/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

/**
 *
 * @author lenal
 */
public class AccueilGUI {

//// Variable pour la couleur des fenêtres
    private static final Color LIGHT_BLUE = new Color(100, 180, 200);

//// Panel
    private JFrame accueil;
   private JPanel panelFin;
   private JPanel panelDroit;
   private JPanel panelGauche;
   private JPanel panelHaut;
   private JSplitPane splitPan;
   private JPanel prez;
   private JPanel panHistorique;
   private JScrollPane t;
   private JPanel panelMessage;
   private JTabbedPane tp;
   private JPanel panelDMHaut;
   private JPanel panelInfoPatient;
   private JPanel panelTest;
   private JPanel patientNom;
   private JPanel pPrenom;
   private JPanel patientSexe;
   private JPanel patientDate;
   private JPanel patientAdresse;
   private JPanel panelListe;
   private JScrollPane tDM;
   private JPanel panelDetail;
   private JPanel panelFiche;
   private JScrollPane obs;
   private JPanel ficheObservations;
   private JScrollPane pres;
   private JPanel fichePrescription;
  private  JScrollPane op;
  private  JPanel ficheOperation;
  private  JScrollPane result;
   private JPanel ficheResultat;
   private JSplitPane DM;
   private JPanel panelDMAHaut; //Création du Panel du haut de la partie DMA
   private JPanel panelInfoPatient2; //Création du Panel contenant les informations du Patient
   private JPanel panelTest2;
   private JPanel patientNomDMA;
   private JPanel pPrenomDMA;
   private JPanel patientSexeDMA;
   private JPanel patientDateDMA;
   private JPanel patientAdresseDMA;
   private JPanel panelListe2;
   private JScrollPane tDMA;
   private JPanel panelDetail2;
  private  JPanel panelFicheDMA;
  private  JSplitPane DMA;

   private GridBagConstraints gbc;

//// Haut
 private   ImageIcon image;
  private  Image img;
  private  Image newimg;
 private   JButton deconnexion;
 private   JLabel presentation;
 private   JLabel presentation2;

//// Gauche 
  private  TitledBorder titre3;
    private JTable tableau;

//// Droite DM
    private ImageIcon iconeF;
    private ImageIcon iconeH;

   private JLabel messageArrive;
   private TitledBorder titleInfo;

    // Informations du patient 
   private Image img2;
  private  Image newimg2;
  private  JLabel image2;
  private  Image imgF;
  private  Image newimgF;
 private   JLabel nom;
 private   JLabel nom2;
 private   JLabel prenom;
 private   JLabel prenom2;
 private   JLabel sexe;
 private   JLabel sexeInfo;
 private   JLabel date;
 private   JLabel dateInfo;
  private  JLabel adresse;
  private  JLabel adresseInfo;

    // Tableau des DMs
   private TitledBorder titleListe;
 private   JTable tableauDM;

    //Détails des DMs
   private TitledBorder titleDetail;
  private  JTextArea observations2;
  private  TitledBorder titleObs;
 private   JTextArea prescription2;
 private   TitledBorder titlePresc;
 private   JTextArea operationInfo;
 private   TitledBorder titleOp;
 private   JTextArea resultatInfo;
 private   TitledBorder titleRes;

   private TitledBorder title;

//// Droite DMA
  private  TitledBorder titleInfo2;
 private   Image img2DMA;
 private   Image newimg2DMA;
 private   JLabel image2DMA;
 private   Image imgFDMA;
 private   Image newimgFDMA;

    //Informations du patient
  private  JLabel nomDMA;
  private  JLabel nom2DMA;
  private  JLabel prenomDMA;
  private  JLabel prenom2DMA;
  private  JLabel sexeDMA;
  private  JLabel sexeInfoDMA;
  private  JLabel dateDMA;
  private  JLabel dateInfoDMA;
  private  JLabel adresseDMA;
  private  JLabel adresseInfoDMA;

    // Tableau des DMAs
  private  TitledBorder titleListe2;
  private  JTable tableauDMA;

    //Détails des DMAs
  private  TitledBorder titleDetail2;

  private  TitledBorder title2;

