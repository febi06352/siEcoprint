/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formSiecoprint;

import java.awt.Dimension;
import java.awt.Font;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi_database.Tool;

/**
 *
 * @author ASUS
 */
public class formDasboard extends javax.swing.JFrame {

    /**
     * Creates new form formDasboard
     */
    formTable.tb_login login = new formTable.tb_login();
    formTable.tb_alamat alamat = new formTable.tb_alamat();
    formTable.tb_pegawai pegawai = new formTable.tb_pegawai();
    formTable.tb_inputDataLogin userLogin = new formTable.tb_inputDataLogin();
    formTable.tb_agen agen = new formTable.tb_agen();
    formTable.tb_pembelian pembelian = new formTable.tb_pembelian();
    formTable.tb_stokBarang stokBarang = new formTable.tb_stokBarang();
    formTable.tb_pengadaanBarang pengadaan = new formTable.tb_pengadaanBarang();
    formTable.tb_pelanggan pelanggan = new formTable.tb_pelanggan();
    formTable.tb_penjualan penjualan = new formTable.tb_penjualan();
    formTable.tb_returBarang retur = new formTable.tb_returBarang();
    formTable.tb_lpPenjualan lpPenjualan = new formTable.tb_lpPenjualan();
    formTable.tb_lpPembelian lpPembelian = new formTable.tb_lpPembelian();
    formTable.tb_analisaPenjualan analisa = new formTable.tb_analisaPenjualan();
    formTable.tb_notaPembayaran nota = new formTable.tb_notaPembayaran();
    //siecoprint.tmpIp alamatIP = new siecoprint.tmpIp();
    int waktumulai = 0;
//     public String nama = "";

//    public void setValue(String nama) {
//        this.nama = nama;
//    }
    public void DaftarStokBarang() {
        try {
            DefaultTableModel tabel = new DefaultTableModel();
            String sql = "Select kategori_barang,tipe_barang,banyak from tb_stokBarang";
            tabel = Tool.dataModeler(sql,login.getIP());
            jTabelStok.setModel(tabel);
        } catch (Exception e) {
        }
    }

    public void pendapatan() {
        try {
            Date tgl = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Statement st = koneksi_database.koneksi.koneksiDB(login.getIP()).createStatement();
            String hasilPendapatan = "select sum(total_harga) as pendapatan from tb_penjualan where tanggal = '" + sdf.format(tgl) + "'";
            ResultSet res = st.executeQuery(hasilPendapatan);
            while (res.next()) {
                jLpendapatan.setText(res.getString("pendapatan"));
            }
        } catch (Exception e) {
        }
    }

    public void pengeluaran() {
        try {
            Date tgl = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Statement st = koneksi_database.koneksi.koneksiDB(login.getIP()).createStatement();
            String hasilPendapatan = "select sum(total_harga) as pengeluaran from tb_pembelian where tanggal = '" + sdf.format(tgl) + "'";
            ResultSet res = st.executeQuery(hasilPendapatan);
            while (res.next()) {
                jLpendapatan.setText(res.getString("pengeluaran"));
            }
        } catch (Exception e) {
        }
    }

