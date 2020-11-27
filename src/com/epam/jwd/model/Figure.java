package com.epam.jwd.model;

import com.epam.jwd.entity.Point;
import com.epam.jwd.strategy.PropertyStrategy;
import com.epam.jwd.strategy.impl.LinePropertyStrategy;

import java.util.Arrays;

public abstract class Figure {

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

    public Point[] getArrPoint() {
        return arrPoint;
    }

    public void setArrPoint(Point[] arrPoint) {
        this.arrPoint = arrPoint;
    }
}
