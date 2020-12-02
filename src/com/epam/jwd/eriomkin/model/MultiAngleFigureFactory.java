package com.epam.jwd.eriomkin.model;

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
    public Figure createFigure(Point... arrPoint) {
        return new MultiAngleFigure(arrPoint);
    }
}
