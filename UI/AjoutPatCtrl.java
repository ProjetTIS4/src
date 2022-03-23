package UI;

import NF.Date;
import NF.Patient;
import NF.Patient.Sexe;
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
    //String ipp;
    AccueilGUI ac;
    int compt;
    Patient p;

    public AjoutPatCtrl(AccueilGUI ac) {
        
         try {

                    String url = "jdbc:mysql://hugofarcy.ddns.net:3306/SIH?autoReconnect=true&useSSL=false";
                    String user = "DEV";
                    String password = "SIH-mmlh2022";

                    Connection con = DriverManager.getConnection(url, user, password);

                  String requete = "SELECT compteurIPP FROM compteur";
                    System.out.println(requete);
                    Statement stm = con.createStatement();
                    ResultSet res = stm.executeQuery(requete);

                    if (res.next()) {
                        this.compt=res.getInt("compteurIPP");
   
                    }
                    

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

        a = new AjoutPatGUI();

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
                a.getNom2().setForeground(Color.black);
            }
        });


        //////////////////////// Panel Nom ////////////////////////
        a.getNomM2().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                a.getNomM2().setText("");
                a.getNomM2().setForeground(Color.black);
            }
        });


        //////////////////////// Panel Prenom ////////////////////////
        a.getPrenom2().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                a.getPrenom2().setText("");
                a.getPrenom2().setForeground(Color.black);
            }
        });

        //////////////////////// Panel Adresse ////////////////////////
        a.getAdresse2().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                a.getAdresse2().setText("");
                a.getAdresse2().setForeground(Color.black);
            }
        });


        //////////////////////// Panel Date de naissance ////////////////////////
        a.getJourN().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                a.getJourN().setText("");
                a.getJourN().setSize(28, 28);
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
                a.getMoisN().setSize(28, 28);
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
                a.getAnneeN().setSize(50, 28);
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
                a.getAdresseN2().setForeground(Color.black);
            }
        });

        //////////////////////// Panel Localisation ////////////////////////
        a.getLoc2().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                a.getLoc2().setText("");
                a.getLoc2().setForeground(Color.black);
            }
        });

        //////////////////////// Panel medecin generaliste ////////////////////////
        a.getMedGen2().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                a.getMedGen2().setText("");
                a.getMedGen2().setForeground(Color.black);
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

                    Date d = new Date(a.getJourN().getText() + "/" + a.getMoisN().getText() + "/" + a.getAnneeN().getText());
                    p= new Patient(a.getNom2().getText(),  a.getPrenom2().getText(), Sexe.FEMME, a.getAdresse2().getText(), d, compt);
                    p.setSexe( a.getChoix().getSelectedItem().toString());
                    
                    String requete = "INSERT INTO patient (ipp, nom_marital, nom_usuel, prenom, DDN, LDN, sexe, adresse, localisation, medGen) VALUES ('"
                            + p.getIPP()
                            + "','"
                            + a.getNomM2().getText()
                            + "','"
                            + a.getNom2().getText()
                            + "','"
                            + a.getPrenom2().getText()
                            + "','"
                            + a.getJourN().getText() + "/" + a.getMoisN().getText() + "/" + a.getAnneeN().getText()
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
                     requete = "UPDATE compteur SET compteurIPP ='"+p.getCompteur() +" '";
                   stm.executeUpdate(requete);

                    String query = "SELECT COUNT(*) FROM patient";
                    ResultSet res = stm.executeQuery(query);

                    int taille = 0;

                    if (res.next()) {
                        taille = res.getInt("COUNT(*)");
                    }

                    String dataPatient[][] = new String[taille][7];
                    String columnsPatient[] = {"IPP", "Nom", "Prénom", "Date de Naissance", "Sexe", "Chambre", "Service de localisation"};

//            res2.close();
                    query = "SELECT * FROM patient ";
                    res = stm.executeQuery(query);
                    int i = 0;
                    while (res.next()) {
                        String IPP = res.getString("IPP");
                        String nom_marital = res.getString("nom_marital");
                        String nom_usuel = res.getString("nom_usuel");
                        String prenom = res.getString("prenom");
                        String dateNaissance = res.getString("DDN");
                        String sexe = res.getString("sexe");
                        String adresse = res.getString("adresse");
                        String localisation = res.getString("localisation");
                        String medGen = res.getString("medGen");

                        if (contains(dataPatient, IPP, 0)) {

                            continue;
                        } else {

                            dataPatient[i][0] = IPP;
                            dataPatient[i][1] = nom_marital;
                            dataPatient[i][2] = prenom;
                            dataPatient[i][3] = dateNaissance;
                            dataPatient[i][4] = sexe;
                            dataPatient[i][5] = affichageLoc(localisation);
                            dataPatient[i][6] = affichageSpe(localisation);

                            i++;
                        }
                    }
                      ac.getTableau().setModel(new DefaultTableModel(dataPatient, columnsPatient) {

                                @Override
                                public boolean isCellEditable(int row, int column) {
                                    //Only the third column
                                    return false;
                                }
                            });

                    ac.getAccueil().repaint();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });

    }
    
        public boolean contains(String[][] t, String s, int j) {
        boolean b = false;
        int size = t.length;
        String ipp = s;

        System.out.println(s);
        for (int i = 0; i < size; i++) {
            String a = t[i][j];
            b = ipp.equals(a);
            if (b) {
                return b;
            }
            System.out.println(a);
            System.out.println(b);
        }

        return b;
    }

    public String affichageLoc(String s) {
        if (s.equals("")){
        return s;}
        else{
        String l = s.substring(1, 5);

        return (l);}
    }

    public String affichageSpe(String s) {
         if (s.equals("")){
        return s;}
        else{ String l = s.substring(5);

        return (l);}
    }
}
