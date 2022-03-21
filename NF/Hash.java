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
import java.security.MessageDigest;

public class Hash
        
        {
    
    
    public String expect(String s){
       
    
     s = s.replace("'", "\\'");
     System.out.println(s);
     return s;
    }
    
    
    
    public static void main(String[] args)throws Exception
    {
//     String password = "123456789";
//     String password2 = "gbois";
//
//        MessageDigest md = MessageDigest.getInstance("SHA-256");
//        md.update(password.getBytes());
//        md.update(password2.getBytes());
//
//        byte byteData[] = md.digest();
//
//        //convertir le tableau de bits en une format hexadécimal - méthode 1
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < byteData.length; i++) {
//         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
//        }
//
//        System.out.println("En format hexa : " + sb.toString());
//
//        
//        
//        
//        
//        //convertir le tableau de bits en une format hexadécimal - méthode 2
//        StringBuffer hexString = new StringBuffer();
//     for (int i=0;i<byteData.length;i++) {
//      String hex=Integer.toHexString(0xff & byteData[i]);
//          if(hex.length()==1) hexString.append('0');
//          hexString.append(hex);
//     }
//     System.out.println("En format hexa : " + hexString.toString());
     Hash h= new Hash();
     h.expect("Je suis vraiment fou. J'ai rêvé que j'avais une poule dans les cheveux. ");
    }
}