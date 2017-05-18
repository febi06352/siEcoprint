/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package siecoprint;

import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author ASUS
 */
public class SiEcoprint {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Properties p = new Properties();
            p.put("logoString", " ");
            McWinLookAndFeel.setCurrentTheme(p);
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
            formSiecoprint.formDasboard fd =new formSiecoprint.formDasboard();
            fd.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SiEcoprint.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SiEcoprint.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SiEcoprint.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SiEcoprint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
