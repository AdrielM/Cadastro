package com.example.adriel.cadastro.Repositories.Impl;

import android.content.Context;

import com.example.adriel.cadastro.DAO.ProdutoDatabase;
import com.example.adriel.cadastro.Model.Produto;

import java.util.List;

/**
 * Created by adriel on 05/01/16.
 */
public interface ProdutoDAO {
    boolean salvar(Produto produto, ProdutoDatabase produtoDatabase);

    List<Produto> find(Context context, ProdutoDatabase produtoDatabase, String query);

    boolean remover(Long id, Context context, ProdutoDatabase produtoDatabase);

}
