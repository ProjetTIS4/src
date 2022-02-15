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

    private Date date;
    private Personnel PHResponsable;
    private Patient patient;
    private String observations;
    private String prescriptions;
    private String operations;
    private String resultats;
    private boolean lettreDeSortie;
    private String correspondance;

    public FichesDM(Patient patient, String observation, String prescriptions, String operations, String resultats, String correspondance) {
        this.patient = patient;
        this.observations = observation;
        this.prescriptions = prescriptions;
        this.operations = operations;
        this.resultats = resultats;
        this.correspondance = correspondance;
        this.lettreDeSortie = false;

    }

    public Personnel getPHResponsable() {
        return PHResponsable;
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

    public Date getDate() {
        return date;
    }
 public void setPHResponsable(Personnel PH) {
       this.PHResponsable=PH;
    }

    public void setPatient(Patient p) {
        this.patient=p;
    }

    public void setObservations(String obs) {
       this.observations=obs;
    }

 
    public void setPrescriptions(String pres) {
        this.prescriptions=pres;
    }

    public void setOperations(String op) {
        this.operations=op;
    }

    public void setResultats(String res) {
        this.resultats=res;
    }

    public void isLettreDeSortie(Boolean b) {
        this.lettreDeSortie=b;
    }

    public void setCorrespondance(String cor) {
       this.correspondance=cor;
    }

    public void setDate(Date d) {
       this.date=d;
    }
}
