package com.epam.jwd.eriomkin.service;

import com.epam.jwd.eriomkin.factory.FigureType;
import com.epam.jwd.eriomkin.model.Figure;
import com.epam.jwd.eriomkin.model.Point;

import java.util.List;

public interface FigureCrud {

    Figure create(FigureType type, Point... figureConstituents);
    List<Figure> multiCreate(FigureType type, List<Point> listFigureConstituents);
    boolean delete(Figure figure);
    Figure find(Figure figure);
    Figure update(Figure figure);
    Figure findByIndex(int index);
    Figure findByCriteria();
}
