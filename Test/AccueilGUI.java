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
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
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
    // private static final Color LIGHT_BLUE = new Color(100, 180, 200);
    //    private static final Color LIGHT_BLUE = new Color(132, 195, 201);
    private static final Color LIGHT_BLUE = new Color(152, 208, 223);
    //private static final Color LIGHT_BLUE = new Color(183, 204, 205);
    // private static final Color LIGHT_BLUE = new Color(213, 240, 240);
    private static final Color LIGHT_BLUE2 = new Color(100, 180, 200, 150);
    private static final Color BLUE = new Color(225, 248, 255);
    private static final Color BLUE2 = new Color(87, 139, 141);
//    private static final Color GREYFOND = new Color(227, 237, 238);
//    private static final Color GREY = new Color(216, 242, 245);
    private static final Color GREY = new Color(241, 244, 244);
    private static final Color GREYFOND = new Color(9, 121, 131);

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
    //
//Côté DMA   
    private JPanel panelDMAHaut; //Création du Panel du haut de la partie DMA
    private JPanel panelInfoPatientDMA; //Création du Panel contenant les informations du Patient
    private JPanel panelTestDMA;
    private JPanel patientNomDMA;
    private JPanel pPrenomDMA;
    private JPanel patientSexeDMA;
    private JPanel patientDateDMA;
    private JPanel patientAdresseDMA;
    private JPanel panelListeDMA;
    private JPanel panelPlusDMA;
    private JScrollPane tDMA;
    private JPanel panelDetailDMA;
    private JPanel panelFicheDMA;
    private JSplitPane DMA;

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
    private JTextArea resultatInfo;
    private Border LoweredBevelBorderRes;
    private TitledBorder titleRes;

    private TitledBorder title;

//// Droite DMA
    private TitledBorder titleInfoDMA;
    private Image img2DMA;
    private Image newimg2DMA;
    private JLabel image2DMA;
    private Image imgFDMA;
    private Image newimgFDMA;

    //Informations du patient
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

    // Tableau des DMAs
    private TitledBorder titleListeDMA;
    private JTable tableauDMA;
    private JButton ajoutActeDMA;
    private ImageIcon plusDMA;
    private Image plusImDMA;
    private Image plusImFinDMA;

    //Détails des DMAs
    private TitledBorder titleDetailDMA;
    private TitledBorder titleDMA;

    public AccueilGUI() {
        accueil = new JFrame("Accueil");
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

//// Panel gauche
        barreRecherche = new JTextField("Tapez votre recherche ici...");
        rechercher = new JButton("🔍");
        choix = new JComboBox();
        retour = new JButton("↶");

////Côté DM
        panelDMHaut = new JPanel((new GridLayout(1, 2)));
        panelDM = new JPanel(new BorderLayout());

        ///
        panelInfoPatient = new JPanel(); //Création du Panel contenant les informations du Patient
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
        ficheResultat = new JPanel(new BorderLayout());
        //
        DM = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelDMHaut, panelSouthDM);   //Création du Panel DM
        //

