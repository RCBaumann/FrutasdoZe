package com.graxa.frutasdoz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.graxa.frutasdoz.R
import com.graxa.frutasdoz.adapter.ListaAdapter.*
import com.graxa.frutasdoz.model.Produtos
import kotlinx.android.synthetic.main.lista_produtos.view.*

class ListaAdapter: RecyclerView.Adapter<ListaViewHolder>() {

    private var produtosList = emptyList<Produtos>()

    class ListaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaViewHolder {
        return ListaViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.lista_produtos,parent,false))
    }

    override fun onBindViewHolder(holder: ListaViewHolder, position: Int) {
        val itemLista = produtosList[position]
        holder.itemView.idLista.text = itemLista.id.toString()
        holder.itemView.nomeLista.text = itemLista.name
        holder.itemView.tipoLista.text = itemLista.tipoProduto
        holder.itemView.dataLista.text = itemLista.dataValidade.toString()
    }

    override fun getItemCount(): Int {
        return produtosList.size
    }

    fun setData(produtos: List<Produtos>){
        this.produtosList = produtos
        notifyDataSetChanged()
    }

}

