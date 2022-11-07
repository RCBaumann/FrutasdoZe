package com.graxa.frutasdoz.repository

import androidx.lifecycle.LiveData
import androidx.room.Query
import com.graxa.frutasdoz.model.Produtos
import com.graxa.frutasdoz.data.ProdutosDao
import java.util.concurrent.Flow
import javax.inject.Inject

class ProdutosRepository @Inject constructor(
    private val produtosDao: ProdutosDao) {

    val readAllData: LiveData<List<Produtos>> = produtosDao.readAllData()

    fun addProdutos(produtos: Produtos) {
        produtosDao.addProdutos(produtos)
    }

    fun updateProdutos(produtos: Produtos){
        produtosDao.updateProdutos(produtos)
    }

    suspend fun deleteProdutos(produtos: Produtos){
        produtosDao.deleteProdutos(produtos)
    }

    suspend fun deleteAllProdutos(){
        produtosDao.deleteAllProdutos()
    }

    fun selectProdutos(searchQuery: String): LiveData<List<Produtos>> {
        return produtosDao.selectProdutos(searchQuery)
    }

}

/*
*
* criar função para consulta por filtro
*
*
 */