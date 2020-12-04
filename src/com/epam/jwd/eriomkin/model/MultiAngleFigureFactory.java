package com.epam.jwd.eriomkin.model;

import com.epam.jwd.eriomkin.exception.FigureException;
import com.epam.jwd.eriomkin.service.impl.ServiceProvider;

public class MultiAngleFigureFactory extends FigureFactory {

    private static MultiAngleFigureFactory instance;

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
        figure = ServiceProvider.getINSTANCE().getMultiangleFigurelePostProcessor().process(figure);
        return figure;
    }
}
