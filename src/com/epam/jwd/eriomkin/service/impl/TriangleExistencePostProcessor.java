package com.epam.jwd.eriomkin.service.impl;

import com.epam.jwd.eriomkin.exception.FigureException;
import com.epam.jwd.eriomkin.exception.FigureNotExistException;
import com.epam.jwd.eriomkin.model.Figure;
import com.epam.jwd.eriomkin.model.Line;
import com.epam.jwd.eriomkin.model.Triangle;
import com.epam.jwd.eriomkin.service.FigurePostProcessor;
import com.epam.jwd.eriomkin.service.util.TriangleValidator;

public class TriangleExistencePostProcessor implements FigurePostProcessor {
    /*
        Здесь надо будет ввести механизм связи с местом хранения фигур (файл, база данных)
        в которую будут сохраняться фигуры.
        Пока же используем пулл фигур здесь
     */

    TriangleExistencePostProcessor() {}

    private static Figure[] figuresPool = new Triangle[42];

    @Override
    public Figure process(Figure figure) throws FigureException {
        if (TriangleValidator.isFigureValid(figure)) {
            figure = fetchOrSaveInPool(figure);
        } else {
            throw new FigureNotExistException("Invalid data");
        }
        return figure;
    }

    private Figure fetchOrSaveInPool(Figure figure) {
        Figure savedFigure;
        if ((savedFigure = fetchFigure(figure)) != null) {
            return savedFigure;
        } else {
            saveInPool(figure);
            return figure;
        }
    }

    private void saveInPool(Figure figure) {
        for (int i = 0; i < figuresPool.length; i++) {
            if (figuresPool[i] == null) {
                figuresPool[i] = figure;
                break;
            }
            if (i == figuresPool.length - 1) {
                scaleFiguresPool();
                figuresPool[i + 1] = figure;
            }
        }
    }

    private void scaleFiguresPool() {
        Figure[] tempLinesPool = figuresPool;
        figuresPool = new Line[(int) (figuresPool.length * 1.5)];
        for (int i = 0; i < tempLinesPool.length; i++) {
            figuresPool[i] = tempLinesPool[i];
        }
    }

    private Figure fetchFigure(Figure newFigure) {
        for (Figure savedFigure : figuresPool) {
            if (savedFigure != null && savedFigure.equals(newFigure)) {
                return savedFigure;
            }
        }
        return null;
    }
}
