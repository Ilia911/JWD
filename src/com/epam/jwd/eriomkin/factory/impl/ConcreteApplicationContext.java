package com.epam.jwd.eriomkin.factory.impl;

import com.epam.jwd.eriomkin.decorator.impl.PostProcessingFactoryDecorator;
import com.epam.jwd.eriomkin.decorator.impl.PreProcessingFactoryDecorator;
import com.epam.jwd.eriomkin.factory.ApplicationContext;
import com.epam.jwd.eriomkin.factory.FigureFactory;

public class ConcreteApplicationContext implements ApplicationContext {
    @Override
    public FigureFactory createFigureFactory() {
        FigureFactory figureFactory = new SimpleFigureFactory();
        figureFactory = new PreProcessingFactoryDecorator(figureFactory);
        figureFactory = new PostProcessingFactoryDecorator(figureFactory);
        return figureFactory;
    }
}
