package com.graxa.frutasdoz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.graxa.frutasdoz.data.ProdutosViewModel
import com.graxa.frutasdoz.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var listaFrutas : RecyclerView

    private lateinit var mProdutosViewModel : ProdutosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide();
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddProduto.setOnClickListener() {
            val intent = Intent(this,CadastroActivity::class.java)
            startActivity(intent)
        }

        binding.btnEditarProduto.setOnClickListener() {
            Toast.makeText(this, "Ainda não está pronto", Toast.LENGTH_LONG).show()
        }

        binding.btnBuscar.setOnClickListener(){
            Toast.makeText(this,"Logo logo você vai poder pesquisar",Toast.LENGTH_LONG).show()
        }

        //RecyclerView correto
        listaFrutas = findViewById(R.id.listaFrutas)
        listaFrutas.setHasFixedSize(true)

        val adapter = ListaAdapter()
        listaFrutas.adapter = adapter
        listaFrutas.layoutManager = LinearLayoutManager(this)

        //ProdutosViewModel
        mProdutosViewModel = ViewModelProvider(this).get(ProdutosViewModel::class.java)
        mProdutosViewModel.readAllData.observe(this, Observer { produtos ->
            adapter.setData(produtos)

        })

    }


}