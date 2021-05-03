
import SA.CorrecaoSolo;
import SA.FonteFosforo;
import SA.FontePotassio;
import SA.NutrientesAdicionais;
import org.junit.Assert;
import org.junit.Test;

public class TestesQuadros {

    @Test
    public void testeTeoresDoSolo(){
        //textura do solo não é um valor categórico e sim um valor inteiro
        //é necessário consultar a classe pra ver que são os valores 1 e 2
        //é preciso inferir que 1 corresponde a Argiloso e 2 a Textura Media
        //faltou o valor ideal para o nutriente H+Al
        CorrecaoSolo correcaoSolo = new CorrecaoSolo();
        Assert.assertArrayEquals(new double[] {9, 0.35, 6, 1.5, 9, 0, 0}, correcaoSolo.calcIdeal(1), 0.1);
        Assert.assertArrayEquals(new double[]{12, 0.25, 4, 1, 6, 0, 0}, correcaoSolo.calcIdeal(2), 0.1);

        //faltaram os métodos SCmol, CTCCmol, VPercentual, MOPercentual, calcula Carbono
        Assert.assertEquals(7.54, correcaoSolo.getSCmol(0.15, 5.76, 1.63), 0.0);
        Assert.assertEquals(12.89, correcaoSolo.getCTCCmol(0.15, 5.76, 1.63, 5.35), 0.0);    
        Assert.assertEquals(58.49, correcaoSolo.getVPercentual(0.15, 5.76, 1.63, 5.35), 0.1);
        Assert.assertEquals(3.07, correcaoSolo.getMOPercentual(30.7), 0.1);
        Assert.assertEquals(17.84, correcaoSolo.getCarbono(3.07), 0.1);
    }
    
