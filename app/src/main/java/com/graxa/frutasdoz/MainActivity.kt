package com.graxa.frutasdoz

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.graxa.frutasdoz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide();
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnBuscar.setOnClickListener(){
            Toast.makeText(this,"Logo logo você vai poder pesquisar",Toast.LENGTH_LONG).show()
        }

        binding.pesquisarFruta.setOnClickListener(){
            Toast.makeText(this,"Logo logo você vai poder pesquisar",Toast.LENGTH_LONG).show()
        }

    }


}