package artie.pedagogicalintervention.generator.service;

import artie.pedagogicalintervention.generator.enums.PrologResultsEnum;
import org.jpl7.JPL;
import org.jpl7.Query;
import org.jpl7.Term;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueryServiceImpl implements QueryService{

    @Override
    public List<String> getSolutions(String filePath, String predicate, String variable, PrologResultsEnum prologResults) {

        List<String> result = new ArrayList<>();

        String[] param = {"-q"};
        JPL.init(param);

        //Starts the query
        Query consultQuery = new Query("consult('"+filePath+"').");
        Query query = new Query(predicate);

        //Looks if the request has solution or not
        if (query.hasSolution()) {
            //If we want a single solution or multiple
            if (prologResults.equals(PrologResultsEnum.SINGLE)) {
                Term solution = query.oneSolution().get(variable);
                result.add(solution.toString());
            }else {
                while (query.hasMoreSolutions()) {
                    Term solution = query.nextSolution().get(variable);
                    System.out.println(solution);
                }
            }
        }

        return result;
    }
}
