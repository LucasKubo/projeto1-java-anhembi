package Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GerenciarProdutos {
    List<Produto> produtos = new ArrayList<>();

    public void adicionar(Produto p) {
        //Adiciona produto à lista
        produtos.add(p);
    }

    public boolean remover(int codigo) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCodigo() == codigo) {
                produtos.remove(produtos.get(i));
                return true;
            }
        }
        return false;
    }

    public Produto buscarPorCodigo(int codigo) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCodigo() == codigo) {
                return produtos.get(i);
            }
        }
        return null;
    }

    public String listarEletronicos() {
        StringBuilder produtosEletronicos = new StringBuilder("");
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i) instanceof Eletronico) {
                produtosEletronicos.append(produtos.get(i).imprimir()).append("\n");
            }
        }
        return produtosEletronicos.toString();
    }


    public String listarPereciveis() {
        StringBuilder produtosPereciveis = new StringBuilder("");
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i) instanceof Perecivel) {
                produtosPereciveis.append(produtos.get(i).imprimir()).append("\n");
            }
        }
        return produtosPereciveis.toString();
    }

    public String listarMoveis() {
        StringBuilder produtosMoveis = new StringBuilder("");
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i) instanceof Movel) {
                produtosMoveis.append(produtos.get(i).imprimir()).append("\n");
            }
        }
        return produtosMoveis.toString();
    }

    public String listarEstoqueMenor(int quantidadeMinima) {
        StringBuilder produtosEstoqueMenor = new StringBuilder("");
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getQuantidade() < quantidadeMinima) {
                produtosEstoqueMenor.append(produtos.get(i).imprimir()).append("\n");
            }
        }
        return produtosEstoqueMenor.toString();
    }

    public String listarEstoqueVazio() {
        StringBuilder produtosEstoqueVazio = new StringBuilder("");
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getQuantidade() == 0) {
                produtosEstoqueVazio.append(produtos.get(i).imprimir()).append("\n");
            }
        }
        return produtosEstoqueVazio.toString();
    }

    public String listarPorFabricante(String fabricante) {
        StringBuilder produtosPorFabricante = new StringBuilder("");
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getFabricante().equals(fabricante)) {
                produtosPorFabricante.append(produtos.get(i).imprimir()).append("\n");
            }
        }
        return produtosPorFabricante.toString();
    }

    public String listarPorValidade(LocalDate validade) {
        StringBuilder listaValidade = new StringBuilder("");
        List<Perecivel> pereciveis = new ArrayList<>();
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i) instanceof  Perecivel ) {
                pereciveis.add((Perecivel) produtos.get(i));
            }
        }
        for (Perecivel perecivel:pereciveis) {
            if(perecivel.getValidade().isEqual(validade)){
                listaValidade.append(perecivel.imprimir()).append("\n");
            }
        }
        return listaValidade.toString();
    }

    public double venderProduto(int codigoProduto, int quantidade) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCodigo() == codigoProduto) {
                return produtos.get(i).vender(quantidade);
            }
        }
        return -1;
    }

    public boolean comprarProduto(int codigoProduto, int quantidade) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCodigo() == codigoProduto) {
                produtos.get(i).comprar(quantidade);
                return true;
            }
        }
        return false;
    }

    public String listarTudo() {
        StringBuilder listaProdutos = new StringBuilder("");
        for (int i = 0; i < produtos.size(); i++) {
            listaProdutos.append(produtos.get(i).imprimir()).append("\n");
        }
        return listaProdutos.toString();
    }

}
