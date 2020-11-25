package com.epam.jwd.strategy.impl;

import by.eriomkin.jwd.entity.Point;
import com.epam.jwd.strategy.PropertyStrategy;

public class TrianglePropertyStrategy implements PropertyStrategy {
    @Override
    public double calculatePerimeter(Point[] arr) {
        double perimeter = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            perimeter += calculeateLengthBetweenTwoPoint(arr[i], arr[i + 1]);
        }
        return perimeter;
    }

    @Override
    public double calculateArea(Point[] arr) {
        return 0;
    }

    private static double calculeateLengthBetweenTwoPoint(Point p1, Point p2) {
        return Math.sqrt((p2.getX() - p1.getX())*(p2.getX() - p1.getX()) + (p2.getY()-p1.getY()*(p2.getY()-p1.getY())));

    }
}
