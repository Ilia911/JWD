package com.epam.jwd.eriomkin.model;

import com.epam.jwd.eriomkin.exception.FigureException;
import com.epam.jwd.eriomkin.service.impl.ServiceProvider;

public class LineFactory extends FigureFactory {

    private static LineFactory instance;

    LineFactory() {
    }

    public static FigureFactory getInstance() {
        if (instance == null) {
            instance = new LineFactory();
        }
        return instance;
    }

    @Override
    public Figure createFigure(Point... arrPoint) throws FigureException {
        Figure figure;
        figure = new Line(arrPoint);
        figure = ServiceProvider.getINSTANCE().getLinePostProcessor().process(figure);
        return figure;
    }
}
