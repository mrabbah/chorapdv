//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.loader;

import com.choranet.format.Formats;

/**
 *
 * @author  adrian
 */
public class RenderStringBasic implements IRenderString {
    
    private Formats[] m_aFormats;
    private int[] m_aiIndex;
    
    /** Creates a new instance of StringnizerBasic */
    public RenderStringBasic(Formats[] fmts, int[] aiIndex) {
        m_aFormats = fmts; 
        m_aiIndex = aiIndex;
    }
    public String getRenderString(Object value) {
        
        if (value == null) {
            return null; 
        } else {
            Object [] avalue = (Object[]) value;
            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < m_aiIndex.length; i++) {
                if (i > 0) {
                    sb.append(" - ");
                }
                sb.append(m_aFormats[m_aiIndex[i]].formatValue(avalue[m_aiIndex[i]]));
            }
            
            return sb.toString();
        }
    }  
   
}
