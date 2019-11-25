package hw_02;

public class SquareMatrix {
    private int _size = 4;
    private int[][] _matrix;

    public SquareMatrix(String[][] matrix, int size) throws MyArraySizeException, MyArrayDataException {
        if (size > 0) {
            this._size = size;
        }
        try{
            check_size(matrix);
            this.initMatrix(matrix);
        } catch (MyArraySizeException e){
            throw e;
        }
        catch (MyArrayDataException e){
            System.out.println("Ячейка [" + e.get_row() + ":" + e.get_column() + "] " + e.get_value());
            throw e;
        }
    }

    public SquareMatrix(String[][] matrix) throws MyArraySizeException, MyArrayDataException {
        try{
            check_size(matrix);
            this.initMatrix(matrix);
        } catch (MyArraySizeException e){
            throw e;
        }
        catch (MyArrayDataException e){
            System.out.println("Ячейка [" + e.get_row() + ":" + e.get_column() + "] " + e.get_value());
            throw e;
        }
    }

    private void initMatrix(String[][] matrix) throws MyArrayDataException {
        this._matrix = new int[this._size][this._size];

        for (int i = 0; i < this._matrix.length; i++) {
            for (int j = 0; j < this._matrix[i].length; j++) {
                try{
                    this._matrix[i][j] = Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException("Передан нецелый тип данных", i+1, j+1, matrix[i][j]);
                }
            }
        }
    }

    private boolean check_size(String[][] matrix) throws MyArraySizeException {
        boolean result = true;

        if (matrix.length != this._size) {
            result = false;
            throw new MyArraySizeException("Превышен размер квадратной матрицы ", this._size);
        }
        for (int i = 0; i < matrix.length; i++){
            if (matrix[i].length != this._size) {
                result = false;
                throw new MyArraySizeException("Превышен размер квадратной матрицы ", this._size);
            }
        }
        return result;
    }

    public int sum_matrix(){
        int sum = 0;
        for (int i = 0; i < this._size; i++){
            for (int j = 0; j < this._size; j++){
                    sum += this._matrix[i][j];
            }
        }
        return sum;
    }
}
