package hw_03;

public class Record {
    private String surname;
    private String numberPhone;

    public Record(String surname, String numberPhone) {
        this.surname = surname;
        this.numberPhone = numberPhone;
    }

    public String getSurname() {
        return surname;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    @Override
    public String toString() {
        return this.surname + " - " + this.numberPhone;
    }
}
