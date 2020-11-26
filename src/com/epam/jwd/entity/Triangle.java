package com.epam.jwd.entity;

import com.epam.jwd.strategy.PropertyStrategy;
import com.epam.jwd.strategy.impl.TrianglePropertyStrategy;

import java.util.Arrays;

public class Triangle extends Figure{

    private Point[] arrPoint = new Point[3];
    private PropertyStrategy figurePropertiesStrategy = TrianglePropertyStrategy.getInstance();

    public Triangle() {}

    public Triangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        arrPoint[0] = firstPoint;
        arrPoint[1] = secondPoint;
        arrPoint[2] = thirdPoint;
    }

    @Override
    public PropertyStrategy getFigurePropertiesStrategy() {
        return figurePropertiesStrategy;
    }

    @Override
    public void setFigurePropertiesStrategy(PropertyStrategy figurePropertiesStrategy) {
        this.figurePropertiesStrategy = figurePropertiesStrategy;
    }

    @Override
    public double fetchPerimeter() {
        return figurePropertiesStrategy.calculatePerimeter(arrPoint);
    }

    @Override
    public double fetchArea() {
        return figurePropertiesStrategy.calculateArea(arrPoint);
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
