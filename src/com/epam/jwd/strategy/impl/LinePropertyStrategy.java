package com.epam.jwd.strategy.impl;


import com.epam.jwd.entity.Point;
import com.epam.jwd.strategy.PropertyStrategy;

public final class LinePropertyStrategy implements PropertyStrategy {
    private final static LinePropertyStrategy instance = new LinePropertyStrategy();

    private LinePropertyStrategy() {}

    public static LinePropertyStrategy getInstance() {
        return instance;
    }
    @Override
    public double calculatePerimeter(Point[] arr) {
        return calculeateLengthBetweenTwoPoint(arr[0], arr[1]);
    }

    @Override
    public double calculateArea(Point[] arr) {
        return 0;
    }


    private static double calculeateLengthBetweenTwoPoint(Point p1, Point p2) {
        double x1 = p1.getX();
        double y1 = p1.getY();
        double x2 = p2.getX();
        double y2 = p2.getY();
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

    }
}
