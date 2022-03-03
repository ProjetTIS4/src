/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

import java.util.Vector;

/**
 *
 * @author manon
 */
public class FichesDMA {

    private String numeroSejour;
    private int compteur;
    private Date date;
    private Personnel PHResponsable;
    private boolean lettreDeSortie;
    private Vector<String> prestations;

    public FichesDMA(Date date, Personnel ph) {
        this.date = date;
        if (compteur < 10) {
            this.numeroSejour = date.anneeToString() + date.moisToString() + "0000" + compteur; //Compteur au format YYMMxxxxx (xxxx est un compteur)
        }
        if (10 <= compteur && compteur < 100) {
            this.numeroSejour = date.anneeToString() + date.moisToString() + "000" + compteur; //Compteur au format YYMMxxxxx (xxxx est un compteur)
        }
        if (100 <= compteur && compteur < 1000) {
            this.numeroSejour = date.anneeToString() + date.moisToString() + "00" + compteur; //Compteur au format YYMMxxxxx (xxxx est un compteur)
        }
        if (1000 <= compteur && compteur < 10000) {
            this.numeroSejour = date.anneeToString() + date.moisToString() + "0" + compteur; //Compteur au format YYMMxxxxx (xxxx est un compteur)
        }
        if (compteur >= 10000) {
            this.numeroSejour = date.anneeToString() + date.moisToString() + "" + compteur; //Compteur au format YYMMxxxxx (xxxx est un compteur)
        }
        this.PHResponsable = ph;
        this.lettreDeSortie = false;
        this.prestations = new Vector<String>();
        this.compteur++;
    }
    
    public FichesDMA(Date date, Personnel ph, String prescription) {
        this.date = date;
        if (compteur < 10) {
            this.numeroSejour = date.anneeToString() + date.moisToString() + "0000" + compteur; //Compteur au format YYMMxxxxx (xxxx est un compteur)
        }
        if (10 <= compteur && compteur < 100) {
            this.numeroSejour = date.anneeToString() + date.moisToString() + "000" + compteur; //Compteur au format YYMMxxxxx (xxxx est un compteur)
        }
        if (100 <= compteur && compteur < 1000) {
            this.numeroSejour = date.anneeToString() + date.moisToString() + "00" + compteur; //Compteur au format YYMMxxxxx (xxxx est un compteur)
        }
        if (1000 <= compteur && compteur < 10000) {
            this.numeroSejour = date.anneeToString() + date.moisToString() + "0" + compteur; //Compteur au format YYMMxxxxx (xxxx est un compteur)
        }
        if (compteur >= 10000) {
            this.numeroSejour = date.anneeToString() + date.moisToString() + "" + compteur; //Compteur au format YYMMxxxxx (xxxx est un compteur)
        }
        this.PHResponsable = ph;
        this.lettreDeSortie = false;
        this.prestations.add(prescription);
        this.compteur++;
    }

    public String getNumeroSejour() {
        return numeroSejour;
    }

    public int getCompteur() {
        return compteur;
    }

    public Date getDate() {
        return date;
    }

    public Personnel getPHResponsable() {
        return PHResponsable;
    }

    public boolean isLettreDeSortie() {
        return lettreDeSortie;
    }

    public Vector<String> getPrestations() {
        return prestations;
    }
}
