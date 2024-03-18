package com.example.kotlinapps.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinapps.R

class ToDoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do)
    }
}