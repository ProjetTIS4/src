/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archives;

/**
 *
 * @author lenal
 */
import NF.DM;
import NF.Date;
import NF.FichesDM;
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
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

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
    protected ImageIcon iconeF;
    protected ImageIcon iconeH;
    String ipp;

    //Variable test pendant qu'on n'a pas de BDD
    Patient patient = new Patient("Fowler", "Sage", Sexe.FEMME, "5 avenue libération", new Date(23, 10, 1999));
    DM dm1 = new DM(patient);
    FichesDM fiche = new FichesDM(patient, " obs", "prescription", "operation", "resultats");

    public AccueilPH(Personnel p) {
        this.p = p;
        accueil = new JFrame("Accueil");

    }

    @Override
    public void run() {
        ipp = "";
//        initLookAndFeel();

        try {
            String url = "jdbc:mysql://hugofarcy.ddns.net:3306/SIH?autoReconnect=true&useSSL=false";
            String user = "DEV";
            String password = "SIH-mmlh2022";

            Connection con = DriverManager.getConnection(url, user, password);

            String query = "SELECT COUNT(IPP) FROM patient";
            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);

            int taille = 0;

            if (res.next()) {
                taille = res.getInt("COUNT(IPP)");
            }

            String data[][] = new String[taille][9];
            String columns[] = {"IPP", "Nom", "Prénom", "Date de Naissance", "Sexe"};
//            res2.close();
            String dataTable[][] = new String[taille][5];
            query = "SELECT * FROM patient";
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
                data[i][8] = medGen;

                i++;
            }

            DefaultTableModel model = new DefaultTableModel(dataTable, columns);
            JTable tableau = new JTable(model);

            //////////////////////////// Création de la fenêtre de accueil  ////////////////////////////
            accueil.setDefaultCloseOperation(EXIT_ON_CLOSE);

            accueil.setBounds(0, 20, 1200, 900);
            accueil.setVisible(true);
            Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
            int longueur = tailleMoniteur.width * 2 / 3;
            int hauteur = tailleMoniteur.height * 2 / 3;
