/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author lenal
 */
public class AccueilGUI {

//// Variable pour la couleur des fenêtres
    private static final Color LIGHT_BLUE = new Color(152, 208, 223);
    private static final Color GREY = new Color(241, 244, 244);

//// Panel
    private JFrame accueil;
    private JPanel panelFin; // Panel que l'on ajoutera dans la fenêtre, dans lequel on va mettre les panels de droite, gauche( grâce au splitPane) et haut
    private JPanel panelDroit;
    private JPanel panelGauche;
    private JPanel panelHaut;
    private JSplitPane splitPan; //Panel central qui split le panel de droite et celui de gauche

    private JPanel prez; // Panel avec le message de bienvenue

    private JPanel panPatients; // Panel avec la liste des patients
    private JScrollPane t;
    private JPanel panelMessage; // Panel de droite qui invite à cliquer sur un patient dans la liste
    private JTabbedPane tp; // Panel qui sépare le DM et le DMA en onglet 

    private JPanel panelRecherche;
    private JPanel panelRechercheDroit; // Panel contenant le bouton valider et le bouton retour
    //
//Côté DM
    private JPanel panelDMHaut;
    private JPanel panelInfoPatient;
    private JPanel panelTest;
    private JPanel patientNom;
    private JPanel pPrenom;
    private JPanel patientSexe;
    private JPanel patientDate;
    private JPanel patientAdresse;
    private JPanel panelDM;
    private JPanel panelListe;
    private JPanel panelPlus;
    private JScrollPane ScrollDM;
    private JScrollPane tActeDM;
    private JPanel panelDetail;
    private JPanel panelFiche;
    private JPanel panelSaveObs;
    private JPanel panelSavePres;
    private JPanel panelSaveOp;
    private JPanel panelSaveRes;
    private JPanel panelSaveSortie;
    private JScrollPane obs;
    private JPanel ficheObservations;
    private JScrollPane pres;
    private JPanel fichePrescription;
    private JScrollPane op;
    private JPanel ficheOperation;
    private JScrollPane result;
    private JPanel ficheResultat;
    private JSplitPane DM;
    private JTabbedPane detailsDM; // Panel qui sépare les observations, prescriptions, opérations et résultats du DM en onglet
    private JPanel panelSouthDM;
    private JPanel panelSortie;
    private JPanel sortieHaut;
    private JPanel prescriptionHaut;
    private JPanel resultatHaut;
    private JPanel modificationLoc;
    private JPanel modificationLoc2;
    //
//Côté DMA   
    private JPanel panelDMAHaut; //Création du Panel du haut de la partie DMA
    private JPanel panelInfoPatientDMA; //Création du Panel contenant les informations du Patient
    private JPanel panelTestDMA;
    private JPanel patientNomDMA;
    private JPanel panelDMA;
    private JPanel pPrenomDMA;
    private JPanel patientSexeDMA;
    private JPanel patientDateDMA;
    private JPanel patientAdresseDMA;
    private JPanel panelListeDMA;
    private JScrollPane tActeDMA;
    private JPanel panelPlusDMA;
    private JScrollPane tDMA;
    private JPanel panelDetailDMA;
    private JPanel panelFicheDMA;
    private JSplitPane DMA;
    private JPanel panelSouthDMA;
    private JScrollPane presDMA;
    private JPanel fichePrescriptionDMA;
    private JPanel panelSortieDMA;
    private JScrollPane scrollSortieDMA;
    private JTabbedPane detailsDMA; // Panel qui sépare les observations, prescriptions, opérations et résultats du DM en onglet
    private JPanel panelNouveauDMA;

    private GridBagConstraints gbc;

//// Haut
    private ImageIcon image;
    private Image img;
    private Image newimg;
    private JButton deconnexion;
    private JLabel presentation;
    private JLabel presentation2;

//// Gauche 
    // Barre de recherche
    private JTextField barreRecherche;
    private JButton rechercher;
    private JComboBox choix;
    private JButton retour;
    // Tableau patients
    private TitledBorder titre3;
    private JTable tableau;
    //Ajouter un patient
    private JButton ajoutPat;
    private ImageIcon plusPat;
    private Image plusImPat;
    private Image plusImFinPat;

//// Droite DM
    private ImageIcon iconeF;
    private ImageIcon iconeH;

    private JLabel messageArrive;
    private Border LoweredBevelBorderInfo;
    private TitledBorder titleInfo;

    // Informations du patient 
    private Image img2;
    private Image newimg2;
    private JLabel image2;
    private Image imgF;
    private Image newimgF;
    private JLabel nom;
    private JLabel nom2;
    private JLabel prenom;
    private JLabel prenom2;
    private JLabel sexe;
    private JLabel sexeInfo;
    private JLabel date;
    private JLabel dateInfo;
    private JLabel adresse;
    private JLabel adresseInfo;
    private Image imgLoc;
    private Image newimgLoc;
    private ImageIcon iconeLoc;
    private JButton modifLoc;

    // Tableau des  DM
    private Border LoweredBevelBorderDM;
    private TitledBorder titleDM;
    private JTable tableauDM;
    private JButton ajoutDM;
    private ImageIcon plusDM;
    private Image plusImDM;
    private Image plusImFinDM;

    // Tableau des Actes du DM
    private Border LoweredBevelBorderListe;
    private TitledBorder titleListe;
    private JTable tableauActeDm;
    private JButton ajoutActe;
    private ImageIcon plus;
    private Image plusIm;
    private Image plusImFin;

    //Détails des DMs
    private ImageIcon saveObs;
    private Image saveImObs;
    private Image saveImFinObs;
    private JButton buttonSaveObs;
    private Border LoweredBevelBorderDetail;
    private TitledBorder titleDetail;
    private JTextArea observations2;
    private Border LoweredBevelBorderObs;
    private TitledBorder titleObs;
    private ImageIcon savePres;
    private JLabel prescriptionRadio;
    private JButton buttonRadio;
    private Image saveImPres;
    private Image saveImFinPres;
    private JButton buttonSavePres;
    private JTextArea prescription2;
    private Border LoweredBevelBorderPres;
    private TitledBorder titlePresc;
    private ImageIcon saveOp;
    private Image saveImOp;
    private Image saveImFinOp;
    private JButton buttonSaveOp;
    private JTextArea operationInfo;
    private Border LoweredBevelBorderOp;
    private TitledBorder titleOp;
    private ImageIcon saveRes;
    private Image saveImRes;
    private Image saveImFinRes;
    private JButton buttonSaveRes;
    private JLabel resultatRadio;
    private JButton buttonResultatRadio;
    private JTextArea resultatInfo;
    private Border LoweredBevelBorderRes;
    private TitledBorder titleRes;

    private JTextArea lettreSortie;
    private JButton buttonSortie;
    private JTextArea ajoutLettreSortie;
    private Border LoweredBevelBorderSortie;
    private TitledBorder titleSortie;
    private JLabel informationsSortie;
    private ImageIcon saveSortie;
    private Image saveImSortie;
    private Image saveImFinSortie;
    private JButton buttonSaveSortie;
    private JScrollPane scrollSortie;

    private TitledBorder title;

//// Droite DMA
    private TitledBorder titleInfoDMA;
    private Image img2DMA;
    private Image newimg2DMA;
    private JLabel image2DMA;
    private Image imgFDMA;
    private Image newimgFDMA;

    //Informations du patient
    private Border LoweredBevelBorderPatientDMA;
    private JLabel nomDMA;
    private JLabel nom2DMA;
    private JLabel prenomDMA;
    private JLabel prenom2DMA;
    private JLabel sexeDMA;
    private JLabel sexeInfoDMA;
    private JLabel dateDMA;
    private JLabel dateInfoDMA;
    private JLabel adresseDMA;
    private JLabel adresseInfoDMA;

    //Nouveau DMA   
    private JLabel nouveauDMA;
    private JButton buttonNouveauDMA;

    // Tableau des DMAs
    private Border LoweredBevelBorderListeDMA;
    private Border LoweredBevelBorderDetailDMA;
    private TitledBorder titleListeActeDMA;
    private TitledBorder titleListeDMA;
    private JTable tableauDMA;

    // Tableau des Actes du DMA
    private Border LoweredBevelBorderDMA;
    private Border LoweredBevelBorderListeActeDMA;

    private JTable tableauActeDMA;
    private JButton ajoutActeDMA;
    private ImageIcon plusDMA;
    private Image plusImDMA;
    private Image plusImFinDMA;

    //Détails des DMAs
    private TitledBorder titleDetailDMA;
    private TitledBorder titleDMA;
    private JTextArea prescriptionDMA;
    private Border LoweredBevelBorderPresDMA;
    private TitledBorder titlePrescDMA;
    private JTextArea lettreSortieDMA;
    private Border LoweredBevelBorderSortieDMA;
    private TitledBorder titleSortieDMA;

    /**
     *
     */
    public AccueilGUI() {
        accueil = new JFrame("Accueil");
        Image icone = Toolkit.getDefaultToolkit().getImage("src/Annexes/Hubspital_logo_grand.png");
        accueil.setIconImage(icone);
        panelFin = new JPanel(new BorderLayout());
        panelDroit = new JPanel(new BorderLayout());
        panelGauche = new JPanel(new BorderLayout());
        panelHaut = new JPanel(new BorderLayout());
        splitPan = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelGauche, panelDroit);
        prez = new JPanel(new GridLayout(2, 1));
        tp = new JTabbedPane();
        panelTest = new JPanel(new GridBagLayout());

        panelTestDMA = new JPanel(new GridBagLayout());
        panPatients = new JPanel(new BorderLayout());
        panelMessage = new JPanel(new GridBagLayout());
        panelRecherche = new JPanel(new BorderLayout());
        panelRechercheDroit = new JPanel(new GridLayout(1, 2));
        resultatHaut = new JPanel(new FlowLayout());

//// Panel gauche
        barreRecherche = new JTextField("Tapez votre recherche ici...");
        rechercher = new JButton("🔍");
        choix = new JComboBox();
        retour = new JButton("↶");

        plusPat = new ImageIcon("src/Annexes/plus.png");
        plusImPat = plusPat.getImage(); // Convertissemnt pour pouvoir redimensionner
        plusImFinPat = plusImPat.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH); // On choisit la taille de l'image
        plusPat = new ImageIcon(plusImFinPat); // On reconvertit

        ajoutPat = new JButton(plusPat);
        ajoutPat.setContentAreaFilled(false);
        ajoutPat.setBorderPainted(true);
        ajoutPat.setToolTipText("Cliquez ici pour ajouter un nouveau patient");
        ajoutPat.setVisible(false);

////Côté DM
        panelDMHaut = new JPanel((new GridLayout(1, 2)));
        panelDM = new JPanel(new BorderLayout());

        ///
        panelInfoPatient = new JPanel(); //Création du Panel contenant les informations du Patient
        modificationLoc = new JPanel(new BorderLayout());
        modificationLoc2 = new JPanel(new BorderLayout());
        //
        patientNom = new JPanel();
        pPrenom = new JPanel();
        patientSexe = new JPanel();
        patientDate = new JPanel();
        patientAdresse = new JPanel();
        ///
        panelListe = new JPanel(new BorderLayout());
        panelPlus = new JPanel(new BorderLayout());
        panelSaveObs = new JPanel(new BorderLayout());
        panelSavePres = new JPanel(new BorderLayout());
        panelSaveOp = new JPanel(new BorderLayout());
        panelSaveRes = new JPanel(new BorderLayout());
        panelSaveSortie = new JPanel(new BorderLayout());
        ///
        panelDetail = new JPanel(new BorderLayout());
        detailsDM = new JTabbedPane();
        //
        // panelFiche = new JPanel(new GridLayout(2, 2));
        panelSouthDM = new JPanel(new BorderLayout());
        obs = new JScrollPane();
        ficheObservations = new JPanel(new BorderLayout());
        pres = new JScrollPane();
        fichePrescription = new JPanel(new BorderLayout());
        op = new JScrollPane();
        ficheOperation = new JPanel(new BorderLayout());
        result = new JScrollPane();
        scrollSortie = new JScrollPane();
        ficheResultat = new JPanel(new BorderLayout());
        panelSortie = new JPanel(new BorderLayout());
        sortieHaut = new JPanel(new FlowLayout());
        prescriptionHaut = new JPanel(new FlowLayout());
        //
        DM = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelDMHaut, panelSouthDM);   //Création du Panel DM
        //

