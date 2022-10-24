package com.graxa.frutasdoz.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.graxa.frutasdoz.model.Produtos

@Dao
interface ProdutosDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addProdutos(produtos: Produtos)

    @Update
    fun updateProdutos (produtos: Produtos)

    @Delete
    suspend fun deleteProdutos (produtos: Produtos)

    @Query("DELETE FROM  produtos_table")
    suspend fun deleteAllProdutos()

    @Query("SELECT * FROM produtos_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Produtos>>

}