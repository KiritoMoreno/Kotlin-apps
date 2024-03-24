package com.example.kotlinapps.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinapps.R
import com.example.kotlinapps.databinding.ActivitySuperHeroListBinding

class SuperHeroListActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySuperHeroListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}