package com.example.zenithbackup.screens

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import com.example.zenithbackup.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> intent = Intent(this, HomeActivity::class.java)

                R.id.profile -> intent = Intent(this, ProfileActivity::class.java)
                R.id.progress -> intent = Intent(this, ProgressActivity::class.java)
            }
            if (intent != null) {
                startActivity(intent)
            }
            true
        }


    }
}
