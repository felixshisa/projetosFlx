package com.example.mercado;

import java.util.ArrayList;

public class Main {

    private ArrayList<Fornecedor> fornecedores = new ArrayList<>();
//   Atributos Fornecedor:

//    private Integer ID;
//    private String nomeFornecedor;
//    private String descricaoFornecedor;
//    private String enderecoFornecedor;

//   Atributos Produto

//    private String nomeProduto;
//    private String descricao;
//    private double preco;
//    private Integer quantidadeEmEstoque;


    public static void main(String[] args) {
        Fornecedor rogerCalcados = new Fornecedor(1,"Roger Calçados", "Dono do Boi Nobre"
                , " Rua Pacheco");

        Produto leite = new Produto(" Leite ", " De soja, muito gostoso ", 3.14,2);

        Produto oleo = new Produto(" Oleo ", " De soja, muito gostoso ", 3.14,2);


        rogerCalcados.addProduto(leite);
        System.out.println(leite);
        rogerCalcados.addProduto(oleo);
        rogerCalcados.removeProduto(leite);
        System.out.println("leite é removido");
        rogerCalcados.listaProdutos();
    }
}
