//comm
package project;

import java.util.ArrayList;
import java.util.Map;

/**
 * Write a description of class disertatie.Rezolvare here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Solve
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class disertatie.Rezolvare
     */
    public Solve(){
        // initialise instance variables
        //x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y

    public static String[] removeElements(String[] input, String deleteMe) {
    List result = new LinkedList();

    for(String item : input)
    if(!deleteMe.equals(item))
    result.add(item);

    return result.toArray(input);
    }
     */

    public int getSolve(ArrayList first){
        Matrix read = new Matrix ();
        Route mp = new Route();
        String [][] matrix = read.getMatrix();
        Map <String,String[]> route = mp.getRoute(matrix);

        ArrayList last = new ArrayList();
        for(Object a : first){
            //Arrays.toString(Object[] a)
            for( String b :route.get(a) ){
                last.add(b);
            }
        }


        for(Object a : first){
            //Arrays.toString(Object[] a)

            if(last.contains(a)){

                //System.out.println( a + "-------este continut ------" );
                return 0;}

        }


        return 1;

    }
}

