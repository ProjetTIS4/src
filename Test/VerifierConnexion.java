/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import NF.Personnel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

/**
 *
 * @author lenal
 */
public class VerifierConnexion implements ActionListener {

    String utilisateur;
    String mdp;
    Personnel p;
    Connexion c;

    public VerifierConnexion(Connexion c) {

        this.c = c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == c.Valider) {
//            while (utilisateur.equals(p.getLogin())) {
//                // p = Le personnel dont l'utilisateur rentré est le sien
//
//            }
//
//            if (mdp.equals(p.getMdp())) { //On vérifie que le mot de passe est correct
//                c.connexion.setVisible(false);
//                SwingUtilities.invokeLater(new AccueilPH());
//
//            }
//
//        }
        c.connexion.setVisible(false);
        AccueilPH a= new AccueilPH();
        SwingUtilities.invokeLater(a);
        
    }

}
