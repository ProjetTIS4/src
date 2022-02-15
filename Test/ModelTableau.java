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
public class ModelTableau extends AbstractTableModel {
    
 private final Object[][] donnees;
 
    private final String[] entetes = {"IPP","Prénom", "Nom", "Date de Naissance", "Sexe"};
 
    public ModelTableau() {
        
        super();
 
        donnees = new Object[][]{
                {"1","Johnathan", "Sykes", "23/08", true},
                {"2","Nicolas", "Van de Kampf", Color.black, true},
                {"3","Damien", "Cuthbert", Color.cyan, true},
                {"4","Corinne", "Valance", Color.blue, false},
                {"5","Emilie", "Schrödinger", Color.magenta, false},
                {"6","Delphine", "Duke", Color.yellow, false},
                {"7","Eric", "Trump", Color.pink, true},
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
