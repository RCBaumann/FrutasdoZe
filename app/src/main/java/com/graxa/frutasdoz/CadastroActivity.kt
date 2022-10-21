package com.graxa.frutasdoz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.graxa.frutasdoz.databinding.ActivityCadastroBinding

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide();

        binding.btnReturn.setOnClickListener() {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


    }

}