package com.example.kotlinapps.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinapps.R
import com.example.kotlinapps.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    private lateinit var  binding:ActivitySettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}