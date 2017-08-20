//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.forms;

import com.choranet.basic.BasicException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import com.choranet.format.Formats;
import com.choranet.pos.instance.InstanceQuery;

import com.choranet.pos.security.License;
import javax.swing.LookAndFeel;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.SubstanceSkin;

/**
 *
 * @author mchahdi
 */
public class StartPOS {

    /** Creates a new instance of StartPOS */
    private StartPOS() {
    }

    public static boolean registerApp() {

        // vemos si existe alguna instancia        
        InstanceQuery i = null;
        try {
            i = new InstanceQuery();
            i.getAppMessage().restoreWindow();
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public static void main(final String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                if (!registerApp()) {
                    System.exit(1);
                }

                AppConfig config = new AppConfig(args);
                config.load();

                // set Locale.
                String slang = config.getProperty("user.language");
                String scountry = config.getProperty("user.country");
                String svariant = config.getProperty("user.variant");
                if (slang != null && !slang.equals("") && scountry != null && svariant != null) {
                    Locale.setDefault(new Locale(slang, scountry, svariant));
                }

                // Set the format patterns
                Formats.setIntegerPattern(config.getProperty("format.integer"));
                Formats.setDoublePattern(config.getProperty("format.double"));
                Formats.setCurrencyPattern(config.getProperty("format.currency"));
                Formats.setPercentPattern(config.getProperty("format.percent"));
                Formats.setDatePattern(config.getProperty("format.date"));
                Formats.setTimePattern(config.getProperty("format.time"));
                Formats.setDateTimePattern(config.getProperty("format.datetime"));

                // Set the look and feel.
                try {

                    Object laf = Class.forName(config.getProperty("swing.defaultlaf")).newInstance();

                    if (laf instanceof LookAndFeel) {
                        UIManager.setLookAndFeel((LookAndFeel) laf);
                    } else if (laf instanceof SubstanceSkin) {
                        SubstanceLookAndFeel.setSkin((SubstanceSkin) laf);
                    }
                } catch (Exception e) {
                }

                JRoot Jroot = null;
                String screenmode = config.getProperty("machine.screenmode");
                if ("fullscreen".equals(screenmode)) {
                    JRootKiosk rootkiosk = new JRootKiosk();
                    rootkiosk.initFrame(config);
                    Jroot = rootkiosk;
                } else {
                    JRootFrame rootframe = new JRootFrame();
                    rootframe.initFrame(config);
                    Jroot = rootframe;
                }
                try {
                    License.checkLicence(Jroot);
                } catch (BasicException ex) {
                    Logger.getLogger(StartPOS.class.getName()).log(Level.SEVERE, null, ex);
                    System.exit(1);
                }
            }
        });
    }
}
