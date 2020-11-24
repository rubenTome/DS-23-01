package e2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Matrix implements Iterable<Integer>{

    private int [][] matriz;
    private final int filas, columnas;
    private SelectIterator iterator = SelectIterator.ROW_COLUMN;

    public Matrix( int rows, int columns){
        this.matriz = new int[rows][columns];
        this.filas = rows;
        this.columnas = columns;
    }
    public Matrix(int [][] m){
        this.matriz = new int[m.length][m[0].length];
        for(int i = 0; i < m.length - 1; i++){
            if(m[i].length != m[i+1].length) throw new IllegalArgumentException();
        }


        for(int r = 0; r < m.length; r++){
            for(int c = 0; c < m[0].length; c++){
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

    public int getCelda(int vfila, int vcolumna){
        if(vfila >= matriz.length || vcolumna >= matriz[0].length)
            throw new IllegalArgumentException();
        else {
            return matriz[vfila][vcolumna];
        }
    }

    public void setCelda(int vfila, int vcolumna, int valor){
        if(vfila >= matriz.length || vcolumna >= matriz[0].length)
            throw new IllegalArgumentException();
        else {
            for(int f = 0; f < matriz.length; f++){
                for(int c = 0; c < matriz[0].length; c++){
                    if(f == vfila && c == vcolumna)
                        this.matriz[f][c] = valor;
                }
            }
        }
    }

    public void setIterator(SelectIterator iterator) {
        this.iterator = iterator;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public int[] getFila(int row){
        if (row < matriz.length) return this.getMatriz()[row];
        else throw new IllegalArgumentException();
    }

    public int[] getColumna(int column){

        int[] columna = new int[matriz[0].length];

        if (column < matriz[0].length) {
            for(int r = 0; r < matriz.length; r++){
                for(Integer c : matriz[r]){
                    if(c == column) columna[r] = this.getCelda(r,c);
                }
            }
        }
        else throw new IllegalArgumentException();
        return columna;
    }

    @Override
    public String toString(){
        StringBuilder matrixBuilder = new StringBuilder();
        for(int r = 0; r < matriz.length; r++){
            matrixBuilder.append("[");
            for(int c = 0; c < matriz[0].length; c++){
                matrixBuilder.append(this.getCelda(r,c)).append(", ");
            }
            matrixBuilder.append("]\n");
        }
        return matrixBuilder.toString();
    }

    public Iterator<Integer> rowColumnIterator(){
        return new RowColumnIterator(this);
    }

    public Iterator<Integer> columnRowIterator(){
        return new ColumnRowIterator(this);
    }

    @Override
    public Iterator<Integer> iterator() {
        if(this.iterator.equals(SelectIterator.ROW_COLUMN)){
            return rowColumnIterator();
        }
        else return columnRowIterator();
    }

    public static class RowColumnIterator implements Iterator<Integer>{

        int indexr = 0, indexc = 0;
        int[][] integerMatrix;

        public RowColumnIterator(Matrix matrix){
            this.integerMatrix = matrix.getMatriz();
        }

        @Override
        public boolean hasNext() {
            if(indexc < integerMatrix[0].length) return true;
            else {
                return indexr++ < integerMatrix.length;
            }
        }

        @Override
        public Integer next() {
            int valor;
            if(indexc < integerMatrix[0].length){
                valor = integerMatrix[indexr][indexc];
                indexc++;
            }
            else{
                if(hasNext()){
                   indexc = 0;
                   indexr++;
                   valor = integerMatrix[indexr][indexc];
                   indexc++;
                }
                else throw new NoSuchElementException();
            }
            return valor;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static class ColumnRowIterator implements Iterator<Integer>{

        int indexr = 0, indexc = 0;
        int[][] integerMatrix;

        public ColumnRowIterator(Matrix matrix){
            this.integerMatrix = matrix.getMatriz();
        }

        @Override
        public boolean hasNext() {
            if(indexr < integerMatrix.length) return true;
            else {
                return indexc++ < integerMatrix[0].length;
            }
        }

        @Override
        public Integer next() {
            int valor;
            if(indexr < integerMatrix.length){
                valor = integerMatrix[indexr][indexc];
                indexr++;
            }
            else{
                if(hasNext()){
                    indexr = 0;
                    indexc++;
                    valor = integerMatrix[indexr][indexc];
                    indexr++;
                }
                else throw new NoSuchElementException();
            }
            return valor;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