    public AccueilGUI() {
        accueil = new JFrame("Accueil");
        panelFin = new JPanel(new BorderLayout());
        panelDroit = new JPanel(new BorderLayout());
        panelGauche = new JPanel(new BorderLayout());
        panelHaut = new JPanel(new BorderLayout());
        splitPan = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT, panelGauche, panelDroit);
        prez = new JPanel(new GridLayout(2, 1));
        tp = new JTabbedPane();
        panelTest = new JPanel(new GridBagLayout());
        panHistorique = new JPanel(new BorderLayout());
        panelMessage = new JPanel(new GridBagLayout());
        panelDMHaut = new JPanel((new GridLayout(1, 2)));
        panelInfoPatient = new JPanel(); //Création du Panel contenant les informations du Patient
        patientNom = new JPanel();
        pPrenom = new JPanel();
        patientSexe = new JPanel();
        patientDate = new JPanel();
        patientAdresse = new JPanel();
        panelListe = new JPanel(new BorderLayout());
        panelDetail = new JPanel(new BorderLayout());
        panelFiche = new JPanel(new GridLayout(2, 2));
        obs = new JScrollPane();
        ficheObservations = new JPanel(new BorderLayout());
        pres = new JScrollPane();
        fichePrescription = new JPanel(new BorderLayout());
        op = new JScrollPane();
        ficheOperation = new JPanel(new BorderLayout());
        result = new JScrollPane();
        ficheResultat = new JPanel(new BorderLayout());
        DM = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelDMHaut, panelDetail);   //Création du Panel DM
        panelDMAHaut = new JPanel((new GridLayout(1, 2)));  //Création du Panel du haut de la partie DMA
        panelInfoPatient2 = new JPanel(); //Création du Panel contenant les informations du Patient
        panelTest2 = new JPanel(new GridBagLayout());
        patientNomDMA = new JPanel();
        pPrenomDMA = new JPanel();
        patientSexeDMA = new JPanel();
        patientDateDMA = new JPanel();
        patientAdresseDMA = new JPanel();
        panelListe2 = new JPanel(new BorderLayout()); //Création du Panel contenant la liste des DMAs du patient 
        tDMA = new JScrollPane(tableauDMA);
        panelDetail2 = new JPanel(new BorderLayout()); //Création du Panel avec les détails du DMA sur lequel on a cliqué
        panelFicheDMA = new JPanel(new GridLayout(2, 2));
        DMA = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelDMAHaut, panelDetail2);

        splitPan.setResizeWeight(0.2); 
        
        gbc = new GridBagConstraints();

// Panel Haut //
        image = new ImageIcon("src/Annexes/deco.jpg");
        img = image.getImage(); // Convertissemnt pour pouvoir redimensionner
        newimg = img.getScaledInstance(60, 32, java.awt.Image.SCALE_SMOOTH); // On choisit la taille de l'image
        image = new ImageIcon(newimg); // On reconvertit

        deconnexion = new JButton(image);
        deconnexion.setContentAreaFilled(false);
        deconnexion.setBorderPainted(false);
        deconnexion.setToolTipText("Cliquez ici pour vous déconnecter");

        presentation = new JLabel();
        presentation2 = new JLabel();
        presentation.setHorizontalAlignment(SwingConstants.CENTER);
        presentation.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
        presentation2.setHorizontalAlignment(SwingConstants.CENTER);
        presentation2.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));

////////////////////////////Panel Gauche ////////////////////////////
        ///////////////// Panel Historique /////////////////
        titre3 = BorderFactory.createTitledBorder("Historique des visites");
        panHistorique.setBorder(titre3);
        tableau = new JTable();
        t = new JScrollPane(tableau);
        t.setOpaque(true);

////////////////////////////Panel Droit ////////////////////////////
        messageArrive = new JLabel("Veuillez cliquer sur un patient pour voir ses informations apparaître ici "); //Le texte "Nom d'utilisateur :"
        messageArrive.setFont(new Font("Bookman Old Style", Font.PLAIN, 18)); //On modifie la police et la taille de l'écriture

///////////////// Panel DM /////////////////
        //Création du Panel du haut de la partie DM
        //Création du Panel contenant les informations du Patient
        titleInfo = BorderFactory.createTitledBorder("informations du patient");
        panelInfoPatient.setBorder(titleInfo);

        iconeH = new ImageIcon("src/Annexes/homme.png");

        img2 = iconeH.getImage(); // Convertissemnt pour pouvoir redimensionner
        newimg2 = img2.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // On choisit la taille de l'image
        iconeH = new ImageIcon(newimg2); // On reconvertit
        image2 = new JLabel(iconeH);

        iconeF = new ImageIcon("src/Annexes/femme.png");
        imgF = iconeF.getImage(); // Convertissemnt pour pouvoir redimensionner
        newimgF = imgF.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // On choisit la taille de l'image     
        iconeF = new ImageIcon(newimgF); // On reconvertit

// Nom
        nom = new JLabel("Nom : ");
        nom.setFont(new Font("Cambria", Font.PLAIN, 18));
        nom2 = new JLabel();
        patientNom.setLayout(new BoxLayout(patientNom, BoxLayout.X_AXIS));

// Prénom
        prenom = new JLabel("Prénom :");
        prenom.setFont(new Font("Cambria", Font.PLAIN, 18));
        prenom2 = new JLabel();
        pPrenom.setLayout(new BoxLayout(pPrenom, BoxLayout.X_AXIS));

//Sexe
        sexe = new JLabel("Sexe : ");
        sexe.setFont(new Font("Cambria", Font.PLAIN, 18));
        sexeInfo = new JLabel();
        patientSexe.setLayout(new BoxLayout(patientSexe, BoxLayout.X_AXIS));

