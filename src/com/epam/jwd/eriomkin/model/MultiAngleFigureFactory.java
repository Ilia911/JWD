package com.epam.jwd.eriomkin.model;

import com.epam.jwd.eriomkin.exception.FigureNotExistException;

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
    public Figure createFigure(Point... arrPoint) throws FigureNotExistException {
        return new MultiAngleFigure(arrPoint);
    }
}
