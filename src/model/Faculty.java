package model;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String name;
    private Human head;
    private List<Department> departments;
    private List<Group> groups;

    public Faculty(String name, Human head) {
        this.name = name;
        this.head = head;
        this.departments = new ArrayList<>();
        this.groups = new ArrayList<>();
    }

    // Геттери
    public String getName() { return name; }
    public Human getHead() { return head; }
    public List<Department> getDepartments() { return departments; }
    public List<Group> getGroups() { return groups; }

    // Сеттери
    public void setName(String name) { this.name = name; }
    public void setHead(Human head) { this.head = head; }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    @Override
    public String toString() {
        return "Факультет: " + name + ", Декан: " + head +
                ", Кафедр: " + departments.size() + ", Груп: " + groups.size();
    }
}