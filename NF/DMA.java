/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

import java.util.Calendar;

import java.util.Vector;

/**
 *
 * @author lenal
 */
public class DMA {

     private String numeroSejour;
     private static int compteur;
    private Vector<FichesDMA> listefiches;
    private Patient patient;
    private Date debut;
    private Date fin;

    public DMA(Patient patient,int compteur) {

        this.patient = patient;
        compteur(compteur);
        this.debut = 
        this.fin = null;
    }

    public Vector<FichesDMA> getListefiches() {
        return listefiches;
    }

    public Patient getPatient() {
        return patient;
    }

    public void addFiche(Date date, Personnel ph) {
        listefiches.add(new FichesDMA(date, ph));
    }
    
    public void compteur(int compteur) {
        
        if (compteur < 10) {
            this.numeroSejour = debut.anneeToString() + debut.moisToString() + "0000" + compteur; //Compteur au format YYMMxxxxx (xxxx est un compteur)

        }
        if (10 <= compteur && compteur < 100) {
            this.numeroSejour = debut.anneeToString() + debut.moisToString() + "000" + compteur; //Compteur au format YYMMxxxxx (xxxx est un compteur)
        }
        if (100 <= compteur && compteur < 1000) {
            this.numeroSejour = debut.anneeToString() + date.moisToString() + "00" + compteur; //Compteur au format YYMMxxxxx (xxxx est un compteur)
        }
        if (1000 <= compteur && compteur < 10000) {
            this.numeroSejour = date.anneeToString() + date.moisToString() + "0" + compteur; //Compteur au format YYMMxxxxx (xxxx est un compteur)
        }
        if (compteur >= 10000) {
            this.numeroSejour = date.anneeToString() + date.moisToString() + "" + compteur; //Compteur au format YYMMxxxxx (xxxx est un compteur)
        }
        this.compteur++;

    }
}
