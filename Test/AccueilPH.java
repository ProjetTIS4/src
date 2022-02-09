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
import NF.NomService;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.TitledBorder;
import NF.Personnel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

/**
 *
 * @author lenal
 */
public class AccueilPH implements Runnable {

    //Variable graphique 
    protected JFrame accueil = new JFrame("Accueil");
    protected JPanel panDetail = new JPanel(new BorderLayout());

// Variable pour la couleur des fenêtres
    private static final Color LIGHT_BLUE = new Color(100, 180, 200);
    private static final Color LIGHT_BLUE2 = new Color(100, 180, 200, 200);

    //Variables utilisées pour le panel historique
    protected JTextArea ficheSoins = new JTextArea("Cliquez sur une date dans l'historique des visites pour avoir le détail de cette visite");

    //Variables utilisées pour le tri
    protected Vector<String> choixTri = new Vector<String>();
    JTextField dateBasJour = new JTextField("JJ");
    JTextField dateHautJour = new JTextField("JJ");
    JTextField dateBasMois = new JTextField("MM");
    JTextField dateHautMois = new JTextField("MM");
    JTextField dateBasAnnee = new JTextField("AAAA");
    JTextField dateHautAnnee = new JTextField("AAAA");
    JButton ok = new JButton("Valider");
    JButton voirTout = new JButton("voirTout");
    protected JComboBox tri = new JComboBox(choixTri);
    JTabbedPane tp;

    //Autres variables
    protected Personnel p;

    public AccueilPH() {
        p = new Personnel("Bon", "Jean", NomService.CARDIOLOGIE, Personnel.Poste.PHService, "ddd", "fff");

    }

    @Override
    public void run() {

        //Création de la fenêtre de accueil
        accueil.setDefaultCloseOperation(EXIT_ON_CLOSE);

        accueil.setBounds(0, 20, 1200, 900);
        // accueil.setResizable(false);
        accueil.setVisible(true);

        JPanel panelFin = new JPanel(new BorderLayout());

        JPanel panelGauche = new JPanel(new BorderLayout());
        panelGauche.setLayout(new GridLayout(2, 1));
        JPanel panelDroit = new JPanel(new BorderLayout());
        JPanel panelHaut = new JPanel(new BorderLayout());
        panelHaut.setBackground(LIGHT_BLUE);

        panelGauche.setBackground(LIGHT_BLUE);

        JSplitPane splitPan = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT, panelDroit, panelGauche);
        splitPan.setResizeWeight(0.2);

        // Panel haut
        JButton retourB = new JButton("Retour");
        JButton ajoutActe = new JButton("+");
        ajoutActe.setToolTipText("Cliquez ici pour ajouter un acte");
        JLabel presentation = new JLabel();
        presentation.setText("Bienvenue " + p.getNom().toUpperCase() + " " + p.getPrenom());
        presentation.setHorizontalAlignment(SwingConstants.CENTER);
        presentation.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
        presentation.setBackground(LIGHT_BLUE);

        tp=new JTabbedPane();
        tp.setBackground(LIGHT_BLUE);
    

        
        
        //Panel Gauche
        //Panel info général 
        JPanel infoGeneral = new JPanel();
        JPanel infoGeneralFin = new JPanel();
        infoGeneralFin.setLayout(new BoxLayout(infoGeneralFin, BoxLayout.X_AXIS));
        infoGeneral.setLayout(new BoxLayout(infoGeneral, BoxLayout.Y_AXIS));
        infoGeneral.setMaximumSize(new Dimension(300, 200));
        TitledBorder title;
        title = BorderFactory.createTitledBorder("informations général");
        infoGeneralFin.setBorder(title);
        infoGeneral.setBackground(LIGHT_BLUE);
        infoGeneralFin.setBackground(LIGHT_BLUE);
        tp.add("DM",infoGeneralFin);

