package com.example.adriel.cadastro.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.adriel.cadastro.Model.Produto;
import com.example.adriel.cadastro.R;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by adriel on 05/01/16.
 */
public class ProdutoAdapter extends BaseAdapter {

        private List<Produto> list;
        private LayoutInflater mLayout;

    public ProdutoAdapter(List<Produto> lista, Context context){
        list = lista;
        mLayout = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 1l;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mLayout.inflate(R.layout.item_list_produto, parent, false);

        TextView nome = (TextView) convertView.findViewById(R.id.nome);
        TextView valor = (TextView) convertView.findViewById(R.id.valor);

        Produto produto = list.get(position);

        DecimalFormat precoFormatado;
        String preco;

        nome.setText(produto.getNome());

        precoFormatado = new DecimalFormat("'R$ '0.00");
        preco = precoFormatado.format(produto.getPreco());

        valor.setText(preco);

        return convertView;
    }
}
