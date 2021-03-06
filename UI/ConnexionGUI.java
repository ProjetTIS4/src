/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author lenal
 */
public class ConnexionGUI {

    private static final Color LIGHT_BLUE2 = new Color(100, 180, 200, 150);
    private static final Color WHITE = new Color(255, 255, 255);
    private static final Color BLUE = new Color(225, 248, 255);

    private JFrame connexion;//Création de la fenêtre de connexion
    private JPanel jPanel;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel panelBoutons;
    private JPanel panelConnexion;
    private JPanel panelImage;
    private JPanel panelRetour;

    private JButton PHS;
    private JButton PHA;
    private JButton SA;
    private JButton SM;
    private JButton PHMT;
    private JLabel qui;

    private JTextField textUtilisateur; // Le champ de texte pour remplir le nom d'utilisateur
    private JPasswordField jPasswordField1; // Le champ de texte pour remplir son mdp. Cela cache les caractères écrits

    // Creation message d'erreur 
    private JLabel erreur;

    private JButton Valider; //bouton se connecter
    private ImageIcon icone;
    private JLabel image;

    private JButton retour;
    private JLabel connexionTexte;
    private JLabel connexionTexte2;
    private JLabel utilisateur;
    private JLabel mdp;

    private GridBagConstraints gbc;

