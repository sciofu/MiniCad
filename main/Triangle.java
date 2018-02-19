package main;

import java.awt.image.BufferedImage;

public final class Triangle implements Shape {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int x3;
    private int y3;
    private int aRGBint;
    private int aRGBext;

    Triangle(final int x1, final int y1, final int x2, final int y2,
            final int x3, final int y3, final int aRGBext, final int aRGBint) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.aRGBext = aRGBext;
        this.aRGBint = aRGBint;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(final int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(final int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(final int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(final int y2) {
        this.y2 = y2;
    }

    public int getX3() {
        return x3;
    }

    public void setX3(final int x3) {
        this.x3 = x3;
    }

    public int getY3() {
        return y3;
    }

    public void setY3(final int y3) {
        this.y3 = y3;
    }

    public int getRGBint() {
        return aRGBint;
    }

    public void setRGBint(final int rGBint) {
        this.aRGBint = rGBint;
    }

    public int getRGBext() {
        return aRGBext;
    }

    public void setRGBext(final int rGBext) {
        this.aRGBext = rGBext;
    }

    public void accept(final Drawer d, final BufferedImage pic) {
        d.draw(this, pic);
    }
}
