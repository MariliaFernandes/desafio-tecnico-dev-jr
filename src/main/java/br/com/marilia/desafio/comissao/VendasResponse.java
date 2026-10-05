package br.com.marilia.desafio.comissao;

import java.util.List;

public class VendasResponse {

    private List<Venda> vendas;

    public VendasResponse() {
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }
}