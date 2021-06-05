/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapotik;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class ProjectApotik {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    protected String encryptPassMD5(String password){
            
        String vpass, vmd5;
        vmd5 = null;

        vpass = password;

        String encryptPass = null;

        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(vpass.getBytes(),0,vpass.length());
            encryptPass = new BigInteger(1, digest.digest()).toString(16);
            vmd5 = encryptPass.toUpperCase();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return vmd5;
    }
    
    protected static Connection conn;
    
    protected static Connection ConnectDB(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/dbapotik";
            String user = "root";
            String pass = "";
            
            conn = DriverManager.getConnection(url, user, pass);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal" + e.getMessage());
            System.exit(0);
        }
        
        return conn;
    }
    
}
