package com.epam.jwd.entity;

import com.epam.jwd.strategy.PropertyStrategy;
import com.epam.jwd.strategy.impl.LinePropertyStrategy;

import java.util.Arrays;

public class Figure {

    private Point[] arrPoint;
    private PropertyStrategy figurePropertiesStrategy;
    {
        figurePropertiesStrategy = LinePropertyStrategy.getInstance();
    }

    public Figure() {};

    public PropertyStrategy getFigurePropertiesStrategy() {
        return figurePropertiesStrategy;
    }

    public void setFigurePropertiesStrategy(PropertyStrategy figurePropertiesStrategy) {
        this.figurePropertiesStrategy = figurePropertiesStrategy;
    }

    public double fetchPerimeter() {
        return figurePropertiesStrategy.calculatePerimeter(arrPoint);
    }
    public double fetchArea() {
        return figurePropertiesStrategy.calculateArea(arrPoint);
    }

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
