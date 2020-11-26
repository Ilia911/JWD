package com.epam.jwd.entity;

import com.epam.jwd.strategy.PropertyStrategy;
import com.epam.jwd.strategy.impl.SquarePropertyStrategy;

import java.util.Arrays;

public class Square extends  Figure{

    private Point[] arrPoint = new Point[4];
    private PropertyStrategy figurePropertyStrategy = SquarePropertyStrategy.INSTANCE;

    public Square() {}

    public Square(Point firstPoint, Point secondPoint, Point thirdPoint, Point forthPoint) {
        arrPoint[0] = firstPoint;
        arrPoint[1] = secondPoint;
        arrPoint[2] = thirdPoint;
        arrPoint[3] = forthPoint;
    }

    @Override
    public PropertyStrategy getFigurePropertiesStrategy() {
        return figurePropertyStrategy;
    }

    @Override
    public void setFigurePropertiesStrategy(PropertyStrategy figurePropertiesStrategy) {
        this.figurePropertyStrategy = figurePropertiesStrategy;
    }

    @Override
    public double fetchPerimeter() {
        return figurePropertyStrategy.calculatePerimeter(arrPoint);
    }

    @Override
    public double fetchArea() {
        return figurePropertyStrategy.calculateArea(arrPoint);
    }

    @Override
    public String toString() {
        return "Square{" +
                Arrays.toString(arrPoint) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;
        if (!super.equals(o)) return false;
        Square square = (Square) o;
        return Arrays.equals(arrPoint, square.arrPoint);
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
