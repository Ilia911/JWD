package com.epam.jwd.eriomkin.service.impl;

import com.epam.jwd.eriomkin.model.Figure;

import java.util.ArrayList;
import java.util.List;

enum FigureStorage {
    INSTANCE;
    // Понимаю что надо бы создасть отдельное хранилище для каждого вида фигур,
    // но т.к. все равно необходимо будет хранить фигуры в другом месте,
    // то для учебных целей, думаю, такой вариант тоже пока подойдет


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


