package com.epam.jwd.eriomkin.service.impl;

import com.epam.jwd.eriomkin.factory.FigureType;

public class FigureSearchCriteria {
    private double minArea;
    private double maxArea;
    private double minPerimeter;
    private double maxPerimeter;
    private FigureType figureType;

    private FigureSearchCriteria(double minArea,
                                 double maxArea, double minPerimeter, double maxPerimeter, FigureType figureType) {
        this.minArea = minArea;
        this.maxArea = maxArea;
        this.minPerimeter = minPerimeter;
        this.maxPerimeter = maxPerimeter;
        this.figureType = figureType;
    }

    public double getMinArea() {
        return minArea;
    }

    public double getMaxArea() {
        return maxArea;
    }

    public double getMinPerimeter() {
        return minPerimeter;
    }

    public double getMaxPerimeter() {
        return maxPerimeter;
    }

    public FigureType getFigureType() {
        return figureType;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "FigureSearchCriteria{" +
                "minArea=" + minArea +
                ", maxArea=" + maxArea +
                ", minPerimeter=" + minPerimeter +
                ", maxPerimeter=" + maxPerimeter +
                ", figureType=" + figureType +
                '}';
    }

    public static class Builder {
        private double minArea;
        private double maxArea;
        private double minPerimeter;
        private double maxPerimeter;
        private FigureType figureType;

        {
            maxArea = Double.MAX_VALUE;
            maxPerimeter = Double.MAX_VALUE;
        }


        public Builder setMinArea(double minArea) {
            this.minArea = minArea;
            return this;
        }

        public Builder setMaxArea(double maxArea) {
            this.maxArea = maxArea;
            return this;
        }

        public Builder setFigureType(FigureType figureType) {
            this.figureType = figureType;
            return this;
        }

        public Builder setMinPerimeter(double minPerimeter) {
            this.minPerimeter = minPerimeter;
            return this;
        }

        public Builder setMaxPerimeter(double maxPerimeter) {
            this.maxPerimeter = maxPerimeter;
            return this;
        }

        public FigureSearchCriteria build() {
            return new FigureSearchCriteria(this.minArea,
                    this.maxArea,
                    this.minPerimeter,
                    this.maxPerimeter,
                    this.figureType);
        }
    }
}
