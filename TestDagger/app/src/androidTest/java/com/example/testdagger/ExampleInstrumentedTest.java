package com.example.testdagger;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import androidx.test.rule.ActivityTestRule;
import static org.junit.Assert.*;
/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.testdagger", appContext.getPackageName());
    }

    @Test
    public void mostrar() {
        onView(withId(R.id.mostrar)).perform(click());
        onView(withId(R.id.texto)).check(matches(withText("Con este curso de arquitectura de desafío latam " +
                "he aprendido nuevos conceptos en esta materia " + "" +
                "y con este buen grupo, me siento motivado y " +
                "estoy satisfechos con este comienzo.")));
    }

    @Test
    public void limpiar() {
        onView(withId(R.id.limpiar)).perform(click());
        onView(withId(R.id.texto)).check(matches(withText("")));
    }

}
