
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

}
