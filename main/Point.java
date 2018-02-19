package main;

public final class Point {
    private int x;
    private int y;

    Point() {

    }
    Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
    int getX() {
        return x;
    }

    void setX(final int x) {
        this.x = x;
    }

    int getY() {
        return y;
    }

    void setY(final int y) {
        this.y = y;
    }
}
