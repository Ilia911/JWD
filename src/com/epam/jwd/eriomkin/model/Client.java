package com.epam.jwd.eriomkin.model;

public class Client {

    private Figure figure;

    public Client(FigureFactory factory, Point[] arrPoint) {
        figure = factory.createFigure(arrPoint);
    }

    public double fetchArea() {
        return figure.fetchArea();
    }

    public double fetchPerimeter() {
        return figure.fetchPerimeter();
    }
}
