package com.verizon.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestScoringServiceGetGrade.class,TestScoringServicePercentage.class})

public class AllTests {
}
