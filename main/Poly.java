package main;

import java.awt.image.BufferedImage;

public final class Poly  implements Shape {
    static final int DIM = 20000;
    private int n;
    private Point[] points;
    private int aRGBext;
    private int aRGBint;

    Poly(final int n, final Point[] points, final int aRGBext, final int aRGBint) {
        this.n = n;
        this.points = points;
        this.aRGBext = aRGBext;
        this.aRGBint = aRGBint;
    }

    public int getN() {
        return n;
    }

    public void setN(final int n) {
        this.n = n;
    }

    public Point[] getPoints() {
        return points;
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

    public void setRGBint(final int rGBint) {
        this.aRGBint = rGBint;
    }

    public void accept(final Drawer d, final BufferedImage pic) {
        d.draw(this, pic);
    }
}
