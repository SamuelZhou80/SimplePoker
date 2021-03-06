package com.example.simplepoker.suite;

import com.example.simplepoker.ExampleTest;
import com.example.simplepoker.PacerCalculateTest;
import com.example.simplepoker.ParameterTest;
import com.example.simplepoker.TestPoker;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ExampleTest.class, ParameterTest.class, TestPoker.class, PacerCalculateTest.class})
public class SuitTest {
}
