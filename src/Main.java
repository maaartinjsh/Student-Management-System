import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

// Creating Student class to store information related to the students
class Student {
    String name;
    String lastName;
    int studentID;
    int age;
    int year;

    //Constructing all student objects
    public Student(String name, String lastName, int studentID, int age, int year) {
        this.name = name;
        this.lastName = lastName;
        this.studentID = studentID;
        this.age = age;
        this.year = year;
    }

    // print student details in a way that is easy read
    @Override
    public String toString() {
        return name + " " + lastName + ", student ID" + studentID + ", Age: " + age + ", Year: " + year;
    }
}

// class which stores all the functions
public class Main {
   
    public static void main(String[] args) {

        System.out.print("Student Management System\n 1.Add a new student \n 2.View all students \n 3.Delete student \n 4.Exit\n");

        Scanner obj = new Scanner(System.in); // for user inputs
        List<Student> studentList = new ArrayList<>(); // array list to save student records
        while (true) { // while loop so the system doesn't stop when user picks 1 option
            System.out.print("\nChoose an option: ");
            String option = obj.nextLine();

            // Option 1 for adding students
            if (option.equals("1")) {
                System.out.print("Enter student's name: ");
                String name = obj.nextLine(); //input student's name

                System.out.print("Enter student's last name: ");
                String lastName = obj.nextLine(); //input student's lastname

                System.out.print("Enter student ID: ");
                int studentID = obj.nextInt(); //input student's ID
                obj.nextLine();

                // Check if ID is already used in system
                for (Student student : studentList) { // finds all student's
                    if (student.studentID == studentID) { // check's if user inputted student ID is already in system
                        System.out.println("Student ID not available"); // prints out message that ID is not available
                    }
                }


                int age = 0; // Sets the student age as 0

                while (age < 18 ) { // checks if entered age is allowed
                    System.out.print("Enter student's age(at least 18): ");
                    age = obj.nextInt(); // enters age if it is allowed
                    if (age < 18 || age >100) { //checks if entered age is not allowed
                        System.out.println("Students need to be at least 18 years old "); // prints message that age is not valid
                    }
                }

                obj.nextLine();
                int year = 0; // sets the year to 0

                while (year < 1 || year > 4) { // allows to input year
                    System.out.print("Which year student is this(choose from year 1 to year 4): ");
                    year = obj.nextInt(); // if year is 1-4 system saves it to array list
                    if (year < 1 || year > 4) {
                        System.out.println("There are only options from year 1 to year 4");// doesn't allow to input year
                    }
                }

                obj.nextLine();
                // new student object
                Student newStudent = new Student(name, lastName, studentID, age, year);
                studentList.add(newStudent); // adds student to the array list
                System.out.println("You added a student: " + newStudent); // prints out array with added student

                // Option 2, view added students
            } else if (option.equals("2")) {
                System.out.println("All students:"); // display all students
                for (Student student : studentList) { // gets all Student objects from studentList
                    System.out.println(student); // prints all students that student variable receives
                }

                System.out.print("Search students from specific year:");
                int studentsFromYear = obj.nextInt(); // new variable to check if there are students form specific year
                obj.nextLine();

                //checks if entered year is valid
                if (studentsFromYear < 1 || studentsFromYear > 4) {
                    System.out.println("There are only options from year 1 to 4");
                } else {
                    for (Student student : studentList) {
                        if (student.year == studentsFromYear) { // checks if year from studentList matches the entered number in studentsFromYear
                            System.out.println(student); // if the variable studentsFromYear matches with studentList year it prints out the students
                        }
                    }
                }

            } else if (option.equals("3")) {
                System.out.print("Enter student's ID to delete that student:");
                int studentToDelete = obj.nextInt();// variable for entering a number
                Iterator<Student> iterator = studentList.iterator(); // delete a specific student

                while (iterator.hasNext()) {
                    Student student = iterator.next();
                    if (studentToDelete == student.studentID) { // checks if number in studentToDelete matches studentID from studentList
                        iterator.remove();// removes student if numbers from studentToDelete and studentID matches
                        System.out.print("Student deleted successfully\n"); // prints out that student has been deleted

                    }
                }
                // Option 4, exit the program
            } else if (option.equals("4")) {
                System.out.println("Exiting the program");
                break;// breaks while loop
            }
        }
        obj.close();//destruct's the object
    }
}
