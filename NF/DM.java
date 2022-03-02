/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

import java.util.Vector;

/**
 *
 * @author lenal
 */
public class DM {

    private Patient patient;
    private Vector<FichesDM> listefiches;
    private Date debut;
    private Date fin;

    public DM(Patient patient, Date debut) {
        this.patient = patient;
        this.debut = debut;
        this.fin = null;
    }

    //On ne mettra pas de set dans cette classe car le DM fonctionne en Append-only
    public Patient getPatient() {
        return patient;
    }

    public void addFiche(String observation, String prescriptions, String operations, String resultats) {
        listefiches.add(new FichesDM(patient, observation, prescriptions, operations, resultats));
    }

}
