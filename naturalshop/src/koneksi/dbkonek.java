    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import com.mysql.jdbc.Connection;
import form.login;
import form.menu;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static koneksi.Koneksi.conn;
/**
 *
 * @author Asus
 */
public class dbkonek {
    
    Connection con;
    PreparedStatement pst;
    Statement st;
    ResultSet rs, rst;
    
    public dbkonek(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/natural_shop", "root", "");
            System.out.println("Sukses!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(dbkonek.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public ResultSet selectDB(){
        try {
            String sql = "SELECT * FROM `barang`";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return rs;
    } 
    
    public void edit(String kdbarang, String nmbarang, int hrgbeli, int hrgjual, int stok){
        try {
            String query = "UPDATE `barang` SET `nama_barang` = ?, `harga_jual` = ?, `harga_beli` = ?, `stok` = ? WHERE `barang`.`kode_barang` = ?;";
            pst = conn.prepareStatement(query);
            pst.setString(5, kdbarang);
            pst.setString(1, nmbarang);
            pst.setInt(3, hrgbeli);
            pst.setInt(2, hrgjual);
            pst.setInt(4, stok);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public ResultSet getNameAdmin(String nmadmin){
        try {
            String query = "SELECT nama_depan FROM `penjual` WHERE username = ?";
            pst = conn.prepareStatement(query);
            pst.setString(1, nmadmin);
            rst = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(dbkonek.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rst;
    }
    
    public ResultSet getDtlBarang(String kdbarang){
        try {
            String query = "SELECT * FROM `barang` WHERE kode_barang = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, kdbarang);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return rs;
    }
    
    public ResultSet getDtlBarangnm(String nmbarang){
        try {
            String query = "SELECT * FROM `barang` WHERE nama_barang = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, nmbarang);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return rs;
    }
   
    public void stok(String kdbarang, int sisa){
        try {
        String query = "UPDATE `barang` SET `stok` = ? WHERE `barang`.`kode_barang` = ?";
            pst = con.prepareStatement(query);
            pst.setString(2, kdbarang);
            pst.setInt(1, sisa);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    
    public void insertpj(String nofaktur, String kodebarang, int jumlah, int subtotal){
        try {
            String query = "insert into penjualan values (NULL,?,?,?,?)";
            pst = con.prepareStatement(query);
            pst.setString(1, nofaktur);
            pst.setString(2, kodebarang);
            pst.setInt(3, jumlah);
            pst.setInt(4, subtotal);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void insertdpj(String nofaktur, String username, int total, int uang, int kembalian, String tanggal, String time){
        try {
            String query = "INSERT INTO `dtl_penjualan` (`no_faktur`, `username`, `tot_harga`, `uang`, `kembalian`, `tanggal`, `datetime`) VALUES (?,?,?,?,?,?,?);";
            pst = con.prepareStatement(query);
            pst.setString(1, nofaktur);
            pst.setString(2, username);
            pst.setInt(3, total);
            pst.setInt(4, uang);
            pst.setInt(5, kembalian);
            pst.setString(6, tanggal);
            pst.setString(7, time);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void insertdpb(String nobeli, String username, String kdsupplier, int total, String tanggal, String time){
        try {
            String query = "INSERT INTO `dtl_pembelian` (`no_beli`, `username`, `kode_supplier`,`tot_harga`, `tanggal`, `datetime`) VALUES (?,?,?,?,?,?);";
            pst = con.prepareStatement(query);
            pst.setString(1, nobeli);
            pst.setString(2, username);
            pst.setString(3, kdsupplier);
            pst.setInt(4, total);
            pst.setString(5, tanggal);
            pst.setString(6, time);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void insertpb(String nobeli, String kdbarang, int jumlah, int subtotal){
        try {
            String query = "insert into pembelian values (NULL,?,?,?,?)";
            pst = con.prepareStatement(query);
            pst.setString(1, nobeli);
            pst.setString(2, kdbarang);
            pst.setInt(3, jumlah);
            pst.setInt(4, subtotal);
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public ResultSet supplier(String kdsupplier){
        try {
            String query = "SELECT * FROM `supplier` WHERE kode_supplier = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, kdsupplier);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(dbkonek.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public void insertbrg(String kdbarang, String nmbarang, int hargabeli, int hargajual, int stok){
        try {
            String sql = "INSERT INTO barang(kode_barang,nama_barang,harga_beli,harga_jual, stok)VALUES (?,?,?,?,?)";
            pst = con.prepareStatement (sql);
            pst.setString (1, kdbarang);
            pst.setString (2, nmbarang);
            pst.setInt (3, hargabeli);
            pst.setInt (4, hargajual);
            pst.setInt (5, stok);
            //eksekusi statement sql
            pst.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    
    }
    
}
