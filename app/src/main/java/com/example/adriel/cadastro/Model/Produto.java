package com.example.adriel.cadastro.Model;

/**
 * Created by adriel on 05/01/16.
 */
public class Produto {
    private Long _id;
    private int quantidade;
    private String nome;
    private double preco;

    public Produto(){}

    public Produto(Long Id, String Nome, double Preco){
        this._id = Id;
        this.nome = Nome;
        this.preco = Preco;
    }

    public Long get_id() {
        return _id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
