package com.epam.jwd.model;

import com.epam.jwd.entity.Point;

public class MultiAngleFigureFactory extends FigureFactory<MultiAngleFigure> {

    private static MultiAngleFigureFactory instance;

    private MultiAngleFigureFactory() {}

    public static MultiAngleFigureFactory getInstance(){
        if (instance == null) {
            instance = new MultiAngleFigureFactory();
        }
        return instance;
    }

    @Override
    public MultiAngleFigure createFigure(Point... arrPoint) {
        return new MultiAngleFigure(arrPoint);
    }
}
