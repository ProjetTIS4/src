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
    ANAPATHOLOGIE,
    CARDIOLOGIE,
    CHIRURGIE,
    DERMATOLOGIE,
    GASTROENTEROLOGIE,
    GERONTOLOGIE,
    GYNECOLOGIE,
    HEMATOLOGIE,
    LaboratoireAnalyse,
    MEDECINE,
    NEUROLOGIE,
    OBSTETRIE,
    ONCOLOGIE,
    PEDIATRIE,
    PNEUMOLOGIE,
    RADIOLOGIE,
    UROLOGIE,
    URGENCES;
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
