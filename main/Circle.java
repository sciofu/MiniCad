package main;

import java.awt.image.BufferedImage;

public final class Circle implements Shape {
    private int x;
    private int y;
    private int r;
    private int aRGBext;
    private int aRGBint;

    Circle(final int x, final  int y, final int r, final int aRGBext, final int aRGBint) {
        this.x = x;
        this.y = y;
        this.r = r;
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

    public int getR() {
        return r;
    }

    public void setR(final int r) {
        this.r = r;
    }

    public int getRGBext() {
        return aRGBext;
    }

    public void setRGBext(final int rGBext) {
        this.aRGBext = rGBext;
    }

    public int getRGBint() {
        return aRGBint;
    }

    public void setRGBint(final int arGBint) {
        this.aRGBint = arGBint;
    }

    public void accept(final Drawer d, final BufferedImage pic) {
        d.draw(this, pic);
    }
}
