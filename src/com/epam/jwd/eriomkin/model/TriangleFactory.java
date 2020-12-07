package com.epam.jwd.eriomkin.model;

import com.epam.jwd.eriomkin.exception.FigureException;
import com.epam.jwd.eriomkin.service.FigurePostProcessor;
import com.epam.jwd.eriomkin.service.impl.ServiceProvider;

public class TriangleFactory extends FigureFactory {
    private static TriangleFactory instance;
    private FigurePostProcessor postProcessor = ServiceProvider.getINSTANCE().getTrianglePostProcessor();

    TriangleFactory() {
    }

    public static FigureFactory getInstance() {
        if (instance == null) {
            instance = new TriangleFactory();
        }
        return instance;
    }

    @Override
    public Figure createFigure(Point... arrPoint) throws FigureException {
        Figure figure;
        figure = new Triangle(arrPoint);
        figure = postProcessor.process(figure);
        return figure;
    }

}
