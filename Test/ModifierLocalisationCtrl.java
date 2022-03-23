/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import NF.Hash;
import NF.Personnel;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenal
 */
public class ModifierLocalisationCtrl implements Runnable {
    
    
    private ModifierLocalisationGUI a;
    private String ipp;
    private AccueilGUI ac;
    private AccueilCtrl acc;

    private String loc;

    public ModifierLocalisationCtrl(String ipp, AccueilGUI ac, AccueilCtrl acc, String loc) {
        a = new ModifierLocalisationGUI();
        this.ipp = ipp;
        this.ac = ac;
        this.loc=loc;
        this.acc=acc;

    }

    @Override
    public void run() {
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

        //////////////////////// Fenêtre ////////////////////////
        // a.getAjouterActe().setBounds(450, 190, 700, 460);
        a.getModifierLoc().setVisible(true);
        a.getModifierLoc().setSize(500, 700);

        //////////////////////// Panel Ancienne loc ////////////////////////
        a.getAncienneLocInfo().setText(loc);
         a.getAncienneLocInfo().setSize(600, 28);
       
        //////////////////////// Panel Nouvelle Loc ////////////////////////
              //a.getNouvelleLocInfo().setSize(28, 800);
              
              a.getNouvelleLocInfo().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                a.getNouvelleLocInfo().setText("");
                a.getNouvelleLocInfo().setSize(600, 28);
                a.getNouvelleLocInfo().setForeground(Color.black);
            }
        });
        //////////////////////// Bouton valider  ////////////////////////
        a.getValider().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                try {
                  
                    String url = "jdbc:mysql://hugofarcy.ddns.net:3306/SIH?autoReconnect=true&useSSL=false";
                    String user = "DEV";
                    String password = "SIH-mmlh2022";

                    Connection con = DriverManager.getConnection(url, user, password);

                     String requete = "UPDATE patient SET localisation ='" + a.getNouvelleLocInfo().getText() + "' WHERE IPP='" + ipp+"'";
 
                        System.out.println(requete);
                        Statement stm = con.createStatement();
                        stm.executeUpdate(requete);

                    a.getModifierLoc().dispose();

                    
                    acc.MAJTableauPatient();
                    
                    ac.getAccueil().validate();
                    ac.getAccueil().repaint();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });

    }
    
}
