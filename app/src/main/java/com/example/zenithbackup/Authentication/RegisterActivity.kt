package com.example.zenithbackup.Authentication

import android.content.ContentValues.TAG
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
import com.google.firebase.auth.FirebaseUser

class RegisterActivity : AppCompatActivity() {
    private lateinit var fullname_edt: EditText
    private lateinit var emailAddress: EditText
    private lateinit var passCode: EditText
    private lateinit var create_Account: Button

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

//        auth = Firebase.auth
        auth = FirebaseAuth.getInstance()

        fullname_edt = findViewById(R.id.editTextText2)
        emailAddress = findViewById(R.id.editTextText3)
        passCode = findViewById(R.id.editTextTextPassword2)
        create_Account = findViewById(R.id.button3)

        create_Account.setOnClickListener {
            val name = fullname_edt.text.toString()
            val email = emailAddress.text.toString()
            val pass = passCode.text.toString()

            if (validateInputs(name, email, pass)) {
                registerUser(email, pass)
            } else {
                Toast.makeText(
                    baseContext,
                    "Please fill in all fields correctly.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

        // ... (your existing onStart() method)

        private fun updateUI(user: FirebaseUser?) {
            if (user != null) {
                // User is registered, navigate to the next screen (e.g., MainActivity)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // Registration failed, show an error message or clear input fields
            }
        }

    private fun validateInputs(name: String, email: String, pass: String): Boolean {
        return name.isNotEmpty() && email.isNotEmpty() && pass.isNotEmpty()
    }

    private fun registerUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Registration success
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    updateUI(user) // Update UI or navigate to the next screen
                } else {
                    // Registration failed
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext,
                        "Registration failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    updateUI(null)
                }
            }
    }
}