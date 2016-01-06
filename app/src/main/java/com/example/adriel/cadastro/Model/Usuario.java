package com.example.adriel.cadastro.Model;

/**
 * Created by adriel on 05/01/16.
 */
public class Usuario {
    private Integer _id;
    private String nome;
    private String login;
    private String senha;

    public Usuario(){}

    public Usuario(Integer id, String Nome, String Login, String Senha){
        this._id = id;
        this.nome = Nome;
        this.login = Login;
        this.senha = Senha;

    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