//régler la taille de JFrame à 2/3 la taille de l'écran
            accueil.setSize(longueur, hauteur);

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

            //  JButton ajoutActe = new JButton("+");
            // ajoutActe.setToolTipText("Cliquez ici pour ajouter un acte");
            JPanel prez = new JPanel(new GridLayout(2, 1));
            JLabel presentation = new JLabel();
            JLabel presentation2 = new JLabel();

            if (p.getPoste() == Poste.PHService) {

                presentation.setText("Bienvenue Dr. " + p.getNom().toUpperCase() + " " + p.getPrenom());
                presentation2.setText("" + p.getNomService());

            } else {
                presentation.setText("Bienvenue " + p.getNom().toUpperCase() + " " + p.getPrenom());
                presentation2.setText("" + p.getPoste() + " - " + p.getNomService());
            }
            presentation.setHorizontalAlignment(SwingConstants.CENTER);
            presentation.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
            presentation.setBackground(LIGHT_BLUE);

            presentation2.setHorizontalAlignment(SwingConstants.CENTER);
            presentation2.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
            presentation2.setBackground(LIGHT_BLUE);

            prez.add(presentation);
            prez.add(presentation2);
            prez.setBackground(LIGHT_BLUE);

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

            GridLayout grid = new GridLayout(3, 1);
            grid.setHgap(00);
            JPanel panTriFin = new JPanel(grid);

            JPanel panTri = new JPanel(new FlowLayout());
            JPanel panTri2 = new JPanel(new FlowLayout());
            JPanel panTri3 = new JPanel(new FlowLayout());
            JLabel preference = new JLabel("Préférence de tri : ");
            preference.setFont(new Font("Arial Nova", Font.PLAIN, 15));
            panTriFin.add(panTri);
            panTriFin.add(panTri2);
            panTriFin.add(panTri3);
            choixTri.add("Du plus récent au plus ancien");
            choixTri.add("Du plus ancien au plus récent");

            JLabel info = new JLabel("(De haut en bas) ");
            panTri.add(preference);
            panTri.add(tri);
            panTri.add(info);
            panTri.setBackground(LIGHT_BLUE);
            panTri2.setBackground(LIGHT_BLUE);
            panTri3.setBackground(LIGHT_BLUE);

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
            panTri3.add(ok);
            panTri3.add(voirTout);

            ///////////////// Panel Historique /////////////////
            JPanel panHistorique = new JPanel(new BorderLayout());
            TitledBorder titre3 = BorderFactory.createTitledBorder("Historique des visites");
            panHistorique.setBorder(titre3);
            panHistorique.setBackground(LIGHT_BLUE);

            //  JTable tableau = new JTable(new ModelTableau());
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

            iconeH = new ImageIcon("src/Annexes/homme.png");

            Image img2 = iconeH.getImage(); // Convertissemnt pour pouvoir redimensionner
            Image newimg2 = img2.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // On choisit la taille de l'image
            iconeH = new ImageIcon(newimg2); // On reconvertit
            JLabel image2 = new JLabel(iconeH);

            iconeF = new ImageIcon("src/Annexes/femme.png");
            Image imgF = iconeF.getImage(); // Convertissemnt pour pouvoir redimensionner
            Image newimgF = imgF.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // On choisit la taille de l'image     
            iconeF = new ImageIcon(newimgF); // On reconvertit

            panelTest.add(image2, gbc);

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
//            adresseInfo.setPreferredSize(new Dimension(130, 80));
//            adresseInfo.setLineWrap(true);
//            adresseInfo.setEditable(false);
            adresseInfo.setBackground(LIGHT_BLUE);
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

            JTable tableauDM = new JTable();
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

            JPanel panelFiche = new JPanel(new GridLayout(2, 2));

            // Observations
            JTextArea observations2 = new JTextArea(fiche.getObservations());
            observations2.setLineWrap(true);
            observations2.setEditable(false);
            JScrollPane obs = new JScrollPane();
            obs.setViewportView(observations2);
            JPanel ficheObservations = new JPanel(new BorderLayout());
            TitledBorder titleObs = BorderFactory.createTitledBorder("Observations");
            ficheObservations.setBorder(titleObs);
            ficheObservations.add(obs);

            panelFiche.add(ficheObservations);
            ficheObservations.setBackground(LIGHT_BLUE);

// Prescription
            JTextArea prescription2 = new JTextArea(fiche.getPrescriptions());
            prescription2.setLineWrap(true);
            prescription2.setEditable(false);
            JScrollPane pres = new JScrollPane();
            pres.setViewportView(prescription2);
            JPanel fichePrescription = new JPanel(new BorderLayout());
            TitledBorder titlePresc = BorderFactory.createTitledBorder("Prescriptions");
            fichePrescription.setBorder(titlePresc);
            fichePrescription.add(pres);

            panelFiche.add(fichePrescription);
            fichePrescription.setBackground(LIGHT_BLUE);

//Opération
            JTextArea operationInfo = new JTextArea(fiche.getOperations());
            operationInfo.setLineWrap(true);
            operationInfo.setEditable(false);
            JScrollPane op = new JScrollPane();
            op.setViewportView(operationInfo);
            JPanel ficheOperation = new JPanel(new BorderLayout());
            TitledBorder titleOp = BorderFactory.createTitledBorder("Opérations");
            ficheOperation.setBorder(titleOp);
            ficheOperation.add(op);

            panelFiche.add(ficheOperation);
            ficheOperation.setBackground(LIGHT_BLUE);

