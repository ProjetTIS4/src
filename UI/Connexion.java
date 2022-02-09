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
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import javax.swing.Box;
import javax.swing.BoxLayout;
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

    private static final Color LIGHT_BLUE = new Color(100, 180, 200);
    private static final Color WHITE = new Color(255, 255, 255);
    JFrame connexion = new JFrame("Connexion");//Création de la fenêtre de connexion

    protected JTextField textUtilisateur = new JTextField();  // Le champ de texte pour remplir le nom d'utilisateur
    protected JPasswordField jPasswordField1 = new JPasswordField(); // Le champ de texte pour remplir son mdp. Cela cache les caractères écrits

    // Creation message d'erreur 
    protected JLabel erreur = new JLabel("Le nom d'utilisateur ou le mot de passe est incorrect ");

    protected JButton Valider; //bouton se connecter

    @Override
    public void run() {

        connexion.setBounds(450, 190, 700, 460);
        connexion.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Création de tous les éléments apparaissant dans la fenêtre 
        //Image
        ImageIcon icone = new ImageIcon("src/Annexes/Hubspital_logo.png");
        Image img = icone.getImage(); // Convertissemnt pour pouvoir redimensionner
        Image newimg = img.getScaledInstance(344, 460, java.awt.Image.SCALE_SMOOTH); // On choisit la taille de l'image

        icone = new ImageIcon(newimg); // On reconvertit
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

        erreur.setForeground(Color.RED);

        Valider = new JButton("Se connecter"); // Le bouton "Se connecter"
        //   Valider.setBackground(new Color(100, 180, 180));  //Pour changer la couleur du bouton 

        textUtilisateur.setMaximumSize(new Dimension(500, textUtilisateur.getMinimumSize().height)); //On choisit la taille de la barre de texte utilisateur
        jPasswordField1.setMaximumSize(new Dimension(500, jPasswordField1.getMinimumSize().height)); //On choisit la taille de la barre de texte mot de passe

        JPanel jPanel = new JPanel(new GridBagLayout());

        /*3- Ajout de ces composants en spécifiant les contraintes de type GridBagConstraints. */
        GridBagConstraints gbc = new GridBagConstraints();

        /*Texte "Connexion" en haut de la fenêtre*/
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets( 0, 0, 0, 0);
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        jPanel.add(connexionTexte, gbc);

        /*Texte "Utilisateur" */
        
         gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 8, 0, 0);
        gbc.anchor = GridBagConstraints.PAGE_START;
        jPanel.add(utilisateur, gbc);

        /*Champ de texte Utilisateur */
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.ipadx = 150;
        jPanel.add(textUtilisateur, gbc);

        /*Texte "Mot de passe" */
        gbc.insets = new Insets(60, 0, 0, 0);
        gbc.ipadx = 0;
        jPanel.add(mdp, gbc);

        /*Champ de texte Mot de Passe */
        gbc.insets = new Insets(90, 0, 0, 0);
        gbc.ipadx = 150;
        jPanel.add(jPasswordField1, gbc);

        /*Bouton valider*/
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(160, 0, 0, 0);
        gbc.ipadx = 0;
       gbc.anchor = GridBagConstraints.PAGE_START;
        jPanel.add(Valider, gbc);



        connexion.add(jPanel, BorderLayout.CENTER); // On ajoute le panel final au centre de la fenêtre

        jPanel.setBackground(LIGHT_BLUE);

    }

}
