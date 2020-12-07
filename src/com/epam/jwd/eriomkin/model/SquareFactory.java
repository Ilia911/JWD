package com.epam.jwd.eriomkin.model;

import com.epam.jwd.eriomkin.exception.FigureException;
import com.epam.jwd.eriomkin.service.FigurePostProcessor;
import com.epam.jwd.eriomkin.service.impl.ServiceProvider;

public class SquareFactory extends FigureFactory {
    private static SquareFactory instance;
    private FigurePostProcessor postProcessor = ServiceProvider.getINSTANCE().getSquarePostProcessor();

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
        figure = postProcessor.process(figure);
        return figure;
    }
}
