package ru.vsu.cs.kravtsova.nina.task3;

public class Circle {
    private double x0;
    private double y0;
    private double r;

    public Circle(double x0, double y0, double r) {
        this.x0 = x0;
        this.y0 = y0;
        this.r = r;
    }

    public boolean isPointIntoCircle(double x, double y) {
        return Math.pow(x - x0, 2) + Math.pow(y - y0, 2) <= Math.pow(r, 2);
    }
}
