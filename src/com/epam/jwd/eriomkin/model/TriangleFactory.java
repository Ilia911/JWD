package com.epam.jwd.eriomkin.model;

import com.epam.jwd.eriomkin.exception.FigureNotExistException;

public class TriangleFactory extends FigureFactory {
    private static Triangle[] trianglesPool = new Triangle[42];
    private static TriangleFactory instance;

    TriangleFactory() {
    }

    public static FigureFactory getInstance() {
        if (instance == null) {
            instance = new TriangleFactory();
        }
        return instance;
    }

    @Override
    public Figure createFigure(Point... arrPoint) throws FigureNotExistException {
        Triangle triangle;
        triangle = fetchTriangle(arrPoint);
        if (triangle == null) {
            triangle = createTriangleAndSaveInPool(arrPoint);
        }
        return triangle;
    }

    private Triangle createTriangleAndSaveInPool(Point[] arrPoint) {
        Triangle newTriangle = new Triangle(arrPoint);
        for (int i = 0; i < trianglesPool.length; i++) {
            if (trianglesPool[i] == null) {
                trianglesPool[i] = newTriangle;
                break;
            }
            if (i == trianglesPool.length - 1) {
                scaleTrianglePool();
                trianglesPool[i + 1] = newTriangle;
            }
        }
        return newTriangle;
    }

    private void scaleTrianglePool() {
        Triangle[] tempLinesPool = trianglesPool;
        trianglesPool = new Triangle[(int) (trianglesPool.length * 1.5)];
        for (int i = 0; i < tempLinesPool.length; i++) {
            trianglesPool[i] = tempLinesPool[i];
        }
    }

    private Triangle fetchTriangle(Point[] arrPoint) {
        for (Triangle triangle : trianglesPool) {
            if (triangle != null && triangle.getArrPoint().equals(arrPoint)) {
                return triangle;
            }
        }
        return null;
    }
}
