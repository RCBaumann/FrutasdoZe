package com.graxa.frutasdoz.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.graxa.frutasdoz.model.TaskListModel

class DataBaseHelper (context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object{
        private val DB_NAME = "db"
        private val DB_VERSION = 1
        private val TABLE_NAME = "registro_produtos"
        private val ID = "id"
        private val TASK_NAME = "taskname"
        private val TASK_DETAILS = "taskdetails"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val CREATE_TABLE = "CREATE TABLE $TABLE_NAME ($ID INTEGER PRIMARY KEY, $TASK_NAME TEXT, $TASK_DETAILS TEXT);"
        p0?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
        p0?.execSQL(DROP_TABLE)
        onCreate(p0)
    }

    fun getAllTasks(): List<TaskListModel>{
        val taskList = ArrayList<TaskListModel>()
        val db : SQLiteDatabase = writableDatabase
        val selectQuery = "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(selectQuery,null)
        if (cursor != null){
            if (cursor.moveToFirst())
                do {
                    val tasks = TaskListModel()
                    tasks.id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID)))
                    tasks.name = cursor.getString(cursor.getColumnIndex(TABLE_NAME))
                    tasks.details = cursor.getString(cursor.getColumnIndex(TASK_DETAILS))
                    taskList.add(tasks)
                }while (cursor.moveToNext())
        }
        cursor.close()
        return taskList
    }

    //insert
    fun addTasks (tasks : TaskListModel): Boolean {
        val db : SQLiteDatabase = this.writableDatabase
        val values = ContentValues()
        values.put(TABLE_NAME,tasks.name)
        values.put(TASK_DETAILS,tasks.details)
        val _success : Long = db.insert(TABLE_NAME,null,values)
        db.close()
        return (Integer.parseInt("$_success") != -1)
    }

    //select the data of particular id
    fun getTask(_id : Int) : TaskListModel {
        val tasks = TaskListModel()
        val db : SQLiteDatabase = writableDatabase
        val selectQuery = "SELECT * FROM $TABLE_NAME WHERE $ID = $_id"
        val cursor : Cursor = db.rawQuery(selectQuery,null)

        cursor?.moveToFirst()
        tasks.id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID)))
        tasks.name = cursor.getString(cursor.getColumnIndex(TASK_NAME))
        tasks.details = cursor.getString(cursor.getColumnIndex(TASK_DETAILS))
        cursor.close()
        return tasks
    }

    //delete
    fun deleteTask (_id: Int): Boolean {
        val db : SQLiteDatabase = this.writableDatabase
        val _success : Long = db.delete(TABLE_NAME, ID + "-?", arrayOf(_id.toString())).toLong()
        db.close()
        return Integer.parseInt("$_success") != -1
    }

    //update
    fun updateTask (tasks: TaskListModel) : Boolean {
        val db : SQLiteDatabase = this.writableDatabase
        val values = ContentValues()
        values.put(TASK_NAME,tasks.name)
        values.put(TASK_DETAILS,tasks.details)
        val _succes : Long = db.update(TABLE_NAME,values, ID + "=?", arrayOf(tasks.id.toString())).toLong()
        db.close()
        return Integer.parseInt("$_succes") != -1

    }

}