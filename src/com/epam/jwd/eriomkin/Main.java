package com.epam.jwd.eriomkin;

import com.epam.jwd.eriomkin.exception.FigureException;
import com.epam.jwd.eriomkin.exception.IllegalFigureTypeException;
import com.epam.jwd.eriomkin.factory.FigureFactory;
import com.epam.jwd.eriomkin.factory.FigureType;
import com.epam.jwd.eriomkin.factory.impl.ApplicationContext;
import com.epam.jwd.eriomkin.model.Figure;
import com.epam.jwd.eriomkin.model.Point;
import com.epam.jwd.eriomkin.service.FigureCrud;
import com.epam.jwd.eriomkin.service.impl.FigureCrudImpl;
import com.epam.jwd.eriomkin.service.impl.FigureSearchCriteria;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        Main instance = new Main();
        try {
            instance.go();
        } catch (IllegalFigureTypeException e) {
            e.printStackTrace();
        }

    }

    private void go() throws IllegalFigureTypeException {

        IninialDataCreator ininialDataCreator = new IninialDataCreator();

        Point[] newRandomArrPoint = ininialDataCreator.createRandomArrPoint(3);

        FigureCrud figureCrud = FigureCrudImpl.INSTANCE;

        Figure figure;

        try {
            figure = figureCrud.create(FigureType.TRIANGLE, newRandomArrPoint);
            double area = figure.fetchArea();
            LOGGER.log(Level.INFO, "Figure {}. Area of the figure: {}", figure, area);
        } catch (FigureException e) {
            LOGGER.log(Level.ERROR, "Array: {}. Result: {}", newRandomArrPoint, e.getMessage());
        }

        FigureSearchCriteria criteria = FigureSearchCriteria.builder()
                .setFigureType(FigureType.TRIANGLE)
                .setMinArea(2.6)
                .setMaxArea(8.5)
                .build();

        List<Figure> listFiguresByCriteria = figureCrud.findByCriteria(criteria);

        LOGGER.log(Level.INFO, "List figures {}.", listFiguresByCriteria);

    }

}
