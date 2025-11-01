package model;

public class Department {
    private String name;
    private Human head;

    public Department(String name, Human head) {
        this.name = name;
        this.head = head;
    }

    // Геттери
    public String getName() { return name; }
    public Human getHead() { return head; }

    // Сеттери
    public void setName(String name) { this.name = name; }
    public void setHead(Human head) { this.head = head; }

    @Override
    public String toString() {
        return "Кафедра: " + name + ", Голова: " + head;
    }
}