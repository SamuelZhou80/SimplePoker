package com.example.simplepoker;

import com.example.simplepoker.PacerCalculate;
import com.example.simplepoker.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
// import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

@RunWith(AndroidJUnit4.class)
public class PacerCalculateTest {

    // private static final String PACKAGE_ESPRESSOTESTS = "com.example.simplepoker";

    @Rule
    public ActivityScenarioRule<PacerCalculate> activityRule =
            new ActivityScenarioRule<>(PacerCalculate.class);

//    @Before
//    public void intentsInit() {
//        // initialize Espresso Intents capturing
//        Intents.init();
//    }
//
//    @After
//    public void intentsTeardown() {
//        // release Espresso Intents capturing
//        Intents.release();
//    }

    @Test
    public void testPacerCalculate() {
        onView(withId(R.id.edit_speed)).perform(typeText("605"), closeSoftKeyboard());
        onView(withId(R.id.button_1)).perform(click());
    }
}
