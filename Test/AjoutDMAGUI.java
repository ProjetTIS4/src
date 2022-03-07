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
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author manon
 */
public class AjoutDMAGUI {
    private JFrame ajouterDMA;

    private static final Color LIGHT_BLUE2 = new Color(225, 248, 255);
    private static final Color LIGHT_BLUE = new Color(100, 180, 200);
    private TitledBorder title2;
    private GridBagConstraints gbc;

    private JPanel panelDate;
    private JPanel panelHeure;
    private JPanel panelPatient;
    private JPanel panelPres;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    
    ////////////Panel Date ///////////////
    private JLabel date;
    private JTextField jour;
    private JLabel slash;
    private JTextField mois;
    private JLabel slash2;
    private JTextField annee;

    ////////////Panel Heure ///////////////
    private JLabel horaire;
    private JTextField heure;
    private JLabel pts;
    private JTextField minute;
    
    ////////////Panel Observations ///////////////
    private JLabel observations;
    private JLabel nom;
    private JTextArea observations2;
    private JTextArea nom2;
    private JScrollPane obs;

    
    ////////////Bouton Valider ///////////////
    private JButton valider;
    private ImageIcon validerImgIcon;
    
    
    public AjoutDMAGUI() {
        ajouterDMA = new JFrame("Ajouter un DMA");
        ajouterDMA.setMinimumSize(new Dimension(500, 700));
//        ajouterActe.setPreferredSize(new Dimension(300, 100));

        panelDate = new JPanel(new FlowLayout());
        panelHeure = new JPanel(new FlowLayout());
        
        date = new JLabel("Date : ");
        jour = new JTextField("JJ");
        jour.setForeground(Color.gray);
        slash = new JLabel("/");
        mois = new JTextField("MM");
        mois.setForeground(Color.gray);
        slash2 = new JLabel("/");
        annee = new JTextField("AAAA");
        annee.setForeground(Color.gray);

        horaire = new JLabel("Heure : ");
        heure = new JTextField("   ");
        pts = new JLabel(":");
        minute = new JTextField("   ");
        
        nom = new JLabel("Nom : ");
        nom2 = new JTextArea(5, 20);
        nom2.setLineWrap(true);
        n = new JScrollPane();
        n.setViewportView(observations2);
        
        
        validerImgIcon = new ImageIcon("src/Annexes/valider.png");

        
        valider = new JButton(validerImgIcon);
        valider.setContentAreaFilled(false);
        valider.setBorderPainted(false);
     

        panelDate.add(date);
        panelDate.add(jour);
        panelDate.add(slash);
        panelDate.add(mois);
        panelDate.add(slash2);
        panelDate.add(annee);

        panelHeure.add(horaire);
        panelHeure.add(heure);
        panelHeure.add(pts);
        panelHeure.add(minute);
        
        
        panelDate.setOpaque(false);
        panelHeure.setOpaque(false);
        
        title2 = BorderFactory.createTitledBorder("");
        jPanel2.setBorder(title2);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(15, 15, 0, 15);
        gbc.anchor = GridBagConstraints.WEST;
        jPanel2.add(panelDate, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(0, 15, 0, 15);
        jPanel2.add(panelHeure, gbc);

        

        gbc.gridy = 3;
        gbc.insets = new Insets(0, 15, 0, 15);
        jPanel2.add(panelPres, gbc);

        
        
                gbc.gridy = 6;
        gbc.insets = new Insets(0, 15, 15, 15);
        gbc.anchor = GridBagConstraints.CENTER;
        jPanel2.add(valider, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(13, 15, 15, 15);

        jPanel4.add(jPanel2, gbc);
        jPanel3.add(jPanel4);

        ajouterDMA.add(jPanel3, BorderLayout.CENTER); // On ajoute le panel final au centre de la fenêtre
    }

    public JFrame getAjouterDMA() {
        return ajouterDMA;
    }

    public void setAjouterDMA(JFrame ajouterDMA) {
        this.ajouterDMA = ajouterDMA;
    }

    public TitledBorder getTitle2() {
        return title2;
    }

    public void setTitle2(TitledBorder title2) {
        this.title2 = title2;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public void setGbc(GridBagConstraints gbc) {
        this.gbc = gbc;
    }

    public JPanel getPanelDate() {
        return panelDate;
    }

    public void setPanelDate(JPanel panelDate) {
        this.panelDate = panelDate;
    }

    public JPanel getPanelHeure() {
        return panelHeure;
    }

    public void setPanelHeure(JPanel panelHeure) {
        this.panelHeure = panelHeure;
    }

    public JPanel getPanelPatient() {
        return panelPatient;
    }

    public void setPanelPatient(JPanel panelPatient) {
        this.panelPatient = panelPatient;
    }

    public JPanel getPanelPres() {
        return panelPres;
    }

    public void setPanelPres(JPanel panelPres) {
        this.panelPres = panelPres;
    }

    public JLabel getDate() {
        return date;
    }

    public void setDate(JLabel date) {
        this.date = date;
    }

    public JTextField getJour() {
        return jour;
    }

    public void setJour(JTextField jour) {
        this.jour = jour;
    }

    public JLabel getSlash() {
        return slash;
    }

    public void setSlash(JLabel slash) {
        this.slash = slash;
    }

    public JTextField getMois() {
        return mois;
    }

    public void setMois(JTextField mois) {
        this.mois = mois;
    }

    public JLabel getSlash2() {
        return slash2;
    }

    public void setSlash2(JLabel slash2) {
        this.slash2 = slash2;
    }

    public JTextField getAnnee() {
        return annee;
    }

    public void setAnnee(JTextField annee) {
        this.annee = annee;
    }

    public JLabel getHoraire() {
        return horaire;
    }

    public void setHoraire(JLabel horaire) {
        this.horaire = horaire;
    }

    public JTextField getHeure() {
        return heure;
    }

    public void setHeure(JTextField heure) {
        this.heure = heure;
    }

    public JLabel getPts() {
        return pts;
    }

    public void setPts(JLabel pts) {
        this.pts = pts;
    }

    public JTextField getMinute() {
        return minute;
    }

    public void setMinute(JTextField minute) {
        this.minute = minute;
    }

    public JLabel getObservations() {
        return observations;
    }

    public void setObservations(JLabel observations) {
        this.observations = observations;
    }

    public JTextArea getObservations2() {
        return observations2;
    }

    public void setObservations2(JTextArea observations2) {
        this.observations2 = observations2;
    }

    public JScrollPane getObs() {
        return obs;
    }

    public void setObs(JScrollPane obs) {
        this.obs = obs;
    }

    public JButton getValider() {
        return valider;
    }

    public void setValider(JButton valider) {
        this.valider = valider;
    }

    public ImageIcon getValiderImgIcon() {
        return validerImgIcon;
    }

    public void setValiderImgIcon(ImageIcon validerImgIcon) {
        this.validerImgIcon = validerImgIcon;
    }
 
    public JLabel getNom() {
        return nom;
    }

    public void setNom(JLabel nom) {
        this.nom = nom;
    }

    public JTextArea getNom2() {
        return nom2;
    }

    public void setNom2(JTextArea nom2) {
        this.nom2 = nom2;
    }

    public JScrollPane getN() {
        return n;
    }

    public void setN(JScrollPane n) {
        this.n = n;
    }
    private JScrollPane n;
}
