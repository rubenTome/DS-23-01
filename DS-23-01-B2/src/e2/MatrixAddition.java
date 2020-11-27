package e2;

import java.util.Iterator;

public class MatrixAddition {

    private static boolean MismaDimension(Matrix m1, Matrix m2){

        if(m1.getFilas() != m2.getFilas()) return false;
        else{
            for(int f = 0; f < m1.getFilas(); f++){
                if(m1.getFila(f).length != m2.getFila(f).length) return false;
            }
        }
        return true;
    }

    public Matrix SumarMatrices(Matrix m1, Matrix m2){

        Matrix matrix;
        Iterator<Integer> iterator1, iterator2;
        int valor, fila = 0, columna;

        if(m1 == null || m2 == null) throw new NullPointerException();

        if(MismaDimension(m1,m2)){
            matrix = new Matrix(m1.getFilas(), m1.getColumnas());
            iterator1 = m1.iterator();
            iterator2 = m2.iterator();

            if(m1.getIterator().equals(SelectIterator.ROW_COLUMN) || m2.getIterator().equals(SelectIterator.ROW_COLUMN)){
                while(iterator1.hasNext() && iterator2.hasNext() && fila < matrix.getFilas()){
                    for(columna = 0; columna < matrix.getColumnas(); columna++){
                        valor = iterator1.next() + iterator2.next();
                        matrix.setCelda(fila, columna, valor);
                    }
                    fila++;
                }
            }
            else {
                columna = 0;
                while(iterator1.hasNext() && iterator2.hasNext() && columna < matrix.getColumnas()){
                    for(fila = 0; fila < matrix.getFilas(); fila++){
                        valor = iterator1.next() + iterator2.next();
                        matrix.setCelda(fila, columna, valor);
                    }
                    columna++;
                }
            }
        }
        else throw new ArithmeticException();

        return matrix;
    }

    public String toString(Matrix matrix){
        return matrix.toString();
    }

}
