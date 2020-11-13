package e2;

public class Matrix {

    private int [][] matriz;
    private int filas, columnas;

    public Matrix( int rows, int columns){
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < columns; c++){
                this.matriz[r][c] = 0;
            }
        }
        this.filas = rows;
        this.columnas = columns;
    }

    public Matrix(int [][] m){
        for(int i = 0; i < m.length - 1; i++){
            if(m[i].length != m[i+1].length) throw new IllegalArgumentException();
        }

        for(int r = 0; r < m.length; r++){
            for(int c = 0; c < m[r].length; c++){
                this.matriz[r][c] = m[r][c];
            }
        }

        this.filas = m.length;
        this.columnas = m[0].length;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }


}
