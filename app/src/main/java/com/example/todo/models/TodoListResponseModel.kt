package com.example.todo.models

data class TodoListResponseModel(
    val todos:Array<TodoModel>,
    val total:Int,
    val skip:Int,
    val limit:Int,
)
