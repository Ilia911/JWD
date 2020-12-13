package com.epam.jwd.eriomkin.service.impl;

import com.epam.jwd.eriomkin.exception.FigureException;
import com.epam.jwd.eriomkin.exception.FigureNotExistException;
import com.epam.jwd.eriomkin.model.Figure;
import com.epam.jwd.eriomkin.service.FigurePostProcessor;
import com.epam.jwd.eriomkin.service.util.LineValidator;

import java.util.List;

class LineExistencePostProcessor implements FigurePostProcessor {

    private List<Figure> lineList = FigureStorage.INSTANCE.getLineList();

    LineExistencePostProcessor() {
    }

    @Override
    public Figure process(Figure figure) throws FigureException {
        if (LineValidator.isFigureValid(figure)) {
            figure = fetchOrSaveInList(figure);
        } else {
            throw new FigureNotExistException("Such line can't exist. Invalid data");
        }
        return figure;
    }

    private Figure fetchOrSaveInList(Figure figure) {
        Figure savedLine;
        if ((savedLine = fetchLine(figure)) != null) {
            return savedLine;
        } else {
            saveInList(figure);
            return figure;
        }
    }

    private void saveInList(Figure figure) {
        lineList.add(figure);
    }

    private Figure fetchLine(Figure figure) {
        for (Figure line : lineList) {
            if (line.equals(figure)) {
                return line;
            }
        }
        return null;
    }
}
