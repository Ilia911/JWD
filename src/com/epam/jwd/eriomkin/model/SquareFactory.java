package com.epam.jwd.eriomkin.model;

import com.epam.jwd.eriomkin.exception.FigureException;
import com.epam.jwd.eriomkin.service.impl.ServiceProvider;

public class SquareFactory extends FigureFactory {
    private static SquareFactory instance;

    SquareFactory() {
    }

    public static FigureFactory getInstance() {
        if (instance == null) {
            instance = new SquareFactory();
        }
        return instance;
    }

    @Override
    public Figure createFigure(Point... arrPoint) throws FigureException {
        Figure figure;
        figure = new Square(arrPoint);
        figure = ServiceProvider.getINSTANCE().getSquarePostProcessor().process(figure);
        return figure;
    }
}
