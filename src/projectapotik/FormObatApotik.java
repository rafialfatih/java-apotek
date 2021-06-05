/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapotik;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet; // Menampung hasil query
import java.sql.SQLException; // Menangani error sql
import java.sql.Statement; // Menampung syntax SQL
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class FormObatApotik extends javax.swing.JFrame {
    
    ProjectApotik main = new ProjectApotik();
    Connection conn = main.ConnectDB();
    ResultSet rs = null;
    Statement stm;
    
    /**
     * Creates new form FormObatApotik
     */
    
    private void ClearData(){
        jTxtKode.setText("");
        jTxtNama.setText("");
        jTxtBeli.setText("");
        jTxtJual1.setText("");
        jTxtJual2.setText("");
        jTxtStok.setText("");
        jCmbSatuan.setSelectedIndex(0);
        jCmbKategori.setSelectedIndex(0);
        jCmbLokasi.setSelectedIndex(0);
    }
    
    public void CmbLokasi(){
        
        jCmbLokasi.addItem("- PILIH LOKASI -");
        
        try {
            String sql = "SELECT * FROM tblokasi";
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            
            while(rs.next()){
                jCmbLokasi.addItem(rs.getString("lokasi"));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
    public void CmbKategori(){
        
        jCmbKategori.addItem("- PILIH KATEGORI -");
        
        try {
            String sql = "SELECT * FROM tbkategoribarang";
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            
            while(rs.next()){
                jCmbKategori.addItem(rs.getString("kategori"));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void CmbSatuan(){
        
        jCmbSatuan.addItem("- PILIH ITEM -");
        
        try {
            String sql = "SELECT * FROM tbsatuan";
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            
            while(rs.next()){
                jCmbSatuan.addItem(rs.getString("satuan"));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void AmbilData(){
        int row, col;
        String kodeObat;
        
        col = 0;
        row = jTableObat.getSelectedRow();
        
        kodeObat = jTableObat.getModel().getValueAt(row, col).toString();
        
        try {
            String sql = "SELECT * FROM tbobat WHERE kodeobat = '" + kodeObat + "'";
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            
            String kode, nama, hargabeli, satuan, harga1, harga2, stok, namakategori, lokasi;
            
            while (rs.next()){
                kode = rs.getString("kodeobat");
                nama = rs.getString("namaobat");
                hargabeli = rs.getString("hargabeli");
                satuan = rs.getString("satuan");
                harga1 = rs.getString("harga1");
                harga2 = rs.getString("harga2");
                stok = rs.getString("stok");
                namakategori = rs.getString("namakategori");
                lokasi = rs.getString("lokasi");
                
                jTxtKode.setText(kode);
                jTxtNama.setText(nama);
                jTxtBeli.setText(hargabeli);
                jCmbSatuan.setSelectedItem(satuan);
                jTxtJual1.setText(harga1);
                jTxtJual2.setText(harga2);
                jTxtStok.setText(stok);
                jCmbKategori.setSelectedItem(namakategori);
                jCmbLokasi.setSelectedItem(lokasi);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
    }
    
    private void DisplayData(){
        
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("Kode Obat");
        model.addColumn("Nama Obat");
        model.addColumn("Harga Beli");
        model.addColumn("Harga Jual 1");
        model.addColumn("Harga Jual 2");
        model.addColumn("Stok");
        
        try{
            String sql = "SELECT * FROM tbobat ORDER BY KodeObat";
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            
            while(rs.next()){
                model.addRow(new Object[]{
                    rs.getString("kodeobat"),
                    rs.getString("namaobat"),
                    rs.getString("hargabeli"),
                    rs.getString("harga1"),
                    rs.getString("harga2"),
                    rs.getString("stok")
                });
            }
            
            jTableObat.setModel(model);
            
            jTableObat.setRowHeight(30);
            
            jTableObat.setFont(new Font("", 0, 20));
            jTableObat.getTableHeader().setFont(new Font("", 1, 18));
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public FormObatApotik() {
        initComponents();
        DisplayData();      
        CmbSatuan();
        CmbKategori();
        CmbLokasi();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTxtStok = new javax.swing.JTextField();
        jTxtKode = new javax.swing.JTextField();
        jTxtNama = new javax.swing.JTextField();
        jCmbSatuan = new javax.swing.JComboBox<>();
        jTxtBeli = new javax.swing.JTextField();
        jTxtJual1 = new javax.swing.JTextField();
        jTxtJual2 = new javax.swing.JTextField();
        jCmbKategori = new javax.swing.JComboBox<>();
        jCmbLokasi = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jOkSimpan = new javax.swing.JButton();
        jOkKeluar = new javax.swing.JButton();
        jOkUbah = new javax.swing.JButton();
        jOkHapus = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableObat = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Form Data Obat");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("Kode Obat");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setText("Nama Obat");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setText("Satuan");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setText("Harga Beli");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setText("Harga Jual 2");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel7.setText("Harga Jual 1");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel8.setText("Stok");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel9.setText("Kategori Obat");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("FORM DATA OBAT");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Form Ini Digunakan Untuk Input Data Obat");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 90));

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel11.setText("Lokasi Obat");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, -1, -1));

        jTxtStok.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        getContentPane().add(jTxtStok, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 130, -1));

        jTxtKode.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        getContentPane().add(jTxtKode, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 150, -1));

        jTxtNama.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        getContentPane().add(jTxtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 320, -1));

        jCmbSatuan.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        getContentPane().add(jCmbSatuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 260, -1));

        jTxtBeli.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        getContentPane().add(jTxtBeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 260, -1));

        jTxtJual1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        getContentPane().add(jTxtJual1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 260, -1));

        jTxtJual2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        getContentPane().add(jTxtJual2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 260, -1));

        jCmbKategori.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        getContentPane().add(jCmbKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, 260, -1));

        jCmbLokasi.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        getContentPane().add(jCmbLokasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 500, 260, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jOkSimpan.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jOkSimpan.setText("Simpan");
        jOkSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOkSimpanActionPerformed(evt);
            }
        });
        jPanel2.add(jOkSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, -1));

        jOkKeluar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jOkKeluar.setText("Keluar");
        jOkKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOkKeluarActionPerformed(evt);
            }
        });
        jPanel2.add(jOkKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 110, -1));

        jOkUbah.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jOkUbah.setText("Ubah");
        jOkUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOkUbahActionPerformed(evt);
            }
        });
        jPanel2.add(jOkUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 110, -1));

        jOkHapus.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jOkHapus.setText("Hapus");
        jOkHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOkHapusActionPerformed(evt);
            }
        });
        jPanel2.add(jOkHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 110, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 780, 80));

        jTableObat.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTableObat.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableObat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableObatMouseClicked(evt);
            }
        });
        jTableObat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableObatKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTableObat);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 830, 180));

        setSize(new java.awt.Dimension(848, 892));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jOkSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOkSimpanActionPerformed
        // TODO add your handling code here:
        try {
            String kodeobat, nama, beli, satuan, harga1, harga2, stok, namakategori, lokasi;
            
            kodeobat = jTxtKode.getText();
            nama = jTxtNama.getText();
            beli = jTxtBeli.getText();
            satuan = jCmbSatuan.getSelectedItem().toString();
            harga1 = jTxtJual1.getText();
            harga2 = jTxtJual2.getText();
            stok = jTxtStok.getText();
            namakategori = jCmbKategori.getSelectedItem().toString();
            lokasi = jCmbLokasi.getSelectedItem().toString();
            
            String sql = "INSERT INTO tbobat VALUES('" + kodeobat + "',"
                    + "'" + nama + "',"
                    + "'" + beli + "',"
                    + "'" + satuan + "',"
                    + "'" + harga1 + "',"
                    + "'" + harga2 + "',"
                    + "'" + stok + "',"
                    + "'" + namakategori + "',"
                    + "'" + lokasi + "')";
            
            stm = conn.createStatement();
            stm.executeUpdate(sql);
            DisplayData();
            stm.close();

            ClearData();
            
            JOptionPane.showMessageDialog(null, "Data Barang Berhasil Disimpan!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jOkSimpanActionPerformed

    private void jOkUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOkUbahActionPerformed
        // TODO add your handling code here:
        try {
            String kodeobat, nama, beli, satuan, harga1, harga2, stok, namakategori, lokasi;
            
            kodeobat = jTxtKode.getText();
            nama = jTxtNama.getText();
            beli = jTxtBeli.getText();
            satuan = jCmbSatuan.getSelectedItem().toString();
            harga1 = jTxtJual1.getText();
            harga2 = jTxtJual2.getText();
            stok = jTxtStok.getText();
            namakategori = jCmbKategori.getSelectedItem().toString();
            lokasi = jCmbLokasi.getSelectedItem().toString();
            
            if (jCmbSatuan.getSelectedIndex() != 0 && jCmbKategori.getSelectedIndex() != 0 && jCmbLokasi.getSelectedIndex() != 0) {
                String sql = "UPDATE tbobat SET kodeobat = '" + kodeobat + "',"
                        + "namaobat = '" + nama + "',"
                        + "hargabeli = '" + beli + "',"
                        + "satuan = '" + satuan + "',"
                        + "harga1 = '" + harga1 + "',"
                        + "harga2 = '" + harga2 + "',"
                        + "stok = '" + stok + "',"
                        + "namakategori = '" + namakategori + "',"
                        + "lokasi = '" + lokasi + "'"
                        + "WHERE kodeobat = '" + kodeobat + "'";

                stm = conn.createStatement();
                stm.executeUpdate(sql);
                DisplayData();
                stm.close();

                JOptionPane.showMessageDialog(null, "Data Berhasil Diubah!");

                ClearData();
            }else{
                JOptionPane.showMessageDialog(null, "Pilihan tidak valid!");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jOkUbahActionPerformed

    private void jTableObatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableObatMouseClicked
        // TODO add your handling code here:
        AmbilData();
    }//GEN-LAST:event_jTableObatMouseClicked

    private void jOkHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOkHapusActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "DELETE FROM tbobat WHERE kodeobat = '" + jTxtKode.getText() + "'";
            
            stm = conn.createStatement();
            stm.executeUpdate(sql);
            DisplayData();
            stm.close();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus!");
            
            ClearData();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jOkHapusActionPerformed

    private void jOkKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOkKeluarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jOkKeluarActionPerformed

    private void jTableObatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableObatKeyReleased
        // TODO add your handling code here:
        AmbilData();
    }//GEN-LAST:event_jTableObatKeyReleased

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
            java.util.logging.Logger.getLogger(FormObatApotik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormObatApotik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormObatApotik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormObatApotik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormObatApotik().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jCmbKategori;
    private javax.swing.JComboBox<String> jCmbLokasi;
    private javax.swing.JComboBox<String> jCmbSatuan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jOkHapus;
    private javax.swing.JButton jOkKeluar;
    private javax.swing.JButton jOkSimpan;
    private javax.swing.JButton jOkUbah;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableObat;
    private javax.swing.JTextField jTxtBeli;
    private javax.swing.JTextField jTxtJual1;
    private javax.swing.JTextField jTxtJual2;
    private javax.swing.JTextField jTxtKode;
    private javax.swing.JTextField jTxtNama;
    private javax.swing.JTextField jTxtStok;
    // End of variables declaration//GEN-END:variables
}
