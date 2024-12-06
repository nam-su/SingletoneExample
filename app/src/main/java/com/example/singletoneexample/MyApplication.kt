package com.example.singletoneexample

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class MyApplication: Application() {
    companion object {
        lateinit var sharedPreferences: SharedPreferences
    }

    override fun onCreate() {
        super.onCreate()
        sharedPreferences = applicationContext.getSharedPreferences("data", Context.MODE_PRIVATE)
    }
}