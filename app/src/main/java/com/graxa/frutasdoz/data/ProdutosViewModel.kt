package com.graxa.frutasdoz.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProdutosViewModel(application: Application): AndroidViewModel(application) {

    private val readAllData: LiveData<List<Produtos>>
    private val repository: ProdutosRepository

    init {
        val produtosDao = ProdutosDatabase.getDatabase(application).produtosDao()
        repository = ProdutosRepository(produtosDao)
        readAllData = repository.readAllData
    }

    fun addProdutos (produtos: Produtos) {
        viewModelScope.launch {Dispatchers.IO}

    }
}