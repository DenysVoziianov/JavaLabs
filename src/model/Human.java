package model;

public class Human {
    private String firstName;
    private String lastName;
    private String patronymic;
    private Sex sex;

    public Human(String firstName, String lastName, String patronymic, Sex sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.sex = sex;
    }

    // Геттери
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPatronymic() { return patronymic; }
    public Sex getSex() { return sex; }

    // Сеттери
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }
    public void setSex(Sex sex) { this.sex = sex; }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + patronymic + " (" + sex + ")";
    }
}