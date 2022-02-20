/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

import NF.Patient.Sexe;
import NF.Personnel.Poste;
import java.util.Calendar;
import NF.Service.NomService;
 

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
        Date date = new Date (1998,12,25);
       Calendar rightNow = Calendar.getInstance();
       Patient patient= new Patient("Duches", "Lola", Sexe.FEMME, "5 rue liber", date,"dr truc");
       System.out.println(patient.getIPP());
       System.out.println(patient.getEntreeServie());
   System.out.println(rightNow.getTime());
       System.out.println(patient.toString());
       
     //  Personnel p=new Personnel("ttt","fff","cardiologie",Poste.PHService,"lll","yyy");
  //     System.out.println(p.getNomService());
       
   //     LocalDate current_date = LocalDate.now();
  //          System.out.println("Current date: "+current_date);

            //getting the current year from the current_date
    //        int current_Year = current_date.getYear();
   //         System.out.println("Current year: "+current_Year);
    }
    
}
