package com.epam.jwd.eriomkin.service.util;

import com.epam.jwd.eriomkin.model.Figure;
import com.epam.jwd.eriomkin.model.Point;

public class TriangleValidator {
    public static boolean isFigureValid(Figure figure) {
        return (isEnoughPoints(figure) && isTriangleExist(figure)) && !isNullPointExist(figure.getArrPoint());
    }

    private static boolean isEnoughPoints(Figure figure) {
        final int NUMBER_OF_FIGURE_POINTS = 3;
        return figure.getArrPoint().length == NUMBER_OF_FIGURE_POINTS;
    }

    private static boolean isNullPointExist(Point[] arrPoint) {
        for (int i = 0; i < arrPoint.length; i++) {
            if (arrPoint[i] == null) {
                return true;
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
