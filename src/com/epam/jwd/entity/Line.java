package com.epam.jwd.entity;


import java.util.Arrays;

public class Line extends Figure {

    private Point[] arrPoint = new Point[2];

    public Line() {}

    public Line(Point startPoint, Point endPoint) {
        arrPoint[0] = startPoint;
        arrPoint[1] = endPoint;

    }
    public Line(Point[] arrPoint) {
        this.arrPoint[0] = arrPoint[0];
        this.arrPoint[1] = arrPoint[1];
    }

    @Override
    public String toString() {
        return "Line{" + Arrays.toString(arrPoint) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        if (!super.equals(o)) return false;
        Line line = (Line) o;
        return Arrays.equals(arrPoint, line.arrPoint);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(arrPoint);
        return result;
    }

    @Override
    public Point[] getArrPoint() {
        return arrPoint;
    }

    @Override
    public void setArrPoint(Point[] arrPoint) {
        this.arrPoint = arrPoint;
    }
}
