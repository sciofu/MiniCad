import javax.imageio.ImageIO;

import main.DrawExt;
import main.DrawInt;
import main.ShapeFactory;
import main.Shape;
import main.ShapeNames;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

final class Main {
    private Main() {
    }
    public static void main(final String[] args) throws IOException {
        int forms;
        File inputFile = new File(args[0]);
        Scanner in = null;
        File outputFile = new File("drawing.png");
        try {
            in = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        forms = in.nextInt();
        ShapeFactory factory = ShapeFactory.getInstance();
        Integer h, w;

        DrawExt outline = DrawExt.getInstance();
        DrawInt inside = DrawInt.getInstance();
        Integer rgb, alpha;
        String line;

        line = in.nextLine();
        line = in.nextLine();
        String[] split = line.split("\\s+");
        ShapeNames sn = getName(split[0]);
        Shape s = factory.createShape(sn, line);
        BufferedImage pic = new BufferedImage(Integer.parseInt(split[2]),
                Integer.parseInt(split[1]),
                BufferedImage.TYPE_INT_ARGB);
        //System.out.println(pic.getWidth() + " " + pic.getHeight());
        s.accept(inside, pic);
        for (int i = 0; i < forms - 1; ++i) {
            line = in.nextLine();
            split = line.split("\\s+");
            sn = getName(split[0]);
            s = factory.createShape(sn, line);
            //System.out.println(sn);
            s.accept(outline, pic);
            s.accept(inside, pic);
        }

        ImageIO.write(pic, "png", outputFile);
    }

    static ShapeNames getName(final String s) {
        if (s.equals("CANVAS")) {
            return ShapeNames.CANVAS;
        }

        if (s.equals("LINE")) {
            return ShapeNames.LINE;
        }

        if (s.equals("SQUARE")) {
            return ShapeNames.SQUARE;
        }

        if (s.equals("RECTANGLE")) {
            return ShapeNames.RECTANGLE;
        }

        if (s.equals("TRIANGLE")) {
            return ShapeNames.TRIANGLE;
        }

        if (s.equals("DIAMOND")) {
            return ShapeNames.DIAMOND;
        }

        if (s.equals("POLYGON")) {
            return ShapeNames.POLY;
        }

        if (s.equals("CIRCLE")) {
            return ShapeNames.CIRCLE;
        }
        return null;
    }
}
