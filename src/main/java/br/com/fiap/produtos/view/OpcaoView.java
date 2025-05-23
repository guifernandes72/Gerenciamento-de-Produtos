package br.com.fiap.produtos.view;

import javax.swing.*;

public class OpcaoView {

    public static Opcao select(){

        Opcao ret = (Opcao) JOptionPane.showInputDialog(
                null, // Componente pai, ja que nao tem painel
                "Selecione uma opcção", //Texto pro usuario
                "Menu", //No titulo
                JOptionPane.QUESTION_MESSAGE, //Uma pergunta pro usuario
                null, //O metodo pede um icione, ja que nao tem, passa como null
                Opcao.values(), //Este parametro pega a lista de opcoes, o numero da opcap
                Opcao.CADASTRAR_PRODUTO); //Qual a opcao que estaria por padrao

            return ret != null ? ret : Opcao.ENCERRAR_SISTEMA; //Se esta difertente de null, ele retorna a opcao, se nao, ele fecha a caixa

    }

}
