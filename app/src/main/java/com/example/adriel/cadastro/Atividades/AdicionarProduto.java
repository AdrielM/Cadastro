package com.example.adriel.cadastro.Atividades;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.adriel.cadastro.DAO.ProdutoDatabase;
import com.example.adriel.cadastro.DAO.ProdutoDatabaseHelper;
import com.example.adriel.cadastro.R;
import com.example.adriel.cadastro.Repositories.Impl.ProdutoDAO;
import com.example.adriel.cadastro.Repositories.ProdutoDAOimpl;

public class AdicionarProduto extends AppCompatActivity implements View.OnClickListener {

   private Button salvar;
    private EditText nome, valor, quantidade;
    private Bundle extras;
    private Long _id;
    private ProdutoDatabase produtoDatabase;
    private ProdutoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_produto);

        this.inicializarElementos();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.btn_deletar:

                produtoDatabase = new ProdutoDatabase(new ProdutoDatabaseHelper(this));
                dao = new ProdutoDAOimpl();

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Confirmação")
                        .setMessage("Deseja mesmo remover o registro?")
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                //salvando no banco
                                if(dao.remover(AdicionarProduto.this._id, AdicionarProduto.this, produtoDatabase)){
                                    Toast.makeText(AdicionarProduto.this, "Removido com sucesso.", Toast.LENGTH_SHORT).show();

                                    startActivity(new Intent(AdicionarProduto.this, ListProduto.class));
                                    finish();
                                }else{
                                    Toast.makeText(AdicionarProduto.this, "Ocorreu um problema ao remover! Tente novamente.",
                                            Toast.LENGTH_SHORT).show();
                                }

                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();

                break;
            default:
                startActivity(new Intent(this, ListProduto.class));
                finish();
                break;
        }

        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        if(this._id != 0l) {

            // Inflate the menu; this adds items to the action bar if it is present.
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_produto, menu);

        }

        return true;
    }


    private void inicializarElementos() {
        this._id = 0l;

        salvar = (Button) findViewById(R.id.salvar);
        salvar.setOnClickListener(this);

        nome = (EditText) findViewById(R.id.nome);
        valor = (EditText) findViewById(R.id.valor);
        quantidade = (EditText) findViewById(R.id.quantidade);

        extras = getIntent().getExtras();

        if (extras != null) {
            inicializarElementosExtras();
        }
    }

        private void inicializarElementosExtras(){

            _id = extras.getLong("_id");
            nome.setText(extras.getString("nome"));
            valor.setText(String.valueOf(extras.getDouble("valor")));
            quantidade.setText(String.valueOf(extras.getInt("quantidade")));

        }


    @Override
    public void onClick(View v) {

    }
}


