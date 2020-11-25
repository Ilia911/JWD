package com.epam.jwd.entity;

import java.util.Arrays;

public class Figure {

    private Point[] arrPoint;

    public Figure() {};

    @Override
    public String toString() {
        return "Figure{" +
                "arrPoint=" + Arrays.toString(arrPoint) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Figure)) return false;
        Figure figure = (Figure) o;
        return Arrays.equals(arrPoint, figure.arrPoint);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arrPoint);
    }

    public Point[] getArrPoint() {
        return arrPoint;
    }

    public void setArrPoint(Point[] arrPoint) {
        this.arrPoint = arrPoint;
    }
}
