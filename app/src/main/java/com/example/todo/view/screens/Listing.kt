package com.example.todo.view.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.R
import com.example.todo.models.TodoModel
import com.example.todo.view.adaptors.TodoListAdaptor
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class Listing : AppCompatActivity() {

    private var listing: Array<TodoModel> = Array(100) { index: Int ->
        TodoModel(index, "Random Text", true, 23)
    }

    private lateinit var recyclerList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listing)

        recyclerList = findViewById<RecyclerView>(R.id.listing)
        recyclerList.layoutManager = LinearLayoutManager(this)
        recyclerList.setHasFixedSize(true)
        recyclerList.adapter = TodoListAdaptor(listing)


    }

}