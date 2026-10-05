package br.com.marilia.desafio.comissao;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VendaJsonReaderTest {

    @Test
    void deveLerTodasAsVendasDoArquivoJson() {
        VendaJsonReader reader = new VendaJsonReader();

        List<Venda> vendas = reader.lerVendas();

        assertEquals(36, vendas.size());
    }
}