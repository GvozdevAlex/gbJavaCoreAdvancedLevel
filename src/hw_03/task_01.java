package hw_03;

import java.util.ArrayList;
import java.util.Arrays;

public class task_01 {

    public static void main(String[] args) {
        String[] Words = {
                "Первый"
                , "Второй", "Второй"
                ,"Третий", "Третий", "Третий"
                ,"Четвертый", "Четвертый", "Четвертый"
                ,"четвертый"
                ,"Пятый", "Пятый", "Пятый", "Пятый", "Пятый"
        };
        System.out.println("Исходный массив");
        System.out.println(Arrays.asList(Words) +  "\n");

        ArrayList<String> WordsDistinct = new ArrayList<>();
        for (int i = 0; i < Words.length; i++) {
            if (!WordsDistinct.contains(Words[i])) {
                WordsDistinct.add(Words[i]);
            }
        }

        int count = 0;
        for (int i = 0; i < WordsDistinct.size(); i++) {
            count = 0;
            for (int j = 0; j < Words.length; j++) {
                if (WordsDistinct.get(i) == Words[j]){
                    count += 1;
                }
            }
            System.out.println("Слово " + WordsDistinct.get(i) + " встречается " + count + " раз");
        }
    }
}
