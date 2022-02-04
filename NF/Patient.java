/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

import java.util.Date;
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

        String annee = "" + entreeService.getYear();
        annee = "" + annee.charAt(2) + annee.charAt(3);
        this.IPP = "" + annee + "XXXXX";  //Il faudrait mettre un compteur ici pour les 7 caractères restants pour que tout les IPP soient différents. 
    }

    public Patient(String nom, String prenom, Sexe sexe, String adresse, Date dateNaissance, String medGen) {
        super(nom, prenom);
        this.adresse = adresse;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.entreeService = LocalDate.now();
        this.medecinGeneraliste = medGen;

        String annee = "" + entreeService.getYear();
        annee = "" + annee.charAt(2) + annee.charAt(3);
        this.IPP = "" + annee + "XXXXX";  //Il faudrait mettre un compteur ici pour les 7 caractères restants pour que tout les IPP soient différents. 
    }

    public String toString() {
        return getNom().toUpperCase() + " " + getPrenom().substring(0, 1).toUpperCase() + getPrenom().substring(1).toLowerCase() + " " + 
                dateNaissance.getDate()+"/"+(dateNaissance.getMonth()-1)+"/"+dateNaissance.getYear();
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
        } else if (sexe.equals(("FEMME"))) {
            this.sexe = Sexe.FEMME;
        }
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

}
