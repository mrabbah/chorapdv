//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.forms;

import com.choranet.data.loader.PreparedSentence;
import com.choranet.data.loader.SerializerWriteString;
import com.choranet.data.loader.Session;
import com.choranet.data.loader.StaticSentence;

/**
 *
 * @author adrianromero
 */
public class DataLogicSystemOracle extends DataLogicSystem {
    
    /** Creates a new instance of DataLogicSystemOracle */
    public DataLogicSystemOracle() {    
    }
    
    public void init(Session s) {
        super.init(s);
        
        m_sInitScript = "/com/choranet/pos/scripts/oracle";
 
        m_peoplevisible = new StaticSentence(s
            , "SELECT ID, NAME, APPPASSWORD, CARD, ROLE, IMAGE FROM PEOPLE WHERE VISIBLE = 1"
            , null
            , peopleread);
        
        m_peoplebycard = new PreparedSentence(s
            , "SELECT ID, NAME, APPPASSWORD, CARD, ROLE, IMAGE FROM PEOPLE WHERE CARD = ? AND VISIBLE = 1"
            , SerializerWriteString.INSTANCE
            , peopleread);         
    }  
}

