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

        /*System.out.println("__________________________________1__________________________________");

        for (String[] str : matrix) {
            for (String elem : str) {
                System.out.print(elem + "\t");
            }
            System.out.println("");
        }
        int size = 0;
        System.out.println("__________________________________2__________________________________");
        for (String b : routes.keySet()) {
            //Arrays.toString(Object[] a)
            System.out.println("K(" + b + ")= " + Arrays.asList(routes.get(b)));
            size++;
        }

        System.out.println("__________________________________3__________________________________");
        int i = 0;
        //System.out.println(sb);
        String[] set = new String[size];
        for (String b : routes.keySet()) {
            set[i] = b;
            i++;
        }
        Subset m = new Subset();
        m.printSubsets(set);

        System.out.println("__________________________________Final______________________________");*/


    }


}
