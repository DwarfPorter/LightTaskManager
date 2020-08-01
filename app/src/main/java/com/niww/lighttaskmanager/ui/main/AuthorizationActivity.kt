package com.niww.lighttaskmanager.ui.main

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.firebase.ui.auth.AuthUI
import com.niww.lighttaskmanager.R

class AuthorizationActivity : AppCompatActivity() {

    companion object {
        private const val MAIL_SIGN_IN_REQUEST_CODE = 1
    }

    private lateinit var btnSignIn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)
        init()
    }

    private fun init() {
        btnSignIn = findViewById(R.id.btn_sign_in)
        btnSignIn.setOnClickListener { authorization() }
    }

    private fun authorization() {
        startActivityForResult(
            AuthUI.getInstance().createSignInIntentBuilder().build(),
            MAIL_SIGN_IN_REQUEST_CODE
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == MAIL_SIGN_IN_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val mainActivityIntent = Intent(this, MainActivity::class.java)
            startActivity(mainActivityIntent)
            finish()
        }
    }

}