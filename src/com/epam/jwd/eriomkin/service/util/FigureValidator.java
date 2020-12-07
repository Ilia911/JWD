package com.epam.jwd.eriomkin.service.util;

import com.epam.jwd.eriomkin.model.Point;

public class FigureValidator {
    public static boolean isFigureValid(Point... arrPoint) {

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
