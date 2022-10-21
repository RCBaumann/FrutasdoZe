package com.graxa.frutasdoz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.graxa.frutasdoz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar!!.hide();
        setContentView(binding.root)

        binding.btnAddProduto.setOnClickListener() {
            val intent = Intent(this,CadastroActivity::class.java)
            startActivity(intent)
        }


    }


}