package com.graxa.frutasdoz.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.graxa.frutasdoz.CadastroActivity
import com.graxa.frutasdoz.MainActivity
import com.graxa.frutasdoz.R
import com.graxa.frutasdoz.model.TaskListModel

class TaskListAdapter (taskList: List<TaskListModel>, internal var context: Context)
    : RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>()
{
    internal  var taskList : List<TaskListModel> = ArrayList()
    init {
        this.taskList = taskList
    }

    inner class TaskViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        var name : TextView = view.findViewById(R.id.nome_fruta)
        var details : TextView = view.findViewById(R.id.tipo_fruta)
        var btn_editar : Button = view.findViewById(R.id.btn_edit)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_main,parent,false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val tasks = taskList [position]
        holder.name.text = tasks.name
        holder.details.text = tasks.details

        holder.btn_editar.setOnClickListener{
            val i = Intent(context,CadastroActivity ::class.java)
            i.putExtra("Mode","E")
            i.putExtra("id",tasks.id)
            context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return taskList.size
    }
}

