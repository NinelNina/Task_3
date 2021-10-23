package ru.vsu.cs.kravtsova.nina.task3;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static final Line LINE = new Line(0, 4, -2);
    private static final Circle CIRCLE = new Circle(-4, -1, 4);
    private static final Rectangle RECTANGLE = new Rectangle(-2, -2, 2, 8);
    private static final Parabola PARABOLA1 = new Parabola(2, 2, 0.125);
    private static final Parabola PARABOLA2 = new Parabola(-2, 1, -1);

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        test();

        Scanner input = new Scanner(System.in);

        System.out.printf("Введите координаты точки:");

        double x = input.nextDouble();
        double y = input.nextDouble();

        printColorForPoint(x, y);
    }

    public static SimpleColor getColor(double x, double y){
        if ((PARABOLA1.isPointAboveParabola(x, y)
                && LINE.isPointAboveLine(x, y)
                && !RECTANGLE.isPointInsideRectangle(x, y))
                ||(!PARABOLA1.isPointAboveParabola(x, y)
                && RECTANGLE.isPointInsideRectangle(x, y)
                && !CIRCLE.isPointIntoCircle(x, y))){
            return SimpleColor.GREEN;
        }

        if ((PARABOLA1.isPointAboveParabola(x, y)
                && RECTANGLE.isPointInsideRectangle(x, y)
                && LINE.isPointAboveLine(x, y))
                ||
                (PARABOLA1.isPointAboveParabola(x, y)
                && !RECTANGLE.isPointInsideRectangle(x, y)
                && !LINE.isPointAboveLine(x, y))
                ||
                (!PARABOLA1.isPointAboveParabola(x, y)
                && !RECTANGLE.isPointInsideRectangle(x, y)
                && LINE.isPointAboveLine(x, y))
                ||
                (CIRCLE.isPointIntoCircle(x, y)
                && !(!PARABOLA2.isPointAboveParabola(x, y)
                && RECTANGLE.isPointInsideRectangle(x, y)))){
            return SimpleColor.BLUE;
        }

        if ((PARABOLA1.isPointAboveParabola(x, y)
                && !LINE.isPointAboveLine(x, y)
                && RECTANGLE.isPointInsideRectangle(x, y))){
            return SimpleColor.ORANGE;
        }

        if (CIRCLE.isPointIntoCircle(x, y)
                && (!PARABOLA2.isPointAboveParabola(x, y)
                && RECTANGLE.isPointInsideRectangle(x, y))){
            return SimpleColor.WHITE;
        }

        if (!PARABOLA2.isPointAboveParabola(x, y)
                && ! CIRCLE.isPointIntoCircle(x, y)){
            return SimpleColor.YELLOW;
        }
        return SimpleColor.GRAY;
    }

    public static void test() {
        printColorForPoint(1, 10);
        printColorForPoint(1.5, 5);
        printColorForPoint(-1, 4);
        printColorForPoint(-3, 7);
        printColorForPoint(-4, 4);
        printColorForPoint(-5, 1);
        printColorForPoint(-1.5, -1.5);
        printColorForPoint(1, 1);
        printColorForPoint(4, 1);
        printColorForPoint(-9, -3);
        printColorForPoint(-2, -6);
    }

    public static void printColorForPoint(double x, double y) {
        System.out.printf("(%.4f, %.4f) -> %s%n", x, y, getColor(x, y));
    }

}
