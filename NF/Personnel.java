
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

import NF.Service.NomService;

/**
 *
 * @author lenal
 */
/**
 * Création d'un medecin. Hérite de Personne.
 */
public class Personnel extends Personne {

    private NomService service;
    private Poste poste;
    private String mdp; // à envoyer dans la BDD
    private String login;

    public enum Poste {
        SecretaireMedicale,
        PHAnesthesiste,
        PHService,
        PHMedicoTechnique,
        Interne,
        Infirmier,
        AideSoignante,
        SecretaireAdministrative,
        Pharmacien;

    }
    
    


    public Personnel(String nom, String prenom, String service, String poste, String login, String mdp) {
        super(nom, prenom);
        setNomServiceString(service);
        this.mdp = mdp; // A envoyer dans la BDD
        this.login = login; // A envoyer dans la BDD
        setPoste(poste);

    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public NomService getNomService() {

        return service;
    }

    public void setNomService(NomService service) {
        this.service = service;
    }
    
        public void setNomServiceString(String service) {
          for(NomService s : NomService.values()){
            if (s.name().equals(service.toUpperCase())){
                this.service=s;
            }
    }}

    public String toString() {
        return "Dr " + getPrenom() + " " + getNom() + ", " + getNomService().toString();
    }

    public boolean equals(Object o) {
        if (o instanceof Personnel) {
            Personnel p = (Personnel) o;
            return getNom().equals(p.getNom()) && getPrenom().equals(p.getPrenom());
        } else {
            return false;
        }
    }
    
    public void setPoste(String poste){
      //  String txt=poste.toUpperCase();
 
        for(Poste p : Poste.values()){
            if (p.name().equals(poste)){
                this.poste=p;
            }
        }        
     
    }

}

