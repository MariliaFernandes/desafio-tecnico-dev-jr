package br.com.marilia.desafio.estoque;

import java.util.List;

public class EstoqueResponse {

    private List<Produto> estoque;

    public EstoqueResponse() {
    }

    public List<Produto> getEstoque() {
        return estoque;
    }

    public void setEstoque(List<Produto> estoque) {
        this.estoque = estoque;
    }
}