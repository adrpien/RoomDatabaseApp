package com.adrpien.roomdatabaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adrpien.roomdatabaseapp.databinding.ActivityListBinding
import com.adrpien.roomdatabaseapp.databinding.ActivityMainBinding

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}