//Résultats
            // gbc.gridx = 1;
            gbc.gridy = 1;

            JTextArea resultatInfo = new JTextArea(fiche.getResultats());
            resultatInfo.setLineWrap(true);
            resultatInfo.setEditable(false);
            JScrollPane result = new JScrollPane();
            result.setViewportView(resultatInfo);
            JPanel ficheResultat = new JPanel(new BorderLayout());
            TitledBorder titleRes = BorderFactory.createTitledBorder("Résultats");
            ficheResultat.setBorder(titleRes);
            ficheResultat.add(result);

            panelFiche.add(ficheResultat);
            ficheResultat.setBackground(LIGHT_BLUE);

            //Création du Panel DM
            JSplitPane DM = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelDMHaut, panelDetail);
            //  DM.setResizeWeight(0.2);
            TitledBorder title = BorderFactory.createTitledBorder("informations générales");
            DM.setBorder(title);
            DM.setBackground(LIGHT_BLUE);

            //  DM.add(panelDMHaut);
            ////////////////s/ Panel DMA /////////////////
            //Création du Panel du haut de la partie DMA
            JPanel panelDMAHaut = new JPanel((new GridLayout(1, 2)));
            panelDMAHaut.setBackground(LIGHT_BLUE);

            //Création du Panel contenant les informations du Patient
            JPanel panelInfoPatient2 = new JPanel();
            TitledBorder titleInfo2 = BorderFactory.createTitledBorder("informations du patient");
            panelInfoPatient2.setBorder(titleInfo2);
            panelInfoPatient2.setBackground(LIGHT_BLUE);

            JPanel panelTest2 = new JPanel(new GridBagLayout());

            //Image
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(00, 0, 0, 0);
            gbc.anchor = GridBagConstraints.CENTER;

            iconeH = new ImageIcon("src/Annexes/homme.png");

            Image img2DMA = iconeH.getImage(); // Convertissemnt pour pouvoir redimensionner
            Image newimg2DMA = img2DMA.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // On choisit la taille de l'image
            iconeH = new ImageIcon(newimg2DMA); // On reconvertit
            JLabel image2DMA = new JLabel(iconeH);

            iconeF = new ImageIcon("src/Annexes/femme.png");
            Image imgFDMA = iconeF.getImage(); // Convertissemnt pour pouvoir redimensionner
            Image newimgFDMA = imgFDMA.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // On choisit la taille de l'image     
            iconeF = new ImageIcon(newimgFDMA); // On reconvertit

            panelTest2.add(image2DMA, gbc);

// Nom
            //gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.ipadx = 0;
            gbc.insets = new Insets(20, 20, 0, 0);
            gbc.anchor = GridBagConstraints.WEST;
            // gbc.weighty = 1;
            //gbc.anchor = GridBagConstraints.CENTER;

            JLabel nomDMA = new JLabel("Nom : ");
            nomDMA.setFont(new Font("Cambria", Font.PLAIN, 18));
            JLabel nom2DMA = new JLabel(patient.getNom());
            JPanel patientNomDMA = new JPanel();
            patientNomDMA.setLayout(new BoxLayout(patientNomDMA, BoxLayout.X_AXIS));
            patientNomDMA.add(nomDMA);
            patientNomDMA.add(nom2DMA);

            panelTest2.add(patientNomDMA, gbc);
            patientNomDMA.setBackground(LIGHT_BLUE);

// Prénom
            gbc.insets = new Insets(0, 20, 0, 0);
            gbc.gridy = 2;

            JLabel prenomDMA = new JLabel("Prénom :");
            prenom.setFont(new Font("Cambria", Font.PLAIN, 18));
            JLabel prenom2DMA = new JLabel(patient.getPrenom());
            JPanel pPrenomDMA = new JPanel();
            pPrenomDMA.setLayout(new BoxLayout(pPrenomDMA, BoxLayout.X_AXIS));
            pPrenomDMA.add(prenomDMA);
            pPrenomDMA.add(prenom2DMA);

            panelTest2.add(pPrenomDMA, gbc);
            pPrenomDMA.setBackground(LIGHT_BLUE);
//Sexe
            gbc.gridy = 3;

            JLabel sexeDMA = new JLabel("Sexe : ");
            sexe.setFont(new Font("Cambria", Font.PLAIN, 18));
            JLabel sexeInfoDMA = new JLabel("" + patient.getSexe());
            JPanel patientSexeDMA = new JPanel();
            patientSexeDMA.setLayout(new BoxLayout(patientSexeDMA, BoxLayout.X_AXIS));
            patientSexeDMA.add(sexeDMA);
            patientSexeDMA.add(sexeInfoDMA);

            panelTest2.add(patientSexeDMA, gbc);
            patientSexeDMA.setBackground(LIGHT_BLUE);

