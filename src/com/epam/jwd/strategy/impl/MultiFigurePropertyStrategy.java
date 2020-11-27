package com.epam.jwd.strategy.impl;

import com.epam.jwd.entity.Point;
import com.epam.jwd.strategy.PropertyStrategy;

public enum MultiFigurePropertyStrategy implements PropertyStrategy {
    INSTANCE;

    @Override
    public double calculatePerimeter(Point[] arr) {

        double perimeter = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            perimeter += calculeateLengthBetweenTwoPoint(arr[i], arr[i + 1]);
        }
        perimeter += calculeateLengthBetweenTwoPoint(arr[0], arr[arr.length - 1]);

        return perimeter;
    }

    @Override
    public double calculateArea(Point[] arr) {
        double doubleArea = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            doubleArea += arr[i].getX() * arr[i + 1].getY() - arr[i].getY() * arr[i + 1].getX();
        }
        doubleArea += arr[arr.length - 1].getX() * arr[0].getY() - arr[arr.length - 1].getY() * arr[0].getX();
        return Math.abs(doubleArea / 2);
    }

    private static double calculeateLengthBetweenTwoPoint(Point p1, Point p2) {

        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();

        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

    }
}
