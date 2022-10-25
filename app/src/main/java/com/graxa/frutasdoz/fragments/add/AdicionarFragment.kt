package com.graxa.frutasdoz.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.graxa.frutasdoz.R
import com.graxa.frutasdoz.model.Produtos
import com.graxa.frutasdoz.viewmodel.ProdutosViewModel
import kotlinx.android.synthetic.main.fragment_adicionar.*
import kotlinx.android.synthetic.main.fragment_adicionar.view.*

class AdicionarFragment : Fragment() {

    private lateinit var mProdutosViewModel: ProdutosViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_adicionar, container,false)

        mProdutosViewModel = ViewModelProvider(this)[ProdutosViewModel::class.java]


        view.btnSalvar.setOnClickListener(){
            inserirDados()
        }

        return view
    }

    private fun inserirDados() {
        val nome = et_nome.text.toString()
        val tipoProduto = et_tipo.text.toString()
        val dataValidade = et_data.text.toString()
        val quantidade = et_quantidade.text.toString()
        val peso = et_peso.text.toString()
        val valor = et_valor.text.toString()

        if(verificarDados(nome,tipoProduto,dataValidade,quantidade,peso,valor)) {
            //Create Produtos Object
            val produtos = Produtos(0, nome,tipoProduto,dataValidade,quantidade, peso, valor)
            //Add dados no BD
            mProdutosViewModel.addProdutos(produtos)
            Toast.makeText(requireContext(),"Produto adicionado com sucesso",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_adicionarFragment_to_listaFragment)
        }else{
            Toast.makeText(requireContext(),"Verifique as informações",Toast.LENGTH_LONG).show()
        }

    }

    private fun verificarDados (
        nome: String, tipoProduto: String, dataValidade: String,quantdidade:String,peso:String,valor:String): Boolean {
        return !(TextUtils.isEmpty(nome) && TextUtils.isEmpty(tipoProduto) && TextUtils.isEmpty(dataValidade) && TextUtils.isEmpty(quantdidade) && TextUtils.isEmpty(peso) && valor.isEmpty())
    }


}