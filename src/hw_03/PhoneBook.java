package hw_03;

import java.util.ArrayList;
import java.util.Iterator;

public class PhoneBook {
    private ArrayList<Record> records;

    public PhoneBook() {
        this.records = new ArrayList<Record>();
    }

    public void add(Record record) {
        records.add(record);
    }

    public ArrayList<Record> get(String surname) {
        ArrayList<Record> findRecords = new ArrayList<Record>();
        for (Record record:records) {
            if (record.getSurname().equals(surname)){
                findRecords.add(record);
            }
        }

        //не получилось реализовать через iterator
//        Iterator<Record> iterator = records.iterator();
//        while (iterator.hasNext()){
//            if (iterator.next().getSurname() == surname){
//                findRecords.add((Record) iterator);
//            }
//        }
        return findRecords;
    }
    public ArrayList<String> getPhone(String surname) {
        ArrayList<String> findPhone = new ArrayList<String>();
        for (Record record:records) {
            if (record.getSurname().equals(surname)){
                findPhone.add(record.getNumberPhone());
            }
        }
        return findPhone;
    }

}
