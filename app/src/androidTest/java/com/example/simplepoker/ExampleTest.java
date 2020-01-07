package com.example.simplepoker;

import android.test.suitebuilder.annotation.MediumTest;

import com.example.simplepoker.utils.GpsUtils;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@MediumTest
public class ExampleTest {

    @Before
    public void before() throws Exception {
        System.out.println("before Test");
    }

    @Test
    public void testOne() {
        assertTrue(GpsUtils.isLeapYear(2020));
        assertFalse("isLeapYear assert false", GpsUtils.isLeapYear(2022));
        assertThat(GpsUtils.getDay(2020, 2), is(29));
        assertNotEquals(28, GpsUtils.getDay(2020, 2));
    }
}
