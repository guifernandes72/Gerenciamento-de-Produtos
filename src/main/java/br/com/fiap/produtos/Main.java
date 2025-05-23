package br.com.fiap.produtos;

import br.com.fiap.produtos.model.Categoria;
import br.com.fiap.produtos.model.Produto;
import br.com.fiap.produtos.repository.CategoriaCollectionRepository;
import br.com.fiap.produtos.repository.ProdutoCollectionRepository;
import br.com.fiap.produtos.view.CategoriaView;
import br.com.fiap.produtos.view.Opcao;
import br.com.fiap.produtos.view.OpcaoView;
import br.com.fiap.produtos.view.ProdutoView;

import javax.swing.*;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Opcao opcao = null;

        do{

            opcao = OpcaoView.select();

            switch (opcao){
                case CADASTRAR_CATEGORIA -> cadastrarCategoria(); //Se a opcao for CADASTRAR_CATEGORIA, ele vai chamar (->) o metodo cadastrarCategoria
                case CADASTRAR_PRODUTO -> cadastrarProduto();
                case ALTERAR_PRODUTO -> alterarProduto();
                case CONSULTAR_PRODUTO_POR_ID -> consultarProdutoPorId();
                case CONSULTAR_PRODUTO_POR_CATEGORIA -> consultarProdutoPorCategoria();
                case ENCERRAR_SISTEMA -> encerrarOSistema();
            }

        } while (opcao != Opcao.ENCERRAR_SISTEMA);

    }

    private static void  alterarProduto() {

        Produto produto = ProdutoView.select(null);
        ProdutoView.update(produto);
    }


    private static void encerrarOSistema() {
        System.exit(0); //Metodo de encerrar
    }

    private static void consultarProdutoPorCategoria() {

        Categoria categoria = CategoriaView.select(null); //Abre uma caixa de selecao de categoria

        List<Produto> produtos = ProdutoCollectionRepository.findByCategoria(categoria);//metodo q tras todos os produtos da categoria q o user selecionou

        if(produtos.isEmpty()){
            JOptionPane.showMessageDialog(null, "Não encontramos produtos com a categoria: " + categoria.getNome());
        }else{
            produtos.forEach(ProdutoView::show);
            produtos.forEach(System.out::println);
        }

    }

    private static void consultarProdutoPorId() {

        Long id = 0l;

        do{
            try{
                id = Long.parseLong(JOptionPane.showInputDialog("Informe o id do produto"));
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "ID inválido");
            }
    }while ( id <=0);

        Produto p = ProdutoCollectionRepository.findById(id);
        if(p != null){
            ProdutoView.show(p);
        }else{
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
        }
    }

    private static void cadastrarProduto() {

        Produto produto = ProdutoView.form(new Produto());
        ProdutoCollectionRepository.save(produto);
        ProdutoView.sucesso(produto);

    }

    private static void cadastrarCategoria() {

        CategoriaView view = new CategoriaView();  //Criando uma categoriaView e dando o nome de view
        Categoria categoria = view.form(new Categoria()); //declarando a var categoria e chamando o form para o cadastramento da categoria
        CategoriaCollectionRepository.save(categoria); //Chama o repositorio e pede pra salvar a categoria
        view.sucesso(categoria); //mensagem de sucesso

    }
}