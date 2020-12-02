package com.epam.jwd.eriomkin.strategy;


import com.epam.jwd.eriomkin.model.Point;

public interface PropertyStrategy {
    double calculatePerimeter(Point[] arr);

    double calculateArea(Point[] arr);
}

