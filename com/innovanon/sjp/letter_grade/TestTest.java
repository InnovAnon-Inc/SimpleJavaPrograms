package com.innovanon.sjp.letter_grade;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestTest.
 * @see com.innovanon.sjp.letter_grade.Test
 */
public class TestTest {
	@Test (expected=IllegalArgumentException.class)
    public void testGetLetterGrade_negative () {
		com.innovanon.sjp.letter_grade.Test t = new com.innovanon.sjp.letter_grade.Test ();
		char g = t.getLetterGrade (-1);
		fail ();
	}
	
    @Test
    public void testGetLetterGrade_0 () {
		com.innovanon.sjp.letter_grade.Test t = new com.innovanon.sjp.letter_grade.Test ();
		char g = t.getLetterGrade (0);
		assertEquals (g, 'F');
	}
	
	@Test
    public void testGetLetterGrade_59 () {
		com.innovanon.sjp.letter_grade.Test t = new com.innovanon.sjp.letter_grade.Test ();
		char g = t.getLetterGrade (59);
		assertEquals (g, 'F');
	}
	
	@Test
    public void testGetLetterGrade_60 () {
		com.innovanon.sjp.letter_grade.Test t = new com.innovanon.sjp.letter_grade.Test ();
		char g = t.getLetterGrade (60);
		assertEquals (g, 'D');
	}
	
	@Test
    public void testGetLetterGrade_69 () {
		com.innovanon.sjp.letter_grade.Test t = new com.innovanon.sjp.letter_grade.Test ();
		char g = t.getLetterGrade (69);
		assertEquals (g, 'D');
	}
	
	@Test
    public void testGetLetterGrade_70 () {
		com.innovanon.sjp.letter_grade.Test t = new com.innovanon.sjp.letter_grade.Test ();
		char g = t.getLetterGrade (70);
		assertEquals (g, 'C');
	}
	
	@Test
    public void testGetLetterGrade_79 () {
		com.innovanon.sjp.letter_grade.Test t = new com.innovanon.sjp.letter_grade.Test ();
		char g = t.getLetterGrade (79);
		assertEquals (g, 'C');
	}
	
	@Test
    public void testGetLetterGrade_80 () {
		com.innovanon.sjp.letter_grade.Test t = new com.innovanon.sjp.letter_grade.Test ();
		char g = t.getLetterGrade (80);
		assertEquals (g, 'B');
	}
	
	@Test
    public void testGetLetterGrade_89 () {
		com.innovanon.sjp.letter_grade.Test t = new com.innovanon.sjp.letter_grade.Test ();
		char g = t.getLetterGrade (89);
		assertEquals (g, 'B');
	}
	
	@Test
    public void testGetLetterGrade_90 () {
		com.innovanon.sjp.letter_grade.Test t = new com.innovanon.sjp.letter_grade.Test ();
		char g = t.getLetterGrade (90);
		assertEquals (g, 'A');
	}
	
	@Test
    public void testGetLetterGrade_99 () {
		com.innovanon.sjp.letter_grade.Test t = new com.innovanon.sjp.letter_grade.Test ();
		char g = t.getLetterGrade (99);
		assertEquals (g, 'A');
	}
	
	@Test
    public void testGetLetterGrade_100 () {
		com.innovanon.sjp.letter_grade.Test t = new com.innovanon.sjp.letter_grade.Test ();
		char g = t.getLetterGrade (100);
		assertEquals (g, 'A');
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetMessage_negative () {
		com.innovanon.sjp.letter_grade.Test t = new com.innovanon.sjp.letter_grade.Test ();
		String m = t.getMessage ("you", "-1");
		fail ();
	}
	
	@Test
	public void testGetMessage_0 () {
		com.innovanon.sjp.letter_grade.Test t = new com.innovanon.sjp.letter_grade.Test ();
		String m = t.getMessage ("you", "0");
		assertEquals (m, "Your grade is 0. That's an F.");
	}
	
	@Test
	public void testGetMessage_59 () {
		com.innovanon.sjp.letter_grade.Test t = new com.innovanon.sjp.letter_grade.Test ();
		String m = t.getMessage ("you", "59");
		assertEquals (m, "Your grade is 59. That's an F.");
	}
	
	@Test
	public void testGetMessage_60 () {
		com.innovanon.sjp.letter_grade.Test t = new com.innovanon.sjp.letter_grade.Test ();
		String m = t.getMessage ("you", "60");
		assertEquals (m, "Your grade is 60. That's a D.");
	}
	
	@Test
	public void testGetMessage_69 () {
		com.innovanon.sjp.letter_grade.Test t = new com.innovanon.sjp.letter_grade.Test ();
		String m = t.getMessage ("you", "69");
		assertEquals (m, "Your grade is 69. That's a D.");
	}
	
	@Test
	public void testGetMessage_70 () {
		com.innovanon.sjp.letter_grade.Test t = new com.innovanon.sjp.letter_grade.Test ();
		String m = t.getMessage ("you", "70");
		assertEquals (m, "Your grade is 70. That's a C.");
	}
	
	@Test
	public void testGetMessage_79 () {
		com.innovanon.sjp.letter_grade.Test t = new com.innovanon.sjp.letter_grade.Test ();
		String m = t.getMessage ("you", "79");
		assertEquals (m, "Your grade is 79. That's a C.");
	}
	
	@Test
	public void testGetMessage_80 () {
		com.innovanon.sjp.letter_grade.Test t = new com.innovanon.sjp.letter_grade.Test ();
		String m = t.getMessage ("you", "80");
		assertEquals (m, "Your grade is 80. That's a B.");
	}
	
	@Test
	public void testGetMessage_89 () {
		com.innovanon.sjp.letter_grade.Test t = new com.innovanon.sjp.letter_grade.Test ();
		String m = t.getMessage ("you", "89");
		assertEquals (m, "Your grade is 89. That's a B.");
	}
	
	@Test
	public void testGetMessage_90 () {
		com.innovanon.sjp.letter_grade.Test t = new com.innovanon.sjp.letter_grade.Test ();
		String m = t.getMessage ("you", "90");
		assertEquals (m, "Your grade is 90. That's an A.");
	}
	
	@Test
	public void testGetMessage_99 () {
		com.innovanon.sjp.letter_grade.Test t = new com.innovanon.sjp.letter_grade.Test ();
		String m = t.getMessage ("you", "99");
		assertEquals (m, "Your grade is 99. That's an A.");
	}
	
	@Test
	public void testGetMessage_100 () {
		com.innovanon.sjp.letter_grade.Test t = new com.innovanon.sjp.letter_grade.Test ();
		String m = t.getMessage ("you", "100");
		assertEquals (m, "Your grade is 100. That's an A.");
	}
}
