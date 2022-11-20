package com.example.mercado;

import java.util.ArrayList;
import java.util.Locale;

public class Fornecedor {

    private Integer ID;
    private ArrayList<Produto> produtos = new ArrayList<>();
    private String nomeFornecedor;
    private String descricaoFornecedor;
    private String enderecoFornecedor;


    public Fornecedor(Integer ID, String nomeFornecedor, String descricaoFornecedor, String enderecoFornecedor) {
        this.ID = ID;
        this.nomeFornecedor = nomeFornecedor;
        this.descricaoFornecedor = descricaoFornecedor;
        this.enderecoFornecedor = enderecoFornecedor;
    }

//    public void teste(Produto produto) {
//        int indice = produtos.indexOf(produto);
//        produto.setIdProduto(indice);
//    }

    public boolean addProduto(Produto produto) {
        if (!produtos.contains(produto)) {
            produtos.add(produto);
            produto.setIdProduto(getProdutos().indexOf(produto)); // id do produto sempre será o número do index da Arraylist
        } else {
            System.out.println("Produto já existente no fornecedor");
            return false;
        }
        return true;
    }

    // remove produto se o id do parâmetro for o mesmo dele
    public boolean removeProduto(Produto produto) {

        for (int i = 0; i< produtos.size(); i++) {
            if (produtos.get(i) == produto) {
                produtos.remove(i);
                for (int j = 0; j < produtos.size() -1; j++) {
                    produtos.get(j).setIdProduto(produtos.indexOf(j));
                }
                return true;
            } else {
                return false;
            }
        }
        return true;
    }



    public Integer getID() {
        return ID;
    }

    public void listaProdutos() {
        produtos.forEach(System.out::println);
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public String getDescricaoFornecedor() {
        return descricaoFornecedor;
    }

    public String getEnderecoFornecedor() {
        return enderecoFornecedor;
    }
}