////Côté DMA
        panelNouveauDMA = new JPanel(new FlowLayout());
        panelDMAHaut = new JPanel((new GridLayout(1, 2)));  //Création du Panel du haut de la partie DMA
        panelDMA = new JPanel(new BorderLayout());
        panelSouthDMA = new JPanel(new BorderLayout());
        panelInfoPatientDMA = new JPanel(); //Création du Panel contenant les informations du Patient

        //panelTest2 = new JPanel(new GridBagLayout());
        patientNomDMA = new JPanel();
        pPrenomDMA = new JPanel();
        patientSexeDMA = new JPanel();
        patientDateDMA = new JPanel();
        patientAdresseDMA = new JPanel();

        panelListeDMA = new JPanel(new BorderLayout());
        panelPlusDMA = new JPanel(new BorderLayout());

        panelListeDMA = new JPanel(new BorderLayout()); //Création du Panel contenant la liste des DMAs du patient 
        tDMA = new JScrollPane(tableauDMA);
        panelDetailDMA = new JPanel(new BorderLayout()); //Création du Panel avec les détails du DMA sur lequel on a cliqué
        detailsDMA = new JTabbedPane();
        panelFicheDMA = new JPanel(new GridLayout(2, 2));
        DMA = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelDMAHaut, panelSouthDMA);
        detailsDMA.setVisible(false);

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

////////////////////////////Panel Gauche ////////////////////////////////////////////////////////////////////////////////////
        ///////////////// Barre de recherche /////////////////
        barreRecherche.setForeground(Color.gray);
        choix.addItem("Nom");
        choix.addItem("Prénom");

        ///////////////// Panel liste de patients /////////////////
        titre3 = BorderFactory.createTitledBorder("Liste des patients");
        panPatients.setBorder(titre3);
        tableau = new JTable();
        tableau.getTableHeader().setReorderingAllowed(false);
        t = new JScrollPane(tableau);
        t.setOpaque(true);

////////////////////////////Panel Droit ////////////////////////////////////////////////////////////////////////////////////
        messageArrive = new JLabel("Veuillez cliquer sur un patient pour voir ses informations apparaître ici "); //Le texte "Nom d'utilisateur :"
        messageArrive.setFont(new Font("Bookman Old Style", Font.PLAIN, 18)); //On modifie la police et la taille de l'écriture

///////////////// Panel DM /////////////////
        //Création du Panel du haut de la partie DM
        //Création du Panel contenant les informations du Patient
        LoweredBevelBorderInfo = BorderFactory.createLoweredBevelBorder();
        titleInfo = BorderFactory.createTitledBorder(LoweredBevelBorderInfo, "informations du patient",
                TitledBorder.LEFT, TitledBorder.TOP
        );

        iconeLoc = new ImageIcon("src/Annexes/modification.png");

        imgLoc = iconeLoc.getImage(); // Convertissemnt pour pouvoir redimensionner
        newimgLoc = imgLoc.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH); // On choisit la taille de l'image
        iconeLoc = new ImageIcon(newimgLoc); // On reconvertit
        modifLoc = new JButton(iconeLoc);

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
        LoweredBevelBorderDM = BorderFactory.createLoweredBevelBorder();
        titleDM = BorderFactory.createTitledBorder(LoweredBevelBorderDM, "Dossier médical",
                TitledBorder.LEFT, TitledBorder.TOP
        );
        panelDM.setBorder(titleDM);

        tableauDM = new JTable();
        tableauDM.setAutoCreateRowSorter(true);
        tableauDM.getTableHeader().setReorderingAllowed(false);
        ScrollDM = new JScrollPane(tableauDM);
        ScrollDM.setOpaque(true);

        plusDM = new ImageIcon("src/Annexes/plus.png");
        plusImDM = plusDM.getImage(); // Convertissemnt pour pouvoir redimensionner
        plusImFinDM = plusImDM.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH); // On choisit la taille de l'image
        plusDM = new ImageIcon(plusImFinDM); // On reconvertit

        ajoutDM = new JButton(plusDM);
        ajoutDM.setContentAreaFilled(false);
        ajoutDM.setBorderPainted(true);
        ajoutDM.setToolTipText("Cliquez ici pour ajouter un nouveau DM");

//Création du Panel contenant la liste des actes dans un DM du patient 
        LoweredBevelBorderListe = BorderFactory.createLoweredBevelBorder();
        titleListe = BorderFactory.createTitledBorder(LoweredBevelBorderListe, "Liste des actes",
                TitledBorder.LEFT, TitledBorder.TOP
        );

        panelListe.setBorder(titleListe);

        tableauActeDm = new JTable();
        tActeDM = new JScrollPane(tableauActeDm);
        tActeDM.setOpaque(true);

        plus = new ImageIcon("src/Annexes/plus.png");
        plusIm = plus.getImage(); // Convertissemnt pour pouvoir redimensionner
        plusImFin = plusIm.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH); // On choisit la taille de l'image
        plus = new ImageIcon(plusImFin); // On reconvertit

        ajoutActe = new JButton(plus);
        ajoutActe.setContentAreaFilled(false);
        ajoutActe.setBorderPainted(true);
        ajoutActe.setToolTipText("Cliquez ici pour ajouter un nouvel acte");
        ajoutActe.setVisible(false);

//Création du Panel avec les détails du DM sur lequel on a cliqué
        LoweredBevelBorderDetail = BorderFactory.createLoweredBevelBorder();
        titleDetail = BorderFactory.createTitledBorder(LoweredBevelBorderDetail, "Détails de cet acte",
                TitledBorder.LEFT, TitledBorder.TOP
        );

        panelDetail.setBorder(titleDetail);

// Observations
        saveObs = new ImageIcon("src/Annexes/save.png");
        saveImObs = saveObs.getImage(); // Convertissemnt pour pouvoir redimensionner
        saveImFinObs = saveImObs.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH); // On choisit la taille de l'image
        saveObs = new ImageIcon(saveImFinObs); // On reconvertit
        buttonSaveObs = new JButton(saveObs);
        buttonSaveObs.setVisible(false);

        observations2 = new JTextArea();
        observations2.setMargin(new Insets(6, 6, 6, 6));
        observations2.setLineWrap(true);
        observations2.setEditable(false);
        obs.setViewportView(observations2);

        LoweredBevelBorderObs = BorderFactory.createLoweredBevelBorder();
        titleObs = BorderFactory.createTitledBorder(LoweredBevelBorderObs, "Observations",
                TitledBorder.LEFT, TitledBorder.TOP
        );
        ficheObservations.setBorder(titleObs);

// Prescription
        prescriptionRadio = new JLabel("Cliquez ici pour prescrire une radiographie : ");
        buttonRadio = new JButton("+");

        savePres = new ImageIcon("src/Annexes/save.png");
        saveImPres = savePres.getImage(); // Convertissemnt pour pouvoir redimensionner
        saveImFinPres = saveImPres.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH); // On choisit la taille de l'image
        savePres = new ImageIcon(saveImFinPres); // On reconvertit
        buttonSavePres = new JButton(savePres);
        buttonSavePres.setVisible(false);

        prescription2 = new JTextArea();
        prescription2.setMargin(new Insets(6, 6, 6, 6));
        prescription2.setLineWrap(true);
        prescription2.setEditable(false);
        pres.setViewportView(prescription2);

        LoweredBevelBorderPres = BorderFactory.createLoweredBevelBorder();
        titlePresc = BorderFactory.createTitledBorder(LoweredBevelBorderPres, "Prescriptions",
                TitledBorder.LEFT, TitledBorder.TOP
        );
        fichePrescription.setBorder(titlePresc);

//Opération
        saveOp = new ImageIcon("src/Annexes/save.png");
        saveImOp = saveOp.getImage(); // Convertissemnt pour pouvoir redimensionner
        saveImFinOp = saveImOp.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH); // On choisit la taille de l'image
        saveOp = new ImageIcon(saveImFinOp); // On reconvertit
        buttonSaveOp = new JButton(saveOp);
        buttonSaveOp.setVisible(false);

        operationInfo = new JTextArea();
        operationInfo.setMargin(new Insets(6, 6, 6, 6));
        operationInfo.setLineWrap(true);
        operationInfo.setEditable(false);
        op.setViewportView(operationInfo);
        LoweredBevelBorderOp = BorderFactory.createLoweredBevelBorder();
        titleOp = BorderFactory.createTitledBorder(LoweredBevelBorderOp, "Opérations",
                TitledBorder.LEFT, TitledBorder.TOP
        );
        ficheOperation.setBorder(titleOp);

//Résultats
        resultatRadio = new JLabel("Cliquez ici pour recevoir les résultats d'une radiographie : ");
        buttonResultatRadio = new JButton("+");
        saveRes = new ImageIcon("src/Annexes/save.png");
        saveImRes = saveRes.getImage(); // Convertissemnt pour pouvoir redimensionner
        saveImFinRes = saveImRes.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH); // On choisit la taille de l'image
        saveRes = new ImageIcon(saveImFinRes); // On reconvertit
        buttonSaveRes = new JButton(saveRes);
        buttonSaveRes.setVisible(false);

        resultatInfo = new JTextArea();
        resultatInfo.setMargin(new Insets(6, 6, 6, 6));
        resultatInfo.setLineWrap(true);
        resultatInfo.setEditable(false);
        result.setViewportView(resultatInfo);
        LoweredBevelBorderRes = BorderFactory.createLoweredBevelBorder();
        titleRes = BorderFactory.createTitledBorder(LoweredBevelBorderRes, "Résultats",
                TitledBorder.LEFT, TitledBorder.TOP
        );
        ficheResultat.setBorder(titleRes);

// Lettre de sortie 
        saveSortie = new ImageIcon("src/Annexes/save.png");
        saveImSortie = saveSortie.getImage(); // Convertissemnt pour pouvoir redimensionner
        saveImFinSortie = saveImSortie.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH); // On choisit la taille de l'image
        saveSortie = new ImageIcon(saveImFinSortie); // On reconvertit
        buttonSaveSortie = new JButton(saveSortie);
        buttonSaveSortie.setVisible(false);

        informationsSortie = new JLabel("Cliquez ici pour ajouter une lettre de sortie ou ajoutez la dans le cadre ci-dessous : ");

        buttonSortie = new JButton("+");
        //ajoutLettreSortie = new JTextArea();
        lettreSortie = new JTextArea();
        lettreSortie.setMargin(new Insets(6, 6, 6, 6));
        lettreSortie.setLineWrap(true);
        // lettreSortie.setEditable(false);
        scrollSortie.setViewportView(lettreSortie);
        LoweredBevelBorderSortie = BorderFactory.createLoweredBevelBorder();
        titleSortie = BorderFactory.createTitledBorder(LoweredBevelBorderSortie, "Lettre de sortie",
                TitledBorder.LEFT, TitledBorder.TOP
        );
        panelSortie.setBorder(titleSortie);

//Création du Panel DM
        title = BorderFactory.createTitledBorder("informations générales");
        DM.setBorder(title);

///////////////// Panel DMA /////////////////
        //Création du Panel contenant les informations du Patient
        LoweredBevelBorderPatientDMA = BorderFactory.createLoweredBevelBorder();
        titleInfoDMA = BorderFactory.createTitledBorder(LoweredBevelBorderPatientDMA, "informations du patient",
                TitledBorder.LEFT, TitledBorder.TOP
        );
        panelInfoPatientDMA.setBorder(titleInfoDMA);

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
        prenomDMA.setFont(new Font("Cambria", Font.PLAIN, 18));
        prenom2DMA = new JLabel();
        pPrenomDMA.setLayout(new BoxLayout(pPrenomDMA, BoxLayout.X_AXIS));

//Sexe
        sexeDMA = new JLabel("Sexe : ");
        sexeDMA.setFont(new Font("Cambria", Font.PLAIN, 18));
        sexeInfoDMA = new JLabel();
        patientSexeDMA.setLayout(new BoxLayout(patientSexeDMA, BoxLayout.X_AXIS));

//Date de naissance
        dateDMA = new JLabel("Date de naissance :");
        dateDMA.setFont(new Font("Cambria", Font.PLAIN, 18));
        dateInfoDMA = new JLabel();
        patientDateDMA.setLayout(new BoxLayout(patientDateDMA, BoxLayout.X_AXIS));

//Adresse
        adresseDMA = new JLabel("Adresse :");
        adresseDMA.setFont(new Font("Cambria", Font.PLAIN, 18));
        adresseInfoDMA = new JLabel();
        patientAdresseDMA.setLayout(new BoxLayout(patientAdresseDMA, BoxLayout.X_AXIS));

        // Création d'un nouveau DMA
        nouveauDMA = new JLabel("Cliquez ici pour ouvrir un nouveau DMA : ");
        buttonNouveauDMA = new JButton("Nouveau DMA");

