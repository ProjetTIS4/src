/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenal
 */
public class ActeCtrl implements Runnable {

    ActeGUI a;
    String ipp;
    AccueilGUI ac;

    public ActeCtrl(String ipp, AccueilGUI ac) {
        a = new ActeGUI();
        this.ipp = ipp;
        this.ac=ac;

    }

    @Override
    public void run() {
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

        //////////////////////// Fenêtre ////////////////////////
        // a.getAjouterActe().setBounds(450, 190, 700, 460);
        a.getAjouterActe().setVisible(true);
        a.getAjouterActe().setSize(500, 700);

        //////////////////////// Panel Date ////////////////////////
        a.getJour().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                a.getJour().setText("");
                a.getJour().setForeground(Color.black);
            }
        });

        a.getJour().addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                if (a.getJour().getText().length() >= 2) // limit to 3 characters
                {
                    e.consume();
                }
            }
        });

        a.getMois().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                a.getMois().setText("");
                a.getMois().setForeground(Color.black);
            }
        });

        a.getMois().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (a.getMois().getText().length() >= 2) // limit to 3 characters
                {
                    e.consume();
                }
            }
        });

        a.getAnnee().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                a.getAnnee().setText("");
                a.getAnnee().setForeground(Color.black);
            }
        });

        a.getAnnee().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (a.getAnnee().getText().length() >= 4) // limit to 3 characters
                {
                    e.consume();
                }
            }
        });

        //////////////////////// Panel heure ////////////////////////
        a.getHeure().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                a.getHeure().setText("");
            }
        });

        a.getHeure().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (a.getHeure().getText().length() >= 2) // limit to 3 characters
                {
                    e.consume();
                }
            }
        });

        a.getMinute().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                a.getMinute().setText("");

            }
        });

        a.getMinute().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (a.getMinute().getText().length() >= 2) // limit to 3 characters
                {
                    e.consume();
                }
            }
        });

        //////////////////////// Bouton valider  ////////////////////////
        a.getValider().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                try {

                    String url = "jdbc:mysql://hugofarcy.ddns.net:3306/SIH?autoReconnect=true&useSSL=false";
                    String user = "DEV";
                    String password = "SIH-mmlh2022";

                    Connection con = DriverManager.getConnection(url, user, password);

                    String requete = "INSERT INTO fichesDM (IPPatient,numFiche,observations,prescriptions,operations,resultats,correspondance,lettreDeSortie) VALUES ('" + ipp
                            + "','"+a.getJour().getText()+a.getMois().getText()+"2','"
                            + a.getObservations2().getText()
                            + "','"
                            + a.getPrestations2().getText()
                            + "','"
                            + a.getOperations2().getText()
                            + "','"
                            + a.getResultat2().getText()
                            + "','','')";

                    System.out.println(requete);
                    Statement stm = con.createStatement();
                    stm.executeUpdate(requete);
                    
                    a.getAjouterActe().dispose();
                
                  
                            String query = "SELECT COUNT(*) FROM fichesDM WHERE IPPatient=" + ipp;
                            ResultSet res = stm.executeQuery(query);

                            int taille = 0;

                            if (res.next()) {
                                taille = res.getInt("COUNT(*)");
                            }

                            String dataDM[][] = new String[taille][8];
                            String columns[] = {"Date", "CR", "lettre sortie"};
//            res2.close();

                            query = "SELECT * FROM fichesDM WHERE IPPatient=" + ipp;
                            res = stm.executeQuery(query);
                            int i = 0;
                            while (res.next()) {

                                String resul = res.getString("resultats");

                                String lettre = res.getString("lettreDeSortie");
                                String num = res.getString("numFiche");

                                dataDM[i][0] = num;
                                if (resul != "") {
                                    dataDM[i][1] = "true";
                                } else {
                                    dataDM[i][1] = "VIDE";
                                }
                                if (lettre != "") {
                                    dataDM[i][2] = "true";
                                } else {
                                    dataDM[i][2] = "VIDE";
                                }

                                i++;
                            }

                           
                            ac.getTableauDM().setModel(new DefaultTableModel(dataDM, columns));
                            ac.getAccueil().validate();
                          ac.getAccueil().repaint();
                    

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
//finally {
//                    try {
//                        con.close();
//                        stm.close();
//                    } catch (Exception e) {
//                    }
//
                //             }
            }
        });

    }

}