    public void aktif(String value) {
        if (value.equals("3")) {
            jMalamat.setEnabled(false);
            jMagen.setEnabled(true);
            jMstok.setEnabled(true);
            jMpegawai.setEnabled(false);
            jMpengadaan.setEnabled(true);
            jMpelanggan.setEnabled(true);
            jMuser.setEnabled(false);
            jMpenjualan.setEnabled(true);
            jMpembelian.setEnabled(true);
            jMretur.setEnabled(true);
            jMlpPembelian.setEnabled(true);
            jMlpPenjualan.setEnabled(true);
            jMaPenjualan.setEnabled(true);
            jMlogout.setEnabled(true);
            jMnota.setEnabled(true);
            jMlogin.setEnabled(false);
            jPanel2.setVisible(true);
            Dimension parent = jDesktopPane1.getSize();
            Dimension child = jPanel2.getSize();
            jPanel2.setLocation((parent.width - child.width) / 2, (parent.height - child.height) / 2);
            if ("".equals(jLpengeluaran.getText())) {
                jLpengeluaran.setText("0");
            } else {
                pengeluaran();
            }
            if ("".equals(jLpendapatan.getText())) {
                jLpendapatan.setText("0");
            } else {
                pendapatan();
            }

        } else if (value.equals("2")) {
            jMalamat.setEnabled(false);
            jMagen.setEnabled(false);
            jMstok.setEnabled(true);
            jMpegawai.setEnabled(false);
            jMpengadaan.setEnabled(true);
            jMpelanggan.setEnabled(true);
            jMuser.setEnabled(false);
            jMpenjualan.setEnabled(true);
            jMpembelian.setEnabled(false);
            jMretur.setEnabled(true);
            jMlpPembelian.setEnabled(false);
            jMlpPenjualan.setEnabled(true);
            jMaPenjualan.setEnabled(true);
            jMlogout.setEnabled(true);
            jMnota.setEnabled(true);
            jMlogin.setEnabled(false);
            jPanel2.setVisible(true);
            Dimension parent = jDesktopPane1.getSize();
            Dimension child = jPanel2.getSize();
            jPanel2.setLocation((parent.width - child.width) / 2, (parent.height - child.height) / 2);
            if ("".equals(jLpengeluaran.getText())) {
                jLpengeluaran.setText("0");
            } else {
                pengeluaran();
            }
            if ("".equals(jLpendapatan.getText())) {
                jLpendapatan.setText("0");
            } else {
                pendapatan();
            }

        } else if (value.equals("1")) {
            jMalamat.setEnabled(true);
            jMagen.setEnabled(true);
            jMstok.setEnabled(true);
            jMpegawai.setEnabled(true);
            jMpengadaan.setEnabled(true);
            jMpelanggan.setEnabled(true);
            jMuser.setEnabled(true);
            jMpenjualan.setEnabled(true);
            jMpembelian.setEnabled(true);
            jMretur.setEnabled(true);
            jMlpPembelian.setEnabled(true);
            jMlpPenjualan.setEnabled(true);
            jMaPenjualan.setEnabled(true);
            jMlogout.setEnabled(true);
            jMnota.setEnabled(true);
            jMlogin.setEnabled(false);
            jPanel2.setVisible(true);
            Dimension parent = jDesktopPane1.getSize();
            Dimension child = jPanel2.getSize();
            jPanel2.setLocation((parent.width - child.width) / 2, (parent.height - child.height) / 2);
            if ("".equals(jLpengeluaran.getText())) {
                jLpengeluaran.setText("0");
            } else {
                pengeluaran();
            }
            if ("".equals(jLpendapatan.getText())) {
                jLpendapatan.setText("0");
            } else {
                pendapatan();
            }


        } else if (value.equals("")) {
            jMalamat.setEnabled(false);
            jMagen.setEnabled(false);
            jMstok.setEnabled(false);
            jMpegawai.setEnabled(false);
            jMpengadaan.setEnabled(false);
            jMpelanggan.setEnabled(false);
            jMuser.setEnabled(false);
            jMpenjualan.setEnabled(false);
            jMpembelian.setEnabled(false);
            jMretur.setEnabled(false);
            jMlpPembelian.setEnabled(false);
            jMlpPenjualan.setEnabled(false);
            jMaPenjualan.setEnabled(false);
            jMlogout.setEnabled(false);
            jMlogin.setEnabled(true);
            alamat.setVisible(false);
            pegawai.setVisible(false);
            userLogin.setVisible(false);
            agen.setVisible(false);
            pembelian.setVisible(false);
            stokBarang.setVisible(false);
            pengadaan.setVisible(false);
            pelanggan.setVisible(false);
            penjualan.setVisible(false);
            lpPembelian.setVisible(false);
            lpPenjualan.setVisible(false);
            retur.setVisible(false);
            jMnota.setEnabled(false);
            jPanel2.setVisible(false);
        }
    }

    public void center_login() {
        login = new formTable.tb_login();
        halaman.add(login);
        Dimension parent = halaman.getSize();
        Dimension child = login.getSize();
        login.setLocation((parent.width - child.width) / 2, (parent.height - child.height) / 2);
        login.setVisible(true);
    }

