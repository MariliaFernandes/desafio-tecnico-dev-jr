package br.com.marilia.desafio.estoque;

public class Movimentacao {

    private Long id;
    private Integer codigoProduto;
    private String tipo;
    private String descricao;
    private Integer quantidade;

    public Movimentacao() {
    }

    public Movimentacao(
            Long id,
            Integer codigoProduto,
            String tipo,
            String descricao,
            Integer quantidade) {

        this.id = id;
        this.codigoProduto = codigoProduto;
        this.tipo = tipo;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public Integer getCodigoProduto() {
        return codigoProduto;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}