package Test;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manon
 */

public class AjoutPatGUI {
    private JFrame ajouterPat;

    private static final Color LIGHT_BLUE2 = new Color(225, 248, 255);
    private static final Color LIGHT_BLUE = new Color(100, 180, 200);
    private TitledBorder title2;
    private GridBagConstraints gbc;

    
    private JPanel panelpatient;
    private JPanel panelNom;
    private JPanel panelNomM;
    private JPanel panelPrenom;
    private JPanel panelSexe;
    private JPanel panelAdresse;
    private JPanel panelDateN;
    private JPanel panelAdresseN;
    private JPanel panelLoc;
    private JPanel panelMedGen;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;

    
////////////////////////////////////////////////////Panel patient////////////////////////////
    private JLabel patient;
    
    ////////////Panel Nom ///////////////
    private JLabel nom;
    private JTextField nom2;
    
    ////////////Panel Nom Marital ///////////////
    private JLabel nomM;
    private JTextField nomM2;

    ////////////Panel PrÃ©nom ///////////////
    private JLabel prenom;
    private JTextField prenom2;
    
    ////////////Panel Sexe ///////////////
    private JLabel sexe;
    private JComboBox choix;
    private Vector<String> S;
    
    
    
    ////////////Panel Adresse ///////////////
    private JLabel adresse;
    private JTextField adresse2;
    
    ////////////Panel Date de Naissance ///////////////
    private JLabel dateN;
    private JTextField jourN;
    private JLabel slashN;
    private JTextField moisN;
    private JLabel slashN2;
    private JTextField anneeN;
    
    ////////////Panel Adresse Naissance ///////////////
    private JLabel adresseN;
    private JTextField adresseN2;
    
    ////////////Panel Localisation ///////////////
    private JLabel loc;
    private JTextField loc2;
    
    ////////////Panel Medecin gÃ©nÃ©raliste ///////////////
    private JLabel medGen;
    private JTextField medGen2;

    ////////////Bouton Valider ///////////////
    private JButton valider;
    private ImageIcon validerImgIcon;

    public AjoutPatGUI() {
        ajouterPat = new JFrame("Créer un nouveau patient");
        ajouterPat.setMinimumSize(new Dimension(500, 700));
//        ajouterActe.setPreferredSize(new Dimension(300, 100));

panelpatient= new JPanel(new FlowLayout());
        panelNom = new JPanel(new FlowLayout());
        panelNomM=new JPanel(new FlowLayout());
        panelPrenom = new JPanel(new FlowLayout());
        panelAdresse = new JPanel(new FlowLayout());
        panelSexe = new JPanel(new FlowLayout());
        panelDateN = new JPanel(new FlowLayout());
        panelAdresseN = new JPanel(new FlowLayout());
        panelLoc = new JPanel(new FlowLayout());
        panelMedGen = new JPanel(new FlowLayout());
        jPanel2 = new JPanel(new GridBagLayout());
        jPanel3 = new JPanel(new GridBagLayout());
        jPanel4 = new JPanel(new GridBagLayout());

        
        patient=new JLabel("Patient :");
        Font font = new Font("Courier", Font.BOLD,12);
        patient.setFont(font);
        
        nom = new JLabel("Nom : ");
        nom2 = new JTextField("    Nom    ");
        nom2.setForeground(Color.gray);

        nomM = new JLabel("Nom marital : ");
        nomM2 = new JTextField("    Nom marital    ");
        nomM2.setForeground(Color.gray);

        prenom = new JLabel("Prénom : ");
        prenom2 = new JTextField("   Prénom    ");
        prenom2.setForeground(Color.gray);
        
        adresse = new JLabel("Adresse : ");
        adresse2 = new JTextField("   Adresse    ");
        adresse2.setForeground(Color.gray);
        
        sexe= new JLabel("Sexe : ");
        S= new Vector<>();
        S.add("F");
        S.add("M");
        choix= new JComboBox(S);
        
        dateN = new JLabel("Date de naissance : ");
        jourN = new JTextField("JJ");
        jourN.setForeground(Color.gray);
        slashN = new JLabel("/");
        moisN = new JTextField("MM");
        moisN.setForeground(Color.gray);
        slashN2 = new JLabel("/");
        anneeN = new JTextField("AAAA");
        anneeN.setForeground(Color.gray);
        
        adresseN = new JLabel("Adresse de naissance : ");
        adresseN2 = new JTextField("   Adresse de naissance   ");
        adresseN2.setForeground(Color.gray);
        
        loc = new JLabel("Localisation : ");
        loc2 = new JTextField("    Localisation     ");
        loc2.setForeground(Color.gray);
        
        medGen = new JLabel("Médecin généraliste : ");
        medGen2 = new JTextField("    Médecin généraliste    ");
        medGen2.setForeground(Color.gray);

        validerImgIcon = new ImageIcon("src/Annexes/valider.png");

        valider = new JButton(validerImgIcon);
        valider.setContentAreaFilled(false);
        valider.setBorderPainted(false);

      
        panelpatient.add(patient);
        
        panelNom.add(nom);
        panelNom.add(nom2);
        
        panelNomM.add(nomM);
        panelNomM.add(nomM2);

        panelPrenom.add(prenom);
        panelPrenom.add(prenom2);
        
        panelAdresse.add(adresse);
        panelAdresse.add(adresse2);
        
        panelSexe.add(sexe);
        panelSexe.add(choix);
        
        panelDateN.add(dateN);
        panelDateN.add(jourN);
        panelDateN.add(slashN);
        panelDateN.add(moisN);
        panelDateN.add(slashN2);
        panelDateN.add(anneeN);
        
        panelAdresseN.add(adresseN);
        panelAdresseN.add(adresseN2);
        
        panelLoc.add(loc);
        panelLoc.add(loc2);

        panelMedGen.add(medGen);
        panelMedGen.add(medGen2);
        
        title2 = BorderFactory.createTitledBorder("");
        jPanel2.setBorder(title2);

              
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy=0;
        gbc.insets= new Insets(0,15,0,15);
        jPanel2.add(patient, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(0, 15, 0, 15);
        jPanel2.add(panelNom, gbc);
        
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 15, 0, 15);
        jPanel2.add(panelNomM, gbc);

        gbc.gridy = 3;
        gbc.insets = new Insets(0, 15, 0, 15);
        jPanel2.add(panelPrenom, gbc);
        
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 15, 0, 15);
        jPanel2.add(panelAdresse, gbc);
        
