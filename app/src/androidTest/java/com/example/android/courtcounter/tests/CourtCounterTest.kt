package com.example.android.courtcounter.tests

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.courtcounter.MainActivity
import com.example.android.courtcounter.R
import com.example.android.courtcounter.utils.BaseTest
import com.example.android.courtcounter.robot.CounterTestRobot
import org.hamcrest.Matchers
import org.hamcrest.Matchers.allOf
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

//type out the run with line and it will import the required parts
@RunWith(AndroidJUnit4::class)
class MyFirstTest: BaseTest() {

    //This test class will be testing the interaction between the HomeActivity and DetailsActivity
    private lateinit var counterTestRobot: CounterTestRobot


    @Before
    fun setup() {
        counterTestRobot = CounterTestRobot()
    }


    @Test
    fun checkTeamAPoints() {

        with(counterTestRobot){
            launchApp()
        }

        with(counterTestRobot) {
            checkTeamAPointsIsDisplayed()
        }
    }

    @Test
    fun tapTeamAFreeThrow() {

        ActivityScenario.launch(MainActivity::class.java)

        onView(allOf(withId(R.id.freethrowButton)))
                .perform(click())

        onView(allOf(withId(R.id.team_a_score)))
                .check(matches(withText("1")))

    }
}