    @Test
    public void testeCorrecaoFosforo(){
        /* classe NutrientesAdicionais não possuia relação com as outras classes
        necessário retornar o nome do elemento da correcaoAdicional.
        Exisem dois métodos que fazem o calculoCorrecaoAdicional. */
        
        Assert.assertEquals(123.95, FonteFosforo.SUPERFOSFATO_SIMPLES.calculaCorrecaoFosforoQtdAplicar(8.59, 1, 12, 70), 0.1);
        Assert.assertArrayEquals(new Object[]{12.4, NutrientesAdicionais.ENXOFRE}, FonteFosforo.SUPERFOSFATO_SIMPLES.calcFosforoCorrecaoAdicional1(8.59, 1, 12, 70));
        Assert.assertArrayEquals(new Object[]{34.7, NutrientesAdicionais.CALCIO}, FonteFosforo.SUPERFOSFATO_SIMPLES.calcFosforoCorrecaoAdicional2(8.59, 1, 12, 70));
        Assert.assertEquals(156.18, FonteFosforo.SUPERFOSFATO_SIMPLES.calcCorrecaoFosforoCusto(8.59, 1, 12, 70, 1260),0.1);

        Assert.assertEquals(54.4, FonteFosforo.SUPERFOSFATO_TRIPLO.calculaCorrecaoFosforoQtdAplicar(8.59, 1, 12, 70), 0.1);
        Assert.assertArrayEquals(new Object[]{0}, FonteFosforo.SUPERFOSFATO_TRIPLO.calcFosforoCorrecaoAdicional1(8.59, 1, 12, 70));
        Assert.assertArrayEquals(new Object[]{10.9, NutrientesAdicionais.CALCIO}, FonteFosforo.SUPERFOSFATO_TRIPLO.calcFosforoCorrecaoAdicional2(8.59, 1, 12, 70));
        Assert.assertEquals(68.5, FonteFosforo.SUPERFOSFATO_TRIPLO.calcCorrecaoFosforoCusto(8.59, 1, 12, 70, 1260),0.1);
    
        Assert.assertEquals(46.4, FonteFosforo.MAP.calculaCorrecaoFosforoQtdAplicar(8.59, 1, 12, 70), 0.1);
        Assert.assertArrayEquals(new Object[]{0}, FonteFosforo.MAP.calcFosforoCorrecaoAdicional1(8.59, 1, 12, 70));
        Assert.assertArrayEquals(new Object[]{4.2, NutrientesAdicionais.NITROGENIO}, FonteFosforo.MAP.calcFosforoCorrecaoAdicional2(8.59, 1, 12, 70));
        Assert.assertEquals(58.5, FonteFosforo.MAP.calcCorrecaoFosforoCusto(8.59, 1, 12, 70, 1260),0.1);
        
        Assert.assertEquals(49.5, FonteFosforo.DAP.calculaCorrecaoFosforoQtdAplicar(8.59, 1, 12, 70), 0.1);
        Assert.assertArrayEquals(new Object[]{0}, FonteFosforo.DAP.calcFosforoCorrecaoAdicional1(8.59, 1, 12, 70));
        Assert.assertArrayEquals(new Object[]{7.9, NutrientesAdicionais.NITROGENIO}, FonteFosforo.DAP.calcFosforoCorrecaoAdicional2(8.59, 1, 12, 70));
        Assert.assertEquals(62.4, FonteFosforo.DAP.calcCorrecaoFosforoCusto(8.59, 1, 12, 70, 1260),0.1);
    
        Assert.assertEquals(123.9, FonteFosforo.TERMOFOSFATO_YOORIN.calculaCorrecaoFosforoQtdAplicar(8.59, 1, 12, 70), 0.1);
        Assert.assertArrayEquals(new Object[]{18.6, NutrientesAdicionais.MAGNESIO}, FonteFosforo.TERMOFOSFATO_YOORIN.calcFosforoCorrecaoAdicional1(8.59, 1, 12, 70));
        Assert.assertArrayEquals(new Object[]{34.7, NutrientesAdicionais.CALCIO}, FonteFosforo.TERMOFOSFATO_YOORIN.calcFosforoCorrecaoAdicional2(8.59, 1, 12, 70));
        Assert.assertEquals(156.1, FonteFosforo.TERMOFOSFATO_YOORIN.calcCorrecaoFosforoCusto(8.59, 1, 12, 70, 1260),0.1);
    
        Assert.assertEquals(67.6, FonteFosforo.FOSFATO_ARAD.calculaCorrecaoFosforoQtdAplicar(8.59, 1, 12, 70), 0.1);
        Assert.assertArrayEquals(new Object[]{0}, FonteFosforo.FOSFATO_ARAD.calcFosforoCorrecaoAdicional1(8.59, 1, 12, 70));
        Assert.assertArrayEquals(new Object[]{35.2, NutrientesAdicionais.CALCIO}, FonteFosforo.FOSFATO_ARAD.calcFosforoCorrecaoAdicional2(8.59, 1, 12, 70));
        Assert.assertEquals(85.1, FonteFosforo.FOSFATO_ARAD.calcCorrecaoFosforoCusto(8.59, 1, 12, 70, 1260),0.1);
          
        Assert.assertEquals(76.9, FonteFosforo.FOSFATO_GAFSA.calculaCorrecaoFosforoQtdAplicar(8.59, 1, 12, 70), 0.1);
        Assert.assertArrayEquals(new Object[]{0}, FonteFosforo.FOSFATO_GAFSA.calcFosforoCorrecaoAdicional1(8.59, 1, 12, 70));
        Assert.assertArrayEquals(new Object[]{40.0, NutrientesAdicionais.CALCIO}, FonteFosforo.FOSFATO_GAFSA.calcFosforoCorrecaoAdicional2(8.59, 1, 12, 70));
        Assert.assertEquals(96.9, FonteFosforo.FOSFATO_GAFSA.calcCorrecaoFosforoCusto(8.59, 1, 12, 70, 1260),0.1);
        
        Assert.assertEquals(69.7, FonteFosforo.FOSFATO_DAOUI.calculaCorrecaoFosforoQtdAplicar(8.59, 1, 12, 70), 0.1);
        Assert.assertArrayEquals(new Object[]{0}, FonteFosforo.FOSFATO_DAOUI.calcFosforoCorrecaoAdicional1(8.59, 1, 12, 70));
        Assert.assertArrayEquals(new Object[]{31.4, NutrientesAdicionais.CALCIO}, FonteFosforo.FOSFATO_DAOUI.calcFosforoCorrecaoAdicional2(8.59, 1, 12, 70));
        Assert.assertEquals(87.8, FonteFosforo.FOSFATO_DAOUI.calcCorrecaoFosforoCusto(8.59, 1, 12, 70, 1260),0.1);
        
        Assert.assertEquals(92.9, FonteFosforo.FOSFATO_PATOS_DE_MINAS.calculaCorrecaoFosforoQtdAplicar(8.59, 1, 12, 70), 0.1);
        Assert.assertArrayEquals(new Object[]{0}, FonteFosforo.FOSFATO_PATOS_DE_MINAS.calcFosforoCorrecaoAdicional1(8.59, 1, 12, 70));
        Assert.assertArrayEquals(new Object[]{26.0, NutrientesAdicionais.CALCIO}, FonteFosforo.FOSFATO_PATOS_DE_MINAS.calcFosforoCorrecaoAdicional2(8.59, 1, 12, 70));
        Assert.assertEquals(117.1, FonteFosforo.FOSFATO_PATOS_DE_MINAS.calcCorrecaoFosforoCusto(8.59, 1, 12, 70, 1260),0.1);
    
        Assert.assertEquals(120.6, FonteFosforo.ESCORIA_DE_THOMAS.calculaCorrecaoFosforoQtdAplicar(8.59, 1, 12, 70), 0.1);
        Assert.assertArrayEquals(new Object[]{0}, FonteFosforo.ESCORIA_DE_THOMAS.calcFosforoCorrecaoAdicional1(8.59, 1, 12, 70));
        Assert.assertArrayEquals(new Object[]{53.1, NutrientesAdicionais.CALCIO}, FonteFosforo.ESCORIA_DE_THOMAS.calcFosforoCorrecaoAdicional2(8.59, 1, 12, 70));
        Assert.assertEquals(151.94, FonteFosforo.ESCORIA_DE_THOMAS.calcCorrecaoFosforoCusto(8.59, 1, 12, 70, 1260),0.1);
    
        Assert.assertEquals(42.9, FonteFosforo.ACIDO_FOSFORICO.calculaCorrecaoFosforoQtdAplicar(8.59, 1, 12, 70), 0.1);
        Assert.assertArrayEquals(new Object[]{0}, FonteFosforo.ACIDO_FOSFORICO.calcFosforoCorrecaoAdicional1(8.59, 1, 12, 70));
        Assert.assertArrayEquals(new Object[]{0}, FonteFosforo.ACIDO_FOSFORICO.calcFosforoCorrecaoAdicional2(8.59, 1, 12, 70));
        Assert.assertEquals(54.05, FonteFosforo.ACIDO_FOSFORICO.calcCorrecaoFosforoCusto(8.59, 1, 12, 70, 1260),0.1);
        
        Assert.assertEquals(123.9, FonteFosforo.MULTIFOSFATO_MAGNESIANO.calculaCorrecaoFosforoQtdAplicar(8.59, 1, 12, 70), 0.1);
        Assert.assertArrayEquals(new Object[]{13.6,NutrientesAdicionais.ENXOFRE}, FonteFosforo.MULTIFOSFATO_MAGNESIANO.calcFosforoCorrecaoAdicional1(8.59, 1, 12, 70));
        Assert.assertArrayEquals(new Object[]{22.3,NutrientesAdicionais.CALCIO}, FonteFosforo.MULTIFOSFATO_MAGNESIANO.calcFosforoCorrecaoAdicional2(8.59, 1, 12, 70));
        Assert.assertEquals(156.1, FonteFosforo.MULTIFOSFATO_MAGNESIANO.calcCorrecaoFosforoCusto(8.59, 1, 12, 70, 1260),0.1);
    }   
    
