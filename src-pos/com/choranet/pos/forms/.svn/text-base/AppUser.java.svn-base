//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.forms;

import java.io.IOException;
import java.io.StringReader;
import java.util.*;
import javax.swing.Icon;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import com.choranet.pos.ticket.UserInfo;
import com.choranet.pos.util.Hashcypher;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author adrianromero
 */
public class AppUser {
    
    private static SAXParser m_sp = null;
    private static HashMap<String, String> m_oldclasses; // This is for backwards compatibility purposes
    
    private String m_sId;
    private String m_sName;
    private String m_sCard;
    private String m_sPassword;
    private String m_sRole;
    private Icon m_Icon;
    
    private Set<String> m_apermissions;
    
    static {        
        initOldClasses();
    }
    
    /** Creates a new instance of AppUser */
    public AppUser(String id, String name, String password, String card, String role, Icon icon) {
        m_sId = id;
        m_sName = name;
        m_sPassword = password;
        m_sCard = card;
        m_sRole = role;
        m_Icon = icon;
        m_apermissions = null;
    }
    
    public Icon getIcon() {
        return m_Icon;
    }
    
    public String getId() {
        return m_sId;
    }    
    
    public String getName() {
        return m_sName;
    }
    
    public void setPassword(String sValue) {
        m_sPassword = sValue;
    }
    
    public String getPassword() {
        return m_sPassword;
    }
    
    public String getRole() {
        return m_sRole;
    }
    
    public String getCard() {
        return m_sCard;
    }
    
    public boolean authenticate() {
        return m_sPassword == null || m_sPassword.equals("") || m_sPassword.startsWith("empty:");
    }
    public boolean authenticate(String sPwd) {
        return Hashcypher.authenticate(sPwd, m_sPassword);
    }
    
    public void fillPermissions(DataLogicSystem dlSystem) {
        
        // inicializamos los permisos
        m_apermissions = new HashSet<String>();
        // Y lo que todos tienen permisos
        m_apermissions.add("com.choranet.pos.forms.JPanelMenu");
        m_apermissions.add("Menu.Exit");        
        
        String sRolePermisions = dlSystem.findRolePermissions(m_sRole);
       
        if (sRolePermisions != null) {
            try {
                if (m_sp == null) {
                    SAXParserFactory spf = SAXParserFactory.newInstance();
                    m_sp = spf.newSAXParser();
                }
                m_sp.parse(new InputSource(new StringReader(sRolePermisions)), new ConfigurationHandler());

            } catch (ParserConfigurationException ePC) {
                System.out.println("Error en el analizador XML. Consulte con su administrador");
            } catch (SAXException eSAX) {
                System.out.println("El archivo no es un documento XML valido. Error de analisis.");
            } catch (IOException eIO) {
                System.out.println("Error al leer el archivo. Consulte con su administrador.");
            }
        }         

    }
    
    public boolean hasPermission(String classname) {

        return (m_apermissions == null) ? false : m_apermissions.contains(classname);        
    }   
    
    public UserInfo getUserInfo() {
        return new UserInfo(m_sId, m_sName);
    }
    
    private static String mapNewClass(String classname) {
        String newclass = m_oldclasses.get(classname);
        return newclass == null 
                ? classname 
                : newclass;
    }
    
