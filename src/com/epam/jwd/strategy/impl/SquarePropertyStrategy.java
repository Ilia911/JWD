package com.epam.jwd.strategy.impl;


import com.epam.jwd.entity.Point;
import com.epam.jwd.strategy.PropertyStrategy;

public enum SquarePropertyStrategy implements PropertyStrategy {
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
        double side;
        side = calculeateLengthBetweenTwoPoint(arr[0], arr[1]);
        return side * side;
    }

    private static double calculeateLengthBetweenTwoPoint(Point p1, Point p2) {

        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();

        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

    }
}
