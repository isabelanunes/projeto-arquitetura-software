# projeto-arquitetura-software
Repositório utilizado para armazenar os artefatos da arquitetura de um aplicativo de correção de solos da disciplina IF67K - Arquitetura de Software

# Relatório de pontos de manutenibilidade (Atividade 3)

## Problemas encontrados
O código apresentava uma grande quantidade de estruturas condicionais (63), pois utilizava por exemplo, um case de um switch-case para retornar a correção de
cada fonte de fósforo ou potássio. Também realizava várias verificações para não permitir o retorno de valores negativos, como quantidade a aplicar no solo ou custo. Outro problema encontrado foi a quantidade de pontos de alteração (21) no código, pois a alteração de uma fonte de fósforo ou potássio necessitava alterar todos os métodos em que ela está presente.

## Soluções
Para diminuir a quantidade de estruturas condicionais e pontos de alteração foram utilizados os seguintes passos: 1 - utilizar uma classe enum para fonte de fósforo e outra para fonte de potássio, sendo que cada classe contém um grupo de constantes que representam cada fonte de fósforo ou potássio (https://github.com/jvitorgf/projeto-arquitetura-software/commit/c747c7f8429d32be9638f60a0d0aba9ebc1a2849). 2 - Utilizar o padrão de projeto Factory (https://java-design-patterns.com/patterns/factory/) para criar uma interface contendo a assinatura dos métodos que realizam os cálculos de correção de fósforo e outra para os cálculos de potássio. Depois, utilizar as classes enum para implementar cada método de correção em cada tipo de fonte. 3 - utilizar o método max da classe Math do java (https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html) para retornar o maior valor entre 0 e um valor da correção, eliminando a condicional que não permitia o retorno de valores negativos. Os passos 2 e 3 foram implementados tanto para correção de fósforo (https://github.com/jvitorgf/projeto-arquitetura-software/commit/a7f802ea256d2b9e6f3587e650312c10061bfc6f) quanto para de potássio (https://github.com/jvitorgf/projeto-arquitetura-software/commit/e4f7879f0a44961c685a800187e58a796cade873). Apesar de um aumento no número de linhas de código do projeto, houve uma diminuição drástica no número de estruturas condicionais e pontos de alteração.

## 1. Linhas de código

A utilização do comando cloc neste projeto gerou o seguinte output:

### Antes

<pre>cloc CorrecaoSolo.java 
       1 text file.
       1 unique file.                              
       0 files ignored.

github.com/AlDanial/cloc v 1.74  T=0.05 s (18.8 files/s, 5312.4 lines/s)
-------------------------------------------------------------------------------
Language                     files          blank        comment           code
-------------------------------------------------------------------------------
Java                             1             40              0            242
-------------------------------------------------------------------------------</pre>
### Depois

<pre>cloc sacorrecaosolo/
       6 text files.
       6 unique files.                              
       0 files ignored.

github.com/AlDanial/cloc v 1.74  T=0.14 s (42.3 files/s, 3231.2 lines/s)
-------------------------------------------------------------------------------
Language                     files          blank        comment           code
-------------------------------------------------------------------------------
Java                             6             82              0            376
-------------------------------------------------------------------------------
SUM:                             6             82              0            376
-------------------------------------------------------------------------------
</pre>

## 2. Estruturas de decisão
### Antes

Foi contabilizado o uso de 63 estruturas de decisões incluíndo if-elses e switch. 

### Depois

Após as mudanças o número de estruturas de decisão do projeto é 2.

## 3. Pontos de alteração
### Antes

Foram contabilizados 21 pontos de alteração no código.

### Depois

Após as mudanças o número de pontos de alteração no projeto é 4.

