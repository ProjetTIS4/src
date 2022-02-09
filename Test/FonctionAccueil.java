/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import NF.Patient;
import NF.Patient.Sexe;
import java.awt.BorderLayout;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenal
 */
public class FonctionAccueil {
    public Vector<Patient> patients;
    
     public FonctionAccueil() {
        

    }
    
    private Vector<String> recupererNomPatient(Vector<Patient> pVect) {
        Vector<String> vect = new Vector<>();
        for (int i = 0; i < pVect.size(); i++) {
            System.out.println(pVect.get(i).getNom());
            vect.add(pVect.get(i).getNom());
        }
        System.out.println(vect);
        return vect;
    }

    private Vector<String> recupererPrenomPatient(Vector<Patient> pVect) {
        Vector<String> vect = new Vector<>();
        for (int i = 0; i < pVect.size(); i++) {
            vect.add(pVect.get(i).getPrenom());
        }
        return vect;
    }

    private Vector<Sexe> recupererSexePatient(Vector<Patient> pVect) {
        Vector<Sexe> vect = new Vector<>();
        for (int i = 0; i < pVect.size(); i++) {
            vect.add(pVect.get(i).getSexe());
        }
        return vect;
    }

    private Vector<String> recupererAdressePatient(Vector<Patient> pVect) {
        Vector<String> vect = new Vector<>();
        for (int i = 0; i < pVect.size(); i++) {
            vect.add(pVect.get(i).getAdresse());
        }
        return vect;
    }

    private Vector<Date> recupererDateNPatient(Vector<Patient> pVect) {
        Vector<Date> vect = new Vector<>();
        for (int i = 0; i < pVect.size(); i++) {
            vect.add(pVect.get(i).getDate());
        }
        return vect;
    }

    private Vector<String> recupererIPP(Vector<Patient> pVect) {
        Vector<String> vect = new Vector<>();
        for (int i = 0; i < pVect.size(); i++) {
            vect.add(pVect.get(i).getIPP());
        }
        return vect;
    }

    
        public void remplirTableau(DefaultTableModel m, Vector<Patient> pVect) {
        System.out.println("remplir");
        m.addColumn("Nom", recupererNomPatient(pVect));
        m.addColumn("Prenom", recupererPrenomPatient(pVect));
        m.addColumn("Sexe", recupererSexePatient(pVect));
        m.addColumn("Adresse", recupererAdressePatient(pVect));
        m.addColumn("Date de naissance", recupererDateNPatient(pVect));
        m.addColumn("Numéro SS", recupererIPP(pVect));

       // revalidate();

    }
    
}
