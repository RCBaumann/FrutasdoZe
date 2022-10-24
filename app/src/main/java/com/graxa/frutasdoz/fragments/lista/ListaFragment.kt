package com.graxa.frutasdoz.fragments.lista

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.graxa.frutasdoz.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_adicionar.view.*
import kotlinx.android.synthetic.main.fragment_lista.view.*

class ListaFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_lista,container,false)

        view.btnAdd.setOnClickListener(){
            findNavController().navigate(R.id.action_listaFragment_to_adicionarFragment)
        }


        return view
    }


}