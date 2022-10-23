package com.graxa.frutasdoz

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.graxa.frutasdoz.model.Produtos
import com.graxa.frutasdoz.viewmodel.ProdutosViewModel
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

        mUserProdutosViewModel = ViewModelProvider(this)[ProdutosViewModel::class.java]

        binding.btnVoltar.setOnClickListener() {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        binding.btnAdd.setOnClickListener {
            inserirDados()
        }
        return

    }

    private fun inserirDados() {
        val nome = et_nome.text.toString()
        val tipoProduto = et_tipo.text.toString()
        val dataValidade = et_data.text

        //todo colocar os outros campos
//        val quantidade = et_quantidade.text
//        val peso = et_peso.text
//        val valor = et_valor.text

        if(verificarDados(nome,tipoProduto,dataValidade.toString())) {
            //Create Produtos Object
            val produtos = Produtos(0, nome,tipoProduto,Integer.parseInt(dataValidade.toString()))
           //Add dados no BD
            mUserProdutosViewModel.addProdutos(produtos)
            Toast.makeText(this,"Adicionado com sucesso",Toast.LENGTH_LONG).show()
            finish()
        }else{
            Toast.makeText(this,"Confira as informações", Toast.LENGTH_LONG).show()
        }

    }

    private fun verificarDados (
        nome: String, tipoProduto: String,
        dataValidade: String
    ): Boolean {
        return  !(TextUtils.isEmpty(nome) && TextUtils.isEmpty(tipoProduto) && TextUtils.isEmpty(dataValidade.toString()))
    }

}