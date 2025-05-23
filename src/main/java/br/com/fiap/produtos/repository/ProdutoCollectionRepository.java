package br.com.fiap.produtos.repository;

import br.com.fiap.produtos.model.Categoria;
import br.com.fiap.produtos.model.Produto;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Vector;

public class ProdutoCollectionRepository {

    private static List<Produto> produtos; //Uma lista de produtos com o nome de produtos

    static{
        produtos = new Vector<>(); //A instancia do produto

        Produto celular = new Produto();

        celular.setNome("Iphone 14") //Stando o nome
                .setDescricao("Aparelho celular da Aplle")
                .setCategoria(CategoriaCollectionRepository.findById(2l))
                .setDataDeCadastro(LocalDateTime.now())
                .setPreco(BigDecimal.valueOf(12000));

        //Metodo de salvar
        save(celular);

    }

    public static List<Produto> findAll(){
        return produtos;
    }

    public static Produto save(Produto produto) {  // Metodo publico e estático que retorna um objeto do tipo Produto, chamado save,
         if(!produtos.contains(produto)){       // e recebe como parâmetro um objeto Produto chamado produto.
            produto.setId((long)produtos.size() + 1); //Definindo o Id do produto
            produtos.add(produto);

            return produto;
     }else{
             JOptionPane.showMessageDialog(null, "Já existe este produto cadastrado com esse nome");
             return null;
         }

    }


    //So um id por produto
    public static Produto findById(Long id){

        return produtos.stream()
                .filter(p -> p.getId(). equals(id))
                .findFirst()
                .orElse(null);
    }

    public static List<Produto> findByCategoria(Categoria categoria) {

        return produtos.stream().filter(p->p.getCategoria().equals(categoria)).toList(); //Uma colecao e caso nao existir, ira retornar uma lista vazia

    }
}
