package com.epam.jwd.entity;


import com.epam.jwd.strategy.PropertyStrategy;
import com.epam.jwd.strategy.impl.LinePropertyStrategy;

import java.util.Arrays;

public class Line extends Figure {

    private Point[] arrPoint = new Point[2];
    private PropertyStrategy figurePropertiesStrategy = LinePropertyStrategy.getInstance();

    public Line() {}

    public Line(Point startPoint, Point endPoint) {
        arrPoint[0] = startPoint;
        arrPoint[1] = endPoint;

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
