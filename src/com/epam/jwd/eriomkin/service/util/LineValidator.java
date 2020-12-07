package com.epam.jwd.eriomkin.service.util;

import com.epam.jwd.eriomkin.model.Figure;
import com.epam.jwd.eriomkin.model.Point;

public class LineValidator {

    public static boolean isFigureValid(Figure figure) {

        return isEnoughPoints(figure.getArrPoint()) && !isNullPointExist(figure.getArrPoint());
    }

    private static boolean isEnoughPoints(Point[] arrPoint) {
        final int NUMBER_OF_FIGURE_POINTS = 2;
        return arrPoint.length == NUMBER_OF_FIGURE_POINTS;
    }

    private static boolean isNullPointExist(Point[] arrPoint) {
        for (int i = 0; i < arrPoint.length; i++) {
            if (arrPoint[i] == null) {
            return true;
            }
        }
        return false;
    }
}
