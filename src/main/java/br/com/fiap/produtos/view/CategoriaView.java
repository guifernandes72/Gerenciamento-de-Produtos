package br.com.fiap.produtos.view;

import br.com.fiap.produtos.model.Categoria;
import br.com.fiap.produtos.repository.CategoriaCollectionRepository;

import javax.swing.*;

public class CategoriaView {

    static CategoriaCollectionRepository repository;

    //SELETOR DE CATEGORIA

    public static Categoria select(Categoria categoria){

        Categoria ret = (Categoria) JOptionPane.showInputDialog(
                null, //Ele pede um componente pai, que nao tem, passa o null
                "Selecione uma opcção",
                "Menu", //No titulo
                JOptionPane.QUESTION_MESSAGE,
                null, //nao tem o icone
                repository.findAll().toArray(), //Número de opcao
                categoria == null ? 1 : categoria); //Se a categoria for == a null o primeiro item ira ser selecionado, se nao a propria categoria

                return ret; //Retornando a categoria
    }

    public void sucesso(){
        JOptionPane.showMessageDialog(null, "A Categoria foi salva com sucesso!"); //Primeiro ele pede o componente pai, ja que nao tem, retorna o null
    }

    public void sucesso(Categoria categoria){
        JOptionPane.showMessageDialog(null, "A Categoria " + categoria.getNome() +" foi salva com sucesso!"); //Primeiro ele pede o componente pai, ja que nao tem, retorna o null
    }

    public static Categoria form(Categoria categoria){
        String nome = JOptionPane.showInputDialog(null, "Informe o nome da Categoria", categoria != null ? categoria.getNome() : "");
        return new Categoria(nome);
    }

}
