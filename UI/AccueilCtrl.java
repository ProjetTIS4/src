/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import HL7.FrameClient;
import HL7.ServeurTest;
import NF.DM;
import NF.DMA;
import NF.Date;
import NF.FichesDM;
import NF.Hash;
import NF.Patient;
import NF.Patient.Sexe;
import NF.Personnel;
import NF.Personnel.Poste;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_ENTER;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.SwingUtilities;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenal
 */
public class AccueilCtrl implements Runnable {

    private String ipp;
    private Personnel p;
    private AccueilGUI a;
    private Patient patient;
    private FichesDM fiche;
    private int taille;
    private String dataTable[][];

    private String dataDMHide[][];
    private String sej;
    private String dataActeDM[][];
    private String dataActeDMA[][];
    private int ligne;
    private String dataDM[][];
    private String dataDMA[][];
    private String data[][];
    private String numFiche;
    private LocalDate dateDuJour;
    private String loc;

    private DefaultTableModel model;

    public AccueilCtrl(Personnel p) {
        this.a = new AccueilGUI();
        this.p = p;
        this.dateDuJour = LocalDate.now();
    }

    @Override
    public void run() {
        ipp = "";
        numFiche = "";

        ligne = 0;
        AccueilCtrl acc = this;
        Hash h = new Hash();

        /// R??cup??ration de la table Patient ///
        try {
            String url = "jdbc:mysql://hugofarcy.ddns.net:3306/SIH?autoReconnect=true&useSSL=false";
            String user = "DEV";
            String password = "SIH-mmlh2022";

            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            String query = "";

            switch (p.getPoste()) {

                case PHService:
                    query = "SELECT COUNT(DISTINCT IPP)  FROM patient JOIN (SELECT * FROM fichesDM JOIN PHS ON(PHreferent=ID) WHERE PHS.service=\"" + p.getNomService() + "\" )AS J  ON IPP=IPPatient";
                    a.getObservations2().setEditable(true);
                    a.getPrescription2().setEditable(true);
                    a.getOperationInfo().setEditable(true);
                    a.getResultatInfo().setEditable(true);
                    a.getAjoutPat().setVisible(false);

                    break;

                case PHAnesthesiste:
                    query = "SELECT COUNT(DISTINCT IPP)  FROM patient JOIN (SELECT * FROM fichesDM JOIN PHS ON(PHreferent=ID) WHERE PHS.service=\"" + p.getNomService() + "\" )AS J  ON IPP=IPPatient";
                    a.getObservations2().setEditable(true);
                    a.getPrescription2().setEditable(true);
                    a.getFicheOperation().setVisible(false);
                    a.getResultatInfo().setEditable(true);
                    a.getAjoutPat().setVisible(false);
                    break;

                case PHMedicoTechnique:
                    query = "SELECT COUNT(DISTINCT IPP) FROM patient JOIN (SELECT * FROM fichesDM JOIN PHS ON(PHreferent=ID) WHERE PHS.service=\"" + p.getNomService() + "\" )AS J  ON IPP=IPPatient";
                    a.getObservations2().setEditable(true);
                    a.getResultatInfo().setEditable(true);
                    a.getFichePrescription().setVisible(false);
                    a.getFicheOperation().setVisible(false);
                    a.getAjoutPat().setVisible(false);
                    break;

                case SecretaireAdministrative:
                    query = "SELECT COUNT(DISTINCT IPP) FROM patient";
                    a.getAjoutPat().setVisible(true);
                    a.getButtonNouveauDMA().setVisible(true);
                    a.getAjoutActeDMA().setVisible(true);
                    break;

                case SecretaireMedicale:
                    // query = "SELECT COUNT(DISTINCT IPP) FROM patient JOIN (SELECT * FROM fichesDM JOIN PHS ON(PHreferent=ID) WHERE PHS.service=\"" + p.getNomService() + "\" )AS J  ON IPP=IPPatient";
                    query = "SELECT COUNT(DISTINCT IPP) FROM patient";
                    a.getAjoutPat().setVisible(false);
                    break;

            }

            ResultSet res = stm.executeQuery(query);

            taille = 0;

            if (res.next()) {
                taille = res.getInt("COUNT(DISTINCT IPP)");
            }

            data = new String[taille][9];
            String columns[] = {"IPP", "Nom", "Pr??nom", "Date de Naissance", "Sexe", "Chambre", "Service de localisation"};

            dataTable = new String[taille][7];

            switch (p.getPoste()) {

                case PHService:
                    query = "SELECT * FROM patient JOIN (SELECT * FROM fichesDM JOIN PHS ON(PHreferent=ID) WHERE PHS.service=\"" + p.getNomService() + "\" )AS J  ON IPP=IPPatient ";

// query = "SELECT * FROM patient JOIN fichesDM ON IPP=IPPatient WHERE PHreferent='" + p.getLogin() + "'";
                    break;

                case PHAnesthesiste:
                    query = "SELECT * FROM patient JOIN (SELECT * FROM fichesDM JOIN PHS ON(PHreferent=ID) WHERE PHS.service=\"" + p.getNomService() + "\" )AS J  ON IPP=IPPatient ";
                    break;

                case PHMedicoTechnique:
                    query = "SELECT * FROM patient JOIN (SELECT * FROM fichesDM JOIN PHS ON(PHreferent=ID) WHERE PHS.service=\"" + p.getNomService() + "\" )AS J  ON IPP=IPPatient ";
                    break;

                case SecretaireAdministrative:
                    query = "SELECT * FROM patient ";

                    break;

                case SecretaireMedicale:
                    //    query = "SELECT * FROM patient JOIN (SELECT * FROM fichesDM JOIN PHS ON(PHreferent=ID) WHERE PHS.service=\"" + p.getNomService() + "\" )AS J  ON IPP=IPPatient ";
                    query = "SELECT * FROM patient ";
                    break;

            }

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

                if (contains(dataTable, IPP, 0)) {

                    continue;
                } else {
                    data[i][0] = IPP;
                    dataTable[i][0] = IPP;
                    data[i][1] = nom_marital;
                    dataTable[i][1] = nom_marital;
                    data[i][2] = nom_usuel;
                    data[i][3] = prenom;
                    dataTable[i][2] = prenom;
                    data[i][4] = dateNaissance;
                    dataTable[i][3] = dateNaissance;
                    data[i][5] = sexe;
                    dataTable[i][4] = sexe;
                    data[i][6] = adresse;
                    data[i][7] = localisation;
                    dataTable[i][5] = affichageLoc(localisation);
                    dataTable[i][6] = affichageSpe(localisation);
                    data[i][8] = medGen;

                    i++;
                }
            }

            model = new DefaultTableModel(dataTable, columns) {

                @Override
                public boolean isCellEditable(int row, int column) {
                    //Only the third column
                    return false;
                }
            };
            a.getTableau().setModel(model);

            //////// R??gler la taille de la fen??tre et permettre d'arr??ter le programme ?? la fermeture de la fen??tre
            a.getAccueil().setDefaultCloseOperation(EXIT_ON_CLOSE);
            a.getAccueil().setBounds(0, 20, 1200, 900);
            a.getAccueil().setVisible(true);
            Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
            int longueur = tailleMoniteur.width * 2 / 3;
            int hauteur = tailleMoniteur.height * 2 / 3;
//r??gler la taille de JFrame ?? 2/3 la taille de l'??cran
            a.getAccueil().setSize(longueur, hauteur);

            ////////// Panel Haut /////////////
            if (p.getPoste() == Personnel.Poste.PHService || p.getPoste() == Personnel.Poste.PHAnesthesiste || p.getPoste() == Personnel.Poste.PHMedicoTechnique) {

                a.getPresentation().setText("Bienvenue Dr. " + p.getNom().toUpperCase() + " " + p.getPrenom());
                a.getPresentation2().setText("" + p.getNomService());

            } else if (p.getPoste() == Personnel.Poste.SecretaireAdministrative) {
                a.getPresentation().setText("Bienvenue " + p.getNom().toUpperCase() + " " + p.getPrenom());
                a.getPresentation2().setText("Secr??taire administrative");
            } else if (p.getPoste() == Personnel.Poste.SecretaireMedicale) {
                a.getPresentation().setText("Bienvenue " + p.getNom().toUpperCase() + " " + p.getPrenom());
                a.getPresentation2().setText("Secr??taire m??dicale - " + p.getNomService());
            }

// Listener de d??connexion
            a.getDeconnexion().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent me) {

                    int input = JOptionPane.showConfirmDialog(a.getAccueil(), "Voulez-vous vraiment vous d??connecter ?", "Confirmation", YES_NO_OPTION, WARNING_MESSAGE);
                    if (input == 0) {
                        a.getAccueil().setVisible(false);
                        SwingUtilities.invokeLater(new ConnexionCtrl());
                    }
                }
            });

            a.getTableau().addMouseListener(new MouseAdapter() {

                public void mouseClicked(MouseEvent me) {

                    if (me.getClickCount() == 1) {
                        a.getTableauActeDm().setModel(new DefaultTableModel());
                        a.getAjoutActe().setVisible(false);
                        a.getTableauActeDMA().setModel(new DefaultTableModel());

                        int ligne = a.getTableau().getSelectedRow();
                        Object cellule = a.getTableau().getValueAt(ligne, 0);
                        ipp = "" + cellule;

                        int k = 0;
                        while (data[k][0].equals(ipp) == false && k < data.length - 1) {

                            k++;

                        }
                        if (k != data.length) {
                            String nom = data[k][1];
                            String prenom = data[k][3];
                            Sexe sexe = creerSexe(data[k][5]);
                            String adresse = data[k][6];
                            Date date = CreerDateNaissanceString(data[k][4]);

                            patient = new Patient(nom, prenom, sexe, adresse, date);
                            patient.setIPP(data[k][0]);
                            patient.setNom(data[k][1]);
                            patient.setPrenom(data[k][3]);
                            patient.setDateNaissanceString(data[k][4]);
                            patient.setSexe(data[k][5]);
                            patient.setAdresse(data[k][6]);
                            patient.setMedGen(data[k][8]);

                        }
                        loc = data[k][7];

                        a.getPanelMessage().setVisible(false);
                        if (p.getPoste().equals(Poste.SecretaireAdministrative)) {
                            int nbDMA = 0;
                            try {
                                String req = "SELECT COUNT(*) FROM DMA WHERE IPPatient='" + ipp + "'";

                                ResultSet res = stm.executeQuery(req);
                                if (res.next()) {
                                    nbDMA = res.getInt("COUNT(*)");
                                }

                                if (nbDMA == 0) {
                                    a.getPanelDMA().add(a.getPanelNouveauDMA());
                                    a.getPanelNouveauDMA().setVisible(true);
                                    a.gettDMA().setVisible(false);
                                    a.getPanelListeDMA().setVisible(false);
                                    a.getPanelDetailDMA().setVisible(false);
                                    a.getPanelPlusDMA().setVisible(false);

                                } else {
                                    a.getPanelDMA().add(a.gettDMA());
                                    a.getPanelNouveauDMA().setVisible(false);
                                    a.gettDMA().setVisible(true);
                                    a.getPanelListeDMA().setVisible(true);
                                    a.getPanelDetailDMA().setVisible(true);
                                    a.getPanelPlusDMA().setVisible(true);
                                }
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }

                            a.getTp().add("DMA", a.getDMA());
                        } else if (p.getPoste().equals(Poste.SecretaireMedicale)) {
                            a.getTp().add("DM", a.getDM());
                        } else if (p.getPoste().equals(Poste.PHService)) {
                            a.getPanelDMA().add(a.gettDMA());

                            try {
                                String req = "SELECT IPP FROM patient JOIN fichesDM ON IPP=IPPatient WHERE PHreferent='" + p.getLogin() + "' AND IPP='" + ipp + "'";

                                ResultSet res = stm.executeQuery(req);
                                while (res.next()) {
                                    String IPP = res.getString("IPP");

                                    if (IPP != null) {
                                        a.getTp().add("DM", a.getDM());
                                        a.getTp().add("DMA", a.getDMA());

                                    } else {
                                        a.getTp().add("DMA", a.getDMA());

                                    }
                                }
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }

                        a.getPanelDroit().add(a.getTp());

                        a.getNom2().setText(patient.getNom());
                        a.getPrenom2().setText(patient.getPrenom());
                        a.getSexeInfo().setText("" + patient.getSexe());
                        a.getDateInfo().setText(patient.stringDate());
                        a.getAdresseInfo().setText(patient.getAdresse());

                        if (patient.getSexe() == Patient.Sexe.HOMME) {
                            a.getImage2().setIcon(a.getIconeH());
                        } else {

                            a.getImage2().setIcon(a.getIconeF());

                        }

////Pour le DMA////
                        a.getNom2DMA().setText(patient.getNom());
                        a.getPrenom2DMA().setText(patient.getPrenom());
                        a.getNom2DMA().setText(patient.getNom());
                        a.getPrenom2DMA().setText(patient.getPrenom());
                        a.getSexeInfoDMA().setText("" + patient.getSexe());
                        a.getDateInfoDMA().setText(patient.stringDate());
                        a.getAdresseInfoDMA().setText(patient.getAdresse());

                        if (patient.getSexe() == Patient.Sexe.HOMME) {
                            a.getImage2DMA().setIcon(a.getIconeH());
                        } else {

                            a.getImage2DMA().setIcon(a.getIconeF());

                        }

                        a.getAccueil().validate();
                        a.getAccueil().repaint();

                        ////Pour le DM////                       
                        try {

// REMPLIR LE TABLEAU DES DMs    
                            String query = "SELECT COUNT(*) FROM DM WHERE IPPatient=" + ipp;
                            Statement stm = con.createStatement();
                            ResultSet res = stm.executeQuery(query);

                            taille = 0;

                            if (res.next()) {
                                taille = res.getInt("COUNT(*)");
                            }

                            dataDM = new String[taille][2];
                            dataDMHide = new String[taille][3];
                            String columnsDM[] = {"Date d'entr??e", "Date de sortie"};

                            query = "SELECT * FROM DM WHERE IPPatient=" + ipp;

                            res = stm.executeQuery(query);
                            int i = 0;
                            while (res.next()) {

                                String dated = res.getString("dateEntree");
                                String sejour = res.getString("numeroSejour");
                                String datef = res.getString("dateSortie");

                                dataDM[i][0] = dated;
                                dataDM[i][1] = datef;
                                dataDMHide[i][0] = dated;
                                dataDMHide[i][1] = datef;
                                dataDMHide[i][2] = sejour;

                                i++;
                            }

                            a.getTableauDM().setModel(new DefaultTableModel(dataDM, columnsDM) {

                                @Override
                                public boolean isCellEditable(int row, int column) {
                                    //Only the third column
                                    return false;
                                }
                            });

                            a.getObservations2().setText("");
                            a.getPrescription2().setText("");
                            a.getOperationInfo().setText("");
                            a.getResultatInfo().setText("");
                            a.getLettreSortie().setText("");
                            a.getDetailsDM().setVisible(false);

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }

                        ////Pour le DMA////  
                        MAJTblDMA();

                    } else if (me.getClickCount() == 2) {
                        if (p.getPoste() == Personnel.Poste.SecretaireMedicale) {
                            if (a.getTableau().getSelectedColumn() == 5 || a.getTableau().getSelectedColumn() == 6) {

                                int ligne = a.getTableau().getSelectedRow();
                                ipp = dataTable[ligne][0];
                                loc = data[ligne][7];

                                SwingUtilities.invokeLater(new ModifierLocalisationCtrl(ipp, a, acc, loc));

                            }
                        }
                    }

                }
            }
            );
            a.getTableauDM().addMouseListener(new MouseAdapter() {

                public void mouseClicked(MouseEvent me) {

                    if (me.getClickCount() == 1) {
                        int ligne = a.getTableauDM().getSelectedRow();

                        a.getAjoutActe().setVisible(true);
                        sej = dataDMHide[ligne][2];

                        try {
                            String query = "";
                            // REMPLIR LE TABLEAU DES ACTES DMs   
                            if (p.getPoste().equals(Poste.SecretaireMedicale)) {
                                query = "SELECT COUNT(*) FROM fichesDM WHERE IPPatient=" + ipp + " AND numeroSejour=" + sej;
                            } else {
                                query = "SELECT COUNT(*) FROM fichesDM WHERE IPPatient=" + ipp + " AND numeroSejour=" + sej + " AND PHreferent= '" + p.getLogin() + "'";
                            }
                            Statement stm = con.createStatement();
                            ResultSet res = stm.executeQuery(query);

                            int taille = 0;

                            if (res.next()) {
                                taille = res.getInt("COUNT(*)");
                            }

                            dataActeDM = new String[taille][8];

                            String columnsActeDM[] = {"Date", "CR", "lettre sortie"};
                            if (p.getPoste().equals(Poste.SecretaireMedicale)) {
                                query = "SELECT * FROM fichesDM WHERE IPPatient=" + ipp + " AND numeroSejour=" + sej;
                            } else {
                                query = "SELECT * FROM fichesDM WHERE IPPatient=" + ipp + " AND numeroSejour=" + sej + " AND PHreferent= '" + p.getLogin() + "'";
                            }

                            res = stm.executeQuery(query);
                            int i = 0;
                            while (res.next()) {

                                String resul = res.getString("resultats");
                                String sejour = res.getString("numeroSejour");
                                String lettre = res.getString("lettreDeSortie");
                                String num = res.getString("numeroFiche");

                                if (sejour.equals(dataDMHide[ligne][2])) {

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

                            a.getTableauActeDm().setModel(new DefaultTableModel(dataActeDM, columnsActeDM) {

                                @Override
                                public boolean isCellEditable(int row, int column) {
                                    //Only the third column
                                    return false;
                                }
                            });
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
            );

            a.getTableauDMA().addMouseListener(new MouseAdapter() {

                public void mouseClicked(MouseEvent me) {

                    if (me.getClickCount() == 1) {
                        int ligne = a.getTableauDMA().getSelectedRow();

                        sej = dataDMA[ligne][2];

                        try {
                            String query = "";
                            // REMPLIR LE TABLEAU DES ACTES DMs   
                            if (p.getPoste().equals(Poste.SecretaireAdministrative)) {
                                query = "SELECT COUNT(*) FROM fichesDMA WHERE IPPatient=" + ipp + " AND numeroSejour=" + sej;
                            } else {
                                query = "SELECT COUNT(*) FROM fichesDMA WHERE IPPatient=" + ipp + " AND numeroSejour=" + sej + " AND PHreferent= '" + p.getLogin() + "'";
                            }

                            Statement stm = con.createStatement();
                            ResultSet res = stm.executeQuery(query);

                            int taille = 0;

                            if (res.next()) {
                                taille = res.getInt("COUNT(*)");
                            }

                            dataActeDMA = new String[taille][3];

                            String columnsActeDMA[] = {"Num??ro de fiche", "PH r??f??rent", "lettre sortie"};
                            if (p.getPoste().equals(Poste.SecretaireAdministrative)) {
                                query = "SELECT * FROM fichesDMA WHERE IPPatient=" + ipp + " AND numeroSejour=" + sej;
                            } else {
                                query = "SELECT * FROM fichesDMA WHERE IPPatient=" + ipp + " AND numeroSejour=" + sej + " AND PHreferent= '" + p.getLogin() + "'";
                            }

                            res = stm.executeQuery(query);
                            int i = 0;
                            while (res.next()) {

                                String PHRef = res.getString("PHreferent");
                                String sejour = res.getString("numeroSejour");
                                String lettre = res.getString("lettreDeSortie");
                                String num = res.getString("numeroFiche");

                                if (sejour.equals(dataDMA[ligne][2])) {

                                    dataActeDMA[i][0] = num;
                                    dataActeDMA[i][1] = PHRef;

                                    if (lettre.equals("") == false) {
                                        dataActeDMA[i][2] = "true";
                                    } else {
                                        dataActeDMA[i][2] = "VIDE";
                                    }
                                }

                                i++;
                            }

                            ipp = ipp;
                            a.getTableauActeDMA().setModel(new DefaultTableModel(dataActeDMA, columnsActeDMA) {

                                @Override
                                public boolean isCellEditable(int row, int column) {
                                    //Only the third column
                                    return false;
                                }
                            });
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
            );

            // Listener sur le bouton "+" pour ajouter un acte      
            a.getButtonRadio().addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent me) {

                    try {
                        // FrameClient client = new FrameClient();
                        new FrameClient().setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(AccueilCtrl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            });

            a.getAjoutActe().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent me) {

                    SwingUtilities.invokeLater(new ActeCtrl(ipp, a, p, sej));
                }
            });

            //Listener sur le bouton "+" pour ajouter un DMA
//            ajout DMA
            a.getButtonNouveauDMA().addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent me) {

                    int compt = 0;
                    try {
                        String requete = "SELECT compteurDMA FROM patient";

                        Statement stm = con.createStatement();
                        ResultSet res = stm.executeQuery(requete);

                        if (res.next()) {
                            compt = res.getInt("compteurDMA");

                        }
                        DMA dma = new DMA(patient, compt);
                        requete = "INSERT INTO DMA (IPPatient, numeroSejour, dateEntree, dateSortie) VALUES ('"
                                + patient.getIPP()
                                + "','"
                                + dma.getNumeroSejour()
                                + "','"
                                + dma.getDebut().toString()
                                + "','"
                                + ""
                                + "')";

                        stm = con.createStatement();
                        stm.executeUpdate(requete);

                        DM dm = new DM(patient, dma.getDebut());
                        requete = "INSERT INTO DM (IPPatient, numeroSejour, dateEntree, dateSortie) VALUES ('"
                                + patient.getIPP()
                                + "','"
                                + dma.getNumeroSejour()
                                + "','"
                                + dma.getDebut().toString()
                                + "','"
                                + ""
                                + "')";

                        stm = con.createStatement();
                        stm.executeUpdate(requete);

                        requete = "UPDATE patient SET compteurDMA ='" + dma.getCompteur() + " ' WHERE IPP='" + patient.getIPP() + "' ";

                        stm.executeUpdate(requete);

                        a.getPanelNouveauDMA().setVisible(false);
                        a.gettDMA().setVisible(true);
                        MAJTblDMA();
                        a.getAccueil().validate();
                        a.getAccueil().repaint();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }
            });

            //Listener sur le bouton "+" pour ajouter un Patient
            a.getAjoutPat().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent me) {

                    SwingUtilities.invokeLater(new AjoutPatCtrl(a, acc));
                }
            });

            //Listener sur le bouton "+" pour ajouter un DMA
            a.getAjoutActeDMA().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    int compt = 0;
                    try {
                        String requete = "SELECT compteurDMA FROM patient WHERE IPP='" + ipp + "'";

                        Statement stm = con.createStatement();
                        ResultSet res = stm.executeQuery(requete);

                        if (res.next()) {
                            compt = res.getInt("compteurDMA");

                        }
                        DMA dma = new DMA(patient, compt);
                        requete = "INSERT INTO DMA (IPPatient, numeroSejour, dateEntree, dateSortie) VALUES ('"
                                + patient.getIPP()
                                + "','"
                                + dma.getNumeroSejour()
                                + "','"
                                + dma.getDebut().toString()
                                + "','"
                                + ""
                                + "')";

                        stm = con.createStatement();
                        stm.executeUpdate(requete);

                        DM dm = new DM(patient, dma.getDebut());
                        requete = "INSERT INTO DM (IPPatient, numeroSejour, dateEntree, dateSortie) VALUES ('"
                                + patient.getIPP()
                                + "','"
                                + dma.getNumeroSejour()
                                + "','"
                                + dma.getDebut().toString()
                                + "','"
                                + "')";

                        stm = con.createStatement();
                        stm.executeUpdate(requete);

                        requete = "UPDATE patient SET compteurDMA ='" + dma.getCompteur() + "' WHERE IPP='" + patient.getIPP() + "' ";
                        stm.executeUpdate(requete);

                        MAJTblDMA();
                        a.getAccueil().validate();
                        a.getAccueil().repaint();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });

            // Listener sur le bouton rechercher 
            a.getBarreRecherche().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    a.getBarreRecherche().setText("");
                    a.getBarreRecherche().setForeground(Color.black);
                }
            });

            a.getRechercher().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent me) {

                    recherche();
                }
            });

            a.getRetour().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    model = new DefaultTableModel(dataTable, columns) {

                        @Override
                        public boolean isCellEditable(int row, int column) {
                            //Only the third column
                            return false;
                        }
                    };
                    a.getTableau().setModel(model);

                }
            });

            a.getBarreRecherche().addKeyListener(new KeyListener() {

                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyChar() == VK_ENTER) {
                        recherche();
                    }
                }

                @Override
                public void keyTyped(KeyEvent e) {
                }

                @Override
                public void keyReleased(KeyEvent e) {
                }

            });

            a.getTableauActeDm().addMouseListener(new MouseAdapter() {

                public void mouseClicked(MouseEvent me) {
                    if (me.getClickCount() == 1) {
                        a.getButtonSaveObs().setVisible(false);
                        a.getButtonSavePres().setVisible(false);
                        a.getButtonSaveOp().setVisible(false);
                        a.getButtonSaveRes().setVisible(false);
                        ligne = a.getTableauActeDm().getSelectedRow();
                        Object cellule = a.getTableauActeDm().getValueAt(ligne, 0);

                        numFiche = "" + cellule;

                        if (dataActeDM[ligne][2].equals("VIDE") && p.getPoste() == Poste.PHService) {
                            a.getObservations2().setEditable(true);
                            a.getPrescription2().setEditable(true);
                            a.getOperationInfo().setEditable(true);
                            a.getResultatInfo().setEditable(true);
                            a.getLettreSortie().setEditable(true);
                            a.getSortieHaut().setVisible(true);
                        } else {
                            a.getObservations2().setEditable(false);
                            a.getPrescription2().setEditable(false);
                            a.getOperationInfo().setEditable(false);
                            a.getResultatInfo().setEditable(false);
                            a.getLettreSortie().setEditable(false);
                            a.getSortieHaut().setVisible(false);

                        }

                        MAJDetailDM();

                    }
                }
            }
            );

            a.getTableauActeDMA().addMouseListener(new MouseAdapter() {

                public void mouseClicked(MouseEvent me) {
                    if (me.getClickCount() == 1) {

                        ligne = a.getTableauActeDMA().getSelectedRow();
                        Object cellule = a.getTableauActeDMA().getValueAt(ligne, 0);

                        String s = "" + cellule;

                        try {
                            String query = "SELECT COUNT(*) FROM fichesDMA WHERE IPPatient=" + ipp;
                            Statement stm = con.createStatement();
                            ResultSet res = stm.executeQuery(query);

                            int taille = 0;

                            if (res.next()) {
                                taille = res.getInt("COUNT(*)");
                            }

                            String dataDMAF[][] = new String[taille][2];
                            //           String columns[] = {"observations", "prescription", "operations", "resultats"};

                            query = "SELECT * FROM fichesDM WHERE IPPatient=" + ipp + " AND numeroFiche=" + s;
                            res = stm.executeQuery(query);
                            int i = 0;
                            while (res.next()) {

                                String pres2 = res.getString("prescriptions");

                                String lettre = res.getString("lettreDeSortie");

                                dataDMAF[i][0] = pres2;
                                dataDMAF[i][1] = lettre;

                                i++;
                            }

                            String prescription = dataDMAF[0][0];
                            String lettre = dataDMAF[0][1];

                            a.getPrescriptionDMA().setText(prescription);
                            a.getLettreSortieDMA().setText(lettre);

                            a.getPanelDetailDMA().add(a.getDetailsDMA());
                            a.getDetailsDMA().setVisible(true);
                            a.getAccueil().validate();
                            a.getAccueil().repaint();

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }

                    }
                }
            }
            );

            a.getObservations2().addKeyListener(new KeyListener() {

                @Override
                public void keyTyped(KeyEvent arg0) {
                    if (a.getObservations2().isEditable()) {

                        a.getButtonSaveObs().setVisible(true);
                    }

                }

                @Override
                public void keyReleased(KeyEvent arg0) {
                }

                @Override
                public void keyPressed(KeyEvent arg0) {
                }
            });

            a.getPrescription2().addKeyListener(new KeyListener() {

                @Override
                public void keyTyped(KeyEvent arg0) {
                    if (a.getPrescription2().isEditable()) {
                        a.getButtonSavePres().setVisible(true);
                    }

                }

                @Override
                public void keyReleased(KeyEvent arg0) {
                }

                @Override
                public void keyPressed(KeyEvent arg0) {
                }
            });

            a.getOperationInfo().addKeyListener(new KeyListener() {

                @Override
                public void keyTyped(KeyEvent arg0) {
                    if (a.getOperationInfo().isEditable()) {
                        a.getButtonSaveOp().setVisible(true);
                    }

                }

                @Override
                public void keyReleased(KeyEvent arg0) {
                }

                @Override
                public void keyPressed(KeyEvent arg0) {
                }
            });

            a.getResultatInfo().addKeyListener(new KeyListener() {

                @Override
                public void keyTyped(KeyEvent arg0) {
                    if (a.getResultatInfo().isEditable()) {
                        a.getButtonSaveRes().setVisible(true);
                    }

                }

                @Override
                public void keyReleased(KeyEvent arg0) {
                }

                @Override
                public void keyPressed(KeyEvent arg0) {
                }
            });

            a.getLettreSortie().addKeyListener(new KeyListener() {

                @Override
                public void keyTyped(KeyEvent arg0) {
                    if (a.getLettreSortie().isEditable()) {
                        a.getButtonSaveSortie().setVisible(true);
                    }

                }

                @Override
                public void keyReleased(KeyEvent arg0) {
                }

                @Override
                public void keyPressed(KeyEvent arg0) {
                }
            });

            a.getButtonSortie().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    try {
                        String url = "jdbc:mysql://hugofarcy.ddns.net:3306/SIH?autoReconnect=true&useSSL=false";
                        String user = "DEV";
                        String password = "SIH-mmlh2022";

                        Connection con = DriverManager.getConnection(url, user, password);

                        try {
                            JFileChooser choose = new JFileChooser();

                            // Ouvrez le fichier
                            int res = choose.showOpenDialog(null);
                            // Enregistrez le fichier
                            // int res = choose.showSaveDialog(null);

                            if (res == JFileChooser.APPROVE_OPTION) {
                                File file = choose.getSelectedFile();
                                choose.getFileView();

                                Scanner obj = new Scanner(file);

                                String lettre = "";
                                while (obj.hasNextLine()) {
                                    lettre = lettre + obj.nextLine();

                                }

                                a.getLettreSortie().setText(lettre);
                                String requete = "UPDATE fichesDM SET lettreDeSortie ='" + (a.getLettreSortie().getText()) + "' WHERE numeroFiche='" + dataActeDM[ligne][0] + "'";

                                //   StringEscapeUtils.escapeJava
                                Statement stm = con.createStatement();
                                stm.executeUpdate(requete);
                                a.getSortieHaut().setVisible(false);
                                a.getButtonSaveSortie().setVisible(false);
                                dataActeDM[ligne][2] = "true";
                                String columnsActeDM[] = {"Date", "CR", "lettre sortie"};
                                a.getTableauActeDm().setModel(new DefaultTableModel(dataActeDM, columnsActeDM) {

                                    @Override
                                    public boolean isCellEditable(int row, int column) {
                                        //Only the third column
                                        return false;
                                    }
                                });

                                LocalDate sortieService = LocalDate.now();
                                String sortie = "";

                                if (sortieService.getMonthValue() < 10) {
                                    if (sortieService.getDayOfMonth() < 10) {
                                        sortie = "0" + sortieService.getDayOfMonth() + "/0" + sortieService.getMonthValue() + "/" + sortieService.getYear();
                                    } else {
                                        sortie = "" + sortieService.getDayOfMonth() + "/0" + sortieService.getMonthValue() + "/" + sortieService.getYear();
                                    }
                                } else {
                                    if (sortieService.getDayOfMonth() < 10) {
                                        sortie = "0" + sortieService.getDayOfMonth() + "/" + sortieService.getMonthValue() + "/" + sortieService.getYear();
                                    } else {
                                        sortie = "" + sortieService.getDayOfMonth() + "/" + sortieService.getMonthValue() + "/" + sortieService.getYear();
                                    }
                                }

                                requete = "UPDATE DM SET dateSortie ='" + sortie + "' WHERE numeroSejour='" + dataDMHide[ligne][2] + "'";
                                stm.executeUpdate(requete);

                                dataDM[ligne][1] = sortie;
                                String columnsDM[] = {"Date d'entr??e", "Date de sortie"};
                                a.getTableauDM().setModel(new DefaultTableModel(dataDM, columnsDM) {

                                    @Override
                                    public boolean isCellEditable(int row, int column) {
                                        //Only the third column
                                        return false;
                                    }
                                });

                                a.getAccueil().validate();
                                a.getAccueil().repaint();

                            }

                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });

            a.getButtonSaveObs().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    try {
                        String url = "jdbc:mysql://hugofarcy.ddns.net:3306/SIH?autoReconnect=true&useSSL=false";
                        String user = "DEV";
                        String password = "SIH-mmlh2022";

                        Connection con = DriverManager.getConnection(url, user, password);

                        String requete = "UPDATE fichesDM SET observations ='" + (h.expect(a.getObservations2().getText())) + "' WHERE numeroFiche='" + dataActeDM[ligne][0] + "'";

                        //   StringEscapeUtils.escapeJava
                        Statement stm = con.createStatement();
                        stm.executeUpdate(requete);

                        a.getButtonSaveObs().setVisible(false);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }
            });

            a.getButtonSavePres().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    try {
                        String url = "jdbc:mysql://hugofarcy.ddns.net:3306/SIH?autoReconnect=true&useSSL=false";
                        String user = "DEV";
                        String password = "SIH-mmlh2022";

                        Connection con = DriverManager.getConnection(url, user, password);

                        String requete = "UPDATE fichesDM SET prescriptions ='" + (h.expect(a.getPrescription2().getText())) + "' WHERE numeroFiche='" + dataActeDM[ligne][0] + "'";

                        //   StringEscapeUtils.escapeJava
                        Statement stm = con.createStatement();
                        stm.executeUpdate(requete);

                        a.getButtonSavePres().setVisible(false);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }
            });

            a.getButtonSaveSortie().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    try {
                        String url = "jdbc:mysql://hugofarcy.ddns.net:3306/SIH?autoReconnect=true&useSSL=false";
                        String user = "DEV";
                        String password = "SIH-mmlh2022";

                        Connection con = DriverManager.getConnection(url, user, password);

                        String requete = "UPDATE fichesDM SET lettreDeSortie ='" + (h.expect(a.getLettreSortie().getText())) + "' WHERE numeroFiche='" + dataActeDM[ligne][0] + "'";

                        //   StringEscapeUtils.escapeJava
                        Statement stm = con.createStatement();
                        stm.executeUpdate(requete);
                        a.getSortieHaut().setVisible(false);
                        dataActeDM[ligne][1] = "true";
                        String columnsActeDM[] = {"Date", "CR", "lettre sortie"};
                        a.getTableauActeDm().setModel(new DefaultTableModel(dataActeDM, columnsActeDM) {

                            @Override
                            public boolean isCellEditable(int row, int column) {
                                //Only the third column
                                return false;
                            }

                        });

                        LocalDate sortieService = LocalDate.now();
                        String sortie = "";

                        if (sortieService.getMonthValue() < 10) {
                            if (sortieService.getDayOfMonth() < 10) {
                                sortie = "0" + sortieService.getDayOfMonth() + "/0" + sortieService.getMonthValue() + "/" + sortieService.getYear();
                            } else {
                                sortie = "" + sortieService.getDayOfMonth() + "/0" + sortieService.getMonthValue() + "/" + sortieService.getYear();
                            }
                        } else {
                            if (sortieService.getDayOfMonth() < 10) {
                                sortie = "0" + sortieService.getDayOfMonth() + "/" + sortieService.getMonthValue() + "/" + sortieService.getYear();
                            } else {
                                sortie = "" + sortieService.getDayOfMonth() + "/" + sortieService.getMonthValue() + "/" + sortieService.getYear();
                            }
                        }

                        requete = "UPDATE DM SET dateSortie ='" + sortie + "' WHERE numeroSejour='" + dataDMHide[ligne][2] + "'";
                        stm.executeUpdate(requete);

                        dataDM[ligne][1] = sortie;
                        String columnsDM[] = {"Date d'entr??e", "Date de sortie"};
                        a.getTableauDM().setModel(new DefaultTableModel(dataDM, columnsDM) {

                            @Override
                            public boolean isCellEditable(int row, int column) {
                                //Only the third column
                                return false;
                            }
                        });

                        a.getAccueil().validate();
                        a.getAccueil().repaint();
                        a.getButtonSaveSortie().setVisible(false);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });

            a.getButtonSaveOp().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    try {
                        String url = "jdbc:mysql://hugofarcy.ddns.net:3306/SIH?autoReconnect=true&useSSL=false";
                        String user = "DEV";
                        String password = "SIH-mmlh2022";

                        Connection con = DriverManager.getConnection(url, user, password);

                        String requete = "UPDATE fichesDM SET operations ='" + (h.expect(a.getOperationInfo().getText())) + "' WHERE numeroFiche='" + dataActeDM[ligne][0] + "'";

                        //   StringEscapeUtils.escapeJava
                        Statement stm = con.createStatement();
                        stm.executeUpdate(requete);

                        a.getButtonSaveOp().setVisible(false);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });

            a.getButtonSaveRes().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    try {
                        String url = "jdbc:mysql://hugofarcy.ddns.net:3306/SIH?autoReconnect=true&useSSL=false";
                        String user = "DEV";
                        String password = "SIH-mmlh2022";

                        Connection con = DriverManager.getConnection(url, user, password);

                        String requete = "UPDATE fichesDM SET resultats ='" + (h.expect(a.getResultatInfo().getText())) + "' WHERE numeroFiche='" + dataActeDM[ligne][0] + "'";

                        //   StringEscapeUtils.escapeJava
                        Statement stm = con.createStatement();
                        stm.executeUpdate(requete);

                        a.getButtonSaveRes().setVisible(false);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });

            a.getModifLoc().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent me) {

                    SwingUtilities.invokeLater(new ModifierLocalisationCtrl(ipp, a, acc, loc));

                }
            });

            a.getButtonResultatRadio().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent me) {

                    try {
                        // FrameClient client = new FrameClient();
                        new ServeurTest(acc).setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(AccueilCtrl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            });

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
//    
//    public void trierDM(){
//    
//    
//    }

    public Sexe creerSexe(String sexe) {
        Sexe s = null;
        if (sexe.equals("HOMME")) {
            s = Sexe.HOMME;
        } else if (sexe.equals(("M"))) {
            s = Sexe.HOMME;
        } else if (sexe.equals(("FEMME"))) {
            s = Sexe.FEMME;
        } else if (sexe.equals(("F"))) {
            s = Sexe.FEMME;
        }
        return s;
    }

    public Date CreerDateNaissanceString(String date) {
        Date d = null;

        int jour = Integer.parseInt("" + date.charAt(0) + date.charAt(1));
        int mois = Integer.parseInt("" + date.charAt(3) + date.charAt(4));
        int annee = Integer.parseInt("" + date.charAt(6) + date.charAt(7) + date.charAt(8) + date.charAt(9));

        d = new Date(jour, mois, annee);
        return d;
    }

    public void recherche() {

        String s = a.getBarreRecherche().getText();
        String dataRecherche[][] = new String[taille][7];
        String columns[] = {"IPP", "Nom", "Pr??nom", "Date de Naissance", "Sexe", "Chambre", "Service de localisation"};
        int k = 0;
        for (int i = 0; i < taille; i++) {
            if (a.getChoix().getSelectedItem().equals("Nom")) {
                s = s.toUpperCase();
                if (dataTable[i][1].contains(s)) {

                    dataRecherche[k][0] = dataTable[i][0];
                    dataRecherche[k][1] = dataTable[i][1];
                    dataRecherche[k][2] = dataTable[i][2];
                    dataRecherche[k][3] = dataTable[i][3];
                    dataRecherche[k][4] = dataTable[i][4];
                    dataRecherche[k][5] = dataTable[i][5];
                    dataRecherche[k][6] = dataTable[i][6];

                    k++;

                    model = new DefaultTableModel(dataRecherche, columns) {

                        @Override
                        public boolean isCellEditable(int row, int column) {
                            //Only the third column
                            return false;
                        }
                    };
                    a.getTableau().setModel(model);

                } else if (s.equals("")) {
                    model = new DefaultTableModel(dataTable, columns) {

                        @Override
                        public boolean isCellEditable(int row, int column) {
                            //Only the third column
                            return false;
                        }
                    };
                    a.getTableau().setModel(model);
                }

            } else {

                if (dataTable[i][2].contains(s)) {

                    dataRecherche[k][0] = dataTable[i][0];
                    dataRecherche[k][1] = dataTable[i][1];
                    dataRecherche[k][2] = dataTable[i][2];
                    dataRecherche[k][3] = dataTable[i][3];
                    dataRecherche[k][4] = dataTable[i][4];
                    dataRecherche[k][5] = dataTable[i][5];
                    dataRecherche[k][6] = dataTable[i][6];
                    k++;

                    model = new DefaultTableModel(dataRecherche, columns) {

                        @Override
                        public boolean isCellEditable(int row, int column) {
                            //Only the third column
                            return false;
                        }
                    };
                    a.getTableau().setModel(model);

                } else if (s.equals("")) {
                    model = new DefaultTableModel(dataTable, columns) {

                        @Override
                        public boolean isCellEditable(int row, int column) {
                            //Only the third column
                            return false;
                        }
                    };
                    a.getTableau().setModel(model);
                }
            }

        }
    }

    public void MAJTblDMA() {
        try {

// REMPLIR LE TABLEAU DES DMAs    
            String url = "jdbc:mysql://hugofarcy.ddns.net:3306/SIH?autoReconnect=true&useSSL=false";
            String user = "DEV";
            String password = "SIH-mmlh2022";

            Connection con = DriverManager.getConnection(url, user, password);

            String query = "SELECT COUNT(*) FROM DMA WHERE IPPatient=" + ipp;
            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);

            taille = 0;

            if (res.next()) {
                taille = res.getInt("COUNT(*)");
            }

            dataDMA = new String[taille][3];
            String columnsDMA[] = {"Date d'entr??e", "Date de sortie", "Num??ro de s??jour"};

            query = "SELECT * FROM DMA WHERE IPPatient=" + ipp;

            res = stm.executeQuery(query);
            int i = 0;
            while (res.next()) {

                String dated = res.getString("dateEntree");
                String sejour = res.getString("numeroSejour");
                String datef = res.getString("dateSortie");

                dataDMA[i][0] = dated;
                dataDMA[i][1] = datef;
                dataDMA[i][2] = sejour;

                i++;
            }

            a.getPrescriptionDMA().setText("");
            a.getLettreSortieDMA().setText("");
            a.getDetailsDMA().setVisible(false);

            a.getTableauDMA().setModel(new DefaultTableModel(dataDMA, columnsDMA) {

                @Override
                public boolean isCellEditable(int row, int column) {
                    //Only the third column
                    return false;
                }
            });

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean contains(String[][] t, String s, int j) {
        boolean b = false;
        int size = t.length;
        String ipp = s;

        for (int i = 0; i < size; i++) {
            String a = t[i][j];
            b = ipp.equals(a);
            if (b) {
                return b;
            }

        }

        return b;
    }

    public String affichageLoc(String s) {
        if (s.equals("")) {
            return s;
        } else {
            String l = s.substring(1, 5);

            return (l);
        }
    }

    public String affichageSpe(String s) {
        if (s.equals("")) {
            return s;
        } else {
            String l = s.substring(5);

            return (l);
        }
    }

    public void MAJTableauPatient() {
        try {
            String url = "jdbc:mysql://hugofarcy.ddns.net:3306/SIH?autoReconnect=true&useSSL=false";
            String user = "DEV";
            String password = "SIH-mmlh2022";

            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            String query = "";

            switch (p.getPoste()) {

                case PHService:
                    query = "SELECT COUNT(DISTINCT IPP)  FROM patient JOIN (SELECT * FROM fichesDM JOIN PHS ON(PHreferent=ID) WHERE PHS.service=\"" + p.getNomService() + "\" )AS J  ON IPP=IPPatient";
                    a.getObservations2().setEditable(true);
                    a.getPrescription2().setEditable(true);
                    a.getOperationInfo().setEditable(true);
                    a.getResultatInfo().setEditable(true);
                    a.getAjoutPat().setVisible(false);

                    break;

                case PHAnesthesiste:
                    query = "SELECT COUNT(DISTINCT IPP)  FROM patient JOIN (SELECT * FROM fichesDM JOIN PHS ON(PHreferent=ID) WHERE PHS.service=\"" + p.getNomService() + "\" )AS J  ON IPP=IPPatient";
                    a.getObservations2().setEditable(true);
                    a.getPrescription2().setEditable(true);
                    a.getFicheOperation().setVisible(false);
                    a.getResultatInfo().setEditable(true);
                    a.getAjoutPat().setVisible(false);
                    break;

                case PHMedicoTechnique:
                    query = "SELECT COUNT(DISTINCT IPP) F FROM patient JOIN (SELECT * FROM fichesDM JOIN PHS ON(PHreferent=ID) WHERE PHS.service=\"" + p.getNomService() + "\" )AS J  ON IPP=IPPatient";
                    a.getObservations2().setEditable(true);
                    a.getResultatInfo().setEditable(true);
                    a.getFichePrescription().setVisible(false);
                    a.getFicheOperation().setVisible(false);
                    a.getAjoutPat().setVisible(false);
                    break;

                case SecretaireAdministrative:
                    query = "SELECT COUNT(DISTINCT IPP) FROM patient";
                    a.getAjoutPat().setVisible(true);
                    break;

                case SecretaireMedicale:
                    //query = "SELECT COUNT(DISTINCT IPP) FROM patient JOIN (SELECT * FROM fichesDM JOIN PHS ON(PHreferent=ID) WHERE PHS.service=\"" + p.getNomService() + "\" )AS J  ON IPP=IPPatient";
                    query = "SELECT COUNT(DISTINCT IPP) FROM patient";
                    a.getAjoutPat().setVisible(false);
                    break;

            }

            ResultSet res = stm.executeQuery(query);

            taille = 0;

            if (res.next()) {
                taille = res.getInt("COUNT(DISTINCT IPP)");
            }

            String data[][] = new String[taille][9];
            String columns[] = {"IPP", "Nom", "Pr??nom", "Date de Naissance", "Sexe", "Chambre", "Service de localisation"};

            dataTable = new String[taille][7];

            switch (p.getPoste()) {

                case PHService:
                    query = "SELECT * FROM patient JOIN (SELECT * FROM fichesDM JOIN PHS ON(PHreferent=ID) WHERE PHS.service=\"" + p.getNomService() + "\" )AS J  ON IPP=IPPatient ";

// query = "SELECT * FROM patient JOIN fichesDM ON IPP=IPPatient WHERE PHreferent='" + p.getLogin() + "'";
                    break;

                case PHAnesthesiste:
                    query = "SELECT * FROM patient JOIN (SELECT * FROM fichesDM JOIN PHS ON(PHreferent=ID) WHERE PHS.service=\"" + p.getNomService() + "\" )AS J  ON IPP=IPPatient ";
                    break;

                case PHMedicoTechnique:
                    query = "SELECT * FROM patient JOIN (SELECT * FROM fichesDM JOIN PHS ON(PHreferent=ID) WHERE PHS.service=\"" + p.getNomService() + "\" )AS J  ON IPP=IPPatient ";
                    break;

                case SecretaireAdministrative:
                    query = "SELECT * FROM patient ";

                    break;

                case SecretaireMedicale:
                    //  query = "SELECT * FROM patient JOIN (SELECT * FROM fichesDM JOIN PHS ON(PHreferent=ID) WHERE PHS.service=\"" + p.getNomService() + "\" )AS J  ON IPP=IPPatient ";
                    query = "SELECT * FROM patient ";
                    break;

            }

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

                if (contains(dataTable, IPP, 0)) {

                    continue;
                } else {
                    data[i][0] = IPP;
                    dataTable[i][0] = IPP;
                    data[i][1] = nom_marital;
                    dataTable[i][1] = nom_marital;
                    data[i][2] = nom_usuel;
                    data[i][3] = prenom;
                    dataTable[i][2] = prenom;
                    data[i][4] = dateNaissance;
                    dataTable[i][3] = dateNaissance;
                    data[i][5] = sexe;
                    dataTable[i][4] = sexe;
                    data[i][6] = adresse;
                    data[i][7] = localisation;
                    dataTable[i][5] = affichageLoc(localisation);
                    dataTable[i][6] = affichageSpe(localisation);
                    data[i][8] = medGen;

                    i++;
                }

                a.getTableau().setModel(new DefaultTableModel(dataTable, columns) {

                    @Override
                    public boolean isCellEditable(int row, int column) {
                        //Only the third column
                        return false;
                    }
                });

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void MAJDetailDM() {
        try {
            String url = "jdbc:mysql://hugofarcy.ddns.net:3306/SIH?autoReconnect=true&useSSL=false";
            String user = "DEV";
            String password = "SIH-mmlh2022";

            Connection con = DriverManager.getConnection(url, user, password);
            String query = "SELECT COUNT(*) FROM fichesDM WHERE IPPatient=" + ipp;
            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);

            int taille = 0;

            if (res.next()) {
                taille = res.getInt("COUNT(*)");
            }

            String dataDMF[][] = new String[taille][5];
            //           String columns[] = {"observations", "prescription", "operations", "resultats"};

            query = "SELECT * FROM fichesDM WHERE IPPatient=" + ipp + " AND numeroFiche=" + numFiche;
            System.out.println(query);
            res = stm.executeQuery(query);
            int i = 0;
            while (res.next()) {

                String obs2 = res.getString("observations");
                String pres2 = res.getString("prescriptions");
                String op2 = res.getString("operations");
                String resul2 = res.getString("resultats");
                String lettre = res.getString("lettreDeSortie");

                dataDMF[i][0] = obs2;
                dataDMF[i][1] = pres2;
                dataDMF[i][2] = op2;
                dataDMF[i][3] = resul2;
                dataDMF[i][4] = lettre;

                i++;
            }

            String observations = dataDMF[0][0];
            String prescriptions = dataDMF[0][1];
            String operations = dataDMF[0][2];
            String resultats = dataDMF[0][3];
            String lettre = dataDMF[0][4];

            fiche = new FichesDM(patient, observations, prescriptions, operations, resultats, lettre);
            fiche.setObservations(dataDMF[0][0]);
            fiche.setPrescriptions(dataDMF[0][1]);
            fiche.setOperations(dataDMF[0][2]);
            fiche.setResultats(dataDMF[0][3]);
            fiche.setLettreDeSortie(dataDMF[0][4]);

            a.getObservations2().setText(fiche.getObservations());
            a.getPrescription2().setText(fiche.getPrescriptions());
            a.getOperationInfo().setText(fiche.getOperations());
            a.getResultatInfo().setText(fiche.getResultats());
            a.getLettreSortie().setText(fiche.getLettreDeSortie());

            a.getPanelDetail().add(a.getDetailsDM());
            a.getDetailsDM().setVisible(true);
            a.getAccueil().validate();
            a.getAccueil().repaint();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public String[][] getData() {
        return data;
    }

    public void setData(String[][] data) {
        this.data = data;
    }

}
