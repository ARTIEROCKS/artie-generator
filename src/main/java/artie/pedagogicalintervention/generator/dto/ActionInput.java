package artie.pedagogicalintervention.generator.dto;

import artie.pedagogicalintervention.generator.type.PrologStringList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActionInput {
   private PrologStringList variablesNames;
   private List<Element> elements;
}
