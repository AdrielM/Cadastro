package com.example.adriel.cadastro.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by adriel on 05/01/16.
 */
public class ProdutoDatabaseHelper extends SQLiteOpenHelper {
    public static final String NOME_TABELA = "produto";
    public static final String COLUMN_ID = "_id";
    public final static String COLUMN_NOME = "nome";
    public static final String COLUMN_VALOR = "valor";
    public static final String COLUMN_QUANTIDADE = "quantidade";

    public static final String CREATE_TABLE = "create table produto"
            + "("
            + "_id" + " integer primary key autoincrement, "
            + "nome" + " text not null, "
            + "valor" + " real not null, "
            + "quantidade" + " integer not null, "
            + ");";


    public ProdutoDatabaseHelper(Context context) {
        super(context, ProdutoDatabase.DATABASE_NAME, null, ProdutoDatabase.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*String sql = " drop table produto";
        db.execSQL(sql);

        onCreate(db);*/
    }


}
