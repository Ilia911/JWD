package com.epam.jwd.eriomkin.model;

public abstract class FigureFactory {

    public abstract Figure createFigure(Point... arrPoint);

    public static FigureFactory getInstance() {
        return null;
    }

}