//Création du Panel contenant la liste des DMAs du patient 
        LoweredBevelBorderDMA = BorderFactory.createLoweredBevelBorder();
        titleListeDMA = BorderFactory.createTitledBorder(LoweredBevelBorderDMA, "Dossier médical administratif",
                TitledBorder.LEFT, TitledBorder.TOP
        );
        panelDMA.setBorder(titleListeDMA);

//Création du Panel contenant la liste des DMAs du patient 
        LoweredBevelBorderListeActeDMA = BorderFactory.createLoweredBevelBorder();
        titleListeActeDMA = BorderFactory.createTitledBorder(LoweredBevelBorderListeActeDMA, "Liste des actes",
                TitledBorder.LEFT, TitledBorder.TOP
        );

        panelListeDMA.setBorder(titleListeActeDMA);

        tableauDMA = new JTable();
        tDMA = new JScrollPane(tableauDMA);
        tDMA.setOpaque(true);

        plusDMA = new ImageIcon("src/Annexes/plus.png");
        plusImDMA = plusDMA.getImage(); // Convertissemnt pour pouvoir redimensionner
        plusImFinDMA = plusImDMA.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH); // On choisit la taille de l'image
        plusDMA = new ImageIcon(plusImFinDMA); // On reconvertit

        ajoutActeDMA = new JButton(plusDMA);
        ajoutActeDMA.setContentAreaFilled(false);
        ajoutActeDMA.setBorderPainted(true);
        ajoutActeDMA.setToolTipText("Cliquez ici pour ajouter un nouvel DMA");
        ajoutActeDMA.setVisible(false);

        tableauActeDMA = new JTable();
        tActeDMA = new JScrollPane(tableauActeDMA);
        tActeDMA.setOpaque(true);

//Création du Panel avec les détails du DMA sur lequel on a cliqué
        LoweredBevelBorderDetailDMA = BorderFactory.createLoweredBevelBorder();
        titleDetailDMA = BorderFactory.createTitledBorder(LoweredBevelBorderDetailDMA, "Détails de cet acte",
                TitledBorder.LEFT, TitledBorder.TOP
        );

        panelDetailDMA.setBorder(titleDetailDMA);

//Nature des Résultats
// Prescription
        presDMA = new JScrollPane();
        fichePrescriptionDMA = new JPanel(new BorderLayout());
        prescriptionDMA = new JTextArea();
        prescriptionDMA.setMargin(new Insets(6, 6, 6, 6));
        prescriptionDMA.setLineWrap(true);
        prescriptionDMA.setEditable(false);
        presDMA.setViewportView(prescriptionDMA);

        LoweredBevelBorderPresDMA = BorderFactory.createLoweredBevelBorder();
        titlePrescDMA = BorderFactory.createTitledBorder(LoweredBevelBorderPresDMA, "Prescriptions",
                TitledBorder.LEFT, TitledBorder.TOP
        );
        fichePrescriptionDMA.setBorder(titlePrescDMA);

        // Lettre de sortie 
        scrollSortieDMA = new JScrollPane();
        panelSortieDMA = new JPanel(new BorderLayout());
        lettreSortieDMA = new JTextArea();
        lettreSortieDMA.setMargin(new Insets(6, 6, 6, 6));
        lettreSortieDMA.setLineWrap(true);
        scrollSortieDMA.setViewportView(lettreSortieDMA);
        LoweredBevelBorderSortieDMA = BorderFactory.createLoweredBevelBorder();
        titleSortieDMA = BorderFactory.createTitledBorder(LoweredBevelBorderSortieDMA, "Lettre de sortie",
                TitledBorder.LEFT, TitledBorder.TOP
        );
        panelSortieDMA.setBorder(titleSortieDMA);

//Création du Panel DMA
        titleDMA = BorderFactory.createTitledBorder("informations générales");
        DMA.setBorder(titleDMA);

        //Création du Panel avec les détails du DM sur lequel on a cliqué
