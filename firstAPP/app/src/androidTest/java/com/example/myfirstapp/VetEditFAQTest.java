package com.example.myfirstapp;

import static org.junit.Assert.*;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class VetEditFAQTest {


    @Rule
    public ActivityTestRule<VetEditFAQ> mActivityTestRule = new ActivityTestRule<VetEditFAQ>(VetEditFAQ.class);
    private VetEditFAQ mActivity = null;


    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void TestLunchVetEditFAQ() {
        View view = mActivity.findViewById(R.id.tvVetPet);
        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}