/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

/**
 *
 * @author lenal
 */
public class Service{

 public enum NomService {
        ANESTHESIOLOGIE,
        CARDIOLOGIE,
        DERMATOLOGIE,
        GERONTOLOGIE,
        GYNECOLOGIE,
        HEMATOLOGIE,
        NEUROLOGIE,
        PEDIATRIE,
        RADIOLOGIE,
        UROLOGIE,
        ONCOLOGIE,
        MEDECINE,
        CHIRURGIE,
        URGENCES,
        PNEUMOLOGIE,
        OBSTETRIE,
        LaboratoireAnalyse,
        GASTROENTEROLOGIE;

    }

public nomService getNomService(String service){
        String txt=service;
        Service servicef=null;
        for(Service s : Service.values()){
            if (s.name().equals(txt)){
                servicef=s;
            }
        }        
        return servicef;
    }


}