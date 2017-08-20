//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.printer;

/**
 *
 * @author adrianromero
 */
public abstract class BaseAnimator implements DisplayAnimator {
    
    protected String baseLine1;
    protected String baseLine2;
    protected String currentLine1;
    protected String currentLine2; 
    
    public BaseAnimator(String line1, String line2) {
        baseLine1 = line1;
        baseLine2 = line2;
    }

    public String getLine1() {
        return currentLine1;
    }

    public String getLine2() {
        return currentLine2;
    }
}
