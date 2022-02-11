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
import java.util.Vector;
import javax.swing.BorderFactory;
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
import NF.Personnel.Poste;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

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
        panelMessage.add(messageArrive, gbc);

        panelMessage.add(messageArrive);
        panelMessage.setBackground(LIGHT_BLUE);
        panelDroit.add(panelMessage, BorderLayout.CENTER);

        JTabbedPane tp = new JTabbedPane();
        tp.setBackground(LIGHT_BLUE);
        ///////////////// Panel DM /////////////////

        JPanel DM = new JPanel(new BorderLayout());
        TitledBorder title;
        title = BorderFactory.createTitledBorder("informations générales");
        DM.setBorder(title);
        DM.setBackground(LIGHT_BLUE);

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

        ajoutActe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                panelMessage.setVisible(false);
                tp.add("DM", DM);
                tp.add("DMA", DMA);
                panelDroit.add(tp);

            }
        });
    }

}
