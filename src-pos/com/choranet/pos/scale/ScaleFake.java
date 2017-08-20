//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

/*
 * ScaleFake.java
 *
 * Created on 13 de junio de 2006, 23:15
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.choranet.pos.scale;

public class ScaleFake implements Scale {
    
    /** Creates a new instance of ScaleFake */
    public ScaleFake() {
    }
    
    public Double readWeight() throws ScaleException {
        return new Double(Math.random() * 2.0);
    }
    
}
