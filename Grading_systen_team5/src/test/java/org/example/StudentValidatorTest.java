package org.example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class StudentValidatorTest {

	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
	}


	////////// TEST FOR checkStudentName() //////////////////
	@Test
	void testCheckStudentNameValid() {
		// Test for valid student name
		Student student1 = new Student("ali", "12345678", 10, 10, 20, 55);
		assertEquals("", StudentValidator.checkStudentName(student1));
	}
	void testCheckStudentNameSpace() {
		// Test for student name starting with a space
		Student student2 = new Student(" ali yasser", "12345678", 10, 10, 20, 55);
		assertEquals(StudentValidator.STUDENT_NAME_SPACE, StudentValidator.checkStudentName(student2));

	}
	void testCheckStudentNameInvalid() {
		// Test for student name with invalid characters
		Student student3 = new Student("alik4k4", "12345678", 10, 10, 20, 55);
		assertEquals(StudentValidator.STUDENT_NAME_INVALID, StudentValidator.checkStudentName(student3));
	}
	void testCheckStudentNameEmpty() {
		// Test for student empty name 
		Student student4 = new Student("", "12345678", 10, 10, 20, 55);
		assertEquals(StudentValidator.STRING_EMPTY, StudentValidator.checkStudentName(student4));
	}

	//////////TEST FOR checkStudentNumber() //////////////////

	@Test
	void testCheckStudentNumberInvalidLength() {
		// Test for invalid student number length
		Student student1 = new Student("ali", "1234567", 10, 10, 20, 55);
		assertEquals(StudentValidator.STUDENT_NUMBER_INVALID_LENGTH, StudentValidator.checkStudentNumber(student1));
	}
	@Test
	void testCheckStudentNumberContainChar() {
		// Test for student number with characters   
		Student student2 = new Student("ali", "123456ab", 10, 10, 20, 55);
		assertEquals(StudentValidator.STUDENT_NUMBER_CONTAIN, StudentValidator.checkStudentNumber(student2));
	}
	@Test
	void testCheckStudentNumberEnd() {
		// Test for student number not ending with an alphabet/digit
		Student student3 = new Student("ali", "1234567&", 10, 10, 20, 55);
		assertEquals(StudentValidator.STUDENT_NUMBER_END, StudentValidator.checkStudentNumber(student3));
	}
	@Test
	void testCheckStudentNumberValid() {
		// Test for valid student number
		Student student4 = new Student("ali", "12345678", 10, 10, 20, 55);
		assertEquals("", StudentValidator.checkStudentNumber(student4));

		// Test for valid student number
		Student student5 = new Student("ali", "1234567p", 10, 10, 20, 55);
		assertEquals("", StudentValidator.checkStudentNumber(student5));

	}
	//////////TEST FOR checkActivities() //////////////////

	@Test
	void testCheckActivitiesValid() {
		// Test for valid activities mark
		Student student1 = new Student("noha", "12345678", 10, 10, 20, 55);
		assertEquals("", StudentValidator.checkActivities(student1));
	}
	@Test
	void testCheckActivitiesExceedLimit() {
		// Test for activities mark exceeding the limit
		Student student2 = new Student("noha", "12345679", 11, 10, 20, 55);
		assertEquals(StudentValidator.ERROR_ACTIVITES_MARK, StudentValidator.checkActivities(student2));
	}
	@Test
	void testCheckActivitiesNegative() {
		// Test for negative activities mark
		Student student3 = new Student("noha", "12345670", -1, 10, 20, 55);
		assertEquals(StudentValidator.ERROR_ACTIVITES_MARK, StudentValidator.checkActivities(student3));
	}
	//////////TEST FOR checkOral() //////////////////
	@Test
	void testCheckOralValid() {
		// Test for valid oral/practical mark
		Student student1 = new Student("shebl", "12345678", 10, 10, 20, 55);
		assertEquals("", StudentValidator.checkOral(student1));
	}
	@Test
	void testCheckOralExceedLimit() {
		// Test for oral/practical mark exceeding the limit
		Student student2 = new Student("shebl", "12345679", 10, 11, 20, 55);
		assertEquals(StudentValidator.ERROR_ORAL_MARK, StudentValidator.checkOral(student2));
	}
	@Test
	void testCheckOralNegative() {
		// Test for negative oral/practical mark
		Student student3 = new Student("shebl", "12345670", 10, -1, 20, 55);
		assertEquals(StudentValidator.ERROR_ORAL_MARK, StudentValidator.checkOral(student3));

	}
	//////////TEST FOR checkMidterm() //////////////////
	@Test
	void testCheckMidtermValid() {
		// Test for valid midterm mark
		Student student1 = new Student("donia", "12345678", 10, 10, 20, 55);
		assertEquals("", StudentValidator.checkMidterm(student1));
	}
	@Test
	void testCheckMidtermExceedLimit() {
		// Test for midterm mark exceeding the limit
		Student student2 = new Student("donia", "12345679", 10, 10, 21, 55);
		assertEquals(StudentValidator.ERROR_MIDTERM_MARK, StudentValidator.checkMidterm(student2));
	}
	@Test
	void testCheckMidtermNegative() {
		// Test for negative midterm mark
		Student student3 = new Student("donia", "12345670", 10, 10, -1, 55);
		assertEquals(StudentValidator.ERROR_MIDTERM_MARK, StudentValidator.checkMidterm(student3));
	}

	//////////TEST FOR checkFinal() //////////////////
	@Test
	void testCheckFinalValid() {
		// Test for valid final exam mark
		Student student1 = new Student("rezk", "12345678", 10, 10, 20, 55);
		assertEquals("", StudentValidator.checkFinal(student1));
	}

	@Test
	void testCheckFinalExceedLimit() {
		// Test for final exam mark exceeding the limit
		Student student2 = new Student("rezk", "12345679", 10, 10, 20, 61);
		assertEquals(StudentValidator.ERROR_FINAL_MARK, StudentValidator.checkFinal(student2));
	}

	@Test
	void testCheckFinalNegative() {
		// Test for negative final exam mark
		Student student3 = new Student("rezk", "12345670", 10, 10, 20, -1);
		assertEquals(StudentValidator.ERROR_FINAL_MARK, StudentValidator.checkFinal(student3));
	}	

	//////////TEST FOR checkStudentData() //////////////////
	@Test
	void testCheckStudentDataValid() {
		// Test for valid student data
		Student student1 = new Student("carol", "12345678", 10, 10, 20, 55);
		assertEquals("", StudentValidator.checkStudentData(student1));
	}
	@Test
	void testCheckStudentDataInvalid() {
		// Test for invalid student data (multiple errors)
		Student student2 = new Student("carol123", "1234567&", 11, -1, 21, 61);
		assertEquals(StudentValidator.STUDENT_NAME_INVALID +
				StudentValidator.STUDENT_NUMBER_END +
				StudentValidator.ERROR_ACTIVITES_MARK +
				StudentValidator.ERROR_FINAL_MARK +
				StudentValidator.ERROR_ORAL_MARK +
				StudentValidator.ERROR_MIDTERM_MARK
				,
				StudentValidator.checkStudentData(student2));
	}	

}