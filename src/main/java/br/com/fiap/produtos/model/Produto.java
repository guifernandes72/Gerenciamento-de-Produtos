package br.com.fiap.produtos.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Produto {

    //Atributos

    private Long id;

    private String nome;

    private String descricao;

    private BigDecimal preco;

    private LocalDateTime dataDeCadastro;

    private Categoria categoria;

    //Construtores

    public Produto(){
    }

    public Produto(Long id, Categoria categoria, LocalDateTime dataDeCadastro, BigDecimal preco, String descricao, String nome) {
        this.setId(id); //Esse id (a primeira variavel) vai receber essa variavel por parametro
        this.setCategoria(categoria);
        this.setDataDeCadastro(dataDeCadastro);
        this.setPreco(preco);
        this.setDescricao(descricao);
        this.setNome(nome);
    }

    //Construtor sem ID
    public Produto(String nome, String descricao, BigDecimal preco, LocalDateTime dataDeCadastro, Categoria categoria) {
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setPreco(preco);
        this.setDataDeCadastro(dataDeCadastro);
        this.setCategoria(categoria);
    }


    //Metodos Acessores


//Geter and Setter usando Builder
    public Long getId() {
        return id;
    }

    public Produto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Produto setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Produto setPreco(BigDecimal preco) {
        this.preco = preco;
        return this;
    }

    public LocalDateTime getDataDeCadastro() {
        return dataDeCadastro;
    }

    public Produto setDataDeCadastro(LocalDateTime dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
        return this;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Produto setCategoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }

    //Equals and HashCode


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }

    //toString
    @Override
    public String toString() {

        return nome.toUpperCase(); //Retornando o nome em maiusculo

    }
}
