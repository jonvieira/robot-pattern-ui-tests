package com.jonas.simplelogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_dashboard.toolbar

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        initViews()
    }

    private fun initViews() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == android.R.id.home) {
            showAlertDialogLogout()
            true
        } else super.onOptionsItemSelected(item)
    }

    private fun showAlertDialogLogout() {
        AlertDialog.Builder(this).apply {
            setTitle(getString(R.string.attention))
            setMessage(getString(R.string.logout_alert))
            setPositiveButton(android.R.string.yes) { _, _ ->
                onBackPressed()
            }
            setNegativeButton(android.R.string.no, null)
            create().show()
        }
    }
}
