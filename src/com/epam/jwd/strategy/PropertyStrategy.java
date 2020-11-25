package com.epam.jwd.strategy;

import by.eriomkin.jwd.entity.Point;

public interface PropertyStrategy {
   double calculatePerimeter(Point[] arr);
   double calculateArea(Point[] arr);
}
