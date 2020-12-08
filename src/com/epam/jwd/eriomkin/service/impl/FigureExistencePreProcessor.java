package com.epam.jwd.eriomkin.service.impl;

import com.epam.jwd.eriomkin.exception.FigureException;
import com.epam.jwd.eriomkin.exception.FigureNotExistException;
import com.epam.jwd.eriomkin.model.Point;
import com.epam.jwd.eriomkin.service.FigurePreProcessor;
import com.epam.jwd.eriomkin.service.util.FigureValidator;

class FigureExistencePreProcessor implements FigurePreProcessor {

    FigureExistencePreProcessor(){}

    @Override
    public void process(Point... arrPoint) throws FigureException {
        if (!FigureValidator.isFigureValid(arrPoint)) {

            throw new FigureNotExistException("Such figure can't exist. There are twin points!");
        }
    }
}
