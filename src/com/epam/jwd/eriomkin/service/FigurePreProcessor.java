package com.epam.jwd.eriomkin.service;

import com.epam.jwd.eriomkin.exception.FigureException;
import com.epam.jwd.eriomkin.model.Point;

public interface FigurePreProcessor {
    void process(Point... arrPoint) throws FigureException;
}
