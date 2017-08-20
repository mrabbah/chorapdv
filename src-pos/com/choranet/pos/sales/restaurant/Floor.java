//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.sales.restaurant;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import com.choranet.basic.BasicException;
import com.choranet.data.loader.DataRead;
import com.choranet.data.loader.ImageUtils;
import com.choranet.data.loader.SerializableRead;
import com.choranet.pos.util.ThumbNailBuilder;
import java.awt.ComponentOrientation;

public class Floor implements SerializableRead {
    
    private String m_sID;
    private String m_sName;
    private Container m_container;
    private Icon m_icon;
    
    private static Image defimg = null;
    
    /** Creates a new instance of Floor */
    public Floor() {
        try {
            defimg = ImageIO.read(getClass().getClassLoader().getResourceAsStream("com/choranet/images/atlantikdesigner.png"));
        } catch (Exception fnfe) {
        }            
    }

    public void readValues(DataRead dr) throws BasicException {
        m_sID = dr.getString(1);
        m_sName = dr.getString(2);
        BufferedImage img = ImageUtils.readImage(dr.getBytes(3));
        ThumbNailBuilder tnbcat = new ThumbNailBuilder(32, 32, defimg);
        m_container = new JPanelDrawing(img);
        m_icon = new ImageIcon(tnbcat.getThumbNail(img));        
    }    
    
    public String getID() {
        return m_sID;
    }
    public String getName() {
        return m_sName;
    }
    public Icon getIcon() {
        return m_icon;
    }    
    public Container getContainer() {
        return m_container;
    }    
    
    private static class JPanelDrawing extends JPanel {
        private Image img;
        
        public JPanelDrawing(Image img) {
            this.img = img;
            setLayout(null);
        }
        
        protected void paintComponent (Graphics g) { 
            super.paintComponent(g);
            if (img != null) {
                g.drawImage(img, 0, 0, this);
            }
        }
        
        public Dimension getPreferredSize() {
            return (img == null) 
                ? new Dimension(640, 480) 
                : new Dimension(img.getWidth(this), img.getHeight(this));
        }
        public Dimension getMinimumSize() {
            return getPreferredSize();
        }
        public Dimension getMaximumSize() {
            return getPreferredSize();
        }
    }    
}
