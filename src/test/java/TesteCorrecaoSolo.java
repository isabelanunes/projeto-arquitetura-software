
import com.mycompany.sacorrecaosolo.CorrecaoSolo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TesteCorrecaoSolo {

    CorrecaoSolo ca = new CorrecaoSolo();

    @Test
    public void testaValoresIdeaisArgiloso() {
        assertArrayEquals(new double[]{9, 0.35, 6, 1.5, 9, 0}, ca.calcIdeal(1));
    }

    @Test
    public void testaValoresIdeaisTextMedia() {
        assertArrayEquals(new double[]{12, 0.25, 4, 1, 6, 0}, ca.calcIdeal(2));
    }

    @Test
    public void testaCorrecaoFosforoSuperfosfatoSimples() {
        assertEquals(233, ca.calculaCorrecaoFosforoQtdAplicar(8.59, 1, 15, 70));
        assertEquals("Superfosfato Simples", ca.getNomeFonteFosforo(1));
        assertEquals(23.3, ca.calcFosforoCorrecaoAdicional1(8.59, 1, 15, 70));
        assertEquals(65.2, ca.calcFosforoCorrecaoAdicional2(8.59, 1, 15, 70));
        assertEquals("Enxofre", ca.getNomeCorrecaoAdicional1(1));
        assertEquals("Cálcio", ca.getNomeCorrecaoAdicional2(1));
        assertEquals(1.29, ca.calcCorrecaoFosforoCusto(8.59, 1, 15, 70, 5.53));

    }

    @Test
    public void testaCorrecaoFosforoSuperfosfatoTriplo() {
        assertEquals(102.29, ca.calculaCorrecaoFosforoQtdAplicar(8.59, 2, 15, 70));
        assertEquals("Superfosfato Triplo", ca.getNomeFonteFosforo(2));
        assertEquals(20.5, ca.calcFosforoCorrecaoAdicional2(8.59, 2, 15, 70));
        assertEquals("Cálcio", ca.getNomeCorrecaoAdicional2(2));
        assertEquals(0.57, ca.calcCorrecaoFosforoCusto(8.59, 2, 15, 70, 5.53));

    }

    @Test
    public void testaCorrecaoFosforoMAP() {
        assertEquals(87.37, ca.calculaCorrecaoFosforoQtdAplicar(8.59, 3, 15, 70));
        assertEquals("MAP", ca.getNomeFonteFosforo(3));
        assertEquals(7.9, ca.calcFosforoCorrecaoAdicional2(8.59, 3, 15, 70));
        assertEquals("Nitrogênio", ca.getNomeCorrecaoAdicional2(3));
        assertEquals(0.48, ca.calcCorrecaoFosforoCusto(8.59, 3, 15, 70, 5.53));

    }

    @Test
    public void testaCorrecaoFosforoDAP() {
        assertEquals(93.2, ca.calculaCorrecaoFosforoQtdAplicar(8.59, 4, 15, 70));
        assertEquals("DAP", ca.getNomeFonteFosforo(4));
        assertEquals(14.9, ca.calcFosforoCorrecaoAdicional2(8.59, 4, 15, 70));
        assertEquals("Nitrogênio", ca.getNomeCorrecaoAdicional2(4));
        assertEquals(0.52, ca.calcCorrecaoFosforoCusto(8.59, 4, 15, 70, 5.53));

    }

    @Test
    public void testaCorrecaoFosforoYoorin() {
        assertEquals(233, ca.calculaCorrecaoFosforoQtdAplicar(8.59, 5, 15, 70));
        assertEquals("Termofosfato Yoorin", ca.getNomeFonteFosforo(5));
        assertEquals(34.9, ca.calcFosforoCorrecaoAdicional1(8.59, 5, 15, 70));
        assertEquals(65.2, ca.calcFosforoCorrecaoAdicional2(8.59, 5, 15, 70));
        assertEquals("Magnésio", ca.getNomeCorrecaoAdicional1(5));
        assertEquals("Cálcio", ca.getNomeCorrecaoAdicional2(5));
        assertEquals(1.29, ca.calcCorrecaoFosforoCusto(8.59, 5, 15, 70, 5.53));

    }

    @Test
    public void testaCorrecaoFosforoFosfatoArad() {
        assertEquals(127.09, ca.calculaCorrecaoFosforoQtdAplicar(8.59, 6, 15, 70));
        assertEquals("Fosfato Arad", ca.getNomeFonteFosforo(6));
        assertEquals(66.1, ca.calcFosforoCorrecaoAdicional2(8.59, 6, 15, 70));
        assertEquals("Cálcio", ca.getNomeCorrecaoAdicional2(6));
        assertEquals(0.70, ca.calcCorrecaoFosforoCusto(8.59, 6, 15, 70, 5.53));
    }

    @Test
    public void testaCorrecaoReativoGafsa() {
        assertEquals(144.62, ca.calculaCorrecaoFosforoQtdAplicar(8.59, 7, 15, 70));
        assertEquals("Fosfato Gafsa", ca.getNomeFonteFosforo(7));
        assertEquals(75.2, ca.calcFosforoCorrecaoAdicional2(8.59, 7, 15, 70));
        assertEquals("Cálcio", ca.getNomeCorrecaoAdicional2(7));
        assertEquals(0.80, ca.calcCorrecaoFosforoCusto(8.59, 7, 15, 70, 5.53));
    }

    @Test
    public void testaCorrecaoFosforoDaoui() {
        assertEquals(131.06, ca.calculaCorrecaoFosforoQtdAplicar(8.59, 8, 15, 70));
        assertEquals("Fosfato Daoui", ca.getNomeFonteFosforo(8));
        assertEquals(59.0, ca.calcFosforoCorrecaoAdicional2(8.59, 8, 15, 70));
        assertEquals("Cálcio", ca.getNomeCorrecaoAdicional2(8));
        assertEquals(0.72, ca.calcCorrecaoFosforoCusto(8.59, 8, 15, 70, 5.53));
    }

    @Test
    public void testaCorrecaoFosforoPatosdeMinas() {
        assertEquals(174.75, ca.calculaCorrecaoFosforoQtdAplicar(8.59, 9, 15, 70));
        assertEquals("Fosfato Patos de Minas", ca.getNomeFonteFosforo(9));
        assertEquals(48.9, ca.calcFosforoCorrecaoAdicional2(8.59, 9, 15, 70));
        assertEquals("Cálcio", ca.getNomeCorrecaoAdicional2(9));
        assertEquals(0.97, ca.calcCorrecaoFosforoCusto(8.59, 9, 15, 70, 5.53));
    }

    @Test
    public void testaCorrecaoFosforoEscoriadeThomas() {
        assertEquals(226.70, ca.calculaCorrecaoFosforoQtdAplicar(8.59, 10, 15, 70));
        assertEquals("Escória de Thomas", ca.getNomeFonteFosforo(10));
        assertEquals(99.7, ca.calcFosforoCorrecaoAdicional2(8.59, 10, 15, 70));
        assertEquals("Cálcio", ca.getNomeCorrecaoAdicional2(10));
        assertEquals(1.25, ca.calcCorrecaoFosforoCusto(8.59, 10, 15, 70, 5.53));
    }

    @Test
    public void testaCorrecaoFosforoAcidoFosfórico() {
        assertEquals(80.65, ca.calculaCorrecaoFosforoQtdAplicar(8.59, 11, 15, 70));
        assertEquals("Ácido Fosfórico", ca.getNomeFonteFosforo(11));
        assertEquals(0.45, ca.calcCorrecaoFosforoCusto(8.59, 11, 15, 70, 5.53));
    }

    @Test
    public void testaCorrecaoFosforoMultifosfatoMagnesiano() {
        assertEquals(233, ca.calculaCorrecaoFosforoQtdAplicar(8.59, 12, 15, 70));
        assertEquals("Multifosfato Magnesiano", ca.getNomeFonteFosforo(12));
        assertEquals(25.6, ca.calcFosforoCorrecaoAdicional1(8.59, 12, 15, 70));
        assertEquals(41.9, ca.calcFosforoCorrecaoAdicional2(8.59, 12, 15, 70));
        assertEquals("Enxofre", ca.getNomeCorrecaoAdicional1(12));
        assertEquals("Cálcio", ca.getNomeCorrecaoAdicional2(12));
        assertEquals(1.29, ca.calcCorrecaoFosforoCusto(8.59, 12, 15, 70, 5.53));
    }

    @Test
    public void testaCorrecaoPotassioCloreto() {
        assertEquals(450.55, ca.calculaCorrecaoPotassioQtdAplicar(0.15, 5.76, 1.63, 5.35, 1, 3));
    }

    @Test
    public void testaCorrecaoPotassioSulfatoDePotassio() {
        assertEquals(502.53, ca.calculaCorrecaoPotassioQtdAplicar(0.15, 5.76, 1.63, 5.35, 2, 3));
    }

    @Test
    public void testaCorrecaoPotassioSulfatodePotassioEMagnesio() {
        assertEquals(1187.8, ca.calculaCorrecaoPotassioQtdAplicar(0.15, 5.76, 1.63, 5.35, 3, 3));
    }

}
