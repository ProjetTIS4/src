/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;


import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author lenal
 */
public class ActeCtrl implements Runnable {

    ActeGUI a;

    public ActeCtrl() {
        a = new ActeGUI();
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
        a.getAjouterActe().setDefaultCloseOperation(EXIT_ON_CLOSE);
       // a.getAjouterActe().setBounds(450, 190, 700, 460);
        a.getAjouterActe().setVisible(true);
       a.getAjouterActe().setSize(480, 600);

        //////////////////////// Panel Date ////////////////////////
        a.getJour().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                a.getJour().setText("");
                a.getJour().setForeground(Color.black);
            }
        });

        a.getJour().addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                if (a.getJour().getText().length() >= 2) // limit to 3 characters
                {
                    e.consume();
                }
            }
        });

        a.getMois().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                a.getMois().setText("");
                a.getMois().setForeground(Color.black);
            }
        });

        a.getMois().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (a.getMois().getText().length() >= 2) // limit to 3 characters
                {
                    e.consume();
                }
            }
        });

        a.getAnnee().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                a.getAnnee().setText("");
                a.getAnnee().setForeground(Color.black);
            }
        });

        a.getAnnee().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (a.getAnnee().getText().length() >= 4) // limit to 3 characters
                {
                    e.consume();
                }
            }
        });

        //////////////////////// Panel heure ////////////////////////
        a.getHeure().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                a.getHeure().setText("");
            }
        });

        a.getHeure().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (a.getHeure().getText().length() >= 2) // limit to 3 characters
                {
                    e.consume();
                }
            }
        });

        a.getMinute().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                a.getMinute().setText("");

            }
        });

        a.getMinute().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (a.getMinute().getText().length() >= 2) // limit to 3 characters
                {
                    e.consume();
                }
            }
        });

        //////////////////////// Observations  ////////////////////////
    }

}
