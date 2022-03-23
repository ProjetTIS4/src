/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

import NF.Patient.Sexe;
import java.time.LocalDate;

/**
 *
 * @author lenal
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LocalDate d = LocalDate.now();
  //      System.out.println(d);
        // TODO code application logic here
        Date date = new Date(23, 02, 2022);
//       Calendar rightNow = Calendar.getInstance();
    Patient patient= new Patient("Duches", "Lola", Sexe.FEMME, "5 rue liber", date,"dr truc");
    Patient patient2= new Patient("Duches", "Lola", Sexe.FEMME, "5 rue liber", date,"dr truc");
//      System.out.println(patient.getIPP());
//      System.out.println(patient2.getIPP());
      int compt=3;
      DMA dma=new DMA(patient,compt);
      DMA dma2=new DMA(patient);
      DMA dma3=new DMA(patient);
      
        System.out.println("1    "+dma.getNumeroSejour());
        System.out.println("2    "+dma2.getNumeroSejour());
        System.out.println("3    "+dma3.getNumeroSejour());
      
//       System.out.println(patient.getEntreeServie());
//   System.out.println(rightNow.getTime());
//
        Personnel p = new Personnel("eee", "eee", "cardio", "PHS", "gbois", "gbois");
//        FichesDMA dma1 = new FichesDMA(date, p);
//        FichesDMA dma2 = new FichesDMA(date, p);
//        System.out.println(dma1.getNumeroSejour());
//        System.out.println(dma2.getNumeroSejour());
      //  int c = dma2.getCompteur();
      //  FichesDMA dma3 = new FichesDMA(date, p, c);
     //   System.out.println(dma3.getNumeroSejour());

        
        
        
        
        //  Personnel p=new Personnel("ttt","fff","cardiologie",Poste.PHService,"lll","yyy");
        //     System.out.println(p.getNomService());
        //     LocalDate current_date = LocalDate.now();
        //          System.out.println("Current date: "+current_date);
        //getting the current year from the current_date
        //        int current_Year = current_date.getYear();
        //         System.out.println("Current year: "+current_Year);
    }

}
