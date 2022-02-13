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
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author lenal
 */
public class Connexion implements Runnable {

    //Listerner 
    protected VerifierConnexion verification;

    private static final Color LIGHT_BLUE = new Color(100, 180, 200);
    private static final Color LIGHT_BLUE2 = new Color(100, 180, 200, 200);
    private static final Color WHITE = new Color(255, 255, 255);
    JFrame connexion = new JFrame("Connexion");//Création de la fenêtre de connexion

    protected JTextField textUtilisateur = new JTextField();  // Le champ de texte pour remplir le nom d'utilisateur
    protected JPasswordField jPasswordField1 = new JPasswordField(); // Le champ de texte pour remplir son mdp. Cela cache les caractères écrits

    // Creation message d'erreur 
    protected JLabel erreur = new JLabel("");
    

    protected JButton Valider; //bouton se connecter

    @Override
    public void run() {

        connexion.setBounds(450, 190, 700, 460);
        connexion.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Création de tous les éléments apparaissant dans la fenêtre 
        //Image
        ImageIcon icone = new ImageIcon("src/Annexes/Hubspital_logo.png");
//        Image img = icone.getImage(); // Convertissemnt pour pouvoir redimensionner
//        Image newimg = img.getScaledInstance(344, 460, java.awt.Image.SCALE_SMOOTH); // On choisit la taille de l'image
//
//        icone = new ImageIcon(newimg); // On reconvertit
        JLabel image = new JLabel(icone);
        image.setOpaque(true);
        image.setBackground(WHITE);

        //fond image 
        connexion.setVisible(true); // On permet à la fenêtre de s'afficher

        connexion.getContentPane().add(image, BorderLayout.WEST); //On ajoute l'image dans la partie gauche de notre fenêtre

        //Partie Connexion
        JLabel connexionTexte = new JLabel("Connexion ");
        connexionTexte.setFont(new Font("Bookman Old Style", Font.PLAIN, 25));
        JLabel utilisateur = new JLabel("Nom d'utilisateur : "); //Le texte "Nom d'utilisateur :"
        utilisateur.setFont(new Font("Bookman Old Style", Font.PLAIN, 18)); //On modifie la police et la taille de l'écriture
        JLabel mdp = new JLabel("Mot de passe : "); // Le texte "Mot de passe :"
        mdp.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));

        erreur.setForeground(Color.red);

        Valider = new JButton("Se connecter"); // Le bouton "Se connecter"
        //   Valider.setBackground(new Color(100, 180, 180));  //Pour changer la couleur du bouton 

        textUtilisateur.setMaximumSize(new Dimension(500, textUtilisateur.getMinimumSize().height)); //On choisit la taille de la barre de texte utilisateur
        jPasswordField1.setMaximumSize(new Dimension(500, jPasswordField1.getMinimumSize().height)); //On choisit la taille de la barre de texte mot de passe

        JPanel jPanel = new JPanel(new GridBagLayout());
        JPanel jPanel2 = new JPanel(new GridBagLayout());
        JPanel jPanel3 = new JPanel(new GridBagLayout());


        /*3- Ajout de ces composants en spécifiant les contraintes de type GridBagConstraints. */
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 5, 0);
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        jPanel.add(connexionTexte, gbc);

        gbc.insets = new Insets(100, 0, 5, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        jPanel.add(erreur, gbc);
        //erreur.setVisible(false);
        

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(15, 23, 0, 15);
//        gbc.weighty = 1.1;
        gbc.anchor = GridBagConstraints.PAGE_START;
        jPanel2.add(utilisateur, gbc);

//        gbc.gridx = 1;
//        gbc.gridy = 2;
        gbc.insets = new Insets(45, 15, 0, 15);
        gbc.ipadx = 150;
        jPanel2.add(textUtilisateur, gbc);

//        gbc.gridx = 1;
//        gbc.gridy = 3;
        // gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(75, 15, 0, 15);
        gbc.ipadx = 0;
        jPanel2.add(mdp, gbc);

//        gbc.gridx = 1;
//        gbc.gridy = 4;
        gbc.insets = new Insets(105, 15, 0, 15);
        gbc.ipadx = 150;
//        gbc.anchor = GridBagConstraints.CENTER;
        jPanel2.add(jPasswordField1, gbc);

//        gbc.gridx = 1;
//        gbc.gridy = 1;
        gbc.insets = new Insets(160, 15, 40, 15);
        gbc.ipadx = 0;
        gbc.anchor = GridBagConstraints.PAGE_START;
        jPanel2.add(Valider, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 23, 0, 15);
//        gbc.weighty = 1.1;
        gbc.anchor = GridBagConstraints.PAGE_START;

        jPanel3.add(jPanel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(15, 23, 15, 15);
//        gbc.weighty = 1.1;
        gbc.anchor = GridBagConstraints.PAGE_START;

        jPanel3.add(jPanel2, gbc);

        connexion.add(jPanel3, BorderLayout.CENTER); // On ajoute le panel final au centre de la fenêtre

        jPanel3.setBackground(LIGHT_BLUE2);
        jPanel2.setBackground(LIGHT_BLUE2);
        jPanel.setOpaque(false);

        // Mise en place des Listeners
        verification = new VerifierConnexion(this);
        Valider.addActionListener(verification);
    }

}
