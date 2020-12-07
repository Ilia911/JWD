package com.epam.jwd.eriomkin.service.util;

import com.epam.jwd.eriomkin.model.Figure;
import com.epam.jwd.eriomkin.model.Point;

public class SquareValidator {
    public static boolean isFigureValid(Figure figure) {
        return (isEnoughPoints(figure) && !isNullPointExist(figure.getArrPoint()) && isSquareExist(figure));
    }

    private static boolean isNullPointExist(Point[] arrPoint) {
        for (int i = 0; i < arrPoint.length; i++) {
            if (arrPoint[i] == null) {
                return true;
            }
        }
        return false;
    }

    private static boolean isEnoughPoints(Figure figure) {
        final int NUMBER_OF_FIGURE_POINTS = 4;
        return figure.getArrPoint().length == NUMBER_OF_FIGURE_POINTS;
    }

    private static boolean isSquareExist(Figure square) {
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

        return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
    }
}
