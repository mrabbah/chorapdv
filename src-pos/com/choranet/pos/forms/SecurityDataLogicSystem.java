/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.choranet.pos.forms;

import com.choranet.basic.BasicException;
import com.choranet.data.loader.Datas;
import com.choranet.data.loader.PreparedSentence;
import com.choranet.data.loader.SentenceExec;
import com.choranet.data.loader.SentenceFind;
import com.choranet.data.loader.SerializerReadString;
import com.choranet.data.loader.SerializerReadUseref;
import com.choranet.data.loader.SerializerWriteBasic;
import com.choranet.data.loader.SerializerWriteString;
import com.choranet.data.loader.Session;

/**
 *
 * @author mohamed
 */
public class SecurityDataLogicSystem extends DataLogicSystem {

    private SentenceFind m_keyddselect;
    private SentenceExec m_keyddinsert;
    private SentenceFind m_isDemoselect;

    public SecurityDataLogicSystem() {
    }

    
    public void init(Session s){
        super.init(s);

         m_keyddselect = new PreparedSentence(s,
                "SELECT KEYDD, ISFIRSTACESS, ISDEMO, NBRPRODALLOWED FROM USEREF",
                SerializerWriteString.INSTANCE,
                new SerializerReadUseref(new Datas[] {Datas.STRING,
                        Datas.STRING, Datas.STRING, Datas.TIMESTAMP,
                        Datas.BOOLEAN, Datas.BOOLEAN, Datas.INT}));

        m_keyddinsert = new PreparedSentence(s
                , "INSERT INTO USEREF(KEYDD, HOSTNAME, REFCLIENT, DATE, ISFIRSTACESS, ISDEMO, NBRPRODALLOWED) VALUES (?, ?, ?, ?, ?, ?, ?)"
                , new SerializerWriteBasic(new Datas[] {Datas.STRING,
                        Datas.STRING, Datas.STRING, Datas.TIMESTAMP,
                        Datas.BOOLEAN, Datas.BOOLEAN, Datas.INT}));

        m_isDemoselect = new PreparedSentence(s,
                "SELECT COUNT(*) FROM PRODUCTS",
                SerializerWriteString.INSTANCE,
//                new SerializerReadBasic(new Datas[]{Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING,
//                    Datas.STRING, Datas.DOUBLE, Datas.DOUBLE, Datas.STRING, Datas.STRING, Datas.DOUBLE,
//                    Datas.DOUBLE, Datas.IMAGE, Datas.BYTES, Datas.BYTES, Datas.IMAGE})
                SerializerReadString.INSTANCE
                );
    }

     public final RefClient findRefClient() throws BasicException {
        return (RefClient) m_keyddselect.find();
    }

    public final void execKeyDD(Object params) throws BasicException {
        m_keyddinsert.exec(params);
    }

    public final String findProductsNbr() throws BasicException{
        return (String) m_isDemoselect.find();
    }
}
