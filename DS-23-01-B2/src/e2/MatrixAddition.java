package e2;

import java.util.Iterator;

public class MatrixAddition {

    private static boolean MismaDimension(Matrix m1, Matrix m2){
        return m1.getFilas() == m2.getFilas() && m1.getColumnas() == m2.getColumnas();
    }

    public Matrix SumarMatrices(Matrix m1, Matrix m2){

        Matrix matrix;
        Iterator<Integer> iterator1, iterator2;
        int valor, fila = 0, columna;

        if(MismaDimension(m1,m2)){
            matrix = new Matrix(m1.getFilas(), m1.getColumnas());
            iterator1 = m1.iterator();
            iterator2 = m2.iterator();

            while(iterator1.hasNext() && iterator2.hasNext() && fila < matrix.getFilas()){
                for(columna = 0; columna < matrix.getColumnas(); columna++){
                    valor = iterator1.next() + iterator2.next();
                    matrix.setCelda(fila, columna, valor);
                }
                fila++;
            }
        }
        else throw new ArithmeticException();

        return matrix;
    }

    public String toString(Matrix matrix){
        return matrix.toString();
    }

}
