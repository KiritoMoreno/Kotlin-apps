package com.example.kotlinapps.todoapp.tasks

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapps.R
import com.example.kotlinapps.todoapp.Task

class TasksViewHolder (view: View):RecyclerView.ViewHolder(view){
    private val tvTask:TextView = view.findViewById(R.id.tvTask)
    private val cbTask:CheckBox = view.findViewById(R.id.cbTask)
    fun render(task:Task){
        tvTask.text=task.name
    }

}