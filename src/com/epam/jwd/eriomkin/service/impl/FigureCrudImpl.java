package com.epam.jwd.eriomkin.service.impl;

import com.epam.jwd.eriomkin.factory.FigureType;
import com.epam.jwd.eriomkin.model.Figure;
import com.epam.jwd.eriomkin.model.Point;
import com.epam.jwd.eriomkin.service.FigureCrud;

import java.util.List;

public class FigureCrudImpl implements FigureCrud {
    @Override
    public Figure create(FigureType type, Point... figureConstituents) {
        return null;
    }

    @Override
    public List<Figure> multiCreate(FigureType type, List<Point> listFigureConstituents) {
        return null;
    }

    @Override
    public boolean delete(Figure figure) {
        return false;
    }

    @Override
    public Figure find(Figure figure) {
        return null;
    }

    @Override
    public Figure update(Figure figure) {
        return null;
    }

    @Override
    public Figure findByIndex(int index) {
        return null;
    }

    @Override
    public Figure findByCriteria() {
        return null;
    }
}
