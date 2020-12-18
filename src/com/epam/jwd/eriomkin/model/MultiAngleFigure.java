package com.epam.jwd.eriomkin.model;

import com.epam.jwd.eriomkin.factory.FigureType;
import com.epam.jwd.eriomkin.strategy.PropertyStrategy;
import com.epam.jwd.eriomkin.strategy.impl.MultiFigurePropertyStrategy;

import java.util.Arrays;
import java.util.Objects;

public class MultiAngleFigure extends Figure {

    private PropertyStrategy figurePropertyStrategy = MultiFigurePropertyStrategy.INSTANCE;
    private static long numberOfMultiAngleFigure = 0;

    private final long index = ++numberOfMultiAngleFigure;

    {
        figureType = FigureType.MULTI_ANGLE_FIGURE;
    }

    public MultiAngleFigure(Point... arrPoint) {
        this.arrPoint = arrPoint;
    }


    @Override
    public PropertyStrategy getFigurePropertiesStrategy() {
        return figurePropertyStrategy;
    }

    @Override
    public void setFigurePropertiesStrategy(PropertyStrategy figurePropertiesStrategy) {
        super.setFigurePropertiesStrategy(figurePropertiesStrategy);
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
    public Point[] getArrPoint() {
        return super.getArrPoint();
    }

    @Override
    public long getIndex() {
        return 0;
    }

    @Override
    public String toString() {
        return "MultiAngleFigure{" +
                "Points:" + Arrays.toString(arrPoint);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiAngleFigure that = (MultiAngleFigure) o;
        return Arrays.equals(arrPoint, that.arrPoint) &&
                Objects.equals(figurePropertyStrategy, that.figurePropertyStrategy);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(figurePropertyStrategy);
        result = 31 * result + Arrays.hashCode(arrPoint);
        return result;
    }
}
