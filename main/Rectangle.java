package main;

import java.awt.image.BufferedImage;

public final class Rectangle implements Shape {
    private int x;
    private int y;
    private int height;
    private int length;
    private int aRGBext;
    private int aRGBint;

    Rectangle(final int x, final int y, final int height,
            final int length, final int aRGBext, final int aRGBint) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.length = length;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(final int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(final int length) {
        this.length = length;
    }

    public int getRGBext() {
        return aRGBext;
    }

    public void setaRGBext(final int rGBext) {
        this.aRGBext = rGBext;
    }

    public int getRGBint() {
        return aRGBint;
    }

    public void setRGBint(final int rGBint) {
        this.aRGBint = rGBint;
    }

    public void accept(final Drawer d, final BufferedImage pic) {
        d.draw(this, pic);
    }
}
