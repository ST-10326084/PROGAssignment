package Main;
import static Main.Menu.input;
import static Main.Menu.mainMenu;
import java.util.*;
// All information sourced from Joyce Farrel,202, Java Programming Cengage 9th Edition
// and Bro Code, 2020, Java Full Course for Free, Youtube (https://www.youtube.com/watch?v=xk4_1vDrzzo)


public class Student {
    public static Scanner input = new Scanner(System.in);          
    static List<Student> students = new ArrayList<>();

    // added so unit tests are easier 
    static Object getStudents() {
        students.get(1);
        return students;
    }

    // added so unit tests are easier 
     public int getStudentId() {
        return studentID;
    }
    
    // added so unit tests are easier 
    public static Student getStudentById(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null; 
    }

    

    private int studentID;
    private String studentName;
    private int studentAge;
    private String studentEmail;
    private String studentCourse;
    private static boolean studentSaved = false;
    
    // Constructor to initialize student objects
    public Student(int studentID, String studentName, int studentAge, String studentEmail, String studentCourse) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentEmail = studentEmail;
        this.studentCourse = studentCourse;
        this.studentSaved = studentSaved;
    }
    
    public int getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public String getStudentCourse() {
        return studentCourse;
    }          
    
    public boolean getStudentSaved() {
        return studentSaved;
    }

    // save student method adds students to memory 
    public static void SaveStudent() {
        
        System.out.println("Capture a new Student");
        System.out.println("---------------------");

        try {
            System.out.print("Enter the student id: ");
            int studentID = input.nextInt();
            input.nextLine();

            System.out.print("Enter the student name: ");
            String studentName = input.nextLine();

            // age
            int studentAge = 0;
            boolean validAge = false;
            while (!validAge) {
                try {
                    System.out.print("Enter the student age: ");
                    studentAge = input.nextInt();
                    input.nextLine();

                    if (studentAge >= 16) {
                        validAge = true;
                    } else {
                        System.out.println("Student age must be at least 16.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input for student age. Please enter an integer.");
                    input.nextLine();
                }
            }

            // email
            System.out.print("Enter the student email: ");
            String studentEmail = input.next();
            input.nextLine();

            // course
            System.out.print("Enter the student course: ");
            String studentCourse = input.nextLine();

            // Create a new Student object and add it to the students list everytime a new student is created
            students.add(new Student(studentID, studentName, studentAge, studentEmail, studentCourse));

            System.out.println("Student saved successfully.");
            System.out.println("_______________________");
            studentSaved = true;
            
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data for the student.");
            input.nextLine();
        }
    }

    // search for students by ID rather than index 
    public static void SearchStudent() {
        System.out.println("Enter the student ID to search for them:");

        int studentIDToSearch = input.nextInt();
        boolean studentIsFound = false;

        for (Student student : students) {
            if (student.getStudentID() == studentIDToSearch) {
                System.out.println("Student found with ID " + studentIDToSearch + ":");
                System.out.println("Student Name: " + student.getStudentName());
                System.out.println("Student Age: " + student.getStudentAge());
                System.out.println("Student Email: " + student.getStudentEmail());
                System.out.println("Student Course: " + student.getStudentCourse());
                studentIsFound = true;
                break;
            }
        }

        if (!studentIsFound) {
            System.out.println("Student with ID " + studentIDToSearch + " not found.");
        }
    }

    // method to delete students 
    public static void DeleteStudent(int studentIDToDelete) { 
        System.out.println("Enter the student ID to delete:");
        studentIDToDelete = input.nextInt();
        input.nextLine();
        
        boolean studentFound = false;
        for (Student student : students) {
            if (student.getStudentID() == studentIDToDelete) {
                System.out.println("Student found with ID " + studentIDToDelete + ":");
                System.out.println("Are you sure you want to delete this student? (y/n)");
                String confirmation = input.nextLine();

                // confirmation code
                if (confirmation.equalsIgnoreCase("y") || confirmation.equalsIgnoreCase("yes")) {
                    students.remove(student);
                    System.out.println("Student with ID " + studentIDToDelete + " has been deleted.");
                } else {
                    System.out.println("Deletion canceled.");
                }

                studentFound = true;
                break;
            }
        }

        if (!studentFound) {
            System.out.println("_________________________________________________");
            System.out.println("Student with ID " + studentIDToDelete + " not found.");
            System.out.println("_________________________________________________");
        }
    }

    // display for students
    public static void StudentReport() {
        System.out.println("Student Information for All Students:");
        System.out.println("*************************************");

        for (Student student : students) {
            System.out.println("Student ID: " + student.studentID);
            System.out.println("Student Name: " + student.studentName);
            System.out.println("Student Age: " + student.studentAge);
            System.out.println("Student Email: " + student.studentEmail);
            System.out.println("Student Course: " + student.studentCourse);
            System.out.println("__________________________");
        } 
            System.out.println("Enter (1) to launch menu or any other key to exit");

        String userInput = input.nextLine();

        if (userInput.equalsIgnoreCase("1")) {
            mainMenu();
        } else {
            Student.ExitStudentApplication();
        }
            
            
        }
    

    // exit app
    public static void ExitStudentApplication() {
        System.out.println("Exiting the program");
        System.exit(0);
    }

}