    /**
     *
     */
    public ConnexionGUI() {
        connexion = new JFrame("Connexion");//Création de la fenêtre de connexion
        Image icone2 = Toolkit.getDefaultToolkit().getImage("src/Annexes/Hubspital_logo_grand.png");
        connexion.setIconImage(icone2);

        jPanel = new JPanel(new GridBagLayout());
        jPanel2 = new JPanel(new GridBagLayout());
        jPanel3 = new JPanel(new GridBagLayout());
        panelBoutons = new JPanel(new GridLayout(3, 3));
        panelConnexion = new JPanel(new BorderLayout());
        panelImage = new JPanel(new BorderLayout());
        panelRetour = new JPanel(new BorderLayout());

        erreur = new JLabel("");

        PHS = new JButton("Praticien Hospitalier de service");
        PHA = new JButton("Praticien Hospitalier anesthésiste");
        PHMT = new JButton("Praticien Hospitalier médico-technique");
        SA = new JButton("Secrétaire administrative");
        SM = new JButton("Secrétaire médicale");

        qui = new JLabel("Je suis ...");
        qui.setFont(new Font("Bookman Old Style", Font.PLAIN, 18)); //On modifie la police et la taille de l'écriture
        qui.setHorizontalAlignment(JLabel.CENTER);

        // Création de tous les éléments apparaissant dans la fenêtre 
        //Panel bouton 
        panelBoutons.add(qui);
        panelBoutons.add(PHS);
        panelBoutons.add(PHA);
        panelBoutons.add(PHMT);
        panelBoutons.add(SA);
        panelBoutons.add(SM);

        //Image
        icone = new ImageIcon("src/Annexes/Hubspital_logo.png");
        image = new JLabel(icone);
        image.setOpaque(true);
        image.setBackground(WHITE);

        panelImage.add(image, BorderLayout.CENTER); //On ajoute l'image dans la partie gauche de notre fenêtre

        //Partie Connexion
        retour = new JButton("↶");
        connexionTexte = new JLabel("Connexion ");
        connexionTexte2 = new JLabel("  ");
        connexionTexte.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
        connexionTexte2.setFont(new Font("Bookman Old Style", Font.ITALIC, 16));
        utilisateur = new JLabel("Nom d'utilisateur : "); //Le texte "Nom d'utilisateur :"
        utilisateur.setFont(new Font("Bookman Old Style", Font.PLAIN, 18)); //On modifie la police et la taille de l'écriture
        mdp = new JLabel("Mot de passe : "); // Le texte "Mot de passe :"
        mdp.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));

        textUtilisateur = new JTextField();
        jPasswordField1 = new JPasswordField();
        textUtilisateur.setMaximumSize(new Dimension(500, textUtilisateur.getMinimumSize().height)); //On choisit la taille de la barre de texte utilisateur
        jPasswordField1.setMaximumSize(new Dimension(500, jPasswordField1.getMinimumSize().height)); //On choisit la taille de la barre de texte mot de passe

        Valider = new JButton("Se connecter"); // Le bouton "Se connecter"

        gbc = new GridBagConstraints();

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 5, 0);
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        jPanel.add(connexionTexte, gbc);

        gbc.insets = new Insets(60, 0, 5, 0);
        jPanel.add(connexionTexte2, gbc);

        gbc.insets = new Insets(130, 0, 5, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        jPanel.add(erreur, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(15, 23, 0, 15);
        gbc.anchor = GridBagConstraints.PAGE_START;
        jPanel2.add(utilisateur, gbc);

        gbc.insets = new Insets(45, 15, 0, 15);
        gbc.ipadx = 150;
        jPanel2.add(textUtilisateur, gbc);

        gbc.insets = new Insets(75, 15, 0, 15);
        gbc.ipadx = 0;
        jPanel2.add(mdp, gbc);

        gbc.insets = new Insets(105, 15, 0, 15);
        gbc.ipadx = 150;
        jPanel2.add(jPasswordField1, gbc);

        gbc.insets = new Insets(160, 15, 40, 15);
        gbc.ipadx = 0;
        gbc.anchor = GridBagConstraints.PAGE_START;
        jPanel2.add(Valider, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 23, 0, 15);
        gbc.anchor = GridBagConstraints.PAGE_START;

        jPanel3.add(jPanel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(15, 23, 15, 15);
        gbc.anchor = GridBagConstraints.PAGE_START;

        jPanel3.add(jPanel2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.PAGE_START;

        jPanel3.add(retour, gbc);

        panelRetour.add(retour, BorderLayout.WEST);
        panelImage.add(panelRetour, BorderLayout.NORTH);
        panelConnexion.add(panelImage, BorderLayout.WEST); //On ajoute l'image dans la partie gauche de notre fenêtre
        panelConnexion.add(jPanel3, BorderLayout.CENTER); // On ajoute le panel final au centre de la fenêtre
        //connexion.add(panelBoutons, BorderLayout.CENTER); // On ajoute le panel final au centre de la fenêtre

        jPanel3.setBackground(BLUE);
        jPanel2.setBackground(LIGHT_BLUE2);
        PHS.setBackground(BLUE);
        PHA.setBackground(BLUE);
        PHMT.setBackground(BLUE);
        SA.setBackground(BLUE);
        SM.setBackground(BLUE);
        panelBoutons.setBackground(LIGHT_BLUE2);
        panelRetour.setBackground(WHITE);

        connexion.setContentPane(panelBoutons);

        jPanel.setOpaque(false);

    }

    /**
     *
     * @return
     */
    public JFrame getConnexion() {
        return connexion;
    }

    /**
     *
     * @param connexion
     */
    public void setConnexion(JFrame connexion) {
        this.connexion = connexion;
    }

    /**
     *
     * @return
     */
    public JPanel getjPanel() {
        return jPanel;
    }

    /**
     *
     * @param jPanel
     */
    public void setjPanel(JPanel jPanel) {
        this.jPanel = jPanel;
    }

    /**
     *
     * @return
     */
    public JPanel getjPanel2() {
        return jPanel2;
    }

    /**
     *
     * @param jPanel2
     */
    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    /**
     *
     * @return
     */
    public JPanel getjPanel3() {
        return jPanel3;
    }

    /**
     *
     * @param jPanel3
     */
    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }

    /**
     *
     * @return
     */
    public JTextField getTextUtilisateur() {
        return textUtilisateur;
    }

    /**
     *
     * @param textUtilisateur
     */
    public void setTextUtilisateur(JTextField textUtilisateur) {
        this.textUtilisateur = textUtilisateur;
    }

    /**
     *
     * @return
     */
    public JPasswordField getjPasswordField1() {
        return jPasswordField1;
    }

    /**
     *
     * @param jPasswordField1
     */
    public void setjPasswordField1(JPasswordField jPasswordField1) {
        this.jPasswordField1 = jPasswordField1;
    }

    /**
     *
     * @return
     */
    public JLabel getErreur() {
        return erreur;
    }

    /**
     *
     * @param erreur
     */
    public void setErreur(JLabel erreur) {
        this.erreur = erreur;
    }

    /**
     *
     * @return
     */
    public JButton getValider() {
        return Valider;
    }

    /**
     *
     * @param Valider
     */
    public void setValider(JButton Valider) {
        this.Valider = Valider;
    }

    /**
     *
     * @return
     */
    public ImageIcon getIcone() {
        return icone;
    }

    /**
     *
     * @param icone
     */
    public void setIcone(ImageIcon icone) {
        this.icone = icone;
    }

    /**
     *
     * @return
     */
    public JLabel getImage() {
        return image;
    }

    /**
     *
     * @param image
     */
    public void setImage(JLabel image) {
        this.image = image;
    }

    /**
     *
     * @return
     */
    public JLabel getConnexionTexte() {
        return connexionTexte;
    }

    /**
     *
     * @param connexionTexte
     */
    public void setConnexionTexte(JLabel connexionTexte) {
        this.connexionTexte = connexionTexte;
    }

    /**
     *
     * @return
     */
    public JLabel getUtilisateur() {
        return utilisateur;
    }

    /**
     *
     * @param utilisateur
     */
    public void setUtilisateur(JLabel utilisateur) {
        this.utilisateur = utilisateur;
    }

    /**
     *
     * @return
     */
    public JLabel getMdp() {
        return mdp;
    }

    /**
     *
     * @param mdp
     */
    public void setMdp(JLabel mdp) {
        this.mdp = mdp;
    }

    /**
     *
     * @return
     */
    public GridBagConstraints getGbc() {
        return gbc;
    }

    /**
     *
     * @param gbc
     */
    public void setGbc(GridBagConstraints gbc) {
        this.gbc = gbc;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelBoutons() {
        return panelBoutons;
    }

    /**
     *
     * @param panelBoutons
     */
    public void setPanelBoutons(JPanel panelBoutons) {
        this.panelBoutons = panelBoutons;
    }

    /**
     *
     * @return
     */
    public JButton getPHS() {
        return PHS;
    }

    /**
     *
     * @param PHS
     */
    public void setPHS(JButton PHS) {
        this.PHS = PHS;
    }

    /**
     *
     * @return
     */
    public JButton getPHA() {
        return PHA;
    }

    /**
     *
     * @param PHA
     */
    public void setPHA(JButton PHA) {
        this.PHA = PHA;
    }

    /**
     *
     * @return
     */
    public JButton getSA() {
        return SA;
    }

    /**
     *
     * @param SA
     */
    public void setSA(JButton SA) {
        this.SA = SA;
    }

    /**
     *
     * @return
     */
    public JButton getSM() {
        return SM;
    }

    /**
     *
     * @param SM
     */
    public void setSM(JButton SM) {
        this.SM = SM;
    }

    /**
     *
     * @return
     */
    public JButton getPHMT() {
        return PHMT;
    }

    /**
     *
     * @param PHMT
     */
    public void setPHMT(JButton PHMT) {
        this.PHMT = PHMT;
    }

    /**
     *
     * @return
     */
    public JLabel getQui() {
        return qui;
    }

    /**
     *
     * @param qui
     */
    public void setQui(JLabel qui) {
        this.qui = qui;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelConnexion() {
        return panelConnexion;
    }

    /**
     *
     * @param panelConnexion
     */
    public void setPanelConnexion(JPanel panelConnexion) {
        this.panelConnexion = panelConnexion;
    }

    /**
     *
     * @return
     */
    public JLabel getConnexionTexte2() {
        return connexionTexte2;
    }

    /**
     *
     * @param connexionTexte2
     */
    public void setConnexionTexte2(JLabel connexionTexte2) {
        this.connexionTexte2 = connexionTexte2;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelImage() {
        return panelImage;
    }

    /**
     *
     * @param panelImage
     */
    public void setPanelImage(JPanel panelImage) {
        this.panelImage = panelImage;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelRetour() {
        return panelRetour;
    }

    /**
     *
     * @param panelRetour
     */
    public void setPanelRetour(JPanel panelRetour) {
        this.panelRetour = panelRetour;
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

}
