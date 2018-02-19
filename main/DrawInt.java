package main;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public final class DrawInt implements Drawer {
    private static DrawInt ourInstance = new DrawInt();
    private static final int THREE = 3;
    public static DrawInt getInstance() {
        return ourInstance;
    }

    private DrawInt() {
    }
    public void draw(final Line l, final BufferedImage pic) {
    }
    public void draw(final Square s, final BufferedImage pic) {
        int x, y, l;
        x = s.getX();
        y = s.getY();
        l = s.getL();

        int xg = Math.min(pic.getWidth() - 1, x + l / 2);
        int yg = Math.min(pic.getHeight() - 1, y + l / 2);
        if (x == pic.getWidth() - 1) {
             xg = x + 1;
        }
        if (y == pic.getHeight() - 1) {
            yg = y + 1;
        }
        flood(xg, yg, s.getRGBext(), s.getRGBint(), pic);
    }
    public void draw(final Rectangle r, final BufferedImage pic) {
        int x, y, h, w;
        x = r.getX();
        y = r.getY();
        h = r.getHeight();
        w = r.getLength();

        int xg = Math.min(pic.getWidth() - 1, x + w / 2);
        int yg = Math.min(pic.getHeight() - 1, y + h / 2);
        if (x == pic.getWidth() - 1) {
            xg = x + 1;
        }
        if (y == pic.getHeight() - 1) {
            yg = y + 1;
        }
        flood(xg, yg, r.getRGBext(), r.getRGBint(), pic);
    }
    public void draw(final Circle c, final BufferedImage pic) {
        int xg, yg;
        xg = c.getX();
        yg = c.getY();

        xg = Math.min(xg, pic.getWidth() - 1);
        yg = Math.min(yg, pic.getHeight() - 1);

        flood(xg, yg, c.getRGBext(), c.getRGBint(), pic);
    }
    public void draw(final Triangle t, final BufferedImage pic) {
        int x1, x2, x3;
        int y1, y2, y3;
        int xg, yg;

        x1 = t.getX1();
        y1 = t.getY1();
        x2 = t.getX2();
        y2 = t.getY2();
        x3 = t.getX3();
        y3 = t.getY3();

        xg = (x1 + x2 + x3) / THREE;
        yg = (y1 + y2 + y3) / THREE;

        xg = Math.min(xg, pic.getWidth() - 1);
        yg = Math.min(yg, pic.getHeight() - 1);

        flood(xg, yg, t.getRGBext(), t.getRGBint(), pic);

    }
    public void draw(final Diamond d, final BufferedImage pic) {
        int xg, yg;
        xg = d.getX();
        yg = d.getY();

        xg = Math.min(xg, pic.getWidth() - 1);
        yg = Math.min(yg, pic.getHeight() - 1);

        flood(xg, yg, d.getRGBext(), d.getRGBint(), pic);
    }
    public void draw(final Poly p, final BufferedImage pic) {
        int n = p.getN();
        Point[] points = p.getPoints();
        int xg = 0, yg = 0;

        for (int i = 0; i < n; ++i) {
            xg += points[i].getX();
        }
        xg /= n;

        for (int i = 0; i < n; ++i) {
            yg += points[i].getY();
        }
        yg /= n;

        xg = Math.min(pic.getWidth(), xg);
        yg = Math.min(pic.getHeight(), yg);

        flood(xg, yg, p.getRGBext(), p.getRGBint(), pic);
    }
    public void draw(final Canvas c, final BufferedImage pic) {
        int h = c.getLength();
        int w = c.getWidth();
        //System.out.println("asasd");
        //System.out.println(h + " " + w);
        //System.out.println(c.getRGB());
        for (int i = 0; i < w; ++i) {
            for (int j = 0; j < h; ++j) {
                pic.setRGB(i, j, c.getRGB());
            }
        }
    }

    public void flood(final int xs, final int ys,
            final int limits, final int rgb, final BufferedImage pic) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int dir = THREE;
        int x, y, nx, ny;
        Queue<Point> q = new LinkedList<Point>();
        Point p = new Point(xs, ys);
        q.add(p);
        while (!q.isEmpty()) {
            p = q.remove();
            x = p.getX();
            y = p.getY();
            //System.out.println(x + " " + y);
            for (int i = 0; i <= dir; ++i) {
                nx = x + dx[i];
                ny = y + dy[i];
               // System.out.println(nx + " " + ny);
                if (checkPic(nx, ny, limits, rgb, pic)) {
                    q.add(new Point(nx, ny));
                    pic.setRGB(nx, ny, rgb);
                }
            }
        }
    }

    boolean checkPic(final int x, final int y,
            final int limits, final int rgb, final BufferedImage pic) {
        if (x < 0 || x >= pic.getWidth()) {
            return false;
        }

        if (y < 0 || y >= pic.getHeight()) {
            return false;
        }

        int prgb = pic.getRGB(x, y);
        //System.out.println(prgb + " " + rgb + " " + limits);
        if (prgb == limits) {
            return false;
        }

        if (prgb == rgb) {
            //System.out.println("nu colorez ca am colorat deja");
            return false;
        }

        //System.out.println("BAGA IN COADA\n");
        return true;
    }
    boolean checkDraw(final int x, final int y, final BufferedImage pic) {
        if (x >= pic.getWidth() || y >= pic.getHeight()) {
            return false;
        }
        return true;
    }
}
