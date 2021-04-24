# projeto-arquitetura-software
Repositório utilizado para armazenar os artefatos da arquitetura de um aplicativo de correção de solos da disciplina IF67K - Arquitetura de Software

# Relatório de pontos de manutenibilidade (Atividade 3)

## Problemas encontrados
O código apresentava uma grande quantidade de estruturas condicionais (63), pois utilizava por exemplo, um case de um switch-case para retornar a correção de
cada fonte de fósforo ou potássio. Também realizava várias verificações para não permitir o retorno de valores negativos, como quantidade a aplicar no solo ou custo. Outro problema encontrado foi a quantidade de pontos de alteração (21) no código, pois a alteração de uma fonte de fósforo ou potássio necessitava alterar todos os métodos em que ela está presente.


## 1. Linhas de código
### Antes

A utilização do comando cloc neste projeto gerou o seguinte output:

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

## 2. Estruturas de decisão
### Antes

Foi contabilizado o uso de 63 estruturas de decisões incluíndo if-elses e switch. 

## 3. Pontos de alteração
### Antes

Foram contabilizados 21 pontos de alteração no código.
