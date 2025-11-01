import model.*;
import controller.*;

public class Run {
    public static void main(String[] args) {
        University university = createTypicalUniversity();
        displayUniversityStructure(university);
    }

    public static University createTypicalUniversity() {
        HumanCreator humanCreator = new HumanCreator();
        StudentCreator studentCreator = new StudentCreator();
        DepartmentCreator departmentCreator = new DepartmentCreator();
        GroupCreator groupCreator = new GroupCreator();
        FacultyCreator facultyCreator = new FacultyCreator();
        UniversityCreator universityCreator = new UniversityCreator();

        Human rector = humanCreator.createHuman("Іван", "Петренко", "Степанович", Sex.MALE);
        University university = universityCreator.createUniversity("Національний технічний університет", rector);

        Human dean = humanCreator.createHuman("Олена", "Сидоренко", "Миколаївна", Sex.FEMALE);
        Faculty computerScienceFaculty = facultyCreator.createFaculty("Факультет комп'ютерних наук", dean);

        Human departmentHead1 = humanCreator.createHuman("Андрій", "Коваленко", "Олександрович", Sex.MALE);
        Department softwareEngineeringDept = departmentCreator.createDepartment("Кафедра програмної інженерії", departmentHead1);

        Human departmentHead2 = humanCreator.createHuman("Марія", "Іваненко", "Петрівна", Sex.FEMALE);
        Department aiDept = departmentCreator.createDepartment("Кафедра штучного інтелекту", departmentHead2);

        computerScienceFaculty.addDepartment(softwareEngineeringDept);
        computerScienceFaculty.addDepartment(aiDept);

        Human groupHead1 = humanCreator.createHuman("Дмитро", "Шевченко", "Андрійович", Sex.MALE);
        Group group1 = groupCreator.createGroup("КН-21-1", groupHead1);

        Human groupHead2 = humanCreator.createHuman("Анна", "Мельник", "Сергіївна", Sex.FEMALE);
        Group group2 = groupCreator.createGroup("КН-21-2", groupHead2);

        Student student1 = studentCreator.createStudent("Олександр", "Бондар", "Вікторович", Sex.MALE);
        Student student2 = studentCreator.createStudent("Юлія", "Ткаченко", "Ігорівна", Sex.FEMALE);
        Student student3 = studentCreator.createStudent("Максим", "Лисенко", "Олегович", Sex.MALE);
        Student student4 = studentCreator.createStudent("Катерина", "Павленко", "Дмитрівна", Sex.FEMALE);

        group1.addStudent(student1);
        group1.addStudent(student2);
        group2.addStudent(student3);
        group2.addStudent(student4);

        computerScienceFaculty.addGroup(group1);
        computerScienceFaculty.addGroup(group2);

        university.addFaculty(computerScienceFaculty);

        return university;
    }

    public static void displayUniversityStructure(University university) {
        System.out.println("=== СТРУКТУРА УНІВЕРСИТЕТУ ===");
        System.out.println(university);
        System.out.println();

        for (Faculty faculty : university.getFaculties()) {
            System.out.println(faculty);

            System.out.println("Кафедри:");
            for (Department department : faculty.getDepartments()) {
                System.out.println("  - " + department);
            }

            System.out.println("Групи:");
            for (Group group : faculty.getGroups()) {
                System.out.println("  - " + group);
                for (Student student : group.getStudents()) {
                    System.out.println("      * " + student);
                }
            }
            System.out.println();
        }
    }
}