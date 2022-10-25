package com.graxa.frutasdoz.fragments.att

import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.graxa.frutasdoz.R
import com.graxa.frutasdoz.model.Produtos
import com.graxa.frutasdoz.viewmodel.ProdutosViewModel
import kotlinx.android.synthetic.main.fragment_adicionar.view.*
import kotlinx.android.synthetic.main.fragment_atualiza.*
import kotlinx.android.synthetic.main.fragment_atualiza.view.*

class AtualizaFragment : Fragment() {

    private val args by navArgs<AtualizaFragmentArgs>()
    private lateinit var mProdutosViewModel: ProdutosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_atualiza, container, false)

        mProdutosViewModel = ViewModelProvider(this)[ProdutosViewModel::class.java]

        view.etAttNome.setText(args.produtosAtual.nome)
        view.etAttTipo.setText(args.produtosAtual.tipoProduto)
        view.etAttData.setText(args.produtosAtual.dataValidade)
        view.etAttQuantidade.setText(args.produtosAtual.quantidade)
        view.etAttPeso.setText(args.produtosAtual.peso)
        view.etAttValor.setText(args.produtosAtual.valor)
        //todo adicionar outros campos

        view.btnAtt.setOnClickListener(){
            atualizaDados()
        }

        setHasOptionsMenu(true)

        return view
    }

    private fun atualizaDados() {
        val nome = etAttNome.text.toString()
        val tipoProduto = etAttTipo.text.toString()
        val dataValidade = etAttData.text.toString()
        val quantdidade = etAttQuantidade.text.toString()
        val peso = etAttPeso.text.toString()
        val valor = etAttValor.text.toString()

        if((verificarDados(nome,tipoProduto,dataValidade,quantdidade,peso,valor))) {
            val atualizaDados = Produtos(args.produtosAtual.id, nome, tipoProduto, dataValidade,quantdidade,peso,valor)
            mProdutosViewModel.updateProdutos(atualizaDados)
            Toast.makeText(requireContext(),"Produto Atualizado!",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_atualizaFragment_to_listaFragment2)
        }else{
            Toast.makeText(requireContext(),"Verifique as informações",Toast.LENGTH_LONG).show()
        }

    }

    private fun verificarDados (
        nome: String, tipoProduto: String, dataValidade: String,quantdidade:String,peso:String,valor:String): Boolean {
        return !(TextUtils.isEmpty(nome) && TextUtils.isEmpty(tipoProduto) && TextUtils.isEmpty(dataValidade) && TextUtils.isEmpty(quantdidade) && TextUtils.isEmpty(peso) && valor.isEmpty())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_delete){
            deleteProduto()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteProduto(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Sim") {_,_ ->
            mProdutosViewModel.deleteProdutos(args.produtosAtual)
            Toast.makeText(requireContext(),"Apagado Com sucesso: ${args.produtosAtual.nome}",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_atualizaFragment_to_listaFragment2)
        }
        builder.setNegativeButton("Não") {_,_ -> }
        builder.setTitle("Deletar ${args.produtosAtual.nome}?")
        builder.setMessage("Tem certeza que quer apagar este produto: ${args.produtosAtual.nome}")
        builder.create().show()

    }


}