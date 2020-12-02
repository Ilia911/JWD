package com.epam.jwd.eriomkin.model;

public class LineFactory extends FigureFactory {

    private static Line[] linesPool = new Line[42];
    private static LineFactory instance;

    LineFactory() {
    }

    public static FigureFactory getInstance() {
        if (instance == null) {
            instance = new LineFactory();
        }
        return instance;
    }

    @Override
    public Figure createFigure(Point... arrPoint) {
        Figure line;
        line = fetchLine(arrPoint);
        if (line == null) {
            line = createLineAndSaveInPool(arrPoint);
        }
        return line;
    }

    private Figure createLineAndSaveInPool(Point[] arrPoint) {
        Line newLine = new Line(arrPoint);
        for (int i = 0; i < linesPool.length; i++) {
            if (linesPool[i] == null) {
                linesPool[i] = newLine;
                break;
            }
            if (i == linesPool.length - 1) {
                scaleLinesPool();
                linesPool[i + 1] = newLine;
            }
        }
        return newLine;
    }

    private void scaleLinesPool() {
        Line[] tempLinesPool = linesPool;
        linesPool = new Line[(int) (linesPool.length * 1.5)];
        for (int i = 0; i < tempLinesPool.length; i++) {
            linesPool[i] = tempLinesPool[i];
        }
    }

    private Line fetchLine(Point[] arrPoint) {
        for (Line line : linesPool) {
            if (line != null && line.getArrPoint().equals(arrPoint)) {
                return line;
            }
        }
        return null;
    }

}
