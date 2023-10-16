package br.com.masters3.beans;

public class Hospedagem {
    private String nome;
    private String local;
    private String tipo;
    private String descricao;
    private double preco;

    public Hospedagem() {
    }

    public Hospedagem(String nome, String local, String tipo, String descricao, double preco) {
        this.nome = nome;
        this.local = local;
        this.tipo = tipo;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
