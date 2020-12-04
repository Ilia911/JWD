package com.epam.jwd.eriomkin.service.util;

import com.epam.jwd.eriomkin.model.Figure;
import com.epam.jwd.eriomkin.model.Point;

public class SquareValidator {
    public static boolean isFigureValid(Figure figure) {
        return (!isTwinPointsExist(figure) && isSquareExist(figure));
    }

    private static boolean isTwinPointsExist(Figure figure) {
        Point[] arrPoint = figure.getArrPoint();
        for (int i = 0; i < arrPoint.length - 1; i++) {
            for (int j = 1 + i; j < arrPoint.length; j++) {
                if (arrPoint[i].equals(arrPoint[j])) {
                    return true;
                }
            }
        }
        return false;
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

        return (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);
    }
}
