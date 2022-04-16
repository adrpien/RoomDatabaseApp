package com.adrpien.roomdatabaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adrpien.roomdatabaseapp.databinding.ActivityMainBinding

/*
Aplikacja:
1. Dodać depencies w build.gradle
2.
 */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}