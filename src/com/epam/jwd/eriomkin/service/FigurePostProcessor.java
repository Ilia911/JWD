package com.epam.jwd.eriomkin.service;

import com.epam.jwd.eriomkin.exception.FigureException;
import com.epam.jwd.eriomkin.model.Figure;

public interface FigurePostProcessor {
    Figure process(Figure figure) throws FigureException;
}
