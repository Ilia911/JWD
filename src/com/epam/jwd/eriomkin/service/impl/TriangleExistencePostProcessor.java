package com.epam.jwd.eriomkin.service.impl;

import com.epam.jwd.eriomkin.exception.FigureException;
import com.epam.jwd.eriomkin.exception.FigureNotExistException;
import com.epam.jwd.eriomkin.model.Figure;
import com.epam.jwd.eriomkin.service.FigurePostProcessor;
import com.epam.jwd.eriomkin.service.util.TriangleValidator;

import java.util.List;

class TriangleExistencePostProcessor implements FigurePostProcessor {

    private List<Figure> triangleList = FigureStorage.INSTANCE.getTriangleList();

    TriangleExistencePostProcessor() {}

    //private static Figure[] triangleList = new Triangle[42];

    @Override
    public Figure process(Figure figure) throws FigureException {
        if (TriangleValidator.isFigureValid(figure)) {
            figure = fetchOrSaveInList(figure);
        } else {
            throw new FigureNotExistException("Invalid data");
        }
        return figure;
    }

    private Figure fetchOrSaveInList(Figure figure) {
        Figure savedFigure;
        if ((savedFigure = fetchFigure(figure)) != null) {
            return savedFigure;
        } else {
            saveInList(figure);
            return figure;
        }
    }

    private void saveInList(Figure figure) {
        triangleList.add(figure);
    }

    private Figure fetchFigure(Figure newFigure) {
        for (Figure savedFigure : triangleList) {
            if (savedFigure.equals(newFigure)) {
                return savedFigure;
            }
        }
        return null;
    }
}
