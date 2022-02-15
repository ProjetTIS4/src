/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.awt.Color;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lenal
 */
public class ModelTableauDM extends AbstractTableModel {

    private final Object[][] donnees;

    private final String[] entetes = {"Date", "Heure", "CR", "Lettre sortie"};

    public ModelTableauDM() {
        super();

        donnees = new Object[][]{
            {"22/10/2001", "16h30", "VIDE", true},
            
        };
    }

    public int getRowCount() {
        return donnees.length;
    }

    public int getColumnCount() {
        return entetes.length;
    }

    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return donnees[rowIndex][columnIndex];
    }
}
