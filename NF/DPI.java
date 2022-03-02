/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

import java.util.Vector;

/**
 *
 * @author lenal
 */
public class DPI {

    private Patient patient;
    private Vector<DMA> dma;
    private Vector<DM> dm;

    public DPI(Patient patient) {
        this.patient = patient;
        dm=null;
        dma=null;

    }

    public Patient getPatient() {
        return patient;
    }

    public Vector<DM> getDm() {
        return dm;
    }

    public Vector<DMA> getDma() {
        return dma;
    }

    
    public void addDMA(Personnel ph, Date date){

            dma.add(new DMA(patient, date));
        }
        
    
    
    public void addDM(Date date){
            dm.add(new DM(patient, date));

    }
    
}
