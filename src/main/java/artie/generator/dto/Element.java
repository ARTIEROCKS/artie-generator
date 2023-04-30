package artie.generator.dto;

import artie.generator.type.PrologStringList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Element {
    private String name;
    private String value;
    private String valence;
    private String grade;

    /**
     * Function to get the prolog element
     * For example: emotion(happy).
     * @return
     */
    public String getPrologElement(){
        return getPrologElement(null);
    }
    public String getPrologElement(PrologStringList variablesValues){
        return name + "(" + (variablesValues == null ? value : variablesValues.toString()) + ")";
    }

    /**
     * Function to get the prolog valence
     * For example: negative(emotion(sad)).
     * @return
     */
    public String getPrologValence(){
        return getPrologValence(null);
    }
    public String getPrologValence(PrologStringList variablesValues){
        return  valence + "(" + getPrologElement(variablesValues)  + ")";
    }

    /**
     * Function to get the prolog grade
     * For example: high(negative(emotion(angry)))
     * @return
     */
    public String getPrologGrade(){
        return getPrologGrade(null);
    }
    public String getPrologGrade(PrologStringList variablesValues){
        return  grade + "(" + getPrologValence(variablesValues) + ")";
    }


    /**
     * Function to get the higher level of a prolog element
     * Level 1: the element, for example: emotion(happy).
     * Level 2: the valence, for example: negative(emotion(sad)).
     * Level 3: the grade, for example: high(negative(emotion(angry))).
     * @return
     */
    public String getHigherLevel(PrologStringList variablesValues){
        if(this.grade == null){
            if(this.valence == null){
                return this.getPrologElement(variablesValues);
            }else{
                return this.getPrologValence(variablesValues);
            }
        }else{
            return this.getPrologGrade(variablesValues);
        }
    }
}
