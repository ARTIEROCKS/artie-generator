package artie.generator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Action {
    private String name;
    private List<ActionInput> actionInputs;

    /**
     * Function to get the prolog function
     * For example: eyeSelection(X, Y) :- high(positive(emotion(X))), high(positive(eyes(Y))).
     * @return
     */
    public String getPrologFunction(){

        //1- Getting the first part of the function: toneOfVoiceSelection(X, Y)
        String variableDefinition = name + "(" + getVariableList() + ")";

        //2- Getting the second part of the function: high(positive(emotion(X))), high(positive(eyes(Y))).
        String functionDefinition = this.getFunctionDefinition();

        return  variableDefinition + " :- " + functionDefinition + ".";
    }

    /**
     * Function to get the variable list in string format
     * For example: X, Y
     * @return
     */
    public String getVariableList(){

        List<String> variables = new ArrayList<>();
        AtomicReference<String> variableList = new AtomicReference<>("");

        //Getting the unique names of the variables
        actionInputs.stream().forEach(ai -> {
           ai.getVariablesNames().getList().forEach(vn ->{
               if(!variables.contains(vn)){
                   variables.add(vn);
               }
           });
        });

        //Listing the unique variable names in the string
        variables.forEach(v -> {
            variableList.set(variableList.toString() + v + ", ");
        });

        return variableList.toString().substring(0, variableList.toString().length() - 2);
    }

    /**
     * Function to get the prolog function definition (after :-)
     * For example: high(positive(emotion(X))), high(positive(eyes(Y))).
     * @return
     */
    public String getFunctionDefinition(){

        AtomicReference<String> functionList = new AtomicReference<>("");
        actionInputs.stream().forEach(ai->{
            ai.getElements().stream().forEach(e ->{
                functionList.set(functionList.toString() + e.getHigherLevel(ai.getVariablesNames()) + ", ");
            });
        });

        return functionList.toString().substring(0, functionList.toString().length() - 2);
    }
}
