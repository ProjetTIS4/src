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
public class Service {

    private String tel;
    private String localisation;
    private String email;
    private NomService nom;

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

public NomService getNomService(String service){
        String txt=service;
        NomService servicef=null;
        for(NomService s : NomService.values()){
            if (s.name().equals(txt)){
                servicef=s;
            }
        }        
        return servicef;
    }

    public Service(String tel, String localisation, String mail, NomService nom) {
        this.tel = tel;
        this.localisation = localisation;
        this.nom = nom;
        this.email = email;
    }

    public NomService getSpe() {
        return this.nom;
    }

    public String getLoc() {
        return this.localisation;
    }

    public String getEmail() {
        return this.email;
    }

    public String getTel() {
        return this.tel;
    }

    public void setSpe(NomService spe) {
        this.nom = spe;
    }

    public void setLoc(String loc) {
        this.localisation = loc;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}
