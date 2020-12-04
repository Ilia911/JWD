package com.epam.jwd.eriomkin.service.impl;

import com.epam.jwd.eriomkin.exception.FigureException;
import com.epam.jwd.eriomkin.exception.FigureNotExistException;
import com.epam.jwd.eriomkin.model.Figure;
import com.epam.jwd.eriomkin.model.Line;
import com.epam.jwd.eriomkin.service.FigurePostProcessor;
import com.epam.jwd.eriomkin.service.util.LineValidator;

public class LineExistencePostProcessor implements FigurePostProcessor {

    /*
    Здесь надо будет ввести механизм связи с местом хранения фигур (файл, база данных)
    в которую будут сохраняться фигуры.
    Пока же используем пулл фигур здесь
     */
    LineExistencePostProcessor() {
    }

    private static Figure[] linesPool = new Line[42];


    @Override
    public Figure process(Figure figure) throws FigureException {
        if (LineValidator.isFigureValid(figure)) {
            figure = fetchOrSaveInPool(figure);
        } else {
            throw new FigureNotExistException("Such line can't exist. Invalid data");
        }
        return figure;
    }

    private Figure fetchOrSaveInPool(Figure figure) {
        Figure savedLine;
        if ((savedLine = fetchLine(figure)) != null) {
            return savedLine;
        } else {
            saveInPool(figure);
            return figure;
        }
    }

    private void saveInPool(Figure figure) {
        for (int i = 0; i < linesPool.length; i++) {
            if (linesPool[i] == null) {
                linesPool[i] = figure;
                break;
            }
            if (i == linesPool.length - 1) {
                scaleLinesPool();
                linesPool[i + 1] = figure;
            }
        }
    }

    private void scaleLinesPool() {
        Figure[] tempLinesPool = linesPool;
        linesPool = new Line[(int) (linesPool.length * 1.5)];
        for (int i = 0; i < tempLinesPool.length; i++) {
            linesPool[i] = tempLinesPool[i];
        }
    }

    private Figure fetchLine(Figure figure) {
        for (Figure line : linesPool) {
            if (line != null && line.equals(figure)) {
                return line;
            }
        }
        return null;
    }
}
