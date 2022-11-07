package com.graxa.frutasdoz

import android.os.Bundle
import android.view.Menu
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.graxa.frutasdoz.databinding.ActivityMainBinding
import com.graxa.frutasdoz.model.Produtos
import com.graxa.frutasdoz.viewmodel.ProdutosViewModel

class MainActivity : AppCompatActivity(),SearchView.OnQueryTextListener {

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel: ProdutosViewModel by viewModels()
    private val mAdapter: ListAdapter by lazy { mAdapter }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)

        val btnBuscar = menu?.findItem(R.id.app_bar_search)
        val searchView = btnBuscar?.actionView as SearchView
        searchView.isSubmitButtonEnabled = true
        searchView.setOnQueryTextListener(this)

        binding.btnBuscar.setOnClickListener(){
            Toast.makeText(this,"Logo logo você vai poder pesquisar",Toast.LENGTH_LONG).show()
        }

        return true
    }


    override fun onQueryTextSubmit(query: String?): Boolean {
        if(query != null){
            selectProdutos(query)
        }
        return true
    }

    override fun onQueryTextChange(query: String?): Boolean {
        if(query != null){
            selectProdutos(query)
        }
        return true
    }

    private fun selectProdutos(query: String?){
        val searchQuery = "%$query%"

//        mainViewModel.selectProdutos(searchQuery).observe(this) { list ->
//            list.let {
//                mAdapter.setData(it)
//            }
//        }

    }


}