//Date de naissance
            gbc.gridy = 4;

            JLabel dateDMA = new JLabel("Date de naissance :");
            date.setFont(new Font("Cambria", Font.PLAIN, 18));
            JLabel dateInfoDMA = new JLabel(patient.stringDate());
            JPanel patientDateDMA = new JPanel();
            patientDateDMA.setLayout(new BoxLayout(patientDateDMA, BoxLayout.X_AXIS));
            patientDateDMA.add(dateDMA);
            patientDateDMA.add(dateInfoDMA);

            panelTest2.add(patientDateDMA, gbc);
            patientDateDMA.setBackground(LIGHT_BLUE);

            //Adresse
            gbc.gridy = 5;

            JLabel adresseDMA = new JLabel("Adresse :");
            adresse.setFont(new Font("Cambria", Font.PLAIN, 18));
            JLabel adresseInfoDMA = new JLabel(patient.getAdresse());
//            adresseInfo.setPreferredSize(new Dimension(130, 80));
//            adresseInfo.setLineWrap(true);
//            adresseInfo.setEditable(false);
            adresseInfo.setBackground(LIGHT_BLUE);
            JPanel patientAdresseDMA = new JPanel();
            patientAdresseDMA.setLayout(new BoxLayout(patientAdresseDMA, BoxLayout.X_AXIS));
            patientAdresseDMA.add(adresse);
            patientAdresseDMA.add(adresseInfo);

            panelTest2.add(patientAdresseDMA, gbc);
            patientAdresseDMA.setBackground(LIGHT_BLUE);

            panelInfoPatient2.add(panelTest2);
            panelTest2.setBackground(LIGHT_BLUE);

            //Création du Panel contenant la liste des DMAs du patient 
            JPanel panelListe2 = new JPanel(new BorderLayout());
            TitledBorder titleListe2 = BorderFactory.createTitledBorder("Liste des DMAs");
            panelListe2.setBorder(titleListe2);
            panelListe2.setBackground(LIGHT_BLUE);

            JTable tableauDMA = new JTable();
            JScrollPane tDMA = new JScrollPane(tableauDMA);
            tDMA.setOpaque(true);
            tableauDMA.setBackground(LIGHT_BLUE);
            tDMA.setBackground(LIGHT_BLUE);
            panelListe2.add(tDMA);

            // Ajout des deux précédents panels au premier
            panelDMAHaut.add(panelInfoPatient2);
            panelDMAHaut.add(panelListe2);
            panelDMAHaut.setPreferredSize(new Dimension(200, 300));

            //Création du Panel avec les détails du DMA sur lequel on a cliqué
            JPanel panelDetail2 = new JPanel(new BorderLayout());
            TitledBorder titleDetail2 = BorderFactory.createTitledBorder("Détails de ce DMA");
            panelDetail2.setBorder(titleDetail2);
            panelDetail2.setBackground(LIGHT_BLUE);

            JPanel panelFicheDMA = new JPanel(new GridLayout(2, 2));

            //Nature des Résultats
            // gbc.gridx = 1;
            gbc.gridy = 1;

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
            //Création du Panel DM
            JSplitPane DMA = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelDMAHaut, panelDetail2);
            //  DM.setResizeWeight(0.2);
            TitledBorder title2 = BorderFactory.createTitledBorder("informations générales");
            DMA.setBorder(title2);
            DMA.setBackground(LIGHT_BLUE);

            //  DM.add(panelDMHaut);
            ///////////////// Organisation des panels /////////////////
            panelHaut.add(deconnexion, BorderLayout.WEST);
            // panelHaut.add(presentation, BorderLayout.NORTH);
            panelHaut.add(prez, BorderLayout.CENTER);
            //  panelHaut.add(ajoutActe, BorderLayout.EAST);

            //panelGauche.add(panTriFin, BorderLayout.NORTH);
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

                        int k = 0;
                        while (data[k][0].equals(s) == false && k < data.length - 1) {

                            k++;

                        }
                        if (k != data.length) {

                            patient.setIPP(data[k][0]);
                            patient.setNom(data[k][1]);
                            patient.setPrenom(data[k][3]);
                            patient.setDateNaissanceString(data[k][4]);
                            patient.setSexe(data[k][5]);
                            patient.setAdresse(data[k][6]);
                            patient.setMedGen(data[k][8]);

                        }

                        panelMessage.setVisible(false);
                        tp.add("DM", DM);
                        tp.add("DMA", DMA);
                        panelDroit.add(tp);

                        nom2.setText(patient.getNom());
                        prenom2.setText(patient.getPrenom());
                        sexeInfo.setText("" + patient.getSexe());
                        dateInfo.setText(patient.stringDate());
                        adresseInfo.setText(patient.getAdresse());

                        if (patient.getSexe() == Sexe.HOMME) {
                            image2.setIcon(iconeH);
                        } else {

                            image2.setIcon(iconeF);

                        }

