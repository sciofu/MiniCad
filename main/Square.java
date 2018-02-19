package main;

import java.awt.image.BufferedImage;

public final class Square implements Shape {
    private int x;
    private int y;
    private int l;
    private int aRGBext;
    private int aRGBint;
    Square(final int x, final int y, final int l, final int aRGBext, final int aRGBint) {
        this.x = x;
        this.y = y;
        this.l = l;
        this.aRGBext = aRGBext;
        this.aRGBint = aRGBint;
    }

    public int getX() {
        return x;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(final int y) {
        this.y = y;
    }

    public int getL() {
        return l;
    }

    public void setL(final int l) {
        this.l = l;
    }

    public int getRGBext() {
        return aRGBext;
    }

    public void setRGBext(final int aRGB) {
        this.aRGBext = aRGB;
    }

    public void accept(final Drawer d, final BufferedImage pic) {
        d.draw(this, pic);
    }

    public int getRGBint() {
        return aRGBint;
    }

    public void setRGBint(final int rGBint) {
        this.aRGBint = rGBint;
    }

}
