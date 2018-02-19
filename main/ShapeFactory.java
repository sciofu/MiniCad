package main;

public final class ShapeFactory implements Factory {
    private static ShapeFactory ourInstance = new ShapeFactory();
    static final int THREE = 3, FOUR = 4, SIXTEEN = 16, FIVE = 5;
    static final int TWOFOUR = 24, SIX = 6, SEVEN = 7, EIGHT = 8;
    static final int BIG = 20000, TEN = 10, NINE = 9;
    public static ShapeFactory getInstance() {
        return ourInstance;
    }

    private ShapeFactory() {
    }

    public Shape createShape(final ShapeNames sn, final String input) {
        if (sn == ShapeNames.CIRCLE) {
            String[] split = input.split("\\s+");
            int x, y, r, rgbo, ao, rgbi, ai;

            x = Integer.valueOf(split[1]);
            y = Integer.valueOf(split[2]);
            r = Integer.valueOf(split[THREE]);
            rgbo = Integer.parseInt(split[FOUR].substring(1), SIXTEEN);
            ao = Integer.parseInt(split[FIVE]);
            rgbo += (ao << TWOFOUR);
            rgbi = Integer.parseInt(split[SIX].substring(1), SIXTEEN);
            ai = Integer.parseInt(split[SEVEN]);
            rgbi += (ai << TWOFOUR);
            return new Circle(x, y, r, rgbo, rgbi);
        }

        if (sn == ShapeNames.DIAMOND) {
            String[] split = input.split("\\s+");
            int x, y, dh, dw, rgbo, ao, rgbi, ai;

            x = Integer.valueOf(split[1]);
            y = Integer.valueOf(split[2]);
            dw = Integer.valueOf(split[THREE]);
            dh = Integer.valueOf(split[FOUR]);

            rgbo = Integer.parseInt(split[FIVE].substring(1), SIXTEEN);
            ao = Integer.parseInt(split[SIX]);
            rgbo += (ao << TWOFOUR);

            rgbi = Integer.parseInt(split[SEVEN].substring(1), SIXTEEN);
            ai = Integer.parseInt(split[EIGHT]);
            rgbi += (ai << TWOFOUR);

            return new Diamond(x, y, dw, dh, rgbo, rgbi);
        }

        if (sn == ShapeNames.LINE) {
            String[] split = input.split("\\s+");
            int x1 = Integer.valueOf(split[1]);
            int y1 = Integer.valueOf(split[2]);
            int x2 = Integer.valueOf(split[THREE]);
            int y2 = Integer.valueOf(split[FOUR]);
            int rgb = Integer.parseInt(split[FIVE].substring(1), SIXTEEN);
            int alpha = Integer.parseInt(split[SIX]);
            rgb += (alpha << TWOFOUR);

            return new Line(x1, y1, x2, y2, rgb);
        }

        if (sn == ShapeNames.POLY) {
            String[] split = input.split("\\s+");
            int n = Integer.valueOf(split[1]);
            Point[] point = new Point[BIG];
            int x, y;
            for (int i = 0; i < n; ++i) {
                x = Integer.valueOf(split[2 * i + 2]);
                y = Integer.valueOf(split[2 * i + THREE]);
                point[i] = new Point(x, y);
            }

            int rgbo, ao, rgbi, ai;

            rgbo = Integer.parseInt(split[2 * n + 2].substring(1), SIXTEEN);
            ao = Integer.parseInt(split[2 * n + THREE]);
            rgbo += (ao << TWOFOUR);

            rgbi = Integer.parseInt(split[2 * n + FOUR].substring(1), SIXTEEN);
            ai = Integer.parseInt(split[2 * n + FIVE]);
            rgbi += (ai << TWOFOUR);

            return new Poly(n, point, rgbo, rgbi);
        }

        if (sn == ShapeNames.RECTANGLE) {
            String[] split = input.split("\\s+");
            int x, y, w, h;
            x = Integer.valueOf(split[1]);
            y = Integer.valueOf(split[2]);
            h = Integer.valueOf(split[THREE]);
            w = Integer.valueOf(split[FOUR]);

            int rgbo, ao, rgbi, ai;

            rgbo = Integer.parseInt(split[FIVE].substring(1), SIXTEEN);
            ao = Integer.parseInt(split[SIX]);
            rgbo += (ao << TWOFOUR);

            rgbi = Integer.parseInt(split[SEVEN].substring(1), SIXTEEN);
            ai = Integer.parseInt(split[EIGHT]);
            rgbi += (ai << TWOFOUR);

            return new Rectangle(x, y, h, w, rgbo, rgbi);
        }

        if (sn == ShapeNames.SQUARE) {
            String[] split = input.split("\\s+");
            int x, y, l, rgbo, ao, rgbi, ai;
            x = Integer.valueOf(split[1]);
            y = Integer.valueOf(split[2]);
            l = Integer.valueOf(split[THREE]);

            rgbo = Integer.parseInt(split[FOUR].substring(1), SIXTEEN);
            ao = Integer.parseInt(split[FIVE]);
            rgbo += (ao << TWOFOUR);

            rgbi = Integer.parseInt(split[SIX].substring(1), SIXTEEN);
            ai = Integer.parseInt(split[SEVEN]);
            rgbi += (ai << TWOFOUR);

            return new Square(x, y, l, rgbo, rgbi);
        }

        if (sn == ShapeNames.TRIANGLE) {
            String[] split = input.split("\\s+");
            int x1, y1, x2, y2, x3, y3;

            x1 = Integer.valueOf(split[1]);
            y1 = Integer.valueOf(split[2]);
            x2 = Integer.valueOf(split[THREE]);
            y2 = Integer.valueOf(split[FOUR]);
            x3 = Integer.valueOf(split[FIVE]);
            y3 = Integer.valueOf(split[SIX]);

            int rgbo, ao, rgbi, ai;

            rgbo = Integer.parseInt(split[SEVEN].substring(1), SIXTEEN);
            ao = Integer.parseInt(split[EIGHT]);
            rgbo += (ao << TWOFOUR);

            rgbi = Integer.parseInt(split[NINE].substring(1), SIXTEEN);
            ai = Integer.parseInt(split[TEN]);
            rgbi += (ai << TWOFOUR);

            return new Triangle(x1, y1, x2, y2, x3, y3, rgbo, rgbi);
        }

        if (sn == ShapeNames.CANVAS) {
            String[] split = input.split("\\s+");
            int h = Integer.parseInt(split[1]);
            int w = Integer.parseInt(split[2]);
            int rgb = Integer.parseInt(split[THREE].substring(1), SIXTEEN);
            int alpha = Integer.parseInt(split[FOUR]);
            rgb += (alpha << TWOFOUR);

            return new Canvas(h, w, rgb);
        }
        return null;
    }
}
