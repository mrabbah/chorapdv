/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.choranet.pos.printer.ticket;

import java.awt.Font;
import java.awt.geom.AffineTransform;

/**
 *
 * @author mohamed
 */
public class BasicTicketForScreen extends BasicTicket {

    private static Font BASEFONT = new Font("Monospaced", Font.PLAIN, 12).deriveFont(AffineTransform.getScaleInstance(1.0, 1.40));
    private static int FONTHEIGHT = 20;
    private static double IMAGE_SCALE = 1.0;

    @Override
    protected Font getBaseFont() {
        return BASEFONT;
    }

    @Override
    protected int getFontHeight() {
        return FONTHEIGHT;
    }

    @Override
    protected double getImageScale() {
        return IMAGE_SCALE;
    }
}
