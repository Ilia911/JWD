package com.epam.jwd.model;

import com.epam.jwd.entity.Figure;
import com.epam.jwd.entity.Line;
import com.epam.jwd.entity.Point;

public class LineFactory extends FigureFactory<com.epam.jwd.entity.Line> {

    private static Figure[] allCreatedFigures = new Figure[32];
    @Override
    public Line createFigure(Point... arrPoint) {
        Line figure = new Line(arrPoint);
        return null;
    }


}
