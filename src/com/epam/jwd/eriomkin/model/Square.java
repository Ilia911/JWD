package com.epam.jwd.eriomkin.model;

import com.epam.jwd.eriomkin.factory.FigureType;
import com.epam.jwd.eriomkin.strategy.PropertyStrategy;
import com.epam.jwd.eriomkin.strategy.impl.SquarePropertyStrategy;

import java.util.Arrays;

public class Square extends Figure {

    private static final int NUMBER_OF_FIGURE_POINTS = 4;
    private static long numberOfSquare = 0;

    private final long index = ++numberOfSquare;
    private PropertyStrategy figurePropertyStrategy = SquarePropertyStrategy.INSTANCE;

    {
        figureType = FigureType.SQUARE;
    }

    public Square(Point... arrPoint) {
        this.arrPoint = new Point[NUMBER_OF_FIGURE_POINTS];
        for (int i = 0; i < NUMBER_OF_FIGURE_POINTS && i < arrPoint.length; i++) {
            this.arrPoint[i] = arrPoint[i];
        }
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
    public long getIndex() {
        return 0;
    }

}
