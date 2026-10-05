package br.com.marilia.desafio.juros;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class JurosService {

    private static final BigDecimal TAXA_DIARIA =
            BigDecimal.valueOf(0.025);

    public BigDecimal calcularJuros(
            BigDecimal valor,
            LocalDate dataVencimento) {

        if (valor == null || valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    "O valor deve ser maior ou igual a zero."
            );
        }

        if (dataVencimento == null) {
            throw new IllegalArgumentException(
                    "A data de vencimento é obrigatória."
            );
        }

        LocalDate hoje = LocalDate.now();

        if (!hoje.isAfter(dataVencimento)) {
            return BigDecimal.ZERO.setScale(2);
        }

        long diasAtraso = ChronoUnit.DAYS.between(
                dataVencimento,
                hoje
        );

        return valor
                .multiply(TAXA_DIARIA)
                .multiply(BigDecimal.valueOf(diasAtraso))
                .setScale(2, RoundingMode.HALF_UP);
    }
}