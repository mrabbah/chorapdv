//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com


package com.choranet.pos.printer;

/**
 *
 * @author adrianromero
 */
public class CurtainAnimator extends BaseAnimator {
    
    public CurtainAnimator(String line1, String line2) {
        super(line1, line2);
    }
    
    public void setTiming(int i) {
        
        int j = i / 2;

        if (j < 10) {
            currentLine1 = DeviceTicket.alignCenter(baseLine1.substring(10 - j, 10 + j), 20);
            currentLine2 = DeviceTicket.alignCenter(baseLine2.substring(10 - j, 10 + j), 20);
        } else {
            currentLine1 = baseLine1;
            currentLine2 = baseLine2;
        }
    }
}