        gbc.gridy = 5;
        gbc.insets = new Insets(0, 15, 0, 15);
        jPanel2.add(panelSexe, gbc);

        gbc.gridy = 6;
        gbc.insets = new Insets(0, 15, 0, 15);
        gbc.anchor = GridBagConstraints.WEST;
        jPanel2.add(panelDateN, gbc);
        
        gbc.gridy = 7;
        gbc.insets = new Insets(0, 15, 0, 15);
        jPanel2.add(panelAdresseN, gbc);
        
        gbc.gridy = 8;
        gbc.insets = new Insets(0, 15, 0, 15);
        jPanel2.add(panelLoc, gbc);
        
        gbc.gridy = 9;
        gbc.insets = new Insets(0, 15, 0, 15);
        jPanel2.add(panelMedGen, gbc);

        gbc.gridy = 10;
        gbc.insets = new Insets(0, 15, 15, 15);
        gbc.anchor = GridBagConstraints.CENTER;
        jPanel2.add(valider, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(13, 15, 15, 15);
        

        jPanel4.add(jPanel2, gbc);
        jPanel3.add(jPanel4);

        ajouterPat.add(jPanel3, BorderLayout.CENTER); // On ajoute le panel final au centre de la fenÃªtre
        panelpatient.setBackground(LIGHT_BLUE2);
        panelAdresse.setBackground(LIGHT_BLUE);
        panelSexe.setBackground(LIGHT_BLUE);
        panelDateN.setBackground(LIGHT_BLUE);
        panelAdresseN.setBackground(LIGHT_BLUE);
        panelLoc.setBackground(LIGHT_BLUE);
        panelMedGen.setBackground(LIGHT_BLUE);
        jPanel3.setBackground(LIGHT_BLUE2);
        jPanel2.setBackground(LIGHT_BLUE);
        jPanel4.setBackground(LIGHT_BLUE);


        panelNom.setOpaque(false);
        panelNomM.setOpaque(false);
        panelPrenom.setOpaque(false);
        panelAdresse.setOpaque(false);
        panelAdresseN.setOpaque(false);
        panelSexe.setOpaque(false);
        panelDateN.setOpaque(false);
        panelAdresseN.setOpaque(false);
        panelLoc.setOpaque(false);
        
    }

    public JFrame getAjouterPat() {
        return ajouterPat;
    }

