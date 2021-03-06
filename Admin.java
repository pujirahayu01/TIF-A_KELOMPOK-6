/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formku;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Admin extends javax.swing.JFrame {
    //memanggil koneksi
    private Connection conn;
    private DefaultTableModel ModelTblAdmin;
    
    public void kode_admin_otomatis(){
    try{
    
    Statement stat = conn.createStatement();
    ResultSet rs = stat.executeQuery("SELECT * FROM penjual order by kode_penjual desc");
    if (rs.next()){
        String kode = rs.getString("kode_penjual").substring(1);
        String AN = "" + (Integer.parseInt(kode) + 1);
        String Nol = "";
        
        if(AN.length()==1)
        {Nol = "00";}
        else if(AN.length()==2)
        {Nol = "0";}
        else if (AN.length()==3)
        {Nol = "";}
        
        ID_admin.setText("P"+ Nol + AN);
        
    } else{
        ID_admin.setText("P001");
    }
    } catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
    }
   
    public void KosongkanForm(){
        Nm_depan.setText(null);
        Nm_Blkng.setText(null);
        Alamat.setText(null);
        Nmr_hp.setText(null);
        password.setText(null);
        
    }
    public Admin() {
        initComponents();
    conn = DBku.Koneksi.cekKoneksi();
    
    
    readDataAdmin();
    kode_admin_otomatis();
    KosongkanForm();
    
    }
    private void readDataAdmin(){
     DefaultTableModel TblAdmin = new DefaultTableModel();
     
    TblAdmin.addColumn("ID Admin");
    TblAdmin.addColumn("Nama Admin");
    TblAdmin.addColumn("Alamat");
    TblAdmin.addColumn("Nomor HP");
    TblAdmin.addColumn("Password");
    Tb_admin.setModel(TblAdmin);
    
     String cari = txtcari.getText();
        try{ 
            String sql = "SELECT * FROM penjual WHERE nama_depan LIKE'%" + cari +"%'";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            // untuk menampilkan datanya
            while(res.next()){
              Object[] o = new Object [5];
            o[0] = res.getString("kode_penjual");
            o[1] = res.getString("nama_depan") + " " + res.getString("nama_belakang");
            o[2] = res.getString("alamat");
            o[3] = res.getString("no_hp");
            o[4] = res.getString("pasword");
            TblAdmin.addRow(o);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Tidak ada data yang di input" + e.getMessage());
            
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Alamat = new javax.swing.JTextField();
        Nmr_hp = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Tmbh_data = new javax.swing.JButton();
        ID_admin = new javax.swing.JTextField();
        Nm_depan = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        Username = new javax.swing.JTextField();
        MNU = new javax.swing.JButton();
        LPRN = new javax.swing.JButton();
        LOGOUT = new javax.swing.JButton();
        Tentang_APL = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        Hapus = new javax.swing.JButton();
        Edit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tb_admin = new javax.swing.JTable();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        txtcari = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        Nm_Blkng = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        btn_clear = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        refresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

        jPanel3.setBackground(new java.awt.Color(33, 66, 99));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        jLabel1.setFont(new java.awt.Font("Bell MT", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADMIN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(422, 422, 422)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(775, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tmbh_data.setBackground(new java.awt.Color(33, 66, 99));
        Tmbh_data.setForeground(new java.awt.Color(255, 255, 255));
        Tmbh_data.setText("Tambah Data");
        Tmbh_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tmbh_dataActionPerformed(evt);
            }
        });

        ID_admin.setEnabled(false);
        ID_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_adminActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        MNU.setText("Menu Utama");
        MNU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MNUActionPerformed(evt);
            }
        });

        LPRN.setText("Laporan");

        LOGOUT.setText("Log Out");
        LOGOUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGOUTActionPerformed(evt);
            }
        });

        Tentang_APL.setText("Tentang Aplikasi");
        Tentang_APL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tentang_APLActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/foto/Hnet.com-image (3).png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MNU, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tentang_APL, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LPRN, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LOGOUT, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(MNU, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LPRN, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Tentang_APL, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LOGOUT, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Hapus.setBackground(new java.awt.Color(33, 66, 99));
        Hapus.setForeground(new java.awt.Color(255, 255, 255));
        Hapus.setText("Hapus Data");
        Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusActionPerformed(evt);
            }
        });

        Edit.setBackground(new java.awt.Color(33, 66, 99));
        Edit.setForeground(new java.awt.Color(255, 255, 255));
        Edit.setText("Edit Data");
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });

        Tb_admin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Tb_admin.setEnabled(false);
        Tb_admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tb_adminMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tb_admin);

        jTextField6.setBackground(new java.awt.Color(33, 66, 99));
        jTextField6.setFont(new java.awt.Font("Bodoni MT", 3, 18)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));
        jTextField6.setText("ID Admin");

        jTextField7.setBackground(new java.awt.Color(33, 66, 99));
        jTextField7.setFont(new java.awt.Font("Bodoni MT", 3, 18)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(255, 255, 255));
        jTextField7.setText("Nama Depan");

        jTextField8.setBackground(new java.awt.Color(33, 66, 99));
        jTextField8.setFont(new java.awt.Font("Bodoni MT", 3, 18)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(255, 255, 255));
        jTextField8.setText("Alamat");

        jTextField9.setBackground(new java.awt.Color(33, 66, 99));
        jTextField9.setFont(new java.awt.Font("Bodoni MT", 3, 18)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(255, 255, 255));
        jTextField9.setText("Nomor HP");

        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcariKeyReleased(evt);
            }
        });

        jTextField11.setBackground(new java.awt.Color(33, 66, 99));
        jTextField11.setFont(new java.awt.Font("Bodoni MT", 3, 18)); // NOI18N
        jTextField11.setForeground(new java.awt.Color(255, 255, 255));
        jTextField11.setText("Nama Belakang");

        jTextField12.setBackground(new java.awt.Color(33, 66, 99));
        jTextField12.setFont(new java.awt.Font("Bodoni MT", 3, 18)); // NOI18N
        jTextField12.setForeground(new java.awt.Color(255, 255, 255));
        jTextField12.setText("Password");

        btn_clear.setBackground(new java.awt.Color(33, 66, 99));
        btn_clear.setForeground(new java.awt.Color(255, 255, 255));
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(33, 66, 99));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(33, 66, 99));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cari Data");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(33, 66, 99)));

        refresh.setBackground(new java.awt.Color(33, 66, 99));
        refresh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        refresh.setForeground(new java.awt.Color(255, 255, 255));
        refresh.setText("Refresh");
        refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshMouseClicked(evt);
            }
        });
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField8)
                            .addComponent(jTextField11, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField9)
                            .addComponent(jTextField12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Nm_depan)
                            .addComponent(ID_admin)
                            .addComponent(Alamat)
                            .addComponent(Nmr_hp)
                            .addComponent(Nm_Blkng)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(Tmbh_data, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(Hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(321, 321, 321)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 259, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField6)
                            .addComponent(ID_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Nm_depan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nm_Blkng, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField8)
                            .addComponent(Alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Nmr_hp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Tmbh_data, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Tmbh_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tmbh_dataActionPerformed
        // TODO add your handling code here:
        String kode, namadepan, namabelakang,nmlengkap,alamat,nohp ,pass;
        kode = ID_admin.getText();
        namadepan = Nm_depan.getText();
        namabelakang = Nm_Blkng.getText();
        alamat = Alamat.getText();
        nohp = Nmr_hp.getText();
        pass = password.getText();
        
        try{
        //nama kolom harus sama dengan yang ada pada database
        String sql = "INSERT INTO penjual(kode_penjual, nama_depan, nama_belakang, alamat, no_hp, pasword)VALUES(?,?,?,?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, kode);
        pst.setString(2, namadepan);
        pst.setString(3, namabelakang);
        pst.setString(4, alamat);
        pst.setString(5, nohp);
        pst.setString(6, pass);
        
        //eksekusi statemnet sql
        pst.execute();    
        JOptionPane.showMessageDialog(null,"Data berhasil di tambahkan");
        KosongkanForm();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal di tambahkan!");
            System.out.println(e.getMessage());
           
        }
        String Nmdpn = String.valueOf(Nm_depan.getText());
        String NmBlkng = String.valueOf(Nm_Blkng.getText());
        String NmLengkap = Nmdpn + " " + NmBlkng;
        
        
    }//GEN-LAST:event_Tmbh_dataActionPerformed

    private void ID_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_adminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_adminActionPerformed

    private void HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "DELETE FROM penjual WHERE kode_penjual='" + ID_admin.getText()+"'";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil di hapus");
            
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, "Data gagal di hapus" + e.getMessage());
        }
        readDataAdmin();
        KosongkanForm();
    }//GEN-LAST:event_HapusActionPerformed

    private void MNUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MNUActionPerformed
        Menu menu = new Menu();
        menu.setVisible(true);
    }//GEN-LAST:event_MNUActionPerformed

    private void Tentang_APLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tentang_APLActionPerformed
        JOptionPane.showMessageDialog(null, " APLIKASI INI DI BUAT OLEH KELOMPOK 6" + "\n" +
                                            " Dibuat pada tahun 2021 oleh Mahasiswa Polije");
    }//GEN-LAST:event_Tentang_APLActionPerformed

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        try{
             String sql = "INSERT penjual set kode_penjual = '" + ID_admin.getText()+ "' ,nama_depan='"+Nm_depan.getText()
                                                            +"' ,nama_belakang='" + Nm_Blkng.getText()+"' ,alamat='" +Alamat.getText()
                                                            +"' ,no_hp='" + Nmr_hp.getText() + "' ,pasword='"+password.getText()
                                                            +"'On Duplicate Key Update kode_penjual ='"+ ID_admin.getText()+ "' ,nama_depan='"+Nm_depan.getText()
                                                            +"' ,nama_belakang='" + Nm_Blkng.getText()+"' ,alamat='" +Alamat.getText()
                                                            +"' ,no_hp='" + Nmr_hp.getText() + "' ,pasword='"+password.getText()+"'";
           
           
           java.sql.PreparedStatement pst = conn.prepareStatement(sql);
           pst.execute();
           JOptionPane.showMessageDialog(null, "Edit data telah berhasil");
           
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        readDataAdmin();
        KosongkanForm();
    }//GEN-LAST:event_EditActionPerformed

    private void Tb_adminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tb_adminMouseClicked
        // TODO add your handling code here:
      int baris = Tb_admin.rowAtPoint(evt.getPoint());
      
      String IDadmin = Tb_admin.getValueAt(baris,0).toString();
      ID_admin.setText(IDadmin);
      
      String[] namalengkp = Tb_admin.getValueAt(baris,1).toString().split(" ");
      Nm_depan.setText(namalengkp[0]);
      Nm_Blkng.setText(namalengkp[1]);
          
      String Almt = Tb_admin.getValueAt(baris, 2).toString();
      Alamat.setText(Almt);
      
      String nohp = Tb_admin.getValueAt(baris, 3).toString();
      Nmr_hp.setText(nohp);
      
      String pass = Tb_admin.getValueAt(baris, 4).toString();
      password.setText(pass);
      
    }//GEN-LAST:event_Tb_adminMouseClicked

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        KosongkanForm();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void txtcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyReleased
        // TODO add your handling code here:
        readDataAdmin();
    }//GEN-LAST:event_txtcariKeyReleased

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshActionPerformed

    private void refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)Tb_admin.getModel();
        model.setRowCount(0);
        readDataAdmin();
        
        
    }//GEN-LAST:event_refreshMouseClicked

    private void LOGOUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGOUTActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame ("Log Out");
        if(JOptionPane.showConfirmDialog(frame, "Yakin untuk KELUAR ?", "Log Out", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
        {
            System.exit(0);
        }    
    }//GEN-LAST:event_LOGOUTActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Alamat;
    private javax.swing.JButton Edit;
    private javax.swing.JButton Hapus;
    private javax.swing.JTextField ID_admin;
    private javax.swing.JButton LOGOUT;
    private javax.swing.JButton LPRN;
    private javax.swing.JButton MNU;
    private javax.swing.JTextField Nm_Blkng;
    private javax.swing.JTextField Nm_depan;
    private javax.swing.JTextField Nmr_hp;
    private javax.swing.JTable Tb_admin;
    private javax.swing.JButton Tentang_APL;
    private javax.swing.JButton Tmbh_data;
    private javax.swing.JTextField Username;
    private javax.swing.JButton btn_clear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField password;
    private javax.swing.JButton refresh;
    private javax.swing.JTextField txtcari;
    // End of variables declaration//GEN-END:variables
}
