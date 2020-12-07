package com.epam.jwd.eriomkin.model;

import com.epam.jwd.eriomkin.exception.FigureException;
import com.epam.jwd.eriomkin.service.FigurePostProcessor;
import com.epam.jwd.eriomkin.service.impl.ServiceProvider;

public class MultiAngleFigureFactory extends FigureFactory {

    private static MultiAngleFigureFactory instance;
    private FigurePostProcessor postProcessor = ServiceProvider.getINSTANCE().getMultiangleFigurelePostProcessor();

    private MultiAngleFigureFactory() {
    }

    public static MultiAngleFigureFactory getInstance() {
        if (instance == null) {
            instance = new MultiAngleFigureFactory();
        }
        return instance;
    }

    @Override
    public Figure createFigure(Point... arrPoint) throws FigureException {
        Figure figure;
        figure = new MultiAngleFigure(arrPoint);
        figure = postProcessor.process(figure);
        return figure;
    }
}
