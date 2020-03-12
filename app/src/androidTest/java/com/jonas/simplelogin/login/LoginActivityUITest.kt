package com.jonas.simplelogin.login

import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import androidx.test.rule.ActivityTestRule
import com.jonas.simplelogin.CreateAccountActivity
import com.jonas.simplelogin.DashboardActivity
import com.jonas.simplelogin.LoginActivity
import com.jonas.simplelogin.R
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class LoginActivityUITest {

    private val validEmail = "test@test.com"
    private val invalidEmail = "test"
    private val validPassword = "pass123"
    private val invalidPassword = "pass"

    @get:Rule
    var activityRule = ActivityTestRule(LoginActivity::class.java)

    @Before
    fun setup() = Intents.init()

    @After
    fun cleanUp() = Intents.release()

    @Test
    fun loginSuccessfully() {
        login {
            typeEmail(validEmail)
            typePassword(validPassword)
            clickLoginButton()
            Intents.intended(hasComponent(DashboardActivity::class.java.name))
        }
    }

    @Test
    fun loginWithWrongEmail() {
        login {
            typeEmail(invalidEmail)
            typePassword(validPassword)
            clickLoginButton()
            checkAlertDialog(R.string.attention)
        }
    }

    @Test
    fun loginWithWrongPassword() {
        login {
            typeEmail(validEmail)
            typePassword(invalidPassword)
            clickLoginButton()
            checkAlertDialog(R.string.attention)
        }
    }

    @Test
    fun checkIfGoToCreateAccount() {
        login {
            clickCreateAccountButton()
            Intents.intended(hasComponent(CreateAccountActivity::class.java.name))
        }
    }
}