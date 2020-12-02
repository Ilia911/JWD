package com.epam.jwd.eriomkin;

import com.epam.jwd.eriomkin.model.Figure;
import com.epam.jwd.eriomkin.model.FigureFactory;
import com.epam.jwd.eriomkin.model.Line;
import com.epam.jwd.eriomkin.model.LineFactory;
import com.epam.jwd.eriomkin.model.Point;
import com.epam.jwd.eriomkin.model.Square;
import com.epam.jwd.eriomkin.model.SquareFactory;
import com.epam.jwd.eriomkin.model.Triangle;
import com.epam.jwd.eriomkin.model.TriangleFactory;

import java.util.Random;

public class ElementArrCreator {

    public Point[] hardcoreArrPoint() {
        Point[] arrPoint = new Point[6];
        arrPoint[0] = new Point(-3,1);
        arrPoint[1] = new Point(0,5);
        arrPoint[2] = new Point(5,2);
        arrPoint[3] = new Point(3,-2);
        arrPoint[4] = new Point(1,-7);
        arrPoint[5] = new Point(-5,-2);
        return arrPoint;
    }

    public Point[] createRandomArrPoint(int length) {
        Point[] arrPoint = new Point[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arrPoint[i] = new Point(random.nextInt(10) - 4, random.nextInt(10) - 4);
        }
        return arrPoint;
    }

    public Point[] createRandomArrPoint() {
        Random random = new Random();
        int length = 4 + random.nextInt(3);
        Point[] arrPoint = new Point[length];

        for (int i = 0; i < length; i++) {
            arrPoint[i] = new Point(random.nextInt(10) - 4, random.nextInt(10) - 4);
        }
        return arrPoint;
    }

    public Figure[] hardcoreArrLine() {
        Figure[] arrLine = new Line[2];
        FigureFactory lineFactory = LineFactory.getInstance();
        arrLine[0] = lineFactory.createFigure(new Point(2, 5), new Point(9,0));
        arrLine[1] = lineFactory.createFigure(new Point(1, 4), new Point(3,8));
        return  arrLine;
    }

    public Figure[] hardcoreArrTriangle() {
        Figure[] arrTriangle = new Triangle[2];
        FigureFactory triangleFactory = TriangleFactory.getInstance();
        arrTriangle[0] = triangleFactory.createFigure(new Point(4,4), new Point(2,3), new Point(4,4));
        arrTriangle[1] = triangleFactory.createFigure(new Point(4,4), new Point(3,3), new Point(-1,-1));
        return arrTriangle;
    }

    public Figure[] hardcoreArrSquare() {
        FigureFactory squareFactory = SquareFactory.getInstance();
        Figure[] arrSquare = new Square[1];
        Point point1 = new Point(0,0);
        Point point2 = new Point(0,2);
        Point point3 = new Point(2,2);
        Point point4 = new Point(2, 0);
        arrSquare[0] = squareFactory.createFigure(point1, point2, point3, point4);
        return arrSquare;
    }
}
