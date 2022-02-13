/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author lenal
 */
import NF.DM;
import NF.Date;
import NF.FichesDM;
import NF.NomService;
import NF.Patient;
import NF.Patient.Sexe;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.TitledBorder;
import NF.Personnel;
import NF.Personnel.Poste;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

/**
 *
 * @author lenal
 */
public class AccueilPH implements Runnable {

    //Listeners 
    protected Deconnexion deco;

    //Variable graphique 
    protected JFrame accueil;

// Variable pour la couleur des fenêtres
    private static final Color LIGHT_BLUE = new Color(100, 180, 200);

    //Autres variables
    protected Personnel p;

    //Variable test pendant qu'on n'a pas de BDD
    Patient patient = new Patient("Fowler", "Sage", Sexe.FEMME, "5 avenue libération", new Date(23, 10, 1999));
    DM dm1 = new DM(patient);
    FichesDM fiche = new FichesDM(patient, "Lorem ipsum dolor sit amet. Ut sunt esse et voluptas ullam qui fuga eius et voluptates molestiae hic facere cupiditate et aliquid quis. Id voluptatem veniam et nihil Quis eum galisum ducimus et architecto nesciunt ut provident soluta et perspiciatis consequatur! Et ullam molestias aut placeat laborum et voluptate voluptas. A possimus aspernatur aut modi animi ut officia maxime est repellendus exercitationem.", "prescription", "operation", "resultats", "correspondance");

    public AccueilPH() {
        p = new Personnel("Bon", "Jean", NomService.CARDIOLOGIE, Poste.PHService, "ddd", "fff");
        accueil = new JFrame("Accueil");

    }

    @Override
    public void run() {

        //////////////////////////// Création de la fenêtre de accueil  ////////////////////////////
        accueil.setDefaultCloseOperation(EXIT_ON_CLOSE);

        accueil.setBounds(0, 20, 1200, 900);
        accueil.setVisible(true);

        JPanel panelFin = new JPanel(new BorderLayout());

        JPanel panelDroit = new JPanel(new BorderLayout());
        //panelDroit.setLayout(new GridLayout(2, 1));
        JPanel panelGauche = new JPanel(new BorderLayout());
        JPanel panelHaut = new JPanel(new BorderLayout());
        panelHaut.setBackground(LIGHT_BLUE);

        panelDroit.setBackground(LIGHT_BLUE);

        JSplitPane splitPan = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT, panelGauche, panelDroit);
        splitPan.setResizeWeight(0.2);

        //////////////////////////// Panel haut ////////////////////////////
        ImageIcon image = new ImageIcon("src/Annexes/deco.jpg");
        Image img = image.getImage(); // Convertissemnt pour pouvoir redimensionner
        Image newimg = img.getScaledInstance(60, 32, java.awt.Image.SCALE_SMOOTH); // On choisit la taille de l'image
        image = new ImageIcon(newimg); // On reconvertit

        JButton deconnexion = new JButton(image);
        deconnexion.setContentAreaFilled(false);
        deconnexion.setBorderPainted(false);
        deconnexion.setToolTipText("Cliquez ici pour vous déconnecter");

        JButton ajoutActe = new JButton("+");
        ajoutActe.setToolTipText("Cliquez ici pour ajouter un acte");
        JLabel presentation = new JLabel();
        presentation.setText("Bienvenue " + p.getNom().toUpperCase() + " " + p.getPrenom() + "\n " + p.getPoste() + " - " + p.getNomService());
        presentation.setHorizontalAlignment(SwingConstants.CENTER);
        presentation.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
        presentation.setBackground(LIGHT_BLUE);

        ////////////////////////////Panel Gauche ////////////////////////////
        ///////////////// Panel tri /////////////////
        //Variables utilisées pour le tri
        Vector<String> choixTri = new Vector<String>();
        JTextField dateBasJour = new JTextField("JJ");
        JTextField dateHautJour = new JTextField("JJ");
        JTextField dateBasMois = new JTextField("MM");
        JTextField dateHautMois = new JTextField("MM");
        JTextField dateBasAnnee = new JTextField("AAAA");
        JTextField dateHautAnnee = new JTextField("AAAA");
        JButton ok = new JButton("Valider");
        JButton voirTout = new JButton("voirTout");
        JComboBox tri = new JComboBox(choixTri);

