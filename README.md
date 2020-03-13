# Robot Pattern UI Test

PoC to demonstrate instrumented tests using RobotPattern. This PoC has only a login screen with local validation, an initial view and a fictitious account creation view, just to demonstrate the tests with navigation between the views.

# Screenshot

<img src="git/robot-pattern-poc.gif" width="250" title="hover text">

# Code sample

### LoginActivityUITest

```kotlin
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
```

### LoginRobot
```kotlin
    fun login(func: LoginRobot.() -> Unit) = LoginRobot().apply { func() }

    class LoginRobot : BaseUITest() {
        fun typeEmail(email: String) = fillEditText(R.id.editTextEmail, email)
        fun typePassword(pass: String) = fillEditText(R.id.editTextPassword, pass)
        fun clickLoginButton() = clickButton(R.id.buttonLogin)
        fun clickCreateAccountButton() = clickButton(R.id.textViewNewAccount)
        fun checkAlertDialog(@IdRes dialogTitle: Int) = alertDialog(dialogTitle)
    }
```

### BaseUITest
```kotlin 
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
```
