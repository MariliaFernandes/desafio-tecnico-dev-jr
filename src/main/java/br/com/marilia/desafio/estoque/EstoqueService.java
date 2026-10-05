package br.com.marilia.desafio.estoque;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class EstoqueService {

    private final AtomicLong proximoId = new AtomicLong(1);

    private final List<Movimentacao> movimentacoes = new ArrayList<>();

    public Integer realizarMovimentacao(
            List<Produto> produtos,
            Integer codigoProduto,
            String tipo,
            String descricao,
            Integer quantidade) {

        if (quantidade == null || quantidade <= 0) {
            throw new IllegalArgumentException(
                    "A quantidade deve ser maior que zero."
            );
        }

        if (tipo == null ||
                (!tipo.equalsIgnoreCase("ENTRADA")
                        && !tipo.equalsIgnoreCase("SAIDA"))) {

            throw new IllegalArgumentException(
                    "Tipo de movimentação inválido. Use ENTRADA ou SAIDA."
            );
        }

        Produto produto = produtos.stream()
                .filter(p -> p.getCodigoProduto().equals(codigoProduto))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "Produto não encontrado: " + codigoProduto
                ));

        if (tipo.equalsIgnoreCase("ENTRADA")) {

            produto.setEstoque(
                    produto.getEstoque() + quantidade
            );

        } else {

            if (quantidade > produto.getEstoque()) {
                throw new IllegalArgumentException(
                        "Estoque insuficiente para realizar a saída."
                );
            }

            produto.setEstoque(
                    produto.getEstoque() - quantidade
            );
        }

        Movimentacao movimentacao = new Movimentacao(
                proximoId.getAndIncrement(),
                codigoProduto,
                tipo.toUpperCase(),
                descricao,
                quantidade
        );

        movimentacoes.add(movimentacao);

        return produto.getEstoque();
    }

    public Integer consultarEstoque(
            List<Produto> produtos,
            Integer codigoProduto) {

        return produtos.stream()
                .filter(p -> p.getCodigoProduto().equals(codigoProduto))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "Produto não encontrado: " + codigoProduto
                ))
                .getEstoque();
    }

    public List<Movimentacao> listarMovimentacoes() {
        return Collections.unmodifiableList(movimentacoes);
    }
}

