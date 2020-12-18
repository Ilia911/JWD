package com.epam.jwd.eriomkin.service.impl;

import com.epam.jwd.eriomkin.exception.IllegalFigureTypeException;
import com.epam.jwd.eriomkin.factory.FigureType;
import com.epam.jwd.eriomkin.service.FigurePostProcessor;
import com.epam.jwd.eriomkin.service.FigurePreProcessor;

public class ServiceProvider {

    private ServiceProvider() {
    }

    private static final ServiceProvider INSTANCE = new ServiceProvider();

    private FigurePreProcessor preProcessor = new FigureExistencePreProcessor();
    private FigurePostProcessor linePostProcessor = new LineExistencePostProcessor();
    private FigurePostProcessor trianglePostProcessor = new TriangleExistencePostProcessor();
    private FigurePostProcessor squarePostProcessor = new SquareExistencePostProcessor();
    private FigurePostProcessor multiangleFigurePostProcessor = new MultiAngleFigureExistencePostProcessor();
    private FigureStorage figureStorage = FigureStorage.INSTANCE;

    public static ServiceProvider getINSTANCE() {
        return INSTANCE;
    }

    public FigurePreProcessor getPreProcessor() {
        return preProcessor;
    }

    public FigureStorage getFigureStorage() {
        return figureStorage;
    }


    public FigurePostProcessor getPostProcessor(FigureType type) throws IllegalFigureTypeException {
        switch (type) {
            case LINE:
                return linePostProcessor;
            case TRIANGLE:
                return trianglePostProcessor;
            case SQUARE:
                return squarePostProcessor;
            case MULTI_ANGLE_FIGURE:
                return multiangleFigurePostProcessor;
            default:
                throw new IllegalFigureTypeException("Figure type not founded");
        }
    }


}
