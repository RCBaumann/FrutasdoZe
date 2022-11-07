package com.graxa.frutasdoz.fragments.add

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.graxa.frutasdoz.R
import com.graxa.frutasdoz.model.Produtos
import com.graxa.frutasdoz.viewmodel.ProdutosViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_adicionar.*
import kotlinx.android.synthetic.main.fragment_adicionar.view.*
import java.util.*

class AdicionarFragment : Fragment() {

    private lateinit var mProdutosViewModel: ProdutosViewModel

    //todo txtsize (depois)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //datepicker calendario
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c. get(Calendar.DAY_OF_MONTH)

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_adicionar, container,false)
        mProdutosViewModel = ViewModelProvider(this)[ProdutosViewModel::class.java]
        view.btnSalvar.setOnClickListener {
            inserirDados()
        }

        //btnData
        view.btnDataAdd.setOnClickListener{
            val dpd = DatePickerDialog(requireContext(), { view, mYear, mMonth, mDay ->
                campoDataAdd.text = "$mDay/${mMonth+1}/$mYear"
            }, year,month,day)
            //showDialog
            dpd.show()
        }

        return view
    }


    private fun inserirDados() {
        val nome = et_nome.text.toString()
        val tipoProduto = et_tipo.text.toString()
        val dataValidade = campoDataAdd.text.toString()
        val quantidade = et_quantidade.text.toString()
        val peso =  et_peso.text.toString()
        val valor =et_valor.text.toString()


        val produtos = Produtos(0, nome,tipoProduto,dataValidade,quantidade, peso, valor)
        if(nome.isNotEmpty() && tipoProduto.isNotEmpty() && dataValidade.isNotEmpty() && quantidade.isNotEmpty() && peso.isNotEmpty() && valor.isNotEmpty()){
            mProdutosViewModel.addProdutos(produtos)
            Toast.makeText(requireContext(),"Produto adicionado com sucesso",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_adicionarFragment_to_listaFragment)
        }else{
            Toast.makeText(requireContext(),"Verifique as informações no cadastro",Toast.LENGTH_SHORT).show()
        }

    }

}