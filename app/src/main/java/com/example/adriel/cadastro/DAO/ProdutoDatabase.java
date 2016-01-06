package com.example.adriel.cadastro.DAO;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by adriel on 05/01/16.
 */
public class ProdutoDatabase {

    private ProdutoDatabaseHelper databaseManager;
    private SQLiteDatabase sqld;
    public static final String DATABASE_NAME = "CadastroProduto.db";
    public static final int DATABASE_VERSION = 1;

    public ProdutoDatabase(ProdutoDatabaseHelper databaseManager) {
        this.databaseManager = databaseManager;
    }

    public void open() {
        sqld = databaseManager.getWritableDatabase();
    }

    public SQLiteDatabase get() {
        if (sqld != null && sqld.isOpen()) {
            return sqld;
        }
        return null;
    }

    public void close() {
        databaseManager.close();
    }

}
