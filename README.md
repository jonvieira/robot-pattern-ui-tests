# Robot Pattern UI Test

PoC to demonstrate instrumented tests using RobotPattern. This PoC has only a login screen with local validation, an initial view and a fictitious account creation view, just to demonstrate the tests with navigation between the views.

# Screenshot

<img src="git/robot-pattern-poc.gif" width="250" title="hover text">

# Code sample

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