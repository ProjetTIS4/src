/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Test.RoundedCornerBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author lenal
 */
public class ConnexionGUI {

    private static final Color LIGHT_BLUE2 = new Color(100, 180, 200, 150);
    private static final Color WHITE = new Color(255, 255, 255);
    private static final Color GRIS = new Color(225, 248, 255);

    private JFrame connexion;//Création de la fenêtre de connexion
    private JPanel jPanel;
    private JPanel jPanel2;
    private JPanel jPanel3;

    private JTextField textUtilisateur; // Le champ de texte pour remplir le nom d'utilisateur
    private JPasswordField jPasswordField1; // Le champ de texte pour remplir son mdp. Cela cache les caractères écrits

    // Creation message d'erreur 
    private JLabel erreur;

    private JButton Valider; //bouton se connecter
    private ImageIcon icone;
    private JLabel image;

    private JLabel connexionTexte;
    private JLabel utilisateur;
    private JLabel mdp;

    private GridBagConstraints gbc;

    public ConnexionGUI() {
        connexion = new JFrame("Connexion");//Création de la fenêtre de connexion

        jPanel = new JPanel(new GridBagLayout());
        jPanel2 = new JPanel(new GridBagLayout());
        jPanel3 = new JPanel(new GridBagLayout());

        erreur = new JLabel("");

        // Création de tous les éléments apparaissant dans la fenêtre 
        //Image
        icone = new ImageIcon("src/Annexes/Hubspital_logo.png");
        image = new JLabel(icone);
        image.setOpaque(true);
        image.setBackground(WHITE);

        connexion.getContentPane().add(image, BorderLayout.WEST); //On ajoute l'image dans la partie gauche de notre fenêtre

        //Partie Connexion
        connexionTexte = new JLabel("Connexion ");
        connexionTexte.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
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

        gbc.insets = new Insets(100, 0, 5, 0);
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

        connexion.add(jPanel3, BorderLayout.CENTER); // On ajoute le panel final au centre de la fenêtre

        jPanel3.setBackground(GRIS);
        jPanel2.setBackground(LIGHT_BLUE2);
        // jPanel3.setBackground(LIGHT_BLUE2);
        jPanel.setOpaque(false);
    }

    public JFrame getConnexion() {
        return connexion;
    }

    public void setConnexion(JFrame connexion) {
        this.connexion = connexion;
    }

    public JPanel getjPanel() {
        return jPanel;
    }

    public void setjPanel(JPanel jPanel) {
        this.jPanel = jPanel;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }

    public JTextField getTextUtilisateur() {
        return textUtilisateur;
    }

    public void setTextUtilisateur(JTextField textUtilisateur) {
        this.textUtilisateur = textUtilisateur;
    }

    public JPasswordField getjPasswordField1() {
        return jPasswordField1;
    }

    public void setjPasswordField1(JPasswordField jPasswordField1) {
        this.jPasswordField1 = jPasswordField1;
    }

    public JLabel getErreur() {
        return erreur;
    }

    public void setErreur(JLabel erreur) {
        this.erreur = erreur;
    }

    public JButton getValider() {
        return Valider;
    }

    public void setValider(JButton Valider) {
        this.Valider = Valider;
    }

    public ImageIcon getIcone() {
        return icone;
    }

    public void setIcone(ImageIcon icone) {
        this.icone = icone;
    }

    public JLabel getImage() {
        return image;
    }

    public void setImage(JLabel image) {
        this.image = image;
    }

    public JLabel getConnexionTexte() {
        return connexionTexte;
    }

    public void setConnexionTexte(JLabel connexionTexte) {
        this.connexionTexte = connexionTexte;
    }

    public JLabel getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(JLabel utilisateur) {
        this.utilisateur = utilisateur;
    }

    public JLabel getMdp() {
        return mdp;
    }

    public void setMdp(JLabel mdp) {
        this.mdp = mdp;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public void setGbc(GridBagConstraints gbc) {
        this.gbc = gbc;
    }

}
