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
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;


@RunWith(AndroidJUnit4.class)
public class ListViewTest {
    private static final String KEY_ITEM = "配速计算器";
    private static final String KEY_ITEM2 = "24点游戏";

    /**
     * 在执行测试接口前启动对应的Activity, 结束后关闭
     */
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testListView() {
        // 通过listview的数据对象
        onData(allOf(is(instanceOf(Modules.class)), getListViewMatcherByText(KEY_ITEM))).perform(click());
        // onView(allOf(withText("配速计算器"))).perform(click());
    }

    @Test
    public void testSelectPokerGame() {
        onData(allOf(is(instanceOf(Modules.class)), getListViewMatcherByText(KEY_ITEM2))).perform(click());
    }

    /**
     * 构建列表项的匹配接口
     * @param text 待匹配的列表项文本
     * @return 数据匹配器
     */
    private static Matcher<Object> getListViewMatcherByText(final String text) {
        return new BoundedMatcher<Object, Modules>(Modules.class) {

            @Override
            public void describeTo(Description description) {
                description.appendText("get item by text:" + text);
            }

            @Override
            protected boolean matchesSafely(Modules item) {
                return item != null && item.name.equals(text);
            }
        };
    }
}
