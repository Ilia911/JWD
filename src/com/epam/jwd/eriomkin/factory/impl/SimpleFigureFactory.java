package com.epam.jwd.eriomkin.factory.impl;

import com.epam.jwd.eriomkin.exception.FigureException;
import com.epam.jwd.eriomkin.exception.IlligalFigureTypeException;
import com.epam.jwd.eriomkin.factory.FigureFactory;
import com.epam.jwd.eriomkin.factory.FigureType;
import com.epam.jwd.eriomkin.model.Figure;
import com.epam.jwd.eriomkin.model.Line;
import com.epam.jwd.eriomkin.model.MultiAngleFigure;
import com.epam.jwd.eriomkin.model.Point;
import com.epam.jwd.eriomkin.model.Square;
import com.epam.jwd.eriomkin.model.Triangle;

public class SimpleFigureFactory implements FigureFactory {
    @Override
    public Figure createFigure(FigureType type, Point... figureConstituents) throws FigureException {
        Figure figure;

        switch (type) {
            case LINE:
                figure = new Line(figureConstituents);
                break;
            case TRIANGLE:
                figure = new Triangle(figureConstituents);
                break;
            case SQUARE:
                figure = new Square(figureConstituents);
                break;
            case MULTI_ANGLE_FIGURE:
                figure = new MultiAngleFigure(figureConstituents);
                break;
            default:
                throw new IlligalFigureTypeException("Illegal type of the figure!");
        }

        return figure;
    }
}
