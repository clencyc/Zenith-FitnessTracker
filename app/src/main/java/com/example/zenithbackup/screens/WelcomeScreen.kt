package com.example.zenithbackup.screens

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.zenithbackup.Authentication.LoginActivity
import com.example.zenithbackup.Authentication.RegisterActivity
import com.example.zenithbackup.R

class WelcomeScreen : AppCompatActivity() {

    lateinit var BTN_Getstarted: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome_screen)

        BTN_Getstarted = findViewById(R.id.button)
        BTN_Getstarted.setOnClickListener {
            val i = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(i)
        }

    }

}