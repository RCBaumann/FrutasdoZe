package com.graxa.frutasdoz

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.graxa.frutasdoz.data.Produtos
import com.graxa.frutasdoz.data.ProdutosViewModel
import com.graxa.frutasdoz.databinding.ActivityCadastroBinding
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding
    private lateinit var mUserProdutosViewModel: ProdutosViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide();

        mUserProdutosViewModel = ViewModelProvider(this).get(ProdutosViewModel::class.java)

        binding.btnVoltar.setOnClickListener() {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        binding.btnAdd.setOnClickListener {
            insertDataToDatabase()
        }
        return

    }

    private fun insertDataToDatabase() {
        val nome = et_nome.text.toString()
        val tipoProduto = et_tipo.text.toString()
        val dataValidade = et_data.text
        val quantidade = et_quantidade.text
        val peso = et_peso.text
        val valor = et_valor.text

        if(inputCheck(nome,tipoProduto,dataValidade,quantidade,peso,valor)) {
            //Create Produtos Object
            val produtos = Produtos(0, nome,tipoProduto,Integer.parseInt(dataValidade.toString()),Integer.parseInt(quantidade.toString()),Integer.parseInt(peso.toString(),Integer.parseInt(valor.toString())))
           //Add data to Database
            mUserProdutosViewModel.addProdutos(produtos)
            Toast.makeText(this,"Adicionado com sucesso",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this,"Confira as informações", Toast.LENGTH_LONG).show()
        }

    }

    private fun inputCheck (
        nome: String, tipoProduto: String,
        dataValidade: Editable, quantidade: Editable,
        peso: Editable, valor: Editable
    ): Boolean {
        return  !(TextUtils.isEmpty(nome) && TextUtils.isEmpty(tipoProduto) && TextUtils.isEmpty(dataValidade.toString())
                && TextUtils.isEmpty(quantidade.toString()) && TextUtils.isEmpty(peso.toString()) && TextUtils.isEmpty(valor.toString()))
    }

}