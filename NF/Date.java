/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

import java.time.LocalDate;

/**
 *
 * @author manon
 */
public class Date {

    private int jour;
    private int mois;
    private int annee;
    private int heure;
    private int minutes;
    private LocalDate dateDuJour;

public Date (LocalDate date){
        this.jour=date.getDayOfMonth();
        this.mois=date.getMonthValue();
        this.annee=date.getYear();
        this.heure=0;
        this.minutes=0;
    }
    public Date(int jour, int mois, int annee, int heure, int minutes) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
        this.heure = heure;
        this.minutes = minutes;
    }


    public Date(int jour, int mois, int annee) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
        this.heure = 0;
        this.minutes = 0;
    }
public Date (String date) {

        int jour = Integer.parseInt("" + date.charAt(0) + date.charAt(1));
        int mois = Integer.parseInt("" + date.charAt(3) + date.charAt(4));
        int annee = Integer.parseInt("" + date.charAt(6) + date.charAt(7) + date.charAt(8) + date.charAt(9));

      this.jour=jour;
      this.mois=mois;
      this.annee=annee;
       this.heure = 0;
        this.minutes = 0;
        
    }

    public String toString() {
        
        if (mois < 10) {
            if (jour < 10) {
                return ("0" + jour + "/0" + mois + "/" + annee);
            } else {
                return ("" + jour + "/0" + mois + "/" + annee);
            }
        } else {
            if (jour < 10) {
                return ("0" + jour + "/" + mois + "/" + annee);
            } else {
                return ("" + jour + "/" + mois + "/" + annee);
            }
        }
         
    }

    public int getAnnee() {
        return this.annee;
    }

    public int getMois() {
        return this.mois;
    }

    public int getJour() {
        return this.jour;
    }

    public int getHeure() {
        return this.heure;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public boolean equals(Object o) {
        if (o instanceof Date) {
            Date d = (Date) o;
            return (annee == d.annee) && (mois == d.mois) && (jour == d.jour) && (heure == d.heure) && (minutes == d.minutes);
        } else {
            return false;
        }
    }


    public String anneeToString() {
        this.dateDuJour= LocalDate.now();
        String annee = "" + dateDuJour.getYear();
        annee = "" + annee.charAt(2) + annee.charAt(3);
        return annee;
    }
    
    


    public String moisToString() {
        String txt = Integer.toString(this.getMois());
        return txt;
    }


    // precondition : 'o' est une instance de 'Date' :
    public int compareTo(Object o) {
        Date d = (Date) o;
        if (annee != d.annee) {
            return annee - d.annee;
        }
        // ici on a forcement annee == d.annee :
        if (mois != d.mois) {
            return mois - d.mois;
        }
        // ici on a forcement annee == d.annee et mois == d.mois :
        if (jour != d.jour) {
            return mois - d.mois;
        }
        //ici on a forcement annee ===d.annee mois == d.mois et jour ==d.jour
        if (heure != d.heure) {
            return heure - d.heure;
        }
        //ici on a forcement annee ===d.annee mois == d.mois  jour ==d.jour et heure == d.heure
        return minutes - d.minutes;
    }
    
        
}
