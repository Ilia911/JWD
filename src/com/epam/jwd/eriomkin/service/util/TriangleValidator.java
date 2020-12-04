package com.epam.jwd.eriomkin.service.util;

import com.epam.jwd.eriomkin.model.Figure;
import com.epam.jwd.eriomkin.model.Point;

public class TriangleValidator {
    public static boolean isFigureValid(Figure figure) {
        return (!isTwinPointsExist(figure) && isTriangleExist(figure));
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

    private static boolean isTriangleExist(Figure triangle) {
        Point[] arrPoint = triangle.getArrPoint();
        int x1 = arrPoint[0].getX();
        int y1 = arrPoint[0].getY();
        int x2 = arrPoint[1].getX();
        int y2 = arrPoint[1].getY();
        int x3 = arrPoint[2].getX();
        int y3 = arrPoint[2].getY();
        return ((x1 - x3) * (y2 - y3) != (x2 - x3) * (y1 - y3));
    }
}
