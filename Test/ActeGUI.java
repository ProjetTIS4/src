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
import java.awt.GridBagLayout;
import java.awt.Image;
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
 * @author lenal
 */
public class ActeGUI {

    private JFrame ajouterActe;

    private static final Color LIGHT_BLUE2 = new Color(225, 248, 255);
    private static final Color LIGHT_BLUE = new Color(100, 180, 200);
    private TitledBorder title2;
    private GridBagConstraints gbc;

    private JPanel panelDate;
    private JPanel panelHeure;
    private JPanel panelObs;
    private JPanel panelPres;
    private JPanel panelOp;
    private JPanel panelRes;
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
    private JTextArea observations2;
    private JScrollPane obs;

    ////////////Panel Prestations ///////////////
    private JLabel prestations;
    private JTextArea prestations2;
    private JScrollPane pres;

    ////////////Panel Opérations ///////////////
    private JLabel operations;
    private JTextArea operations2;
    private JScrollPane ope;

    ////////////Panel Résultats ///////////////
    private JLabel resultats;
    private JTextArea resultat2;
    private JScrollPane resu;

    ////////////Bouton Valider ///////////////
    private JButton valider;
    private ImageIcon validerImgIcon;


    public ActeGUI() {
        ajouterActe = new JFrame("Ajouter un acte");
        ajouterActe.setMinimumSize(new Dimension(500, 700));
//        ajouterActe.setPreferredSize(new Dimension(300, 100));

        panelDate = new JPanel(new FlowLayout());
        panelHeure = new JPanel(new FlowLayout());
        panelObs = new JPanel(new FlowLayout());
        panelPres = new JPanel(new FlowLayout());
        panelOp = new JPanel(new FlowLayout());
        panelRes = new JPanel(new FlowLayout());
        jPanel2 = new JPanel(new GridBagLayout());
        jPanel3 = new JPanel(new GridBagLayout());
        jPanel4 = new JPanel(new GridBagLayout());

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

        observations = new JLabel("Observations : ");
        observations2 = new JTextArea(5, 20);
        observations2.setLineWrap(true);
        obs = new JScrollPane();
        obs.setViewportView(observations2);

        prestations = new JLabel("Prescriptions : ");
        prestations2 = new JTextArea(5, 20);
        prestations2.setLineWrap(true);
        pres = new JScrollPane();
        pres.setViewportView(prestations2);

        operations = new JLabel("Opérations :     ");
        operations2 = new JTextArea(5, 20);
        operations2.setLineWrap(true);
        ope = new JScrollPane();
        ope.setViewportView(operations2);

        resultats = new JLabel("Résultats :        ");
        resultat2 = new JTextArea(5, 20);
        resultat2.setLineWrap(true);
        resu = new JScrollPane();
        resu.setViewportView(resultat2);
        
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

        panelObs.add(observations);
        panelObs.add(obs);

        panelPres.add(prestations);
        panelPres.add(pres);

        panelOp.add(operations);
        panelOp.add(ope);

        panelRes.add(resultats);
        panelRes.add(resu);

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

        gbc.gridy = 2;
        gbc.insets = new Insets(0, 15, 0, 15);
        jPanel2.add(panelObs, gbc);

        gbc.gridy = 3;
        gbc.insets = new Insets(0, 15, 0, 15);
        jPanel2.add(panelPres, gbc);

        gbc.gridy = 4;
        gbc.insets = new Insets(0, 15, 0, 15);
        jPanel2.add(panelOp, gbc);

        gbc.gridy = 5;
        gbc.insets = new Insets(0, 15, 0, 15);
        jPanel2.add(panelRes, gbc);
        
                gbc.gridy = 6;
        gbc.insets = new Insets(0, 15, 15, 15);
        gbc.anchor = GridBagConstraints.CENTER;
        jPanel2.add(valider, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(13, 15, 15, 15);

        jPanel4.add(jPanel2, gbc);
        jPanel3.add(jPanel4);

        ajouterActe.add(jPanel3, BorderLayout.CENTER); // On ajoute le panel final au centre de la fenêtre

        jPanel3.setBackground(LIGHT_BLUE2);
        jPanel2.setBackground(LIGHT_BLUE);
        jPanel4.setBackground(LIGHT_BLUE);

        panelDate.setOpaque(false);
        panelHeure.setOpaque(false);
        panelObs.setOpaque(false);
        panelPres.setOpaque(false);
        panelOp.setOpaque(false);
        panelRes.setOpaque(false);

    }

    public JFrame getAjouterActe() {
        return ajouterActe;
    }

    public void setAjouterActe(JFrame ajouterActe) {
        this.ajouterActe = ajouterActe;
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

    public JPanel getPanelObs() {
        return panelObs;
    }

    public void setPanelObs(JPanel panelObs) {
        this.panelObs = panelObs;
    }

    public JPanel getPanelPres() {
        return panelPres;
    }

    public void setPanelPres(JPanel panelPres) {
        this.panelPres = panelPres;
    }

    public JPanel getPanelOp() {
        return panelOp;
    }

    public void setPanelOp(JPanel panelOp) {
        this.panelOp = panelOp;
    }

    public JPanel getPanelRes() {
        return panelRes;
    }

    public void setPanelRes(JPanel panelRes) {
        this.panelRes = panelRes;
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

    public JLabel getPrestations() {
        return prestations;
    }

    public void setPrestations(JLabel prestations) {
        this.prestations = prestations;
    }

    public JTextArea getPrestations2() {
        return prestations2;
    }

    public void setPrestations2(JTextArea prestations2) {
        this.prestations2 = prestations2;
    }

    public JScrollPane getPres() {
        return pres;
    }

    public void setPres(JScrollPane pres) {
        this.pres = pres;
    }

    public JLabel getOperations() {
        return operations;
    }

    public void setOperations(JLabel operations) {
        this.operations = operations;
    }

    public JTextArea getOperations2() {
        return operations2;
    }

    public void setOperations2(JTextArea operations2) {
        this.operations2 = operations2;
    }

    public JScrollPane getOpe() {
        return ope;
    }

    public void setOpe(JScrollPane ope) {
        this.ope = ope;
    }

    public JLabel getResultats() {
        return resultats;
    }

    public void setResultats(JLabel resultats) {
        this.resultats = resultats;
    }

    public JTextArea getResultat2() {
        return resultat2;
    }

    public void setResultat2(JTextArea resultat2) {
        this.resultat2 = resultat2;
    }

    public JScrollPane getResu() {
        return resu;
    }

    public void setResu(JScrollPane resu) {
        this.resu = resu;
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

    public JPanel getjPanel4() {
        return jPanel4;
    }

    public void setjPanel4(JPanel jPanel4) {
        this.jPanel4 = jPanel4;
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
    
    
}
