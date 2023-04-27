package artie.pedagogicalintervention.generator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Prolog {
    private List<String> elements;
    private List<String> valences;
    private List<String> grades;

    private List<String> functions;

    public void addElement(String element){
        //Avoiding duplicate elements in the list
        if(!this.elements.contains(element)) {
            this.elements.add(element);
        }
    }
    public void addValence(String valence){
        //Avoiding duplicate valences in the list
        if(!this.valences.contains(valence)) {
            this.valences.add(valence);
        }
    }
    public void addGrade(String grade){
        //Avoiding duplicate grades in the list
        if(!this.grades.contains(grade)) {
            this.grades.add(grade);
        }
    }

    public void addFunction(String function){
        //Avoiding duplicate functions in the list
        if(!this.functions.contains(function)) {
            this.functions.add(function);
        }
    }

    /**
     * Function to transform this object into a prolog program
     * @return
     */
    public String toString(){
        AtomicReference<String> program = new AtomicReference<>("");

        //1- Element list
        this.elements.stream().forEach(e -> {
            program.set(program.toString() + e + "\n");
        });

        //2- Valence list
        this.valences.stream().forEach(v -> {
            program.set(program.toString() + v + "\n");
        });

        //3- Grade list
        this.grades.stream().forEach(g -> {
            program.set(program.toString() + g + "\n");
        });

        //4- Function list
        this.functions.stream().forEach(p->{
            program.set(program.toString() + p + "\n");
        });

        return program.toString();
    }
}
