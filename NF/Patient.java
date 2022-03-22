/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

import java.time.LocalDate;

/**
 *
 * @author lenal
 */
public class Patient extends Personne {

    private String adresse;
    private Date dateNaissance;
    private String IPP;
    private LocalDate entreeService;
    private String medecinGeneraliste;
    private Sexe sexe;
    private static int compteur;
    private String annee;

    public enum Sexe {
        HOMME,
        FEMME
    }

    public Patient(String nom, String prenom, Sexe sexe, String adresse, Date dateNaissance) {
        super(nom, prenom);
        this.adresse = adresse;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.entreeService = LocalDate.now();
        this.medecinGeneraliste = "Inconnu";
        this.annee = "" + entreeService.getYear();
        this.annee = "" + annee.charAt(2) + annee.charAt(3);

        compteur(this.compteur);
    }
    
    public Patient(String nom, String prenom, Sexe sexe, String adresse, Date dateNaissance, int compteur) {
        super(nom, prenom);
        this.adresse = adresse;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.entreeService = LocalDate.now();
        this.medecinGeneraliste = "Inconnu";
        this.annee = "" + entreeService.getYear();
        this.annee = "" + annee.charAt(2) + annee.charAt(3);

        compteur(compteur);
    }

    public Patient(String nom, String prenom, Sexe sexe, String adresse, Date dateNaissance, String medGen) {
        super(nom, prenom);
        this.adresse = adresse;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.entreeService = LocalDate.now();
        this.medecinGeneraliste = medGen;
        this.annee = "" + entreeService.getYear();
        this.annee = "" + annee.charAt(2) + annee.charAt(3);

        compteur(this.compteur);
    }

    public void compteur(int compteur) {

        if (compteur < 10) {
            this.IPP = "" + annee + "000000" + compteur; //Compteur au format YYxxxxxxx (xxxxxx est un compteur)

        } else if (10 <= compteur && compteur < 100) {
            this.IPP = "" + annee + "00000" + compteur; //Compteur au format YYxxxxxxx (xxxxxx est un compteur)
        } else if (100 <= compteur && compteur < 1000) {
            this.IPP = "" + annee + "0000" + compteur; //Compteur au format YYxxxxxxx (xxxxxx est un compteur)
        } else if (1000 <= compteur && compteur < 10000) {
            this.IPP = "" + annee + "000" + compteur; //Compteur au format YYxxxxxxx (xxxxxxxx est un compteur)
        } else if (compteur >= 10000) {
            this.IPP = "" + annee + "00" + compteur; //Compteur au format YYxxxxxxx (xxxxxxxx est un compteur)
        } else if (compteur >= 100000) {
            this.IPP = "" + annee + "0" + compteur; //Compteur au format YYxxxxxxx (xxxxxxxx est un compteur)
        } else if (compteur >= 1000000) {
            this.IPP = "" + annee + "" + compteur; //Compteur au format YYxxxxxxx (xxxxxxxx est un compteur)
        }
        this.compteur++;

    }

    public String toString() {
        return getNom().toUpperCase() + " " + getPrenom().substring(0, 1).toUpperCase() + getPrenom().substring(1).toLowerCase() + " "
                + dateNaissance.getJour() + "/" + (dateNaissance.getMois()) + "/" + dateNaissance.getAnnee();
    }

    public boolean equals(Object o) {
        if (o instanceof Patient) {
            Patient p = (Patient) o;
            return getNom().equals(p.getNom()) && getPrenom().equals(p.getPrenom());
        } else {
            return false;
        }
    }

    public String getAdresse() {
        return adresse;
    }

    public LocalDate getEntreeServie() {
        return entreeService;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public Date getDate() {
        return dateNaissance;
    }

    public String stringDate() {

        if (dateNaissance.getMois() < 10) {
            if (dateNaissance.getJour() < 10) {
                return ("0" + dateNaissance.getJour() + "/0" + dateNaissance.getMois() + "/" + dateNaissance.getAnnee());
            } else {
                return ("" + dateNaissance.getJour() + "/0" + dateNaissance.getMois() + "/" + dateNaissance.getAnnee());
            }
        } else {
            if (dateNaissance.getJour() < 10) {
                return ("0" + dateNaissance.getJour() + "/" + dateNaissance.getMois() + "/" + dateNaissance.getAnnee());
            } else {
                return ("" + dateNaissance.getJour() + "/" + dateNaissance.getMois() + "/" + dateNaissance.getAnnee());
            }
        }

    }

    public String getIPP() {
        return IPP;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMedGen() {
        return medecinGeneraliste;
    }

    public void setMedGen(String medGen) {
        this.medecinGeneraliste = medGen;
    }

    public void setSexe(String sexe) {
        if (sexe.equals("HOMME")) {
            this.sexe = Sexe.HOMME;
        } else if (sexe.equals(("M"))) {
            this.sexe = Sexe.HOMME;
        } else if (sexe.equals(("FEMME"))) {
            this.sexe = Sexe.FEMME;
        } else if (sexe.equals(("F"))) {
            this.sexe = Sexe.FEMME;
        }
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setDateNaissanceString(String date) {

        int jour = Integer.parseInt("" + date.charAt(0) + date.charAt(1));
        int mois = Integer.parseInt("" + date.charAt(3) + date.charAt(4));
        int annee = Integer.parseInt("" + date.charAt(6) + date.charAt(7) + date.charAt(8) + date.charAt(9));

        dateNaissance = new Date(jour, mois, annee);

    }

    public void setIPP(String IPP) {
        this.IPP = IPP;
    }

}