//        LoweredBevelBorderDetail = BorderFactory.createLoweredBevelBorder();
//        titleDetail = BorderFactory.createTitledBorder(LoweredBevelBorderDetail, "Détails de cet acte",
//                TitledBorder.LEFT, TitledBorder.TOP
//        );
//        panelDetail.setBorder(titleDetail);
///////////////////// On ajoute les éléments les uns dans les autres ///////////////////// 
        prez.add(presentation);
        prez.add(presentation2); // Pourquoi y'en a deux ?
        panPatients.add(t, BorderLayout.CENTER);
        panPatients.add(ajoutPat, BorderLayout.SOUTH);

        panelMessage.add(messageArrive);
        panelDroit.add(panelMessage, BorderLayout.CENTER);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(50, 0, 5, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panelMessage.add(messageArrive, gbc); //A revoir le gbc n'est peut-être plus nécessaire. 

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;

        panelTest.add(image2, gbc);

        gbc.gridy = 1;
        gbc.ipadx = 0;
        gbc.insets = new Insets(20, 20, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;

        patientNom.add(nom); //ajoute le label "Nom:"
        patientNom.add(nom2); //ajoute le contenu du nom
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
        panelListe.add(tActeDM);
        panelDM.add(ScrollDM);
        panelDM.setBorder(titleDM);

        panelPlus.add(ajoutActe, BorderLayout.EAST);
        panelListe.add(panelPlus, BorderLayout.NORTH);

        //modificationLoc2.add(modificationLoc, BorderLayout.WEST);
        //panelInfoPatient.add(modificationLoc2,BorderLayout.WEST);
        panelDMHaut.add(panelInfoPatient);
        panelDMHaut.add(panelDM);
        panelDMHaut.setPreferredSize(new Dimension(200, 300));
        panelSouthDM.add(panelListe, BorderLayout.WEST);
        panelSouthDM.add(panelDetail, BorderLayout.CENTER);

        panelSaveObs.add(buttonSaveObs, BorderLayout.EAST);
        ficheObservations.add(obs, BorderLayout.CENTER);
        ficheObservations.add(panelSaveObs, BorderLayout.SOUTH);
        detailsDM.add("Observations", ficheObservations);

        panelSavePres.add(buttonSavePres, BorderLayout.EAST);
        prescriptionHaut.add(prescriptionRadio);
        prescriptionHaut.add(buttonRadio);
        fichePrescription.add(prescriptionHaut, BorderLayout.NORTH);
        fichePrescription.add(pres, BorderLayout.CENTER);
        fichePrescription.add(panelSavePres, BorderLayout.SOUTH);
        detailsDM.add("Prescriptions", fichePrescription);

        panelSaveOp.add(buttonSaveOp, BorderLayout.EAST);
        ficheOperation.add(op, BorderLayout.CENTER);
        ficheOperation.add(panelSaveOp, BorderLayout.SOUTH);
        detailsDM.add("Opérations", ficheOperation);

        panelSaveRes.add(buttonSaveRes, BorderLayout.EAST);
        resultatHaut.add(resultatRadio);
        resultatHaut.add(buttonResultatRadio);
        ficheResultat.add(resultatHaut, BorderLayout.NORTH);
        ficheResultat.add(result, BorderLayout.CENTER);
        ficheResultat.add(panelSaveRes, BorderLayout.SOUTH);
        detailsDM.add("Résultats", ficheResultat);

        panelSaveSortie.add(buttonSaveSortie, BorderLayout.EAST);
        sortieHaut.add(informationsSortie);
        sortieHaut.add(buttonSortie);
        panelSortie.add(sortieHaut, BorderLayout.NORTH);
        panelSortie.add(scrollSortie, BorderLayout.CENTER);
        panelSortie.add(panelSaveSortie, BorderLayout.SOUTH);
        detailsDM.add("Lettre de sortie", panelSortie);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panelTestDMA.add(image2DMA, gbc);

        patientNomDMA.add(nomDMA);
        patientNomDMA.add(nom2DMA);

        gbc.gridy = 1;
        gbc.ipadx = 0;
        gbc.insets = new Insets(20, 20, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        panelTestDMA.add(patientNomDMA, gbc);

        pPrenomDMA.add(prenomDMA);
        pPrenomDMA.add(prenom2DMA);
        gbc.insets = new Insets(0, 20, 0, 0);
        gbc.gridy = 2;
        panelTestDMA.add(pPrenomDMA, gbc);

        patientSexeDMA.add(sexeDMA);
        patientSexeDMA.add(sexeInfoDMA);
        gbc.gridy = 3;
        panelTestDMA.add(patientSexeDMA, gbc);

        patientDateDMA.add(dateDMA);
        patientDateDMA.add(dateInfoDMA);
        gbc.gridy = 4;
        panelTestDMA.add(patientDateDMA, gbc);

        patientAdresseDMA.add(adresseDMA);
        patientAdresseDMA.add(adresseInfoDMA);
        gbc.gridy = 5;
        panelTestDMA.add(patientAdresseDMA, gbc);

        panelNouveauDMA.add(nouveauDMA);
        panelNouveauDMA.add(buttonNouveauDMA);

        panelInfoPatientDMA.add(panelTestDMA);
        //panelDMA.add(tDMA);
        panelPlusDMA.add(ajoutActeDMA, BorderLayout.EAST);
        panelDMA.add(panelPlusDMA, BorderLayout.NORTH);
        panelListeDMA.add(tActeDMA);

        panelDMAHaut.add(panelInfoPatientDMA);
        panelDMAHaut.add(panelDMA);
        panelDMAHaut.setPreferredSize(new Dimension(200, 300));
        panelSouthDMA.add(panelListeDMA, BorderLayout.WEST);
        panelSouthDMA.add(panelDetailDMA, BorderLayout.CENTER);

        fichePrescriptionDMA.add(presDMA, BorderLayout.CENTER);
        detailsDMA.add("Prescriptions", fichePrescriptionDMA);

        panelSortieDMA.add(scrollSortieDMA, BorderLayout.CENTER);
        detailsDMA.add("Lettre de sortie", panelSortieDMA);

        panelHaut.add(deconnexion, BorderLayout.WEST);
        panelHaut.add(prez, BorderLayout.CENTER);
        panelGauche.add(panPatients);

        panelRechercheDroit.add(rechercher);
        panelRechercheDroit.add(retour);
        panelRecherche.add(barreRecherche, BorderLayout.CENTER);

        panelRecherche.add(panelRechercheDroit, BorderLayout.EAST);
        panelRecherche.add(choix, BorderLayout.WEST);
        panelGauche.add(panelRecherche, BorderLayout.NORTH);
        panelFin.add(panelHaut, BorderLayout.NORTH);
        panelFin.add(splitPan, BorderLayout.CENTER);

        accueil.add(panelFin);

        ///////////////////// On rend le fond des éléments transparents ///////////////////// 
        prez.setOpaque(false);
        //
        patientNom.setOpaque(false);
        patientSexe.setOpaque(false);
        patientDate.setOpaque(false);
        patientAdresse.setOpaque(false);
        pPrenom.setOpaque(false);
        panelTest.setOpaque(false); // Panel contenant les infos du patient pour que ce soit centré dans le panel info patient

//        ficheObservations.setOpaque(false);
//        fichePrescription.setOpaque(false);
//        ficheOperation.setOpaque(false);
//        ficheResultat.setOpaque(false);
        //
        patientNomDMA.setOpaque(false);
        pPrenomDMA.setOpaque(false);
        patientSexeDMA.setOpaque(false);
        patientDateDMA.setOpaque(false);
        patientAdresseDMA.setOpaque(false);
        panelTestDMA.setOpaque(false); // Panel contenant les infos du patient pour que ce soit centré dans le panel info patient
        //
        panelPlus.setOpaque(false);
        panelPlusDMA.setOpaque(false);
        panelRechercheDroit.setOpaque(false);
        sortieHaut.setOpaque(false);
        prescriptionHaut.setOpaque(false);
        resultatHaut.setOpaque(false);
        nouveauDMA.setOpaque(false);

        ///////////////////// On ajoute la couleur aux éléments ///////////////////// 
        panelHaut.setBackground(LIGHT_BLUE);
        panelDroit.setBackground(LIGHT_BLUE);
        panPatients.setBackground(LIGHT_BLUE); // Panel de gauche
        panelMessage.setBackground(LIGHT_BLUE);
        panelRecherche.setBackground(LIGHT_BLUE);

        ficheObservations.setBackground(LIGHT_BLUE);
        fichePrescription.setBackground(LIGHT_BLUE);
        fichePrescriptionDMA.setBackground(LIGHT_BLUE);
        ficheOperation.setBackground(LIGHT_BLUE);
        ficheResultat.setBackground(LIGHT_BLUE);
        panelSortie.setBackground(LIGHT_BLUE);
        panelSortieDMA.setBackground(LIGHT_BLUE);
        panelSaveObs.setBackground(LIGHT_BLUE);
        panelSavePres.setBackground(LIGHT_BLUE);
        panelSaveOp.setBackground(LIGHT_BLUE);
        panelSaveRes.setBackground(LIGHT_BLUE);
        panelSaveSortie.setBackground(LIGHT_BLUE);

        panelListe.setBackground(GREY);
        panelDetail.setBackground(GREY);
        panelDM.setBackground(GREY);
        panelInfoPatient.setBackground(GREY);
        panelNouveauDMA.setBackground(GREY);

        panelInfoPatientDMA.setBackground(GREY);
        panelListeDMA.setBackground(GREY);
        panelDetailDMA.setBackground(GREY);
        panelDMA.setBackground(GREY);

        t.setBackground(LIGHT_BLUE); //Tour des tableaux (scrollbar)
        tDMA.setBackground(LIGHT_BLUE);
        ScrollDM.setBackground(LIGHT_BLUE);

        tActeDM.setBackground(LIGHT_BLUE);
        tActeDMA.setBackground(LIGHT_BLUE);

        tableau.setBackground(GREY); //Cases des tableaux
        tableauDMA.setBackground(GREY);
        tableauDM.setBackground(GREY);
        tableauActeDm.setBackground(GREY);
        tableauActeDMA.setBackground(GREY);

    }

    /**
     * Récupère les informations présentes dans la page Accueil
     * @return
     */
    public JFrame getAccueil() {
        return accueil;
    }

    /**
     * Permet la modification des informations présentes dans la page Accueil
     * @param accueil
     */
    public void setAccueil(JFrame accueil) {
        this.accueil = accueil;
    }

    
    /**
     *
     * @return
     */
    public JPanel getPanelFin() {
        return panelFin;
    }

    /**
     *
     * @param panelFin
     */
    public void setPanelFin(JPanel panelFin) {
        this.panelFin = panelFin;
    }

    /**
     *Récupère les informations présentes sur la partie droite de la page
     * @return
     */
    public JPanel getPanelDroit() {
        return panelDroit;
    }

    /**
     *Permet la modification des informations présentes sur la partie droite de la page
     * @param panelDroit
     */
    public void setPanelDroit(JPanel panelDroit) {
        this.panelDroit = panelDroit;
    }

    /**
     *Récupère les informations présentes sur la partie droite de la page
     * @return
     */
    public JPanel getPanelGauche() {
        return panelGauche;
    }

    /**
     *Permet la modification des informations présentes sur la partie gauche de la page
     * @param panelGauche
     */
    public void setPanelGauche(JPanel panelGauche) {
        this.panelGauche = panelGauche;
    }

    /**
     *Récupère les informations présentes sur la partie haute de la page
     * @return
     */
    public JPanel getPanelHaut() {
        return panelHaut;
    }

    /**
     *Permet la modification des informations présentes sur la partie haute de la page
     * @param panelHaut
     */
    public void setPanelHaut(JPanel panelHaut) {
        this.panelHaut = panelHaut;
    }

    /**
     *
     * @return
     */
    public JSplitPane getSplitPan() {
        return splitPan;
    }

    /**
     *
     * @param splitPan
     */
    public void setSplitPan(JSplitPane splitPan) {
        this.splitPan = splitPan;
    }

    /**
     *
     * @return
     */
    public JPanel getPrez() {
        return prez;
    }

    /**
     *
     * @param prez
     */
    public void setPrez(JPanel prez) {
        this.prez = prez;
    }

    /**
     *
     * @return
     */
    public JPanel getPanHistorique() {
        return panPatients;
    }

    /**
     *
     * @param panPatients
     */
    public void setPanHistorique(JPanel panPatients) {
        this.panPatients = panPatients;
    }

    /**
     *
     * @return
     */
    public JScrollPane getT() {
        return t;
    }

    /**
     *
     * @param t
     */
    public void setT(JScrollPane t) {
        this.t = t;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelMessage() {
        return panelMessage;
    }

    /**
     *
     * @param panelMessage
     */
    public void setPanelMessage(JPanel panelMessage) {
        this.panelMessage = panelMessage;
    }

    /**
     *
     * @return
     */
    public JTabbedPane getTp() {
        return tp;
    }

    /**
     *
     * @param tp
     */
    public void setTp(JTabbedPane tp) {
        this.tp = tp;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelDMHaut() {
        return panelDMHaut;
    }

    /**
     *
     * @param panelDMHaut
     */
    public void setPanelDMHaut(JPanel panelDMHaut) {
        this.panelDMHaut = panelDMHaut;
    }

    /**
     *Récupère les informations de l'espace des informations patient
     * @return
     */
    public JPanel getPanelInfoPatient() {
        return panelInfoPatient;
    }

    /**
     *Permet la modification des informations de l'espace des informations patient
     * @param panelInfoPatient
     */
    public void setPanelInfoPatient(JPanel panelInfoPatient) {
        this.panelInfoPatient = panelInfoPatient;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelTest() {
        return panelTest;
    }

    /**
     *
     * @param panelTest
     */
    public void setPanelTest(JPanel panelTest) {
        this.panelTest = panelTest;
    }

    /**
     *Récupère le nom de famille du patient
     * @return
     */
    public JPanel getPatientNom() {
        return patientNom;
    }

    /**
     *Permet de modifier le nom de famille du patient
     * @param patientNom
     */
    public void setPatientNom(JPanel patientNom) {
        this.patientNom = patientNom;
    }

    /**
     *Récupère le prénom du patient 
     * @return
     */
    public JPanel getpPrenom() {
        return pPrenom;
    }

    /**
     *Permet de modifier le prénom du patient
     * @param pPrenom
     */
    public void setpPrenom(JPanel pPrenom) {
        this.pPrenom = pPrenom;
    }

    /**
     *Récupère le sexe du patient
     * @return
     */
    public JPanel getPatientSexe() {
        return patientSexe;
    }

    /**
     *Permet de modifier le sexe du patient 
     * @param patientSexe
     */
    public void setPatientSexe(JPanel patientSexe) {
        this.patientSexe = patientSexe;
    }

    /**
     *Récupère la date de naissance du patient
     * @return
     */
    public JPanel getPatientDate() {
        return patientDate;
    }

    /**
     *Permet de modifier la date de naissance du patient
     * @param patientDate
     */
    public void setPatientDate(JPanel patientDate) {
        this.patientDate = patientDate;
    }

    /**
     *Récupère l'adresse du patient 
     * @return
     */
    public JPanel getPatientAdresse() {
        return patientAdresse;
    }

    /**
     *Permet de modifier l'adresse du patient
     * @param patientAdresse
     */
    public void setPatientAdresse(JPanel patientAdresse) {
        this.patientAdresse = patientAdresse;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelListe() {
        return panelListe;
    }

    /**
     *
     * @param panelListe
     */
    public void setPanelListe(JPanel panelListe) {
        this.panelListe = panelListe;
    }

    /**
     *Récupère les informations dans la partie Liste des actes du DM
     * @return
     */
    public JScrollPane gettActeDM() {
        return tActeDM;
    }

    /**
     *Permet de modifier les informations dans la partie Liste des actes du DM
     * @param tActeDM
     */
    public void settActeDM(JScrollPane tActeDM) {
        this.tActeDM = tActeDM;
    }

    /**
     *Récupère les informations sur les détails des actes d'une fiche de soins
     * @return
     */
    public JPanel getPanelDetail() {
        return panelDetail;
    }

    /**
     *Permet de modifier les informations sur les détails des actes d'une fiche de soins
     * @param panelDetail
     */
    public void setPanelDetail(JPanel panelDetail) {
        this.panelDetail = panelDetail;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelFiche() {
        return panelFiche;
    }

    /**
     *
     * @param panelFiche
     */
    public void setPanelFiche(JPanel panelFiche) {
        this.panelFiche = panelFiche;
    }

    /**
     *Récupère la position de la scroll barre de l'onglet Observations
     * @return
     */
    public JScrollPane getObs() {
        return obs;
    }

    /**
     *Permet de modifier la position de la scroll barre de l'onglet Observations
     * @param obs
     */
    public void setObs(JScrollPane obs) {
        this.obs = obs;
    }

    /**
     *Récupère les observations d'une fiche de soins
     * @return
     */
    public JPanel getFicheObservations() {
        return ficheObservations;
    }

    /**
     *Permet de modifier les observations d'une fiche de soins
     * @param ficheObservations
     */
    public void setFicheObservations(JPanel ficheObservations) {
        this.ficheObservations = ficheObservations;
    }

    /**
     *Récupère la position de la scroll barre de l'onglet Prescription
     * @return
     */
    public JScrollPane getPres() {
        return pres;
    }

    /**
     *Permet de modifier la position de la scroll barre de l'onglet Prescription
     * @param pres
     */
    public void setPres(JScrollPane pres) {
        this.pres = pres;
    }

    /**
     *Récupère les Prescriptions d'une fiche de soins
     * @return
     */
    public JPanel getFichePrescription() {
        return fichePrescription;
    }

    /**
     *Permet de modifier les Prescriptions d'une fiche de soins
     * @param fichePrescription
     */
    public void setFichePrescription(JPanel fichePrescription) {
        this.fichePrescription = fichePrescription;
    }

    /**
     *Récupère la position de la scroll barre de l'onglet Opérations
     * @return
     */
    public JScrollPane getOp() {
        return op;
    }

    /**
     *Permet de modifier la position de la scroll barre de l'onglet Observations
     * @param op
     */
    public void setOp(JScrollPane op) {
        this.op = op;
    }

    /**
     *Récupère les opérations d'une fiche de soins
     * @return
     */
    public JPanel getFicheOperation() {
        return ficheOperation;
    }

    /**
     *Permet de modifier les opérations sur une fiche de soins 
     * @param ficheOperation
     */
    public void setFicheOperation(JPanel ficheOperation) {
        this.ficheOperation = ficheOperation;
    }

    /**
     *Récupère la position de la scroll barre de l'onglet Résultats
     * @return
     */
    public JScrollPane getResult() {
        return result;
    }

    /**
     *Permet de modifier la position de la scroll barre de l'onglet Résultats
     * @param result
     */
    public void setResult(JScrollPane result) {
        this.result = result;
    }

    /**
     *Récupère les résultats d'une fiche de soins 
     * @return
     */
    public JPanel getFicheResultat() {
        return ficheResultat;
    }

    /**
     *Permet de modifier les résultats d'une fiche de soins 
     * @param ficheResultat
     */
    public void setFicheResultat(JPanel ficheResultat) {
        this.ficheResultat = ficheResultat;
    }

    /**
     *Récupère l'état de l'onglet DM (séléctionné ou non)
     * @return
     */
    public JSplitPane getDM() {
        return DM;
    }

    /**
     *Permet de modifier l'état de l'onglet DM (séléctionné ou non)
     * @param DM
     */
    public void setDM(JSplitPane DM) {
        this.DM = DM;
    }

    /**
     *Récupère les informations présentes sur la partie haute de l'onglet DMA
     * @return
     */
    public JPanel getPanelDMAHaut() {
        return panelDMAHaut;
    }

    /**
     *Permet de modifier les informations présentes sur la partie haute de l'onglet DMA
     * @param panelDMAHaut
     */
    public void setPanelDMAHaut(JPanel panelDMAHaut) {
        this.panelDMAHaut = panelDMAHaut;
    }

    /**
     *Récupère les informations du patient dans l'onglet DMA
     * @return
     */
    public JPanel getPanelInfoPatientDMA() {
        return panelInfoPatientDMA;
    }

    /**
     *Permet de modifier les informations du patient dans l'onglet DMA
     * @param panelInfoPatientDMA
     */
    public void setPanelInfoPatientDMA(JPanel panelInfoPatientDMA) {
        this.panelInfoPatientDMA = panelInfoPatientDMA;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelTestDMA() {
        return panelTestDMA;
    }

    /**
     *
     * @param panelTest2
     */
    public void setPanelTestDMA(JPanel panelTest2) {
        this.panelTestDMA = panelTest2;
    }

    /**
     *Récupère le nom de famille d'un patient dans son DMA
     * @return
     */
    public JPanel getPatientNomDMA() {
        return patientNomDMA;
    }

    /**
     *Permet de modifier le nom de famille d'un patient dans son DMA
     * @param patientNomDMA
     */
    public void setPatientNomDMA(JPanel patientNomDMA) {
        this.patientNomDMA = patientNomDMA;
    }

    /**
     *Récupère le prénom d'un patient dans son DMA
     * @return
     */
    public JPanel getpPrenomDMA() {
        return pPrenomDMA;
    }

    /**
     *Permet de modifier le prénom d'un patient dans son DMA
     * @param pPrenomDMA
     */
    public void setpPrenomDMA(JPanel pPrenomDMA) {
        this.pPrenomDMA = pPrenomDMA;
    }

    /**
     *Récupère le sexe d'un patient dans son DMA
     * @return
     */
    public JPanel getPatientSexeDMA() {
        return patientSexeDMA;
    }

    /**
     *Permet de modifier le sexe d'un patient dans son DMA
     * @param patientSexeDMA
     */
    public void setPatientSexeDMA(JPanel patientSexeDMA) {
        this.patientSexeDMA = patientSexeDMA;
    }

    /**
     *Récupère la date de naissance d'un patient dans son DMA
     * @return
     */
    public JPanel getPatientDateDMA() {
        return patientDateDMA;
    }

    /**
     *Permet de modifier la date de naissance d'un patient dans son DMA
     * @param patientDateDMA
     */
    public void setPatientDateDMA(JPanel patientDateDMA) {
        this.patientDateDMA = patientDateDMA;
    }

    /**
     *Récupère l'adresse postale d'un patient dans son DMA
     * @return
     */
    public JPanel getPatientAdresseDMA() {
        return patientAdresseDMA;
    }

    /**
     *Permet de mofifier l'adresse postale d'un patient dans son DMA
     * @param patientAdresseDMA
     */
    public void setPatientAdresseDMA(JPanel patientAdresseDMA) {
        this.patientAdresseDMA = patientAdresseDMA;
    }

    /**
     *Récupère les informations dans la liste des actes d'un patient dans son DMA
     * @return
     */
    public JPanel getPanelListeDMA() {
        return panelListeDMA;
    }

    /**
     *Permet de modifier les informations dans la liste des actes d'un patient dans son DMA
     * @param panelListeDMA
     */
    public void setPanelListeDMA(JPanel panelListeDMA) {
        this.panelListeDMA = panelListeDMA;
    }

    /**
     *Récupère la position de la scroll barre de l'onglet DMA
     * @return
     */
    public JScrollPane gettDMA() {
        return tDMA;
    }

    /**
     *Permet de modifier la position de la scroll barre de l'onglet DMA
     * @param tDMA
     */
    public void settDMA(JScrollPane tDMA) {
        this.tDMA = tDMA;
    }

    /**
     *Récupère les détails d'un acte dans le DMA d'un patient
     * @return
     */
    public JPanel getPanelDetail2() {
        return panelDetailDMA;
    }

    /**
     *Permet de modifier les détails d'un acte dans le DMA d'un patient
     * @param panelDetail2
     */
    public void setPanelDetail2(JPanel panelDetail2) {
        this.panelDetailDMA = panelDetail2;
    }

    /**
     *Récupère les informations d'une fiche DMA dans le DMA d'un patient
     * @return
     */
    public JPanel getPanelFicheDMA() {
        return panelFicheDMA;
    }

    /**
     *Permet de modifier les informations d'une fiche DMA dans le DMA d'un patient
     * @param panelFicheDMA
     */
    public void setPanelFicheDMA(JPanel panelFicheDMA) {
        this.panelFicheDMA = panelFicheDMA;
    }

    /**
     *Récupère l'état de l'onglet DMA (séléctionné ou non)
     * @return
     */
    public JSplitPane getDMA() {
        return DMA;
    }

    /**
     *Permet de modifier l'état de l'onglet DMA (séléctionné ou non)
     * @param DMA
     */
    public void setDMA(JSplitPane DMA) {
        this.DMA = DMA;
    }

    /**
     *Récupère lcontraintes de position des éléments 
     * @return
     */
    public GridBagConstraints getGbc() {
        return gbc;
    }

    /**
     *Permet de modifier lcontraintes de position des éléments 
     * @param gbc
     */
    public void setGbc(GridBagConstraints gbc) {
        this.gbc = gbc;
    }

    /**
     *Récupère l'image choisie en icône
     * @return
     */
    public ImageIcon getImage() {
        return image;
    }

    /**
     *Permet de modiifer l'image choisie en icône
     * @param image
     */
    public void setImage(ImageIcon image) {
        this.image = image;
    }

    /**
     *Récupère l'image choisie
     * @return
     */
    public Image getImg() {
        return img;
    }

    /**
     *Permet de modifier l'image choisie
     * @param img
     */
    public void setImg(Image img) {
        this.img = img;
    }

    /**
     *Récupère l'image choisie
     * @return
     */
    public Image getNewimg() {
        return newimg;
    }

    /**
     *Permer de modifier l'image choisie
     * @param newimg
     */
    public void setNewimg(Image newimg) {
        this.newimg = newimg;
    }

    /**
     *Récupère l'état du bouton déconnexion (cliqué ou non)
     * @return
     */
    public JButton getDeconnexion() {
        return deconnexion;
    }

    /**
     *Permet de modifier l'état du bouton déconnexion (cliqué ou non)
     * @param deconnexion
     */
    public void setDeconnexion(JButton deconnexion) {
        this.deconnexion = deconnexion;
    }

    /**
     *Récupère le label présentation
     * @return
     */
    public JLabel getPresentation() {
        return presentation;
    }

    /**
     *Permet de modifier le label présentation
     * @param presentation
     */
    public void setPresentation(JLabel presentation) {
        this.presentation = presentation;
    }

    /**
     *Récupère le deuxième label présentation
     * @return
     */
    public JLabel getPresentation2() {
        return presentation2;
    }

    /**
     *Permet de modifier le deuxième label présentation
     * @param presentation2
     */
    public void setPresentation2(JLabel presentation2) {
        this.presentation2 = presentation2;
    }

    /**
     *
     * @return
     */
    public TitledBorder getTitre3() {
        return titre3;
    }

    /**
     *
     * @param titre3
     */
    public void setTitre3(TitledBorder titre3) {
        this.titre3 = titre3;
    }

    /**
     *Récupère les infomations dans le tableau de patients
     * @return
     */
    public JTable getTableau() {
        return tableau;
    }

    /**
     *Permet de modifier les infomations dans le tableau de patients
     * @param tableau
     */
    public void setTableau(JTable tableau) {
        this.tableau = tableau;
    }

    /**
     *Récupère l'image de l'icône "Femme" à partir d'une URL
     * @return
     */
    public ImageIcon getIconeF() {
        return iconeF;
    }

    /**
     *Permet de modifier l'image de l'icône "Femme" à partir d'une URL
     * @param iconeF
     */
    public void setIconeF(ImageIcon iconeF) {
        this.iconeF = iconeF;
    }

    /**
     *Récupère l'image de l'icône "Homme" à partir d'une URL
     * @return
     */
    public ImageIcon getIconeH() {
        return iconeH;
    }

    /**
     *Permet de modifier l'image de l'icône "Homme" à partir d'une URL
     * @param iconeH
     */
    public void setIconeH(ImageIcon iconeH) {
        this.iconeH = iconeH;
    }

    /**
     *
     * @return
     */
    public JLabel getMessageArrive() {
        return messageArrive;
    }

    /**
     *
     * @param messageArrive
     */
    public void setMessageArrive(JLabel messageArrive) {
        this.messageArrive = messageArrive;
    }

    /**
     *Récupère le titre pour les informations du patient
     * @return
     */
    public TitledBorder getTitleInfo() {
        return titleInfo;
    }

    /**
     *Permet de modifier le titre pour les informations du patient
     * @param titleInfo
     */
    public void setTitleInfo(TitledBorder titleInfo) {
        this.titleInfo = titleInfo;
    }

    /**
     *Récupère l'image 
     * @return
     */
    public Image getImg2() {
        return img2;
    }

    /**
     *Permet de modifier l'image 
     * @param img2
     */
    public void setImg2(Image img2) {
        this.img2 = img2;
    }

    /**
     *Récupère l'image 
     * @return
     */
    public Image getNewimg2() {
        return newimg2;
    }

    /**
     *Permet de modifier l'image 
     * @param newimg2
     */
    public void setNewimg2(Image newimg2) {
        this.newimg2 = newimg2;
    }

    /**
     *Récupère le titre de l'image
     * @return
     */
    public JLabel getImage2() {
        return image2;
    }

    /**
     *Permet de modifier le titre de l'image
     * @param image2
     */
    public void setImage2(JLabel image2) {
        this.image2 = image2;
    }

    /**
     *Récupère l'image "Femme"
     * @return
     */
    public Image getImgF() {
        return imgF;
    }

    /**
     *Permet de modifier l'image "Femme"
     * @param imgF
     */
    public void setImgF(Image imgF) {
        this.imgF = imgF;
    }

    /**
     *Récupère l'image "Homme"
     * @return
     */
    public Image getNewimgF() {
        return newimgF;
    }

    /**
     *Permet de modifier l'image "Homme"
     * @param newimgF
     */
    public void setNewimgF(Image newimgF) {
        this.newimgF = newimgF;
    }

    /**
     *Récupère le nom du label pour le nom du patient
     * @return
     */
    public JLabel getNom() {
        return nom;
    }

    /**
     *Permet de modifier le nom du label pour le nom du patient
     * @param nom
     */
    public void setNom(JLabel nom) {
        this.nom = nom;
    }

    /**
     *Récupère le nom du label pour le nom du patient
     * @return
     */
    public JLabel getNom2() {
        return nom2;
    }

    /**
     *Permet de modifier le nom du label pour le nom du patient
     * @param nom2
     */
    public void setNom2(JLabel nom2) {
        this.nom2 = nom2;
    }

    /**
     *Récupère le nom du label pour le prénom du patient
     * @return
     */
    public JLabel getPrenom() {
        return prenom;
    }

    /**
     *Permet de modifier le nom du label pour le prénom du patient
     * @param prenom
     */
    public void setPrenom(JLabel prenom) {
        this.prenom = prenom;
    }

    /**
     *Récupère le nom du label pour le prénom du patient
     * @return
     */
    public JLabel getPrenom2() {
        return prenom2;
    }

    /**
     *Permet de modifier le nom du label pour le prénom du patient
     * @param prenom2
     */
    public void setPrenom2(JLabel prenom2) {
        this.prenom2 = prenom2;
    }

    /**
     *Récupère le nom du label pour le sexe du patient
     * @return
     */
    public JLabel getSexe() {
        return sexe;
    }

    /**
     *Permet de modifier le nom du label pour le sexe du patient
     * @param sexe
     */
    public void setSexe(JLabel sexe) {
        this.sexe = sexe;
    }

    /**
     *Récupère le nom du label pour le sexe du patient
     * @return
     */
    public JLabel getSexeInfo() {
        return sexeInfo;
    }

    /**
     *Permet de modifier le nom du label pour le see du patient
     * @param sexeInfo
     */
    public void setSexeInfo(JLabel sexeInfo) {
        this.sexeInfo = sexeInfo;
    }

    /**
     *Récupère le nom du label pour la date de naissance du patient
     * @return
     */
    public JLabel getDate() {
        return date;
    }

    /**
     *¨Permet de modifier le nom du label pour la date de naissance du patient
     * @param date
     */
    public void setDate(JLabel date) {
        this.date = date;
    }

    /**
     *Récupère le nom du label pour la date de naissance du patient
     * @return
     */
    public JLabel getDateInfo() {
        return dateInfo;
    }

    /**
     *Permet de modifier le nom du label pour la date de naissance du patient
     * @param dateInfo
     */
    public void setDateInfo(JLabel dateInfo) {
        this.dateInfo = dateInfo;
    }

    /**
     *Récupère le nom du label pour l'adresse postale du patient
     * @return
     */
    public JLabel getAdresse() {
        return adresse;
    }

    /**
     *Permet de modifier le nom du label pour l'adresse postale du patient
     * @param adresse
     */
    public void setAdresse(JLabel adresse) {
        this.adresse = adresse;
    }

    /**
     *Récupère le nom du label pour l'adresse postale du patient
     * @return
     */
    public JLabel getAdresseInfo() {
        return adresseInfo;
    }

    /**
     *Permet de modifier le nom du label pour l'adresse postale du patient
     * @param adresseInfo
     */
    public void setAdresseInfo(JLabel adresseInfo) {
        this.adresseInfo = adresseInfo;
    }

    /**
     *
     * @return
     */
    public TitledBorder getTitleListe() {
        return titleListe;
    }

    /**
     *
     * @param titleListe
     */
    public void setTitleListe(TitledBorder titleListe) {
        this.titleListe = titleListe;
    }

    /**
     *Récupère les informations du tableau de liste des DM
     * @return
     */
    public JTable getTableauDM() {
        return tableauDM;
    }

    /**
     *Permet de modifier les informations du tableau de liste des DM
     * @param tableauDM
     */
    public void setTableauDM(JTable tableauDM) {
        this.tableauDM = tableauDM;
    }

    /**
     *Récupère le nom du titre pour la partie details des actes
     * @return
     */
    public TitledBorder getTitleDetail() {
        return titleDetail;
    }

    /**
     *Permet de modifier le nom du titre pour la partie details des actes
     * @param titleDetail
     */
    public void setTitleDetail(TitledBorder titleDetail) {
        this.titleDetail = titleDetail;
    }

    /**
     *Récupère les informations dans la zone de texte de la partie observations
     * @return
     */
    public JTextArea getObservations2() {
        return observations2;
    }

    /**
     *Permet de modifier les informations dans la zone de texte de la partie observations
     * @param observations2
     */
    public void setObservations2(JTextArea observations2) {
        this.observations2 = observations2;
    }

    /**
     *Récupère le nom du titre pour la partie observations
     * @return
     */
    public TitledBorder getTitleObs() {
        return titleObs;
    }

    /**
     *Permet de modifier le nom du titre pour la partie observations
     * @param titleObs
     */
    public void setTitleObs(TitledBorder titleObs) {
        this.titleObs = titleObs;
    }

    /**
     *Récupère les informations dans la zone de texte de la partie prescriptions
     * @return
     */
    public JTextArea getPrescription2() {
        return prescription2;
    }

    /**
     *Permet de modifier les informations dans la zone de texte de la partie prescriptions
     * @param prescription2
     */
    public void setPrescription2(JTextArea prescription2) {
        this.prescription2 = prescription2;
    }

    /**
     *Récupère le nom du titre pour la partie prescriptions
     * @return
     */
    public TitledBorder getTitlePresc() {
        return titlePresc;
    }

    /**
     *Permet de modifier le nom du titre pour la partie prescriptions
     * @param titlePresc
     */
    public void setTitlePresc(TitledBorder titlePresc) {
        this.titlePresc = titlePresc;
    }

    /**
     *Récupère les informations dans la zone de texte de la partie opérations
     * @return
     */
    public JTextArea getOperationInfo() {
        return operationInfo;
    }

    /**
     *Permet de modifier les informations dans la zone de texte de la partie opérations
     * @param operationInfo
     */
    public void setOperationInfo(JTextArea operationInfo) {
        this.operationInfo = operationInfo;
    }

    /**
     *Récupère le nom du titre pour la partie opérations
     * @return
     */
    public TitledBorder getTitleOp() {
        return titleOp;
    }

    /**
     *Permet de modifier le nom du titre pour la partie opérations
     * @param titleOp
     */
    public void setTitleOp(TitledBorder titleOp) {
        this.titleOp = titleOp;
    }

    /**
     *Récupère les informations dans la zone de texte de la partie résultats
     * @return
     */
    public JTextArea getResultatInfo() {
        return resultatInfo;
    }

    /**
     *Permet de modifier les informations dans la zone de texte de la partie résultats
     * @param resultatInfo
     */
    public void setResultatInfo(JTextArea resultatInfo) {
        this.resultatInfo = resultatInfo;
    }

    /**
     *Récupère le nom du titre pour la partie résultats
     * @return
     */
    public TitledBorder getTitleRes() {
        return titleRes;
    }

    /**
     *Permet de modifier le nom du titre pour la partie résultats
     * @param titleRes
     */
    public void setTitleRes(TitledBorder titleRes) {
        this.titleRes = titleRes;
    }

    /**
     *Récupère le nom du titre
     * @return
     */
    public TitledBorder getTitle() {
        return title;
    }

    /**
     *Permet de modifier le nom du titre pour la partie opérations
     * @param title
     */
    public void setTitle(TitledBorder title) {
        this.title = title;
    }

    /**
     *Récupère le nom du titre pour la partie informations sur le patient du DMA
     * @return
     */
    public TitledBorder getTitleInfoDMA() {
        return titleInfoDMA;
    }

    /**
     *Permet de modifier le nom du titre pour la partie informations sur le patient du DMA
     * @param titleInfo2
     */
    public void setTitleInfoDMA(TitledBorder titleInfo2) {
        this.titleInfoDMA = titleInfo2;
    }

    /**
     *Récupère l'image pour le DMA
     * @return
     */
    public Image getImg2DMA() {
        return img2DMA;
    }

    /**
     *Permet de modifier l'image pour le DMA
     * @param img2DMA
     */
    public void setImg2DMA(Image img2DMA) {
        this.img2DMA = img2DMA;
    }

    /**
     *Récupère l'image pour le DMA
     * @return
     */
    public Image getNewimg2DMA() {
        return newimg2DMA;
    }

    /**
     *Permet de modifier l'image pour le DMA
     * @param newimg2DMA
     */
    public void setNewimg2DMA(Image newimg2DMA) {
        this.newimg2DMA = newimg2DMA;
    }

    /**
     *Récupère le label pour l'image du DMA
     * @return
     */
    public JLabel getImage2DMA() {
        return image2DMA;
    }

    /**
     *Permet de modifier le label pour l'image du DMA
     * @param image2DMA
     */
    public void setImage2DMA(JLabel image2DMA) {
        this.image2DMA = image2DMA;
    }

    /**
     *Récupère l'image "Femme" pour le DMA
     * @return
     */
    public Image getImgFDMA() {
        return imgFDMA;
    }

    /**
     *Permet de modifier l'image "Femme" pour le DMA
     * @param imgFDMA
     */
    public void setImgFDMA(Image imgFDMA) {
        this.imgFDMA = imgFDMA;
    }

    /**
     *Récupère l'image "Femme" pour le DMA
     * @return
     */
    public Image getNewimgFDMA() {
        return newimgFDMA;
    }

    /**
     *Récupère l'image "Femme" pour le DMA
     * @param newimgFDMA
     */
    public void setNewimgFDMA(Image newimgFDMA) {
        this.newimgFDMA = newimgFDMA;
    }

    /**
     *Récupère le label du nom dans le DMA
     * @return
     */
    public JLabel getNomDMA() {
        return nomDMA;
    }

    /**
     *Permet de modifier le label du nom dans le DMA
     * @param nomDMA
     */
    public void setNomDMA(JLabel nomDMA) {
        this.nomDMA = nomDMA;
    }

    /**
     *Récupère le label du nom dans le DMA
     * @return
     */
    public JLabel getNom2DMA() {
        return nom2DMA;
    }

    /**
     *Permet de modifier le label du nom dans le DMA
     * @param nom2DMA
     */
    public void setNom2DMA(JLabel nom2DMA) {
        this.nom2DMA = nom2DMA;
    }

    /**
     *Récupère le label du prénom dans le DMA
     * @return
     */
    public JLabel getPrenomDMA() {
        return prenomDMA;
    }

    /**
     *Permet de modifier le label du prénom dans le DMA
     * @param prenomDMA
     */
    public void setPrenomDMA(JLabel prenomDMA) {
        this.prenomDMA = prenomDMA;
    }

    /**
     *Récupère le label du prénom dans le DMA
     * @return
     */
    public JLabel getPrenom2DMA() {
        return prenom2DMA;
    }

    /**
     *
     * @param prenom2DMA
     */
    public void setPrenom2DMA(JLabel prenom2DMA) {
        this.prenom2DMA = prenom2DMA;
    }

    /**
     *
     * @return
     */
    public JLabel getSexeDMA() {
        return sexeDMA;
    }

    /**
     *
     * @param sexeDMA
     */
    public void setSexeDMA(JLabel sexeDMA) {
        this.sexeDMA = sexeDMA;
    }

    /**
     *
     * @return
     */
    public JLabel getSexeInfoDMA() {
        return sexeInfoDMA;
    }

    /**
     *
     * @param sexeInfoDMA
     */
    public void setSexeInfoDMA(JLabel sexeInfoDMA) {
        this.sexeInfoDMA = sexeInfoDMA;
    }

    /**
     *
     * @return
     */
    public JLabel getDateDMA() {
        return dateDMA;
    }

    /**
     *
     * @param dateDMA
     */
    public void setDateDMA(JLabel dateDMA) {
        this.dateDMA = dateDMA;
    }

    /**
     *
     * @return
     */
    public JLabel getDateInfoDMA() {
        return dateInfoDMA;
    }

    /**
     *
     * @param dateInfoDMA
     */
    public void setDateInfoDMA(JLabel dateInfoDMA) {
        this.dateInfoDMA = dateInfoDMA;
    }

    /**
     *
     * @return
     */
    public JLabel getAdresseDMA() {
        return adresseDMA;
    }

    /**
     *
     * @param adresseDMA
     */
    public void setAdresseDMA(JLabel adresseDMA) {
        this.adresseDMA = adresseDMA;
    }

    /**
     *
     * @return
     */
    public JLabel getAdresseInfoDMA() {
        return adresseInfoDMA;
    }

    /**
     *
     * @param adresseInfoDMA
     */
    public void setAdresseInfoDMA(JLabel adresseInfoDMA) {
        this.adresseInfoDMA = adresseInfoDMA;
    }

    /**
     *
     * @return
     */
    public TitledBorder getTitleListeDMA() {
        return titleListeDMA;
    }

    /**
     *
     * @param titleListe2
     */
    public void setTitleListe2(TitledBorder titleListe2) {
        this.titleListeDMA = titleListe2;
    }

    /**
     *
     * @return
     */
    public JTable getTableauDMA() {
        return tableauDMA;
    }

    /**
     *
     * @param tableauDMA
     */
    public void setTableauDMA(JTable tableauDMA) {
        this.tableauDMA = tableauDMA;
    }

    /**
     *
     * @return
     */
    public TitledBorder getTitleDetail2() {
        return titleDetailDMA;
    }

    /**
     *
     * @param titleDetailDMA
     */
    public void setTitleDetailDMA(TitledBorder titleDetailDMA) {
        this.titleDetailDMA = titleDetailDMA;
    }

    /**
     *
     * @return
     */
    public TitledBorder getTitleDMA() {
        return titleDMA;
    }

    /**
     *
     * @param titleDMA
     */
    public void setTitleDMA(TitledBorder titleDMA) {
        this.titleDMA = titleDMA;
    }

    /**
     *
     * @return
     */
    public JButton getAjoutActe() {
        return ajoutActe;
    }

    /**
     *
     * @param ajoutActe
     */
    public void setAjoutActe(JButton ajoutActe) {
        this.ajoutActe = ajoutActe;
    }

    /**
     *
     * @return
     */
    public ImageIcon getPlus() {
        return plus;
    }

    /**
     *
     * @param plus
     */
    public void setPlus(ImageIcon plus) {
        this.plus = plus;
    }

    /**
     *
     * @return
     */
    public Image getPlusIm() {
        return plusIm;
    }

    /**
     *
     * @param plusIm
     */
    public void setPlusIm(Image plusIm) {
        this.plusIm = plusIm;
    }

    /**
     *
     * @return
     */
    public Image getPlusImFin() {
        return plusImFin;
    }

    /**
     *
     * @param plusImFin
     */
    public void setPlusImFin(Image plusImFin) {
        this.plusImFin = plusImFin;
    }

    /**
     *
     * @return
     */
    public JPanel getPanPatients() {
        return panPatients;
    }

    /**
     *
     * @param panPatients
     */
    public void setPanPatients(JPanel panPatients) {
        this.panPatients = panPatients;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelPlus() {
        return panelPlus;
    }

    /**
     *
     * @param panelPlus
     */
    public void setPanelPlus(JPanel panelPlus) {
        this.panelPlus = panelPlus;
    }

    /**
     *
     * @return
     */
    public JTabbedPane getDetailsDM() {
        return detailsDM;
    }

    /**
     *
     * @param detailsDM
     */
    public void setDetailsDM(JTabbedPane detailsDM) {
        this.detailsDM = detailsDM;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelRecherche() {
        return panelRecherche;
    }

    /**
     *
     * @param panelRecherche
     */
    public void setPanelRecherche(JPanel panelRecherche) {
        this.panelRecherche = panelRecherche;
    }

    /**
     *
     * @return
     */
    public JTextField getBarreRecherche() {
        return barreRecherche;
    }

    /**
     *
     * @param barreRecherche
     */
    public void setBarreRecherche(JTextField barreRecherche) {
        this.barreRecherche = barreRecherche;
    }

    /**
     *
     * @return
     */
    public JButton getRechercher() {
        return rechercher;
    }

    /**
     *
     * @param rechercher
     */
    public void setRechercher(JButton rechercher) {
        this.rechercher = rechercher;
    }

    /**
     *
     * @return
     */
    public JComboBox getChoix() {
        return choix;
    }

    /**
     *
     * @param choix
     */
    public void setChoix(JComboBox choix) {
        this.choix = choix;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelRechercheDroit() {
        return panelRechercheDroit;
    }

    /**
     *
     * @param panelRechercheDroit
     */
    public void setPanelRechercheDroit(JPanel panelRechercheDroit) {
        this.panelRechercheDroit = panelRechercheDroit;
    }

    /**
     *
     * @return
     */
    public JButton getRetour() {
        return retour;
    }

    /**
     *
     * @param retour
     */
    public void setRetour(JButton retour) {
        this.retour = retour;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelDM() {
        return panelDM;
    }

    /**
     *
     * @param panelDM
     */
    public void setPanelDM(JPanel panelDM) {
        this.panelDM = panelDM;
    }

    /**
     *
     * @return
     */
    public JScrollPane getScrollDM() {
        return ScrollDM;
    }

    /**
     *
     * @param ScrollDM
     */
    public void setScrollDM(JScrollPane ScrollDM) {
        this.ScrollDM = ScrollDM;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelSouthDM() {
        return panelSouthDM;
    }

    /**
     *
     * @param panelSouthDM
     */
    public void setPanelSouthDM(JPanel panelSouthDM) {
        this.panelSouthDM = panelSouthDM;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelPlusDMA() {
        return panelPlusDMA;
    }

    /**
     *
     * @param panelPlusDMA
     */
    public void setPanelPlusDMA(JPanel panelPlusDMA) {
        this.panelPlusDMA = panelPlusDMA;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelDetailDMA() {
        return panelDetailDMA;
    }

    /**
     *
     * @param panelDetailDMA
     */
    public void setPanelDetailDMA(JPanel panelDetailDMA) {
        this.panelDetailDMA = panelDetailDMA;
    }

    /**
     *
     * @return
     */
    public TitledBorder getTitleDM() {
        return titleDM;
    }

    /**
     *
     * @param titleDM
     */
    public void setTitleDM(TitledBorder titleDM) {
        this.titleDM = titleDM;
    }

    /**
     *
     * @return
     */
    public JButton getAjoutDM() {
        return ajoutDM;
    }

    /**
     *
     * @param ajoutDM
     */
    public void setAjoutDM(JButton ajoutDM) {
        this.ajoutDM = ajoutDM;
    }

    /**
     *
     * @return
     */
    public ImageIcon getPlusDM() {
        return plusDM;
    }

    /**
     *
     * @param plusDM
     */
    public void setPlusDM(ImageIcon plusDM) {
        this.plusDM = plusDM;
    }

    /**
     *
     * @return
     */
    public Image getPlusImDM() {
        return plusImDM;
    }

    /**
     *
     * @param plusImDM
     */
    public void setPlusImDM(Image plusImDM) {
        this.plusImDM = plusImDM;
    }

    /**
     *
     * @return
     */
    public Image getPlusImFinDM() {
        return plusImFinDM;
    }

    /**
     *
     * @param plusImFinDM
     */
    public void setPlusImFinDM(Image plusImFinDM) {
        this.plusImFinDM = plusImFinDM;
    }

    /**
     *
     * @return
     */
    public JTable getTableauActeDm() {
        return tableauActeDm;
    }

    /**
     *
     * @param tableauActeDm
     */
    public void setTableauActeDm(JTable tableauActeDm) {
        this.tableauActeDm = tableauActeDm;
    }

    /**
     *
     * @return
     */
    public JButton getAjoutActeDMA() {
        return ajoutActeDMA;
    }

    /**
     *
     * @param ajoutActeDMA
     */
    public void setAjoutActeDMA(JButton ajoutActeDMA) {
        this.ajoutActeDMA = ajoutActeDMA;
    }

    /**
     *
     * @return
     */
    public ImageIcon getPlusDMA() {
        return plusDMA;
    }

    /**
     *
     * @param plusDMA
     */
    public void setPlusDMA(ImageIcon plusDMA) {
        this.plusDMA = plusDMA;
    }

    /**
     *
     * @return
     */
    public Image getPlusImDMA() {
        return plusImDMA;
    }

    /**
     *
     * @param plusImDMA
     */
    public void setPlusImDMA(Image plusImDMA) {
        this.plusImDMA = plusImDMA;
    }

    /**
     *
     * @return
     */
    public Image getPlusImFinDMA() {
        return plusImFinDMA;
    }

    /**
     *
     * @param plusImFinDMA
     */
    public void setPlusImFinDMA(Image plusImFinDMA) {
        this.plusImFinDMA = plusImFinDMA;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelSave() {
        return panelSaveObs;
    }

    /**
     *
     * @param panelSaveObs
     */
    public void setPanelSave(JPanel panelSaveObs) {
        this.panelSaveObs = panelSaveObs;
    }

    /**
     *
     * @return
     */
    public Border getLoweredBevelBorderInfo() {
        return LoweredBevelBorderInfo;
    }

    /**
     *
     * @param LoweredBevelBorderInfo
     */
    public void setLoweredBevelBorderInfo(Border LoweredBevelBorderInfo) {
        this.LoweredBevelBorderInfo = LoweredBevelBorderInfo;
    }

    /**
     *
     * @return
     */
    public Border getLoweredBevelBorderDM() {
        return LoweredBevelBorderDM;
    }

    /**
     *
     * @param LoweredBevelBorderDM
     */
    public void setLoweredBevelBorderDM(Border LoweredBevelBorderDM) {
        this.LoweredBevelBorderDM = LoweredBevelBorderDM;
    }

    /**
     *
     * @return
     */
    public Border getLoweredBevelBorderListe() {
        return LoweredBevelBorderListe;
    }

    /**
     *
     * @param LoweredBevelBorderListe
     */
    public void setLoweredBevelBorderListe(Border LoweredBevelBorderListe) {
        this.LoweredBevelBorderListe = LoweredBevelBorderListe;
    }

    /**
     *
     * @return
     */
    public Border getLoweredBevelBorderDetail() {
        return LoweredBevelBorderDetail;
    }

    /**
     *
     * @param LoweredBevelBorderDetail
     */
    public void setLoweredBevelBorderDetail(Border LoweredBevelBorderDetail) {
        this.LoweredBevelBorderDetail = LoweredBevelBorderDetail;
    }

    /**
     *
     * @return
     */
    public Border getLoweredBevelBorderObs() {
        return LoweredBevelBorderObs;
    }

    /**
     *
     * @param LoweredBevelBorderObs
     */
    public void setLoweredBevelBorderObs(Border LoweredBevelBorderObs) {
        this.LoweredBevelBorderObs = LoweredBevelBorderObs;
    }

    /**
     *
     * @return
     */
    public Border getLoweredBevelBorderPres() {
        return LoweredBevelBorderPres;
    }

    /**
     *
     * @param LoweredBevelBorderPres
     */
    public void setLoweredBevelBorderPres(Border LoweredBevelBorderPres) {
        this.LoweredBevelBorderPres = LoweredBevelBorderPres;
    }

    /**
     *
     * @return
     */
    public Border getLoweredBevelBorderOp() {
        return LoweredBevelBorderOp;
    }

    /**
     *
     * @param LoweredBevelBorderOp
     */
    public void setLoweredBevelBorderOp(Border LoweredBevelBorderOp) {
        this.LoweredBevelBorderOp = LoweredBevelBorderOp;
    }

    /**
     *
     * @return
     */
    public Border getLoweredBevelBorderRes() {
        return LoweredBevelBorderRes;
    }

    /**
     *
     * @param LoweredBevelBorderRes
     */
    public void setLoweredBevelBorderRes(Border LoweredBevelBorderRes) {
        this.LoweredBevelBorderRes = LoweredBevelBorderRes;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelSaveObs() {
        return panelSaveObs;
    }

    /**
     *
     * @param panelSaveObs
     */
    public void setPanelSaveObs(JPanel panelSaveObs) {
        this.panelSaveObs = panelSaveObs;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelSavePres() {
        return panelSavePres;
    }

    /**
     *
     * @param panelSavePres
     */
    public void setPanelSavePres(JPanel panelSavePres) {
        this.panelSavePres = panelSavePres;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelSaveOp() {
        return panelSaveOp;
    }

    /**
     *
     * @param panelSaveOp
     */
    public void setPanelSaveOp(JPanel panelSaveOp) {
        this.panelSaveOp = panelSaveOp;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelSaveRes() {
        return panelSaveRes;
    }

    /**
     *
     * @param panelSaveRes
     */
    public void setPanelSaveRes(JPanel panelSaveRes) {
        this.panelSaveRes = panelSaveRes;
    }

    /**
     *
     * @return
     */
    public ImageIcon getSaveObs() {
        return saveObs;
    }

    /**
     *
     * @param saveObs
     */
    public void setSaveObs(ImageIcon saveObs) {
        this.saveObs = saveObs;
    }

    /**
     *
     * @return
     */
    public Image getSaveImObs() {
        return saveImObs;
    }

    /**
     *
     * @param saveImObs
     */
    public void setSaveImObs(Image saveImObs) {
        this.saveImObs = saveImObs;
    }

    /**
     *
     * @return
     */
    public Image getSaveImFinObs() {
        return saveImFinObs;
    }

    /**
     *
     * @param saveImFinObs
     */
    public void setSaveImFinObs(Image saveImFinObs) {
        this.saveImFinObs = saveImFinObs;
    }

    /**
     *
     * @return
     */
    public JButton getButtonSaveObs() {
        return buttonSaveObs;
    }

    /**
     *
     * @param buttonSaveObs
     */
    public void setButtonSaveObs(JButton buttonSaveObs) {
        this.buttonSaveObs = buttonSaveObs;
    }

    /**
     *
     * @return
     */
    public ImageIcon getSavePres() {
        return savePres;
    }

    /**
     *
     * @param savePres
     */
    public void setSavePres(ImageIcon savePres) {
        this.savePres = savePres;
    }

    /**
     *
     * @return
     */
    public Image getSaveImPres() {
        return saveImPres;
    }

    /**
     *
     * @param saveImPres
     */
    public void setSaveImPres(Image saveImPres) {
        this.saveImPres = saveImPres;
    }

    /**
     *
     * @return
     */
    public Image getSaveImFinPres() {
        return saveImFinPres;
    }

    /**
     *
     * @param saveImFinPres
     */
    public void setSaveImFinPres(Image saveImFinPres) {
        this.saveImFinPres = saveImFinPres;
    }

    /**
     *
     * @return
     */
    public JButton getButtonSavePres() {
        return buttonSavePres;
    }

    /**
     *
     * @param buttonSavePres
     */
    public void setButtonSavePres(JButton buttonSavePres) {
        this.buttonSavePres = buttonSavePres;
    }

    /**
     *
     * @return
     */
    public ImageIcon getSaveOp() {
        return saveOp;
    }

    /**
     *
     * @param saveOp
     */
    public void setSaveOp(ImageIcon saveOp) {
        this.saveOp = saveOp;
    }

    /**
     *
     * @return
     */
    public Image getSaveImOp() {
        return saveImOp;
    }

    /**
     *
     * @param saveImOp
     */
    public void setSaveImOp(Image saveImOp) {
        this.saveImOp = saveImOp;
    }

    /**
     *
     * @return
     */
    public Image getSaveImFinOp() {
        return saveImFinOp;
    }

    /**
     *
     * @param saveImFinOp
     */
    public void setSaveImFinOp(Image saveImFinOp) {
        this.saveImFinOp = saveImFinOp;
    }

    /**
     *
     * @return
     */
    public JButton getButtonSaveOp() {
        return buttonSaveOp;
    }

    /**
     *
     * @param buttonSaveOp
     */
    public void setButtonSaveOp(JButton buttonSaveOp) {
        this.buttonSaveOp = buttonSaveOp;
    }

    /**
     *
     * @return
     */
    public ImageIcon getSaveRes() {
        return saveRes;
    }

    /**
     *
     * @param saveRes
     */
    public void setSaveRes(ImageIcon saveRes) {
        this.saveRes = saveRes;
    }

    /**
     *
     * @return
     */
    public Image getSaveImRes() {
        return saveImRes;
    }

    /**
     *
     * @param saveImRes
     */
    public void setSaveImRes(Image saveImRes) {
        this.saveImRes = saveImRes;
    }

    /**
     *
     * @return
     */
    public Image getSaveImFinRes() {
        return saveImFinRes;
    }

    /**
     *
     * @param saveImFinRes
     */
    public void setSaveImFinRes(Image saveImFinRes) {
        this.saveImFinRes = saveImFinRes;
    }

    /**
     *
     * @return
     */
    public JButton getButtonSaveRes() {
        return buttonSaveRes;
    }

    /**
     *
     * @param buttonSaveRes
     */
    public void setButtonSaveRes(JButton buttonSaveRes) {
        this.buttonSaveRes = buttonSaveRes;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelSaveSortie() {
        return panelSaveSortie;
    }

    /**
     *
     * @param panelSaveSortie
     */
    public void setPanelSaveSortie(JPanel panelSaveSortie) {
        this.panelSaveSortie = panelSaveSortie;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelSortie() {
        return panelSortie;
    }

    /**
     *
     * @param panelSortie
     */
    public void setPanelSortie(JPanel panelSortie) {
        this.panelSortie = panelSortie;
    }

    /**
     *
     * @return
     */
    public JPanel getSortieHaut() {
        return sortieHaut;
    }

    /**
     *
     * @param sortieHaut
     */
    public void setSortieHaut(JPanel sortieHaut) {
        this.sortieHaut = sortieHaut;
    }

    /**
     *
     * @return
     */
    public JTextArea getLettreSortie() {
        return lettreSortie;
    }

    /**
     *
     * @param lettreSortie
     */
    public void setLettreSortie(JTextArea lettreSortie) {
        this.lettreSortie = lettreSortie;
    }

    /**
     *
     * @return
     */
    public JButton getButtonSortie() {
        return buttonSortie;
    }

    /**
     *
     * @param buttonSortie
     */
    public void setButtonSortie(JButton buttonSortie) {
        this.buttonSortie = buttonSortie;
    }

    /**
     *
     * @return
     */
    public JTextArea getAjoutLettreSortie() {
        return ajoutLettreSortie;
    }

    /**
     *
     * @param ajoutLettreSortie
     */
    public void setAjoutLettreSortie(JTextArea ajoutLettreSortie) {
        this.ajoutLettreSortie = ajoutLettreSortie;
    }

    /**
     *
     * @return
     */
    public Border getLoweredBevelBorderSortie() {
        return LoweredBevelBorderSortie;
    }

    /**
     *
     * @param LoweredBevelBorderSortie
     */
    public void setLoweredBevelBorderSortie(Border LoweredBevelBorderSortie) {
        this.LoweredBevelBorderSortie = LoweredBevelBorderSortie;
    }

    /**
     *
     * @return
     */
    public TitledBorder getTitleSortie() {
        return titleSortie;
    }

    /**
     *
     * @param titleSortie
     */
    public void setTitleSortie(TitledBorder titleSortie) {
        this.titleSortie = titleSortie;
    }

    /**
     *
     * @return
     */
    public JLabel getInformationsSortie() {
        return informationsSortie;
    }

    /**
     *
     * @param informationsSortie
     */
    public void setInformationsSortie(JLabel informationsSortie) {
        this.informationsSortie = informationsSortie;
    }

    /**
     *
     * @return
     */
    public ImageIcon getSaveSortie() {
        return saveSortie;
    }

    /**
     *
     * @param saveSortie
     */
    public void setSaveSortie(ImageIcon saveSortie) {
        this.saveSortie = saveSortie;
    }

    /**
     *
     * @return
     */
    public Image getSaveImSortie() {
        return saveImSortie;
    }

    /**
     *
     * @param saveImSortie
     */
    public void setSaveImSortie(Image saveImSortie) {
        this.saveImSortie = saveImSortie;
    }

    /**
     *
     * @return
     */
    public Image getSaveImFinSortie() {
        return saveImFinSortie;
    }

    /**
     *
     * @param saveImFinSortie
     */
    public void setSaveImFinSortie(Image saveImFinSortie) {
        this.saveImFinSortie = saveImFinSortie;
    }

    /**
     *
     * @return
     */
    public JButton getButtonSaveSortie() {
        return buttonSaveSortie;
    }

    /**
     *
     * @param buttonSaveSortie
     */
    public void setButtonSaveSortie(JButton buttonSaveSortie) {
        this.buttonSaveSortie = buttonSaveSortie;
    }

    /**
     *
     * @return
     */
    public JScrollPane getScrollSortie() {
        return scrollSortie;
    }

    /**
     *
     * @param scrollSortie
     */
    public void setScrollSortie(JScrollPane scrollSortie) {
        this.scrollSortie = scrollSortie;
    }

    /**
     *
     * @return
     */
    public JPanel getPrescriptionHaut() {
        return prescriptionHaut;
    }

    /**
     *
     * @param prescriptionHaut
     */
    public void setPrescriptionHaut(JPanel prescriptionHaut) {
        this.prescriptionHaut = prescriptionHaut;
    }

    /**
     *
     * @return
     */
    public JLabel getPrescriptionRadio() {
        return prescriptionRadio;
    }

    /**
     *
     * @param prescriptionRadio
     */
    public void setPrescriptionRadio(JLabel prescriptionRadio) {
        this.prescriptionRadio = prescriptionRadio;
    }

    /**
     *
     * @return
     */
    public JButton getButtonRadio() {
        return buttonRadio;
    }

    /**
     *
     * @param buttonRadio
     */
    public void setButtonRadio(JButton buttonRadio) {
        this.buttonRadio = buttonRadio;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelDMA() {
        return panelDMA;
    }

    /**
     *
     * @param panelDMA
     */
    public void setPanelDMA(JPanel panelDMA) {
        this.panelDMA = panelDMA;
    }

    /**
     *
     * @return
     */
    public JScrollPane gettActeDMA() {
        return tActeDMA;
    }

    /**
     *
     * @param tActeDMA
     */
    public void settActeDMA(JScrollPane tActeDMA) {
        this.tActeDMA = tActeDMA;
    }

    /**
     *
     * @return
     */
    public Border getLoweredBevelBorderListeDMA() {
        return LoweredBevelBorderListeDMA;
    }

    /**
     *
     * @param LoweredBevelBorderListeDMA
     */
    public void setLoweredBevelBorderListeDMA(Border LoweredBevelBorderListeDMA) {
        this.LoweredBevelBorderListeDMA = LoweredBevelBorderListeDMA;
    }

    /**
     *
     * @return
     */
    public TitledBorder getTitleListeActeDMA() {
        return titleListeActeDMA;
    }

    /**
     *
     * @param titleListeActeDMA
     */
    public void setTitleListeActeDMA(TitledBorder titleListeActeDMA) {
        this.titleListeActeDMA = titleListeActeDMA;
    }

    /**
     *
     * @return
     */
    public JTable getTableauActeDMA() {
        return tableauActeDMA;
    }

    /**
     *
     * @param tableauActeDMA
     */
    public void setTableauActeDMA(JTable tableauActeDMA) {
        this.tableauActeDMA = tableauActeDMA;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelSouthDMA() {
        return panelSouthDMA;
    }

    /**
     *
     * @param panelSouthDMA
     */
    public void setPanelSouthDMA(JPanel panelSouthDMA) {
        this.panelSouthDMA = panelSouthDMA;
    }

    /**
     *
     * @return
     */
    public JScrollPane getPresDMA() {
        return presDMA;
    }

    /**
     *
     * @param presDMA
     */
    public void setPresDMA(JScrollPane presDMA) {
        this.presDMA = presDMA;
    }

    /**
     *
     * @return
     */
    public JPanel getFichePrescriptionDMA() {
        return fichePrescriptionDMA;
    }

    /**
     *
     * @param fichePrescriptionDMA
     */
    public void setFichePrescriptionDMA(JPanel fichePrescriptionDMA) {
        this.fichePrescriptionDMA = fichePrescriptionDMA;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelSortieDMA() {
        return panelSortieDMA;
    }

    /**
     *
     * @param panelSortieDMA
     */
    public void setPanelSortieDMA(JPanel panelSortieDMA) {
        this.panelSortieDMA = panelSortieDMA;
    }

    /**
     *
     * @return
     */
    public JScrollPane getScrollSortieDMA() {
        return scrollSortieDMA;
    }

    /**
     *
     * @param scrollSortieDMA
     */
    public void setScrollSortieDMA(JScrollPane scrollSortieDMA) {
        this.scrollSortieDMA = scrollSortieDMA;
    }

    /**
     *
     * @return
     */
    public JTabbedPane getDetailsDMA() {
        return detailsDMA;
    }

    /**
     *
     * @param detailsDMA
     */
    public void setDetailsDMA(JTabbedPane detailsDMA) {
        this.detailsDMA = detailsDMA;
    }

    /**
     *
     * @return
     */
    public JTextArea getPrescriptionDMA() {
        return prescriptionDMA;
    }

    /**
     *
     * @param prescriptionDMA
     */
    public void setPrescriptionDMA(JTextArea prescriptionDMA) {
        this.prescriptionDMA = prescriptionDMA;
    }

    /**
     *
     * @return
     */
    public Border getLoweredBevelBorderPresDMA() {
        return LoweredBevelBorderPresDMA;
    }

    /**
     *
     * @param LoweredBevelBorderPresDMA
     */
    public void setLoweredBevelBorderPresDMA(Border LoweredBevelBorderPresDMA) {
        this.LoweredBevelBorderPresDMA = LoweredBevelBorderPresDMA;
    }

    /**
     *
     * @return
     */
    public TitledBorder getTitlePrescDMA() {
        return titlePrescDMA;
    }

    /**
     *
     * @param titlePrescDMA
     */
    public void setTitlePrescDMA(TitledBorder titlePrescDMA) {
        this.titlePrescDMA = titlePrescDMA;
    }

    /**
     *
     * @return
     */
    public JTextArea getLettreSortieDMA() {
        return lettreSortieDMA;
    }

    /**
     *
     * @param lettreSortieDMA
     */
    public void setLettreSortieDMA(JTextArea lettreSortieDMA) {
        this.lettreSortieDMA = lettreSortieDMA;
    }

    /**
     *
     * @return
     */
    public Border getLoweredBevelBorderSortieDMA() {
        return LoweredBevelBorderSortieDMA;
    }

    /**
     *
     * @param LoweredBevelBorderSortieDMA
     */
    public void setLoweredBevelBorderSortieDMA(Border LoweredBevelBorderSortieDMA) {
        this.LoweredBevelBorderSortieDMA = LoweredBevelBorderSortieDMA;
    }

    /**
     *
     * @return
     */
    public TitledBorder getTitleSortieDMA() {
        return titleSortieDMA;
    }

    /**
     *
     * @param titleSortieDMA
     */
    public void setTitleSortieDMA(TitledBorder titleSortieDMA) {
        this.titleSortieDMA = titleSortieDMA;
    }

    /**
     *
     * @return
     */
    public JButton getAjoutPat() {
        return ajoutPat;
    }

    /**
     *
     * @param ajoutPat
     */
    public void setAjoutPat(JButton ajoutPat) {
        this.ajoutPat = ajoutPat;
    }

    /**
     *
     * @return
     */
    public ImageIcon getPlusPat() {
        return plusPat;
    }

    /**
     *
     * @param plusPat
     */
    public void setPlusPat(ImageIcon plusPat) {
        this.plusPat = plusPat;
    }

    /**
     *
     * @return
     */
    public Image getPlusImPat() {
        return plusImPat;
    }

    /**
     *
     * @param plusImPat
     */
    public void setPlusImPat(Image plusImPat) {
        this.plusImPat = plusImPat;
    }

    /**
     *
     * @return
     */
    public Image getPlusImFinPat() {
        return plusImFinPat;
    }

    /**
     *
     * @param plusImFinPat
     */
    public void setPlusImFinPat(Image plusImFinPat) {
        this.plusImFinPat = plusImFinPat;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelNouveauDMA() {
        return panelNouveauDMA;
    }

    /**
     *
     * @param panelNouveauDMA
     */
    public void setPanelNouveauDMA(JPanel panelNouveauDMA) {
        this.panelNouveauDMA = panelNouveauDMA;
    }

    /**
     *
     * @return
     */
    public JButton getButtonNouveauDMA() {
        return buttonNouveauDMA;
    }

    /**
     *
     * @param buttonNouveauDMA
     */
    public void setButtonNouveauDMA(JButton buttonNouveauDMA) {
        this.buttonNouveauDMA = buttonNouveauDMA;
    }

    /**
     *
     * @return
     */
    public JButton getModifLoc() {
        return modifLoc;
    }

    /**
     *
     * @param modifLoc
     */
    public void setModifLoc(JButton modifLoc) {
        this.modifLoc = modifLoc;
    }

    /**
     *
     * @return
     */
    public JButton getButtonResultatRadio() {
        return buttonResultatRadio;
    }

    /**
     *
     * @param buttonResultatRadio
     */
    public void setButtonResultatRadio(JButton buttonResultatRadio) {
        this.buttonResultatRadio = buttonResultatRadio;
    }

}