    public void setAjouterPat(JFrame ajouterPat) {
        this.ajouterPat = ajouterPat;
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

    public JPanel getPanelNom() {
        return panelNom;
    }

    public void setPanelNom(JPanel panelNom) {
        this.panelNom = panelNom;
    }

    public JPanel getPanelPrenom() {
        return panelPrenom;
    }

    public void setPanelPrenom(JPanel panelPrenom) {
        this.panelPrenom = panelPrenom;
    }

    public JPanel getPanelSexe() {
        return panelSexe;
    }

    public void setPanelSexe(JPanel panelSexe) {
        this.panelSexe = panelSexe;
    }

    public JPanel getPanelAdresse() {
        return panelAdresse;
    }

    public void setPanelAdresse(JPanel panelAdresse) {
        this.panelAdresse = panelAdresse;
    }

    public JPanel getPanelDateN() {
        return panelDateN;
    }

    public void setPanelDateN(JPanel panelDateN) {
        this.panelDateN = panelDateN;
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

    public JLabel getPatient() {
        return patient;
    }

    public void setPatient(JLabel patient) {
        this.patient = patient;
    }

    public JPanel getPanelpatient() {
        return panelpatient;
    }

    public void setPanelpatient(JPanel panelpatient) {
        this.panelpatient = panelpatient;
    }

    public JPanel getPanelNomM() {
        return panelNomM;
    }

    public void setPanelNomM(JPanel panelNomM) {
        this.panelNomM = panelNomM;
    }

    public JPanel getPanelAdresseN() {
        return panelAdresseN;
    }

    public void setPanelAdresseN(JPanel panelAdresseN) {
        this.panelAdresseN = panelAdresseN;
    }

    public JPanel getPanelLoc() {
        return panelLoc;
    }

    public void setPanelLoc(JPanel panelLoc) {
        this.panelLoc = panelLoc;
    }

    public JPanel getPanelMedGen() {
        return panelMedGen;
    }

    public void setPanelMedGen(JPanel panelMedGen) {
        this.panelMedGen = panelMedGen;
    }

    public JLabel getNom() {
        return nom;
    }

    public void setNom(JLabel nom) {
        this.nom = nom;
    }

    public JTextField getNom2() {
        return nom2;
    }

    public void setNom2(JTextField nom2) {
        this.nom2 = nom2;
    }

    public JLabel getNomM() {
        return nomM;
    }

    public void setNomM(JLabel nomM) {
        this.nomM = nomM;
    }

    public JTextField getNomM2() {
        return nomM2;
    }

    public void setNomM2(JTextField nomM2) {
        this.nomM2 = nomM2;
    }

    public JLabel getPrenom() {
        return prenom;
    }

    public void setPrenom(JLabel prenom) {
        this.prenom = prenom;
    }

    public JTextField getPrenom2() {
        return prenom2;
    }

    public void setPrenom2(JTextField prenom2) {
        this.prenom2 = prenom2;
    }

    public JLabel getSexe() {
        return sexe;
    }

    public void setSexe(JLabel sexe) {
        this.sexe = sexe;
    }

    public JComboBox getChoix() {
        return choix;
    }

    public void setChoix(JComboBox choix) {
        this.choix = choix;
    }

    public Vector<String> getS() {
        return S;
    }

    public void setS(Vector<String> S) {
        this.S = S;
    }

    public JLabel getAdresse() {
        return adresse;
    }

    public void setAdresse(JLabel adresse) {
        this.adresse = adresse;
    }

    public JTextField getAdresse2() {
        return adresse2;
    }

    public void setAdresse2(JTextField adresse2) {
        this.adresse2 = adresse2;
    }

    public JLabel getDateN() {
        return dateN;
    }

    public void setDateN(JLabel dateN) {
        this.dateN = dateN;
    }

    public JTextField getJourN() {
        return jourN;
    }

    public void setJourN(JTextField jourN) {
        this.jourN = jourN;
    }

    public JLabel getSlashN() {
        return slashN;
    }

    public void setSlashN(JLabel slashN) {
        this.slashN = slashN;
    }

    public JTextField getMoisN() {
        return moisN;
    }

    public void setMoisN(JTextField moisN) {
        this.moisN = moisN;
    }

    public JLabel getSlashN2() {
        return slashN2;
    }

    public void setSlashN2(JLabel slashN2) {
        this.slashN2 = slashN2;
    }

    public JTextField getAnneeN() {
        return anneeN;
    }

    public void setAnneeN(JTextField anneeN) {
        this.anneeN = anneeN;
    }

    public JLabel getAdresseN() {
        return adresseN;
    }

    public void setAdresseN(JLabel adresseN) {
        this.adresseN = adresseN;
    }

    public JTextField getAdresseN2() {
        return adresseN2;
    }

    public void setAdresseN2(JTextField adresseN2) {
        this.adresseN2 = adresseN2;
    }

    public JLabel getLoc() {
        return loc;
    }

    public void setLoc(JLabel loc) {
        this.loc = loc;
    }

    public JTextField getLoc2() {
        return loc2;
    }

    public void setLoc2(JTextField loc2) {
        this.loc2 = loc2;
    }

    public JLabel getMedGen() {
        return medGen;
    }

    public void setMedGen(JLabel medGen) {
        this.medGen = medGen;
    }

    public JTextField getMedGen2() {
        return medGen2;
    }

    public void setMedGen2(JTextField medGen2) {
        this.medGen2 = medGen2;
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


