package com.jai.Assertions;

import com.jai.Student;
import com.jai.StudentNotFoundException;
import com.jai.StudentService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {

    @Test
    void getStudentByIdTestUsingAssertNull() {
        StudentService service = new StudentService();

        // No students added yet
        Student actualStudent = service.getStudentById(1);

        // Check that no student found (should be null)
        assertNull(actualStudent, "Expected null because no student exists with ID 1");
    }

    @Test
    void getStudentByIdTestUsingAssertNotNull() {
        StudentService service = new StudentService();
        Student student = new Student(1, "Ramesh");
        service.addStudent(student);

        Student actualStudent = service.getStudentById(1);

        // Check that student exists (should not be null)
        assertNotNull(actualStudent, "Expected a student object, but found null");
    }

    @Test
    void getStudentByIdTestUsingAssertEquals_IdAndName() {
        StudentService service = new StudentService();
        Student expectedStudent = new Student(1, "Ramesh");
        service.addStudent(expectedStudent);

        Student actualStudent = service.getStudentById(1);

        // Compare ID
        assertEquals(1, actualStudent.getId(), "Student ID should be 1");

        // Compare Name
        assertEquals("Ramesh", actualStudent.getName(), "Student name should be Ramesh");

        // Compare entire Student object
        assertEquals(expectedStudent, actualStudent, "Expected and actual student objects should match");
    }

    @Test
    void studentShouldNotHaveIncorrectName() {
        StudentService service = new StudentService();
        Student correctStudent = new Student(1, "Ramesh");
        service.addStudent(correctStudent);

        Student fetchedStudent = service.getStudentById(1);

        // This should pass because names are not equal
        assertNotEquals("Suresh", fetchedStudent.getName(),
                () -> "Expected name to be different from 'Suresh', but got: " + fetchedStudent.getName());
    }


    @Test
    @DisplayName("Should throw StudentNotFoundException when student name does not exist")
    void testGetStudentByName_ThrowsException() {
        StudentService service = new StudentService();
        service.addStudent(new Student(1, "Ramesh"));

        // Using 2-argument assertThrows
        assertThrows(StudentNotFoundException.class, () -> {
            service.getStudentByName("amesh");
        });
    }

    @Test
    void testGetStudentByName_ThrowsExceptionWithCustomMessage() {
        StudentService service = new StudentService();

        // Using 3-argument assertThrows with custom failure message
        assertThrows(StudentNotFoundException.class, () -> {
            service.getStudentByName("Ramesh");
        }, "Expected exception for non-existent student name");
    }

    @Test
    @Disabled("This test is disabled until bug #123 is fixed")
    void testGetStudentByName_TemporarilyDisabled() {
        // This test won't run
    }



}
