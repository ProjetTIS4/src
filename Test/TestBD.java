/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author lenal
 */
import java.sql.*;

public class TestBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        try 
  {
      String url = "jdbc:mysql://hugofarcy.ddns.net:3306/SIH?autoReconnect=true&useSSL=false";
      String user = "DEV";
      String password = "SIH-mmlh2022";
    
      Connection con = DriverManager.getConnection(url, user, password);
    
      String query = "SELECT * FROM SA";
      Statement stm = con.createStatement();
      ResultSet res = stm.executeQuery(query);
      
      String data[][] = new String[8][4];
    
      int i = 0;
      while (res.next()) {
        String id = res.getString("nom");
        String nom = res.getString("prenom");
        String age = res.getString("ID");
        String mdp = res.getString("mdp");
        data[i][0] = id + "";
        data[i][1] = nom;
        data[i][2] = age;
        data[i][3] = mdp;
        i++;
      }
      
      System.out.println(data.length);
      
      
      System.out.println(data[1][2]);
    }
        catch(SQLException e) {
      e.printStackTrace();
    }
  }
    
}
