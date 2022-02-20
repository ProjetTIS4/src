/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.TitledBorder;

/**
 *
 * @author lenal
 */
public class AjouterActe implements Runnable {

    protected JFrame ajouterActe;
    private static final Color LIGHT_BLUE2 = new Color(225, 248, 255);
    private static final Color LIGHT_BLUE = new Color(100, 180, 200, 150);

    @Override
    public void run() {

        ajouterActe = new JFrame("Ajouter un acte");
        ajouterActe.setBounds(450, 190, 700, 460);
        ajouterActe.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ajouterActe.setVisible(true);

        //////////////////////// La date ////////////////////////
        JLabel date = new JLabel("Date : ");
        JTextField jour = new JTextField("JJ");
        jour.setForeground(Color.gray);
        JLabel slash = new JLabel("/");
        JTextField mois = new JTextField("MM");
        mois.setForeground(Color.gray);
        JLabel slash2 = new JLabel("/");
        JTextField annee = new JTextField("AAAA");
        annee.setForeground(Color.gray);

        JPanel panelDate = new JPanel(new FlowLayout());
        panelDate.add(date);
        panelDate.add(jour);
        panelDate.add(slash);
        panelDate.add(mois);
        panelDate.add(slash2);
        panelDate.add(annee);

        jour.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                jour.setText("");
                jour.setForeground(Color.black);
            }
        });

        jour.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                if (jour.getText().length() >= 2) // limit to 3 characters
                {
                    e.consume();
                }
            }
        });

        mois.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                mois.setText("");
                mois.setForeground(Color.black);
            }
        });

        mois.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (mois.getText().length() >= 2) // limit to 3 characters
                {
                    e.consume();
                }
            }
        });

        annee.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                annee.setText("");
                annee.setForeground(Color.black);
            }
        });

        annee.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (annee.getText().length() >= 4) // limit to 3 characters
                {
                    e.consume();
                }
            }
        });

        //////////////////////// Panel heure ////////////////////////
        JPanel panelHeure = new JPanel(new FlowLayout());

        JLabel horaire = new JLabel("Heure : ");
        JTextField heure = new JTextField("   ");
        JLabel pts = new JLabel(":");
        JTextField minute = new JTextField("   ");

        panelHeure.add(horaire);
        panelHeure.add(heure);
        panelHeure.add(pts);
        panelHeure.add(minute);

        heure.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                heure.setText("");
            }
        });

        heure.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (heure.getText().length() >= 2) // limit to 3 characters
                {
                    e.consume();
                }
            }
        });

        minute.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                minute.setText("");

            }
        });

        minute.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (minute.getText().length() >= 2) // limit to 3 characters
                {
                    e.consume();
                }
            }
        });

        //////////////////////// Observations  ////////////////////////
        JPanel panelObs = new JPanel(new FlowLayout());
        JLabel observations = new JLabel("Observations : ");
        JTextArea observations2 = new JTextArea(5, 20){
        @Override
        protected void paintComponent(Graphics g) {
            if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setPaint(getBackground());
                g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(
                        0, 0, getWidth() - 1, getHeight() - 1));
                g2.dispose();
            }
            super.paintComponent(g);
        }

        @Override
        public void updateUI() {
            super.updateUI();
            setOpaque(false);
            setBorder(new RoundedCornerBorder());
        }
    };
        observations2.setLineWrap(true);
        JScrollPane obs = new JScrollPane();
        obs.setViewportView(observations2);

        panelObs.add(observations);
        panelObs.add(obs);

        //////////////////////// Prestations  ////////////////////////
        JPanel panelPres = new JPanel(new FlowLayout());
        JLabel prestations = new JLabel("Prescriptions : ");
        JTextArea prestations2 = new JTextArea(5, 20);
        prestations2.setLineWrap(true);
        JScrollPane pres = new JScrollPane();
        pres.setViewportView(prestations2);

        panelPres.add(prestations);
        panelPres.add(pres);

        //////////////////////// Opérations  ////////////////////////
        JPanel panelOp = new JPanel(new FlowLayout());
        JLabel operations = new JLabel("Opérations :     ");
        JTextArea operations2 = new JTextArea(5, 20);
        operations2.setLineWrap(true);
        JScrollPane ope = new JScrollPane();
        ope.setViewportView(operations2);

        panelOp.add(operations);
        panelOp.add(ope);

        //////////////////////// Résultats  ////////////////////////
        JPanel panelRes = new JPanel(new FlowLayout());
        JLabel resultats = new JLabel("Résultats : ");
        JTextArea resultat2 = new JTextArea(5, 20);
        resultat2.setLineWrap(true);
        JScrollPane resu = new JScrollPane();
        resu.setViewportView(resultat2);

        panelRes.add(resultats);
        panelRes.add(resu);

        JPanel jPanel2 = new JPanel(new GridBagLayout());
        JPanel jPanel3 = new JPanel(new GridBagLayout());

        TitledBorder title2;
        title2 = BorderFactory.createTitledBorder("Ajout Acte");
        jPanel2.setBorder(title2);

        /*3- Ajout de ces composants en spécifiant les contraintes de type GridBagConstraints. */
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(15, 15, 0, 15);
        gbc.anchor = GridBagConstraints.WEST;
        jPanel2.add(panelDate, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(0, 15, 0, 15);
        jPanel2.add(panelHeure, gbc);

        gbc.gridy = 2;
        gbc.insets = new Insets(0, 15, 0, 15);
        jPanel2.add(panelObs, gbc);

       gbc.gridy = 3;
       gbc.insets = new Insets(0, 15, 0, 15);
       jPanel2.add(panelPres, gbc);

       gbc.gridy = 4;
       gbc.insets = new Insets(0, 15, 0, 15);
       jPanel2.add(panelOp, gbc);

//        gbc.gridy = 5;
//        gbc.insets = new Insets(0, 15, 0, 15);
//        jPanel2.add(panelRes, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;

        jPanel3.add(jPanel2, gbc);

        ajouterActe.add(jPanel3, BorderLayout.CENTER); // On ajoute le panel final au centre de la fenêtre

        jPanel3.setBackground(LIGHT_BLUE2);
        jPanel2.setBackground(LIGHT_BLUE);

        //   ajouterActe.pack();
        // Les couleurs 
        panelDate.setOpaque(false);
        panelHeure.setOpaque(false);
        panelObs.setOpaque(false);
        panelPres.setOpaque(false);
        panelOp.setOpaque(false);
 //      panelRes.setOpaque(false);

    }

}
