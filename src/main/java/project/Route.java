//comm
package project;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a description of class disertatie.MakeParcursuri here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Route{


    public Map<String,String[]> getRoute(String[][] matrix) {

        int sum;
        int pozition = 0;
        String a = "" ;
        Map <String,String[]> route = new HashMap<String,String[]>();

        for(int i = 1; i<matrix.length; i++){
            a = matrix[0][i];
            sum = 0;
            for(int j = 1 ; j<matrix.length; j++){
                if(!matrix[i][j].equals("0") && !matrix[i][j].equals("1"))
                    sum++;
            }
            pozition = 0;
            String [] individualRoute = new String [sum];
            for(int j = 1 ; j<matrix.length; j++){
                if(!matrix[i][j].equals("0") && !matrix[i][j].equals("1")){
                    individualRoute[pozition] = matrix[0][j];
                    pozition++;
                }
            }
            route.put(a,individualRoute);
            // System.out.println("K("+a+")= "+Arrays.asList(parcursIndividual));
        }

        return route;

    }


}
