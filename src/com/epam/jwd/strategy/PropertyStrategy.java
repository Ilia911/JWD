package com.epam.jwd.strategy;


import com.epam.jwd.entity.Point;

public interface PropertyStrategy {
   double calculatePerimeter(Point[] arr);
   double calculateArea(Point[] arr);
}

