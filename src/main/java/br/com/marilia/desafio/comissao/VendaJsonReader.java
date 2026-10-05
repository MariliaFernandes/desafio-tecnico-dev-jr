package br.com.marilia.desafio.comissao;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

public class VendaJsonReader {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Venda> lerVendas() {
        try {
            InputStream arquivo = getClass()
                    .getClassLoader()
                    .getResourceAsStream("vendas.json");

            if (arquivo == null) {
                throw new RuntimeException("Arquivo vendas.json não encontrado.");
            }

            VendasResponse response = objectMapper.readValue(
                    arquivo,
                    VendasResponse.class
            );

            return response.getVendas();

        } catch (Exception e) {
            throw new RuntimeException(
                    "Erro ao ler o arquivo vendas.json.",
                    e
            );
        }
    }
}