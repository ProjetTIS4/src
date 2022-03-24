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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author lenal
 */
public class ModifierLocalisationGUI {

    private JFrame modifierLoc;

    private static final Color LIGHT_BLUE2 = new Color(225, 248, 255);
    private static final Color LIGHT_BLUE = new Color(100, 180, 200);
    private TitledBorder title2;
    private GridBagConstraints gbc;

    private JPanel panelAncienneLoc;
    private JPanel panelNouvelleLoc;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;

    ////////////Panel Date ///////////////
    private JLabel ancienneLoc;
    private JTextField ancienneLocInfo;

    ////////////Panel Heure ///////////////
    private JLabel nouvelleLoc;
    private JTextField nouvelleLocInfo;

    ////////////Bouton Valider ///////////////
    private JButton valider;
    private ImageIcon validerImgIcon;

    /**
     *
     */
    public ModifierLocalisationGUI() {
        modifierLoc = new JFrame("Modification de la localisation");
        Image icone = Toolkit.getDefaultToolkit().getImage("src/Annexes/Hubspital_logo_grand.png");
        modifierLoc.setIconImage(icone);
        modifierLoc.setMinimumSize(new Dimension(500, 700));
//        ajouterActe.setPreferredSize(new Dimension(300, 100));

        panelAncienneLoc = new JPanel(new FlowLayout());
        panelNouvelleLoc = new JPanel(new FlowLayout());
        jPanel2 = new JPanel(new GridBagLayout());
        jPanel3 = new JPanel(new GridBagLayout());
        jPanel4 = new JPanel(new GridBagLayout());

        ancienneLoc = new JLabel("Ancienne localisation : ");
        ancienneLocInfo = new JTextField("   ");
         //ancienneLocInfo.setForeground(Color.white); 

        nouvelleLoc = new JLabel("Nouvelle localisation : ");
        nouvelleLocInfo = new JTextField("2208Fpediatrie");
        nouvelleLocInfo.setSize(500, 28);
        nouvelleLocInfo.setForeground(Color.white); 

        validerImgIcon = new ImageIcon("src/Annexes/valider.png");

        valider = new JButton(validerImgIcon);
        valider.setContentAreaFilled(false);
        valider.setBorderPainted(false);

        panelAncienneLoc.add(ancienneLoc);
        panelAncienneLoc.add(ancienneLocInfo);

        panelNouvelleLoc.add(nouvelleLoc);
        panelNouvelleLoc.add(nouvelleLocInfo);

        title2 = BorderFactory.createTitledBorder("");
        jPanel2.setBorder(title2);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(15, 15, 0, 15);
        gbc.anchor = GridBagConstraints.WEST;
        jPanel2.add(panelAncienneLoc, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(0, 15, 0, 15);
        jPanel2.add(panelNouvelleLoc, gbc);

        gbc.gridy = 6;
        gbc.insets = new Insets(0, 15, 15, 15);
        gbc.anchor = GridBagConstraints.CENTER;
        jPanel2.add(valider, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(13, 15, 15, 15);

        jPanel4.add(jPanel2, gbc);
        jPanel3.add(jPanel4);

        modifierLoc.add(jPanel3, BorderLayout.CENTER); // On ajoute le panel final au centre de la fenêtre

        jPanel3.setBackground(LIGHT_BLUE2);
        jPanel2.setBackground(LIGHT_BLUE);
        jPanel4.setBackground(LIGHT_BLUE);

        panelAncienneLoc.setOpaque(false);
        panelNouvelleLoc.setOpaque(false);

    }

    /**
     *
     * @return
     */
    public JFrame getModifierLoc() {
        return modifierLoc;
    }

    /**
     *
     * @param modifierLoc
     */
    public void setModifierLoc(JFrame modifierLoc) {
        this.modifierLoc = modifierLoc;
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
    public JPanel getPanelAncienneLoc() {
        return panelAncienneLoc;
    }

    /**
     *
     * @param panelAncienneLoc
     */
    public void setPanelAncienneLoc(JPanel panelAncienneLoc) {
        this.panelAncienneLoc = panelAncienneLoc;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelNouvelleLoc() {
        return panelNouvelleLoc;
    }

    /**
     *
     * @param panelNouvelleLoc
     */
    public void setPanelNouvelleLoc(JPanel panelNouvelleLoc) {
        this.panelNouvelleLoc = panelNouvelleLoc;
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
    public JLabel getAncienneLoc() {
        return ancienneLoc;
    }

    /**
     *
     * @param ancienneLoc
     */
    public void setAncienneLoc(JLabel ancienneLoc) {
        this.ancienneLoc = ancienneLoc;
    }

    /**
     *
     * @return
     */
    public JTextField getAncienneLocInfo() {
        return ancienneLocInfo;
    }

    /**
     *
     * @param ancienneLocInfo
     */
    public void setAncienneLocInfo(JTextField ancienneLocInfo) {
        this.ancienneLocInfo = ancienneLocInfo;
    }

    /**
     *
     * @return
     */
    public JLabel getNouvelleLoc() {
        return nouvelleLoc;
    }

    /**
     *
     * @param nouvelleLoc
     */
    public void setNouvelleLoc(JLabel nouvelleLoc) {
        this.nouvelleLoc = nouvelleLoc;
    }

    /**
     *
     * @return
     */
    public JTextField getNouvelleLocInfo() {
        return nouvelleLocInfo;
    }

    /**
     *
     * @param nouvelleLocInfo
     */
    public void setNouvelleLocInfo(JTextField nouvelleLocInfo) {
        this.nouvelleLocInfo = nouvelleLocInfo;
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

}
