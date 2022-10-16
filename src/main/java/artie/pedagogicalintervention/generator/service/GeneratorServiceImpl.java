package artie.pedagogicalintervention.generator.service;

import artie.pedagogicalintervention.generator.dto.Action;
import artie.pedagogicalintervention.generator.dto.ActionInput;
import artie.pedagogicalintervention.generator.dto.Prolog;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GeneratorServiceImpl implements GeneratorService{

    @Autowired
    private Prolog prolog;

    @Override
    public String generate(List<Action> actionList) {

        actionList.stream().forEach(a ->{
            
            //Getting all the action inputs to generate the basic elements
            a.getActionInputs().stream().forEach(ai ->{

                //1- Generate the elements, valences and grades
                generateBasicElements(ai);
            });
        });

        return null;
    }

    /**
     * Function to generate the basic elements, valences and grades
     * @param action
     * @return
     */
    private void generateBasicElements(ActionInput action){

        //Generating the basic elements, valences and grades
        action.getElements().stream().forEach(e->{
            this.prolog.addElement(e.getPrologElement());
            this.prolog.addGrade(e.getPrologGrade());
            this.prolog.addValence(e.getValence());
        });
    }
}
