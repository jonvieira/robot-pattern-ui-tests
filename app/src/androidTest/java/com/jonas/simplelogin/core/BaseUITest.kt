package com.jonas.simplelogin.core

import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText

open class BaseUITest {
    fun fillEditText(@IdRes idRes: Int, text: String): ViewInteraction =
        onView(withId(idRes))
            .perform(typeText(text), closeSoftKeyboard())

    fun clickButton(@IdRes idRes: Int): ViewInteraction =
        onView(withId(idRes))
            .perform(click())

    fun alertDialog(@IdRes idRes: Int): ViewInteraction =
        onView(withText(idRes))
            .inRoot(isDialog())
            .check(matches(isDisplayed()))
}