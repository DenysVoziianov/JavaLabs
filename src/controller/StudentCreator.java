package controller;

import model.Student;
import model.Sex;

public class StudentCreator {
    public Student createStudent(String firstName, String lastName, String patronymic, Sex sex) {
        return new Student(firstName, lastName, patronymic, sex);
    }
}