    public void center_alamat() {
        try {
            alamat = new formTable.tb_alamat();
            halaman.add(alamat);
            Dimension parent = halaman.getSize();
            Dimension child = alamat.getSize();
            alamat.setLocation((parent.width - child.width) / 2, (parent.height - child.height) / 2);
            alamat.setVisible(true);
            alamat.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(formDasboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void center_pegawai() {
        try {
            pegawai = new formTable.tb_pegawai();
            halaman.add(pegawai);
            Dimension parent = halaman.getSize();
            Dimension child = pegawai.getSize();
            pegawai.setLocation((parent.width - child.width) / 2, (parent.height - child.height) / 2);
            pegawai.setVisible(true);
            pegawai.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(formDasboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void center_agen() {
        try {
            agen = new formTable.tb_agen();
            halaman.add(agen);
            Dimension parent = halaman.getSize();
            Dimension child = agen.getSize();
            agen.setLocation((parent.width - child.width) / 2, (parent.height - child.height) / 2);
            agen.setVisible(true);
            agen.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(formDasboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void center_userLogin() {
        try {
            userLogin = new formTable.tb_inputDataLogin();
            halaman.add(userLogin);
            Dimension parent = halaman.getSize();
            Dimension child = userLogin.getSize();
            userLogin.setLocation((parent.width - child.width) / 2, (parent.height - child.height) / 2);
            userLogin.setVisible(true);
            userLogin.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(formDasboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void center_pembelian() {
        try {
            pembelian = new formTable.tb_pembelian();
            halaman.add(pembelian);
            Dimension parent = halaman.getSize();
            Dimension child = pembelian.getSize();
            pembelian.setLocation((parent.width - child.width) / 2, (parent.height - child.height) / 2);
            pembelian.setVisible(true);
            pembelian.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(formDasboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void center_stokBarang() {
        try {
            stokBarang = new formTable.tb_stokBarang();
            halaman.add(stokBarang);
            Dimension parent = halaman.getSize();
            Dimension child = stokBarang.getSize();
            stokBarang.setLocation((parent.width - child.width) / 2, (parent.height - child.height) / 2);
            stokBarang.setVisible(true);
            stokBarang.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(formDasboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pengadaanBarang() {
        try {
            pengadaan = new formTable.tb_pengadaanBarang();
            halaman.add(pengadaan);
            Dimension parent = halaman.getSize();
            Dimension child = pengadaan.getSize();
            pengadaan.setLocation((parent.width - child.width) / 2, (parent.height - child.height) / 2);
            pengadaan.setVisible(true);
            pengadaan.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(formDasboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void center_pelanggan() {
        try {
            pelanggan = new formTable.tb_pelanggan();
            halaman.add(pelanggan);
            Dimension parent = halaman.getSize();
            Dimension child = pelanggan.getSize();
            pelanggan.setLocation((parent.width - child.width) / 2, (parent.height - child.height) / 2);
            pelanggan.setVisible(true);
            pelanggan.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(formDasboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void center_penjualan() {
        try {
            penjualan = new formTable.tb_penjualan();
            halaman.add(penjualan);
            Dimension parent = halaman.getSize();
            Dimension child = penjualan.getSize();
            penjualan.setLocation((parent.width - child.width) / 2, (parent.height - child.height) / 2);
            penjualan.setVisible(true);
            penjualan.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(formDasboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void center_retur() {
        try {
            retur = new formTable.tb_returBarang();
            halaman.add(retur);
            Dimension parent = halaman.getSize();
            Dimension child = retur.getSize();
            retur.setLocation((parent.width - child.width) / 2, (parent.height - child.height) / 2);
            retur.setVisible(true);
            retur.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(formDasboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void center_lpPenjualn() {
        try {
            lpPenjualan = new formTable.tb_lpPenjualan();
            halaman.add(lpPenjualan);
            Dimension parent = halaman.getSize();
            Dimension child = lpPenjualan.getSize();
            lpPenjualan.setLocation((parent.width - child.width) / 2, (parent.height - child.height) / 2);
            lpPenjualan.setVisible(true);
            lpPenjualan.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(formDasboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void center_lpPembelian() {
        try {
            lpPembelian = new formTable.tb_lpPembelian();
            halaman.add(lpPembelian);
            Dimension parent = halaman.getSize();
            Dimension child = lpPembelian.getSize();
            lpPembelian.setLocation((parent.width - child.width) / 2, (parent.height - child.height) / 2);
            lpPembelian.setVisible(true);
            lpPembelian.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(formDasboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void analisa_penjualan() {
        try {
            analisa = new formTable.tb_analisaPenjualan();
            halaman.add(analisa);
            Dimension parent = halaman.getSize();
            Dimension child = analisa.getSize();
            analisa.setLocation((parent.width - child.width) / 2, (parent.height - child.height) / 2);
            analisa.setVisible(true);
            analisa.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(formDasboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void notaPembayaran() {
        try {
            nota = new formTable.tb_notaPembayaran();
            halaman.add(nota);
            Dimension parent = halaman.getSize();
            Dimension child = nota.getSize();
            nota.setLocation((parent.width - child.width) / 2, (parent.height - child.height) / 2);
            nota.setVisible(true);
            nota.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(formDasboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public formDasboard() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);

        center_login();
        DaftarStokBarang();

        //aktif("");
        new Thread() {
            @Override
            public void run() {
                while (waktumulai == 0) {
                    Calendar kalender = new GregorianCalendar();
                    int jam = kalender.get(Calendar.HOUR);
                    int menit = kalender.get(Calendar.MINUTE);
                    int detik = kalender.get(Calendar.SECOND);
                    int AM_PM = kalender.get(Calendar.AM_PM);
                    String siang_malam = "";
                    if (AM_PM == 1) {
                        siang_malam = "PM";
                    } else {
                        siang_malam = "AM";
                    }
                    String time = jam + ":" + menit + ":" + detik + " " + siang_malam;
                    Dimension parent = sidebar.getSize();
                    Dimension child = jLjam.getSize();
                    jLjam.setLocation((parent.width - child.width) / 2, (parent.height - child.height) / 2);
                    jLjam.setFont(new Font("Arial", Font.PLAIN, 24));
                    jLjam.setText(time);
                    if (login.isVisible()) {
                        aktif(login.getuser());
                    }
                }
            }
        }.start();
        //System.out.println(login.getIP());
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
        halaman = new javax.swing.JDesktopPane();
        sidebar = new javax.swing.JDesktopPane();
        jLjam = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabelStok = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLpendapatan = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLpengeluaran = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMlogin = new javax.swing.JMenuItem();
        jMlogout = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMalamat = new javax.swing.JMenuItem();
        jMpegawai = new javax.swing.JMenuItem();
        jMuser = new javax.swing.JMenuItem();
        jMagen = new javax.swing.JMenuItem();
        jMstok = new javax.swing.JMenuItem();
        jMpengadaan = new javax.swing.JMenuItem();
        jMpelanggan = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMpenjualan = new javax.swing.JMenuItem();
        jMpembelian = new javax.swing.JMenuItem();
        jMretur = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMlpPenjualan = new javax.swing.JMenuItem();
        jMlpPembelian = new javax.swing.JMenuItem();
        jMnota = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMaPenjualan = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLjam.setBackground(new java.awt.Color(0, 0, 204));
        jLjam.setText("jLabel2");
        jLjam.setBounds(20, 10, 150, 40);
        sidebar.add(jLjam, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Kabar Harian"));
        jPanel2.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabelStok.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTabelStok);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 230, 212));

        jLabel1.setText("Pendapatan Hari Ini");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLpendapatan, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLpendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 220, -1));

        jLabel2.setText("Pengeluaran Hari Ini");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLpengeluaran, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLpengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 220, -1));

        jPanel2.setBounds(20, 10, 250, 500);
        jDesktopPane1.add(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sidebar, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(jDesktopPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(halaman, javax.swing.GroupLayout.DEFAULT_SIZE, 1126, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE))
            .addComponent(halaman)
        );

        jMenu1.setText("File");

        jMlogin.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMlogin.setText("Login");
        jMlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMloginActionPerformed(evt);
            }
        });
        jMenu1.add(jMlogin);

        jMlogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.SHIFT_MASK));
        jMlogout.setText("Logout");
        jMlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMlogoutActionPerformed(evt);
            }
        });
        jMenu1.add(jMlogout);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Master");

        jMalamat.setText("Kelola Alamat");
        jMalamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMalamatActionPerformed(evt);
            }
        });
        jMenu2.add(jMalamat);

        jMpegawai.setText("Kelola Pegawai");
        jMpegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMpegawaiActionPerformed(evt);
            }
        });
        jMenu2.add(jMpegawai);

        jMuser.setText("Kelola User");
        jMuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMuserActionPerformed(evt);
            }
        });
        jMenu2.add(jMuser);

        jMagen.setText("Kelola agen");
        jMagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMagenActionPerformed(evt);
            }
        });
        jMenu2.add(jMagen);

        jMstok.setText("Kelola Stok Barang");
        jMstok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMstokActionPerformed(evt);
            }
        });
        jMenu2.add(jMstok);

        jMpengadaan.setText("Kelola Pengadaan Barang");
        jMpengadaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMpengadaanActionPerformed(evt);
            }
        });
        jMenu2.add(jMpengadaan);

        jMpelanggan.setText("Kelola Pelanggan");
        jMpelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMpelangganActionPerformed(evt);
            }
        });
        jMenu2.add(jMpelanggan);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Transaksi");

        jMpenjualan.setText("Penjualan");
        jMpenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMpenjualanActionPerformed(evt);
            }
        });
        jMenu3.add(jMpenjualan);

        jMpembelian.setText("Pembelian");
        jMpembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMpembelianActionPerformed(evt);
            }
        });
        jMenu3.add(jMpembelian);

