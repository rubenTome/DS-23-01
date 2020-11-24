package e2;

import org.junit.jupiter.api.Test;

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
    MatrixAddition suma = new MatrixAddition();

    @Test
    void sumarMatrices() {

        assertEquals(m3, suma.SumarMatrices(m1,m2));

        m1.setIterator(SelectIterator.COLUMN_ROW);
        m2.setIterator(SelectIterator.COLUMN_ROW);

        assertEquals(m3, suma.SumarMatrices(m1,m2));

        assertThrows(ArithmeticException.class, () -> suma.SumarMatrices(m1,m4));
        assertThrows(ArithmeticException.class, () -> suma.SumarMatrices(m2, null));

    }
}