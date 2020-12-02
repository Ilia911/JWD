package com.epam.jwd.eriomkin.model;

import com.epam.jwd.eriomkin.strategy.PropertyStrategy;
import com.epam.jwd.eriomkin.strategy.impl.MultiFigurePropertyStrategy;

public abstract class Figure {

    protected Point[] arrPoint;
    private PropertyStrategy figurePropertiesStrategy = MultiFigurePropertyStrategy.INSTANCE;

    public Figure(Point... arrPoint) {
        this.arrPoint = arrPoint;
    }

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

}