    @Test
    public void testeCorrecaoPotassio(){
        /* método do quadro potassio na classe CorrecaoSolo */
        /*incluido metodo de percentual ideal do potassio */
        CorrecaoSolo correcaoSolo = new CorrecaoSolo();
        Assert.assertEquals(1.2, correcaoSolo.calcParticipacaoAtualCTCSoloPotassio(0.15, 5.76, 1.63, 5.35), 0.1);
        Assert.assertEquals(3, correcaoSolo.calcParticipacaoCTCSoloPotassioAposCorrecao(3), 0.1);
        Assert.assertEquals(3.0, correcaoSolo.participacaoPotassioPercentualIdeal(), 0.1);

        Assert.assertEquals(450.5, FontePotassio.CLORETO_DE_POTASSIO.calculaCorrecaoPotassioQtdAplicar(0.15, 5.76, 1.63, 5.35, 1, 3), 0.1);
        Assert.assertArrayEquals(new Object[]{0}, FontePotassio.CLORETO_DE_POTASSIO.calcCorrecaoPotassioAdicional1(0.15, 5.76, 1.63, 5.35, 1, 3));
        Assert.assertArrayEquals(new Object[]{0}, FontePotassio.CLORETO_DE_POTASSIO.calcCorrecaoPotassioAdicional2(0.15, 5.76, 1.63, 5.35, 1, 3));
        Assert.assertEquals(1126.37, FontePotassio.CLORETO_DE_POTASSIO.calcCorrecaoPotassioCusto(0.15, 5.76, 1.63, 5.35, 1, 3, 2500), 0.1); 
        
        Assert.assertEquals(502.5, FontePotassio.SULFATO_DE_POTASSIO.calculaCorrecaoPotassioQtdAplicar(0.15, 5.76, 1.63, 5.35, 1, 3), 0.1);
        Assert.assertArrayEquals(new Object[]{85.43, NutrientesAdicionais.ENXOFRE}, FontePotassio.SULFATO_DE_POTASSIO.calcCorrecaoPotassioAdicional1(0.15, 5.76, 1.63, 5.35, 1, 3));
        Assert.assertArrayEquals(new Object[]{0}, FontePotassio.SULFATO_DE_POTASSIO.calcCorrecaoPotassioAdicional2(0.15, 5.76, 1.63, 5.35, 1, 3));
        Assert.assertEquals(1256.33, FontePotassio.SULFATO_DE_POTASSIO.calcCorrecaoPotassioCusto(0.15, 5.76, 1.63, 5.35, 1, 3, 2500), 0.1);
        
        Assert.assertEquals(1187.8, FontePotassio.SULFATO_DE_POTASSIO_E_MAGNESIO.calculaCorrecaoPotassioQtdAplicar(0.15, 5.76, 1.63, 5.35, 1, 3), 0.1);
        Assert.assertArrayEquals(new Object[]{261.32, NutrientesAdicionais.ENXOFRE}, FontePotassio.SULFATO_DE_POTASSIO_E_MAGNESIO.calcCorrecaoPotassioAdicional1(0.15, 5.76, 1.63, 5.35, 1, 3));
        Assert.assertArrayEquals(new Object[]{213.8, NutrientesAdicionais.MAGNESIO}, FontePotassio.SULFATO_DE_POTASSIO_E_MAGNESIO.calcCorrecaoPotassioAdicional2(0.15, 5.76, 1.63, 5.35, 1, 3));
        Assert.assertEquals(2969.51, FontePotassio.SULFATO_DE_POTASSIO_E_MAGNESIO.calcCorrecaoPotassioCusto(0.15, 5.76, 1.63, 5.35, 1, 3, 2500), 0.1); 
    }

}
