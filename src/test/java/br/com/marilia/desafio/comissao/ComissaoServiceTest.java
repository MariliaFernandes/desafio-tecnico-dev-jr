package br.com.marilia.desafio.comissao;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComissaoServiceTest {

    private final ComissaoService service = new ComissaoService();

    @Test
    void deveRetornarZeroParaVendaAbaixoDe100() {
        BigDecimal resultado = service.calcularComissao(
                BigDecimal.valueOf(99.99)
        );

        assertEquals(
                BigDecimal.ZERO,
                resultado
        );
    }

    @Test
    void deveCalcularUmPorCentoParaVendaEntre100E499() {
        BigDecimal resultado = service.calcularComissao(
                BigDecimal.valueOf(200)
        );

        assertEquals(
                BigDecimal.valueOf(2.00).setScale(2),
                resultado
        );
    }

    @Test
    void deveCalcularCincoPorCentoParaVendaDe500OuMais() {
        BigDecimal resultado = service.calcularComissao(
                BigDecimal.valueOf(500)
        );

        assertEquals(
                BigDecimal.valueOf(25.00).setScale(2),
                resultado
        );
    }
}