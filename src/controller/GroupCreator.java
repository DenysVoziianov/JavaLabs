package controller;

import model.Group;
import model.Human;
import model.Student;

public class GroupCreator {
    public Group createGroup(String name, Human head) {
        return new Group(name, head);
    }
}