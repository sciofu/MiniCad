package main;

import java.awt.image.BufferedImage;

public final class Canvas implements Shape {
    private int length;
    private int width;
    private int aRGB;

    Canvas(final int length, final int width, final int aRGB) {
        this.length = length;
        this.width = width;
        this.aRGB = aRGB;
    }

    public void setWidth(final int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(final int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public int getRGB() {
        return aRGB;
    }

    public void setRGB(final int rGB) {
        this.aRGB = rGB;
    }
    public void accept(final Drawer d, final BufferedImage pic) {
        d.draw(this, pic);
    }
}
