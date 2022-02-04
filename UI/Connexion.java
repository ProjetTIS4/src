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

 
        //Image
        ImageIcon icone = new ImageIcon("src/Annexes/Hubspital_logo.png");
        Image img = icone.getImage(); // Convertissemnt pour pouvoir redimensionner
        Image newimg = img.getScaledInstance(344, 460, java.awt.Image.SCALE_SMOOTH); // On choisit la taille de l'image
       
        icone = new ImageIcon(newimg); // On reconvertit
        JLabel image = new JLabel(icone);
        
        //Fond image
        image.setOpaque(true);
        image.setBackground(WHITE);
        

        connexion.setVisible(true); // On permet à la fenêtre de s'afficher

        connexion.getContentPane().add(image, BorderLayout.WEST); //On ajoute l'image dans la partie gauche de notre fenêtre

        //Partie Connexion
        JLabel utilisateur = new JLabel("Nom d'utilisateur : "); //Le texte "Nom d'utilisateur :"
        utilisateur.setFont(new Font("Bookman Old Style", Font.PLAIN, 18)); //On modifie la police et la taille de l'écriture
        JLabel mdp = new JLabel("Mot de passe : "); // Le texte "Mot de passe :"
        mdp.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));

        erreur.setForeground(Color.RED);

        Valider = new JButton("Se connecter"); // Le bouton "Se connecter"

        textUtilisateur.setMaximumSize(new Dimension(500, textUtilisateur.getMinimumSize().height)); //On choisit la taille de la barre de texte utilisateur
        jPasswordField1.setMaximumSize(new Dimension(500, jPasswordField1.getMinimumSize().height)); //On choisit la taille de la barre de texte mot de passe

        
        
        JPanel jPanel = new JPanel(new GridBagLayout());
        JPanel jPanel1 = new JPanel(); // Ce panel va contenir tous les composants créés dans la partie Connexion
        jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.Y_AXIS));


        /* Ajout de ces composants en spécifiant les contraintes de type GridBagConstraints. */
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(10,8,0,0); 
        jPanel.add(utilisateur, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(5,0,0,0); 
        gbc.ipadx=150;
        jPanel.add(textUtilisateur, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(10,0,0,0); 
        gbc.ipadx=0;
        jPanel.add(mdp, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.insets = new Insets(5,0,0,0); 
        gbc.ipadx=150;
        jPanel.add(jPasswordField1, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.insets = new Insets(60,0,0,0); 
        gbc.ipadx=0;
        jPanel.add(Valider, gbc);
        
        

        connexion.add(jPanel, BorderLayout.CENTER); // On ajoute le panel final au centre de la fenêtre

        
        jPanel.setBackground(LIGHT_BLUE);
        
       
    }

}
