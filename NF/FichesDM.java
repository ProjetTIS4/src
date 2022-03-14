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
//On ne mettra pas de set qui modifie les informations dans cette l'application car le DM fonctionne en Append-only
public class FichesDM {

    private Date date;
    private Personnel PHResponsable;
    private Patient patient;
    private String observations;
    private String prescriptions;
    private String operations;
    private String resultats;
    private String lettreDeSortie;


    public FichesDM(Patient patient, String observation, String prescriptions, String operations, String resultats, String lettre) {
        this.patient = patient;
        this.observations = observation;
        this.prescriptions = prescriptions;
        this.operations = operations;
        this.resultats = resultats;
        this.lettreDeSortie = lettre;

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

    public String getLettreDeSortie() {
        return lettreDeSortie;
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

    public void setLettreDeSortie(String lettre) {
        this.lettreDeSortie=lettre;
    }



    public void setDate(Date d) {
       this.date=d;
    }

}
