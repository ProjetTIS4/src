/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

/**
 *
 * @author lenal
 */
public class Localisation {

    private int etage;
    private int chambre;
    private Service.NomService nom;
    private Lit lit;

    public enum Lit {
        P,
        F
    }

    public Localisation(int etage, int chambre, Service.NomService nom, Lit lit) {

        this.etage = etage;
        this.chambre = chambre;
        this.nom = nom;
        this.lit = lit;
    }

    public int getEtage() {
        return this.etage;
    }

    public int getChambre() {
        return this.chambre;
    }

    public Service.NomService getService() {
        return this.nom;
    }

    public Lit getLit() {
        return this.lit;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public void setChambre(int chambre) {
        this.chambre = chambre;
    }

    public void setService(Service.NomService nom) {
        this.nom = nom;
    }

    public void setLit(Lit lit) {
        this.lit = lit;
    }
}
