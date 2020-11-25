package com.epam.jwd.entity;

import java.util.Arrays;

public class Triangle extends Figure{

    private Point[] arrPoint = new Point[3];

    public Triangle() {}

    public Triangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        arrPoint[0] = firstPoint;
        arrPoint[1] = secondPoint;
        arrPoint[2] = thirdPoint;
    }
    public Triangle(Point[] arrPoint) {
        this.arrPoint[0] = arrPoint[0];
        this.arrPoint[1] = arrPoint[1];
        this.arrPoint[2] = arrPoint[2];
    }

    @Override
    public String toString() {
        return "Triangle {" +
                 Arrays.toString(arrPoint) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        if (!super.equals(o)) return false;
        Triangle triangle = (Triangle) o;
        return Arrays.equals(arrPoint, triangle.arrPoint);
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
