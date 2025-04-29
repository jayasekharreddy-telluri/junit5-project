package com.jai.Assertions;

import com.jai.Student;
import com.jai.StudentNotFoundException;
import com.jai.StudentService;
import org.junit.jupiter.api.*;

public class StudentServiceTest2 {

    private static StudentService studentService;
    private Student testStudent;

    @BeforeAll
    static void setupAll() {
        System.out.println("⚙ Setting up shared resources...");
        studentService = new StudentService(); // This will run only once
    }

    @BeforeEach
    void setup() {
        System.out.println("🔄 Setting up before each test...");
        // Reset the service before each test (if needed)
        testStudent = new Student(1, "Ramesh");
        studentService.addStudent(testStudent); // Add fresh student for each test
    }

    @Test
    void testGetStudentByNameSuccess() {
        Student found = studentService.getStudentByName("Ramesh");
        Assertions.assertNotNull(found);
        Assertions.assertEquals("Science", found.getName());
        System.out.println("✅ testGetStudentByNameSuccess passed");
    }

    @Test
    void testGetStudentByNameThrowsException() {
        Assertions.assertThrows(StudentNotFoundException.class, () -> {
            studentService.getStudentByName("John"); // not present
        });
        System.out.println("✅ testGetStudentByNameThrowsException passed");
    }

    @AfterEach
    void tearDown() {
        System.out.println("♻ Cleaning up after each test...");
        // Clear student list to ensure test isolation

    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("🧹 Releasing shared resources...");
        studentService = null;
    }
}
