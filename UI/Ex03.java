/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Un troisieme exercice destiné à utiliser le <code>GridBagLayout</code>.
 * Objectif: faire une mini pyramide de boutons. Entre la premiere et la seconde
 * rangée de bouton, une marge de 10 pixels doit être ajoutée.
 * <p/>
 * Si vous tombé par hasard sur ce code, sachez que vous pouvez trouver le
 * tutoriel l'accompagnant sur
 * <a href="http://bbclone.developpez.com">Ma page perso</a>.
 * <p/>
 * Attention: Le code a été réalisé en utilisant Java 6. Vous en aurez besoin si
 * vous voulez compiler les codes sources par vous-même.
 *
 * @author bebe (bbclone@gmail.com).
 */
public class Ex03 {
        

    private JPanel getContent() {
        JTextField textField = new JTextField(12);
        JButton button = new JButton("button");
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.weightx = 1.0;
        panel.add(new JLabel(""), gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(textField, gbc);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(button, gbc);
        return panel;
    }

  

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new Ex03().getContent());
        f.setSize(400,200);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
                           }
        });
    }
}
