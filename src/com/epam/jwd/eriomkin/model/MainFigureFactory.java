package com.epam.jwd.eriomkin.model;

import com.epam.jwd.eriomkin.exception.FigureException;
import com.epam.jwd.eriomkin.exception.IlligalFigureTypeException;
import com.epam.jwd.eriomkin.service.FigurePreProcessor;
import com.epam.jwd.eriomkin.service.impl.ServiceProvider;

public class MainFigureFactory {
    private FigureFactory factory;

    private static final MainFigureFactory INSTANCE = new MainFigureFactory();
    private FigurePreProcessor preProcessor = ServiceProvider.getINSTANCE().getPreProcessor();

    public static MainFigureFactory getINSTANCE() {
        return INSTANCE;
    }

    public Figure createFigure(String type, Point... arrPoint) throws FigureException {
        Figure figure;

        preProcessor.process(arrPoint);

        switch (type) {
            case "line":
                factory = LineFactory.getInstance();
                break;
            case "triangle":
                factory = TriangleFactory.getInstance();
                break;
            case "square":
                factory = SquareFactory.getInstance();
                break;
            case "multiangle":
                factory = MultiAngleFigureFactory.getInstance();
                break;
            default:
                throw new IlligalFigureTypeException("Illegal type of the figure!");
        }
        figure = factory.createFigure(arrPoint);

        return figure;
    }

}
