package com.graxa.frutasdoz.fragments.att

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.graxa.frutasdoz.R
import com.graxa.frutasdoz.adapter.ListaAdapter

class AtualizaDadosFragment : Fragment() {

    private lateinit var listaAdapter: ListaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_atualizar, container, false)

    }

}