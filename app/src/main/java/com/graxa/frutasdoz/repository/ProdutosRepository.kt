package com.graxa.frutasdoz.repository

import androidx.lifecycle.LiveData
import com.graxa.frutasdoz.model.Produtos
import com.graxa.frutasdoz.data.ProdutosDao

class ProdutosRepository(private val produtosDao: ProdutosDao) {

    val readAllData: LiveData<List<Produtos>> = produtosDao.readAllData()

    suspend fun addProdutos(produtos: Produtos) {
        produtosDao.addProdutos(produtos)
    }

    suspend fun updateProdutos(produtos: Produtos){
        produtosDao.updateProdutos(produtos)
    }

    suspend fun deleteProdutos(produtos: Produtos){
        produtosDao.deleteProdutos(produtos)
    }

    suspend fun deleteAllProdutos(){
        produtosDao.deleteAllProdutos()
    }

}