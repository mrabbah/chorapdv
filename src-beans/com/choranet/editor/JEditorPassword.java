//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.editor;

import com.choranet.basic.BasicException;

public class JEditorPassword extends JEditorText {
    
    private static final char ECHO_CHAR = '*';
    
    /** Creates a new instance of JEditorPassword */
    public JEditorPassword() {
        super();
    }
    
    protected final int getMode() {
        return EditorKeys.MODE_STRING;
    }
        
    protected int getStartMode() {
        return MODE_Abc1;
    }
    
    protected String getTextEdit() {
        
        StringBuffer s = new StringBuffer();
        s.append("<html>");
        s.append(getEcho(m_svalue));
        if (m_cLastChar != '\u0000') {
            s.append("<font color=\"#a0a0a0\">");
            s.append(ECHO_CHAR);
            s.append("</font>");
        }
        s.append("<font color=\"#a0a0a0\">_</font>");

        return s.toString(); 
    }
    
    public final String getPassword() {
        
        // como clave nunca devolvemos null
        String sPassword = getText();
        return sPassword == null ? "" : sPassword;     
    }    
    
    protected String getTextFormat() throws BasicException {
        return "<html>" + getEcho(m_svalue);
    }    
    
    private String getEcho(String sValue) {
        
        if (sValue == null) {
            return "";
        } else {
            char[] c = new char[sValue.length()];
            for(int i = 0; i < sValue.length(); i++) {
                c[i] = ECHO_CHAR;
            }
            return new String(c);
        }
    }
}
