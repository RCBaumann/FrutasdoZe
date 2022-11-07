package com.graxa.frutasdoz.viewmodel

import android.app.Application
import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.graxa.frutasdoz.data.ProdutosDatabase
import com.graxa.frutasdoz.model.Produtos
import com.graxa.frutasdoz.repository.ProdutosRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.Flow

class ProdutosViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Produtos>>
    private val repository: ProdutosRepository

    init {
        val produtosDao = ProdutosDatabase.getDatabase(application).produtosDao()
        repository = ProdutosRepository(produtosDao)
        readAllData = repository.readAllData
    }

    fun addProdutos (produtos: Produtos) {
        viewModelScope.launch (Dispatchers.IO) {
            repository.addProdutos(produtos)
        }
    }

    fun updateProdutos (produtos: Produtos){
        viewModelScope.launch (Dispatchers.IO) {
            repository.updateProdutos(produtos)
        }
    }

    fun deleteProdutos(produtos: Produtos){
        viewModelScope.launch (Dispatchers.IO) {
            repository.deleteProdutos(produtos)
        }
    }

    fun deleteAllProdutos(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllProdutos()
        }
    }

    fun selectProdutos(searchQuery: String): LiveData<List<Produtos>> {
        return repository.selectProdutos(searchQuery)
    }

}