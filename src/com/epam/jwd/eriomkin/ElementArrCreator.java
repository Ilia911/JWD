package com.epam.jwd.eriomkin;

import com.epam.jwd.eriomkin.model.Point;

import java.util.Random;

public class ElementArrCreator {

    public Point[] hardcoreArrPoint() {
        Point[] arrPoint = new Point[6];
        arrPoint[0] = new Point(-3, 1);
        arrPoint[1] = new Point(0, 5);
        arrPoint[2] = new Point(5, 2);
        arrPoint[3] = new Point(3, -2);
        arrPoint[4] = new Point(1, -7);
        arrPoint[5] = new Point(-5, -2);
        return arrPoint;
    }

    public Point[] createRandomArrPoint(int length) {
        Point[] arrPoint = new Point[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arrPoint[i] = new Point(random.nextInt(10) - 4, random.nextInt(10) - 4);
        }
        return arrPoint;
    }

    public Point[] createRandomArrPoint() {
        Random random = new Random();
        int length = random.nextInt(5) + 2;
        Point[] arrPoint = new Point[length];

        for (int i = 0; i < length; i++) {
            arrPoint[i] = new Point(random.nextInt(10) - 4, random.nextInt(10) - 4);
        }
        return arrPoint;
    }

}
