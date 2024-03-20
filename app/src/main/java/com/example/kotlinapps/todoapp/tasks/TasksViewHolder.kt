package com.example.kotlinapps.todoapp.tasks

import android.graphics.Paint
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
        if (task.isSelected){
            tvTask.paintFlags = tvTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }else{
            tvTask.paintFlags = tvTask.paintFlags and  Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
        cbTask.isChecked = task.isSelected
        
        tvTask.text=task.name
    }

}