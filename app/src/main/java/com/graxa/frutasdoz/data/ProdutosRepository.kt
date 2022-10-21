package com.graxa.frutasdoz.data

import androidx.lifecycle.LiveData

class ProdutosRepository(private val produtosDao: ProdutosDao) {

    val readAllData: LiveData<List<Produtos>> = produtosDao.readAllData()

    suspend fun addProdutos(produtos: Produtos) {
        produtosDao.addProdutos(produtos)
    }
}