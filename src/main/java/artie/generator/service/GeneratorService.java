package artie.generator.service;

import artie.generator.dto.Action;
import artie.generator.dto.bmle.BML;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface GeneratorService {
    public String generateProlog(List<Action>actionList);
    public String generateBMLE(BML bml) throws JsonProcessingException;
}
