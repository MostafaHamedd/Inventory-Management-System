package comp3350.ims.presentation;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.allOf;

import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.ims.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ActiveInventoryActivityTest {

    @Rule
    public ActivityTestRule<ActiveInventoryActivity> mActivityTestRule =
            new ActivityTestRule<>(ActiveInventoryActivity.class);

    @Test
    public void activeInventoryActivityTest() {
        ViewInteraction button = onView(
                allOf(withId(R.id.buttonManager), withText("Manager"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class))),
                        isDisplayed()));
        button.check(matches(isDisplayed()));
    }
}
