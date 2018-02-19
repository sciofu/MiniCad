package main;

import java.awt.image.BufferedImage;

public interface Drawer {
    void draw(Line l, BufferedImage pic);
    void draw(Square s, BufferedImage pic);
    void draw(Rectangle r, BufferedImage pic);
    void draw(Circle c, BufferedImage pic);
    void draw(Triangle t, BufferedImage pic);
    void draw(Diamond d, BufferedImage pic);
    void draw(Poly p, BufferedImage pic);
    void draw(Canvas c, BufferedImage pic);
}

