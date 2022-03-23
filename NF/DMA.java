/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

import java.time.LocalDate;
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
    private LocalDate date;
    private Date debut;
    private Date fin;



    public DMA(Patient patient, int compteur) {

        this.patient = patient;
        this.date = LocalDate.now();
        this.debut= new Date(date);

        this.fin = null;
        this.compteur=compteur;
        compteur(compteur);
    }
    public DMA(Patient patient) {

        this.patient = patient;
        this.date = LocalDate.now();
        this.debut= new Date(date);
        this.fin = null;
        if (compteur < 10) {
            this.numeroSejour = this.debut.anneeToString() + this.debut.moisToString() + "0000" + compteur; //Compteur au format YYMMxxxxx (xxxx est un compteur)
        }
        else if (10 <= compteur && compteur < 100) {
            this.numeroSejour = this.debut.anneeToString() + this.debut.moisToString() + "000" + compteur; //Compteur au format YYMMxxxxx (xxxx est un compteur)
        }
        else if (100 <= compteur && compteur < 1000) {
            this.numeroSejour = this.debut.anneeToString() + this.debut.moisToString() + "00" + compteur; //Compteur au format YYMMxxxxx (xxxx est un compteur)
        }
        else if (1000 <= compteur && compteur < 10000) {
            this.numeroSejour = this.debut.anneeToString() + this.debut.moisToString() + "0" + compteur; //Compteur au format YYMMxxxxx (xxxx est un compteur)
        }
        else {
            this.numeroSejour = this.debut.anneeToString() + this.debut.moisToString() + "" + compteur; //Compteur au format YYMMxxxxx (xxxx est un compteur)
        }
        this.compteur++;
    }

    public void compteur(int compteur) {
        
        if (compteur < 10) {
            this.numeroSejour = this.debut.anneeToString() + this.debut.moisToString() + "0000" + compteur; //Compteur au format YYMMxxxxx (xxxx est un compteur)
        }
        else if (10 <= compteur && compteur < 100) {
            this.numeroSejour = this.debut.anneeToString() + this.debut.moisToString() + "000" + compteur; //Compteur au format YYMMxxxxx (xxxx est un compteur)
        }
        else if (100 <= compteur && compteur < 1000) {
            this.numeroSejour = this.debut.anneeToString() + this.debut.moisToString() + "00" + compteur; //Compteur au format YYMMxxxxx (xxxx est un compteur)
        }
        else if (1000 <= compteur && compteur < 10000) {
            this.numeroSejour = this.debut.anneeToString() + this.debut.moisToString() + "0" + compteur; //Compteur au format YYMMxxxxx (xxxx est un compteur)
        }
        else {
            this.numeroSejour = this.debut.anneeToString() + this.debut.moisToString() + "" + compteur; //Compteur au format YYMMxxxxx (xxxx est un compteur)
        }
        this.compteur++;

    }
    
    public Vector<FichesDMA> getListefiches() {
        return listefiches;
    }

    public Patient getPatient() {
        return patient;
    }

    public void addFiche( Personnel ph) {
        listefiches.add(new FichesDMA( ph));
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public String getNumeroSejour() {
        return numeroSejour;
    }

    public void setNumeroSejour(String numeroSejour) {
        this.numeroSejour = numeroSejour;
    }

    public static int getCompteur() {
        return DMA.compteur;
    }

    public static void setCompteur(int compteur) {
        DMA.compteur = compteur;
    }
    
    

}
