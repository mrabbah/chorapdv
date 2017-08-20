//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.possync;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;
import com.choranet.basic.BasicException;
import com.choranet.data.gui.MessageInf;
import com.choranet.data.loader.ImageUtils;
import com.choranet.pos.customers.CustomerInfoExt;
import com.choranet.pos.forms.AppLocal;
import com.choranet.pos.forms.DataLogicSales;
import com.choranet.pos.forms.DataLogicSystem;
import com.choranet.pos.forms.ProcessAction;
import com.choranet.pos.inventory.MovementReason;
import com.choranet.pos.inventory.TaxCategoryInfo;
import com.choranet.pos.ticket.CategoryInfo;
import com.choranet.pos.ticket.ProductInfoExt;
import com.choranet.pos.ticket.TaxInfo;
import com.choranet.ws.customers.Customer;
import com.choranet.ws.externalsales.Product;
import com.choranet.ws.externalsales.ProductPlus;
import java.util.Date;
import java.util.UUID;

public class ProductsSync implements ProcessAction {
        
    private DataLogicSystem dlsystem;
    private DataLogicIntegration dlintegration;
    private DataLogicSales dlsales;
    private String warehouse;
    private ExternalSalesHelper externalsales;
    
    /** Creates a new instance of ProductsSync */
    public ProductsSync(DataLogicSystem dlsystem, DataLogicIntegration dlintegration, DataLogicSales dlsales, String warehouse) {
        this.dlsystem = dlsystem;
        this.dlintegration = dlintegration;
        this.dlsales = dlsales;
        this.warehouse = warehouse;
        externalsales = null;
    }
    
    public MessageInf execute() throws BasicException {
        
        try {
        
            if (externalsales == null) {
                externalsales = new ExternalSalesHelper(dlsystem);
            }
            
            Product[] products = externalsales.getProductsCatalog();
            Customer[] customers = externalsales.getCustomers();

            if (products == null || customers == null){
                throw new BasicException(AppLocal.getIntString("message.returnnull"));
            }     
            
            if (products.length > 0){
                
                dlintegration.syncProductsBefore();
                
                Date now = new Date();
                
                for (Product product : products) {
                    
                    // Synchonization of taxcategories
                    TaxCategoryInfo tc = new TaxCategoryInfo();
                    tc.setID(product.getTax().getId());
                    tc.setName(product.getTax().getName());                     
                    dlintegration.syncTaxCategory(tc);
                    
                    // Synchonization of taxes
                    TaxInfo t = new TaxInfo();
                    t.setID(product.getTax().getId());
                    t.setName(product.getTax().getName());
                    t.setTaxCategoryID(tc.getID());
                    t.setRate(product.getTax().getPercentage() / 100);   
                    t.setCascade(false);
                    dlintegration.syncTax(t);
                   
                    // Synchonization of categories
                    CategoryInfo c = new CategoryInfo();
                    c.setID(product.getCategory().getId());
                    c.setName(product.getCategory().getName());
                    c.setImage(null);                        
                    dlintegration.syncCategory(c);

                    // Synchonization of products
                    ProductInfoExt p = new ProductInfoExt();
                    p.setID(product.getId());
                    p.setReference(product.getId());
                    p.setCode(product.getEan() == null || product.getEan().equals("") ? product.getId() : product.getEan());
                    p.setName(product.getName());
                    p.setCom(false);
                    p.setScale(false);
                    p.setPriceBuy(product.getPurchasePrice());
                    p.setPriceSell(product.getListPrice());
                    p.setCategoryID(c.getID());
                    p.setTaxCategoryInfo(tc);
                    p.setImage(ImageUtils.readImage(product.getImageUrl()));
                    dlintegration.syncProduct(p);  
                    
                    // Synchronization of stock          
                    if (product instanceof ProductPlus) {
                        
                        ProductPlus productplus = (ProductPlus) product;
                        
                        double diff = productplus.getQtyonhand() - dlsales.findProductStock(p.getID(), warehouse);
                        
                        Object[] diary = new Object[7];
                        diary[0] = UUID.randomUUID().toString();
                        diary[1] = now;
                        diary[2] = diff > 0.0 
                                ? MovementReason.IN_MOVEMENT.getKey()
                                : MovementReason.OUT_MOVEMENT.getKey();
                        diary[3] = warehouse;
                        diary[4] = p.getID();
                        diary[5] = new Double(diff);
                        diary[6] = new Double(p.getPriceBuy());                                
                        dlsales.getStockDiaryInsert().exec(diary);   
                    }
                }
                
                // datalogic.syncProductsAfter();
            }
            
            if (customers.length > 0 ) {
                
                dlintegration. syncCustomersBefore();
                
                for (Customer customer : customers) {                    
                    CustomerInfoExt cinfo = new CustomerInfoExt(customer.getId());
                    cinfo.setSearchkey(customer.getSearchKey());
                    cinfo.setName(customer.getName());          
                    cinfo.setNotes(customer.getDescription());
                    // TODO: Finish the integration of all fields.
                    dlintegration.syncCustomer(cinfo);
                }
            }
            
            if (products.length == 0 && customers.length == 0) {
                return new MessageInf(MessageInf.SGN_NOTICE, AppLocal.getIntString("message.zeroproducts"));               
            } else {
                return new MessageInf(MessageInf.SGN_SUCCESS, AppLocal.getIntString("message.syncproductsok"), AppLocal.getIntString("message.syncproductsinfo", products.length, customers.length));
            }
                
        } catch (ServiceException e) {            
            throw new BasicException(AppLocal.getIntString("message.serviceexception"), e);
        } catch (RemoteException e){
            throw new BasicException(AppLocal.getIntString("message.remoteexception"), e);
        } catch (MalformedURLException e){
            throw new BasicException(AppLocal.getIntString("message.malformedurlexception"), e);
        }
    }   
}
