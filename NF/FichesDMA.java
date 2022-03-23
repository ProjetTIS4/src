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

  
    private Personnel PHResponsable;
    private boolean lettreDeSortie;
    private Vector<String> prestations;

    public FichesDMA(Personnel ph) {
        this.PHResponsable = ph;
        this.lettreDeSortie = false;
        this.prestations = new Vector<String>();    


    }
  

    public FichesDMA( Personnel ph, String prescription) {
        this.PHResponsable = ph;
        this.lettreDeSortie = false;
        this.prestations.add(prescription);
        
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
