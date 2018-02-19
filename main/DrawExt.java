package main;

import java.awt.image.BufferedImage;

public final class DrawExt implements Drawer {
    private static DrawExt ourInstance = new DrawExt();
    static final int THREE = 3, FOUR = 4, TEN = 10, SIX = 6;
    public static DrawExt getInstance() {
            return ourInstance;
    }

    private DrawExt() {
    }

    @Override
    public void draw(final Line l, final BufferedImage pic) {
            int x1, y1, x2, y2, rgb;
            x1 = l.getXs();
            y1 = l.getYs();
            x2 = l.getXf();
            y2 = l.getYf();
            rgb = l.getRGB();
            line(x1, y1, x2, y2, rgb, pic);
    }

    @Override
    public void draw(final Square s, final BufferedImage pic) {
            int x, y, l, rgbe;
            x = s.getX();
            y = s.getY();
            l = s.getL();
            rgbe = s.getRGBext();
            line(x, y, x + l - 1, y, rgbe, pic);
            line(x, y, x, y + l - 1, rgbe, pic);
            line(x + l - 1, y, x + l - 1, y + l - 1, rgbe, pic);
            line(x, y + l - 1, x + l - 1, y + l - 1, rgbe, pic);
    }

    @Override
    public void draw(final Rectangle r, final BufferedImage pic) {
            int x, y, h, w, rgbe;
            x = r.getX();
            y = r.getY();
            h = r.getHeight();
            w = r.getLength();
            rgbe = r.getRGBext();
            if (checkDraw(x, y, pic)) {
                line(x, y, x + w - 1, y, rgbe, pic);
                line(x, y, x, y + h - 1, rgbe, pic);
                line(x + w - 1, y, x + w - 1, y + h - 1, rgbe, pic);
                line(x, y + h - 1, x + w - 1, y + h - 1, rgbe, pic);
            }
    }
    @Override
    public void draw(final Circle c, final BufferedImage pic) {
            int x, y, r, rgb;
            x = c.getX();
            y = c.getY();
            r = c.getR();
            rgb = c.getRGBext();

            circle(x, y, r, rgb, pic);
    }

    @Override
    public void draw(final Triangle t, final BufferedImage pic) {
            int x1, y1, x2, y2, x3, y3;
            int rgbe;

            x1 = t.getX1();
            y1 = t.getY1();
            x2 = t.getX2();
            y2 = t.getY2();
            x3 = t.getX3();
            y3 = t.getY3();
            rgbe = t.getRGBext();

            line(x1, y1, x2, y2, rgbe, pic);
            line(x2, y2, x3, y3, rgbe, pic);
            line(x3, y3, x1, y1, rgbe, pic);
    }

    @Override
    public void draw(final Diamond d, final BufferedImage pic) {
            int x, y, dh, dw, rgbe;

            x = d.getX();
            y = d.getY();
            dw = d.getLength();
            dh = d.getHeight();
            rgbe = d.getRGBext();

            line(x, y - dh / 2, x - dw / 2, y, rgbe, pic);
            line(x, y - dh / 2, x + dw / 2, y, rgbe, pic);
            line(x + dw / 2, y, x, y + dh / 2, rgbe, pic);
            line(x, y + dh / 2, x - dw / 2, y, rgbe, pic);
    }

    @Override
    public void draw(final Poly p, final BufferedImage pic) {
            int n, rgbe;
            Point[] points = p.getPoints();
            n = p.getN();
            rgbe = p.getRGBext();
            for (int i = 0; i < n - 1; ++i) {
                line(points[i].getX(), points[i].getY(),
                        points[i + 1].getX(), points[i + 1].getY(), rgbe, pic);
            }

            line(points[n - 1].getX(), points[n - 1].getY(),
                    points[0].getX(), points[0].getY(), rgbe, pic);
    }

    @Override
    public void draw(final Canvas c, final BufferedImage pic) {

    }

    void line(final int x1, final int y1, final int x2,
            final int y2, final int rgb, final BufferedImage pic) {
            //System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
            int x, y, dx, dy, s1, s2, aux;
            boolean interchange;
            x = x1;
            y = y1;
            dx = Math.abs(x2 - x1);
            dy = Math.abs(y2 - y1);
            s1 = getSign(x2 - x1);
            s2 = getSign(y2 - y1);

            //System.out.println(dx + " " + dy);

            if (dy > dx) {
                aux = dx;
                dx = dy;
                dy = aux;
                interchange = true;
            } else {
                interchange = false;
            }

            int error = 2 * dy - dx;
            //System.out.println(dx + " " + dy);
            for (int i = 0; i <= dx; ++i) {
                //System.out.println(x + " " + y);
                if (x < pic.getWidth() && y < pic.getHeight()) {
                        if (x >= 0 && y >= 0) {
                            pic.setRGB(x, y, rgb);
                        }
                }
                while (error > 0) {
                        if (interchange) {
                            x += s1;
                        } else {
                            y += s2;
                        }
                        error -= 2 * dx;
                }

                if (interchange) {
                        y += s2;
                } else {
                        x += s1;
                }

                error += 2 * dy;
            }
    }

    int getSign(final int x) {
            if (x < 0) {
                return -1;
            }

            if (x > 0) {
                return 1;
            }

            return 0;
    }

    void circle(final int xc, final int yc, final int r, final int rgb, final BufferedImage pic) {
            int x = 0, y = r;
            int d = THREE - 2 * r;
            while (y >= x) {
                setCircle(xc, yc, x, y, rgb, pic);
                x++;

                if (d > 0) {
                        --y;
                        d = d + FOUR * (x - y) + TEN;
                } else {
                        d = d +  FOUR * x + SIX;
                }
                setCircle(xc, yc, x, y, rgb, pic);
            }
    }

    void setCircle(final int xc, final int yc, final int x,
            final int y, final int rgb, final BufferedImage pic) {
            checkNset(xc + x, yc + y, rgb, pic);
            checkNset(xc - x, yc + y, rgb, pic);
            checkNset(xc + x, yc - y, rgb, pic);
            checkNset(xc - x, yc - y, rgb, pic);
            checkNset(xc + y, yc + x, rgb, pic);
            checkNset(xc - y, yc + x, rgb, pic);
            checkNset(xc + y, yc - x, rgb, pic);
            checkNset(xc - y, yc - x, rgb, pic);
    }

    void checkNset(final int x, final int y, final int rgb, final BufferedImage pic) {
            if (x < pic.getWidth() && y < pic.getHeight()) {
                if (x >= 0 && y >= 0) {
                        pic.setRGB(x, y, rgb);
                }
            }
    }

    boolean checkDraw(final int x, final int y, final BufferedImage pic) {
        if (x >= pic.getWidth() || y >= pic.getHeight()) {
            return false;
        }
        return true;
    }
}
