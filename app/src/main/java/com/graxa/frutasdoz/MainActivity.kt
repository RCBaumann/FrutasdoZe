package com.graxa.frutasdoz

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.graxa.frutasdoz.databinding.ActivityMainBinding
import com.graxa.frutasdoz.viewmodel.ProdutosViewModel

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

//        //RecyclerView correto
//        listaFrutas = findViewById(R.id.listaFrutas)
//        listaFrutas.setHasFixedSize(true)
//
//        val adapter = ListaAdapter()
//        listaFrutas.adapter = adapter
//        listaFrutas.layoutManager = LinearLayoutManager(this)
//
//        //ProdutosViewModel
//        mProdutosViewModel = ViewModelProvider(this).get(ProdutosViewModel::class.java)
//        mProdutosViewModel.readAllData.observe(this, Observer { produtos ->
//            adapter.setData(produtos)
//
//        })

    }


}