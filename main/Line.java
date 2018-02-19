package main;

import java.awt.image.BufferedImage;

public final class Line implements Shape {
    private int xs;
    private int ys;
    private int xf;
    private int yf;
    private int rgb;

    Line(final int xs, final int ys, final int xf, final int yf, final int rgb) {
        this.xs = xs;
        this.ys = ys;
        this.xf = xf;
        this.yf = yf;
        this.rgb = rgb;
    }

    public int getXs() {
        return xs;
    }

    public void setXs(final int xs) {
        this.xs = xs;
    }

    public int getYs() {
        return ys;
    }

    public void setYs(final int ys) {
        this.ys = ys;
    }

    public int getXf() {
        return xf;
    }

    public void setXf(final int xf) {
        this.xf = xf;
    }

    public int getYf() {
        return yf;
    }

    public void setYf(final int yf) {
        this.yf = yf;
    }

    public int getRGB() {
        return rgb;
    }

    public void setRGB(final int argb) {
        this.rgb = argb;
    }

    public void accept(final Drawer d, final BufferedImage pic) {
        d.draw(this, pic);
    }
}
