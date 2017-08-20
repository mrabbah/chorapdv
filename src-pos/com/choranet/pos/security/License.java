/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.choranet.pos.security;

import com.choranet.basic.BasicException;
import com.choranet.data.gui.JMessageDialog;
import com.choranet.pos.forms.JRoot;
import com.choranet.pos.forms.RefClient;
import com.choranet.pos.util.DiskUtils;
import java.util.Date;

/**
 *
 * @author mohamed
 */
public class License {

    public License() {
    }

    public static String checkIsFirstAcess(JRoot rootframe) throws BasicException {
        String storedkey = null;
        RefClient client = rootframe.getRefClient();
        if (client != null) {
            // le cas d'un volume d'installation est bien spécifié sur la base (step1).
            if (client.getM_isfirstAcess()) {
                rootframe.execKeyDD(
                        new Object[]{DiskUtils.getSerialNumber(client.getM_keydd()),
                            rootframe.getHostName(), "client", new Date(),
                            false, false, 0});
                System.exit(0);
            } else {
                storedkey = client.getM_keydd();
            }
        } else {
            // le cas du volume d'installation utilisé par défault (C)
            rootframe.execKeyDD(
                    new Object[]{DiskUtils.getDefaultSerialNumber(),
                        rootframe.getHostName(), "client", new Date(), false, false, 0});
            System.exit(0);
        }
        return storedkey;
    }

    public static void checkLicence(JRoot rootframe) throws BasicException {

        Boolean checkLicenceKey = false;
        RefClient client = rootframe.getRefClient();
        if (client != null && client.isM_isDemo()) {
            int nbrProductAllowed = client.getM_nbrProdAllowed();
            int currentNbrProduct = rootframe.getPtoductNomber();
            if (currentNbrProduct > nbrProductAllowed) {
                // supprimer le dernier produit
                // Afficher message : Merci de récupérer la version complete ...
                JMessageDialog.getMessageLicense(rootframe, "demo.message.chora.contact").setVisible(true);
                System.exit(1);
            }
        } else {
            String storedKey = checkIsFirstAcess(rootframe);
            String keySPart = storedKey.split("-")[1];
            String volume = keySPart.substring(0, 1);
            String currentKey = DiskUtils.getSerialNumber(volume);


            storedKey = keySPart.replace(volume, "");
            if (storedKey.equals(currentKey.replace("-", ""))) {
                checkLicenceKey = true;
            }

            if (!checkLicenceKey) {
               JMessageDialog.getMessageLicense(rootframe, "message.chora.contact").setVisible(true);
               System.exit(1);
            }
        }
    }
}
