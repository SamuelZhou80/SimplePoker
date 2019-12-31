package com.example.simplepoker;

import android.content.Context;
import android.test.suitebuilder.annotation.MediumTest;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@MediumTest
public class ExampleInstrumentationTest {

    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = MyApplication.getAppContext();

        assertEquals("com.example.simplepoker", appContext.getPackageName());
    }

    @Before
    public void before() throws Exception {
        System.out.println("before InstrumentationTest");
    }

    @Test
    public void testOne() {
        assertNotEquals(100, 300);
    }
}
