package artie.pedagogicalintervention.generator.service;

import artie.pedagogicalintervention.generator.dto.Action;
import artie.pedagogicalintervention.generator.dto.bmle.BML;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface GeneratorService {
    public String generateProlog(List<Action>actionList);
    public String generateBMLE(BML bml) throws JsonProcessingException;
}
