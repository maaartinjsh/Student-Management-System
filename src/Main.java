//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.lang.module.FindException;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

class Student {
    String name;
    String lastName;
    int age;
    int year;

    // Constructor to initialize a new student
    public Student(String name, String lastName, int age, int year) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.year = year;
    }

    // Override toString() to make displaying students easier
    @Override
    public String toString() {
        return name + " " + lastName + ", Age: " + age + ", Year: " + year;
    }
}


public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Student Management System\n 1.Add a new student \n 2.View all students \n 3.Delete student");

        Scanner obj = new Scanner(System.in);
        List<Object> studentList = new ArrayList<>();
        String option = "";
        System.out.print("Choose an option: ");
        option = obj.nextLine();

        String name = null;
        String lastName = null;
        if (option.equals("1")) {
            System.out.printf("Enter student's name: ");
            name = obj.nextLine();

            System.out.printf("Enter student's last name: ");
            lastName = obj.nextLine();

            System.out.printf("Enter student's age: ");
            int age = obj.nextInt();
            int year = 0;
            while (year < 1 || year > 4) {
                System.out.printf("Which year student is this: ");
                year = obj.nextInt();
                if (year < 1 || year > 4) {
                    System.out.println("There are only options from year 1 to year 4");
                }
            }
            System.out.printf("You added a student called: %s\n", name + " " + lastName + " " + age + " to year " + year);


        } else if (option.equals("2")) {
            System.out.printf("All students", name + " " + lastName);


        }


    }
}
