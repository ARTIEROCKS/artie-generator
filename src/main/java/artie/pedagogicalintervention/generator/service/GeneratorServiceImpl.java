package artie.pedagogicalintervention.generator.service;

import artie.pedagogicalintervention.generator.dto.Action;
import artie.pedagogicalintervention.generator.dto.ActionInput;
import artie.pedagogicalintervention.generator.dto.Prolog;
import artie.pedagogicalintervention.generator.dto.bmle.BML;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneratorServiceImpl implements GeneratorService{

    @Autowired
    private Prolog prolog;

    /**
     * Function to generate the prolog file
     * @param actionList
     * @return the prolog program in string format
     */
    @Override
    public String generateProlog(List<Action> actionList) {

        actionList.stream().forEach(a ->{

            //Getting all the action inputs to generate the basic elements
            a.getActionInputs().stream().forEach(ai ->{
                //1- Generate the elements, valences and grades
                generateBasicElements(ai);
            });

            //2- Generate the functions
            this.prolog.addFunction(a.getPrologFunction());
        });

        //Returning the prolog program in string format
        return this.prolog.toString();
    }

    /**
     * Function to generate the basic elements, valences and grades
     * @param action
     * @return
     */
    private void generateBasicElements(ActionInput action){

        //Generating the basic elements, valences and grades
        action.getElements().stream().forEach(e->{
            this.prolog.addElement(e.getPrologElement() + ".");
            this.prolog.addGrade(e.getPrologGrade() + ".");
            this.prolog.addValence(e.getPrologValence() + ".");
        });
    }

    @Override
    public String generateBMLE(BML bml) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.writeValueAsString(bml);
    }
}
