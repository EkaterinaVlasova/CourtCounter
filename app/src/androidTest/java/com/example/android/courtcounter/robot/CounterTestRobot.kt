package com.example.android.courtcounter.robot

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.android.courtcounter.MainActivity
import com.example.android.courtcounter.R
import org.hamcrest.Matchers.allOf

class CounterTestRobot {

    val TEAM_A_SCORE = "0"

    fun launchApp() {

        ActivityScenario.launch(MainActivity::class.java)
    }

    fun checkTeamAPointsIsDisplayed() {

        onView(allOf(ViewMatchers.withId(R.id.team_a_score), withText(TEAM_A_SCORE)))
                .check(ViewAssertions.matches(ViewMatchers.isCompletelyDisplayed()))
    }
}