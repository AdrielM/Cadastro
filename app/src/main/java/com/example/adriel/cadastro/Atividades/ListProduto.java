package com.example.adriel.cadastro.Atividades;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.adriel.cadastro.Adapter.ProdutoAdapter;
import com.example.adriel.cadastro.DAO.ProdutoDatabase;
import com.example.adriel.cadastro.DAO.ProdutoDatabaseHelper;
import com.example.adriel.cadastro.Model.Produto;
import com.example.adriel.cadastro.R;
import com.example.adriel.cadastro.Repositories.Impl.ProdutoDAO;
import com.example.adriel.cadastro.Repositories.ProdutoDAOimpl;

import java.util.List;

public class ListProduto extends AppCompatActivity implements View.OnClickListener {

    private ListView lista;
    private ProdutoAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_produto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListProduto.this, AdicionarProduto.class));
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    protected void onResume(){
        super.onResume();
        this.inicializarElementos();
    }


    private void inicializarElementos(){
        lista = (ListView) findViewById(R.id.lista);

        adapter = new ProdutoAdapter(getLista(), this);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(ListProduto.this, AdicionarProduto.class);
                Produto produto = (Produto) adapter.getItem(position);

                intent.putExtra("_id", produto.get_id());
                intent.putExtra("nome", produto.getNome());
                intent.putExtra("valor", produto.getPreco());
                intent.putExtra("quantidade", produto.getQuantidade());


                startActivity(intent);

            }
        });


    }

    public List<Produto> getLista() {
        ProdutoDatabase produtoDatabase = new ProdutoDatabase(new ProdutoDatabaseHelper(this));
        ProdutoDAO dao = new ProdutoDAOimpl();

        return dao.find(this, produtoDatabase, "select * from " + ProdutoDatabaseHelper.NOME_TABELA + " order by " + ProdutoDatabaseHelper.COLUMN_NOME);

    }


    @Override
    public void onClick(View v) {
        /*switch (v.getId()) {
            case R.id.add:
                startActivity(new Intent(this, AddProduto.class));
                break;
        }*/
    }

}
