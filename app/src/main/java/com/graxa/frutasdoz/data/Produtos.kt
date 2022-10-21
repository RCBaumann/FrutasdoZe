package com.graxa.frutasdoz.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "proutos_table")
data class Produtos (
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val name : String,
    val tipoProduto : Int,
    val dataValidade : Long,
    val quantidade : Int,
    val peso : Double,
    val valor : Double
    )
