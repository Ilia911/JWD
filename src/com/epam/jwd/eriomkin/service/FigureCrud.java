package com.epam.jwd.eriomkin.service;

import com.epam.jwd.eriomkin.exception.FigureException;
import com.epam.jwd.eriomkin.exception.IllegalFigureTypeException;
import com.epam.jwd.eriomkin.factory.FigureType;
import com.epam.jwd.eriomkin.model.Figure;
import com.epam.jwd.eriomkin.model.Point;
import com.epam.jwd.eriomkin.service.impl.FigureSearchCriteria;

import java.util.List;
import java.util.Optional;

public interface FigureCrud {

    Figure create(FigureType type, Point... figureConstituents) throws FigureException;
    List<Figure> multiCreate(FigureType figureType, List<Point[]> figureConstituents) throws FigureException;
    boolean delete(Figure figure) throws FigureException;
    Optional<Figure> find(Figure figure) throws IllegalFigureTypeException;
    boolean update(Figure figure) throws IllegalFigureTypeException;
    Optional<Figure> findByIndex(FigureType figureType, int index) throws IllegalFigureTypeException;
    List<Figure> findByCriteria(FigureSearchCriteria criteria) throws IllegalFigureTypeException;
}
