package br.com.marilia.desafio.comissao;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ComissaoService {

    public BigDecimal calcularComissao(BigDecimal valorVenda) {

        if (valorVenda.compareTo(BigDecimal.valueOf(100)) < 0) {
            return BigDecimal.ZERO;
        }

        if (valorVenda.compareTo(BigDecimal.valueOf(500)) < 0) {
            return valorVenda
                    .multiply(BigDecimal.valueOf(0.01))
                    .setScale(2, RoundingMode.HALF_UP);
        }

        return valorVenda
                .multiply(BigDecimal.valueOf(0.05))
                .setScale(2, RoundingMode.HALF_UP);
    }
}