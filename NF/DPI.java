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
    private DMA dma;
    private DM dm;

    public DPI(Patient patient) {
        this.patient = patient;
        dm=null;
        dma=null;

    }

    public Patient getPatient() {
        return patient;
    }

    public DM getDm() {
        return dm;
    }

    public DMA getDma() {
        return dma;
    }

    
    public void addDMA(Personnel ph, Date date){
        if(dma==null){
            this.dma=new DMA(patient);
        }
        
    }
    
    public void addDM(){
        if(dm==null){
            this.dm=new DM(patient);
        }
    }
    
}
