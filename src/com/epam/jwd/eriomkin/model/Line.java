package com.epam.jwd.eriomkin.model;


import com.epam.jwd.eriomkin.strategy.PropertyStrategy;
import com.epam.jwd.eriomkin.strategy.impl.LinePropertyStrategy;

import java.util.Arrays;

public class Line extends Figure {

    private static final int NUMBER_OF_FIGURE_POINTS = 2;
    private PropertyStrategy figurePropertiesStrategy = LinePropertyStrategy.getInstance();

    public Line(Point... arrPoint) {
        this.arrPoint = new Point[NUMBER_OF_FIGURE_POINTS];
        for (int i = 0; i < NUMBER_OF_FIGURE_POINTS && i < arrPoint.length; i++) {
            this.arrPoint[i] = arrPoint[i];
        }
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

}
