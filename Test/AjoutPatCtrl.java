package Test;


import Test.AccueilGUI;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manon
 */

    public class AjoutPatCtrl implements Runnable {

    AjoutPatGUI a;
    String ipp;
    AccueilGUI ac;
    int compt;

    public AjoutPatCtrl(AccueilGUI ac) {
        this.ipp="test";
//        compt++;
//        if (compt < 10) {
//            this.ipp = ac.getDate().toString() + "0000" + compt; //Compteur au format YYMMxxxxx (xxxx est un compteur)
//        }
//        if (10 <= compt && compt < 100) {
//            this.ipp = ac.getDate().toString() + "000" + compt; //Compteur au format YYMMxxxxx (xxxx est un compteur)
//        }
//        if (100 <= compt && compt < 1000) {
//            this.ipp = ac.getDate().toString() + "00" + compt; //Compteur au format YYMMxxxxx (xxxx est un compteur)
//        }
//        if (1000 <= compt && compt < 10000) {
//            this.ipp = ac.getDate().toString() + "0" + compt; //Compteur au format YYMMxxxxx (xxxx est un compteur)
//        }
//        if (compt >= 10000) {
//            this.ipp = ac.getDate().toString() + compt; //Compteur au format YYMMxxxxx (xxxx est un compteur)
//        }
        a = new AjoutPatGUI();
//        this.ipp = ac.getDate().toString() + compt;
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

        //////////////////////// FenÃªtre ////////////////////////
        // a.getAjouterActe().setBounds(450, 190, 700, 460);
        a.getAjouterPat().setVisible(true);
        a.getAjouterPat().setSize(500, 700);

        //////////////////////// Panel Nom ////////////////////////
        a.getNom2().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                a.getNom2().setText("");
            }
        });
        
        a.getNom2().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (a.getNom2().getText().length() >= 2) // limit to 3 characters
                {
                    e.consume();
                }
            }
        });
        
        //////////////////////// Panel Nom ////////////////////////
        a.getNomM2().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                a.getNomM2().setText("");
            }
        });
        
        a.getNomM2().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (a.getNomM2().getText().length() >= 2) // limit to 3 characters
                {
                    e.consume();
                }
            }
        });
        
        //////////////////////// Panel Prenom ////////////////////////
        a.getPrenom2().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                a.getPrenom2().setText("");
            }
        });
        
        a.getPrenom().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (a.getPrenom().getText().length() >= 2) // limit to 3 characters
                {
                    e.consume();
                }
            }
        });
        //////////////////////// Panel Adresse ////////////////////////
        a.getAdresse2().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                a.getAdresse2().setText("");
            }
        });
        
        a.getAdresse2().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (a.getAdresse2().getText().length() >= 2) // limit to 3 characters
                {
                    e.consume();
                }
            }
        });
        //////////////////////// Panel Date de naissance ////////////////////////
        
        a.getJourN().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                a.getJourN().setText("");
                a.getJourN().setSize(28,28);
                a.getJourN().setForeground(Color.black);
            }
        });

        a.getJourN().addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                if (a.getJourN().getText().length() >= 2) // limit to 3 characters
                {
                    e.consume();
                }
            }
        });

        a.getMoisN().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                a.getMoisN().setText("");
                 a.getMoisN().setSize(28,28);
                a.getMoisN().setForeground(Color.black);
            }
        });

        a.getMoisN().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (a.getMoisN().getText().length() >= 2) // limit to 3 characters
                {
                    e.consume();
                }
            }
        });

        a.getAnneeN().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                a.getAnneeN().setText("");
                 a.getAnneeN().setSize(50,28);
                a.getAnneeN().setForeground(Color.black);
            }
        });

        a.getAnneeN().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (a.getAnneeN().getText().length() >= 4) // limit to 3 characters
                {
                    e.consume();
                }
            }
        });
 //////////////////////// Panel Adresse de naissance ////////////////////////
 a.getAdresseN2().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                a.getAdresseN2().setText("");
            }
        });
 
 a.getAdresseN2().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (a.getAdresseN2().getText().length() >= 2) // limit to 3 characters
                {
                    e.consume();
                }
            }
        });
  //////////////////////// Panel Localisation ////////////////////////
  a.getLoc2().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                a.getLoc2().setText("");
            }
        });
  
  a.getLoc2().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (a.getLoc2().getText().length() >= 2) // limit to 3 characters
                {
                    e.consume();
                }
            }
        });
   //////////////////////// Panel medecin generaliste ////////////////////////
   a.getMedGen2().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                a.getMedGen2().setText("");
            }
        });
   
   a.getMedGen2().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (a.getMedGen2().getText().length() >= 2) // limit to 3 characters
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

                    String requete = "INSERT INTO patient (ipp, nom_marital, nom_usuel, prenom, DDN, LDN, sexe, adresse, localisation, medGen) VALUES ('"
                            + ipp
                            + "','"
                            + a.getNomM2().getText()
                            + "','"
                            + a.getNom2().getText() 
                            + "','"
                            + a.getPrenom2().getText()
                            + "','"
                            + a.getAnneeN().getText() + a.getMoisN().getText() + a.getJourN().getText()
                            + "','"
                            + a.getAdresseN2().getText()
                            + "','"
                            + a.getChoix().getSelectedItem().toString()
                            + "','"
                            + a.getAdresse2().getText()
                            + "','"
                            + a.getLoc2().getText()
                            + "','"
                            + a.getMedGen2().getText()
                            + "')";
                    
                     System.out.println(requete);
                    Statement stm = con.createStatement();
                    stm.executeUpdate(requete);
                    
                    a.getAjouterPat().dispose();

                    String query = "SELECT COUNT(*) FROM patient WHERE IPPatient=" + ipp;
                    ResultSet res = stm.executeQuery(query);

                    int taille = 0;

                    if (res.next()) {
                        taille = res.getInt("COUNT(*)");
                    }

                    String dataDMA[][] = new String[taille][8];
                    String columns[] = {"Date d'entrÃ©e", "Date de sortie"};
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
                    
                    
                    ac.getAccueil().repaint();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });

    }
}

