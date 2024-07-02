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

class RegisterActivity : AppCompatActivity() {
    private lateinit var fullname_edt: EditText
    private lateinit var emailAddress: EditText
    private lateinit var passCode: EditText
    private lateinit var create_Account: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        fullname_edt = findViewById(R.id.editTextText2)
        emailAddress = findViewById(R.id.editTextText3)
        passCode = findViewById(R.id.editTextTextPassword2)
        create_Account = findViewById(R.id.button3)

        create_Account.setOnClickListener {
            val name = fullname_edt.text.toString()
            val email = emailAddress.text.toString()
            val pass = passCode.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && pass.isNotEmpty()) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                fullname_edt.error = "Please enter your name"
                emailAddress.error = "Please enter your email"
                passCode.error = "Please enter your password"
            }
        }
    }
}