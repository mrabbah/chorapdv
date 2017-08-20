//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.printer.ticket;

import java.awt.*;
import java.awt.geom.*;

import com.choranet.pos.printer.DevicePrinter;
import com.choranet.pos.printer.screen.*;

public class MyPrinterState {

    private int m_iSize;
    
    /** Creates a new instance of PrinterState */
    public MyPrinterState(int iSize) {
        m_iSize = iSize;
    }
    
    public int getLineMult() {
        return getLineMult(m_iSize);
    }   
    public static int getLineMult(int iSize) {
        switch (iSize) {
        case 0: case 2:
            return 1;
        case 1: case 3:
            return 2;
        default:
            return 0;
        }
    }
    
    public Font getFont(Font baseFont, int iStyle) {
        Font f;
        switch (m_iSize) {
            case 0: 
                f = baseFont;
                break;
            case 2:
                f = baseFont.deriveFont(AffineTransform.getScaleInstance(2.0, 1.0));
                break;
           case 1:
                f = baseFont.deriveFont(AffineTransform.getScaleInstance(1.0, 2.0));
                break;
            case 3:
                f = baseFont.deriveFont(AffineTransform.getScaleInstance(2.0, 2.0));
                break;
            default:
                f = baseFont;
                break;
        }
        f = f.deriveFont((iStyle & DevicePrinter.STYLE_BOLD) != 0 ? Font.BOLD : Font.PLAIN);
        // Falta aplicar el subrayado
        return f;        
    }
    
}
