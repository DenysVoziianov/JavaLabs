package model;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private Human head;
    private List<Faculty> faculties;

    public University(String name, Human head) {
        this.name = name;
        this.head = head;
        this.faculties = new ArrayList<>();
    }

    // Геттери
    public String getName() { return name; }
    public Human getHead() { return head; }
    public List<Faculty> getFaculties() { return faculties; }

    // Сеттери
    public void setName(String name) { this.name = name; }
    public void setHead(Human head) { this.head = head; }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    @Override
    public String toString() {
        return "Університет: " + name + ", Ректор: " + head +
                ", Факультетів: " + faculties.size();
    }
}