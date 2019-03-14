package com.example.loginandregistration.adapter

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.loginandregistration.R
import db.entities.ToDoItem
import kotlinx.android.synthetic.main.layout_item_todo.view.*

class ActionAdapter(private val activities: List<ToDoItem>)
    : RecyclerView.Adapter<ActionAdapter.ActionViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ActionViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item_todo, parent, false))

    override fun onBindViewHolder(holder: ActionViewHolder, position: Int) {
        holder.bindStudent(activities[position])
    }

    override fun getItemCount() = activities.size

    inner class ActionViewHolder(view: View): RecyclerView.ViewHolder(view) {

        fun bindStudent(activity: ToDoItem) {

            var priority = activity.priority.toString()

            itemView.title.text = activity.title.toString()
            itemView.content.text = activity.content.toString()
            itemView.priority.text = priority

            if(priority == itemView.context.getString(R.string.high)){
               itemView.setBackgroundColor(Color.RED)
            } else if(priority == itemView.context.getString(R.string.low)){
                itemView.setBackgroundColor(Color.WHITE)
            } else if(priority == itemView.context.getString(R.string.medium)){
                itemView.setBackgroundColor(Color.YELLOW)
            }


        }
    }
}