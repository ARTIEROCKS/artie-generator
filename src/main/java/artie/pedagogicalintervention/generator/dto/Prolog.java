package artie.pedagogicalintervention.generator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prolog {
    private List<String> elements;
    private List<String> valences;
    private List<String> grades;

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
}
