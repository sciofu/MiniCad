package main;

import java.awt.image.BufferedImage;

public interface Shape {
    void accept(Drawer d, BufferedImage pic);
}
