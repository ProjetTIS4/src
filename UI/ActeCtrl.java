/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import NF.Hash;
import NF.Personnel;
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
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenal
 */
public class ActeCtrl implements Runnable {
    
    private ActeGUI a;
    private String ipp;
    private AccueilGUI ac;
    private Personnel p;
    private String s;
    private String data[][];
    
    public ActeCtrl(String ipp, AccueilGUI ac, Personnel p, String s) {
        a = new ActeGUI();
        this.ipp = ipp;
        this.ac = ac;
        this.p = p;
        this.s = s;
        
    }
    
    @Override
    public void run() {
        choix();
        if (p.getPoste() == Personnel.Poste.PHService) {
            
            a.getPanelPH().setVisible(false);
        }
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
                a.getJour().setSize(28, 28);
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
                a.getMois().setSize(28, 28);
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
                a.getAnnee().setSize(50, 28);
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
                a.getHeure().setSize(28, 28);
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
                a.getMinute().setSize(28, 28);
                
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
                    Hash h = new Hash();
                    String url = "jdbc:mysql://hugofarcy.ddns.net:3306/SIH?autoReconnect=true&useSSL=false";
                    String user = "DEV";
                    String password = "SIH-mmlh2022";
                    
                    Connection con = DriverManager.getConnection(url, user, password);
                    
                    String str = (String) a.getChoixPH().getSelectedItem();
                    String[] newStr = str.split("\\s+");
                    int j = Integer.parseInt(newStr[0]);
                    
                    String requete = "";
                    
                    if (p.getPoste() == Personnel.Poste.PHService) {
                        requete = "INSERT INTO fichesDM (IPPatient, numeroSejour, numeroFiche,PHreferent,observations,prescriptions,operations,resultats,lettreDeSortie) VALUES ('"
                                + ipp
                                + "','"
                                + s
                                + "','"
                                + a.getAnnee().getText() + a.getMois().getText() + a.getJour().getText() + a.getHeure().getText() + a.getMinute().getText()
                                + "','"
                                + p.getLogin()
                                + "','"
                                + (h.expect(a.getObservations2().getText()))
                                + "','"
                                + h.expect(a.getPrestations2().getText())
                                + "','"
                                + h.expect(a.getOperations2().getText())
                                + "','"
                                + h.expect(a.getResultat2().getText())
                                + "','')";
                    } else {
                        requete = "INSERT INTO fichesDM (IPPatient, numeroSejour, numeroFiche,PHreferent,observations,prescriptions,operations,resultats,lettreDeSortie) VALUES ('"
                                + ipp
                                + "','"
                                + s
                                + "','"
                                + a.getAnnee().getText() + a.getMois().getText() + a.getJour().getText() + a.getHeure().getText() + a.getMinute().getText()
                                + "','"
                                + data[j][0]
                                + "','"
                                + (h.expect(a.getObservations2().getText()))
                                + "','"
                                + h.expect(a.getPrestations2().getText())
                                + "','"
                                + h.expect(a.getOperations2().getText())
                                + "','"
                                + h.expect(a.getResultat2().getText())
                                + "','')";
                    }
                    
                    Statement stm = con.createStatement();
                    stm.executeUpdate(requete);
                    
                    a.getAjouterActe().dispose();
                    
                      String query = "";
                            // REMPLIR LE TABLEAU DES ACTES DMs   
                            if (p.getPoste().equals(Personnel.Poste.SecretaireMedicale)) {
                                query = "SELECT COUNT(*) FROM fichesDM WHERE IPPatient=" + ipp + " AND numeroSejour=" + s;
                            } else {
                                query = "SELECT COUNT(*) FROM fichesDM WHERE IPPatient=" + ipp + " AND numeroSejour=" + s + " AND PHreferent= '" + p.getLogin() + "'";
                            }
                             stm = con.createStatement();
                            ResultSet res = stm.executeQuery(query);

                       

                            int taille = 0;

                            if (res.next()) {
                                taille = res.getInt("COUNT(*)");
                            }

                            String dataActeDM[][] = new String[taille][8];

                            String columnsActeDM[] = {"Date", "CR", "lettre sortie"};
                            if (p.getPoste().equals(Personnel.Poste.SecretaireMedicale)) {
                                query = "SELECT * FROM fichesDM WHERE IPPatient=" + ipp + " AND numeroSejour=" + s;
                            } else {
                                query = "SELECT * FROM fichesDM WHERE IPPatient=" + ipp + " AND numeroSejour=" + s + " AND PHreferent= '" + p.getLogin() + "'";
                            }

                            res = stm.executeQuery(query);
                            int i = 0;
                            while (res.next()) {

                                String resul = res.getString("resultats");
                                String sejour = res.getString("numeroSejour");
                                String lettre = res.getString("lettreDeSortie");
                                String num = res.getString("numeroFiche");

                                if (sejour.equals(s)) {

                                    dataActeDM[i][0] = num;
                                    if (resul.equals("") == false) {
                                        dataActeDM[i][1] = "true";

                                    } else {
                                        dataActeDM[i][1] = "VIDE";

                                    }
                                    if (lettre.equals("") == false) {
                                        dataActeDM[i][2] = "true";
                                    } else {
                                        dataActeDM[i][2] = "VIDE";
                                    }
                                }

                                
                        i++;
                    }
                    
                    ac.getTableauActeDm().setModel(new DefaultTableModel(dataActeDM, columnsActeDM) {
                        
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
    
    public void choix() {
        
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
            
            data = new String[taille][3];
            
            query = "SELECT nom, prenom,ID FROM PHS";
            res = stm.executeQuery(query);
            
            int i = 0;
            while (res.next()) {
               
                String nom = res.getString("nom");
                String prenom = res.getString("prenom");
                 String id = res.getString("ID");
                
                data[i][0] = id;
                data[i][1] = nom;
                data[i][2] = prenom;
                
                String s = "" + i + " " + res.getString("nom") + " " + res.getString("prenom");
                a.getChoixPH().addItem(s);
                
                i++;
            }
            
            a.getAjouterActe().validate();
            a.getAjouterActe().repaint();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
