package com.example.zenithbackup.screens

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.zenithbackup.R
import com.example.zenithbackup.ToWebActivity


class HomeActivity : AppCompatActivity() {

    private lateinit var ButtonToWebView: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize FirebaseApp

        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        ButtonToWebView = findViewById(R.id.towebbtn)
        ButtonToWebView.setOnClickListener {
            val i = Intent(applicationContext, ToWebActivity::class.java)
            startActivity(i)
        }
    }
}