/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
    private JPanel panelPH;
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

    ////////////Panel PHRéférent ///////////////
    private JLabel phLabel;
    private JComboBox choixPH;

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

/**
     *Crée tous les panels, leur label et les boutons contenus dans la fenêtre "Ajouter acte" et les organise dans l'espace
     */

    public ActeGUI() {
        ajouterActe = new JFrame("Ajouter un acte");
        Image icone = Toolkit.getDefaultToolkit().getImage("src/Annexes/Hubspital_logo_grand.png");
        ajouterActe.setIconImage(icone);
        ajouterActe.setMinimumSize(new Dimension(500, 800));
//        ajouterActe.setPreferredSize(new Dimension(300, 100));

        panelDate = new JPanel(new FlowLayout());
        panelHeure = new JPanel(new FlowLayout());
        panelPH = new JPanel(new FlowLayout());
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

        phLabel = new JLabel("PH référent : ");
        choixPH = new JComboBox();

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

        panelPH.add(phLabel);
        panelPH.add(choixPH);

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
        jPanel2.add(panelPH, gbc);

        gbc.gridy = 3;
        gbc.insets = new Insets(0, 15, 0, 15);
        jPanel2.add(panelObs, gbc);

        gbc.gridy = 4;
        gbc.insets = new Insets(0, 15, 0, 15);
        jPanel2.add(panelPres, gbc);

        gbc.gridy = 5;
        gbc.insets = new Insets(0, 15, 0, 15);
        jPanel2.add(panelOp, gbc);

        gbc.gridy = 6;
        gbc.insets = new Insets(0, 15, 0, 15);
        jPanel2.add(panelRes, gbc);

        gbc.gridy = 7;
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
         panelPH.setOpaque(false);
        panelObs.setOpaque(false);
        panelPres.setOpaque(false);
        panelOp.setOpaque(false);
        panelRes.setOpaque(false);

    }

     /**
     *
     * @return
     */
    public JFrame getAjouterActe() {
        return ajouterActe;
    }

    /**
     *
     * @param ajouterActe
     */
    public void setAjouterActe(JFrame ajouterActe) {
        this.ajouterActe = ajouterActe;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelDate() {
        return panelDate;
    }

    /**
     *
     * @param panelDate
     */
    public void setPanelDate(JPanel panelDate) {
        this.panelDate = panelDate;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelHeure() {
        return panelHeure;
    }

    /**
     *
     * @param panelHeure
     */
    public void setPanelHeure(JPanel panelHeure) {
        this.panelHeure = panelHeure;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelObs() {
        return panelObs;
    }

    /**
     *
     * @param panelObs
     */
    public void setPanelObs(JPanel panelObs) {
        this.panelObs = panelObs;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelPres() {
        return panelPres;
    }

    /**
     *
     * @param panelPres
     */
    public void setPanelPres(JPanel panelPres) {
        this.panelPres = panelPres;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelOp() {
        return panelOp;
    }

    /**
     *
     * @param panelOp
     */
    public void setPanelOp(JPanel panelOp) {
        this.panelOp = panelOp;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelRes() {
        return panelRes;
    }

    /**
     *
     * @param panelRes
     */
    public void setPanelRes(JPanel panelRes) {
        this.panelRes = panelRes;
    }

    /**
     *
     * @return
     */
    public JLabel getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(JLabel date) {
        this.date = date;
    }

    /**
     *
     * @return
     */
    public JTextField getJour() {
        return jour;
    }

    /**
     *
     * @param jour
     */
    public void setJour(JTextField jour) {
        this.jour = jour;
    }

    /**
     *
     * @return
     */
    public JLabel getSlash() {
        return slash;
    }

    /**
     *
     * @param slash
     */
    public void setSlash(JLabel slash) {
        this.slash = slash;
    }

    /**
     *
     * @return
     */
    public JTextField getMois() {
        return mois;
    }

    /**
     *
     * @param mois
     */
    public void setMois(JTextField mois) {
        this.mois = mois;
    }

    /**
     *
     * @return
     */
    public JLabel getSlash2() {
        return slash2;
    }

    /**
     *
     * @param slash2
     */
    public void setSlash2(JLabel slash2) {
        this.slash2 = slash2;
    }

    /**
     *
     * @return
     */
    public JTextField getAnnee() {
        return annee;
    }

    /**
     *
     * @param annee
     */
    public void setAnnee(JTextField annee) {
        this.annee = annee;
    }

    /**
     *
     * @return
     */
    public JLabel getHoraire() {
        return horaire;
    }

    /**
     *
     * @param horaire
     */
    public void setHoraire(JLabel horaire) {
        this.horaire = horaire;
    }

    /**
     *
     * @return
     */
    public JTextField getHeure() {
        return heure;
    }

    /**
     *
     * @param heure
     */
    public void setHeure(JTextField heure) {
        this.heure = heure;
    }

    /**
     *
     * @return
     */
    public JLabel getPts() {
        return pts;
    }

    /**
     *
     * @param pts
     */
    public void setPts(JLabel pts) {
        this.pts = pts;
    }

    /**
     *
     * @return
     */
    public JTextField getMinute() {
        return minute;
    }

    /**
     *
     * @param minute
     */
    public void setMinute(JTextField minute) {
        this.minute = minute;
    }

    /**
     *
     * @return
     */
    public JLabel getObservations() {
        return observations;
    }

    /**
     *
     * @param observations
     */
    public void setObservations(JLabel observations) {
        this.observations = observations;
    }

    /**
     *
     * @return
     */
    public JTextArea getObservations2() {
        return observations2;
    }

    /**
     *
     * @param observations2
     */
    public void setObservations2(JTextArea observations2) {
        this.observations2 = observations2;
    }

    /**
     *
     * @return
     */
    public JScrollPane getObs() {
        return obs;
    }

    /**
     *
     * @param obs
     */
    public void setObs(JScrollPane obs) {
        this.obs = obs;
    }

    /**
     *
     * @return
     */
    public JLabel getPrestations() {
        return prestations;
    }

    /**
     *
     * @param prestations
     */
    public void setPrestations(JLabel prestations) {
        this.prestations = prestations;
    }

    /**
     *
     * @return
     */
    public JTextArea getPrestations2() {
        return prestations2;
    }

    /**
     *
     * @param prestations2
     */
    public void setPrestations2(JTextArea prestations2) {
        this.prestations2 = prestations2;
    }

    /**
     *
     * @return
     */
    public JScrollPane getPres() {
        return pres;
    }

    /**
     *
     * @param pres
     */
    public void setPres(JScrollPane pres) {
        this.pres = pres;
    }

    /**
     *
     * @return
     */
    public JLabel getOperations() {
        return operations;
    }

    /**
     *
     * @param operations
     */
    public void setOperations(JLabel operations) {
        this.operations = operations;
    }

    /**
     *
     * @return
     */
    public JTextArea getOperations2() {
        return operations2;
    }

    /**
     *
     * @param operations2
     */
    public void setOperations2(JTextArea operations2) {
        this.operations2 = operations2;
    }

    /**
     *
     * @return
     */
    public JScrollPane getOpe() {
        return ope;
    }

    /**
     *
     * @param ope
     */
    public void setOpe(JScrollPane ope) {
        this.ope = ope;
    }

    /**
     *
     * @return
     */
    public JLabel getResultats() {
        return resultats;
    }

    /**
     *
     * @param resultats
     */
    public void setResultats(JLabel resultats) {
        this.resultats = resultats;
    }

    /**
     *
     * @return
     */
    public JTextArea getResultat2() {
        return resultat2;
    }

    /**
     *
     * @param resultat2
     */
    public void setResultat2(JTextArea resultat2) {
        this.resultat2 = resultat2;
    }

    /**
     *
     * @return
     */
    public JScrollPane getResu() {
        return resu;
    }

    /**
     *
     * @param resu
     */
    public void setResu(JScrollPane resu) {
        this.resu = resu;
    }

    /**
     *
     * @return
     */
    public TitledBorder getTitle2() {
        return title2;
    }

    /**
     *
     * @param title2
     */
    public void setTitle2(TitledBorder title2) {
        this.title2 = title2;
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
    public JPanel getjPanel4() {
        return jPanel4;
    }

    /**
     *
     * @param jPanel4
     */
    public void setjPanel4(JPanel jPanel4) {
        this.jPanel4 = jPanel4;
    }

    /**
     *
     * @return
     */
    public JButton getValider() {
        return valider;
    }

    /**
     *
     * @param valider
     */
    public void setValider(JButton valider) {
        this.valider = valider;
    }

    /**
     *
     * @return
     */
    public ImageIcon getValiderImgIcon() {
        return validerImgIcon;
    }

    /**
     *
     * @param validerImgIcon
     */
    public void setValiderImgIcon(ImageIcon validerImgIcon) {
        this.validerImgIcon = validerImgIcon;
    }

    public JComboBox getChoixPH() {
        return choixPH;
    }

    public void setChoixPH(JComboBox choixPH) {
        this.choixPH = choixPH;
    }

    public JPanel getPanelPH() {
        return panelPH;
    }

    public void setPanelPH(JPanel panelPH) {
        this.panelPH = panelPH;
    }

}
