/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

/**
 *
 * @author lenal
 */
public class Deconnexion implements ActionListener {

    AccueilPH a;

    public Deconnexion(AccueilPH a){
    this.a=a;}
    
    
    @Override
    public void actionPerformed(ActionEvent e) {

        a.accueil.setVisible(false);
        SwingUtilities.invokeLater(new Connexion());

    }
    
   
}
