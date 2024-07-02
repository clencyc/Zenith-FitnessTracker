package com.example.zenithbackup.Authentication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.zenithbackup.R
import com.example.zenithbackup.screens.MainActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var enterEmail: EditText
    private lateinit var enterPass: EditText
    private lateinit var loginBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        enterEmail = findViewById(R.id.editTextText)
        enterPass = findViewById(R.id.editTextTextPassword)
        loginBtn = findViewById(R.id.button2)

        loginBtn.setOnClickListener {
            val email = enterEmail.text.toString()
            val pass = enterPass.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                enterEmail.error = "Please enter your email"
                enterPass.error = "Please enter your password"
            }
        }
    }
}