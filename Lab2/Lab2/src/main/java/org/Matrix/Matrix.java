package org.Matrix;

import java.util.Arrays;
import java.util.Random;


public class Matrix {

    double[][] data;
    public int getRows() {
        return this.data.length;
    }
    public int getCols() {
        return this.data[0].length;
    }

    public Matrix() {
        // step 2.1
        this.data = new double[0][0];
    }
    public Matrix(int rows, int cols) {
        // step 2.2
        this.data = new double[rows][cols];
    }
    public Matrix(Matrix other) {
        // step 2.3
        this.data = other.data.clone();
    }

    public void set(int row, int col, double value) {
        // step 3
        if (row < 0 || row >= this.getRows()) {
            throw new IndexOutOfBoundsException("Invalid row index: " + row);
        }
        if (col < 0 || col >= this.getCols()) {
            throw new IndexOutOfBoundsException("Invalid column index: " + col);
        }
        data[row][col] = value;
    }

    public double getElement(int row, int col) {
        // step 4.1
        if (row < 0 || row >= this.getRows()) {
            throw new IndexOutOfBoundsException("Invalid row index: " + row);
        }
        if (col < 0 || col >= this.getCols()) {
            throw new IndexOutOfBoundsException("Invalid column index: " + col);
        }
        return this.data[row][col];
    }

    public static String dimensionMatrix(Matrix matrix){
        int row = matrix.getRows();
        int columns = matrix.getCols();
        return row + " x " + columns;
    }

    public double[] getRow(int row) {
        // step 4.2
        if (row < 0 || row >= this.getRows()) {
            throw new IndexOutOfBoundsException("Invalid row index: " + row);
        }
        return this.data[row];
    }

    public double[] getCol(int col) {
        // step 4.3
        if (col < 0 || col >= this.getCols()) {
            throw new IndexOutOfBoundsException("Invalid column index: " + col);
        }
        double[] column = new double[this.data.length];
        for (int i = 0; i < this.data.length; i++) {
            column[i] = this.data[i][col];
        }
        return column;
    }

    @Override
    public boolean equals(Object obj) {
        //step 6.1
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Matrix matrix = (Matrix) obj;
        return Arrays.deepEquals(data, matrix.data);
    }

