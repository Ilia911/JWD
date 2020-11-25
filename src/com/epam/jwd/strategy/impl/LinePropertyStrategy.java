package com.epam.jwd.strategy.impl;

import by.eriomkin.jwd.entity.Point;
import com.epam.jwd.strategy.PropertyStrategy;

public class LinePropertyStrategy implements PropertyStrategy {
    @Override
    public double calculatePerimeter(Point[] arr) {
        Point p1 = arr[0];
        Point p2 = arr[1];
        return Math.sqrt((p2.getX() - p1.getX())*(p2.getX() - p1.getX()) + (p2.getY()-p1.getY()*(p2.getY()-p1.getY())));
    }

    @Override
    public double calculateArea(Point[] arr) {
        return 0;
    }
}
