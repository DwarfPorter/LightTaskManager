package com.niww.lighttaskmanager.ui.fragments.adapters

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.niww.lighttaskmanager.R
import com.niww.lighttaskmanager.model.data.Task

class TaskListPagingAdapter: PagedListAdapter<Task, TaskListPagingAdapter.MyViewHolder>(DiffUtilCallback()){


    class MyViewHolder(val view: View): RecyclerView.ViewHolder(view){

        val id=view.findViewById<TextView>(R.id.task_id)
        val name = view.findViewById<TextView>(R.id.task_name)
        val implementer = view.findViewById<TextView>(R.id.task_implementer)
        val dueDate = view.findViewById<TextView>(R.id.task_dueDate)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.task_list_recyclerview_item, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val task=getItem(position)

        println("binded position = "+position + " ; id =   " + task!!.id)

        holder.id.text=task!!.id.toString()
        holder.name.text = task!!.name
        holder.implementer.text = task!!.implementer.name
        holder.dueDate.text = task!!.dueDate.toString()

    }


    class DiffUtilCallback: DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem.id == newItem.id;
        }

        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem != newItem;
        }

    }


}