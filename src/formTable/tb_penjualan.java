/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formTable;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class tb_penjualan extends javax.swing.JInternalFrame {

    /**
     * Creates new form tb_penjualan
     */
    
    siecoprint.tmpIp alamatIP = new siecoprint.tmpIp();
    public void setTable(JTable table, int row) {
        DefaultTableModel tablemodel = new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null}
                },
                new String[]{
                    "ID Penjualan", "ID Pelanggan", "ID Stok", "ID Pegawai", "Nama Barang", "Tipe Barang", "Banyak Barang", "Diskon", "Harga Barang", "Total Harga"
                });
        table.setModel(tablemodel);
        String[] data = {null};

        for (int i = 0; i < row; i++) {
            ((DefaultTableModel) table.getModel()).addRow(data);
        }
    }

    public void id_pelanggan() {
        try {
            //Connection con = koneksi.konek.koneksiDB();
            Statement st = koneksi_database.koneksi.koneksiDB(alamatIP.getIp()).createStatement();
            String sql = "select id_pelanggan from tb_pelanggan order by id_pelanggan asc";
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Object[] ob = new Object[3];
                ob[0] = res.getString(1);

                jCidPelanggan.addItem(ob[0]);
            }
            res.close();
            st.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void id_pegawai() {
        try {
            Statement st = koneksi_database.koneksi.koneksiDB(alamatIP.getIp()).createStatement();
            String sql = "select id_pegawai from tb_pegawai order by id_pegawai asc";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Object[] ob = new Object[3];
                ob[0] = rs.getString(1);
                jCidPegawai.addItem(ob[0]);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void id_stok() {
        try {
            Statement st = koneksi_database.koneksi.koneksiDB(alamatIP.getIp()).createStatement();
            String sql = "select id_stok from tb_stokbarang order by id_stok asc";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Object[] ob = new Object[3];
                ob[0] = rs.getString(1);
                jCidStok.addItem(ob[0]);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public tb_penjualan() {
        initComponents();
//        id_pelanggan();
//        id_pegawai();
//        id_stok();


        jTharga.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (jTbanyak.getText().equals("") || jTharga.getText().equals("") || jTDiskon.getText().equals("")) {
                    jLtotal.setText(String.valueOf("0"));
                    jLnota.setText("");
                } else {
                    int total = Integer.parseInt(jTharga.getText()) * Integer.parseInt(jTbanyak.getText());
                    int diskon = total - ((total * Integer.parseInt(jTDiskon.getText())) / 100);
                    jLtotal.setText(String.valueOf(diskon));
                    Date tgl = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("ddmmyyyyhhmss");
                    String idNota = "N" + sdf.format(tgl);
                    jLnota.setText(idNota);
                }

            }
        });


        jTbanyak.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (jTbanyak.getText().equals("") || jTharga.getText().equals("") || jTDiskon.getText().equals("")) {
                    jLtotal.setText(String.valueOf("0"));
                    jLnota.setText("");
                } else {
                    int total = Integer.parseInt(jTharga.getText()) * Integer.parseInt(jTbanyak.getText());
                    int diskon = total - ((total * Integer.parseInt(jTDiskon.getText())) / 100);
                    jLtotal.setText(String.valueOf(diskon));
                    Date tgl = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("ddmmyyyyhhmss");
                    String idNota = "N" + sdf.format(tgl);
                    jLnota.setText(idNota);
                }

            }
        });

        jTDiskon.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (jTbanyak.getText().equals("") || jTharga.getText().equals("") || jTDiskon.getText().equals("")) {
                    jLtotal.setText(String.valueOf("0"));
                    jLnota.setText("");
                } else {
                    int total = Integer.parseInt(jTharga.getText()) * Integer.parseInt(jTbanyak.getText());
                    int diskon = total - ((total * Integer.parseInt(jTDiskon.getText())) / 100);
                    jLtotal.setText(String.valueOf(diskon));
                    Date tgl = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("ddmmyyyyhhmss");
                    String idNota = "N" + sdf.format(tgl);
                    jLnota.setText(idNota);
                }

            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jCidPelanggan = new javax.swing.JComboBox();
        jCidStok = new javax.swing.JComboBox();
        jCidPegawai = new javax.swing.JComboBox();
        jTnamaBarang = new javax.swing.JTextField();
        jTtipe = new javax.swing.JTextField();
        jTbanyak = new javax.swing.JTextField();
        jTharga = new javax.swing.JTextField();
        jLtotal = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTDiskon = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTransaksi = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLHarga = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLnota = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Penjualan");

        jLabel1.setText("ID Pelanggan");

        jLabel2.setText("ID Stok");

        jLabel3.setText("ID Pegawai");

        jLabel4.setText("Nama Barang");

        jLabel5.setText("Type Barang");

        jLabel6.setText("Banyak Barang");

        jLabel7.setText("Harga Satuan");

        jLabel8.setText("Total Harga");

        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Diskon");

        jTableTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableTransaksi);

        jButton2.setText("Simpan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel10.setText("Total Harga Yang Harus Dibayar");

        jLabel11.setText("Nomer Nota");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(71, 71, 71))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jCidPelanggan, 0, 210, Short.MAX_VALUE)
                                    .addComponent(jCidStok, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCidPegawai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTnamaBarang)
                                    .addComponent(jTtipe)
                                    .addComponent(jLnota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jButton1))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(489, 489, 489))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(63, 63, 63)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTharga, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                    .addComponent(jTDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTbanyak)
                                    .addComponent(jLtotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(44, 44, 44)
                        .addComponent(jLHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jCidPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jCidStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jCidPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTnamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTbanyak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTtipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLnota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel10)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    Vector tampungData = new Vector();
    Vector tampungKata = new Vector();
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            Date tanggal = new Date();
            SimpleDateFormat sfd = new SimpleDateFormat("ddmmyyyyhhmss");
            String idPenjualan = "PJ" + sfd.format(tanggal);
            tampungKata.removeAllElements();
            tampungData.add(idPenjualan + "\t" + jCidPelanggan.getSelectedItem() + "\t" + jCidStok.getSelectedItem() + "\t" + jCidPegawai.getSelectedItem() + "\t" + jTnamaBarang.getText() + "\t" + jTtipe.getText() + "\t" + jTbanyak.getText() + "\t" + jTDiskon.getText() + "\t" + jTharga.getText() + "\t" + jLtotal.getText());
            for (int i = 0; i < tampungData.size(); i++) {
                String kata = tampungData.get(i).toString();
                String[] pKata = kata.split("\t");
                for (String tmp : pKata) {
                    tampungKata.add(tmp);
                }
            }
            //System.out.println(tampungKata.get(0) + "\t" + jTableTransaksi.getRowCount());
            setTable(jTableTransaksi, jTableTransaksi.getRowCount());
            for (int j = 0; j < tampungData.size(); j++) {
                int batas = j * 10;
                jTableTransaksi.setValueAt(tampungKata.get(batas), j, 0);
                jTableTransaksi.setValueAt(tampungKata.get(batas + 1), j, 1);
                jTableTransaksi.setValueAt(tampungKata.get(batas + 2), j, 2);
                jTableTransaksi.setValueAt(tampungKata.get(batas + 3), j, 3);
                jTableTransaksi.setValueAt(tampungKata.get(batas + 4), j, 4);
                jTableTransaksi.setValueAt(tampungKata.get(batas + 5), j, 5);
                jTableTransaksi.setValueAt(tampungKata.get(batas + 6), j, 6);
                jTableTransaksi.setValueAt(tampungKata.get(batas + 7), j, 7);
                jTableTransaksi.setValueAt(tampungKata.get(batas + 8), j, 8);
                jTableTransaksi.setValueAt(tampungKata.get(batas + 9), j, 9);
            }
            //System.out.println(jTableTransaksi.getValueAt(0, 9));
            int jumlah = 0;
            for (int k = 0; k < jTableTransaksi.getRowCount(); k++) {
                jumlah += Integer.parseInt(jTableTransaksi.getValueAt(k, 9).toString());
                jLHarga.setText(String.valueOf(jumlah));
            }
            jCidPegawai.setSelectedIndex(0);
            jCidStok.setSelectedItem(0);
            jCidPelanggan.setSelectedIndex(0);
            jTnamaBarang.setText("");
            jTDiskon.setText("");
            jTbanyak.setText("");
            jTharga.setText("");
            jTtipe.setText("");
            jLtotal.setText("");
            JOptionPane.showMessageDialog(rootPane, "Berhasil Ditambahkan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Gagal Ditambahkan");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        tampungData.removeAllElements();
        try {
            for (int a = 0; a < jTableTransaksi.getRowCount(); a++) {
                Date tanggal = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String sql = "insert into tb_penjualan values ('" + jTableTransaksi.getValueAt(a, 0).toString() + "','" + jLnota.getText() + "','" + jTableTransaksi.getValueAt(a, 1).toString() + "','" + jTableTransaksi.getValueAt(a, 2).toString() + "','" + jTableTransaksi.getValueAt(a, 3).toString() + "','" + jTableTransaksi.getValueAt(a, 4).toString() + "','" + jTableTransaksi.getValueAt(a, 5).toString() + "','" + jTableTransaksi.getValueAt(a, 6).toString() + "','" + jTableTransaksi.getValueAt(a, 7).toString() + "','" + jTableTransaksi.getValueAt(a, 8).toString() + "','" + jTableTransaksi.getValueAt(a, 9).toString() + "','" + java.sql.Date.valueOf(sdf.format(tanggal)) + "')";
                java.sql.Connection conn = (java.sql.Connection) koneksi_database.koneksi.koneksiDB(alamatIP.getIp());
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(rootPane, "Berhasil Menyimpan");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Gagal Menyimpan");
        }

    }//GEN-LAST:event_jButton2ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jCidPegawai;
    private javax.swing.JComboBox jCidPelanggan;
    private javax.swing.JComboBox jCidStok;
    private javax.swing.JLabel jLHarga;
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
    private javax.swing.JLabel jLnota;
    private javax.swing.JLabel jLtotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTDiskon;
    private javax.swing.JTable jTableTransaksi;
    private javax.swing.JTextField jTbanyak;
    private javax.swing.JTextField jTharga;
    private javax.swing.JTextField jTnamaBarang;
    private javax.swing.JTextField jTtipe;
    // End of variables declaration//GEN-END:variables
}
