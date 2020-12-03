package com.epam.jwd.eriomkin;

import com.epam.jwd.eriomkin.exception.FigureNotExistException;

import com.epam.jwd.eriomkin.model.Client;
import com.epam.jwd.eriomkin.model.FigureFactory;
import com.epam.jwd.eriomkin.model.LineFactory;
import com.epam.jwd.eriomkin.model.MultiAngleFigureFactory;
import com.epam.jwd.eriomkin.model.Point;
import com.epam.jwd.eriomkin.model.SquareFactory;
import com.epam.jwd.eriomkin.model.TriangleFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        Main example = new Main();
        ElementArrCreator elementArrCreator = new ElementArrCreator();

        Point[] newRandomArrPoint = elementArrCreator.createRandomArrPoint();

        Client client = null;


        try {
            client = example.configureClient(newRandomArrPoint);
            double area = client.fetchArea();
            LOGGER.log(Level.INFO, "Area of the figure: {}", area);
        } catch (FigureNotExistException e) {
            LOGGER.log(Level.ERROR, e.getMessage());
        }

    }

    private Client configureClient(Point[] arrPoint) throws FigureNotExistException {
        Client client;
        FigureFactory factory;

        switch (arrPoint.length) {
            case 0:
            case 1:
                throw new FigureNotExistException("Array of the points must contain more than one point!");
            case 2:
                factory = LineFactory.getInstance();
                break;
            case 3:
                factory = TriangleFactory.getInstance();
                break;
            case 4:
                factory = SquareFactory.getInstance();
                break;
            default:
                factory = MultiAngleFigureFactory.getInstance();
                break;
        }
        client = new Client(factory, arrPoint);
        return client;
    }


}
