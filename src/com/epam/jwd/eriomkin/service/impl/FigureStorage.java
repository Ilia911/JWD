package com.epam.jwd.eriomkin.service.impl;

import com.epam.jwd.eriomkin.model.Figure;

import java.util.ArrayList;
import java.util.List;

enum FigureStorage {
    INSTANCE;

    private List<Figure> lineList = new ArrayList<>();
    private List<Figure> triangleList = new ArrayList<>();
    private List<Figure> squareList = new ArrayList<>();
    private List<Figure> multiAngleList = new ArrayList<>();

    public List<Figure> getLineList() {
        return lineList;
    }

    public List<Figure> getTriangleList() {
        return triangleList;
    }

    public List<Figure> getSquareList() {
        return squareList;
    }

    public List<Figure> getMultiAngleList() {
        return multiAngleList;
    }
}


