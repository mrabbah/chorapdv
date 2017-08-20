//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.data.loader;

import com.choranet.basic.BasicException;


public class SequenceForMySQL extends BaseSentence {
    
    private BaseSentence sent1;
    private BaseSentence sent2;
    
    /** Creates a new instance of SequenceForMySQL */
    public SequenceForMySQL(Session s, String sSeqTable, SerializerRead serread) {
        
        sent1 = new StaticSentence(s, "UPDATE " + sSeqTable + " SET ID = LAST_INSERT_ID(ID + 1)");
        sent2 = new StaticSentence(s, "SELECT LAST_INSERT_ID()", null, serread);
    }
    
    // Funciones de bajo nivel    
    public DataResultSet openExec(Object params) throws BasicException {        
        sent1.exec();
        return sent2.openExec(null);
    }   
    public DataResultSet moreResults() throws BasicException {
        return sent2.moreResults();
    }
    public void closeExec() throws BasicException {
        sent2.closeExec();
    }
}
