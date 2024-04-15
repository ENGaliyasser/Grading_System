package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class SubjectTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testSubjectConstructorWithString() {
        // Test for constructor that takes a string
        String subjectString = "Software testing,CSE333,100";
        Subject subject = new Subject(subjectString);

        assertEquals("Software testing", subject.getName());
        assertEquals("CSE333", subject.getCode());
        assertEquals(100, subject.getFullMark());
        assertNotNull(subject.getStudents()); // Ensure students ArrayList is initialized
        assertEquals(0, subject.getStudents().size()); // Ensure students ArrayList is empty initially
    }

    @Test
    void testGettersAndSetters() {
        // Test for getters and setters
        Subject subject = new Subject("Test", "ABC123", 90);

        subject.setName("New Test");
        assertEquals("New Test", subject.getName());

        subject.setCode("XYZ789");
        assertEquals("XYZ789", subject.getCode());

        subject.setFullMark(95);
        assertEquals(95, subject.getFullMark());

        // Test for setting and getting students ArrayList
        Student student1 = new Student("alii", "12345678", 10, 10, 20, 55);
        Student student2 = new Student("ali", "87654321", 10, 10, 20, 60);
        subject.getStudents().add(student1);
        subject.getStudents().add(student2);

        assertEquals(2, subject.getStudents().size());
        assertEquals(student1, subject.getStudents().get(0));
        assertEquals(student2, subject.getStudents().get(1));
    }
}