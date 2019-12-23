package com.example.simplepoker;

import com.example.simplepoker.utils.GpsUtils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParameterTest {
    private int mParam1;
    private int mParam2;
    private int mParam3;

    @Parameters
    public static Collection<Object[]> initTestData() {
        return Arrays.asList(new Object[][]{
                {3, 1, 2},
                {10, 5, 5},
                {6, 4, 2},
                {7, 3, 4}
        });
    }

    public ParameterTest(int input1, int input2, int input3) {
        mParam1 = input1;
        mParam2 = input2;
        mParam3 = input3;
    }

    @Before
    public void setup() {
        System.out.println("before ParameterTest");
    }

    @Test
    public void testGetDate() {
        Assert.assertNotEquals(1, GpsUtils.getAllDays(mParam1, mParam2, mParam3));
    }
}
