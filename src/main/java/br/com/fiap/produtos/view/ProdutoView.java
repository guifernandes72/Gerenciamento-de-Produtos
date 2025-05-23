package br.com.fiap.produtos.view;

import br.com.fiap.produtos.model.Categoria;
import br.com.fiap.produtos.model.Produto;
import br.com.fiap.produtos.repository.ProdutoCollectionRepository;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProdutoView {


    public static Produto form(Produto produto) {


        Categoria categoria = null;

        do{
            categoria = CategoriaView.select(produto.getCategoria());
        }while(categoria == null);



        String nome = "";
        do {
            nome = JOptionPane.showInputDialog(null, "Informe o nome do produto", produto.getNome());
        }while(nome.equals(""));



        String descricao = "";
        do {
            descricao = JOptionPane.showInputDialog(null, "Informe a descrição do produto", produto.getDescricao());
        }while(descricao.equals(""));



        double preco = 0;

        do {
            try{
                preco = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o preço do produto", produto.getPreco()));

            }catch (Exception e){

            }
        }while(preco <= 0);

        Produto ret = produto;

        ret.setCategoria(categoria)
                .setNome(nome)
                .setDescricao(descricao)
                .setDataDeCadastro(LocalDateTime.now())
                .setPreco(BigDecimal.valueOf(preco));

        return ret;

    }

    public void sucesso(){
        JOptionPane.showMessageDialog(null, "O Produto foi salvo com sucesso!"); //Primeiro ele pede o componente pai, ja que nao tem, retorna o null
    }

    public static void sucesso(Produto produto){
        JOptionPane.showMessageDialog(null, "O Produto " + produto.getNome() +" foi salva com sucesso!"); //Primeiro ele pede o componente pai, ja que nao tem, retorna o null
    }


    public static Produto select(Produto produto){

        Produto ret = (Produto) JOptionPane.showInputDialog(
                null, //Ele pede um componente pai, que nao tem, passa o null
                "Selecione um produto",
                "Menu", //No titulo
                JOptionPane.QUESTION_MESSAGE,
                null, //nao tem o icone
                ProdutoCollectionRepository.findAll().toArray(), //Número de opcao
                produto == null ? 1 : produto); //Se a categoria for == a null o primeiro item ira ser selecionado, se nao a propria categoria

        return ret; //Retornando a categoria
    }


    public static void update(Produto produto){
        form(produto);
        sucesso(produto);
        show(produto);
    }

    public static void show(Produto p) {

        System.out.println(p);

        String textoFormatado = String.format("Produto: " + p.getNome() + System.lineSeparator() + "Descrição: " + p.getDescricao() + System.lineSeparator() + "Preço: %,.2f" , p.getPreco());

        JOptionPane.showMessageDialog(null, textoFormatado);

    }

}
