package Main;
// All information sourced from Joyce Farrel,202, Java Programming Cengage 9th Edition
// and Bro Code, 2020, Java Full Course for Free, Youtube (https://www.youtube.com/watch?v=xk4_1vDrzzo)
/**
 *
 * @author Dean
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testSaveStudent() {
        Student student = new Student(11, "John Doe", 18, "john@example.com", "Computer Science");
        Student.SaveStudent();
        Student savedStudent = Student.getStudentById(11);
        assertNotNull(savedStudent);
        assertEquals(student.getStudentID(), savedStudent.getStudentID());
        
    }

    @Test
    public void testSearchStudent_StudentFound() {
       
        Student student = new Student(12, "Alice Smith", 20, "alice@example.com", "Math");
        Student.students.add(student);

        Student foundStudent = Student.getStudentById(12);
        assertNotNull(foundStudent);
        assertEquals(student.getStudentID(), foundStudent.getStudentID());
        
    }

    @Test
    public void testSearchStudent_StudentNotFound() {
        Student foundStudent = Student.getStudentById(999);
        assertNull(foundStudent);
    }

    @Test
    public void testDeleteStudent_StudentFound() {
        
        Student student = new Student(13, "Bob Johnson", 22, "bob@example.com", "Physics");
        Student.students.add(student);

        int initialSize = Student.students.size();
        Student.DeleteStudent(13);
        int newSize = Student.students.size();

       
        assertEquals(initialSize - 1, newSize);
        assertNull(Student.getStudentById(13));
    }

    @Test
    public void testDeleteStudent_StudentNotFound() {
        
        int initialSize = Student.students.size();
        Student.DeleteStudent(999);
        int newSize = Student.students.size();

        assertEquals(initialSize, newSize);
    }

    @Test
    public void testStudentAge_StudentAgeValid() {
      
        Student student = new Student(14, "Eve Brown", 18, "eve@example.com", "Chemistry");
        assertEquals(18, student.getStudentAge());
    }

    @Test
    public void testStudentAge_StudentAgeInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Student(15, "Invalid Age", 15, "invalid@example.com", "Invalid Course");
        });
    }

    @Test
    public void testStudentAge_StudentAgeInvalidCharacter() {
        assertThrows(NumberFormatException.class, () -> {
            new Student(16, "Invalid Character Age", Integer.parseInt("abc"), "invalid@example.com", "Invalid Course");
        });
    }
}
