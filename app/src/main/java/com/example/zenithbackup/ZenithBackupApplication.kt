package com.example.zenithbackup

import android.app.Application
import com.google.firebase.FirebaseApp

class ZenithBackupApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // this is the launcher activity
        FirebaseApp.initializeApp(this)
    }

}