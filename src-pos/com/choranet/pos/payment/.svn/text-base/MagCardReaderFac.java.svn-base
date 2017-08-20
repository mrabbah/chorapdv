//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.payment;

/**
 *
 * @author adrianromero
 */
public class MagCardReaderFac {
    
    /** Creates a new instance of MagCarReaderFac */
    private MagCardReaderFac() {
    }
    
    public static MagCardReader getMagCardReader(String sReader) {
        
        if ("Intelligent".equals(sReader)) {
            return new MagCardReaderIntelligent();
        } else if ("Generic".equals(sReader)) {
            return new MagCardReaderGeneric();
        } else {
            return null;
        }
    }    
}
