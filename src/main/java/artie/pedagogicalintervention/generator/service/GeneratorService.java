package artie.pedagogicalintervention.generator.service;

import artie.pedagogicalintervention.generator.dto.Action;

import java.util.List;

public interface GeneratorService {
    public String Generate(List<Action>actionList);
}
