package com.epam.jwd.eriomkin.service.impl;

import com.epam.jwd.eriomkin.exception.IlligalFigureTypeException;
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
    private FigurePostProcessor multiangleFigurePostProcessor = new MultiangleFigureExistencePostProcessor();



    public FigurePreProcessor getPreProcessor() {
        return preProcessor;
    }
    public static ServiceProvider getINSTANCE() {
        return INSTANCE;
    }
    public FigurePostProcessor getPostProcessor(FigureType type) throws IlligalFigureTypeException {
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
                throw new IlligalFigureTypeException("Figure type not founded");
        }
    }

    // Delete these methods after delete factory in com.epam.jwd.eriomkin.model package
    public FigurePostProcessor getLinePostProcessor() {
        return linePostProcessor;
    }
    public FigurePostProcessor getTrianglePostProcessor() {
        return trianglePostProcessor;
    }
    public FigurePostProcessor getSquarePostProcessor() {
        return squarePostProcessor;
    }
    public FigurePostProcessor getMultiangleFigurePostProcessor() {
        return multiangleFigurePostProcessor;
    }

}
