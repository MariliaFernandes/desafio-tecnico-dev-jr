# Desafio Técnico - Desenvolvedor Júnior

Projeto desenvolvido para resolução de desafio técnico para a vaga de Desenvolvedor Júnior.

## Tecnologias utilizadas

* Java 17
* Maven
* JUnit 5
* Jackson
* JSON

## Funcionalidades

### 1. Cálculo de comissão

O sistema realiza o cálculo de comissão de acordo com o valor da venda:

* Vendas abaixo de R$ 100,00: sem comissão
* Vendas abaixo de R$ 500,00: comissão de 1%
* Vendas a partir de R$ 500,00: comissão de 5%

As vendas são carregadas a partir do arquivo:

```text
src/main/resources/vendas.json
```

### 2. Movimentação de estoque

O sistema permite realizar movimentações de:

* ENTRADA
* SAIDA

Cada movimentação possui:

* identificador único
* código do produto
* tipo da movimentação
* descrição
* quantidade

O estoque do produto é atualizado após cada movimentação.

As informações iniciais dos produtos são carregadas a partir do arquivo:

```text
src/main/resources/estoque.json
```

Também é possível consultar o estoque final de um produto e listar as movimentações realizadas.

### 3. Cálculo de juros

O sistema calcula juros de 2,5% ao dia sobre valores vencidos.

O cálculo considera a quantidade de dias entre a data de vencimento e a data atual.

## Estrutura do projeto

```text
src
├── main
│   ├── java
│   │   └── br.com.marilia.desafio
│   │       ├── Main.java
│   │       ├── comissao
│   │       ├── estoque
│   │       └── juros
│   │
│   └── resources
│       ├── vendas.json
│       └── estoque.json
│
└── test
    └── java
        └── br.com.marilia.desafio
            ├── comissao
            ├── estoque
            └── juros
```

## Como executar

É necessário ter Java 17 e Maven instalados.

Para executar os testes:

```bash
mvn clean test
```

Para executar a aplicação pela IDE, execute a classe:

```text
br.com.marilia.desafio.Main
```

## Testes

O projeto possui testes automatizados utilizando JUnit 5.

Os testes verificam:

* cálculo de comissão
* leitura das vendas pelo JSON
* entrada de estoque
* saída de estoque
* validação de estoque insuficiente
* leitura dos produtos pelo JSON
* cálculo de juros
* comportamento para valores ainda não vencidos

## Resultado dos testes

Todos os testes automatizados devem ser executados com:

```bash
mvn clean test
```

Resultado atual:

```text
Tests run: 11
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
```
