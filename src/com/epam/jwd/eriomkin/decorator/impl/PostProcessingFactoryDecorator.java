package com.epam.jwd.eriomkin.decorator.impl;

import com.epam.jwd.eriomkin.decorator.FigureFactoryDecorator;
import com.epam.jwd.eriomkin.exception.FigureException;
import com.epam.jwd.eriomkin.factory.FigureFactory;
import com.epam.jwd.eriomkin.factory.FigureType;
import com.epam.jwd.eriomkin.model.Figure;
import com.epam.jwd.eriomkin.model.Point;
import com.epam.jwd.eriomkin.service.impl.ServiceProvider;

public class PostProcessingFactoryDecorator extends FigureFactoryDecorator {
    private FigureFactory figureFactory;
    private ServiceProvider serviceProvider = ServiceProvider.getINSTANCE();

    public PostProcessingFactoryDecorator(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    @Override
    public Figure createFigure(FigureType type, Point... figureConstituents) throws FigureException {
        Figure figure = figureFactory.createFigure(type, figureConstituents);
        figure = serviceProvider.getPostProcessor(type).process(figure);
        return figure;
    }
}
