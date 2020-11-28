package com.epam.jwd;

import com.epam.jwd.entity.*;
import com.epam.jwd.model.*;
import com.epam.jwd.model.exception.TooShortPointArrayException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        Point[] arrPoint;
        Figure[] arrLine;
        Figure[] arrTriangle;
        Figure[] arrSquare;

        ElementArrCreator elementArrCreator = new ElementArrCreator();

        arrPoint = elementArrCreator.hardcoreArrPoint();
        arrLine = elementArrCreator.hardcoreArrLine();
        arrTriangle = elementArrCreator.hardcoreArrTriangle();
        arrSquare = elementArrCreator.hardcoreArrSquare();

        logArrPoint(arrPoint);
        logArrLine(arrLine);
        logArrTriangle(arrTriangle);
        logArrSquare(arrSquare);

        FigureFactory multiAngleFactory = MultiAngleFigureFactory.getInstance();
        Point[] newRandomArrPoint = elementArrCreator.createRandomArrPoint();

        Client client = null;
        try {
            client = configureClient(newRandomArrPoint);
            double area = client.fetchArea();
            LOGGER.log(Level.INFO, "Area of the figure: {}",  area);
        } catch (TooShortPointArrayException e) {
            LOGGER.log(Level.ERROR, "Unvalid length of the array");
        }

        Figure multiAngleFigure2 = multiAngleFactory.createFigure(newRandomArrPoint);
        LOGGER.log(Level.INFO, "New multiAngleFigure is \n{};\n and it's perimeter = {}"
                , multiAngleFigure2, multiAngleFigure2.fetchPerimeter());


        Figure multiAngleFigure = multiAngleFactory.createFigure(arrPoint);
        LOGGER.log(Level.INFO, "New multiAngleFigure is \n{};\n and it's area = {}"
                , multiAngleFigure, multiAngleFigure.fetchArea());

    }

    private static Client configureClient(Point[] arrPoint) throws TooShortPointArrayException {
        Client client;
        FigureFactory factory;

        switch (arrPoint.length) {
            case 1:
                throw new TooShortPointArrayException();
            case 2:
                factory = LineFactory.getInstance();
                break;
            case 3:
                factory = TriangleFactory.getInstance();
                break;
            case 4:
                factory = SquareFactory.getInstance();
                break;
            default:
                factory = MultiAngleFigureFactory.getInstance();
        }
        client = new Client(factory, arrPoint);
        return client;
    }

    private static void logArrLine(Figure[] arrFigure) {

        for (int i = 0; i < arrFigure.length; i++) {
            if (checkFigureExistence(arrFigure[i])) {
                LOGGER.log(Level.INFO, "Line[{}]:", i);
                logArrPoint(arrFigure[i].getArrPoint());
            } else {
                LOGGER.log(Level.ERROR, "{} is not a line", arrFigure[i].toString());
            }
        }
    }

    private static void logArrTriangle(Triangle[] arrFigure) {

        for (int i = 0; i < arrFigure.length; i++) {
            if (!checkFigureExistence(arrFigure[i])) {
                LOGGER.log(Level.ERROR, "{} is not a figure triangle", arrFigure[i].toString());
                continue;
            }
            if (checkTriangleExistance(arrFigure[i])){
                    LOGGER.log(Level.INFO, "Triangle[{}]:", i);
                logArrPoint(arrFigure[i].getArrPoint());
            }else {
                LOGGER.log(Level.ERROR, "{} can not exist", arrFigure[i].toString());
            }
        }
    }
    private static boolean checkTriangleExistance(Triangle triangle) {
        Point[] arrPoint = triangle.getArrPoint();
        int x1 = arrPoint[0].getX();
        int y1 = arrPoint[0].getY();
        int x2 = arrPoint[1].getX();
        int y2 = arrPoint[1].getY();
        int x3 = arrPoint[2].getX();
        int y3 = arrPoint[2].getY();
        return ((x1-x3)*(y2-y3) != (x2-x3)*(y1-y3));
    }

    private static void logArrSquare(Figure[] arrFigure) {

        for (int i = 0; i < arrFigure.length; i++) {
            if (!checkFigureExistence(arrFigure[i])) {
                LOGGER.log(Level.ERROR, "{} is not a figure square", arrFigure[i].toString());
                continue;
            }
            if (checkSquareExistance(arrFigure[i])){
                LOGGER.log(Level.INFO, "Square[{}]:", i);
                logArrPoint(arrFigure[i].getArrPoint());
            }else {
                LOGGER.log(Level.ERROR, "{} is not a squre", arrFigure[i].toString());
            }
        }
    }
    private static boolean checkSquareExistance(Figure square) {
        Point[] arrPoint = square.getArrPoint();
        Point point1 = arrPoint[0];
        Point point2 = arrPoint[1];
        Point point3 = arrPoint[2];
        Point point4 = arrPoint[3];

        if (calculateSqareLength(point1, point3) == calculateSqareLength(point2, point4)) {
            if (calculateSqareLength(point1, point2) == calculateSqareLength(point4, point3)) {
                return true;
            }
        }
        if (calculateSqareLength(point1, point2) == calculateSqareLength(point3, point4)) {
            if (calculateSqareLength(point1, point3) == calculateSqareLength(point4, point2)) {
                return true;
            }
        }
        return false;
    }

    private static int calculateSqareLength(Point point1, Point point2) {
        int x1 = point1.getX();
        int y1 = point1.getY();
        int x2 = point2.getX();
        int y2 = point2.getY();

        return (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);
    }

    private  static void logArrTriangle(Figure[] arrFigure) {
        for (int i = 0; i < arrFigure.length; i++) {
            LOGGER.log(Level.INFO, "Triangle[{}]:", i);
            logArrPoint(arrFigure[i].getArrPoint());
        }

    }

    private static void logArrPoint(Point[] arrPoint) {
        int counter = 0;
        do {
            LOGGER.log(Level.INFO, "arr[{}] = {}", counter, arrPoint[counter]);
        } while(++counter < arrPoint.length);
    }

    private static boolean checkFigureExistence (Figure figure) {
        Point[] arrPoint = figure.getArrPoint();
        for (int i = 0; i < arrPoint.length - 1; i++) {
            for (int j = 1 + i; j < arrPoint.length; j++) {
                if (arrPoint[i].equals(arrPoint[j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
