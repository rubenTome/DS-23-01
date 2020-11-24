package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    int [][] arr1 = {{1,2,3}, {4,5,6}, {7,8,9}};
    int[] ar1 = {7,8,9};
    int[] ar2 = {1,4,7};
    Matrix m1 = new Matrix(arr1);

    @Test
    void matrixTest(){
        assertEquals(1 ,m1.getCelda(0,0));
        m1.setCelda(1,0,0);
        assertEquals(0, m1.getCelda(1,0));
        assertArrayEquals(ar1,m1.getFila(2));
        assertArrayEquals(ar2,m1.getColumna(0));
        assertThrows(IllegalArgumentException.class, () -> m1.getColumna(4));
        assertThrows(IllegalArgumentException.class, () -> m1.getFila(4));


        assertThrows(UnsupportedOperationException.class, () -> m1.columnRowIterator().remove());
        assertThrows(UnsupportedOperationException.class, () -> m1.rowColumnIterator().remove());
    }
}