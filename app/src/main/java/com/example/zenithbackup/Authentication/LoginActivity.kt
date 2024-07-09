package com.example.zenithbackup.Authentication

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.zenithbackup.R
import com.example.zenithbackup.screens.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var enterEmail: EditText
    private lateinit var enterPass: EditText
    private lateinit var loginBtn: Button
    private lateinit var auth: FirebaseAuth
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        // Initialize Firebase Auth
        // auth = Firebase.auth

        enterEmail = findViewById(R.id.editTextText)
        enterPass = findViewById(R.id.editTextTextPassword)
        loginBtn = findViewById(R.id.button2)
        progressDialog = ProgressDialog(this)

        loginBtn.setOnClickListener {
            val email = enterEmail.text.toString().trim()

            val pass = enterPass.text.toString().trim()

            if (email.isNotEmpty() && pass.isNotEmpty()) {
                // Sign in with Firebase
                signInWithEmailAndPassword(email, pass)
            } else {
                if (email.isEmpty()) {
                    enterEmail.error = "Please enter email"
                }
                if (pass.isEmpty()) {
                    enterPass.error = "Please enter password"
                }
            }
        }
    }

    private fun signInWithEmailAndPassword(email: String, pass: String) {
        progressDialog.setTitle("Logging In")
        progressDialog.setMessage("Please wait...")
        progressDialog.show()

        auth.signInWithEmailAndPassword(email, pass)
            .addOnCompleteListener(this) { task ->
                progressDialog.dismiss()
                if (task.isSuccessful) {
                    Log.d("LoginActivity", "signInWithEmail:success")
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Log.w("LoginActivity", "signInWithEmail:failure", task.exception)
                    val errorMessage = when (task.exception) {
                        is FirebaseAuthInvalidUserException -> "Account not found. Please register."
                        is FirebaseAuthInvalidCredentialsException -> "Invalid email or password."
                        else -> "Authentication failed. Please try again."
                    }
                    Toast.makeText(baseContext, errorMessage, Toast.LENGTH_SHORT).show()
                }
            }
    }

}