        //Image
//        if (p.getSexe() == Sexe.HOMME) {
//            ImageIcon iconeH = new ImageIcon("src/UI/homme.png");
//            Image img = iconeH.getImage(); // Convertissemnt pour pouvoir redimensionner
//            Image newimg = img.getScaledInstance(216, 216, java.awt.Image.SCALE_SMOOTH); // On choisit la taille de l'image
//            iconeH = new ImageIcon(newimg); // On reconvertit
//            JLabel image = new JLabel(iconeH);
//            infoGeneralFin.add(image);
//        } else {
//            ImageIcon iconeF = new ImageIcon("src/UI/femme.png");
//            Image img = iconeF.getImage(); // Convertissemnt pour pouvoir redimensionner
//            Image newimg = img.getScaledInstance(216, 216, java.awt.Image.SCALE_SMOOTH); // On choisit la taille de l'image
//            iconeF = new ImageIcon(newimg); // On reconvertit
//            JLabel image = new JLabel(iconeF);
//            infoGeneralFin.add(image);
//        }
// Nom
        JLabel nom = new JLabel("Nom : ");
        nom.setFont(new Font("Cambria", Font.PLAIN, 18));
        JLabel nom2 = new JLabel(p.getNom());
        JPanel pNom = new JPanel();
        pNom.setLayout(new BoxLayout(pNom, BoxLayout.X_AXIS));
        pNom.add(nom);
        pNom.add(nom2);
        pNom.setBackground(LIGHT_BLUE);

// Prénom
        JLabel prenom = new JLabel("Prénom :");
        prenom.setFont(new Font("Cambria", Font.PLAIN, 18));
        JLabel prenom2 = new JLabel(p.getPrenom());
        JPanel pPrenom = new JPanel();
        pPrenom.setLayout(new BoxLayout(pPrenom, BoxLayout.X_AXIS));
        pPrenom.add(prenom);
        pPrenom.add(prenom2);
        pPrenom.setBackground(LIGHT_BLUE);

//Sexe
        JLabel sexe = new JLabel("Sexe :");
        sexe.setFont(new Font("Cambria", Font.PLAIN, 18));
        JPanel pSexe = new JPanel();
        pSexe.setLayout(new BoxLayout(pSexe, BoxLayout.X_AXIS));
        pSexe.add(sexe);
        pSexe.setBackground(LIGHT_BLUE);

//Date de naissance
        JLabel date = new JLabel("Date de naissance :");
        date.setFont(new Font("Cambria", Font.PLAIN, 18));
        JPanel pDate = new JPanel();
        pDate.setLayout(new BoxLayout(pDate, BoxLayout.X_AXIS));
        pDate.add(date);
        pDate.setBackground(LIGHT_BLUE);

        //Adresse
        JLabel adresse = new JLabel("Adresse :");
        adresse.setFont(new Font("Cambria", Font.PLAIN, 18));
        JPanel pAdresse = new JPanel();
        pAdresse.setLayout(new BoxLayout(pAdresse, BoxLayout.X_AXIS));
        pAdresse.add(adresse);
        pAdresse.setBackground(LIGHT_BLUE);

        //Numéro de sécu
        JLabel secu = new JLabel("N° de sécurité social :");
        secu.setFont(new Font("Cambria", Font.PLAIN, 18));
        JPanel pSecu = new JPanel();
        pSecu.setLayout(new BoxLayout(pSecu, BoxLayout.X_AXIS));
        pSecu.add(secu);
        pSecu.setBackground(LIGHT_BLUE);

        //Panel Dernière Visite
        JPanel derniereVisite = new JPanel();

        derniereVisite.setLayout(new BoxLayout(derniereVisite, BoxLayout.Y_AXIS));
        TitledBorder title2;
        title2 = BorderFactory.createTitledBorder("Dernier acte ajouté");
        derniereVisite.setBorder(title2);
        derniereVisite.setBackground(LIGHT_BLUE);
        tp.add("DMA",derniereVisite);

        //Date 
        JLabel dateDer = new JLabel("Date : ");
        dateDer.setMaximumSize(new Dimension(148, dateDer.getMinimumSize().height));
        dateDer.setFont(new Font("Cambria", Font.PLAIN, 18));
        JPanel pDateDer = new JPanel();
        pDateDer.setLayout(new BoxLayout(pDateDer, BoxLayout.X_AXIS));
        pDateDer.add(dateDer);
        pDateDer.setBackground(LIGHT_BLUE);

        //Prestation
        JLabel prestation = new JLabel("Prestation : ");
        prestation.setMaximumSize(new Dimension(137, prestation.getMinimumSize().height));
        prestation.setFont(new Font("Cambria", Font.PLAIN, 18));

        JPanel pPrestation = new JPanel();
        pPrestation.setLayout(new BoxLayout(pPrestation, BoxLayout.X_AXIS));
        pPrestation.add(prestation);
        pPrestation.setBackground(LIGHT_BLUE);

        // Code de l'acte
        JLabel codeLabel = new JLabel("Code de l'acte : ");
        codeLabel.setMaximumSize(new Dimension(130, codeLabel.getMinimumSize().height));
        codeLabel.setFont(new Font("Cambria", Font.PLAIN, 18));
        JPanel pCode = new JPanel();
        pCode.setLayout(new BoxLayout(pCode, BoxLayout.X_AXIS));
        pCode.add(codeLabel);
        pCode.setBackground(LIGHT_BLUE);

        //Coeff de l'acte 
        JLabel coeff = new JLabel("Coeff de l'acte : ");
        coeff.setMaximumSize(new Dimension(130, coeff.getMinimumSize().height));
        coeff.setFont(new Font("Cambria", Font.PLAIN, 18));
        JPanel pCoeff = new JPanel();
        pCoeff.setLayout(new BoxLayout(pCoeff, BoxLayout.X_AXIS));
        pCoeff.add(coeff);
        pCoeff.setBackground(LIGHT_BLUE);

