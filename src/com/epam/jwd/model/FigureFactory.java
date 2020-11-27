package com.epam.jwd.model;

import com.epam.jwd.entity.Point;

public abstract class FigureFactory<T extends Figure> {

    public abstract T createFigure(Point... arrPoint);

    public static FigureFactory getInstance() {
        return null;
    }
}
