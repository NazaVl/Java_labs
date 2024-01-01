package org.Matrix;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Matrix matrix = Matrix.randomMatrix(3,3);
        System.out.println(matrix);
        matrix.transpose();
        System.out.println(matrix);
    }
}