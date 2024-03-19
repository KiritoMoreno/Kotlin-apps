package com.example.kotlinapps.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapps.R
import com.example.kotlinapps.todoapp.TaskCategory.*
import com.example.kotlinapps.todoapp.categories.CategoriesAdapter
import com.example.kotlinapps.todoapp.tasks.TasksAdapter

class ToDoActivity : AppCompatActivity() {
    private val categories = listOf(
        Business,
        Personal,
        Other
    )
    private val tasks = mutableListOf(
        Task("PruebaBusiness", Business),
        Task("PruebaOther", Other),
        Task("PruebaPersonal", Personal)
    )
    private lateinit var rvCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var rvTasks: RecyclerView
    private lateinit var tasksAdapter: TasksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do)
        initComponents()
        initUI()
    }

    private fun initComponents(){
        rvCategories= findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)

    }
    private fun initUI(){
        categoriesAdapter = CategoriesAdapter(categories)
        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rvCategories.adapter = categoriesAdapter

        tasksAdapter = TasksAdapter(tasks)
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = tasksAdapter

    }
}