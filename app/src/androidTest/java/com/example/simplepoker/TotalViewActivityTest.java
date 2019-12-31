package com.example.simplepoker;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.matcher.BoundedMatcher;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

@RunWith(AndroidJUnit4.class)
public class TotalViewActivityTest {

    @Rule
    public ActivityScenarioRule<TotalViewActivity> activityRule =
            new ActivityScenarioRule<>(TotalViewActivity.class);

    @Test
    public void testSpinner() {
        onData(allOf(is(instanceOf(String.class)), getListViewMatcherByText("item2")))
                .inAdapterView(withId(R.id.test_spinner)).perform(click());
    }

    @Test
    public void testRadioButton() {
        onView(withId(R.id.radio_button1)).perform(click());
        onView(withId(R.id.radio_button3)).perform(click());
    }

    @Test
    public void testCheckButton() {
        onView(withId(R.id.manager_check2)).perform(click());
        // onView(withId(R.id.radio_button3)).perform(click());
    }

    /**
     * 构建列表项的匹配接口
     * @param text 待匹配的列表项文本
     * @return 数据匹配器
     */
    private static Matcher<Object> getListViewMatcherByText(final String text) {
        return new BoundedMatcher<Object, String>(String.class) {

            @Override
            public void describeTo(Description description) {
                description.appendText("get item by text:" + text);
            }

            @Override
            protected boolean matchesSafely(String item) {
                return item != null && item.equals(text);
            }
        };
    }
}
