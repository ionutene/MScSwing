//comm
package project;// A Java program to print all subsets of a set
import java.util.*;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
class Subset
{
    // Print all subsets of given set[]

    //private static final String FILENAME = "filename.txt";
    static void printSubsets(String set[])
    {
        Solve r = new Solve();
        BufferedWriter bw = null;
        File file = new File("ParcursuriPosibile.txt");


        //FileWriter fw = null;
        ArrayList primul = new ArrayList();
        int n = set.length;
        int count = 0;
        int countOk = 0;
        String content = "";
        // Run a loop for printing all 2^n
        // subsets one by obe
        for (int i = 0; i < (1<<n); i++)
        {
            System.out.print(count++ +" { ");
            content = "";
            primul.clear();
            // Print current subset
            for (int j = 0; j < n; j++)

                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                if ((i & (1 << j)) > 0) {
                    System.out.print(set[j] + " ");
                    primul.add(set[j]);
                    content += set[j]+" ";
                }



            System.out.println("} = " + r.getSolve(primul) );
            content = "\n"+countOk + ". { " + content.trim() + " } = 1";
            if(r.getSolve(primul) == 1) {
                //System.out.println(" ");
                //System.out.println("Adica " + content);
                //System.out.println(" ");
                try {
                    //String mycontent = "This String would be written" +
                    //" to the specified File";
                    //Specify the file name and path here
                    FileWriter fw = new FileWriter(file, true);
                    bw = new BufferedWriter(fw);
                    /* This logic will make sure that the file
                       * gets created if it is not present at the
                         * specified location*/
                    if (!file.exists()) {
                        file.createNewFile();
                    }




                    bw.write(content);
                    countOk++;
                    bw.append("\r\n");
                    //content = "";
                    System.out.println("Scriere reusita in fisier");

                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
                finally
                {
                    try{
                        if(bw!=null)
                            bw.close();
                    }catch(Exception ex){
                        System.out.println("Am intampinat probleme in scrierea datelor in fisier"+ex);
                    }
                }
            }

        }
    }




    // Driver code


}