        jMretur.setText("Retur Barang");
        jMretur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMreturActionPerformed(evt);
            }
        });
        jMenu3.add(jMretur);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Report");

        jMlpPenjualan.setText("Rincian Penjualan");
        jMlpPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMlpPenjualanActionPerformed(evt);
            }
        });
        jMenu5.add(jMlpPenjualan);

        jMlpPembelian.setText("Rincian Pembelian");
        jMlpPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMlpPembelianActionPerformed(evt);
            }
        });
        jMenu5.add(jMlpPembelian);

        jMnota.setText("Nota Pembayaran");
        jMnota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnotaActionPerformed(evt);
            }
        });
        jMenu5.add(jMnota);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Analisa");

        jMaPenjualan.setText("Analisa Penjualan");
        jMaPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMaPenjualanActionPerformed(evt);
            }
        });
        jMenu6.add(jMaPenjualan);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMalamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMalamatActionPerformed
        // TODO add your handling code here:
        if (!alamat.isVisible()) {            
            center_alamat();
            alamat.tampilkan();
        } else {
            alamat.toFront();
        }

    }//GEN-LAST:event_jMalamatActionPerformed

    private void jMpegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMpegawaiActionPerformed
        // TODO add your handling code here:
        if (!pegawai.isVisible()) {
            center_pegawai();
            pegawai.combo_id();
            pegawai.tampilkan();
        } else {
            pegawai.toFront();
        }
    }//GEN-LAST:event_jMpegawaiActionPerformed

    private void jMuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMuserActionPerformed
        // TODO add your handling code here:
        if (!userLogin.isVisible()) {
            center_userLogin();
            userLogin.tampilkan();
            userLogin.combo_id();
        } else {
            userLogin.toFront();
        }

    }//GEN-LAST:event_jMuserActionPerformed

    private void jMagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMagenActionPerformed
        // TODO add your handling code here:
        if (!agen.isVisible()) {
            center_agen();
            agen.tampilkan();
        } else {
            agen.toFront();
        }

    }//GEN-LAST:event_jMagenActionPerformed

    private void jMpembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMpembelianActionPerformed
        // TODO add your handling code here:
        if (!pembelian.isVisible()) {
            center_pembelian();
            pembelian.id_agen();
            pembelian.id_pegawai();
            pembelian.id_stok();
        } else {
            pembelian.toFront();
        }

    }//GEN-LAST:event_jMpembelianActionPerformed

    private void jMstokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMstokActionPerformed
        // TODO add your handling code here:
        if (!stokBarang.isVisible()) {
            center_stokBarang();
            stokBarang.tampilkan();        
        } else {
            stokBarang.toFront();
        }

    }//GEN-LAST:event_jMstokActionPerformed

    private void jMpengadaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMpengadaanActionPerformed
        // TODO add your handling code here:
        if (!pengadaan.isVisible()) {
            pengadaanBarang();
            pengadaan.id_pegawai();            
        } else {
            pengadaan.toFront();
        }

    }//GEN-LAST:event_jMpengadaanActionPerformed

    private void jMpelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMpelangganActionPerformed
        // TODO add your handling code here:
        if (!pelanggan.isVisible()) {
            center_pelanggan();
            pelanggan.tampilkan();
        } else {
            pelanggan.toFront();
        }
    }//GEN-LAST:event_jMpelangganActionPerformed

    private void jMpenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMpenjualanActionPerformed
        // TODO add your handling code here:
        if (!penjualan.isVisible()) {
            center_penjualan();
            penjualan.id_pegawai();
            penjualan.id_pelanggan();
            penjualan.id_stok();
        } else {
            penjualan.toFront();
        }
    }//GEN-LAST:event_jMpenjualanActionPerformed

    private void jMreturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMreturActionPerformed
        // TODO add your handling code here:
        if (!retur.isVisible()) {
            center_retur();
            retur.id_penjualan();
            retur.id_stok();
            retur.tampilkan();
        } else {
            retur.toFront();
        }
    }//GEN-LAST:event_jMreturActionPerformed

    private void jMlpPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMlpPenjualanActionPerformed
        // TODO add your handling code here:
        if (!lpPenjualan.isVisible()) {
            center_lpPenjualn();
        } else {
            lpPenjualan.toFront();
        }
    }//GEN-LAST:event_jMlpPenjualanActionPerformed

    private void jMlpPembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMlpPembelianActionPerformed
        // TODO add your handling code here:
        if (!lpPembelian.isVisible()) {
            center_lpPembelian();
        } else {
            lpPembelian.toFront();
        }
    }//GEN-LAST:event_jMlpPembelianActionPerformed

    private void jMaPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMaPenjualanActionPerformed
        // TODO add your handling code here:
        if (!analisa.isVisible()) {
            analisa_penjualan();
        } else {
            analisa.toFront();
        }
    }//GEN-LAST:event_jMaPenjualanActionPerformed

    private void jMlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMlogoutActionPerformed
        // TODO add your handling code here:
        int dialog = JOptionPane.YES_NO_OPTION;
        int pertanyaan = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Ingin Keluar Dari Program ini ?", "Warning", dialog);
        if (pertanyaan == 0) {
            center_login();
        }
    }//GEN-LAST:event_jMlogoutActionPerformed

    private void jMloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMloginActionPerformed
        // TODO add your handling code here:
        if (!login.isVisible()) {
            center_login();
        }
    }//GEN-LAST:event_jMloginActionPerformed

    private void jMnotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnotaActionPerformed
        // TODO add your handling code here:
        if (!nota.isVisible()) {
            notaPembayaran();
        }
    }//GEN-LAST:event_jMnotaActionPerformed

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
            java.util.logging.Logger.getLogger(formDasboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formDasboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formDasboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formDasboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formDasboard().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane halaman;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLjam;
    private javax.swing.JLabel jLpendapatan;
    private javax.swing.JLabel jLpengeluaran;
    private javax.swing.JMenuItem jMaPenjualan;
    private javax.swing.JMenuItem jMagen;
    private javax.swing.JMenuItem jMalamat;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMlogin;
    private javax.swing.JMenuItem jMlogout;
    private javax.swing.JMenuItem jMlpPembelian;
    private javax.swing.JMenuItem jMlpPenjualan;
    private javax.swing.JMenuItem jMnota;
    private javax.swing.JMenuItem jMpegawai;
    private javax.swing.JMenuItem jMpelanggan;
    private javax.swing.JMenuItem jMpembelian;
    private javax.swing.JMenuItem jMpengadaan;
    private javax.swing.JMenuItem jMpenjualan;
    private javax.swing.JMenuItem jMretur;
    private javax.swing.JMenuItem jMstok;
    private javax.swing.JMenuItem jMuser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabelStok;
    private javax.swing.JDesktopPane sidebar;
    // End of variables declaration//GEN-END:variables
}
