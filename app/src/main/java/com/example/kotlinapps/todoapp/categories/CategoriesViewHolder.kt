package com.example.kotlinapps.todoapp.categories

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapps.R
import com.example.kotlinapps.todoapp.TaskCategory

class CategoriesViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    private val divider: View= view.findViewById(R.id.divider)
    fun render(taskCategory: TaskCategory, onItemSelected:(Int) -> Unit){

        itemView.setOnClickListener{onItemSelected(layoutPosition)}

        when(taskCategory){
            TaskCategory.Business -> {
                tvCategoryName.text="Negocios"
                divider.setBackgroundColor(ContextCompat.getColor(divider.context,R.color.todo_business_category))
            }
            TaskCategory.Other -> {
                tvCategoryName.text="Otros"
                divider.setBackgroundColor(ContextCompat.getColor(divider.context,R.color.todo_other_category))
            }
            TaskCategory.Personal -> {
                tvCategoryName.text="Personal"
                divider.setBackgroundColor(ContextCompat.getColor(divider.context,R.color.todo_personal_category))
            }
        }
    }

    private fun onItemSelected(layoutPosition: Int): View.OnClickListener? {

        

    }

}