package br.com.marilia.desafio.estoque;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

public class EstoqueJsonReader {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Produto> lerProdutos() {

        try {

            InputStream arquivo = getClass()
                    .getClassLoader()
                    .getResourceAsStream("estoque.json");

            if (arquivo == null) {
                throw new RuntimeException(
                        "Arquivo estoque.json não encontrado."
                );
            }

            EstoqueResponse response = objectMapper.readValue(
                    arquivo,
                    EstoqueResponse.class
            );

            return response.getEstoque();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Erro ao ler o arquivo estoque.json.",
                    e
            );
        }
    }
}