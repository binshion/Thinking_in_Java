package thinkingInJava.io;

import org.omg.CORBA.PRIVATE_MEMBER;
import thinkingInJava.shape.Circle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract class Shape implements Serializable {
    public static final int RED = 1, BLUE = 2, GREEN = 3;
    private int xPos, yPos, dimension;
    private static Random rand = new Random(47);
    private static int counter = 0;
    public abstract void setColor(int newColor);
    public abstract int getColor();

    public Shape(int xVal, int yVal, int dim) {
        xPos = xVal;
        yPos = yVal;
        dimension = dim;
    }

    public String toString() {
        return getClass() + "color[" + getColor() + "] xPos[" + xPos +
                "] yPos[" + yPos + "] dim[" + dimension + "]\n";
    }

    public static Shape randomFactory() {
        int xVal = rand.nextInt(100);
        int yVal = rand.nextInt(100);
        int dim = rand.nextInt(100);
        switch (counter++ % 3) {
            default:
            case 0:
                return new Circles(xVal, yVal, dim);
            case 1:
                return new Square(xVal, yVal, dim);
            case 2:
                return new Line(xVal, yVal, dim);
        }
    }
}

class Circles extends Shape {
    private static int color = RED;
    public Circles(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }

    @Override
    public int getColor() {
        return color;
    }
}

class Square extends Shape {
    private static int color;
    public Square(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
        color = RED;
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }

    @Override
    public int getColor() {
        return color;
    }
}

class Line extends Shape {
    private static int color = RED;
    public static void serializeStaticState(ObjectOutputStream os) throws IOException {
        os.writeInt(color);
    }
    public static void deserializeStaticState(ObjectInputStream os) throws IOException {
        color = os.readInt();
    }

    public Line(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }

    @Override
    public int getColor() {
        return color;
    }
}

/**
 * [class thinkingInJava.io.Circlescolor[3] xPos[58] yPos[55] dim[93]
 * , class thinkingInJava.io.Squarecolor[3] xPos[61] yPos[61] dim[29]
 * , class thinkingInJava.io.Linecolor[3] xPos[68] yPos[0] dim[22]
 * , class thinkingInJava.io.Circlescolor[3] xPos[7] yPos[88] dim[28]
 * , class thinkingInJava.io.Squarecolor[3] xPos[51] yPos[89] dim[9]
 * , class thinkingInJava.io.Linecolor[3] xPos[78] yPos[98] dim[61]
 * , class thinkingInJava.io.Circlescolor[3] xPos[20] yPos[58] dim[16]
 * , class thinkingInJava.io.Squarecolor[3] xPos[40] yPos[11] dim[22]
 * , class thinkingInJava.io.Linecolor[3] xPos[4] yPos[83] dim[6]
 * , class thinkingInJava.io.Circlescolor[3] xPos[75] yPos[10] dim[42]
 * ]
 */
public class StoreCADState {
    public static void main(String[] args) throws Exception {
        List<Class<? extends Shape>> shapeTypes = new ArrayList<>();

        shapeTypes.add(Circles.class);
        shapeTypes.add(Square.class);
        shapeTypes.add(Line.class);

        List<Shape> shapes = new ArrayList<>();
        //Make some shapes:
        for (int i = 0; i < 10; i++) {
            shapes.add(Shape.randomFactory());
        }
        for (int i = 0; i < 10; i++) {
            ((Shape) shapes.get(i)).setColor(Square.GREEN);
        }

        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("E:/JavaProject/Thinking_in_Java/thinkingInJava/io/CADState.out")
        );
        out.writeObject(shapeTypes);
        Line.serializeStaticState(out);
        out.writeObject(shapes);

        System.out.println(shapes);
    }
}
