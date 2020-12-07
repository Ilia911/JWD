package com.epam.jwd.eriomkin.service.util;

import com.epam.jwd.eriomkin.model.Figure;
import com.epam.jwd.eriomkin.model.Point;

public class MultiangleFigureValidator {
    public static boolean isFigureValid(Figure figure) {

        return isEnoughPoints(figure) && !isNullPointExist(figure.getArrPoint());
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
        final int MIN_NUMBER_OF_FIGURE_POINTS = 4;
        return figure.getArrPoint().length >= MIN_NUMBER_OF_FIGURE_POINTS;
    }
}
