package com.epam.jwd.model;

import com.epam.jwd.entity.Point;

public class SquareFactory extends FigureFactory<Square> {
    private static Square[] squaresPool = new Square[42];
    private static SquareFactory instance;

    SquareFactory(){}

    public static FigureFactory getInstance() {
        if (instance == null) {
            instance = new SquareFactory();
        }
        return instance;
    }
    @Override
    public Square createFigure(Point... arrPoint) {
        Square square;
        square = fetchSquare(arrPoint);
        if (square == null) {
            square = createSquareAndSaveInPool(arrPoint);
        }
        return square;
    }

    private Square createSquareAndSaveInPool(Point[] arrPoint) {
        Square newSquare = new Square(arrPoint);
        for (int i = 0; i < squaresPool.length; i++) {
            if (squaresPool[i] == null) {
                squaresPool[i] = newSquare;
                break;
            }
            if (i == squaresPool.length - 1) {
                scaleSquarePool();
                squaresPool[i + 1] = newSquare;
            }
        }
        return newSquare;
    }

    private void scaleSquarePool() {
        Square[] tempLinesPool = squaresPool;
        squaresPool = new Square[(int) (squaresPool.length*1.5)];
        for (int i = 0; i < tempLinesPool.length; i++) {
            squaresPool[i] = tempLinesPool[i];
        }
    }

    private Square fetchSquare(Point[] arrPoint) {
        for (Square square : squaresPool) {
            if (square != null && square.getArrPoint().equals(arrPoint)) {
                return square;
            }
        }
        return null;
    }
}
