package com.baking.mirela.bakingapp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.FragmentTransaction;

import com.baking.mirela.bakingapp.activity.mvp.Detail.DetailActivity;
import com.baking.mirela.bakingapp.activity.mvp.Detail.DetailFragment;
import com.baking.mirela.bakingapp.model.Recipe;
import com.baking.mirela.bakingapp.ui.MainFragment;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.baking.mirela.bakingapp", appContext.getPackageName());
    }

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);


    @Test
    public void fragment_can_be_instantiated() {
        mActivityRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                MainFragment fragment = startFragment();
            }
        });
        onView(withId(R.id.main_fragment)).check(matches(isDisplayed()));
    }

    private MainFragment startFragment() {
        MainActivity activity = (MainActivity) mActivityRule.getActivity();
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        MainFragment mainFragment = new MainFragment();
        transaction.commit();
        return mainFragment;
    }

    @Test
    public void recicleView_can_be_clicked() {

        onView(withId(R.id.my_recycler_view))
                .perform(actionOnItemAtPosition(0, click()));

        onView(withId(R.id.fragment_container)).check(matches(isDisplayed()));

    }

    @Rule
    public ActivityTestRule<DetailActivity> mDetailActivityRule = new ActivityTestRule(DetailActivity.class);


    @Test
    public void detailFragment_can_be_instantiated() {
        mDetailActivityRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                DetailFragment fragment = startDetailFragment();
            }
        });
        onView(withId(R.id.fragment_container)).check(matches(isDisplayed()));


    }

    private DetailFragment startDetailFragment() {
        DetailActivity activity = (DetailActivity) mDetailActivityRule.getActivity();
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        DetailFragment fragment = new DetailFragment();

        Recipe recipe = new Recipe();
        fragment.setRecipe(recipe);
        transaction.commit();
        return fragment;
    }

    @Test
    public void detailIngredianceButton_isVisible() {
        onView(withId(R.id.my_recycler_view))
                .perform(actionOnItemAtPosition(0, click()));

        onView(withId(R.id.Detail_fra)).check(matches(isDisplayed()));

        onView(withId(R.id.ingredient_button)).check(matches(isDisplayed()));

    }

    @Test
    public void detail_steps_recycler_view_can_click() {
        onView(withId(R.id.my_recycler_view))
                .perform(actionOnItemAtPosition(0, click()));

        onView(withId(R.id.Detail_fra)).check(matches(isDisplayed()));

        onView(withId(R.id.steps_recycler_view)).check(matches(isDisplayed()));

        onView(withId(R.id.steps_recycler_view))
                .perform(actionOnItemAtPosition(0, click()));

        onView(withId(R.id.fragment_container)).check(matches(isDisplayed()));

    }
}


