package com.jonas.simplelogin.login

import androidx.annotation.IdRes
import com.jonas.simplelogin.R
import com.jonas.simplelogin.core.BaseUITest

fun login(func: LoginRobot.() -> Unit) = LoginRobot().apply { func() }

class LoginRobot : BaseUITest() {
    fun typeEmail(email: String) = fillEditText(R.id.editTextEmail, email)
    fun typePassword(pass: String) = fillEditText(R.id.editTextPassword, pass)
    fun clickLoginButton() = clickButton(R.id.buttonLogin)
    fun clickCreateAccountButton() = clickButton(R.id.textViewNewAccount)
    fun checkAlertDialog(@IdRes dialogTitle: Int) = alertDialog(dialogTitle)
}