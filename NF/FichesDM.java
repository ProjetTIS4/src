/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

/**
 *
 * @author manon
 */
//On ne mettra pas de set dans cette classe car le DM fonctionne en Append-only

public class FichesDM {
    private Patient patient;
    private String observations;
    private String prescriptions;
    private String operations;
    private String resultats;
    private boolean lettreDeSortie;
    private String correspondance;
    
    public FichesDM(Patient patient,String observation, String prescriptions, String operations, String resultats, String correspondance){
        this.patient = patient;
        this.observations = observation;
        this.prescriptions= prescriptions;
        this.operations= operations;
        this.resultats= resultats;
        this.correspondance=correspondance;
        this.lettreDeSortie=false;
        
    }

    public Patient getPatient() {
        return patient;
    }

    public String getObservations() {
        return observations;
    }

    public String getPrescriptions() {
        return prescriptions;
    }

    public String getOperations() {
        return operations;
    }

    public String getResultats() {
        return resultats;
    }

    public boolean isLettreDeSortie() {
        return lettreDeSortie;
    }

    public String getCorrespondance() {
        return correspondance;
    }
    
    
    
    
}
