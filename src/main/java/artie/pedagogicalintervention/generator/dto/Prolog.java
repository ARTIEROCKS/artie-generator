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
        this.elements.add(element);
    }
    public void addValence(String valence){
        this.elements.add(valence);
    }
    public void addGrade(String grade){
        this.elements.add(grade);
    }
}
