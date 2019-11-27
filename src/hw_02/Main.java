package hw_02;

public class Main {
    public static void main(String[] args) {
        String[][] myMantix1 = {
                {"1","33","7","3"}
                ,{"2","34","8","6"}
                ,{"3","35","9","9"}
                ,{"4","36","10","12"}
        };
        String[][] myMantix2 = {
                {"1","33","7"}
                ,{"2","34","8"}
                ,{"3","35","9"}
        };
        String[][] myMantix3 = {
                {"1s","33","7","3"}
                ,{"2","34","8","6"}
                ,{"3","35","9","9"}
                ,{"4","36","10","12"}
        };

        System.out.println("Правильный вариант");
        try {
            SquareMatrix test1 = new SquareMatrix(myMantix1);
            System.out.println(test1.sum_matrix());
        } catch (MyArrayDataException | MyArraySizeException e){
            e.printStackTrace();
        }
        System.out.println("*********************************");
        System.out.println("Неправильный вариант: неверный размер");
        try {
            SquareMatrix test2 = new SquareMatrix(myMantix2);
//            SquareMatrix test2 = new SquareMatrix(myMantix2,3);
            System.out.println(test2.sum_matrix());
        } catch (MyArrayDataException | MyArraySizeException e){
            e.printStackTrace();
        }
        System.out.println("*********************************");
        System.out.println("Неправильный вариант: передан нецелый тип данных");
        try {
            SquareMatrix test3 = new SquareMatrix(myMantix3);
            System.out.println(test3.sum_matrix());
        } catch (MyArrayDataException | MyArraySizeException e){
            e.printStackTrace();
        }
    }
}
