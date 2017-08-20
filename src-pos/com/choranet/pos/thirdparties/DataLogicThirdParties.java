//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.thirdparties;

import com.choranet.data.loader.Datas;
import com.choranet.data.loader.Session;
import com.choranet.data.loader.TableDefinition;
import com.choranet.format.Formats;
import com.choranet.pos.forms.BeanFactoryDataSingle;

public class DataLogicThirdParties extends BeanFactoryDataSingle {
    
    private TableDefinition m_tthirdparties;
 
    /** Creates a new instance of DataLogicAdmin */
    public DataLogicThirdParties() {
    }
    
    public void init(Session s){

        m_tthirdparties = new TableDefinition(s,
            "THIRDPARTIES"
            , new String[] {"ID", "CIF", "NAME", "ADDRESS", "CONTACTCOMM", "CONTACTFACT", "PAYRULE", "FAXNUMBER", "PHONENUMBER", "MOBILENUMBER", "EMAIL", "WEBPAGE", "NOTES"}
            , new Datas[] {Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING}
            , new Formats[] {Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING}
            , new int[] {0}
        );   
        
    }
       
    public final TableDefinition getTableThirdParties() {
        return m_tthirdparties;
    }    
}

