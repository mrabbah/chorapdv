//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.editor;

import com.choranet.format.Formats;

public class JEditorCurrency extends JEditorNumber {
    
	private static final long serialVersionUID = 5096754100573262803L;
	
	/** Creates a new instance of JEditorCurrency */
    public JEditorCurrency() {
    }
    
    protected Formats getFormat() {
        return Formats.CURRENCY;
    }
    protected int getMode() {
        return EditorKeys.MODE_DOUBLE;
    }  
}