        //Type de l'acte 
        JLabel typeLabel = new JLabel("Type de l'acte : ");
        typeLabel.setMaximumSize(new Dimension(130, typeLabel.getMinimumSize().height));
        typeLabel.setFont(new Font("Cambria", Font.PLAIN, 18));
        JPanel pType = new JPanel();
        pType.setLayout(new BoxLayout(pType, BoxLayout.X_AXIS));
        pType.add(typeLabel);
        pType.setBackground(LIGHT_BLUE);

        //Observation
        JLabel commentaire = new JLabel("Observation: ");
        commentaire.setFont(new Font("Cambria", Font.PLAIN, 18));

        JScrollPane comm = new JScrollPane();

        JPanel pCommentaire = new JPanel();
        comm.setMaximumSize(new Dimension(400, 200));
        pCommentaire.setLayout(new BoxLayout(pCommentaire, BoxLayout.X_AXIS));
        pCommentaire.add(commentaire);
        pCommentaire.add(comm);
        pCommentaire.setBackground(LIGHT_BLUE);

        // Cout total 
        JLabel coutTot = new JLabel("Coût total :");

        coutTot.setMaximumSize(new Dimension(140, coutTot.getMinimumSize().height));
        coutTot.setFont(new Font("Cambria", Font.PLAIN, 18));
        JPanel pCout = new JPanel();
        pCout.setLayout(new BoxLayout(pCout, BoxLayout.X_AXIS));
        pCout.add(coutTot);
        pCout.setBackground(LIGHT_BLUE);

        //Panel Droit
        //Panel tri 
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

        // Panel Historique
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

        //Panel détail 
//        ficheSoins.setMaximumSize(new Dimension(400, 200));
//        panDetail.setBackground(LIGHT_BLUE);
        ArrayList<Integer> index = new ArrayList<Integer>();

        //  JSplitPane splitPanDroit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panHistorique, panDetail);
//        splitPanDroit.setResizeWeight(0.45);
//        splitPanDroit.setBorder(titre3);
//
//        splitPanDroit.setBackground(LIGHT_BLUE);
//        JScrollPane detail = new JScrollPane(ficheSoins);
//        panDetail.add(detail);
        infoGeneral.add(pNom);
        Dimension minSize = new Dimension(5, 3);  //Cette ligne et les 3 suivantes servent à espacer les composants ajoutés avant et après ces lignes
        Dimension prefSize = new Dimension(5, 3);
        Dimension maxSize = new Dimension(Short.MAX_VALUE, 3);
        infoGeneral.add(new Box.Filler(minSize, prefSize, maxSize));
        infoGeneral.add(pPrenom);
        infoGeneral.add(new Box.Filler(minSize, prefSize, maxSize));
        infoGeneral.add(pSexe);
        infoGeneral.add(new Box.Filler(minSize, prefSize, maxSize));
        infoGeneral.add(pDate);
        infoGeneral.add(new Box.Filler(minSize, prefSize, maxSize));
        infoGeneral.add(pAdresse);
        infoGeneral.add(new Box.Filler(minSize, prefSize, maxSize));
        infoGeneral.add(pSecu);
        infoGeneralFin.add(infoGeneral);

        derniereVisite.add(pDateDer);
        derniereVisite.add(new Box.Filler(minSize, prefSize, maxSize));
        derniereVisite.add(pPrestation);
        derniereVisite.add(new Box.Filler(minSize, prefSize, maxSize));
        derniereVisite.add(pCode);
        derniereVisite.add(new Box.Filler(minSize, prefSize, maxSize));
        derniereVisite.add(pCoeff);
        derniereVisite.add(new Box.Filler(minSize, prefSize, maxSize));
        derniereVisite.add(pType);
        derniereVisite.add(new Box.Filler(minSize, prefSize, maxSize));
        derniereVisite.add(pCout);
        derniereVisite.add(new Box.Filler(minSize, prefSize, maxSize));
        derniereVisite.add(pCommentaire);

        panelHaut.add(retourB, BorderLayout.WEST);
        panelHaut.add(presentation, BorderLayout.CENTER);
        panelHaut.add(ajoutActe, BorderLayout.EAST);

        //panelGauche.add(infoGeneralFin);
     //   panelGauche.add(derniereVisite);
     panelGauche.add(tp);

        panelDroit.add(panTriFin, BorderLayout.NORTH);
        panelDroit.add(panHistorique);

        panelFin.add(panelHaut, BorderLayout.NORTH);
        panelFin.add(splitPan, BorderLayout.CENTER);

        accueil.add(panelFin);

    }
}
