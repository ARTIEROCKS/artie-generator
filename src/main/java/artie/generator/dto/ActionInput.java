package artie.generator.dto;

import artie.generator.type.PrologStringList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ActionInput {
   private PrologStringList variablesNames;
   private List<Element> elements;
}
