package com.epam.jwd.eriomkin.model;

import com.epam.jwd.eriomkin.exception.FigureException;
import com.epam.jwd.eriomkin.exception.FigureNotExistException;

public abstract class FigureFactory {

    public abstract Figure createFigure(Point... arrPoint) throws FigureNotExistException, FigureException;

    public static FigureFactory getInstance() {
        return null;
    }

}
