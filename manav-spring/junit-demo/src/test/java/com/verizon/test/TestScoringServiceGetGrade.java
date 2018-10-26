package com.verizon.test;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import com.verizon.model.Grade;
import com.verizon.service.ScoringService;

@RunWith(Parameterized.class)
public class TestScoringServiceGetGrade {
	ScoringService ss;
	private double inputAvg;
	private Grade expectedGrade;

	public TestScoringServiceGetGrade(double inputAvg, Grade expectedGrade) {
		this.inputAvg = inputAvg;
		this.expectedGrade = expectedGrade;
	}

	@Parameters
	public static Collection testData() {
		Object[][] data = { { 90, Grade.A }, { 80, Grade.B }, { 70, Grade.C }, { 69, Grade.F } };
		return Arrays.asList(data);
	}

	@Before
	public void setUp() throws Exception {
		this.ss = new ScoringService();
	}

	@After
	public void tearDown() throws Exception {
		this.ss = null;
	}

@Test	
public void testGetGrade() {

	 assertEquals(expectedGrade,ss.getGrade(inputAvg));	}
}
