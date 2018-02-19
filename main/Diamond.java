package main;

import java.awt.image.BufferedImage;

public final class Diamond implements Shape {
    private int x;
    private int y;
    private int height;
    private int length;
    private int rgbint;
    private int rgbext;

    Diamond(final int x, final int y, final int length,
        final int height, final int rgbext, final int rgbint) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.height = height;
        this.rgbext = rgbext;
        this.rgbint = rgbint;
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

    public int getRGBint() {
        return rgbint;
    }

    public void setRGBint(final int argbint) {
        this.rgbint = argbint;
    }

    public int getRGBext() {
        return rgbext;
    }

    public void setRGBext(final int argbext) {
        this.rgbext = argbext;
    }

    public void accept(final Drawer d, final BufferedImage pic) {
        d.draw(this, pic);
    }
}
