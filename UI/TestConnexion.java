/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javax.swing.SwingUtilities;

/**
 *
 * @author lenal
 */
public class TestConnexion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      SwingUtilities.invokeLater( new Connexion());
       //  SwingUtilities.invokeLater( new FichePatient(0,0));
       //SwingUtilities.invokeLater( new FichePatientSecretaire("189059940100742",0));
         
    }
    
}
