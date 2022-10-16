package artie.pedagogicalintervention.generator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Element {
    private String name;
    private String value;
    private String valence;
    private String grade;
}
