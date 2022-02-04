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

    protected JTextField textUtilisateur = new JTextField();  // Le champ de texte pour remplir le nom d'utilisateur
    protected JPasswordField jPasswordField1 = new JPasswordField(); // Le champ de texte pour remplir son mdp. Cela cache les caractères écrits
    JFrame connexion = new JFrame("Connexion");//Création de la fenêtre de connexion

    // Creation box 2 pour espace 
    protected Dimension minSize4 = new Dimension(5, 60); //Cette ligne et les 3 suivantes servent à espacer les composants ajoutés avant et après ces lignes
    protected Dimension prefSize4 = new Dimension(5, 60);
    protected Dimension maxSize4 = new Dimension(Short.MAX_VALUE, 60);
    protected Box.Filler box2 = new Box.Filler(minSize4, prefSize4, maxSize4);

    //Creation box 1 pour espace
    protected Dimension minSize3 = new Dimension(5, 50); //Cette ligne et les 3 suivantes servent à espacer les composants ajoutés avant et après ces lignes
    protected Dimension prefSize3 = new Dimension(5, 50);
    protected Dimension maxSize3 = new Dimension(Short.MAX_VALUE, 50);
    protected Box.Filler box = new Box.Filler(minSize3, prefSize3, maxSize3);

    // Creation message d'erreur 
    protected JLabel erreur = new JLabel("Le nom d'utilisateur ou le mot de passe est incorrect ");

    protected JButton Valider; //bouton se connecter

    @Override
    public void run() {

        JPanel jPanel1 = new JPanel(); // Ce panel va contenir tous les composants créés dans la partie Connexion
        jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.Y_AXIS));
        connexion.setDefaultCloseOperation(EXIT_ON_CLOSE);

        connexion.setBounds(450, 190, 700, 460);
        connexion.setResizable(false); // On empêche la fenêtre de se redimensionner

        // Création de tous les éléments apparaissant dans la fenêtre 
        //Image
        ImageIcon icone = new ImageIcon("src/Annexes/Hubspital_logo.png");
        Image img = icone.getImage(); // Convertissemnt pour pouvoir redimensionner
        Image newimg = img.getScaledInstance(344, 460, java.awt.Image.SCALE_SMOOTH); // On choisit la taille de l'image
        icone = new ImageIcon(newimg); // On reconvertit
        JLabel image = new JLabel(icone);

        connexion.setVisible(true); // On permet à la fenêtre de s'afficher

        //Partie Connexion

        
        JLabel utilisateur = new JLabel("Nom d'utilisateur : "); //Le texte "Nom d'utilisateur :"
        utilisateur.setFont(new Font("Bookman Old Style", Font.PLAIN, 18)); //On modifie la police et la taille de l'écriture
        JLabel mdp = new JLabel("Mot de Passe : "); // Le texte "Mot de passe :"
        mdp.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));

        // erreur.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
        erreur.setForeground(Color.RED);

        Valider = new JButton("Se connecter"); // Le bouton "Se connecter"

        textUtilisateur.setMaximumSize(new Dimension(500, textUtilisateur.getMinimumSize().height)); //On choisit la taille de la barre de texte utilisateur
        jPasswordField1.setMaximumSize(new Dimension(500, jPasswordField1.getMinimumSize().height)); //On choisit la taille de la barre de texte mot de passe

        // Maintenant on va gérer la structure de la page
        JPanel panelfin = new JPanel(new BorderLayout()); //Le panel qui va contenir tous les autres panels
        JPanel panel4 = new JPanel(); // Ce panel sert à décaler un peut le panel central vers la droite

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // On se sert d'un BoxLayout Y_AXIS pour que les composants se mettent les uns en dessous des autres.

        JPanel panel2 = new JPanel(); // Ce panel servira à aller au dessus de panel pour le centrer

        JPanel panel3 = new JPanel(); // Ce panel servira à aller en dessous de panel pour le centrer

        connexion.getContentPane().add(image, BorderLayout.WEST); //On ajoute l'image dans la partie gauche de notre fenêtre

        //On ajoute tous les composants de la partie connexion dans notre jPanell
        jPanel1.add(erreur);

        jPanel1.add(box);
        jPanel1.add(utilisateur);
        jPanel1.add(textUtilisateur);
        Dimension minSize = new Dimension(5, 10);  //Cette ligne et les 3 suivantes servent à espacer les composants ajoutés avant et après ces lignes
        Dimension prefSize = new Dimension(5, 10);
        Dimension maxSize = new Dimension(Short.MAX_VALUE, 10);
        jPanel1.add(new Box.Filler(minSize, prefSize, maxSize));
        jPanel1.add(mdp);
        jPanel1.add(jPasswordField1);
        jPanel1.add(new Box.Filler(minSize, prefSize, maxSize));

        Dimension minSize2 = new Dimension(5, 10); //Cette ligne et les 3 suivantes servent à espacer les composants ajoutés avant et après ces lignes
        Dimension prefSize2 = new Dimension(5, 10);
        Dimension maxSize2 = new Dimension(Short.MAX_VALUE, 10);
        jPanel1.add(new Box.Filler(minSize2, prefSize2, maxSize2));
        jPanel1.add(Valider);

        jPanel1.add(box2);
        box.setVisible(false);
        box2.setVisible(false);
        erreur.setVisible(false);

        // On change la couleur de tous nos panels
        jPanel1.setBackground(LIGHT_BLUE);
        panel.setBackground(LIGHT_BLUE);
        panel2.setBackground(LIGHT_BLUE);
        panel3.setBackground(LIGHT_BLUE);
        panel4.setBackground(LIGHT_BLUE);
        // messageErreur.setBackground(LIGHT_BLUE);

        // On ajoute les panels dans le boxLayout
        panel.add(panel2);

        panel.add(jPanel1);
        panel.add(panel3);

        panelfin.add(panel4, BorderLayout.WEST); // On ajoute le panel à gauche pour espacer
        panelfin.add(panel); // On ajoute le panel que l'on a remplit précédemment dans le panel final

        connexion.add(panelfin, BorderLayout.CENTER); // On ajoute le panel final au centre de la fenêtre

    }

}
