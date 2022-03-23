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
public class AjoutDMACtrl implements Runnable {

    AjoutDMAGUI a;
    String ipp;
    AccueilGUI ac;

    public AjoutDMACtrl(String ipp, AccueilGUI ac) {
        a = new AjoutDMAGUI();
        this.ipp = ipp;
        this.ac = ac;
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
        a.getAjouterDMA().setVisible(true);
        a.getAjouterDMA().setSize(500, 700);

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

                    String requete = "INSERT INTO DMA (IPPatient,numeroSejour,dateEntree,dateSortie) VALUES ('" 
                            + ipp
                            + "','" 
                            + "compteur" 
                            + "','" 
                            + a.getAnnee().getText() + a.getMois().getText() + a.getJour().getText() + a.getHeure().getText() + a.getMinute().getText() 
                            + "','"
                            + "test"
                            + "','"
                            + (a.getNom2().getText());

                    //   StringEscapeUtils.escapeJava
                    System.out.println(requete);
                    Statement stm = con.createStatement();
                    stm.executeUpdate(requete);

                    a.getAjouterDMA().dispose();

                    String query = "SELECT COUNT(*) FROM fichesDMA WHERE IPPatient=" + ipp;
                    ResultSet res = stm.executeQuery(query);

                    int taille = 0;

                    if (res.next()) {
                        taille = res.getInt("COUNT(*)");
                    }

                    String dataDMA[][] = new String[taille][8];
                    String columns[] = {"Date d'entrée", "Date de sortie"};
//            res2.close();

                    query = "SELECT * FROM fichesDMA WHERE IPPatient=" + ipp;
                    res = stm.executeQuery(query);
                    int i = 0;
                    while (res.next()) {

                        String dated = res.getString("dateEntree");

                        String datef = res.getString("dateSortie");;

                        dataDMA[i][0] = dated;
                        dataDMA[i][1]= datef;

                        i++;
                    }

                    ac.getTableauDMA().setModel(new DefaultTableModel(dataDMA, columns) {

                        @Override
                        public boolean isCellEditable(int row, int column) {
                            //Only the third column
                            return false;
                        }
                    });
                    ac.getAccueil().validate();
                    ac.getAccueil().repaint();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });

    }
}
