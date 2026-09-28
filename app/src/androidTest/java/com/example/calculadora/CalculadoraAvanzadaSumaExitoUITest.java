package com.example.calculadora;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class CalculadoraAvanzadaSumaExitoUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testSumaExito(){
        onView(withId(R.id.btnAvanzada)).perform(click());
        onView(withId(R.id.tv2)).perform(click());
        onView(withId(R.id.tvRes)).perform(click());
        onView(withId(R.id.tv3)).perform(click());
        onView(withId(R.id.tvEqu)).perform(click());

        onView(withId(R.id.tvResult)).check(matches(withText("-1")));
    }
}
