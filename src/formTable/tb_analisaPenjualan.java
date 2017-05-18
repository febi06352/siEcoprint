/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formTable;

import analisaPenjualan.dataItem;
import analisaPenjualan.sqlItemset;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class tb_analisaPenjualan extends javax.swing.JInternalFrame {

    /**
     * Creates new form tb_analisaPenjualan
     */
    Vector<dataItem> dt = new Vector<dataItem>();
    NumberFormat atur = NumberFormat.getInstance();
    sqlItemset si = new sqlItemset();
    siecoprint.tmpIp alamatIP = new siecoprint.tmpIp();

    public void isiData() {
        dt.removeAllElements();
        try {
            int tmp = Integer.parseInt(jTbanyak.getText()) * Integer.parseInt(jSpinnerSupport.getValue().toString()) / 100;
            Statement st = koneksi_database.koneksi.koneksiDB(alamatIP.getIp()).createStatement();
            String sql = "SELECT id_stok, count(no_nota) , tipe_barang FROM tb_penjualan GROUP BY id_stok HAVING count( no_nota ) >=1 ";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                if (rs.getInt("count(no_nota)") >= tmp) {
                    dataItem DI = new dataItem();
                    DI.setKode_item(rs.getString("id_stok"));
                    DI.setNama_item(rs.getString("tipe_barang"));
                    DI.setNilai(rs.getInt("count(no_nota)"));
                    dt.add(DI);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }

    public void iterasi2() {
        jThasilAnalisa.setText("");
        int n = 0;
        float bnyAB, bnyA, bnyB = 0;
        float supp, conf = 0;
        for (int i = 0; i < dt.size(); i++) {
            n++;
            for (int j = 0 + n; j < dt.size(); j++) {
                bnyAB = si.iterasi2(dt.get(i).getKode_item(), dt.get(j).getKode_item());
                bnyA = dt.get(i).getNilai();
                bnyB = dt.get(j).getNilai();
                supp = bnyAB / Integer.parseInt(jTbanyak.getText()) * 100;
                if (supp >= Float.parseFloat(jSpinnerSupport.getValue().toString())) {
                    conf = (bnyAB / bnyA) * 100;
                    if (conf >= Float.parseFloat(jSpinnerConf.getValue().toString())) {
                        jThasilAnalisa.setText(jThasilAnalisa.getText() + " Jika membeli \" " + dt.get(i).getNama_item() + " \" maka akan membeli \" " + dt.get(j).getNama_item() + " \" dengan Supp  " + atur.format(supp) + "% dan Conf " + atur.format(conf) + "% \n");
                    }

                    conf = (bnyAB / bnyB) * 100;
                    if (conf >= Float.parseFloat(jSpinnerConf.getValue().toString())) {
                        jThasilAnalisa.setText(jThasilAnalisa.getText() + " Jika membeli \" " + dt.get(j).getNama_item() + " \" maka akan membeli \" " + dt.get(i).getNama_item() + " \" dengan Supp " + atur.format(supp) + "% dan Conf " + atur.format(conf) + "% \n");
                    }
                }
            }
        }
    }

    public void iterasi3() {
        int n = 0;
        float bnyABC, bnyAB = 0;
        float supp, conf = 0;
        for (int i = 0; i < dt.size(); i++) {
            n++;
            for (int j = 0 + n; j < dt.size(); j++) {
                for (int k = 0 + j + 1; k < dt.size(); k++) {
                    bnyABC = si.iterasi3(dt.get(i).getKode_item(), dt.get(j).getKode_item(), dt.get(k).getKode_item());
                    supp = bnyABC / Integer.parseInt(jTbanyak.getText()) * 100;
                    if (supp >= Float.parseFloat(jSpinnerSupport.getValue().toString())) {
                        bnyAB = si.iterasi2(dt.get(i).getKode_item(), dt.get(j).getKode_item());
                        conf = (bnyABC / bnyAB) * 100;
                        if (conf >= Float.parseFloat(jSpinnerConf.getValue().toString())) {
                            jThasilAnalisa.setText(jThasilAnalisa.getText() + " Jika membeli \" " + dt.get(i).getNama_item() + " \" dan \" " + dt.get(j).getNama_item() + " \" maka akan membeli \" " + dt.get(k).getNama_item() + " \" dengan Supp " + atur.format(supp) + "% dan Conf " + atur.format(conf) + "% \n");
                        }

                        bnyAB = si.iterasi2(dt.get(i).getKode_item(), dt.get(k).getKode_item());
                        conf = (bnyABC / bnyAB) * 100;
                        if (conf >= Float.parseFloat(jSpinnerConf.getValue().toString())) {
                            jThasilAnalisa.setText(jThasilAnalisa.getText() + " Jika membeli \" " + dt.get(i).getNama_item() + " \" dan \" " + dt.get(k).getNama_item() + " \" maka akan membeli \" " + dt.get(j).getNama_item() + " \" dengan Supp " + atur.format(supp) + "% dan Conf " + atur.format(conf) + "% \n");
                        }

                        bnyAB = si.iterasi2(dt.get(j).getKode_item(), dt.get(k).getKode_item());
                        conf = (bnyABC / bnyAB) * 100;
                        if (conf >= Float.parseFloat(jSpinnerConf.getValue().toString())) {
                            jThasilAnalisa.setText(jThasilAnalisa.getText() + " Jika membeli \" " + dt.get(j).getNama_item() + " \" dan \" " + dt.get(k).getNama_item() + " \" Maka akan membeli \" " + dt.get(i).getNama_item() + " \" dengan Supp " + atur.format(supp) + "% dan Conf " + atur.format(conf) + "% \n");
                        }
                    }
                }
            }
        }
    }

    public tb_analisaPenjualan() {
        initComponents();
        //isiData();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSpinnerSupport = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jSpinnerConf = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTbanyak = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jThasilAnalisa = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Analisis Penjualan"));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Minimum Support", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 12))); // NOI18N

        jLabel1.setText("Nilai minimum dari jumlah transaksi yang");

        jLabel2.setText("Membeli barang yang sama");

        jLabel3.setText("Angka Minimum");

        jLabel4.setText("%");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSpinnerSupport, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jSpinnerSupport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Minimum Confidance", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 12))); // NOI18N

        jLabel5.setText("Angka Minimum");

        jLabel6.setText("Level minimum suatu tingkat kepercayaan");

        jLabel7.setText("antara suatu item barang");

        jLabel10.setText("%");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSpinnerConf, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jSpinnerConf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(9, 9, 9)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Count", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 12))); // NOI18N

        jLabel8.setText("Banyak");

        jLabel9.setText("Banyak Transaksi Keseluruhan");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jTbanyak)))
                .addGap(25, 25, 25))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTbanyak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jThasilAnalisa.setColumns(20);
        jThasilAnalisa.setRows(5);
        jScrollPane1.setViewportView(jThasilAnalisa);

        jButton1.setText("Proses");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton1)
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jButton1)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addContainerGap())
        );

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        isiData();
        iterasi2();
        iterasi3();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerConf;
    private javax.swing.JSpinner jSpinnerSupport;
    private javax.swing.JTextField jTbanyak;
    private javax.swing.JTextArea jThasilAnalisa;
    // End of variables declaration//GEN-END:variables
}
