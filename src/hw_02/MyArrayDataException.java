package hw_02;


public class MyArrayDataException extends NumberFormatException{
    private int _row;
    private int _column;
    private String _value;

    public MyArrayDataException(String message, int row, int column, String value) {
        super(message);
        this._row = row;
        this._column = column;
        this._value = value;
    }

    public int get_row() {
        return _row;
    }

    public int get_column() {
        return _column;
    }

    public String get_value() {
        return _value;
    }
}
