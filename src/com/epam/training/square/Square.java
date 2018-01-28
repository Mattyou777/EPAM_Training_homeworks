package com.epam.training.square;

import java.util.Arrays;

/**
 * Created by Matt on 28.01.2018.
 */
public class Square {
    private double point1x;
    private double point1y;
    private double point2x;
    private double point2y;

    public Square(double point1x, double point1y, double point2x, double point2y) {
        this.point1x = point1x;
        this.point1y = point1y;
        this.point2x = point2x;
        this.point2y = point2y;
    }

    public double getPoint1x() {
        return point1x;
    }

    public double getPoint1y() {
        return point1y;
    }

    public double getPoint2x() {
        return point2x;
    }

    public double getPoint2y() {
        return point2y;
    }

    public double squareSq(){
        return Math.abs(point1x-point2x)*Math.abs(point1y-point2y);
    }

    public static double crosSquare(Square square1,Square square2){
        if (Math.max(square1.getPoint1x(),square1.getPoint2x()) <= Math.min(square2.getPoint1x(),square2.getPoint2x()) ||
                Math.max(square2.getPoint1x(),square2.getPoint2x()) <= Math.min(square1.getPoint1x(),square1.getPoint2x()) ||
                Math.max(square1.getPoint1y(),square1.getPoint2y()) <= Math.min(square2.getPoint1y(),square2.getPoint2y()) ||
                Math.max(square2.getPoint1y(),square2.getPoint2y()) <= Math.min(square1.getPoint1y(),square1.getPoint2y())){
            return 0.0;
        }
        double [] xs = new double[]{square1.getPoint1x(),square1.getPoint2x(),square2.getPoint1x(),square2.getPoint2x()};
        double [] ys = new double[]{square1.getPoint1y(),square1.getPoint2y(),square2.getPoint1y(),square2.getPoint2y()};
        Arrays.sort(xs);
        Arrays.sort(ys);
        return Math.abs(xs[1]-xs[2])*Math.abs(ys[1]-ys[2]);
    }

    public static void main(String[] args) {
        System.out.println(crosSquare(new Square(-1.0,-1.0,0.5,0),new Square(-1.0,-1.0,1.0,0.0)));
    }
}
