/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import NF.Personnel;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_ENTER;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author lenal
 */
public class ConnexionCtrl implements Runnable {

    String utilisateur;
    String mdp;
    Personnel p;
    ConnexionGUI c;
    String valeurBouton;

    /**
     *
     */
    public ConnexionCtrl() {
        initLookAndFeel(); // Appelle la fonction qui choisit le Look and Feel Nimbus 
        c = new ConnexionGUI();

    }

    /**
     *
     */
    public void run() {

        //////////////////////// Fenêtre ////////////////////////
        c.getConnexion().setBounds(450, 190, 720, 460);
        c.getConnexion().setDefaultCloseOperation(EXIT_ON_CLOSE);
        c.getConnexion().setVisible(true);
 

        c.getPHS().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                valeurBouton = "PHS";
                c.getConnexionTexte2().setText("Personnel Hospitalier de Service");
                c.getConnexion().setContentPane(c.getPanelConnexion());
                c.getConnexion().validate();
                c.getConnexion().repaint();
            }
        });

        c.getPHA().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                valeurBouton = "PHA";
                c.getConnexionTexte2().setText("Personnel Hospitalier Anesthésiste");
                c.getConnexion().setContentPane(c.getPanelConnexion());
                c.getConnexion().validate();
                c.getConnexion().repaint();
            }
        });

        c.getPHMT().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                valeurBouton = "PHMT";
                c.getConnexionTexte2().setText("Personnel Hospitalier Médico Technique");
                c.getConnexion().setContentPane(c.getPanelConnexion());
                c.getConnexion().validate();
                c.getConnexion().repaint();
            }
        });

        c.getSA().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                valeurBouton = "SA";
                c.getConnexionTexte2().setText("Secrétaire Administrative");
                c.getConnexion().setContentPane(c.getPanelConnexion());
                c.getConnexion().validate();
                c.getConnexion().repaint();
            }
        });

        c.getSM().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                valeurBouton = "SM";
                c.getConnexionTexte2().setText("Secrétaire Médicale");
                c.getConnexion().setContentPane(c.getPanelConnexion());
                c.getConnexion().validate();
                c.getConnexion().repaint();
            }
        });
        
             c.getRetour().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                c.getConnexion().setContentPane(c.getPanelBoutons());
                c.getErreur().setVisible(false);
                c.getTextUtilisateur().setText("");
                c.getjPasswordField1().setText("");
                c.getConnexion().validate();
                c.getConnexion().repaint();
            }
        });


        //////////////////////// Listener de connexion ////////////////////////
        c.getValider().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                connexion();

            }
        });

        c.getjPasswordField1().addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == VK_ENTER) {
                    connexion();
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });

    }

    private static void initLookAndFeel() {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }

    }

    /**
     *
     */
    public void connexion() {

        try {
            
            String url = "jdbc:mysql://hugofarcy.ddns.net:3306/SIH?autoReconnect=true&useSSL=false";
            String user = "DEV";
            String password = "SIH-mmlh2022";

            Connection con = DriverManager.getConnection(url, user, password);

            String query = "SELECT COUNT(*) FROM " + valeurBouton;
            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);

            int taille = 0;

            if (res.next()) {
                taille = res.getInt("COUNT(*)");
            }

            String data[][] = new String[taille][6];

            query = "SELECT * FROM " + valeurBouton;
            res = stm.executeQuery(query);

            int i = 0;
            while (res.next()) {
                String nom = res.getString("nom");
                String prenom = res.getString("prenom");
                String id = res.getString("ID");
                String mdp = res.getString("mdp");
                String service = res.getString("service");
                String poste = res.getString("poste");
                data[i][0] = nom;
                data[i][1] = prenom;
                data[i][2] = id;
                data[i][3] = mdp;
                data[i][4] = service;
                data[i][5] = poste;
                i++;
            }

            utilisateur = c.getTextUtilisateur().getText();

            mdp = c.getjPasswordField1().getText();
            int j = 0;

            while (utilisateur.equals(data[j][2]) == false && j < data.length - 1) {
                j++;

            }
            if (utilisateur.equals(data[j][2])) {

                if (mdp.equals(data[j][3])) { //On vérifie que le mot de passe est correct
                    c.getConnexion().setVisible(false);
                    p = new Personnel(data[j][0], data[j][1], data[j][4], data[j][5], data[j][2], data[j][3]);
                    SwingUtilities.invokeLater(new AccueilCtrl(p));

                } else {

                    c.getErreur().setForeground(Color.red);
                    c.getErreur().setText("Le nom d'utilisateur ou le mot de passe est incorrect ");
                    c.getErreur().setForeground(Color.red);

                    c.getConnexion().revalidate();
                    c.getConnexion().repaint();
                    j = 0;
                }

            } else {
                c.getErreur().setForeground(Color.red);
                c.getErreur().setText("Le nom d'utilisateur ou le mot de passe est incorrect ");
                c.getErreur().setForeground(Color.red);

                c.getConnexion().revalidate();
                c.getConnexion().repaint();
                j = 0;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
     
}
