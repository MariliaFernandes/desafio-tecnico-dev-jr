package br.com.marilia.desafio.estoque;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EstoqueServiceTest {

    @Test
    void deveAdicionarProdutoAoEstoque() {

        List<Produto> produtos = new ArrayList<>();

        produtos.add(
                new Produto(101, "Caneta Azul", 150)
        );

        EstoqueService service = new EstoqueService();

        service.realizarMovimentacao(
                produtos,
                101,
                "ENTRADA",
                "Reposição de estoque",
                50
        );

        assertEquals(
                200,
                service.consultarEstoque(produtos, 101)
        );
    }

    @Test
    void deveRetirarProdutoDoEstoque() {

        List<Produto> produtos = new ArrayList<>();

        produtos.add(
                new Produto(101, "Caneta Azul", 150)
        );

        EstoqueService service = new EstoqueService();

        service.realizarMovimentacao(
                produtos,
                101,
                "SAIDA",
                "Venda",
                30
        );

        assertEquals(
                120,
                service.consultarEstoque(produtos, 101)
        );
    }

    @Test
    void naoDevePermitirSaidaMaiorQueEstoque() {

        List<Produto> produtos = new ArrayList<>();

        produtos.add(
                new Produto(101, "Caneta Azul", 150)
        );

        EstoqueService service = new EstoqueService();

        assertThrows(
                IllegalArgumentException.class,
                () -> service.realizarMovimentacao(
                        produtos,
                        101,
                        "SAIDA",
                        "Venda",
                        200
                )
        );
    }
}