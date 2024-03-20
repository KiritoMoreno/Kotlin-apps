package com.example.kotlinapps.todoapp

sealed class TaskCategory (var isSelected:Boolean = false){
    object Personal : TaskCategory()
    object Business: TaskCategory()
    object Other: TaskCategory()

}