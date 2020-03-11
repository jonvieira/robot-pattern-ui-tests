package com.jonas.simplelogin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.buttonLogin
import kotlinx.android.synthetic.main.activity_main.editTextEmail
import kotlinx.android.synthetic.main.activity_main.editTextPassword
import kotlinx.android.synthetic.main.activity_main.textViewNewAccount

const val VALID_EMAIL = "test@test.com"
const val VALID_PASS = "pass123"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonLogin.setOnClickListener { validateLogin() }
        textViewNewAccount.setOnClickListener { createNewAccount() }
    }

    private fun validateLogin() {
        val email = editTextEmail.text.toString()
        val password = editTextPassword.text.toString()

        if (email == VALID_EMAIL && password == VALID_PASS)
            startActivity(Intent(this, DashboardActivity::class.java))
        else
            showAlertDialogInvalidLogin()
    }

    private fun createNewAccount() = startActivity(Intent(this, CreateAccountActivity::class.java))

    private fun showAlertDialogInvalidLogin() = AlertDialog.Builder(this@MainActivity).apply {
        setTitle(getString(R.string.attention))
        setMessage(getString(R.string.error_login))
        setPositiveButton(android.R.string.ok, null)
        create().show()
    }
}
