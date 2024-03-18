package com.example.kotlinapps.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapps.R

class ToDoActivity : AppCompatActivity() {
    private lateinit var rvCategories: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do)
        initComponents()
        initUI()
    }

    private fun initComponents(){
        rvCategories= findViewById(R.id.rvCategories)

    }
    private fun initUI(){

    }
}