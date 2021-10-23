package ru.vsu.cs.kravtsova.nina.task3;

public class Rectangle {
    private double x0;
    private double y0;
    private double x1;
    private double y1;

    public Rectangle(double x0, double y0, double x1, double y1) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }

    public boolean isPointInsideRectangle(double x, double y){
        return (y >= y0 && y <= y1) && (x >= x0 && x <= x1);
    }
}
