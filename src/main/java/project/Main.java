package project;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        try {
            Map<String, Set<String>> formulas = CSVParser.readCSV();
//            System.out.println(formulas);
            Combinations combinations = new Combinations(formulas.keySet());
            combinations.doAllNonRepetitiveCombinationsBetweenIndices(2, 2);
            RouteVerification routeVerification = new RouteVerification(combinations.getFinalElements(), formulas);
            routeVerification.doRouteVerifications();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
