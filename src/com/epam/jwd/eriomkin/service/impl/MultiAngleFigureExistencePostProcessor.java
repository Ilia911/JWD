package com.epam.jwd.eriomkin.service.impl;

import com.epam.jwd.eriomkin.exception.FigureException;
import com.epam.jwd.eriomkin.exception.FigureNotExistException;
import com.epam.jwd.eriomkin.model.Figure;
import com.epam.jwd.eriomkin.service.FigurePostProcessor;
import com.epam.jwd.eriomkin.service.util.MultiangleFigureValidator;

import java.util.List;

class MultiAngleFigureExistencePostProcessor implements FigurePostProcessor {

    private List<Figure> multiAngleList = FigureStorage.INSTANCE.getMultiAngleList();

    MultiAngleFigureExistencePostProcessor() {}

    @Override
    public Figure process(Figure figure) throws FigureException {
        if (MultiangleFigureValidator.isFigureValid(figure)) {
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
        multiAngleList.add(figure);
    }

    private Figure fetchFigure(Figure newFigure) {
        for (Figure savedFigure : multiAngleList) {
            if (savedFigure.equals(newFigure)) {
                return savedFigure;
            }
        }
        return null;
    }
}
