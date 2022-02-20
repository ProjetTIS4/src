/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import NF.Service.NomService;
import NF.Personnel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

        // On récupère les données dans la BDD
        try {
            String url = "jdbc:mysql://hugofarcy.ddns.net:3306/SIH?autoReconnect=true&useSSL=false";
            String user = "DEV";
            String password = "SIH-mmlh2022";

            Connection con = DriverManager.getConnection(url, user, password);

           String query = "SELECT COUNT(*) FROM PHS";
            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);

            int taille = 0;

            if (res.next()) {
                taille = res.getInt("COUNT(*)");
            }

            String data[][] = new String[taille][6];
            
             query = "SELECT * FROM PHS";
            res = stm.executeQuery(query);

            int i = 0;
            while (res.next()) {
                String id = res.getString("nom");
                String nom = res.getString("prenom");
                String age = res.getString("ID");
                String mdp = res.getString("mdp");
                String service = res.getString("service");
                String poste = res.getString("poste");
                data[i][0] = id + "";
                data[i][1] = nom;
                data[i][2] = age;
                data[i][3] = mdp;
                data[i][4]=service;
                data[i][5]=poste;
                i++;
            }

            utilisateur = c.textUtilisateur.getText();
            System.out.println(utilisateur);
            mdp = c.jPasswordField1.getText();
            int j = 0;
            if (e.getSource() == c.Valider ) {
                while (utilisateur.equals(data[j][2]) == false && j < data.length - 1) {

                    System.out.println(data[j][4].toUpperCase());
                    j++;

                    // p = Le personnel dont l'utilisateur rentré est le sien
                }
                if (utilisateur.equals(data[j][2])) {
                    if (mdp.equals(data[j][3])) { //On vérifie que le mot de passe est correct
                        c.connexion.setVisible(false);
                        p= new Personnel(data[j][0], data[j][1], data[j][4], data[j][5], data[j][2], data[j][3]);
                        SwingUtilities.invokeLater(new AccueilPH(p));

                    } else {
                        // c.box.setVisible(true);
                        //c.box2.setVisible(true);
                        // c.erreur.setForeground(Color.RED);
                        c.erreur.setText("Le nom d'utilisateur ou le mot de passe est incorrect ");
                        c.erreur.setForeground(Color.red);
                        
//  c.erreur.setVisible(true);
                        c.connexion.revalidate();
                        c.connexion.repaint();
                        j = 0;
                    }

                } else {
                    c.erreur.setText("Le nom d'utilisateur ou le mot de passe est incorrect ");
                        c.erreur.setForeground(Color.red);
                        
//  c.erreur.setVisible(true);
                        c.connexion.revalidate();
                        c.connexion.repaint();
                        j = 0;
                }
            }

//        c.connexion.setVisible(false);
//        AccueilPH a= new AccueilPH();
//        SwingUtilities.invokeLater(a);
            System.out.println(data[0][0]);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    
    

}
