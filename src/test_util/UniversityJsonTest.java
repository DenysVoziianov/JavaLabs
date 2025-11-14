package test_util;

import model.*;
import controller.*;
import util.JsonManager;
import org.junit.Test;
import static org.junit.Assert.*;

public class UniversityJsonTest {

    @Test
    public void testUniversityJsonSerialization() {
        // Створюємо старий університет з двома підрозділами на кожному рівні
        University oldUniversity = createTestUniversity();

        // Створюємо JsonManager
        JsonManager jsonManager = new JsonManager();

        // Шлях до файлу
        String filePath = "test_university.json";

        // Записуємо університет у файл
        jsonManager.saveUniversityToJson(oldUniversity, filePath);

        // Зчитуємо університет з файлу
        University newUniversity = jsonManager.loadUniversityFromJson(filePath);

        // Перевіряємо, що університети еквівалентні
        assertNotNull("Новий університет не повинен бути null", newUniversity);
        assertEquals("Університети повинні бути еквівалентні", oldUniversity, newUniversity);

        // Видаляємо тестовий файл
        new java.io.File(filePath).delete();
    }

    private University createTestUniversity() {
        HumanCreator humanCreator = new HumanCreator();
        StudentCreator studentCreator = new StudentCreator();
        DepartmentCreator departmentCreator = new DepartmentCreator();
        GroupCreator groupCreator = new GroupCreator();
        FacultyCreator facultyCreator = new FacultyCreator();
        UniversityCreator universityCreator = new UniversityCreator();

        // Створюємо ректора
        Human rector = humanCreator.createHuman("Іван", "Петренко", "Степанович", Sex.MALE);
        University university = universityCreator.createUniversity("Національний технічний університет", rector);

        // Створюємо факультет
        Human dean = humanCreator.createHuman("Олена", "Сидоренко", "Миколаївна", Sex.FEMALE);
        Faculty faculty = facultyCreator.createFaculty("Факультет комп'ютерних наук", dean);

        // Створюємо дві кафедри
        Human deptHead1 = humanCreator.createHuman("Андрій", "Коваленко", "Олександрович", Sex.MALE);
        Department dept1 = departmentCreator.createDepartment("Кафедра програмної інженерії", deptHead1);

        Human deptHead2 = humanCreator.createHuman("Марія", "Іваненко", "Петрівна", Sex.FEMALE);
        Department dept2 = departmentCreator.createDepartment("Кафедра штучного інтелекту", deptHead2);

        // Додаємо кафедри до факультету
        faculty.addDepartment(dept1);
        faculty.addDepartment(dept2);

        // Створюємо дві групи для кожної кафедри
        // Групи для першої кафедри
        Human groupHead1 = humanCreator.createHuman("Дмитро", "Шевченко", "Андрійович", Sex.MALE);
        Group group1 = groupCreator.createGroup("КН-21-1", groupHead1);

        Human groupHead2 = humanCreator.createHuman("Анна", "Мельник", "Сергіївна", Sex.FEMALE);
        Group group2 = groupCreator.createGroup("КН-21-2", groupHead2);

        // Групи для другої кафедри
        Human groupHead3 = humanCreator.createHuman("Олексій", "Бондар", "Вікторович", Sex.MALE);
        Group group3 = groupCreator.createGroup("КН-21-3", groupHead3);

        Human groupHead4 = humanCreator.createHuman("Софія", "Коваль", "Олегівна", Sex.FEMALE);
        Group group4 = groupCreator.createGroup("КН-21-4", groupHead4);

        // Додаємо по два студенти до кожної групи
        addStudentsToGroup(group1, studentCreator, "Перший", "Перший");
        addStudentsToGroup(group1, studentCreator, "Другий", "Другий");

        addStudentsToGroup(group2, studentCreator, "Третій", "Третій");
        addStudentsToGroup(group2, studentCreator, "Четвертий", "Четвертий");

        addStudentsToGroup(group3, studentCreator, "П'ятий", "П'ятий");
        addStudentsToGroup(group3, studentCreator, "Шостий", "Шостий");

        addStudentsToGroup(group4, studentCreator, "Сьомий", "Сьомий");
        addStudentsToGroup(group4, studentCreator, "Восьмий", "Восьмий");

        // Додаємо групи до факультету
        faculty.addGroup(group1);
        faculty.addGroup(group2);
        faculty.addGroup(group3);
        faculty.addGroup(group4);

        // Додаємо факультет до університету
        university.addFaculty(faculty);

        return university;
    }

    private void addStudentsToGroup(Group group, StudentCreator studentCreator, String firstName, String lastName) {
        Student student1 = studentCreator.createStudent(firstName + "Студент", lastName, "Олегович", Sex.MALE);
        Student student2 = studentCreator.createStudent(firstName + "Студентка", lastName, "Миколаївна", Sex.FEMALE);
        group.addStudent(student1);
        group.addStudent(student2);
    }
}