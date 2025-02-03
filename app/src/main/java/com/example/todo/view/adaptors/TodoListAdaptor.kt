package com.example.todo.view.adaptors

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.R
import com.example.todo.models.TodoModel

class TodoListAdaptor(private val todoList: Array<TodoModel>) :
    RecyclerView.Adapter<TodoListAdaptor.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val description: TextView = itemView.findViewById(R.id.textView)
        val date: TextView = itemView.findViewById(R.id.date)
        val tick: ImageView = itemView.findViewById(R.id.tick)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.recycle_todo, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = todoList[position]
        holder.description.text = currentItem.todo
        holder.date.text = "24-Nov 2023"
        holder.tick.visibility = View.GONE

    }
}