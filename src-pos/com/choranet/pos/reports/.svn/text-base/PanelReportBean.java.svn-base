//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.reports;

import com.choranet.basic.BasicException;
import com.choranet.data.loader.BaseSentence;
import com.choranet.data.loader.Datas;
import com.choranet.data.loader.QBFBuilder;
import com.choranet.data.loader.SerializerReadBasic;
import com.choranet.data.loader.StaticSentence;
import com.choranet.data.user.EditorCreator;
import com.choranet.pos.forms.AppLocal;
import com.choranet.pos.forms.AppView;
import com.choranet.pos.forms.BeanFactoryException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adrianromero
 */
public class PanelReportBean extends JPanelReport {
    
    private String title;
    private String report;
    
    private String resourcebundle = null;
    
    private String sentence;
    
    private List<Datas> fielddatas = new ArrayList<Datas>();
    private List<String> fieldnames = new ArrayList<String>();
    
    private List<String> paramnames = new ArrayList<String>();
    
    private JParamsComposed qbffilter = new JParamsComposed();
    
    @Override
    public void init(AppView app) throws BeanFactoryException {   
        
        qbffilter.init(app);       
        super.init(app);
    }
    
    @Override
    public void activate() throws BasicException {
        
        qbffilter.activate();
        super.activate();
        
        if (qbffilter.isEmpty()) {
            setVisibleFilter(false);
            setVisibleButtonFilter(false);
        }
    }
    
    @Override
    protected EditorCreator getEditorCreator() {
        
        return qbffilter;
    }    
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setTitleKey(String titlekey) {
        title = AppLocal.getIntString(titlekey);
    }
    
    public String getTitle() {
        return title;
    } 
    
    public void setReport(String report) {
        this.report = report;
    }
    
    protected String getReport() {
        return report;
    }  
    
    public void setResourceBundle(String resourcebundle) {
        this.resourcebundle = resourcebundle;
    }
    
    protected String getResourceBundle() {
        return resourcebundle == null 
                ? report 
                : resourcebundle;
    }    
    
    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
    
    public void addField(String name, Datas data) {
        fieldnames.add(name);
        fielddatas.add(data);
    }
    
    public void addParameter(String name) {
        paramnames.add(name);        
    }
    
    protected BaseSentence getSentence() {
        return new StaticSentence(m_App.getSession()
            , new QBFBuilder(sentence, paramnames.toArray(new String[paramnames.size()]))
            , qbffilter.getSerializerWrite()
            , new SerializerReadBasic(fielddatas.toArray(new Datas[fielddatas.size()])));
    }
    
    protected ReportFields getReportFields() {
        return new ReportFieldsArray(fieldnames.toArray(new String[fieldnames.size()]));
    }       
    
    public void addQBFFilter(ReportEditorCreator qbff) {
        qbffilter.addEditor(qbff);
    }    
}
