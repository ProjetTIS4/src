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

    private Vector<FichesDMA> listefiches;
    private Patient patient;
    private Date debut;
    private Date fin;

    public DMA(Patient patient, Date debut) {

        this.patient = patient;
        this.debut = debut;
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
}
