/*Calcutor
 * By: Ian Davey
 * Purpose: to calculate stuff
 * Version: 0.1.2
 * Date of last update 2/9/2024
 * Date of start: 1/~26/2024
 */



import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.io.File;
import java.util.Date;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

    try{

      Date currentdate = new Date();
      SimpleDateFormat formatter = new SimpleDateFormat("_dd_MM_yyyy_HH_mm_ss");
      String datetime = formatter.format(currentdate);
      String date = datetime;


      File file = new File("Output"+date+".txt"); 
      FileWriter myWriter = new FileWriter("Output"+date+".txt");

      
      if (file.createNewFile()) {
       System.out.println("created output file: Output"+date+".txt");
       myWriter.write("created output file: Output.txt /n" + System.getProperty( "line.separator" ));
      }


      Scanner myObj = new Scanner(System.in); 
      boolean stay = true ;

      while (stay == true) {


         try {
            double Num1 = 0 ;
            String op = "0" ;
            double Num2 = 0 ;

            System.out.println("enter equation"); //getting input'
            myWriter.write("enter equation" + System.getProperty( "line.separator" ));
            Num1 = myObj.nextDouble();
            op = myObj.next();
            Num2 = myObj.nextDouble(); 

             myWriter.write(Num1 + " " + op + " " + Num2 + System.getProperty( "line.separator" ));
            double result = 1 ;           

            if (op.contains("+")) {
              
              result = Num1 + Num2 ;

            } else if(op.contains("-")) {
              
              result = Num1 - Num2 ;

            } else if(op.contains("/")) {
              
              result = Num1 / Num2 ;
               
            } else if(op.contains("*")) {
              
               result = Num1 * Num2 ;

            } else if(op.contains("^")) {

               double power = Num2 ;
               result = 1 ;
               while (power !=0) {
                  result = result * Num1 ;
                  power --;
               }

               
            } else if(op.toUpperCase().contains("SQUAREROOT")) {
              
              result = Math.sqrt(Num1);

            }

           System.out.println("= " + result);
           myWriter.write("= " + result + System.getProperty( "line.separator" ));



         }
         catch(Exception E) {
            System.out.println("Make sure equation is entered correctly!");
            JOptionPane.showMessageDialog(null,"Make sure equation is entered correctly!");  
            myWriter.write("Make sure equation is entered correctly!");
         }finally {

            System.out.println("Exit? Y/N") ;
           
            myWriter.write("Exit? Y/N" + System.getProperty( "line.separator" ));
           
            myObj.nextLine();

            String Exit = myObj.next();

            myWriter.write(Exit + System.getProperty( "line.separator" ));

            if (Exit.equalsIgnoreCase("Y")) {
               stay = false; 


            }else if (Exit.equalsIgnoreCase("N")) {
               myObj.nextLine();
            }else {
               System.out.println("Please enter Y or N");
               myWriter.write("Please enter Y or N" + System.getProperty( "line.separator" ));
            }

         }


      }
      myObj.close() ;  
      myWriter.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
          e.printStackTrace();
      }
   }
}


