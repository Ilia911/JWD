package com.epam.jwd.eriomkin.model;

import com.epam.jwd.eriomkin.exception.FigureNotExistException;

public class Client {

    private Figure figure;

    public Client(FigureFactory factory, Point[] arrPoint) throws FigureNotExistException {
        figure = factory.createFigure(arrPoint);
    }

    public double fetchArea() {
        return figure.fetchArea();
    }

    public double fetchPerimeter() {
        return figure.fetchPerimeter();
    }
}