////Côté DMA
        panelDMAHaut = new JPanel((new GridLayout(1, 2)));  //Création du Panel du haut de la partie DMA

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
        panelFicheDMA = new JPanel(new GridLayout(2, 2));
        DMA = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelDMAHaut, panelDetailDMA);

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
        //titleInfo = BorderFactory.createTitledBorder("informations du patient");
        //  titleInfo.setTitleColor(GREYFOND);
        LoweredBevelBorderInfo = BorderFactory.createLoweredBevelBorder();
        titleInfo = BorderFactory.createTitledBorder(LoweredBevelBorderInfo, "informations du patient",
                TitledBorder.LEFT, TitledBorder.TOP
        );

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
        titleDM = BorderFactory.createTitledBorder(LoweredBevelBorderDM, "Dossier médicaux",
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
        ajoutDM.setToolTipText("Cliquez ici pour ajouter un nouvel acte");

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

//Création du Panel DM
        title = BorderFactory.createTitledBorder("informations générales");
        DM.setBorder(title);

///////////////// Panel DMA /////////////////
        //Création du Panel contenant les informations du Patient
        titleInfoDMA = BorderFactory.createTitledBorder("informations du patient");
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

//Création du Panel contenant la liste des DMAs du patient 
        titleListeDMA = BorderFactory.createTitledBorder("Liste des DMAs");
        panelListeDMA.setBorder(titleListeDMA);

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
        ajoutActeDMA.setToolTipText("Cliquez ici pour ajouter un nouvel acte");

//Création du Panel avec les détails du DMA sur lequel on a cliqué
        titleDetailDMA = BorderFactory.createTitledBorder("Détails de ce DMA");
        panelDetailDMA.setBorder(titleDetailDMA);

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
        titleDMA = BorderFactory.createTitledBorder("informations générales");
        DMA.setBorder(titleDMA);

///////////////////// On ajoute les éléments les uns dans les autres ///////////////////// 
        prez.add(presentation);
        prez.add(presentation2); // Pourquoi y'en a deux ?
        panPatients.add(t, BorderLayout.CENTER);

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
        fichePrescription.add(pres, BorderLayout.CENTER);
        fichePrescription.add(panelSavePres, BorderLayout.SOUTH);
        detailsDM.add("Prescriptions", fichePrescription);

        panelSaveOp.add(buttonSaveOp, BorderLayout.EAST);
        ficheOperation.add(op, BorderLayout.CENTER);
        ficheOperation.add(panelSaveOp, BorderLayout.SOUTH);
        detailsDM.add("Opérations", ficheOperation);

        panelSaveRes.add(buttonSaveRes, BorderLayout.EAST);
        ficheResultat.add(result, BorderLayout.CENTER);
        ficheResultat.add(panelSaveRes, BorderLayout.SOUTH);
        detailsDM.add("Résultats", ficheResultat);

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

        panelInfoPatientDMA.add(panelTestDMA);
        panelListeDMA.add(tDMA);
        panelPlusDMA.add(ajoutActeDMA, BorderLayout.EAST);
        panelListeDMA.add(panelPlusDMA, BorderLayout.NORTH);

        panelDMAHaut.add(panelInfoPatientDMA);
        panelDMAHaut.add(panelListeDMA);
        panelDMAHaut.setPreferredSize(new Dimension(200, 300));

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
        panelRechercheDroit.setOpaque(false);

        ///////////////////// On ajoute la couleur aux éléments ///////////////////// 
        panelHaut.setBackground(LIGHT_BLUE);
        panelDroit.setBackground(LIGHT_BLUE);
        panPatients.setBackground(LIGHT_BLUE); // Panel de gauche
        panelMessage.setBackground(LIGHT_BLUE);
        panelRecherche.setBackground(LIGHT_BLUE);

        ficheObservations.setBackground(LIGHT_BLUE);
        fichePrescription.setBackground(LIGHT_BLUE);
        ficheOperation.setBackground(LIGHT_BLUE);
        ficheResultat.setBackground(LIGHT_BLUE);
        panelSaveObs.setBackground(LIGHT_BLUE);
        panelSavePres.setBackground(LIGHT_BLUE);
        panelSaveOp.setBackground(LIGHT_BLUE);
        panelSaveRes.setBackground(LIGHT_BLUE);

        panelListe.setBackground(GREY);
        panelDetail.setBackground(GREY);
        panelDM.setBackground(GREY);
        panelInfoPatient.setBackground(GREY);
        panelInfoPatientDMA.setBackground(GREY);
        panelListeDMA.setBackground(GREY);
        panelDetailDMA.setBackground(GREY);

        t.setBackground(LIGHT_BLUE); //Tour des tableaux (scrollbar)
        tDMA.setBackground(LIGHT_BLUE);
        ScrollDM.setBackground(LIGHT_BLUE);
        tActeDM.setBackground(LIGHT_BLUE);

        tableau.setBackground(GREY); //Cases des tableaux
        tableauDMA.setBackground(GREY);
        tableauDM.setBackground(GREY);
        tableauActeDm.setBackground(GREY);

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
        return panPatients;
    }

    public void setPanHistorique(JPanel panPatients) {
        this.panPatients = panPatients;
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

    public JScrollPane gettActeDM() {
        return tActeDM;
    }

    public void settActeDM(JScrollPane tActeDM) {
        this.tActeDM = tActeDM;
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

    public JPanel getPanelInfoPatientDMA() {
        return panelInfoPatientDMA;
    }

    public void setPanelInfoPatientDMA(JPanel panelInfoPatientDMA) {
        this.panelInfoPatientDMA = panelInfoPatientDMA;
    }

    public JPanel getPanelTestDMA() {
        return panelTestDMA;
    }

    public void setPanelTestDMA(JPanel panelTest2) {
        this.panelTestDMA = panelTest2;
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

    public JPanel getPanelListeDMA() {
        return panelListeDMA;
    }

    public void setPanelListeDMA(JPanel panelListeDMA) {
        this.panelListeDMA = panelListeDMA;
    }

    public JScrollPane gettDMA() {
        return tDMA;
    }

    public void settDMA(JScrollPane tDMA) {
        this.tDMA = tDMA;
    }

    public JPanel getPanelDetail2() {
        return panelDetailDMA;
    }

    public void setPanelDetail2(JPanel panelDetail2) {
        this.panelDetailDMA = panelDetail2;
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

    public TitledBorder getTitleInfoDMA() {
        return titleInfoDMA;
    }

    public void setTitleInfoDMA(TitledBorder titleInfo2) {
        this.titleInfoDMA = titleInfo2;
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

    public TitledBorder getTitleListeDMA() {
        return titleListeDMA;
    }

    public void setTitleListe2(TitledBorder titleListe2) {
        this.titleListeDMA = titleListe2;
    }

    public JTable getTableauDMA() {
        return tableauDMA;
    }

    public void setTableauDMA(JTable tableauDMA) {
        this.tableauDMA = tableauDMA;
    }

    public TitledBorder getTitleDetail2() {
        return titleDetailDMA;
    }

    public void setTitleDetailDMA(TitledBorder titleDetailDMA) {
        this.titleDetailDMA = titleDetailDMA;
    }

    public TitledBorder getTitleDMA() {
        return titleDMA;
    }

    public void setTitleDMA(TitledBorder titleDMA) {
        this.titleDMA = titleDMA;
    }

    public JButton getAjoutActe() {
        return ajoutActe;
    }

    public void setAjoutActe(JButton ajoutActe) {
        this.ajoutActe = ajoutActe;
    }

    public ImageIcon getPlus() {
        return plus;
    }

    public void setPlus(ImageIcon plus) {
        this.plus = plus;
    }

    public Image getPlusIm() {
        return plusIm;
    }

    public void setPlusIm(Image plusIm) {
        this.plusIm = plusIm;
    }

    public Image getPlusImFin() {
        return plusImFin;
    }

    public void setPlusImFin(Image plusImFin) {
        this.plusImFin = plusImFin;
    }

    public JPanel getPanPatients() {
        return panPatients;
    }

    public void setPanPatients(JPanel panPatients) {
        this.panPatients = panPatients;
    }

    public JPanel getPanelPlus() {
        return panelPlus;
    }

    public void setPanelPlus(JPanel panelPlus) {
        this.panelPlus = panelPlus;
    }

    public JTabbedPane getDetailsDM() {
        return detailsDM;
    }

    public void setDetailsDM(JTabbedPane detailsDM) {
        this.detailsDM = detailsDM;
    }

    public JPanel getPanelRecherche() {
        return panelRecherche;
    }

    public void setPanelRecherche(JPanel panelRecherche) {
        this.panelRecherche = panelRecherche;
    }

    public JTextField getBarreRecherche() {
        return barreRecherche;
    }

    public void setBarreRecherche(JTextField barreRecherche) {
        this.barreRecherche = barreRecherche;
    }

    public JButton getRechercher() {
        return rechercher;
    }

    public void setRechercher(JButton rechercher) {
        this.rechercher = rechercher;
    }

    public JComboBox getChoix() {
        return choix;
    }

    public void setChoix(JComboBox choix) {
        this.choix = choix;
    }

    public JPanel getPanelRechercheDroit() {
        return panelRechercheDroit;
    }

    public void setPanelRechercheDroit(JPanel panelRechercheDroit) {
        this.panelRechercheDroit = panelRechercheDroit;
    }

    public JButton getRetour() {
        return retour;
    }

    public void setRetour(JButton retour) {
        this.retour = retour;
    }

    public JPanel getPanelDM() {
        return panelDM;
    }

    public void setPanelDM(JPanel panelDM) {
        this.panelDM = panelDM;
    }

    public JScrollPane getScrollDM() {
        return ScrollDM;
    }

    public void setScrollDM(JScrollPane ScrollDM) {
        this.ScrollDM = ScrollDM;
    }

    public JPanel getPanelSouthDM() {
        return panelSouthDM;
    }

    public void setPanelSouthDM(JPanel panelSouthDM) {
        this.panelSouthDM = panelSouthDM;
    }

    public JPanel getPanelPlusDMA() {
        return panelPlusDMA;
    }

    public void setPanelPlusDMA(JPanel panelPlusDMA) {
        this.panelPlusDMA = panelPlusDMA;
    }

    public JPanel getPanelDetailDMA() {
        return panelDetailDMA;
    }

    public void setPanelDetailDMA(JPanel panelDetailDMA) {
        this.panelDetailDMA = panelDetailDMA;
    }

    public TitledBorder getTitleDM() {
        return titleDM;
    }

    public void setTitleDM(TitledBorder titleDM) {
        this.titleDM = titleDM;
    }

    public JButton getAjoutDM() {
        return ajoutDM;
    }

    public void setAjoutDM(JButton ajoutDM) {
        this.ajoutDM = ajoutDM;
    }

    public ImageIcon getPlusDM() {
        return plusDM;
    }

    public void setPlusDM(ImageIcon plusDM) {
        this.plusDM = plusDM;
    }

    public Image getPlusImDM() {
        return plusImDM;
    }

    public void setPlusImDM(Image plusImDM) {
        this.plusImDM = plusImDM;
    }

    public Image getPlusImFinDM() {
        return plusImFinDM;
    }

    public void setPlusImFinDM(Image plusImFinDM) {
        this.plusImFinDM = plusImFinDM;
    }

    public JTable getTableauActeDm() {
        return tableauActeDm;
    }

    public void setTableauActeDm(JTable tableauActeDm) {
        this.tableauActeDm = tableauActeDm;
    }

    public JButton getAjoutActeDMA() {
        return ajoutActeDMA;
    }

    public void setAjoutActeDMA(JButton ajoutActeDMA) {
        this.ajoutActeDMA = ajoutActeDMA;
    }

    public ImageIcon getPlusDMA() {
        return plusDMA;
    }

    public void setPlusDMA(ImageIcon plusDMA) {
        this.plusDMA = plusDMA;
    }

    public Image getPlusImDMA() {
        return plusImDMA;
    }

    public void setPlusImDMA(Image plusImDMA) {
        this.plusImDMA = plusImDMA;
    }

    public Image getPlusImFinDMA() {
        return plusImFinDMA;
    }

    public void setPlusImFinDMA(Image plusImFinDMA) {
        this.plusImFinDMA = plusImFinDMA;
    }

    public JButton getAjoutDMA() {
        return ajoutActeDMA;
    }

    public void setAjoutDMA(JButton ajoutActeDMA) {
        this.ajoutActeDMA = ajoutActeDMA;
    }

    public JPanel getPanelSave() {
        return panelSaveObs;
    }

    public void setPanelSave(JPanel panelSaveObs) {
        this.panelSaveObs = panelSaveObs;
    }

    public Border getLoweredBevelBorderInfo() {
        return LoweredBevelBorderInfo;
    }

    public void setLoweredBevelBorderInfo(Border LoweredBevelBorderInfo) {
        this.LoweredBevelBorderInfo = LoweredBevelBorderInfo;
    }

    public Border getLoweredBevelBorderDM() {
        return LoweredBevelBorderDM;
    }

    public void setLoweredBevelBorderDM(Border LoweredBevelBorderDM) {
        this.LoweredBevelBorderDM = LoweredBevelBorderDM;
    }

    public Border getLoweredBevelBorderListe() {
        return LoweredBevelBorderListe;
    }

    public void setLoweredBevelBorderListe(Border LoweredBevelBorderListe) {
        this.LoweredBevelBorderListe = LoweredBevelBorderListe;
    }

    public Border getLoweredBevelBorderDetail() {
        return LoweredBevelBorderDetail;
    }

    public void setLoweredBevelBorderDetail(Border LoweredBevelBorderDetail) {
        this.LoweredBevelBorderDetail = LoweredBevelBorderDetail;
    }

    public Border getLoweredBevelBorderObs() {
        return LoweredBevelBorderObs;
    }

    public void setLoweredBevelBorderObs(Border LoweredBevelBorderObs) {
        this.LoweredBevelBorderObs = LoweredBevelBorderObs;
    }

    public Border getLoweredBevelBorderPres() {
        return LoweredBevelBorderPres;
    }

    public void setLoweredBevelBorderPres(Border LoweredBevelBorderPres) {
        this.LoweredBevelBorderPres = LoweredBevelBorderPres;
    }

    public Border getLoweredBevelBorderOp() {
        return LoweredBevelBorderOp;
    }

    public void setLoweredBevelBorderOp(Border LoweredBevelBorderOp) {
        this.LoweredBevelBorderOp = LoweredBevelBorderOp;
    }

    public Border getLoweredBevelBorderRes() {
        return LoweredBevelBorderRes;
    }

    public void setLoweredBevelBorderRes(Border LoweredBevelBorderRes) {
        this.LoweredBevelBorderRes = LoweredBevelBorderRes;
    }

    public JPanel getPanelSaveObs() {
        return panelSaveObs;
    }

    public void setPanelSaveObs(JPanel panelSaveObs) {
        this.panelSaveObs = panelSaveObs;
    }

    public JPanel getPanelSavePres() {
        return panelSavePres;
    }

    public void setPanelSavePres(JPanel panelSavePres) {
        this.panelSavePres = panelSavePres;
    }

    public JPanel getPanelSaveOp() {
        return panelSaveOp;
    }

    public void setPanelSaveOp(JPanel panelSaveOp) {
        this.panelSaveOp = panelSaveOp;
    }

    public JPanel getPanelSaveRes() {
        return panelSaveRes;
    }

    public void setPanelSaveRes(JPanel panelSaveRes) {
        this.panelSaveRes = panelSaveRes;
    }

    public ImageIcon getSaveObs() {
        return saveObs;
    }

    public void setSaveObs(ImageIcon saveObs) {
        this.saveObs = saveObs;
    }

    public Image getSaveImObs() {
        return saveImObs;
    }

    public void setSaveImObs(Image saveImObs) {
        this.saveImObs = saveImObs;
    }

    public Image getSaveImFinObs() {
        return saveImFinObs;
    }

    public void setSaveImFinObs(Image saveImFinObs) {
        this.saveImFinObs = saveImFinObs;
    }

    public JButton getButtonSaveObs() {
        return buttonSaveObs;
    }

    public void setButtonSaveObs(JButton buttonSaveObs) {
        this.buttonSaveObs = buttonSaveObs;
    }

    public ImageIcon getSavePres() {
        return savePres;
    }

    public void setSavePres(ImageIcon savePres) {
        this.savePres = savePres;
    }

    public Image getSaveImPres() {
        return saveImPres;
    }

    public void setSaveImPres(Image saveImPres) {
        this.saveImPres = saveImPres;
    }

    public Image getSaveImFinPres() {
        return saveImFinPres;
    }

    public void setSaveImFinPres(Image saveImFinPres) {
        this.saveImFinPres = saveImFinPres;
    }

    public JButton getButtonSavePres() {
        return buttonSavePres;
    }

    public void setButtonSavePres(JButton buttonSavePres) {
        this.buttonSavePres = buttonSavePres;
    }

    public ImageIcon getSaveOp() {
        return saveOp;
    }

    public void setSaveOp(ImageIcon saveOp) {
        this.saveOp = saveOp;
    }

    public Image getSaveImOp() {
        return saveImOp;
    }

    public void setSaveImOp(Image saveImOp) {
        this.saveImOp = saveImOp;
    }

    public Image getSaveImFinOp() {
        return saveImFinOp;
    }

    public void setSaveImFinOp(Image saveImFinOp) {
        this.saveImFinOp = saveImFinOp;
    }

    public JButton getButtonSaveOp() {
        return buttonSaveOp;
    }

    public void setButtonSaveOp(JButton buttonSaveOp) {
        this.buttonSaveOp = buttonSaveOp;
    }

    public ImageIcon getSaveRes() {
        return saveRes;
    }

    public void setSaveRes(ImageIcon saveRes) {
        this.saveRes = saveRes;
    }

    public Image getSaveImRes() {
        return saveImRes;
    }

    public void setSaveImRes(Image saveImRes) {
        this.saveImRes = saveImRes;
    }

    public Image getSaveImFinRes() {
        return saveImFinRes;
    }

    public void setSaveImFinRes(Image saveImFinRes) {
        this.saveImFinRes = saveImFinRes;
    }

    public JButton getButtonSaveRes() {
        return buttonSaveRes;
    }

    public void setButtonSaveRes(JButton buttonSaveRes) {
        this.buttonSaveRes = buttonSaveRes;
    }

}
