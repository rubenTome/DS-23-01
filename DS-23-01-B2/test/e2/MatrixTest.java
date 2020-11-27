package e2;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    int [][] arr1 = {{1,2,3}, {4,5,6}, {7,8,9}};
    int[] ar1 = {7,8,9};
    int[] ar2 = {1,4,7};
    int[][] notarr = {{1,1,1}, {1,2}, {3,3,3}};
    int[][] notarr2 = {{1,1,1}, null, {3,3,3}};
    int [][] arr2 = new int[3][3];
    Matrix m1 = new Matrix(arr1);
    Matrix m2 = new Matrix(3,3);

    Iterator<Integer> it1;

    @Test
    void matrixTest(){

        //Operaciones fundamentales
        assertArrayEquals(ar1,m1.getFila(2));
        assertArrayEquals(ar2,m1.getColumna(0));

        assertEquals(3, m1.getFilas());
        assertEquals(3, m1.getColumnas());

        //toString
        assertEquals("[1, 2, 3]\n[4, 5, 6]\n[7, 8, 9]\n", m1.toString());


        //Modificar celda
        m1.setCelda(1,0,0);

        //Leer celda
        assertEquals(1 ,m1.getCelda(0,0));
        assertEquals(0, m1.getCelda(1,0));


        //Matriz a ceros
        assertArrayEquals(arr2, m2.getMatriz());

        //Iterators
        it1 = m1.iterator();
        int f1 = 0, c1;
        while(it1.hasNext() && f1 < m1.getFilas()){
            for(c1 = 0; c1 < m1.getColumnas(); c1++){
                assertEquals(m1.getMatriz()[f1][c1], it1.next());
            }
            f1++;
        }

        m1.setIterator(SelectIterator.COLUMN_ROW);
        it1 = m1.iterator();
        c1 = 0;
        while(it1.hasNext() && c1 < m1.getColumnas()){
            for(f1 = 0; f1 < m1.getFilas(); f1++){
                assertEquals(m1.getMatriz()[f1][c1], it1.next());
            }
            c1++;
        }

        //Lecturas no válidas
        assertThrows(IllegalArgumentException.class, () -> m1.getColumna(4));
        assertThrows(IllegalArgumentException.class, () -> m1.getFila(4));
        assertThrows(IllegalArgumentException.class, () -> m1.getCelda(4, 4));
        assertThrows(IllegalArgumentException.class, () -> m1.getCelda(0, 4));

        //Modificaciones no válidas
        assertThrows(IllegalArgumentException.class, () -> m1.setCelda(4,4,1));
        assertThrows(IllegalArgumentException.class, () -> m1.setCelda(0,4,1));
        assertThrows(IllegalArgumentException.class, () -> new Matrix(notarr));
        assertThrows(NullPointerException.class, () -> new Matrix(notarr2));
        assertThrows(NullPointerException.class, () -> new Matrix(null));


        //Remove
        assertThrows(UnsupportedOperationException.class, () -> m1.columnRowIterator().remove());
        assertThrows(UnsupportedOperationException.class, () -> m1.rowColumnIterator().remove());
    }
}