/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import NF.Patient;
import NF.Patient.Sexe;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Date;
import java.util.Vector;
import javax.swing.border.AbstractBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenal
 */

class RoundedCornerBorder extends AbstractBorder {

        
    private static final Color LIGHT_BLUE2 = new Color(100, 180, 200,50);
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Shape border = getBorderShape(x, y, width - 1, height - 1);
           g2.setPaint(LIGHT_BLUE2);
            Area corner = new Area(new Rectangle2D.Double(x, y, width, height));
            corner.subtract(new Area(border));
            g2.fill(corner);
           g2.setPaint(Color.GRAY);
            g2.draw(border);
            g2.dispose();
        }

        public Shape getBorderShape(int x, int y, int w, int h) {
            int r = h; //h / 2;
            return new RoundRectangle2D.Double(x, y, w, h, r, r);
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(4, 8, 4, 8);
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.set(4, 8, 4, 8);
            return insets;
        }
    }

