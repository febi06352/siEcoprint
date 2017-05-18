/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisaPenjualan;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class sqlItemset {

    siecoprint.tmpIp alamatIP = new siecoprint.tmpIp();
    public int banyakTransaksi() {
        int jml = 0;
        try {
            Statement st = koneksi_database.koneksi.koneksiDB(alamatIP.getIp()).createStatement();
            String bykSql = "select count(no_nota) from tb_penjualan";
            ResultSet res = st.executeQuery(bykSql);
            while (res.next()) {
                jml = res.getInt("count(no_nota)");
            }
            res.close();
            st.close();
            //System.out.println(jml);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return jml;
    }

    public int iterasi2(String a, String b) {
        int jml = 0;
        try {
            Statement st = koneksi_database.koneksi.koneksiDB(alamatIP.getIp()).createStatement();
            String sql = "select COUNT(DISTINCT no_nota)as ddd from tb_penjualan Where no_nota in ( select no_nota from tb_penjualan where id_stok='" + a + "') "
                    + "and no_nota in ( select no_nota from tb_penjualan where id_stok='" + b + "')";
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                jml = res.getInt("ddd");
            }
            res.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return jml;
    }

    public int iterasi3(String a, String b, String c) {
        int jml = 0;
        try {
            Statement st = koneksi_database.koneksi.koneksiDB(alamatIP.getIp()).createStatement();
            String sql = "select COUNT(DISTINCT no_nota)as aaa from tb_penjualan Where no_nota in ( select no_nota from tb_penjualan where id_stok='" + a + "') "
                    + "and no_nota in ( select no_nota from tb_penjualan where id_stok='" + b + "')"
                    + "and no_nota in ( select no_nota from tb_penjualan where id_stok='" + c + "')";
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                jml = res.getInt("aaa");
            }
            res.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return jml;
    }
}
