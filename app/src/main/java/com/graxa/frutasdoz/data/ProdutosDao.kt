package com.graxa.frutasdoz.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProdutosDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addProdutos(produtos: Produtos)

    @Query("SELECT * FROM proutos_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Produtos>>

}