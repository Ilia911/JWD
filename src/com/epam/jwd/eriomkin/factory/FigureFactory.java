package com.epam.jwd.eriomkin.factory;

import com.epam.jwd.eriomkin.exception.FigureException;
import com.epam.jwd.eriomkin.model.Figure;
import com.epam.jwd.eriomkin.model.Point;

public interface FigureFactory {
    Figure createFigure(FigureType type, Point... figureConstituents) throws FigureException;
}
