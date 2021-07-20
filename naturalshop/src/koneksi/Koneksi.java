/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Koneksi {
    
    //variabel untuk menampung koneksi
    public static Connection conn;
    Statement st;
    ResultSet rs;
    PreparedStatement pst;
    
    //fungsi untuk melakukan cek koneksi
    public static Connection cekKoneksi(){
        if(conn == null){
        try {
            //register
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //isi variabel conn
            conn = DriverManager.getConnection("jdbc:mysql://localhost/natural_shop" , "root" , "");
            System.out.println("koneksi berhasil");
              
        } catch (SQLException e){
            System.out.println("koneksi gagal!");
            System.out.println(e.getMessage());
        }
        
        }
        return conn;
    }
    
    public static void main(String[] args){
        cekKoneksi();
    
    }
}
    

