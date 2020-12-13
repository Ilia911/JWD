package com.epam.jwd.eriomkin;

import com.epam.jwd.eriomkin.exception.FigureException;
import com.epam.jwd.eriomkin.factory.FigureFactory;
import com.epam.jwd.eriomkin.factory.FigureType;
import com.epam.jwd.eriomkin.factory.impl.ApplicationContext;
import com.epam.jwd.eriomkin.model.Figure;
import com.epam.jwd.eriomkin.model.Point;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        ElementArrCreator elementArrCreator = new ElementArrCreator();

        Point[] newRandomArrPoint = elementArrCreator.createRandomArrPoint(3);

        FigureFactory figureFactory = ApplicationContext.getFigureFactory();

        Figure figure;

        try {

            figure = figureFactory.createFigure(FigureType.TRIANGLE, newRandomArrPoint);
            double area = figure.fetchArea();
            LOGGER.log(Level.INFO, "Figure {}. Area of the figure: {}", figure, area);
        } catch (FigureException e) {
            LOGGER.log(Level.ERROR, "Array: {}. Result: {}", newRandomArrPoint, e.getMessage());
        }
        //System.out.printf("Area of the triangle = %6.2f", FigureStorage.INSTANCE.getTriangleList().get(0).fetchArea());

    }

}
