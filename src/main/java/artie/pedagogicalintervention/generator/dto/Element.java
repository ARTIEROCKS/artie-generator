package artie.pedagogicalintervention.generator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    public String getPrologElement(String variableValue){
        return name + "(" + (variableValue == null ? value : variableValue) + ")";
    }

    /**
     * Function to get the prolog valence
     * For example: negative(emotion(sad)).
     * @return
     */
    public String getPrologValence(){
        return getPrologValence(null);
    }
    public String getPrologValence(String variableValue){
        return  valence + "(" + getPrologElement(variableValue)  + ")";
    }

    /**
     * Function to get the prolog grade
     * For example: high(negative(emotion(angry)))
     * @return
     */
    public String getPrologGrade(){
        return getPrologGrade(null);
    }
    public String getPrologGrade(String variableValue){
        return  grade + "(" + getPrologValence(variableValue) + ")";
    }


    /**
     * Function to get the higher level of a prolog element
     * Level 1: the element, for example: emotion(happy).
     * Level 2: the valence, for example: negative(emotion(sad)).
     * Level 3: the grade, for example: high(negative(emotion(angry))).
     * @return
     */
    public String getHigherLevel(String variableValue){
        if(this.grade == null){
            if(this.valence == null){
                return this.getPrologElement(variableValue);
            }else{
                return this.getPrologValence(variableValue);
            }
        }else{
            return this.getPrologGrade(variableValue);
        }
    }
}
