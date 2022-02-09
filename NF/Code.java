/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

/**
 *
 * @author manon
 */

    // Cette enumeration fait intervenir des valeurs qui possedent des
// attributs ('libelle' et 'cout') qui sont initialises par un appel du
// constructeur (arguments entre parentheses apres le nom de chaque valeur).
// Par exemple, la valeur Code.FP a un attribut 'libelle' contenant la chaine
// de caracteres "forfait pediatrique" et un attribut 'cout' ayant la valeur 5.0
enum Code {
    // valeurs de l'ï¿½num :
    CS("consultation au cabinet", 23.0),
    CSC("consultation cardiologie", 45.73),
    FP("forfait pediatrique", 5.0),
    KC("actes de chirurgie et de specialite", 2.09),
    KE("actes d'echographie, de doppler", 1.89),
    K("autres actes de specialite", 1.92),
    KFA("forfait A", 30.49),
    KFB("forfait B", 60.98),
    ORT("orthodontie", 2.15),
    PRO("prothese dentaire", 2.15),
    CCP("Consultation contraception et prevention", 34.30),
    COE("Consultation obligatoire de l'enfant", 50.50),
    CNPSY("Consultation neurophychiatrique/neurologique", 52.80),
    CDE("Consultation dermathologie", 48.50);

    // attributs de l'ï¿½num :
    private String libelle;
    private double cout;

    // constructeur :
    private Code(String libelle, double cout) {
        this.libelle = libelle;
        this.cout = cout;
    }

    // mï¿½thodes :
//    public String toString() { //afiche nom exam
//        return super.toString() + " : " +  this.libelle /*+ ", cout=" + cout + " euros"*/;
//    }
    public String afficherLibelle(){
        return this.libelle;
    }
    
    public String afficherCode(){
        return super.toString();
    }
    

    // calcule le prix pour un coefficient donne :
    public double calculerCout(int coefficient) {
        return coefficient * cout;
    }
//
//    public String getCode() {
//        return super.toString();
//    }
}
