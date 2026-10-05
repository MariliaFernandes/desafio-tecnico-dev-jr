package br.com.marilia.desafio.estoque;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EstoqueJsonReaderTest {

    @Test
    void deveLerProdutosDoJson() {

        EstoqueJsonReader reader = new EstoqueJsonReader();

        List<Produto> produtos = reader.lerProdutos();

        assertNotNull(produtos);
        assertEquals(5, produtos.size());

        assertEquals(
                101,
                produtos.get(0).getCodigoProduto()
        );

        assertEquals(
                "Caneta Azul",
                produtos.get(0).getDescricaoProduto()
        );

        assertEquals(
                150,
                produtos.get(0).getEstoque()
        );
    }
}