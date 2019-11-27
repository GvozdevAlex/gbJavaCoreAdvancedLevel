package hw_02;


public class MyArraySizeException extends ArrayIndexOutOfBoundsException {

    public MyArraySizeException(String s, int size) {
        super(s + " " + size);
    }
}
