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

# Relatório - Atividade #4
O objetivo desta atividade foi criar três testes que simulam os quadros de teores do solo, correção/recuperação de fósforo, e correção/recuperação de potássio.
Serão elencados abaixo os resultados obtidos bem como as dificuldades encontradas para cada quadro.

<ul>
       <li><b>Teores do Solo</b> - <a href="https://github.com/isabelanunes/projeto-arquitetura-software/commit/92ed2835df1db851d7319570260727f6f218acaf">commit</a></li>
       <p> <b>Dificuldades/problemas encontrados: </b> <br> 
              a) A textura do solo não é um valor categórico e sim um valor inteiro, onde 1 corresponde à Solo Argiloso e 2 à Textura Média. <br>
              Essa decisão de implementação pode tornar o entendimento da aplicação dificultoso para quem não conhece o problema que está sendo tratado, pois é necessário    realizar uma investigação na classe <i>CorrecaoSolo</i> e no método <i>calcIdeal()</i> para realizar uma inferência em relação ao problema abordado. <br> 
              b) Faltou o retorno do valor ideal para o nutriente H+Al. O problema foi resolvido acrescentando um elemento ao atributo nutrienteIdeal da classe <i>CorrecaoSolo</i> e retornando o valor ideal no método <i>calcIdeal()</i>. <br>
              c) Faltou a implementação dos métodos de correção da CTC, tais quais: S cmol, CTC cmol, V percentual, Teor Ideal de MO percentual e o cálculo do Carbono. <br>
              Os métodos acima citados foram implementados na classe <i>CorrecaoSolo</i>. <br>
              <b>Observação:</b> o método que realiza o cálculo dos valores ideais dos nutrientes retornou os valores esperados. <br>
       </p>
       <li><b>Correção/recuperação de Fósforo</b> - <a href="https://github.com/isabelanunes/projeto-arquitetura-software/commit/bc32c791ae81ff3d9b9b15e7d2f33c079a0a0566">commit</a></li>
       <p> <b>Dificuldades/problemas encontrados: </b> <br> 
              a) A classe NutrientesAdicionais não possui relação com as outras classes da aplicação, entretanto era utilizada de forma isolada nos métodos de testes. <br> Analisando a implementação, inferi que a utilização teria como objetivo, cobrir o teste do método de nutrientes adicionais fornecidos com a correção, sendo implementada da seguinte forma "<i>assertEquals("CALCIO", NutrientesAdicionais.CALCIO.name());</i>". Este teste não cobre de fato um método da aplicação. </br>
              b) Os métodos <i>calcFosforoCorrecaoAdicional1()</i> e <i>calcFosforoCorrecaoAdicional2()</i> da classe <i>FonteFosforo</i> não retornam o nome do nutriente adicional, somente os valores. <br>
              Sendo assim, foi necessário alterar o retorno do método (double para Object[]) para que fosse possível retornar também o nome do elemento, além do valor. <br>
              c) A alteração necessária no ponto b) foi dificultosa pois a mudança teve que ser implementada em todos os valores do enum da classe <i>FonteFosforo</i>, visto que cada valor implementa este método. Além disso, como existem dois métodos que realizam a mesma coisa, a mudança teve que ser replicada para ambos. <br>
              <b>Observação: </b>os métodos <i>calculaCorrecaoFosforoQtdAplicar()</i> e <i>calcCorrecaoFosforoCusto()</i> retornaram os valores esperados. O valor calculado para o elemento adicional também estava correto. Além disso, houve um tratamento de arredondamento para os retornos do tipo double, o que facilitou a implementação dos testes. 
       </p>
        <li><b>Correção/recuperação de Potássio</b> - <a href="https://github.com/isabelanunes/projeto-arquitetura-software/commit/6b30b8edcdc93b2096cb00276e623cbc9c4f3d45">commit</a></li>
       <p> <b>Dificuldades/problemas encontrados: </b> <br>
              a) As dificuldades e problemas elencados para a Correção/recuperação de Fósforo se estendem para esta análise. <br>
              b) Os métodos do quadro de correção do potássio não estão inteiramente concentrados na classe <i>Fonte Potássio</i>. <br>
       Os métodos <i>calcParticipacaoAtualCTCSoloPotassio()</i> e <i>calcParticipacaoCTCSoloPotassioAposCorrecao()</i> pertencem a classe <i>CorrecaoSolo</i>. <br>
              c) Faltou o método que retorna o percentual ideal do potássio. <br>
       O método faltante foi implementando na classe <i>CorrecaoSolo</i>, seguindo a estrutura da aplicação. <br>
              <b>Observação: </b>os métodos <i>calculaCorrecaoFosforoQtdAplicar()</i> e <i>calcCorrecaoFosforoCusto()</i> retornaram os valores esperados. O valor calculado para o elemento adicional também estava correto. Além disso, houve um tratamento de arredondamento para os retornos do tipo double, o que facilitou a implementação dos testes. 
       </p>
       
</ul>