    @Override
    public int hashCode() {
        // step 6.2
        return Arrays.deepHashCode(data);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getCols(); j++) {
                builder.append(data[i][j]).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public Matrix add(double value){
        Matrix newMatrix = new Matrix(this);
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getCols(); j++) {
                newMatrix.data[i][j] = this.data[i][j] + value;
            }
        }
        return newMatrix;
    }

    public Matrix add(Matrix matrix) {
        // step 8.1
        if (this.data.length != matrix.getRows() || this.data[0].length != matrix.getCols()) {
            throw new IllegalArgumentException("Inappropriate matrix size");
        }

        Matrix result = new Matrix(this.data.length, this.data[0].length);
        for (int i = 0; i < this.data.length; i++) {
            for (int j = 0; j < this.data[0].length; j++) {
                result.data[i][j] = this.data[i][j] + matrix.data[i][j];
            }
        }
        return result;
    }

    public Matrix multiply(double scalar){
        // step 8.2
        Matrix result = new Matrix(this.data.length, this.data[0].length);
        for (int i = 0; i < this.data.length; i++) {
            for (int j = 0; j < this.data[0].length; j++) {
                result.data[i][j] = this.data[i][j]*scalar;
            }
        }
        return result;
    }

    public Matrix multiply(Matrix matrix) {
        if (this.getCols() != matrix.getRows()) {
            throw new IllegalArgumentException("Number of columns in the first matrix must be equal to the number of rows in the second matrix for multiplication.");
        }

        Matrix result = new Matrix(this.getRows(), matrix.getCols());
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < matrix.getCols(); j++) {
                int sum = 0;
                for (int k = 0; k < this.getCols(); k++) {
                    sum += this.getElement(i, k) * matrix.getElement(k, j);
                }
                result.set(i, j, sum);
            }
        }
        return result;
    }

    public Matrix transpose() {
        // step 10
        Matrix result = new Matrix(this.getCols(), this.getRows());
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getCols(); j++) {
                result.data[j][i] = this.data[i][j];
            }
        }
        return result;
    }
    public static Matrix diagonal(int[] values) {
        // step 11
        int size = values.length;
        Matrix result = new Matrix(size, size);
        for (int i = 0; i < size; i++) {
            result.data[i][i] =values[i];
        }
        return result;
    }
    public static Matrix unitMatrix(int size){
        // step 12

        Matrix result = new Matrix(size, size);
        for (int i = 0; i < size; i++) {
            result.data[i][i] = 1;
        }
        return result;
    }
    public static Matrix randomRow(int rows) {
        // step 13
        Matrix result = new Matrix(1, rows);
        for (int i = 0; i < rows; i++) {
            result.data[0][i] = (int) (Math.random()*(200+1)) - 100;
        }
        return result;
    }
    public static Matrix randomColumn(int cols) {
        // step 14
        Matrix result = new Matrix(cols, 1);
        for (int i = 0; i < cols; i++) {
            result.data[i][0] = (int) (Math.random()*(200+1)) - 100;
        }
        return result;
    }
    public static Matrix randomMatrix(int rows, int cols) {
        Random rand = new Random();
        Matrix matrix = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix.set(i, j, rand.nextInt(100));
            }
        }
        return matrix;
    }

    public Matrix triangularShapeUpper(){
        int LowestLenght;
        if (this.getCols() < this.getRows()) {
            LowestLenght = this.getCols();
        } else {
            LowestLenght = this.getRows();
        }
        Matrix newMatrix = new Matrix(this);
        for (int i = 0; i < LowestLenght; i++) {
            boolean matrix_swaped = false;
            for (int j = i; j < this.getRows(); j++) {
                if (matrix_swaped) {

                } else {
                    if (newMatrix.data[j][i] != 0) {
                        double[] temp = newMatrix.data[i];
                        newMatrix.data[i] = newMatrix.data[j];
                        newMatrix.data[j] = temp;
                        matrix_swaped = true;
                    }
                }
            }
            double first_d = newMatrix.data[i][i];
            for (int j = 1 + i; j < newMatrix.getRows(); j++) {
                double other_d = newMatrix.data[j][i];
                if (first_d != 0) {
                    double alpha = other_d / first_d;
                    for (int k = 0; k < newMatrix.getCols(); k++) {
                        newMatrix.data[j][k] = newMatrix.data[j][k] - alpha*newMatrix.data[i][k];
                    }
                }
            }
        }
        return newMatrix;
    }

    public Matrix triangularShapeLower(){
        int LastDigitOfTriangul;
        if (this.getCols() < this.getRows()) {
            LastDigitOfTriangul = 0;
        } else {
            LastDigitOfTriangul = this.getCols() - this.getRows();
        }
        Matrix newMatrix = new Matrix(this);
        int count_backing = 0;
        for (int i = newMatrix.getCols() - 1; i > LastDigitOfTriangul - 1; i--) {
            count_backing++;
            int row_pivot = newMatrix.getRows() - count_backing;

            Boolean matrix_swaped = false;
            for (int j = row_pivot; j > -1; j--) {
                if(matrix_swaped){

                } else {
                    if (newMatrix.data[j][i] != 0) {
                        double[] temp = newMatrix.data[row_pivot];
                        newMatrix.data[row_pivot] = newMatrix.data[j];
                        newMatrix.data[j] = temp;
                        matrix_swaped = true;
                    }
                }

            }

            double first_d = newMatrix.data[row_pivot][i];

            for (int j = row_pivot - 1; j > -1 ; j--) {
                double other_d = newMatrix.data[j][i];
                if(first_d != 0) {
                    double alpha = other_d / first_d;
                    for (int k = 0; k < newMatrix.getCols(); k++) {
                        newMatrix.data[j][k] = newMatrix.data[j][k] - alpha*newMatrix.data[row_pivot][k];
                    }
                }
            }
        }
        return newMatrix;
    }
}