        JPanel panTriFin = new JPanel(new BorderLayout());
        JPanel panTri = new JPanel(new FlowLayout());
        JPanel panTri2 = new JPanel(new FlowLayout());
        JLabel preference = new JLabel("Préférence de tri : ");
        preference.setFont(new Font("Arial Nova", Font.PLAIN, 15));
        panTriFin.add(panTri, BorderLayout.NORTH);
        panTriFin.add(panTri2);
        choixTri.add("Du plus récent au plus ancien");
        choixTri.add("Du plus ancien au plus récent");

        JLabel info = new JLabel("(De haut en bas) ");
        panTri.add(preference);
        panTri.add(tri);
        panTri.add(info);
        panTri.setBackground(LIGHT_BLUE);
        panTri2.setBackground(LIGHT_BLUE);

        JLabel dateInf = new JLabel("Afficher les fiches entre le ");
        JLabel dateInf2 = new JLabel(" et le ");

        dateBasJour.setPreferredSize(new Dimension(23, 18));
        dateBasMois.setPreferredSize(new Dimension(23, 18));
        dateBasAnnee.setPreferredSize(new Dimension(38, 18));
        dateHautJour.setPreferredSize(new Dimension(23, 18));
        dateHautMois.setPreferredSize(new Dimension(23, 18));
        dateHautAnnee.setPreferredSize(new Dimension(38, 18));

        panTri2.add(dateInf);
        panTri2.add(dateBasJour);

        panTri2.add(dateBasMois);
        panTri2.add(dateBasAnnee);
        panTri2.add(dateInf2);
        panTri2.add(dateHautJour);
        panTri2.add(dateHautMois);
        panTri2.add(dateHautAnnee);
        panTri2.add(ok);
        panTri2.add(voirTout);

        ///////////////// Panel Historique /////////////////
        JPanel panHistorique = new JPanel(new BorderLayout());
        TitledBorder titre3 = BorderFactory.createTitledBorder("Historique des visites");
        panHistorique.setBorder(titre3);
        panHistorique.setBackground(LIGHT_BLUE);

        JTable tableau = new JTable(new ModelTableau());
        JScrollPane t = new JScrollPane(tableau);
        t.setOpaque(true);
        tableau.setBackground(LIGHT_BLUE);
        t.setBackground(LIGHT_BLUE);
        panHistorique.add(t, BorderLayout.CENTER);

