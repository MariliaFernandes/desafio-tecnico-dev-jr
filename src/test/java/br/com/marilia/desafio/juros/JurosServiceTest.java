package br.com.marilia.desafio.juros;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JurosServiceTest {

    @Test
    void naoDeveCalcularJurosParaVencimentoHoje() {

        JurosService service = new JurosService();

        BigDecimal resultado = service.calcularJuros(
                BigDecimal.valueOf(100),
                LocalDate.now()
        );

        assertEquals(
                BigDecimal.ZERO.setScale(2),
                resultado
        );
    }

    @Test
    void deveCalcularJurosDeUmDia() {

        JurosService service = new JurosService();

        BigDecimal resultado = service.calcularJuros(
                BigDecimal.valueOf(100),
                LocalDate.now().minusDays(1)
        );

        assertEquals(
                BigDecimal.valueOf(2.50).setScale(2),
                resultado
        );
    }

    @Test
    void deveCalcularJurosDeCincoDias() {

        JurosService service = new JurosService();

        BigDecimal resultado = service.calcularJuros(
                BigDecimal.valueOf(100),
                LocalDate.now().minusDays(5)
        );

        assertEquals(
                BigDecimal.valueOf(12.50).setScale(2),
                resultado
        );
    }
}