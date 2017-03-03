package project;

import java.util.Arrays;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Matrix read = new Matrix();
        Route mp = new Route();
        StringBuilder sb = read.sb();
        String[][] matrix = read.getMatrix();
        Map<String, String[]> route = mp.getRoute(matrix);

        System.out.println("__________________________________1__________________________________");

        for (String[] str : matrix) {
            for (String elem : str) {
                System.out.print(elem + "\t");
            }
            System.out.println("");
        }
        int size = 0;
        System.out.println("__________________________________2__________________________________");
        for (String b : route.keySet()) {
            //Arrays.toString(Object[] a)
            System.out.println("K(" + b + ")= " + Arrays.asList(route.get(b)));
            size++;
        }

        System.out.println("__________________________________3__________________________________");
        int i = 0;
        //System.out.println(sb);
        String[] set = new String[size];
        for (String b : route.keySet()) {
            set[i] = b;
            i++;
        }
        Subset m = new Subset();
        m.printSubsets(set);

        System.out.println("__________________________________Final______________________________");


    }



}
