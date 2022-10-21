package com.graxa.frutasdoz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.graxa.frutasdoz.database.DataBaseHelper
import com.graxa.frutasdoz.model.TaskListModel

class CadastroActivity : AppCompatActivity () {

    lateinit var btn_add : Button
    lateinit var btn_remove : Button
    lateinit var  et_nome : EditText
    lateinit var  et_tipo : EditText
    var dbHandler : DataBaseHelper ?= null
    var isEditMode : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        supportActionBar!!.hide()

        btn_add = findViewById(R.id.btn_add_cadastro)
        btn_remove = findViewById(R.id.btn_remove_cadastro)
        et_nome = findViewById(R.id.nome_fruta_cadastro)
        et_tipo = findViewById(R.id.tipo_fruta_cadastro)

        dbHandler = DataBaseHelper(this)

        if (intent != null && intent.getStringExtra("Mode") == "E"){
            //update data
            isEditMode = true
            btn_add.text = "Update Data"
            btn_remove.visibility = View.VISIBLE
            val tasks : TaskListModel = dbHandler!!.getTask((intent.getIntExtra("id",0)))
            et_nome.setText(tasks.name)
            et_tipo.setText(tasks.details)

        } else {
            //insert new data
            isEditMode = false
            btn_add.text = "Sava data"
            btn_remove.visibility = View.GONE

        }

        btn_add.setOnClickListener {
            var success : Boolean = false
            val tasks : TaskListModel = TaskListModel()
            if (isEditMode) {
                //update
                tasks.id = intent.getIntExtra("id", 0)
                tasks.name =  et_nome.text.toString()
                tasks.details = et_tipo.toString()

                success = dbHandler?.updateTask(tasks) as Boolean

            } else {
                //insert
                tasks.name = et_nome.text.toString()
                tasks.details = et_tipo.toString()

                success = dbHandler?.addTasks(tasks) as Boolean

            }
            if (success) {
                val i = Intent(applicationContext,MainActivity :: class.java)
                startActivity(i)
                finish()
            } else {
                Toast.makeText(applicationContext, "Alguma Coisa Deu errado =[",Toast.LENGTH_LONG).show()
            }
        }

        btn_remove.setOnClickListener {
            val dialog = AlertDialog.Builder(this).setTitle("Info").setMessage("Aperte SIM para deletar")
                .setPositiveButton("SIM") { dialog, i ->
                    val success = dbHandler?.deleteTask(intent.getIntExtra("id", 0)) as Boolean
                    if (success)
                        finish()
                    dialog.dismiss()
                }
                .setNegativeButton("NÃO") { dialog, i ->
                    dialog.dismiss()
                }
            dialog.show()
        }

    }

}

