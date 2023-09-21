package Main;
import java.util.*;
// All information sourced from Joyce Farrel,202, Java Programming Cengage 9th Edition
// and Bro Code, 2020, Java Full Course for Free, Youtube (https://www.youtube.com/watch?v=xk4_1vDrzzo)

public class Menu {
    public static Scanner input = new Scanner(System.in);
    
    public static void introMenu() {
        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("*************************************");
        System.out.println("Enter (1) to launch menu or any other key to exit");

        try {
            int menuChoice = input.nextInt();

            if (menuChoice == 1) {
                mainMenu();
            } else {
                Student.ExitStudentApplication();
            }
        } catch (InputMismatchException e) {
            Student.ExitStudentApplication();
            input.nextLine();
        }
    }

    public static void mainMenu() {
    boolean exitFlag = false;

    while (!exitFlag) {
        System.out.println("Please select one of the following menu items: ");
        System.out.println("(1) Capture a new student.");
        System.out.println("(2) Search for a student.");
        System.out.println("(3) Delete a student.");
        System.out.println("(4) Print student report.");
        System.out.println("(5) Exit Application");

        int menuChoice = input.nextInt();
        
        switch (menuChoice) {
            case 1:
                Student.SaveStudent();
                break;
            case 2:
                Student.SearchStudent();
                break;
            case 3:
                Student.DeleteStudent(0);
                break;
            case 4:
                Student.StudentReport();
                break;
            case 5:
                Student.ExitStudentApplication();
                exitFlag = true;
                break;
            default:
                System.out.println("Incorrect number chosen. Please choose a number from 1 to 5.");
        }
    }
    }
}


