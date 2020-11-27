package e2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MatrixAdditionTest {

    int[][] arr1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[][] arr2 = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
    int[][] arr3 = {{2, 3, 4}, {5, 6, 7}, {8, 9, 10}};
    int[][] arr4 = {{4, 3, 2}, {1, 0, 1}};

    Matrix m1 = new Matrix(arr1);
    Matrix m2 = new Matrix(arr2);
    Matrix m3 = new Matrix(arr3);
    Matrix m4 = new Matrix(arr4);
    Matrix mSum;
    Matrix mSum2;
    MatrixAddition suma = new MatrixAddition();

    @Test
    void sumarMatrices() {

        mSum = new Matrix(suma.SumarMatrices(m1,m2).getMatriz());

        assertTrue(Arrays.deepEquals(m3.getMatriz(),mSum.getMatriz()));

        m1.setIterator(SelectIterator.COLUMN_ROW);
        m2.setIterator(SelectIterator.COLUMN_ROW);

        mSum2 = new Matrix(suma.SumarMatrices(m1,m2).getMatriz());

        assertTrue(Arrays.deepEquals(m3.getMatriz(),mSum.getMatriz()));

        //toString
        m1.setIterator(SelectIterator.ROW_COLUMN);
        m2.setIterator(SelectIterator.ROW_COLUMN);
        assertEquals("[2, 3, 4]\n[5, 6, 7]\n[8, 9, 10]\n", suma.toString(mSum));
        assertEquals("[2, 3, 4]\n[5, 6, 7]\n[8, 9, 10]\n", suma.toString(mSum2));

        //Sumas no válidas
        assertThrows(ArithmeticException.class, () -> suma.SumarMatrices(m1,m4));
        assertThrows(NullPointerException.class, () -> suma.SumarMatrices(m2, null));

    }
}