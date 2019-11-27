package hw_03;

import java.util.ArrayList;

public class task_02 {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(new Record("Иванов", "+7916000001"));
        phoneBook.add(new Record("Петров", "+7916000002"));
        phoneBook.add(new Record("Иванов", "+7916000003"));

        String surnameFind = "Иванов";
        ArrayList<Record> find = phoneBook.get(surnameFind);
        if (find.isEmpty()){
            System.out.println(surnameFind + " в справочнике не найден!");
        } else {
            find.forEach(record -> System.out.println(record.getNumberPhone()));
        }

        ArrayList<String> findPhone = phoneBook.getPhone(surnameFind);
        if (findPhone.isEmpty()){
            System.out.println(surnameFind + " в справочнике не найден!");
        } else {
            System.out.println(findPhone);
        }
    }
}
