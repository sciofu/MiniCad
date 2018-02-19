package main;

public interface Factory {
    Shape createShape(ShapeNames sn, String input);
}