//Date de naissance
        date = new JLabel("Date de naissance :");
        date.setFont(new Font("Cambria", Font.PLAIN, 18));
        dateInfo = new JLabel();
        patientDate.setLayout(new BoxLayout(patientDate, BoxLayout.X_AXIS));

//Adresse
        adresse = new JLabel("Adresse :");
        adresse.setFont(new Font("Cambria", Font.PLAIN, 18));
        adresseInfo = new JLabel();
        patientAdresse.setLayout(new BoxLayout(patientAdresse, BoxLayout.X_AXIS));

//Création du Panel contenant la liste des DMs du patient 
        titleListe = BorderFactory.createTitledBorder("Liste des DMs");
        panelListe.setBorder(titleListe);

        tableauDM = new JTable();
        tDM = new JScrollPane(tableauDM);
        tDM.setOpaque(true);

//Création du Panel avec les détails du DM sur lequel on a cliqué
        titleDetail = BorderFactory.createTitledBorder("Détails de ce DM");
        panelDetail.setBorder(titleDetail);

// Observations
        observations2 = new JTextArea();
        observations2.setLineWrap(true);
        observations2.setEditable(false);
        obs.setViewportView(observations2);
        titleObs = BorderFactory.createTitledBorder("Observations");
        ficheObservations.setBorder(titleObs);

// Prescription
        prescription2 = new JTextArea();
        prescription2.setLineWrap(true);
        prescription2.setEditable(false);
        pres.setViewportView(prescription2);
        titlePresc = BorderFactory.createTitledBorder("Prescriptions");
        fichePrescription.setBorder(titlePresc);

//Opération
        operationInfo = new JTextArea();
        operationInfo.setLineWrap(true);
        operationInfo.setEditable(false);
        op.setViewportView(operationInfo);
        titleOp = BorderFactory.createTitledBorder("Opérations");
        ficheOperation.setBorder(titleOp);

//Résultats
        resultatInfo = new JTextArea();
        resultatInfo.setLineWrap(true);
        resultatInfo.setEditable(false);
        result.setViewportView(resultatInfo);
        titleRes = BorderFactory.createTitledBorder("Résultats");
        ficheResultat.setBorder(titleRes);

//Création du Panel DM
        title = BorderFactory.createTitledBorder("informations générales");
        DM.setBorder(title);

///////////////// Panel DMA /////////////////
        //Création du Panel contenant les informations du Patient
        titleInfo2 = BorderFactory.createTitledBorder("informations du patient");
        panelInfoPatient2.setBorder(titleInfo2);

//Image
        iconeH = new ImageIcon("src/Annexes/homme.png");
        img2DMA = iconeH.getImage(); // Convertissemnt pour pouvoir redimensionner
        newimg2DMA = img2DMA.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // On choisit la taille de l'image
        iconeH = new ImageIcon(newimg2DMA); // On reconvertit
        image2DMA = new JLabel(iconeH);

        iconeF = new ImageIcon("src/Annexes/femme.png");
        imgFDMA = iconeF.getImage(); // Convertissemnt pour pouvoir redimensionner
        newimgFDMA = imgFDMA.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // On choisit la taille de l'image     
        iconeF = new ImageIcon(newimgFDMA); // On reconvertit

// Nom
        nomDMA = new JLabel("Nom : ");
        nomDMA.setFont(new Font("Cambria", Font.PLAIN, 18));
        nom2DMA = new JLabel();
        patientNomDMA.setLayout(new BoxLayout(patientNomDMA, BoxLayout.X_AXIS));

// Prénom
        prenomDMA = new JLabel("Prénom :");
        prenom.setFont(new Font("Cambria", Font.PLAIN, 18));
        prenom2DMA = new JLabel();
        pPrenomDMA.setLayout(new BoxLayout(pPrenomDMA, BoxLayout.X_AXIS));

//Sexe
        sexeDMA = new JLabel("Sexe : ");
        sexe.setFont(new Font("Cambria", Font.PLAIN, 18));
        sexeInfoDMA = new JLabel();
        patientSexeDMA.setLayout(new BoxLayout(patientSexeDMA, BoxLayout.X_AXIS));

//Date de naissance
        dateDMA = new JLabel("Date de naissance :");
        date.setFont(new Font("Cambria", Font.PLAIN, 18));
        dateInfoDMA = new JLabel();
        patientDateDMA.setLayout(new BoxLayout(patientDateDMA, BoxLayout.X_AXIS));

//Adresse
        adresseDMA = new JLabel("Adresse :");
        adresseDMA.setFont(new Font("Cambria", Font.PLAIN, 18));
        adresseInfoDMA = new JLabel();
        patientAdresseDMA.setLayout(new BoxLayout(patientAdresseDMA, BoxLayout.X_AXIS));

//Création du Panel contenant la liste des DMAs du patient 
        titleListe2 = BorderFactory.createTitledBorder("Liste des DMAs");
        panelListe2.setBorder(titleListe2);
        tableauDMA = new JTable();
        tDMA.setOpaque(true);

