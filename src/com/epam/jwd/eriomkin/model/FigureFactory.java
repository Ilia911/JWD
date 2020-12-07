package com.epam.jwd.eriomkin.model;

import com.epam.jwd.eriomkin.exception.FigureException;

public abstract class FigureFactory {

    public abstract Figure createFigure(Point... arrPoint) throws FigureException;

    public static FigureFactory getInstance() {
        return null;
    }

}
