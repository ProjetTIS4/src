/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import NF.Date;
import NF.FichesDM;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    private String s;
    private String dataDMHide[][];
    private String sej;

    private DefaultTableModel model;

    public AccueilCtrl(Personnel p) {
        this.a = new AccueilGUI();
        this.p = p;
    }

    @Override
    public void run() {
        s = "";

        /// Récupération de la table Patient ///
        try {
            String url = "jdbc:mysql://hugofarcy.ddns.net:3306/SIH?autoReconnect=true&useSSL=false";
            String user = "DEV";
            String password = "SIH-mmlh2022";

            Connection con = DriverManager.getConnection(url, user, password);
            Statement stm = con.createStatement();
            String query = "";

            switch (p.getPoste()) {

                case PHService:
                    query = "SELECT COUNT(DISTINCT IPP) FROM patient JOIN fichesDM ON IPP=IPPatient WHERE PHreferent='" + p.getLogin() + "'";

                    break;

                case PHAnesthesiste:
                    query = "SELECT COUNT(DISTINCT IPP) FROM patient JOIN fichesDM ON IPP=IPPatient WHERE PHreferent='" + p.getLogin() + "'";

                    break;

                case PHMedicoTechnique:
                    query = "SELECT COUNT(DISTINCT IPP) FROM patient JOIN fichesDM ON IPP=IPPatient WHERE PHreferent='" + p.getLogin() + "'";

                    break;

                case SecretaireAdministrative:
                    query = "SELECT COUNT(DISTINCT IPP) FROM patient";

                    break;

                case SecretaireMedicale:
                    query = "SELECT COUNT(DISTINCT IPP) FROM patient JOIN (SELECT * FROM fichesDM JOIN PHS ON(PHreferent=ID) WHERE PHS.service=\"" + p.getNomService() + "\" )AS J  ON IPP=IPPatient";

                    break;

            }

            ResultSet res = stm.executeQuery(query);

            taille = 0;

            if (res.next()) {
                taille = res.getInt("COUNT(DISTINCT IPP)");
            }

            String data[][] = new String[taille][9];
            String columns[] = {"IPP", "Nom", "Prénom", "Date de Naissance", "Sexe", "Localisation"};

            dataTable = new String[taille][6];

            switch (p.getPoste()) {

                case PHService:
                    query = "SELECT * FROM patient JOIN fichesDM ON IPP=IPPatient WHERE PHreferent='" + p.getLogin() + "'";
                    break;

                case PHAnesthesiste:
                    query = "SELECT * FROM patient JOIN fichesDM ON IPP=IPPatient WHERE PHreferent='" + p.getLogin() + "'";
                    break;

                case PHMedicoTechnique:
                    query = "SELECT * FROM patient JOIN fichesDM ON IPP=IPPatient WHERE PHreferent='" + p.getLogin() + "'";
                    break;

                case SecretaireAdministrative:
                    query = "SELECT * FROM patient ";

                    break;

                case SecretaireMedicale:
                    query = "SELECT * FROM patient JOIN (SELECT * FROM fichesDM JOIN PHS ON(PHreferent=ID) WHERE PHS.service=\"" + p.getNomService() + "\" )AS J  ON IPP=IPPatient ";

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
                    dataTable[i][5] = localisation;
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

            //////// Régler la taille de la fenêtre et permettre d'arrêter le programme à la fermeture de la fenêtre
            a.getAccueil().setDefaultCloseOperation(EXIT_ON_CLOSE);
            a.getAccueil().setBounds(0, 20, 1200, 900);
            a.getAccueil().setVisible(true);
            Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
            int longueur = tailleMoniteur.width * 2 / 3;
            int hauteur = tailleMoniteur.height * 2 / 3;
//régler la taille de JFrame à 2/3 la taille de l'écran
            a.getAccueil().setSize(longueur, hauteur);

            ////////// Panel Haut /////////////
            if (p.getPoste() == Personnel.Poste.PHService || p.getPoste() == Personnel.Poste.PHAnesthesiste || p.getPoste() == Personnel.Poste.PHMedicoTechnique) {

                a.getPresentation().setText("Bienvenue Dr. " + p.getNom().toUpperCase() + " " + p.getPrenom());
                a.getPresentation2().setText("" + p.getNomService());

            } else if (p.getPoste() == Personnel.Poste.SecretaireAdministrative) {
                a.getPresentation().setText("Bienvenue " + p.getNom().toUpperCase() + " " + p.getPrenom());
                a.getPresentation2().setText("Secrétaire administrative");
            } else if (p.getPoste() == Personnel.Poste.SecretaireMedicale) {
                a.getPresentation().setText("Bienvenue " + p.getNom().toUpperCase() + " " + p.getPrenom());
                a.getPresentation2().setText("Secrétaire médicale - " + p.getNomService());
            }

// Listener de déconnexion
            a.getDeconnexion().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    String[] choix ={"Oui","Non"};
                    int input = JOptionPane.showConfirmDialog(a.getAccueil(), "Etes vous sûr ?","Confirmation",YES_NO_OPTION,WARNING_MESSAGE);
                   if (input==0){
                    a.getAccueil().setVisible(false);
                    SwingUtilities.invokeLater(new ConnexionCtrl());}
                }
            });

            a.getTableau().addMouseListener(new MouseAdapter() {

                public void mouseClicked(MouseEvent me) {

                    if (me.getClickCount() == 1) {
                        a.getTableauActeDm().setModel(new DefaultTableModel());
                        a.getAjoutActe().setVisible(false);

                        int ligne = a.getTableau().getSelectedRow();
                        Object cellule = a.getTableau().getValueAt(ligne, 0);
                        s = "" + cellule;

                        int k = 0;
                        while (data[k][0].equals(s) == false && k < data.length - 1) {

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

                        a.getPanelMessage().setVisible(false);
                        if (p.getPoste().equals(Poste.SecretaireAdministrative)) {

                            a.getTp().add("DMA", a.getDMA());
                        } else if (p.getPoste().equals(Poste.SecretaireMedicale)) {
                            a.getTp().add("DM", a.getDM());

                        } else {
                            a.getTp().add("DM", a.getDM());
                            a.getTp().add("DMA", a.getDMA());
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
                            String query = "SELECT COUNT(*) FROM DM WHERE IPPatient=" + s;
                            Statement stm = con.createStatement();
                            ResultSet res = stm.executeQuery(query);

                            taille = 0;

                            if (res.next()) {
                                taille = res.getInt("COUNT(*)");
                            }

                            String dataDM[][] = new String[taille][2];
                            dataDMHide = new String[taille][3];
                            String columnsDM[] = {"Date ", "Date de fin"};

                            query = "SELECT * FROM DM WHERE IPPatient=" + s;

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
                            a.getDetailsDM().setVisible(false);

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
            );
            a.getTableauDM().addMouseListener(new MouseAdapter() {

                public void mouseClicked(MouseEvent me) {

                    if (me.getClickCount() == 1) {
                        int ligne = a.getTableauDM().getSelectedRow();
                        System.out.println(ligne);
                        a.getAjoutActe().setVisible(true);
                        sej = dataDMHide[ligne][2];

                        try {

                            // REMPLIR LE TABLEAU DES ACTES DMs   
                            String query = "SELECT COUNT(*) FROM fichesDM WHERE IPPatient=" + s + " AND numeroSejour=" + sej;

                            Statement stm = con.createStatement();
                            ResultSet res = stm.executeQuery(query);

                            System.out.println(s);

                            int taille = 0;

                            if (res.next()) {
                                taille = res.getInt("COUNT(*)");
                            }

                            String dataActeDM[][] = new String[taille][8];

                            String columns[] = {"Date", "CR", "lettre sortie"};

                            query = "SELECT * FROM fichesDM WHERE IPPatient=" + s;
                            res = stm.executeQuery(query);
                            int i = 0;
                            while (res.next()) {

                                String resul = res.getString("resultats");
                                String sejour = res.getString("numeroSejour");
                                String lettre = res.getString("lettreDeSortie");
                                String num = res.getString("numeroFiche");

                                if (sejour.equals(dataDMHide[ligne][2])) {

                                    dataActeDM[i][0] = num;
                                    if (resul != "") {
                                        dataActeDM[i][1] = "true";
                                    } else {
                                        dataActeDM[i][1] = "VIDE";
                                    }
                                    if (lettre != "") {
                                        dataActeDM[i][2] = "true";
                                    } else {
                                        dataActeDM[i][2] = "VIDE";
                                    }
                                }

                                i++;
                            }

                            ipp = s;
                            a.getTableauActeDm().setModel(new DefaultTableModel(dataActeDM, columns) {

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

            a.getAjoutActe().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent me) {

                    SwingUtilities.invokeLater(new ActeCtrl(ipp, a, p, sej));
                }
            });

            //Listener sur le bouton "+" pour ajouter un DMA
            a.getAjoutDMA().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent me) {

                    SwingUtilities.invokeLater(new AjoutDMACtrl(ipp, a));
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
                        int ligne = a.getTableauActeDm().getSelectedRow();
                        Object cellule = a.getTableauActeDm().getValueAt(ligne, 0);

                        String s = "" + cellule;

                        try {
                            String query = "SELECT COUNT(*) FROM fichesDM WHERE IPPatient=" + ipp;
                            Statement stm = con.createStatement();
                            ResultSet res = stm.executeQuery(query);

                            int taille = 0;

                            if (res.next()) {
                                taille = res.getInt("COUNT(*)");
                            }

                            String dataDMF[][] = new String[taille][4];
                            //           String columns[] = {"observations", "prescription", "operations", "resultats"};

                            query = "SELECT * FROM fichesDM WHERE IPPatient=" + ipp + " AND numeroFiche=" + s;
                            res = stm.executeQuery(query);
                            int i = 0;
                            while (res.next()) {

                                String obs2 = res.getString("observations");
                                String pres2 = res.getString("prescriptions");
                                String op2 = res.getString("operations");
                                String resul2 = res.getString("resultats");

                                dataDMF[i][0] = obs2;
                                dataDMF[i][1] = pres2;
                                dataDMF[i][2] = op2;
                                dataDMF[i][3] = resul2;

                                i++;
                            }

                            String observations = dataDMF[0][0];
                            String prescriptions = dataDMF[0][1];
                            String operations = dataDMF[0][2];
                            String resultats = dataDMF[0][3];

                            fiche = new FichesDM(patient, observations, prescriptions, operations, resultats);
                            fiche.setObservations(dataDMF[0][0]);
                            fiche.setPrescriptions(dataDMF[0][1]);
                            fiche.setOperations(dataDMF[0][2]);
                            fiche.setResultats(dataDMF[0][3]);

                            a.getObservations2().setText(fiche.getObservations());
                            a.getPrescription2().setText(fiche.getPrescriptions());
                            a.getOperationInfo().setText(fiche.getOperations());
                            a.getResultatInfo().setText(fiche.getResultats());

                            a.getPanelDetail().add(a.getDetailsDM());
                            a.getDetailsDM().setVisible(true);
                            a.getAccueil().validate();
                            a.getAccueil().repaint();

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }

                    }
                }
            }
            );

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
        String dataRecherche[][] = new String[taille][5];
        String columns[] = {"IPP", "Nom", "Prénom", "Date de Naissance", "Sexe"};
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
//        int i = 0;
//        while (b != true || i < size - 1) {
//            String a = t[i][j];
//            b = ipp.equals(a);
//            System.out.println(a);
//            System.out.println(b);
//            i++;
//        }

        return b;
    }

}
