package br.com.fiap.produtos.model;

import java.util.Objects;

public class Categoria {

    //Atributos

    private Long id;

    private String nome;

    //Construtores


    public Categoria() {
    }

    //Com ID
    public Categoria(Long id, String nome) {
        this.setId(id);
        this.setNome(nome);
    }

    //Sem o ID, pois quando ira cadastrar o produto, nao tera o id
    public Categoria(String nome) {
        this.setNome(nome);
    }


    //Getter and Setter sendo builder, que significa toda vez que ele setar um valor de uma propiedade ele vai devolver o objeto
    public Long getId() {
        return id;
    }

    public Categoria setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Categoria setNome(String nome) {
        this.nome = nome;
        return this;
    }


    //equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(nome, categoria.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }

    //toString
    @Override
    public String toString() {
        return nome.toUpperCase();
    }
}
