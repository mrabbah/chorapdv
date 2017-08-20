//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com


package com.choranet.pos.printer;

/**
 *
 * @author adrianromero
 */
public class BlinkAnimator extends BaseAnimator {
    
    public BlinkAnimator(String line1, String line2) {
        super(line1, line2);
    }
    
    public void setTiming(int i) {
        
        if ((i % 10) < 5) {
            currentLine1 = "";
            currentLine2 = "";
        } else {
            currentLine1 = baseLine1;
            currentLine2 = baseLine2;
        }
    }
}
