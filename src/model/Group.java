package model;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private Human head;
    private List<Student> students;

    public Group(String name, Human head) {
        this.name = name;
        this.head = head;
        this.students = new ArrayList<>();
    }

    // Геттери
    public String getName() { return name; }
    public Human getHead() { return head; }
    public List<Student> getStudents() { return students; }

    // Сеттери
    public void setName(String name) { this.name = name; }
    public void setHead(Human head) { this.head = head; }

    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public String toString() {
        return "Група: " + name + ", Староста: " + head + ", Кількість студентів: " + students.size();
    }
}