        ////////////////////////////Panel Droit ////////////////////////////
        JLabel messageArrive = new JLabel("Veuillez cliquer sur un patient pour voir ses informations apparaître ici "); //Le texte "Nom d'utilisateur :"
        messageArrive.setFont(new Font("Bookman Old Style", Font.PLAIN, 18)); //On modifie la police et la taille de l'écriture
        JPanel panelMessage = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(50, 0, 5, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panelMessage.add(messageArrive, gbc); //A revoir le gbc n'est peut-être plus nécessaire. 

        panelMessage.add(messageArrive);
        panelMessage.setBackground(LIGHT_BLUE);
        panelDroit.add(panelMessage, BorderLayout.CENTER);

        JTabbedPane tp = new JTabbedPane();
        tp.setBackground(LIGHT_BLUE);
        ///////////////// Panel DM /////////////////

        //Création du Panel du haut de la partie DM
        JPanel panelDMHaut = new JPanel((new GridLayout(1, 2)));
        panelDMHaut.setBackground(LIGHT_BLUE);

        //Création du Panel contenant les informations du Patient
        JPanel panelInfoPatient = new JPanel();
        TitledBorder titleInfo = BorderFactory.createTitledBorder("informations du patient");
        panelInfoPatient.setBorder(titleInfo);
        panelInfoPatient.setBackground(LIGHT_BLUE);

        JPanel panelTest = new JPanel(new GridBagLayout());

//Image
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(00, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;

        if (patient.getSexe() == Sexe.HOMME) {
            ImageIcon iconeH = new ImageIcon("src/Annexes/homme.png");
            Image img2 = iconeH.getImage(); // Convertissemnt pour pouvoir redimensionner
            Image newimg2 = img2.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // On choisit la taille de l'image
            iconeH = new ImageIcon(newimg2); // On reconvertit
            JLabel image2 = new JLabel(iconeH);
            panelInfoPatient.add(image2);
            panelTest.add(image2, gbc);
        } else {
            ImageIcon iconeF = new ImageIcon("src/Annexes/femme.png");
            Image img2 = iconeF.getImage(); // Convertissemnt pour pouvoir redimensionner
            Image newimg2 = img2.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // On choisit la taille de l'image
            iconeF = new ImageIcon(newimg2); // On reconvertit
            JLabel image2 = new JLabel(iconeF);
            panelTest.add(image2, gbc);

        }

// Nom
        //gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.ipadx = 0;
        gbc.insets = new Insets(20, 20, 0, 0);
        gbc.anchor = GridBagConstraints.WEST;
        // gbc.weighty = 1;
        //gbc.anchor = GridBagConstraints.CENTER;

        JLabel nom = new JLabel("Nom : ");
        nom.setFont(new Font("Cambria", Font.PLAIN, 18));
        JLabel nom2 = new JLabel(patient.getNom());
        JPanel patientNom = new JPanel();
        patientNom.setLayout(new BoxLayout(patientNom, BoxLayout.X_AXIS));
        patientNom.add(nom);
        patientNom.add(nom2);

        panelTest.add(patientNom, gbc);
        patientNom.setBackground(LIGHT_BLUE);

// Prénom
        gbc.insets = new Insets(0, 20, 0, 0);
        gbc.gridy = 2;

        JLabel prenom = new JLabel("Prénom :");
        prenom.setFont(new Font("Cambria", Font.PLAIN, 18));
        JLabel prenom2 = new JLabel(patient.getPrenom());
        JPanel pPrenom = new JPanel();
        pPrenom.setLayout(new BoxLayout(pPrenom, BoxLayout.X_AXIS));
        pPrenom.add(prenom);
        pPrenom.add(prenom2);

        panelTest.add(pPrenom, gbc);
        pPrenom.setBackground(LIGHT_BLUE);
//Sexe
        gbc.gridy = 3;

        JLabel sexe = new JLabel("Sexe : ");
        sexe.setFont(new Font("Cambria", Font.PLAIN, 18));
        JLabel sexeInfo = new JLabel("" + patient.getSexe());
        JPanel patientSexe = new JPanel();
        patientSexe.setLayout(new BoxLayout(patientSexe, BoxLayout.X_AXIS));
        patientSexe.add(sexe);
        patientSexe.add(sexeInfo);

        panelTest.add(patientSexe, gbc);
        patientSexe.setBackground(LIGHT_BLUE);

//Date de naissance
        gbc.gridy = 4;

        JLabel date = new JLabel("Date de naissance :");
        date.setFont(new Font("Cambria", Font.PLAIN, 18));
        JLabel dateInfo = new JLabel(patient.stringDate());
        JPanel patientDate = new JPanel();
        patientDate.setLayout(new BoxLayout(patientDate, BoxLayout.X_AXIS));
        patientDate.add(date);
        patientDate.add(dateInfo);

        panelTest.add(patientDate, gbc);
        patientDate.setBackground(LIGHT_BLUE);

        //Adresse
        gbc.gridy = 5;

        JLabel adresse = new JLabel("Adresse :");
        adresse.setFont(new Font("Cambria", Font.PLAIN, 18));
        JLabel adresseInfo = new JLabel(patient.getAdresse());
        JPanel patientAdresse = new JPanel();
        patientAdresse.setLayout(new BoxLayout(patientAdresse, BoxLayout.X_AXIS));
        patientAdresse.add(adresse);
        patientAdresse.add(adresseInfo);

        panelTest.add(patientAdresse, gbc);
        patientAdresse.setBackground(LIGHT_BLUE);

        panelInfoPatient.add(panelTest);
        panelTest.setBackground(LIGHT_BLUE);

        //Création du Panel contenant la liste des DMs du patient 
        JPanel panelListe = new JPanel(new BorderLayout());
        TitledBorder titleListe = BorderFactory.createTitledBorder("Liste des DMs");
        panelListe.setBorder(titleListe);
        panelListe.setBackground(LIGHT_BLUE);

        JTable tableauDM = new JTable(new ModelTableauDM());
        JScrollPane tDM = new JScrollPane(tableauDM);
        tDM.setOpaque(true);
        tableauDM.setBackground(LIGHT_BLUE);
        tDM.setBackground(LIGHT_BLUE);
        panelListe.add(tDM);

        // Ajout des deux précédents panels au premier
        panelDMHaut.add(panelInfoPatient);
        panelDMHaut.add(panelListe);
        panelDMHaut.setPreferredSize(new Dimension(200, 300));

        //Création du Panel avec les détails du DM sur lequel on a cliqué
        JPanel panelDetail = new JPanel(new BorderLayout());
        TitledBorder titleDetail = BorderFactory.createTitledBorder("Détails de ce DM");
        panelDetail.setBorder(titleDetail);
        panelDetail.setBackground(LIGHT_BLUE);
        
        JPanel panelFiche = new JPanel(new FlowLayout());

//        JPanel panelDetail = new JPanel(new GridBagLayout());
        // Nom
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        // gbc.weighty = 1;
        //gbc.anchor = GridBagConstraints.CENTER;

        JTextArea observations2 = new JTextArea(fiche.getObservations());
        observations2.setLineWrap(true);
        JPanel ficheObservations = new JPanel(new BorderLayout());
        TitledBorder titleObs = BorderFactory.createTitledBorder("Observations");
        ficheObservations.setBorder(titleObs);
        ficheObservations.add(observations2);

        panelFiche.add(ficheObservations );
        ficheObservations.setBackground(LIGHT_BLUE);

// Prénom
        //gbc.insets = new Insets(0, 20, 0, 0);
        gbc.gridx = 1;
        gbc.gridy = 0;

        JLabel prescription2 = new JLabel(fiche.getPrescriptions());
        JPanel fichePrescription = new JPanel(new BorderLayout());
        TitledBorder titlePresc = BorderFactory.createTitledBorder("Prescriptions");
        fichePrescription.setBorder(titlePresc);
        fichePrescription.add(prescription2);

        panelFiche.add(fichePrescription  );
        fichePrescription.setBackground(LIGHT_BLUE);
//Sexe
        gbc.gridy = 3;

        JLabel operation = new JLabel("Opération : ");
        sexe.setFont(new Font("Cambria", Font.PLAIN, 18));
        JLabel operationInfo = new JLabel(fiche.getOperations());
        JPanel ficheOperation = new JPanel();
        ficheOperation.add(operation);
        ficheOperation.add(operationInfo);

        //  panelFiche.add(ficheOperation, gbc);
        ficheOperation.setBackground(LIGHT_BLUE);

//Date de naissance
        // gbc.gridx = 1;
        gbc.gridy = 1;

        JLabel resultatInfo = new JLabel(fiche.getResultats());
        JPanel ficheResultat = new JPanel(new BorderLayout());
        TitledBorder titleRes = BorderFactory.createTitledBorder("Résultats");
        ficheResultat.setBorder(titleRes);
        ficheResultat.add(resultatInfo);

        panelFiche.add(ficheResultat );
         ficheResultat.setBackground(LIGHT_BLUE);

        //Création du Panel DM
        JSplitPane DM = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelDMHaut, panelDetail);
        //  DM.setResizeWeight(0.2);
        TitledBorder title = BorderFactory.createTitledBorder("informations générales");
        DM.setBorder(title);
        DM.setBackground(LIGHT_BLUE);

        //  DM.add(panelDMHaut);
        ///////////////// Panel DMA /////////////////
        JPanel DMA = new JPanel(new BorderLayout());
        TitledBorder title2;
        title2 = BorderFactory.createTitledBorder("Informations générales");
        DMA.setBorder(title2);
        DMA.setBackground(LIGHT_BLUE);

        ///////////////// Organisation des panels /////////////////
        panelHaut.add(deconnexion, BorderLayout.WEST);
        panelHaut.add(presentation, BorderLayout.CENTER);
        panelHaut.add(ajoutActe, BorderLayout.EAST);

        panelGauche.add(panTriFin, BorderLayout.NORTH);
        panelGauche.add(panHistorique);

        panelFin.add(panelHaut, BorderLayout.NORTH);
        panelFin.add(splitPan, BorderLayout.CENTER);

        accueil.add(panelFin);

        ///////////////// Gestion des listeners /////////////////
        deco = new Deconnexion(this);
        deconnexion.addActionListener(deco);

        tableau.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 1) {
                    int ligne = tableau.getSelectedRow();
                    Object cellule = tableau.getValueAt(ligne, 0);
                    String s = "" + cellule;
                    System.out.println(s);
                    panelMessage.setVisible(false);
                    tp.add("DM", DM);
                    tp.add("DMA", DMA);
                    panelDroit.add(tp);

                    patient.setNom("Zenik");
                    nom2.setText(patient.getNom());
                    patient.setPrenom("Nina");
                    prenom2.setText(patient.getPrenom());
                    patient.setSexe("FEMME");
                    sexeInfo.setText("" + patient.getSexe());
                    patient.setDateNaissance(new Date(12, 11, 2003));
                    dateInfo.setText(patient.stringDate());
                    patient.setAdresse("11 rue Edouard Vaillant");
                    adresseInfo.setText(patient.getAdresse());

                    accueil.validate();
                    accueil.repaint();

                }
            }
        });

        tableauDM.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 1) {
                    int ligne = tableauDM.getSelectedRow();
                    Object cellule = tableauDM.getValueAt(ligne, 0);
                    String s = "" + cellule;
                    System.out.println(s);

                    panelDetail.add(panelFiche);
                }
            }
        });
    }

}
