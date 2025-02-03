package com.example.todo.models

data class TodoModel(
    val id: Int,
    val todo: String,
    val completed: Boolean,
    val userId: Int
)
