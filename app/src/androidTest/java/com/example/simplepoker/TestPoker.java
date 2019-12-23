package com.example.simplepoker;

import android.content.Intent;
import android.os.Bundle;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Test;

public class TestPoker extends ActivityInstrumentationTestCase2<PlayPoker24> {

    public TestPoker() {
        super(PlayPoker24.class);
    }

    @Override
    public PlayPoker24 getActivity() {
        PlayPoker24 a;
        Intent i = new Intent();
        Bundle b = new Bundle();
        b.putString("name", "sss");
        b.putString("id", "sss");
        // a = launchActivityWithIntent(targetPackage, OneActivity.class, i);
        a = launchActivity("com.example.simplepoker", PlayPoker24.class, b);
        setActivity(a);
        System.out.println("getActivity--------------------------");
        return a;
    }

    @Test
    public void test1() {
        System.out.println("---------start test1-----------------");
        getActivity().exhaustiveCalc(3, 4, 8, 2);
    }
}