//Création du Panel avec les détails du DMA sur lequel on a cliqué
        titleDetail2 = BorderFactory.createTitledBorder("Détails de ce DMA");
        panelDetail2.setBorder(titleDetail2);

//Nature des Résultats
//            JTextArea resultatInfoDMA = new JTextArea(ficheDMA.getPrestations());
//            resultatInfoDMA.setLineWrap(true);
//            resultatInfoDMA.setEditable(false);
//            JScrollPane resultDMA = new JScrollPane();
//            resultDMA.setViewportView(resultatInfoDMA);
//            JPanel ficheResultatDMA = new JPanel(new BorderLayout());
//            TitledBorder titleResDMA = BorderFactory.createTitledBorder("Nature des résultats");
//            ficheResultatDMA.setBorder(titleResDMA);
//            ficheResultatDMA.add(resultDMA);
//            panelFicheDMA.add(ficheResultatDMA);
//            ficheResultatDMA.setBackground(LIGHT_BLUE);
//Création du Panel DMA
        
        title2 = BorderFactory.createTitledBorder("informations générales");
        DMA.setBorder(title2);

///////////////////// On ajoute les éléments les uns dans les autres ///////////////////// 
        prez.add(presentation);
        prez.add(presentation2);
        panHistorique.add(t, BorderLayout.CENTER);

        panelMessage.add(messageArrive);
        panelDroit.add(panelMessage, BorderLayout.CENTER);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(50, 0, 5, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panelMessage.add(messageArrive, gbc); //A revoir le gbc n'est peut-être plus nécessaire. 

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(00, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;

        panelTest.add(image2, gbc);

        gbc.gridy = 1;
        gbc.ipadx = 0;
        gbc.insets = new Insets(20, 20, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;

        patientNom.add(nom);
        patientNom.add(nom2);
        panelTest.add(patientNom, gbc);

        pPrenom.add(prenom);
        pPrenom.add(prenom2);
        gbc.insets = new Insets(0, 20, 0, 0);
        gbc.gridy = 2;
        panelTest.add(pPrenom, gbc);

        patientSexe.add(sexe);
        patientSexe.add(sexeInfo);
        gbc.gridy = 3;
        panelTest.add(patientSexe, gbc);

        patientDate.add(date);
        patientDate.add(dateInfo);
        gbc.gridy = 4;
        panelTest.add(patientDate, gbc);

        patientAdresse.add(adresse);
        patientAdresse.add(adresseInfo);
        gbc.gridy = 5;
        panelTest.add(patientAdresse, gbc);

        panelInfoPatient.add(panelTest);
        panelListe.add(tDM);

        panelDMHaut.add(panelInfoPatient);
        panelDMHaut.add(panelListe);
        panelDMHaut.setPreferredSize(new Dimension(200, 300));

        ficheObservations.add(obs);
        panelFiche.add(ficheObservations);

        fichePrescription.add(pres);
        panelFiche.add(fichePrescription);

        ficheOperation.add(op);
        panelFiche.add(ficheOperation);

        ficheResultat.add(result);
        panelFiche.add(ficheResultat);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panelTest2.add(image2DMA, gbc);

        patientNomDMA.add(nomDMA);
        patientNomDMA.add(nom2DMA);

        gbc.gridy = 1;
        gbc.ipadx = 0;
        gbc.insets = new Insets(20, 20, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        panelTest2.add(patientNomDMA, gbc);

        pPrenomDMA.add(prenomDMA);
        pPrenomDMA.add(prenom2DMA);

        gbc.insets = new Insets(0, 20, 0, 0);
        gbc.gridy = 2;
        panelTest2.add(pPrenomDMA, gbc);

        patientSexeDMA.add(sexeDMA);
        patientSexeDMA.add(sexeInfoDMA);

        gbc.gridy = 3;
        panelTest2.add(patientSexeDMA, gbc);

        patientDateDMA.add(dateDMA);
        patientDateDMA.add(dateInfoDMA);

        gbc.gridy = 4;
        panelTest2.add(patientDateDMA, gbc);

        patientAdresseDMA.add(adresseDMA);
        patientAdresseDMA.add(adresseInfoDMA);

        gbc.gridy = 5;
        panelTest2.add(patientAdresseDMA, gbc);

        panelInfoPatient2.add(panelTest2);
        panelListe2.add(tDMA);

        panelHaut.add(deconnexion, BorderLayout.WEST);
        panelHaut.add(prez, BorderLayout.CENTER);
        panelGauche.add(panHistorique);
        panelFin.add(panelHaut, BorderLayout.NORTH);
        panelFin.add(splitPan, BorderLayout.CENTER);

        accueil.add(panelFin);

        // Ajout des deux précédents panels au premier
        panelDMAHaut.add(panelInfoPatient2);
        panelDMAHaut.add(panelListe2);
        panelDMAHaut.setPreferredSize(new Dimension(200, 300));

        ///////////////////// On ajoute la couleur aux éléments ///////////////////// 
        panelHaut.setBackground(LIGHT_BLUE);
        prez.setBackground(LIGHT_BLUE);
      panelDroit.setBackground(LIGHT_BLUE);
        panHistorique.setBackground(LIGHT_BLUE);
       patientNom.setBackground(LIGHT_BLUE);
        panelInfoPatient.setBackground(LIGHT_BLUE);
        panelMessage.setBackground(LIGHT_BLUE);
        panelDMHaut.setBackground(LIGHT_BLUE);
        pPrenom.setBackground(LIGHT_BLUE);
        patientSexe.setBackground(LIGHT_BLUE);
        patientDate.setBackground(LIGHT_BLUE);
        patientAdresse.setBackground(LIGHT_BLUE);
        panelTest.setBackground(LIGHT_BLUE);
        panelListe.setBackground(LIGHT_BLUE);
        tableauDM.setBackground(LIGHT_BLUE);
        tDM.setBackground(LIGHT_BLUE);
        panelDetail.setBackground(LIGHT_BLUE);
        ficheObservations.setBackground(LIGHT_BLUE);
        fichePrescription.setBackground(LIGHT_BLUE);
        ficheOperation.setBackground(LIGHT_BLUE);
        DM.setBackground(LIGHT_BLUE);
        panelDMAHaut.setBackground(LIGHT_BLUE);
        panelInfoPatient2.setBackground(LIGHT_BLUE);
        patientNomDMA.setBackground(LIGHT_BLUE);
        pPrenomDMA.setBackground(LIGHT_BLUE);
        patientSexeDMA.setBackground(LIGHT_BLUE);
        patientDateDMA.setBackground(LIGHT_BLUE);
        patientAdresseDMA.setBackground(LIGHT_BLUE);
        panelTest2.setBackground(LIGHT_BLUE);
        panelListe2.setBackground(LIGHT_BLUE);
        panelDetail2.setBackground(LIGHT_BLUE);
        DMA.setBackground(LIGHT_BLUE);

        
        t.setBackground(LIGHT_BLUE);
        tDMA.setBackground(LIGHT_BLUE);
        tableau.setBackground(LIGHT_BLUE);
        tableauDMA.setBackground(LIGHT_BLUE);


        ficheResultat.setBackground(LIGHT_BLUE);
    }

    public JFrame getAccueil() {
        return accueil;
    }

    public void setAccueil(JFrame accueil) {
        this.accueil = accueil;
    }

    public JPanel getPanelFin() {
        return panelFin;
    }

    public void setPanelFin(JPanel panelFin) {
        this.panelFin = panelFin;
    }

    public JPanel getPanelDroit() {
        return panelDroit;
    }

    public void setPanelDroit(JPanel panelDroit) {
        this.panelDroit = panelDroit;
    }

    public JPanel getPanelGauche() {
        return panelGauche;
    }

    public void setPanelGauche(JPanel panelGauche) {
        this.panelGauche = panelGauche;
    }

    public JPanel getPanelHaut() {
        return panelHaut;
    }

    public void setPanelHaut(JPanel panelHaut) {
        this.panelHaut = panelHaut;
    }

    public JSplitPane getSplitPan() {
        return splitPan;
    }

    public void setSplitPan(JSplitPane splitPan) {
        this.splitPan = splitPan;
    }

    public JPanel getPrez() {
        return prez;
    }

    public void setPrez(JPanel prez) {
        this.prez = prez;
    }

    public JPanel getPanHistorique() {
        return panHistorique;
    }

    public void setPanHistorique(JPanel panHistorique) {
        this.panHistorique = panHistorique;
    }

    public JScrollPane getT() {
        return t;
    }

    public void setT(JScrollPane t) {
        this.t = t;
    }

    public JPanel getPanelMessage() {
        return panelMessage;
    }

    public void setPanelMessage(JPanel panelMessage) {
        this.panelMessage = panelMessage;
    }

    public JTabbedPane getTp() {
        return tp;
    }

    public void setTp(JTabbedPane tp) {
        this.tp = tp;
    }

    public JPanel getPanelDMHaut() {
        return panelDMHaut;
    }

    public void setPanelDMHaut(JPanel panelDMHaut) {
        this.panelDMHaut = panelDMHaut;
    }

    public JPanel getPanelInfoPatient() {
        return panelInfoPatient;
    }

    public void setPanelInfoPatient(JPanel panelInfoPatient) {
        this.panelInfoPatient = panelInfoPatient;
    }

    public JPanel getPanelTest() {
        return panelTest;
    }

    public void setPanelTest(JPanel panelTest) {
        this.panelTest = panelTest;
    }

    public JPanel getPatientNom() {
        return patientNom;
    }

    public void setPatientNom(JPanel patientNom) {
        this.patientNom = patientNom;
    }

    public JPanel getpPrenom() {
        return pPrenom;
    }

    public void setpPrenom(JPanel pPrenom) {
        this.pPrenom = pPrenom;
    }

    public JPanel getPatientSexe() {
        return patientSexe;
    }

    public void setPatientSexe(JPanel patientSexe) {
        this.patientSexe = patientSexe;
    }

    public JPanel getPatientDate() {
        return patientDate;
    }

    public void setPatientDate(JPanel patientDate) {
        this.patientDate = patientDate;
    }

    public JPanel getPatientAdresse() {
        return patientAdresse;
    }

    public void setPatientAdresse(JPanel patientAdresse) {
        this.patientAdresse = patientAdresse;
    }

    public JPanel getPanelListe() {
        return panelListe;
    }

    public void setPanelListe(JPanel panelListe) {
        this.panelListe = panelListe;
    }

    public JScrollPane gettDM() {
        return tDM;
    }

    public void settDM(JScrollPane tDM) {
        this.tDM = tDM;
    }

    public JPanel getPanelDetail() {
        return panelDetail;
    }

    public void setPanelDetail(JPanel panelDetail) {
        this.panelDetail = panelDetail;
    }

    public JPanel getPanelFiche() {
        return panelFiche;
    }

    public void setPanelFiche(JPanel panelFiche) {
        this.panelFiche = panelFiche;
    }

    public JScrollPane getObs() {
        return obs;
    }

    public void setObs(JScrollPane obs) {
        this.obs = obs;
    }

    public JPanel getFicheObservations() {
        return ficheObservations;
    }

    public void setFicheObservations(JPanel ficheObservations) {
        this.ficheObservations = ficheObservations;
    }

    public JScrollPane getPres() {
        return pres;
    }

    public void setPres(JScrollPane pres) {
        this.pres = pres;
    }

    public JPanel getFichePrescription() {
        return fichePrescription;
    }

    public void setFichePrescription(JPanel fichePrescription) {
        this.fichePrescription = fichePrescription;
    }

    public JScrollPane getOp() {
        return op;
    }

    public void setOp(JScrollPane op) {
        this.op = op;
    }

    public JPanel getFicheOperation() {
        return ficheOperation;
    }

    public void setFicheOperation(JPanel ficheOperation) {
        this.ficheOperation = ficheOperation;
    }

    public JScrollPane getResult() {
        return result;
    }

    public void setResult(JScrollPane result) {
        this.result = result;
    }

    public JPanel getFicheResultat() {
        return ficheResultat;
    }

    public void setFicheResultat(JPanel ficheResultat) {
        this.ficheResultat = ficheResultat;
    }

    public JSplitPane getDM() {
        return DM;
    }

    public void setDM(JSplitPane DM) {
        this.DM = DM;
    }

    public JPanel getPanelDMAHaut() {
        return panelDMAHaut;
    }

    public void setPanelDMAHaut(JPanel panelDMAHaut) {
        this.panelDMAHaut = panelDMAHaut;
    }

    public JPanel getPanelInfoPatient2() {
        return panelInfoPatient2;
    }

    public void setPanelInfoPatient2(JPanel panelInfoPatient2) {
        this.panelInfoPatient2 = panelInfoPatient2;
    }

    public JPanel getPanelTest2() {
        return panelTest2;
    }

    public void setPanelTest2(JPanel panelTest2) {
        this.panelTest2 = panelTest2;
    }

    public JPanel getPatientNomDMA() {
        return patientNomDMA;
    }

    public void setPatientNomDMA(JPanel patientNomDMA) {
        this.patientNomDMA = patientNomDMA;
    }

    public JPanel getpPrenomDMA() {
        return pPrenomDMA;
    }

    public void setpPrenomDMA(JPanel pPrenomDMA) {
        this.pPrenomDMA = pPrenomDMA;
    }

    public JPanel getPatientSexeDMA() {
        return patientSexeDMA;
    }

    public void setPatientSexeDMA(JPanel patientSexeDMA) {
        this.patientSexeDMA = patientSexeDMA;
    }

    public JPanel getPatientDateDMA() {
        return patientDateDMA;
    }

    public void setPatientDateDMA(JPanel patientDateDMA) {
        this.patientDateDMA = patientDateDMA;
    }

    public JPanel getPatientAdresseDMA() {
        return patientAdresseDMA;
    }

    public void setPatientAdresseDMA(JPanel patientAdresseDMA) {
        this.patientAdresseDMA = patientAdresseDMA;
    }

    public JPanel getPanelListe2() {
        return panelListe2;
    }

    public void setPanelListe2(JPanel panelListe2) {
        this.panelListe2 = panelListe2;
    }

    public JScrollPane gettDMA() {
        return tDMA;
    }

    public void settDMA(JScrollPane tDMA) {
        this.tDMA = tDMA;
    }

    public JPanel getPanelDetail2() {
        return panelDetail2;
    }

    public void setPanelDetail2(JPanel panelDetail2) {
        this.panelDetail2 = panelDetail2;
    }

    public JPanel getPanelFicheDMA() {
        return panelFicheDMA;
    }

    public void setPanelFicheDMA(JPanel panelFicheDMA) {
        this.panelFicheDMA = panelFicheDMA;
    }

    public JSplitPane getDMA() {
        return DMA;
    }

    public void setDMA(JSplitPane DMA) {
        this.DMA = DMA;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public void setGbc(GridBagConstraints gbc) {
        this.gbc = gbc;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public Image getNewimg() {
        return newimg;
    }

    public void setNewimg(Image newimg) {
        this.newimg = newimg;
    }

    public JButton getDeconnexion() {
        return deconnexion;
    }

    public void setDeconnexion(JButton deconnexion) {
        this.deconnexion = deconnexion;
    }

    public JLabel getPresentation() {
        return presentation;
    }

    public void setPresentation(JLabel presentation) {
        this.presentation = presentation;
    }

    public JLabel getPresentation2() {
        return presentation2;
    }

    public void setPresentation2(JLabel presentation2) {
        this.presentation2 = presentation2;
    }

    public TitledBorder getTitre3() {
        return titre3;
    }

    public void setTitre3(TitledBorder titre3) {
        this.titre3 = titre3;
    }

    public JTable getTableau() {
        return tableau;
    }

    public void setTableau(JTable tableau) {
        this.tableau = tableau;
    }

    public ImageIcon getIconeF() {
        return iconeF;
    }

    public void setIconeF(ImageIcon iconeF) {
        this.iconeF = iconeF;
    }

    public ImageIcon getIconeH() {
        return iconeH;
    }

    public void setIconeH(ImageIcon iconeH) {
        this.iconeH = iconeH;
    }

    public JLabel getMessageArrive() {
        return messageArrive;
    }

    public void setMessageArrive(JLabel messageArrive) {
        this.messageArrive = messageArrive;
    }

    public TitledBorder getTitleInfo() {
        return titleInfo;
    }

    public void setTitleInfo(TitledBorder titleInfo) {
        this.titleInfo = titleInfo;
    }

    public Image getImg2() {
        return img2;
    }

    public void setImg2(Image img2) {
        this.img2 = img2;
    }

    public Image getNewimg2() {
        return newimg2;
    }

    public void setNewimg2(Image newimg2) {
        this.newimg2 = newimg2;
    }

    public JLabel getImage2() {
        return image2;
    }

    public void setImage2(JLabel image2) {
        this.image2 = image2;
    }

    public Image getImgF() {
        return imgF;
    }

    public void setImgF(Image imgF) {
        this.imgF = imgF;
    }

    public Image getNewimgF() {
        return newimgF;
    }

    public void setNewimgF(Image newimgF) {
        this.newimgF = newimgF;
    }

    public JLabel getNom() {
        return nom;
    }

    public void setNom(JLabel nom) {
        this.nom = nom;
    }

    public JLabel getNom2() {
        return nom2;
    }

    public void setNom2(JLabel nom2) {
        this.nom2 = nom2;
    }

    public JLabel getPrenom() {
        return prenom;
    }

    public void setPrenom(JLabel prenom) {
        this.prenom = prenom;
    }

    public JLabel getPrenom2() {
        return prenom2;
    }

    public void setPrenom2(JLabel prenom2) {
        this.prenom2 = prenom2;
    }

    public JLabel getSexe() {
        return sexe;
    }

    public void setSexe(JLabel sexe) {
        this.sexe = sexe;
    }

    public JLabel getSexeInfo() {
        return sexeInfo;
    }

    public void setSexeInfo(JLabel sexeInfo) {
        this.sexeInfo = sexeInfo;
    }

    public JLabel getDate() {
        return date;
    }

    public void setDate(JLabel date) {
        this.date = date;
    }

    public JLabel getDateInfo() {
        return dateInfo;
    }

    public void setDateInfo(JLabel dateInfo) {
        this.dateInfo = dateInfo;
    }

    public JLabel getAdresse() {
        return adresse;
    }

    public void setAdresse(JLabel adresse) {
        this.adresse = adresse;
    }

    public JLabel getAdresseInfo() {
        return adresseInfo;
    }

    public void setAdresseInfo(JLabel adresseInfo) {
        this.adresseInfo = adresseInfo;
    }

    public TitledBorder getTitleListe() {
        return titleListe;
    }

    public void setTitleListe(TitledBorder titleListe) {
        this.titleListe = titleListe;
    }

    public JTable getTableauDM() {
        return tableauDM;
    }

    public void setTableauDM(JTable tableauDM) {
        this.tableauDM = tableauDM;
    }

    public TitledBorder getTitleDetail() {
        return titleDetail;
    }

    public void setTitleDetail(TitledBorder titleDetail) {
        this.titleDetail = titleDetail;
    }

    public JTextArea getObservations2() {
        return observations2;
    }

    public void setObservations2(JTextArea observations2) {
        this.observations2 = observations2;
    }

    public TitledBorder getTitleObs() {
        return titleObs;
    }

    public void setTitleObs(TitledBorder titleObs) {
        this.titleObs = titleObs;
    }

    public JTextArea getPrescription2() {
        return prescription2;
    }

    public void setPrescription2(JTextArea prescription2) {
        this.prescription2 = prescription2;
    }

    public TitledBorder getTitlePresc() {
        return titlePresc;
    }

    public void setTitlePresc(TitledBorder titlePresc) {
        this.titlePresc = titlePresc;
    }

    public JTextArea getOperationInfo() {
        return operationInfo;
    }

    public void setOperationInfo(JTextArea operationInfo) {
        this.operationInfo = operationInfo;
    }

    public TitledBorder getTitleOp() {
        return titleOp;
    }

    public void setTitleOp(TitledBorder titleOp) {
        this.titleOp = titleOp;
    }

    public JTextArea getResultatInfo() {
        return resultatInfo;
    }

    public void setResultatInfo(JTextArea resultatInfo) {
        this.resultatInfo = resultatInfo;
    }

    public TitledBorder getTitleRes() {
        return titleRes;
    }

    public void setTitleRes(TitledBorder titleRes) {
        this.titleRes = titleRes;
    }

    public TitledBorder getTitle() {
        return title;
    }

    public void setTitle(TitledBorder title) {
        this.title = title;
    }

    public TitledBorder getTitleInfo2() {
        return titleInfo2;
    }

    public void setTitleInfo2(TitledBorder titleInfo2) {
        this.titleInfo2 = titleInfo2;
    }

    public Image getImg2DMA() {
        return img2DMA;
    }

    public void setImg2DMA(Image img2DMA) {
        this.img2DMA = img2DMA;
    }

    public Image getNewimg2DMA() {
        return newimg2DMA;
    }

    public void setNewimg2DMA(Image newimg2DMA) {
        this.newimg2DMA = newimg2DMA;
    }

    public JLabel getImage2DMA() {
        return image2DMA;
    }

    public void setImage2DMA(JLabel image2DMA) {
        this.image2DMA = image2DMA;
    }

    public Image getImgFDMA() {
        return imgFDMA;
    }

    public void setImgFDMA(Image imgFDMA) {
        this.imgFDMA = imgFDMA;
    }

    public Image getNewimgFDMA() {
        return newimgFDMA;
    }

    public void setNewimgFDMA(Image newimgFDMA) {
        this.newimgFDMA = newimgFDMA;
    }

    public JLabel getNomDMA() {
        return nomDMA;
    }

    public void setNomDMA(JLabel nomDMA) {
        this.nomDMA = nomDMA;
    }

    public JLabel getNom2DMA() {
        return nom2DMA;
    }

    public void setNom2DMA(JLabel nom2DMA) {
        this.nom2DMA = nom2DMA;
    }

    public JLabel getPrenomDMA() {
        return prenomDMA;
    }

    public void setPrenomDMA(JLabel prenomDMA) {
        this.prenomDMA = prenomDMA;
    }

    public JLabel getPrenom2DMA() {
        return prenom2DMA;
    }

    public void setPrenom2DMA(JLabel prenom2DMA) {
        this.prenom2DMA = prenom2DMA;
    }

    public JLabel getSexeDMA() {
        return sexeDMA;
    }

    public void setSexeDMA(JLabel sexeDMA) {
        this.sexeDMA = sexeDMA;
    }

    public JLabel getSexeInfoDMA() {
        return sexeInfoDMA;
    }

    public void setSexeInfoDMA(JLabel sexeInfoDMA) {
        this.sexeInfoDMA = sexeInfoDMA;
    }

    public JLabel getDateDMA() {
        return dateDMA;
    }

    public void setDateDMA(JLabel dateDMA) {
        this.dateDMA = dateDMA;
    }

    public JLabel getDateInfoDMA() {
        return dateInfoDMA;
    }

    public void setDateInfoDMA(JLabel dateInfoDMA) {
        this.dateInfoDMA = dateInfoDMA;
    }

    public JLabel getAdresseDMA() {
        return adresseDMA;
    }

    public void setAdresseDMA(JLabel adresseDMA) {
        this.adresseDMA = adresseDMA;
    }

    public JLabel getAdresseInfoDMA() {
        return adresseInfoDMA;
    }

    public void setAdresseInfoDMA(JLabel adresseInfoDMA) {
        this.adresseInfoDMA = adresseInfoDMA;
    }

    public TitledBorder getTitleListe2() {
        return titleListe2;
    }

    public void setTitleListe2(TitledBorder titleListe2) {
        this.titleListe2 = titleListe2;
    }

    public JTable getTableauDMA() {
        return tableauDMA;
    }

    public void setTableauDMA(JTable tableauDMA) {
        this.tableauDMA = tableauDMA;
    }

    public TitledBorder getTitleDetail2() {
        return titleDetail2;
    }

    public void setTitleDetail2(TitledBorder titleDetail2) {
        this.titleDetail2 = titleDetail2;
    }

    public TitledBorder getTitle2() {
        return title2;
    }

    public void setTitle2(TitledBorder title2) {
        this.title2 = title2;
    }

}
