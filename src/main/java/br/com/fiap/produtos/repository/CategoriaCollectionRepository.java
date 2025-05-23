package br.com.fiap.produtos.repository;

import br.com.fiap.produtos.model.Categoria;
import br.com.fiap.produtos.model.Produto;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

public class CategoriaCollectionRepository {

    private static List<Categoria> categorias; //Lista

    static {

        categorias = new Vector<>();

        //Criando a categoria
        Categoria eletronicos = new Categoria(1l, "Eletrônicos"); //Os parametros das categorias
        Categoria celulares = new Categoria(2l,"Celulares");
        Categoria livros = new Categoria(3l,"Livros");


        //Adcionando na lista
        categorias.add(eletronicos);
        categorias.add(celulares);
        categorias.add(livros);

    }

    //Metodos

    //Consultar as categorias
    public static List<Categoria> findAll() {
        return categorias;
    }

    //Esse metodo espera um Long do Id
    public static Categoria findById(Long id) {
        return categorias.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null); //O retorno dele é a lista de categorias, transforma em string e tem um filtro, cujo nesse filtro ele recebe o c e ele compara o c e tem que ser o id que recebeu nesse parametro
    }

    public static List<Categoria> findByNome(String nome) { //Ele espera um nome nessa lista

        return categorias.stream()
                .filter(c -> c.getNome().equalsIgnoreCase(nome))
                .toList(); //O filtro (seguindo a msm logica que no id)

    }

    //Metodos para salvar a categoria
    public static Categoria save (Categoria categoria){ //Um metodo publico, que é estatico, vai retornar uma categoria e o metodo se chama save. Ele espera uma categoria que é chamada de categoria

        if(!categorias.contains(categoria)){ //se conter categorias em categoria nao vai salvar
            categoria.setId((long)categorias.size() + 1); //Cria o id da categoria, ele vai ver o tamanho de categorias vai colocar mais um e transforma em long
            categorias.add(categoria); //Adiciona a categoria nova
            return categoria; //retorna a categoria
        }else{
            JOptionPane.showMessageDialog(null, "Já existe uma categoria com o nome informado");
            return null; //Pois a categoria nao foi salva
        }


    }


}