    private static void initOldClasses() {
        m_oldclasses = new HashMap<String, String>();
        
        // update permissions from 0.0.24 to 2.20    
        m_oldclasses.put("net.adrianromero.tpv.panelsales.JPanelTicketSales", "com.choranet.pos.sales.JPanelTicketSales");
        m_oldclasses.put("net.adrianromero.tpv.panelsales.JPanelTicketEdits", "com.choranet.pos.sales.JPanelTicketEdits");
        m_oldclasses.put("net.adrianromero.tpv.panels.JPanelPayments", "com.choranet.pos.panels.JPanelPayments");
        m_oldclasses.put("net.adrianromero.tpv.panels.JPanelCloseMoney", "com.choranet.pos.panels.JPanelCloseMoney");
        m_oldclasses.put("net.adrianromero.tpv.reports.JReportClosedPos", "/com/choranet/reports/closedpos.bs");

//        m_oldclasses.put("payment.cash", "");
//        m_oldclasses.put("payment.cheque", "");
//        m_oldclasses.put("payment.paper", "");
//        m_oldclasses.put("payment.tichet", "");
//        m_oldclasses.put("payment.magcard", "");
//        m_oldclasses.put("payment.free", "");
//        m_oldclasses.put("refund.cash", "");
//        m_oldclasses.put("refund.cheque", "");
//        m_oldclasses.put("refund.paper", "");
//        m_oldclasses.put("refund.magcard", "");

        m_oldclasses.put("Menu.StockManagement", "com.choranet.pos.forms.MenuStockManagement");
        m_oldclasses.put("net.adrianromero.tpv.inventory.ProductsPanel", "com.choranet.pos.inventory.ProductsPanel");
        m_oldclasses.put("net.adrianromero.tpv.inventory.ProductsWarehousePanel", "com.choranet.pos.inventory.ProductsWarehousePanel");
        m_oldclasses.put("net.adrianromero.tpv.inventory.CategoriesPanel", "com.choranet.pos.inventory.CategoriesPanel");
        m_oldclasses.put("net.adrianromero.tpv.panels.JPanelTax", "com.choranet.pos.inventory.TaxPanel");
        m_oldclasses.put("net.adrianromero.tpv.inventory.StockDiaryPanel", "com.choranet.pos.inventory.StockDiaryPanel");
        m_oldclasses.put("net.adrianromero.tpv.inventory.StockManagement", "com.choranet.pos.inventory.StockManagement");
        m_oldclasses.put("net.adrianromero.tpv.reports.JReportProducts", "/com/choranet/reports/products.bs");
        m_oldclasses.put("net.adrianromero.tpv.reports.JReportCatalog", "/com/choranet/reports/productscatalog.bs");
        m_oldclasses.put("net.adrianromero.tpv.reports.JReportInventory", "/com/choranet/reports/inventory.bs");
        m_oldclasses.put("net.adrianromero.tpv.reports.JReportInventory2", "/com/choranet/reports/inventoryb.bs");
        m_oldclasses.put("net.adrianromero.tpv.reports.JReportInventoryBroken", "/com/choranet/reports/inventorybroken.bs");
        m_oldclasses.put("net.adrianromero.tpv.reports.JReportInventoryDiff", "/com/choranet/reports/inventorydiff.bs");

        m_oldclasses.put("Menu.SalesManagement", "com.choranet.pos.forms.MenuSalesManagement");
        m_oldclasses.put("net.adrianromero.tpv.reports.JReportUserSales", "/com/choranet/reports/usersales.bs");
        m_oldclasses.put("net.adrianromero.tpv.reports.JReportClosedProducts", "/com/choranet/reports/closedproducts.bs");
        m_oldclasses.put("net.adrianromero.tpv.reports.JReportTaxes", "/com/choranet/reports/taxes.bs");
        m_oldclasses.put("net.adrianromero.tpv.reports.JChartSales", "/com/choranet/reports/chartsales.bs");

        m_oldclasses.put("Menu.Maintenance", "com.choranet.pos.forms.MenuMaintenance");
        m_oldclasses.put("net.adrianromero.tpv.admin.PeoplePanel", "com.choranet.pos.admin.PeoplePanel");
        m_oldclasses.put("net.adrianromero.tpv.admin.RolesPanel", "com.choranet.pos.admin.RolesPanel");
        m_oldclasses.put("net.adrianromero.tpv.admin.ResourcesPanel", "com.choranet.pos.admin.ResourcesPanel");
        m_oldclasses.put("net.adrianromero.tpv.inventory.LocationsPanel", "com.choranet.pos.inventory.LocationsPanel");
        m_oldclasses.put("net.adrianromero.tpv.mant.JPanelFloors", "com.choranet.pos.mant.JPanelFloors");
        m_oldclasses.put("net.adrianromero.tpv.mant.JPanelPlaces", "com.choranet.pos.mant.JPanelPlaces");
        m_oldclasses.put("com.choranet.possync.ProductsSync", "com.choranet.possync.ProductsSyncCreate");
        m_oldclasses.put("com.choranet.possync.OrdersSync", "com.choranet.possync.OrdersSyncCreate");

        m_oldclasses.put("Menu.ChangePassword", "Menu.ChangePassword");
        m_oldclasses.put("net.adrianromero.tpv.panels.JPanelPrinter", "com.choranet.pos.panels.JPanelPrinter");
        m_oldclasses.put("net.adrianromero.tpv.config.JPanelConfiguration", "com.choranet.pos.config.JPanelConfiguration");
        
//        m_oldclasses.put("button.print", "");
//        m_oldclasses.put("button.opendrawer", "");
        
        // update permissions from 2.00 to 2.20       
        m_oldclasses.put("com.choranet.pos.reports.JReportCustomers", "/com/choranet/reports/customers.bs");
        m_oldclasses.put("com.choranet.pos.reports.JReportCustomersB", "/com/choranet/reports/customersb.bs");
        m_oldclasses.put("com.choranet.pos.reports.JReportClosedPos", "/com/choranet/reports/closedpos.bs");
        m_oldclasses.put("com.choranet.pos.reports.JReportClosedProducts", "/com/choranet/reports/closedproducts.bs");
        m_oldclasses.put("com.choranet.pos.reports.JChartSales", "/com/choranet/reports/chartsales.bs");
        m_oldclasses.put("com.choranet.pos.reports.JReportInventory", "/com/choranet/reports/inventory.bs");
        m_oldclasses.put("com.choranet.pos.reports.JReportInventory2", "/com/choranet/reports/inventoryb.bs");
        m_oldclasses.put("com.choranet.pos.reports.JReportInventoryBroken", "/com/choranet/reports/inventorybroken.bs");
        m_oldclasses.put("com.choranet.pos.reports.JReportInventoryDiff", "/com/choranet/reports/inventorydiff.bs");
        m_oldclasses.put("com.choranet.pos.reports.JReportPeople", "/com/choranet/reports/people.bs");
        m_oldclasses.put("com.choranet.pos.reports.JReportTaxes", "/com/choranet/reports/taxes.bs");
        m_oldclasses.put("com.choranet.pos.reports.JReportUserSales", "/com/choranet/reports/usersales.bs");
        m_oldclasses.put("com.choranet.pos.reports.JReportProducts", "/com/choranet/reports/products.bs");
        m_oldclasses.put("com.choranet.pos.reports.JReportCatalog", "/com/choranet/reports/productscatalog.bs");
        
        // update permissions from 2.10 to 2.20
        m_oldclasses.put("com.choranet.pos.panels.JPanelTax", "com.choranet.pos.inventory.TaxPanel");
        
    }
    
    private class ConfigurationHandler extends DefaultHandler {       
        @Override
        public void startDocument() throws SAXException {}
        @Override
        public void endDocument() throws SAXException {}    
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
            if ("class".equals(qName)){
                m_apermissions.add(mapNewClass(attributes.getValue("name")));
            }
        }      
        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {}
        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {}
    }     
    
    
}
