package com.verizon.test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.verizon.exception.ScoreException;
import com.verizon.service.ScoringService;

public class TestScoringServicePercentage {
	private ScoringService ss;

	@Before
	public void setUp() throws Exception {
		this.ss = new ScoringService();
	}

	@After
	public void tearDown() throws Exception {
		this.ss = null;
	}

	@Test
	public void testGetPercentageWithValidData() {
		int[] marks = { 50, 60, 50 };
		int maxMarks = 100;
		double expectedPercent = 53.33;
		try {
			double actual = ss.getPercentage(marks, maxMarks);
			assertEquals(expectedPercent, actual,0.5);
		} catch (ScoreException e) {
			fail("Exception not be raised in this case");
		}
	}

	@Test(expected = ScoreException.class)
	public void testGetPercentageWithNullMarks() throws ScoreException {
		int[] marks = null;
		int maxMarks = 100;
		ss.getPercentage(marks, maxMarks);
		fail("Expecting an Exception");
	}

	@Test(expected = ScoreException.class)
	public void testGetPercentageWithZeroMaxMarks() throws ScoreException {
		int[] marks = { 23, 44, 55 };
		int maxMarks = 0;
		ss.getPercentage(marks, maxMarks);
		fail("Expecting an Max Marks Zero Exception");
	}

	@Test(expected = ScoreException.class)
	public void testGetPercentageWithZeroInvalidMarks() throws ScoreException {
		int[] marks = { 23, -44, 55 };
		int maxMarks = 100;
		ss.getPercentage(marks, maxMarks);
		fail("Expecting an Negative Exception");
	}

}