package com.epam.jwd.strategy.impl;

import com.epam.jwd.entity.Point;
import com.epam.jwd.strategy.PropertyStrategy;

public final class TrianglePropertyStrategy implements PropertyStrategy {
    private static TrianglePropertyStrategy instance;

    private TrianglePropertyStrategy(){};

    public static TrianglePropertyStrategy getInstance() {
        if (instance == null) {
            instance = new TrianglePropertyStrategy();
        }
        return instance;
    }
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

        double sideOne = calculeateLengthBetweenTwoPoint(arr[0], arr[1]);
        double sideTwo = calculeateLengthBetweenTwoPoint(arr[1], arr[2]);
        double sideThree = calculeateLengthBetweenTwoPoint(arr[0], arr[2]);
        double perimeterHalf = (sideOne + sideTwo + sideThree) / 3;

        return Math.sqrt(perimeterHalf * (perimeterHalf - sideOne) * (perimeterHalf - sideTwo)
                * (perimeterHalf - sideThree));
    }

    private static double calculeateLengthBetweenTwoPoint(Point p1, Point p2) {

        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();

        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

    }
}
