/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

import NF.Patient.Sexe;
import java.util.Calendar;


/**
 *
 * @author lenal
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Date date = new Date (20,10,1999);
       Calendar rightNow = Calendar.getInstance();
       Patient patient= new Patient("Duches", "Lola", Sexe.FEMME, "5 rue liber", date,"dr truc");
       System.out.println(patient.getIPP());
       System.out.println(patient.getEntreeServie());
   System.out.println(rightNow.getTime());
       System.out.println(patient.toString());
   //     LocalDate current_date = LocalDate.now();
  //          System.out.println("Current date: "+current_date);

            //getting the current year from the current_date
    //        int current_Year = current_date.getYear();
   //         System.out.println("Current year: "+current_Year);
    }
    
}
