package com.epam.jwd.eriomkin.service.impl;

import com.epam.jwd.eriomkin.service.FigurePostProcessor;

public class ServiceProvider {

    private ServiceProvider() {
    }

    private static final ServiceProvider INSTANCE = new ServiceProvider();

    private FigurePostProcessor linePostProcessor = new LineExistencePostProcessor();
    private FigurePostProcessor trianglePostProcessor = new TriangleExistencePostProcessor();
    private FigurePostProcessor squarePostProcessor = new SquareExistencePostProcessor();

    public FigurePostProcessor getSquarePostProcessor() {
        return squarePostProcessor;
    }

    public FigurePostProcessor getMultiangleFigurelePostProcessor() {
        return multiangleFigurelePostProcessor;
    }

    private FigurePostProcessor multiangleFigurelePostProcessor = new MultiangleFigureExistencePostProcessor();

    public FigurePostProcessor getTrianglePostProcessor() {
        return trianglePostProcessor;
    }

    public FigurePostProcessor getLinePostProcessor() {
        return linePostProcessor;
    }

    public static ServiceProvider getINSTANCE() {
        return INSTANCE;
    }
}
