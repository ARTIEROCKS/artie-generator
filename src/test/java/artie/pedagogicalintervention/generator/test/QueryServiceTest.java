package artie.pedagogicalintervention.generator.test;

import artie.pedagogicalintervention.generator.enums.PrologResultsEnum;
import artie.pedagogicalintervention.generator.service.QueryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryServiceTest {
    @Autowired
    private QueryService queryService;

    @Test
    public void testGetSolutions() {
        // Set up test arguments
        String filePath = "src/main/resources/test.pl";
        String predicate = "eyeSelection(sad, X)";
        String variable = "X";
        PrologResultsEnum prologResults = PrologResultsEnum.MULTIPLE;

        // Call getSolutions method
        List<String> result = queryService.getSolutions(filePath, predicate, variable, prologResults);

        // Verify results
        assertEquals(1, result.size());
        assertEquals("yellow", result.get(0));
    }
}