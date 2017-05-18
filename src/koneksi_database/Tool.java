/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi_database;

/**
 *
 * @author ASUS
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author grandong
 */
public class Tool {

    public static DefaultTableModel dataModeler(String sql,String ip) throws SQLException {
        Connection koneksi = koneksi_database.koneksi.koneksiDB(ip);
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        PreparedStatement ps = null;
        try {
            DefaultTableModel model = new DefaultTableModel();
            ps = koneksi.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            rsmd = rs.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                model.addColumn(rsmd.getColumnName(i));
            }

            while (rs.next()) {
                Object[] obj = new Object[rsmd.getColumnCount()];
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    obj[i] = rs.getString(i + 1);
                }
                model.addRow(obj);
            }
            return model;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }
}
