//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.forms;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.choranet.basic.BasicException;
import com.choranet.data.loader.Session;
import com.choranet.pos.util.AltEncrypter;

/**
 *
 * @author adrianromero
 */
public class AppViewConnection {
    
    /** Creates a new instance of AppViewConnection */
    private AppViewConnection() {
    }
    
    public static Session createSession(AppProperties props) throws BasicException {
               
        // Inicializo la conexion contra la base de datos.
        try {   
            
            ClassLoader cloader = new URLClassLoader(new URL[] {new File(props.getProperty("db.driverlib")).toURI().toURL()});
            DriverManager.registerDriver(new DriverWrapper((Driver) Class.forName(props.getProperty("db.driver"), true, cloader).newInstance()));            
            
            String sDBUser = props.getProperty("db.user");
            String sDBPassword = props.getProperty("db.password");        
            if (sDBUser != null && sDBPassword != null && sDBPassword.startsWith("crypt:")) {
                // La clave esta encriptada.
                AltEncrypter cypher = new AltEncrypter("cypherkey" + sDBUser);
                sDBPassword = cypher.decrypt(sDBPassword.substring(6));
            }   

             return new Session(props.getProperty("db.URL"), sDBUser,sDBPassword);     

        } catch (InstantiationException e) {
            throw new BasicException(AppLocal.getIntString("message.databasedrivererror"), e);
        } catch (IllegalAccessException eIA) {
            throw new BasicException(AppLocal.getIntString("message.databasedrivererror"), eIA);
        } catch (MalformedURLException eMURL) {
            throw new BasicException(AppLocal.getIntString("message.databasedrivererror"), eMURL);
        } catch (ClassNotFoundException eCNF) {
            throw new BasicException(AppLocal.getIntString("message.databasedrivererror"), eCNF);
        } catch (SQLException eSQL) {
            throw new BasicException(AppLocal.getIntString("message.databaseconnectionerror"), eSQL);
        }   
    }
}
