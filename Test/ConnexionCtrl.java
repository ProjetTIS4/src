/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import NF.Personnel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author lenal
 */
public class ConnexionCtrl implements Runnable {

    String utilisateur;
    String mdp;
    Personnel p;
    ConnexionGUI c;

    public ConnexionCtrl() {
        initLookAndFeel(); // Appelle la fonction qui choisit le Look and Feel Nimbus 
        c = new ConnexionGUI();

    }

    public void run() {

        //////////////////////// Fenêtre ////////////////////////
        c.getConnexion().setBounds(450, 190, 700, 460);
        c.getConnexion().setDefaultCloseOperation(EXIT_ON_CLOSE);
        c.getConnexion().setVisible(true);

        //////////////////////// Listener de connexion ////////////////////////
        c.getValider().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
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
                        data[i][4] = service;
                        data[i][5] = poste;
                        i++;
                    }

                    utilisateur = c.getTextUtilisateur().getText();

                    mdp = c.getjPasswordField1().getText();
                    int j = 0;

                    while (utilisateur.equals(data[j][2]) == false && j < data.length - 1) {
                        j++;

                    }
                    if (utilisateur.equals(data[j][2])) {

                        if (mdp.equals(data[j][3])) { //On vérifie que le mot de passe est correct
                            c.getConnexion().setVisible(false);
                            p = new Personnel(data[j][0], data[j][1], data[j][4], data[j][5], data[j][2], data[j][3]);
                            SwingUtilities.invokeLater(new AccueilCtrl(p));

                        } else {

                            c.getErreur().setForeground(Color.red);
                            c.getErreur().setText("Le nom d'utilisateur ou le mot de passe est incorrect ");
                            c.getErreur().setForeground(Color.red);

                            c.getConnexion().revalidate();
                            c.getConnexion().repaint();
                            j = 0;
                        }

                    } else {
                        c.getErreur().setForeground(Color.red);
                        c.getErreur().setText("Le nom d'utilisateur ou le mot de passe est incorrect ");
                        c.getErreur().setForeground(Color.red);

                        c.getConnexion().revalidate();
                        c.getConnexion().repaint();
                        j = 0;
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });

    }

    private static void initLookAndFeel() {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }

    }
}