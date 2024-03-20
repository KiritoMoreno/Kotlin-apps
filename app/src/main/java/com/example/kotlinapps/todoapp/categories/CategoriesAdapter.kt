package com.example.kotlinapps.todoapp.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapps.R
import com.example.kotlinapps.todoapp.TaskCategory

class CategoriesAdapter(private var categories: List <TaskCategory>, private val onItemSelected:(Int)):RecyclerView.Adapter<CategoriesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_task_category, parent, false)
        return CategoriesViewHolder(view)
    }
    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.render(categories[position], onItemSelected)
    }
    override fun getItemCount(): Int = categories.size




}