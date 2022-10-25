package com.graxa.frutasdoz.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "produtos_table")
data class Produtos(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nome: String,
    val tipoProduto: String,
    val dataValidade: String,
    val quantidade: String,
    val peso: String,
    val valor: String
    //todo alterar tipos
): Parcelable