////Pour le DMA////
                        nom2DMA.setText(patient.getNom());
                        prenom2DMA.setText(patient.getPrenom());
                        sexeInfoDMA.setText("" + patient.getSexe());
                        dateInfoDMA.setText(patient.stringDate());
                        adresseInfoDMA.setText(patient.getAdresse());

                        if (patient.getSexe() == Sexe.HOMME) {
                            image2DMA.setIcon(iconeH);
                        } else {

                            image2DMA.setIcon(iconeF);

                        }

                        accueil.validate();
                        accueil.repaint();

                        try {
                            String query = "SELECT COUNT(*) FROM fichesDM WHERE IPPatient=" + s;
                            Statement stm = con.createStatement();
                            ResultSet res = stm.executeQuery(query);

                            int taille = 0;

                            if (res.next()) {
                                taille = res.getInt("COUNT(*)");
                            }

                            String dataDM[][] = new String[taille][8];
                            String columns[] = {"Date", "CR", "lettre sortie"};
//            res2.close();

                            query = "SELECT * FROM fichesDM WHERE IPPatient=" + s;
                            res = stm.executeQuery(query);
                            int i = 0;
                            while (res.next()) {

                                String resul = res.getString("resultats");

                                String lettre = res.getString("lettreDeSortie");
                                String num = res.getString("numFiche");

                                dataDM[i][0] = num;
                                if (resul != null) {
                                    dataDM[i][1] = "true";
                                } else {
                                    dataDM[i][1] = "VIDE";
                                }
                                if (lettre != null) {
                                    dataDM[i][2] = "true";
                                } else {
                                    dataDM[i][2] = "VIDE";
                                }

                                i++;
                            }

                            ipp = s;
                            tableauDM.setModel(new DefaultTableModel(dataDM, columns));
                            observations2.setText("");
                            prescription2.setText("");
                            operationInfo.setText("");
                            resultatInfo.setText("");
                            panelFiche.setVisible(false);

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
            );

            tableauDM.addMouseListener(new MouseAdapter() {

                public void mouseClicked(MouseEvent me) {
                    if (me.getClickCount() == 1) {
                        int ligne = tableauDM.getSelectedRow();
                        Object cellule = tableauDM.getValueAt(ligne, 0);
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
                            String columns[] = {"observations", "prescription", "operations", "resultats"};
//            res2.close();

                            query = "SELECT * FROM fichesDM WHERE IPPatient=" + ipp + " AND numFiche=" + s;
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

                            fiche.setObservations(dataDMF[0][0]);
                            fiche.setPrescriptions(dataDMF[0][1]);
                            fiche.setOperations(dataDMF[0][2]);
                            fiche.setResultats(dataDMF[0][3]);

                            observations2.setText(fiche.getObservations());
                            prescription2.setText(fiche.getPrescriptions());
                            operationInfo.setText(fiche.getOperations());
                            resultatInfo.setText(fiche.getResultats());

                            panelDetail.add(panelFiche);
                            panelFiche.setVisible(true);
                            accueil.validate();
                            accueil.repaint();

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

//        private static void initLookAndFeel() {
//
//        try {
//            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (Exception e) {
//            // If Nimbus is not available, you can set the GUI to another look and feel.
//        }
//
//    }
}
