import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

class Student {
    String name;
    String lastName;
    int studentID;
    int age;
    int year;

    public Student(String name, String lastName, int studentID, int age, int year) {
        this.name = name;
        this.lastName = lastName;
        this.studentID = studentID;
        this.age = age;
        this.year = year;
    }
        public String toString() {
        return name + " " + lastName + ", student ID" + studentID + ", Age: " + age + ", Year: " + year;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.print("Student Management System\n 1.Add a new student \n 2.View all students \n 3.Delete student \n 4.Exit\n");

        Scanner obj = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();
        while (true) {
            System.out.print("\nChoose an option: ");
            String option = obj.nextLine();

            if (option.equals("1")) {
                System.out.print("Enter student's name: ");
                String name = obj.nextLine();

                System.out.print("Enter student's last name: ");
                String lastName = obj.nextLine();

                System.out.print("Enter student ID: ");
                int studentID = obj.nextInt();
                obj.nextLine();
                for (Student student : studentList) {
                    if (student.studentID == studentID) {
                        System.out.println("Student ID not available");
                    }
                }

                int age = 0;
                while (age < 18 ) {
                    System.out.print("Enter student's age: ");
                    age = obj.nextInt();
                    if (age < 18 || age >100) {
                        System.out.println("Students need to be at least 18 years old ");
                    }
                }
                obj.nextLine();
                int year = 0;
                while (year < 1 || year > 4) {
                    System.out.print("Which year student is this: ");
                    year = obj.nextInt();
                    if (year < 1 || year > 4) {
                        System.out.println("There are only options from year 1 to year 4");
                    }
                }
                obj.nextLine();
                Student newStudent = new Student(name, lastName, studentID, age, year);
                studentList.add(newStudent);
                System.out.println("You added a student: " + newStudent);

            } else if (option.equals("2")) {
                System.out.println("All students:");
                for (Student student : studentList) {
                    System.out.println(student);
                }
                System.out.print("Search students from specific year:");
                int studentsFromYear = obj.nextInt();
                obj.nextLine();
                if (studentsFromYear < 1 || studentsFromYear > 4) {
                    System.out.println("There are only options from year 1 to 4");
                } else {
                    for (Student student : studentList) {
                        if (student.year == studentsFromYear) {
                            System.out.println(student);
                        }
                    }
                }

            } else if (option.equals("3")) {
                System.out.print("Enter student's ID to delete that student:");
                int studentToDelete = obj.nextInt();
                Iterator<Student> iterator = studentList.iterator();
                while (iterator.hasNext()) {
                    Student student = iterator.next();
                    if (studentToDelete == student.studentID) {
                        iterator.remove();
                        System.out.print("Student deleted successfully\n");
                        break;
                    }
                }
            } else if (option.equals("4")) {
                System.out.println("Exiting the program");
                break;
            }
        }
        obj.close();
    }
}
