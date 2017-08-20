//    CHORA POS is a point of sales application designed for touch screens.
//    Copyright (C) 2010-2011 CHORA INFORMATIQUE, SARL.
//    http://www.choranet.com

package com.choranet.pos.printer.ticket;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import com.choranet.pos.printer.screen.*;

public class PrintItemImage implements PrintItem {

    protected BufferedImage image;
    protected double scale;

    /** Creates a new instance of PrintItemImage
     * @param image
     */
    public PrintItemImage(BufferedImage image, double scale) {
        this.image = image;
        this.scale = scale;
    }

    @Override
    public void draw(Graphics2D g, int x, int y, int width) {
        g.drawImage(image, x + (width - (int)(image.getWidth() * scale)) / 2, y, (int)(image.getWidth() * scale), (int)(image.getHeight() * scale), null);
    }

    @Override
    public int getHeight() {
        return (int) (image.getHeight() * scale);
    }
}
