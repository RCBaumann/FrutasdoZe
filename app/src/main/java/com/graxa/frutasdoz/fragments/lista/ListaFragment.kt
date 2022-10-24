package com.graxa.frutasdoz.fragments.lista

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.graxa.frutasdoz.R
import com.graxa.frutasdoz.adapter.ListaAdapter
import com.graxa.frutasdoz.viewmodel.ProdutosViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_adicionar.view.*
import kotlinx.android.synthetic.main.fragment_lista.view.*

class ListaFragment : Fragment() {

    private lateinit var mUserProdutosViewModel: ProdutosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_lista,container,false)

        //recyclerview
        val adapter = ListaAdapter()
        val listaFrutas = view.listaFrutas
        listaFrutas.adapter = adapter
        listaFrutas.layoutManager = LinearLayoutManager(requireContext())


        //ProdutosViewModel
        mUserProdutosViewModel = ViewModelProvider(this).get(ProdutosViewModel::class.java)
        mUserProdutosViewModel.readAllData.observe(viewLifecycleOwner, Observer { produtos ->
            adapter.setData(produtos)

        })

        view.btnAdd.setOnClickListener(){
            findNavController().navigate(R.id.action_listaFragment_to_adicionarFragment)
        }

        //add menu
        setHasOptionsMenu(true)


        return view
    }


}