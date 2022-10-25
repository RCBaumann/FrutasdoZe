package com.graxa.frutasdoz.fragments.add

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.graxa.frutasdoz.R
import com.graxa.frutasdoz.model.Produtos
import com.graxa.frutasdoz.viewmodel.ProdutosViewModel
import kotlinx.android.synthetic.main.fragment_adicionar.*
import kotlinx.android.synthetic.main.fragment_adicionar.view.*
import java.text.SimpleDateFormat
import java.util.*

class AdicionarFragment : Fragment() {

    private lateinit var mProdutosViewModel: ProdutosViewModel

    var btnData: Button? = null
    var txViewData: TextView? = null
    var cal: Calendar = Calendar.getInstance()

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

//        // get the references from layout file
//        this.txtViewData.also { txViewData = it }
//        this.btnData.also { btnData = it }
//
//
//        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
//            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
//                                   dayOfMonth: Int) {
//                cal.set(Calendar.YEAR, year)
//                cal.set(Calendar.MONTH, monthOfYear)
//                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
//                updateDateInView()
//            }
//        }
//
//        // when you click on the button, show DatePickerDialog that is set with OnDateSetListener
//        btnData!!.setOnClickListener {
//            DatePickerDialog(
//                requireContext(),
//                dateSetListener,
//                // set DatePickerDialog to point to today's date when it loads up
//                cal.get(Calendar.YEAR),
//                cal.get(Calendar.MONTH),
//                cal.get(Calendar.DAY_OF_MONTH)
//            ).show()
//        }

        return view
    }


//    private fun updateDateInView() {
//        val myFormat = "MM/dd/yyyy" // mention the format you need
//        val sdf = SimpleDateFormat(myFormat, Locale.US)
//        txViewData!!.text = sdf.format(cal.getTime())
//    }


    private fun inserirDados() {
        val nome = et_nome.text.toString()
        val tipoProduto = et_tipo.text.toString()
        val dataValidade = txtViewData.text.toString()
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