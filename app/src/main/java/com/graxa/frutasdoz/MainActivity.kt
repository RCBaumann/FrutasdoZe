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
    private lateinit var mProdutosViewModel : ProdutosViewModel
    private lateinit var listaFrutas : RecyclerView
//    private lateinit var listaAdapter: ListaAdapter

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

        listaFrutas = findViewById(R.id.listaFrutas)
        listaFrutas.setHasFixedSize(true)

        val adapter = ListaAdapter()
        listaFrutas.adapter = adapter
        listaFrutas.layoutManager = LinearLayoutManager(this)

        //Recyclerview
//        val adapter = ListaAdapter()
//        val listaView = listaFrutas
//        listaView.adapter = adapter
//        listaView.layoutManager = LinearLayoutManager(requireContext())

        //ProdutosViewModel
        mProdutosViewModel = ViewModelProvider(this).get(ProdutosViewModel::class.java)
        mProdutosViewModel.readAllData.observe(this, Observer { produtos ->
            adapter.setData(produtos)

        })

    }


}