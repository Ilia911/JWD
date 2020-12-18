package com.epam.jwd.eriomkin.service.impl;

import com.epam.jwd.eriomkin.exception.FigureException;
import com.epam.jwd.eriomkin.exception.IllegalFigureTypeException;
import com.epam.jwd.eriomkin.factory.FigureType;
import com.epam.jwd.eriomkin.factory.impl.ApplicationContext;
import com.epam.jwd.eriomkin.model.Figure;
import com.epam.jwd.eriomkin.model.Point;
import com.epam.jwd.eriomkin.service.FigureCrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FigureCrudImpl implements FigureCrud {
    @Override
    public Figure create(FigureType type, Point... figureConstituents) throws FigureException {

        return ApplicationContext.getFigureFactory().createFigure(type, figureConstituents);
    }

    @Override
    public List<Figure> multiCreate(FigureType figureType, List<Point[]> figureConstituents) throws FigureException {

        List<Figure> resultFigureList = new ArrayList<>();
        for (Point[] figureConstituent : figureConstituents
        ) {
            resultFigureList.add(this.create(figureType, figureConstituent));

        }
        return resultFigureList;
    }

    @Override
    public boolean delete(Figure figure) throws FigureException {

        List<Figure> figureList = fetchFigureList(figure.getFigureType());

        return figureList.remove(figure);
    }

    @Override
    public Optional<Figure> find(Figure figure) throws IllegalFigureTypeException {

        List<Figure> figureList = fetchFigureList(figure.getFigureType());

        return figureList.stream().filter(figure::equals).findFirst();
    }

    @Override
    public boolean update(Figure figure) throws IllegalFigureTypeException {

        List<Figure> figureList = fetchFigureList(figure.getFigureType());

        for (Figure figureFromList : figureList
        ) {
            if (figureFromList.equals(figure)) {
                figureFromList = figure;
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<Figure> findByIndex(FigureType figureType, int index) throws IllegalFigureTypeException {

        List<Figure> figureList = fetchFigureList(figureType);

        return figureList.stream().filter((figure) -> figure.getIndex() == index).findFirst();

    }

    @Override
    public List<Figure> findByCriteria(FigureSearchCriteria criteria) throws IllegalFigureTypeException {

        List<Figure> figureList = fetchFigureList(criteria.getFigureType());

        return figureList.stream()
                .filter(figure -> figure.fetchArea() >= criteria.getMinArea() 
                        && figure.fetchArea() < criteria.getMaxArea())
                .filter(figure -> figure.fetchPerimeter() >= criteria.getMinPerimeter()
                        && figure.fetchPerimeter() < criteria.getMaxPerimeter())
                .collect(Collectors.toList());
    }

    private List<Figure> fetchFigureList(FigureType figureType) throws IllegalFigureTypeException {
        if (figureType == null) {
            return fetchFigureList();
        }
        List<Figure> figureList;
        switch (figureType) {
            case MULTI_ANGLE_FIGURE:
                return ServiceProvider.getINSTANCE().getFigureStorage().getMultiAngleList();
            case LINE:
                return ServiceProvider.getINSTANCE().getFigureStorage().getLineList();
            case TRIANGLE:
                return ServiceProvider.getINSTANCE().getFigureStorage().getTriangleList();
            case SQUARE:
                return ServiceProvider.getINSTANCE().getFigureStorage().getSquareList();
            default:
                throw new IllegalFigureTypeException("Illegal Figure Type!");

        }

    }

    private List<Figure> fetchFigureList() {

        FigureStorage figureStorage = ServiceProvider.getINSTANCE().getFigureStorage();
        List<Figure> figureList = new ArrayList<>();

        figureList.addAll(figureStorage.getMultiAngleList());
        figureList.addAll(figureStorage.getLineList());
        figureList.addAll(figureStorage.getTriangleList());
        figureList.addAll(figureStorage.getSquareList());
        return figureList;
    }

}

