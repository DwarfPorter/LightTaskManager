package com.niww.lighttaskmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
/**
 * SplashActivity
 * **/
class SplashActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
        checkAuth()
    }

    private fun checkAuth() {
        if (auth.currentUser == null) {
            val authorizationIntent = Intent(this, AuthorizationActivity::class.java)
            startActivity(authorizationIntent)
            finish()
        } else {
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
            finish()
        }
    }
}