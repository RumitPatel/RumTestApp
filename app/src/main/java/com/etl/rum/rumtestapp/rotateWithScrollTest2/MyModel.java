package com.etl.rum.rumtestapp.rotateWithScrollTest2;

public class MyModel {
    private static int degreeMain;
    private static boolean isRotateRight;

    public static int getDegrees() {
        return degreeMain;
    }

    public static void setDegrees(int updatedDegrees) {
        degreeMain = updatedDegrees;
    }

    public static boolean getIsRotationLeft() {
        return isRotateRight;
    }

    public static void setIsRotationLeft(boolean updatedIsRotateRight) {
        isRotateRight = updatedIsRotateRight;
    }
}