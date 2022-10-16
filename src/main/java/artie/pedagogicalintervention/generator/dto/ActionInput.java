package artie.pedagogicalintervention.generator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActionInput {
   private String variableName;
   private List<Element> elements;
}
