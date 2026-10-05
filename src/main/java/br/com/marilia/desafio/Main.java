package br.com.marilia.desafio;

import br.com.marilia.desafio.comissao.ComissaoService;
import br.com.marilia.desafio.comissao.Venda;
import br.com.marilia.desafio.comissao.VendaJsonReader;
import br.com.marilia.desafio.estoque.EstoqueJsonReader;
import br.com.marilia.desafio.estoque.EstoqueService;
import br.com.marilia.desafio.estoque.Produto;
import br.com.marilia.desafio.juros.JurosService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        executarComissao();

        executarEstoque();

        executarJuros();
    }

    private static void executarComissao() {

        System.out.println("===== QUESTÃO 1 - COMISSÃO =====");

        VendaJsonReader reader = new VendaJsonReader();
        ComissaoService service = new ComissaoService();

        List<Venda> vendas = reader.lerVendas();

        Map<String, BigDecimal> comissoes = new HashMap<>();

        for (Venda venda : vendas) {

            BigDecimal comissao =
                    service.calcularComissao(venda.getValor());

            comissoes.merge(
                    venda.getVendedor(),
                    comissao,
                    BigDecimal::add
            );
        }

        comissoes.forEach((vendedor, comissao) ->
                System.out.println(
                        vendedor + " - Comissão: R$ "
                                + comissao.setScale(2)
                )
        );

        System.out.println();
    }

private static void executarEstoque() {

    System.out.println("===== QUESTÃO 2 - ESTOQUE =====");

    EstoqueJsonReader reader = new EstoqueJsonReader();
    EstoqueService service = new EstoqueService();

    List<Produto> produtos = reader.lerProdutos();

    int estoqueFinal = service.realizarMovimentacao(
            produtos,
            101,
            "ENTRADA",
            "Reposição de mercadoria",
            50
    );

    System.out.println(
            "Produto: Caneta Azul"
    );

    System.out.println(
            "Estoque final: " + estoqueFinal
    );

    System.out.println(
            "Movimentações registradas: "
                    + service.listarMovimentacoes().size()
    );

    System.out.println();
}
    private static void executarJuros() {

        System.out.println("===== QUESTÃO 3 - JUROS =====");

        JurosService service = new JurosService();

        BigDecimal valor = BigDecimal.valueOf(100);

        LocalDate vencimento =
                LocalDate.now().minusDays(5);

        BigDecimal juros =
                service.calcularJuros(
                        valor,
                        vencimento
                );

        System.out.println(
                "Valor: R$ " + valor
        );

        System.out.println(
                "Vencimento: " + vencimento
        );

        System.out.println(
                "Juros: R$ " + juros
        );

        System.out.println();
    }
}