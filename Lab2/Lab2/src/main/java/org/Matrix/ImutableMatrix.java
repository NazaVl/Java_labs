package org.Matrix;


public class ImutableMatrix extends Matrix {

    public ImutableMatrix(){
        super();
    }

    public ImutableMatrix(int rows, int columns){
        super(rows, columns);
    }

    public ImutableMatrix(Matrix matrix_old){
        super(matrix_old);
    }


    @Override
    public void set(int row, int col, double value) {
        System.out.println("Err, u cann`t change immutable matrix");;
    }


    @Override
    public Matrix add(Matrix mat){
        return new Matrix(this).add(mat);
    }


    @Override
    public Matrix add(double scalar){
        return new Matrix(this).add(scalar);
    }

    @Override
    public Matrix multiply(Matrix mat){
        return new Matrix(this).multiply(mat);
    }
    @Override
    public Matrix multiply(double scalar){
        return new Matrix(this).multiply(scalar);
    }

    @Override
    public Matrix transpose(){
        return new Matrix(this).transpose();
    }

    @Override
    public Matrix triangularShapeUpper(){
        return new Matrix(this).triangularShapeUpper();
    }

    @Override
    public Matrix triangularShapeLower(){
        return new Matrix(this).triangularShapeLower();
    }
}