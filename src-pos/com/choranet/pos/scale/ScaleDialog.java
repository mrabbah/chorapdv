//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.scale;

import com.choranet.beans.JNumberDialog;
import com.choranet.pos.forms.AppLocal;
import java.awt.Component;
import javax.swing.ImageIcon;

/**
 *
 * @author adrian
 */
public class ScaleDialog implements Scale {

    private Component parent;

    public ScaleDialog(Component parent) {
        this.parent = parent;
    }

    public Double readWeight() throws ScaleException {
        
        // Set title for grams Kilos, ounzes, pounds, ...
        return JNumberDialog.showEditNumber(parent, AppLocal.getIntString("label.scale"), AppLocal.getIntString("label.scaleinput"), new ImageIcon(ScaleDialog.class.getResource("/com/choranet/images/ark2.png")));
    }
}
