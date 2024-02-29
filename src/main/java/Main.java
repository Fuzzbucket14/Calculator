/*Calcutor
 * By: Ian Davey
 * Purpose: to calculate stuff
 * Version: 0.2.0
 * Date of last update 2/9/2024
 * Date of start: 1/~26/2024
 */
//Table Tabe = new Table();
//Tabe.RunTable(args);


import java.text.SimpleDateFormat;
import java.io.File;
import java.util.Date;
import java.io.FileWriter;
import java.io.IOException;




public class Main {

    public static void main(String[] args) {

      try{

       //finds date and time for output file
       Date currentdate = new Date();
       SimpleDateFormat formatter = new SimpleDateFormat("_dd_MM_yyyy_HH_mm_ss");
       String datetime = formatter.format(currentdate);
       String date = datetime;
 
       //makes file directory string
       String Output = System.getProperty("user.dir") + "/output";
 
       //makes file directory
       new File(Output).mkdirs();
 
       //adds extra /output for output file
       Output = Output + "/output" ;
 
       //makes output file

       String outputfolder = Output + "Output"+date+".txt";
       File file = new File(outputfolder); 
       FileWriter myWriter = new FileWriter(outputfolder);
 
       //tells user taht we made a new file
       if (file.createNewFile()) {
        System.out.println("created output file:" + Output+date+".txt");
        myWriter.write("created output file:" + Output+date+".txt" + System.getProperty( "line.separator" ));
       }


       //runs Calculator
       Calculator calc = new Calculator();
       calc.RunCalculateor(outputfolder);

      myWriter.close();
      }catch (IOException e) {
         e.printStackTrace();
      }


       
      
   }
}


