//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.printer;

/**
 *
 * @author adrianromero
 */
public class NullAnimator implements DisplayAnimator {
    
    protected String currentLine1;
    protected String currentLine2; 
    
    public NullAnimator(String line1, String line2) {
        currentLine1 = DeviceTicket.alignLeft(line1, 20);
        currentLine2 = DeviceTicket.alignLeft(line2, 20);
    }

    public void setTiming(int i) {
    }

    public String getLine1() {
        return currentLine1;
    }

    public String getLine2() {
        return currentLine2;
    }
}
