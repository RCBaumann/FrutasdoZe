package com.graxa.frutasdoz.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "proutos_table")
data class Produtos(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val tipoProduto: String,
    val dataValidade: Int
    //todo colocar campos restantes
)
