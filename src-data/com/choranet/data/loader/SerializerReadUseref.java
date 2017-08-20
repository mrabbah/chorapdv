/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.choranet.data.loader;

import com.choranet.basic.BasicException;
import com.choranet.pos.forms.RefClient;

/**
 *
 * @author mohamed
 */
public class SerializerReadUseref implements SerializerRead {

    private Datas[] m_classes;

    /** Creates a new instance of SerializerReadUseref */
    public SerializerReadUseref(Datas[] classes) {
        m_classes = classes;
    }
    
    public Object readValues(DataRead dr) throws BasicException {
                return new RefClient(
                        dr.getString(1),
                        dr.getBoolean(2),
                        dr.getBoolean(3),
                        dr.getInt(4));
            }
}