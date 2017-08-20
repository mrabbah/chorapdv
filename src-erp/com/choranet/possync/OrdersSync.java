//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.possync;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;
import javax.xml.rpc.ServiceException;
import com.choranet.basic.BasicException;
import com.choranet.data.gui.MessageInf;
import com.choranet.pos.forms.AppLocal;
import com.choranet.pos.forms.DataLogicSystem;
import com.choranet.pos.forms.ProcessAction;
import com.choranet.pos.payment.PaymentInfo;
import com.choranet.pos.ticket.TicketInfo;
import com.choranet.pos.ticket.TicketLineInfo;
import com.choranet.ws.externalsales.BPartner;
import com.choranet.ws.externalsales.Order;
import com.choranet.ws.externalsales.OrderIdentifier;
import com.choranet.ws.externalsales.OrderLine;
import com.choranet.ws.externalsales.Payment;


public class OrdersSync implements ProcessAction {
     
    private DataLogicSystem dlsystem;
    private DataLogicIntegration dlintegration;
    private ExternalSalesHelper externalsales;
    
    /** Creates a new instance of OrdersSync */
    public OrdersSync(DataLogicSystem dlsystem, DataLogicIntegration dlintegration) {
        this.dlsystem = dlsystem;
        this.dlintegration = dlintegration;
        externalsales = null;
    }
    
    public MessageInf execute() throws BasicException {        
        
        try {
        
            if (externalsales == null) {
                externalsales = new ExternalSalesHelper(dlsystem);
            }
            
            // Obtenemos los tickets
            List<TicketInfo> ticketlist = dlintegration.getTickets();
            for (TicketInfo ticket : ticketlist) {
                ticket.setLines(dlintegration.getTicketLines(ticket.getId()));
                ticket.setPayments(dlintegration.getTicketPayments(ticket.getId()));
            }
            
            if (ticketlist.size() == 0) {
                
                return new MessageInf(MessageInf.SGN_NOTICE, AppLocal.getIntString("message.zeroorders"));
            } else {

                // transformo tickets en ordenes
                Order[] orders = transformTickets(ticketlist);

                //uploads orders and return boolean as a result
                if(!externalsales.uploadOrders(orders))
                    throw new BasicException(AppLocal.getIntString("message.returnnull"));

                // actualizo los tickets como subidos
                dlintegration.execTicketUpdate();

                return new MessageInf(MessageInf.SGN_SUCCESS, AppLocal.getIntString("message.syncordersok"), AppLocal.getIntString("message.syncordersinfo", orders.length));
            }

        } catch (ServiceException e) {            
            throw new BasicException(AppLocal.getIntString("message.serviceexception"), e);
        } catch (RemoteException e){
            throw new BasicException(AppLocal.getIntString("message.remoteexception"), e);
        } catch (MalformedURLException e){
            throw new BasicException(AppLocal.getIntString("message.malformedurlexception"), e);
        }
    }  
    
    private Order[] transformTickets(List<TicketInfo> ticketlist) {

        // Transformamos de tickets a ordenes
        Order[] orders = new Order[ticketlist.size()];
        for (int i = 0; i < ticketlist.size(); i++) {
            TicketInfo ticket = ticketlist.get(i);

            orders[i] = new Order();

            OrderIdentifier orderid = new OrderIdentifier();
            Calendar datenew = Calendar.getInstance();
            datenew.setTime(ticket.getDate());
            orderid.setDateNew(datenew);
            orderid.setDocumentNo(Integer.toString(ticket.getTicketId()));

            orders[i].setOrderId(orderid);
            orders[i].setState(800175);
            
            // set the business partner
            BPartner bp;
            if (ticket.getCustomerId() == null) {
                bp = null;
            } else {
                bp = new BPartner();
                bp.setId(ticket.getCustomer().getSearchkey());
                bp.setName(ticket.getCustomer().getName());
            }
            orders[i].setBusinessPartner(bp);

            //Saco las lineas del pedido
            OrderLine[] orderLine = new OrderLine[ticket.getLines().size()];
            for (int j = 0; j < ticket.getLines().size(); j++){
                TicketLineInfo line = ticket.getLines().get(j);

                orderLine[j] = new OrderLine();
                orderLine[j].setOrderLineId(String.valueOf(line.getTicketLine()));// o simplemente "j"
                if (line.getProductID() == null) {
                    orderLine[j].setProductId("0");
                } else {
                    orderLine[j].setProductId(line.getProductID()); // capturar error
                }
                orderLine[j].setUnits(line.getMultiply());
                orderLine[j].setPrice(line.getPrice());
                orderLine[j].setTaxId(line.getTaxInfo().getId());     
            }
            orders[i].setLines(orderLine);

            //Saco las lineas de pago
            Payment[] paymentLine = new Payment[ticket.getPayments().size()];
            for (int j = 0; j < ticket.getPayments().size(); j++){       
                PaymentInfo payment = ticket.getPayments().get(j);

                paymentLine[j] = new Payment();
                paymentLine[j].setAmount(payment.getTotal());
                if ("magcard".equals(payment.getName())) {
                    paymentLine[j].setPaymentType("K");
                } else if ("cheque".equals(payment.getName())) {
                    paymentLine[j].setPaymentType("2");
                } else if ("cash".equals(payment.getName())) {
                    paymentLine[j].setPaymentType("B");
                } else {
                    paymentLine[j].setPaymentType(null); // unknown
                }        
            }     
            orders[i].setPayment(paymentLine);                    
        }
        
        return orders;
    }
    
    private static int parseInt(String sValue) {
        
        try {
            return Integer.parseInt(sValue); 
        } catch (NumberFormatException eNF) {
            return 0;
        }
    }
}
