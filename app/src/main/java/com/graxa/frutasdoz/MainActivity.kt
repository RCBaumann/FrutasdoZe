package com.graxa.frutasdoz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.MobileAds
import com.graxa.frutasdoz.adapter.TaskListAdapter
import com.graxa.frutasdoz.database.DataBaseHelper
import com.graxa.frutasdoz.model.TaskListModel

class MainActivity : AppCompatActivity() {

    lateinit var lista_frutas : RecyclerView
    lateinit var  btn_add : Button
    var taskListAdapter : TaskListAdapter ?= null
    var dbHandler : DataBaseHelper ?= null
    var taskList : List<TaskListModel> = ArrayList<TaskListModel>()
    private var linearLayoutMananger : LinearLayoutManager ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MobileAds.initialize(this) {}
        supportActionBar!!.hide();

        lista_frutas = findViewById(R.id.lista_frutas)
        btn_add = findViewById(R.id.btn_add)

        dbHandler = DataBaseHelper(this)
        fetchList()

        btn_add.setOnClickListener{
            val i = Intent(applicationContext,CadastroActivity :: class.java)
            startActivity(i)
        }

    }

    private fun fetchList (){
        taskList = dbHandler !!.getAllTasks()
        taskListAdapter = TaskListAdapter(taskList,applicationContext)
        linearLayoutMananger = LinearLayoutManager(applicationContext)
        lista_frutas.layoutManager = linearLayoutMananger
        lista_frutas.adapter = taskListAdapter
        taskListAdapter?.notifyDataSetChanged()
    }
}