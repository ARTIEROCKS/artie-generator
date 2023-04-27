package artie.pedagogicalintervention.generator.service;
import artie.pedagogicalintervention.generator.enums.PrologResultsEnum;
import org.jpl7.*;

import java.util.List;

public interface QueryService {
    List<String> getSolutions(String filePath, String predicate, String variable, PrologResultsEnum prologResults);
}
