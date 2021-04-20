
import com.mycompany.sacorrecaosolo.CorrecaoSolo;
import com.mycompany.sacorrecaosolo.FonteFosforo;
import com.mycompany.sacorrecaosolo.FontePotassio;
import com.mycompany.sacorrecaosolo.NutrientesAdicionais;
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
        assertEquals("SUPERFOSFATO_SIMPLES",FonteFosforo.SUPERFOSFATO_SIMPLES.name());
        assertEquals(23.3, ca.calcFosforoCorrecaoAdicional1(8.59, 1, 15, 70));
        assertEquals(65.2, ca.calcFosforoCorrecaoAdicional2(8.59, 1, 15, 70));
        assertEquals("ENXOFRE", NutrientesAdicionais.ENXOFRE.name());
        assertEquals("CALCIO", NutrientesAdicionais.CALCIO.name());
        assertEquals(1.29, ca.calcCorrecaoFosforoCusto(8.59, 1, 15, 70, 5.53));

    }

    @Test
    public void testaCorrecaoFosforoSuperfosfatoTriplo() {
        assertEquals(102.29, ca.calculaCorrecaoFosforoQtdAplicar(8.59, 2, 15, 70));
        assertEquals("SUPERFOSFATO_TRIPLO",FonteFosforo.SUPERFOSFATO_TRIPLO.name());
        assertEquals(20.5, ca.calcFosforoCorrecaoAdicional2(8.59, 2, 15, 70));
        assertEquals("CALCIO", NutrientesAdicionais.CALCIO.name());
        assertEquals(0.57, ca.calcCorrecaoFosforoCusto(8.59, 2, 15, 70, 5.53));

    }

    @Test
    public void testaCorrecaoFosforoMAP() {
        assertEquals(87.37, ca.calculaCorrecaoFosforoQtdAplicar(8.59, 3, 15, 70));
        assertEquals("MAP", FonteFosforo.MAP.name());
        assertEquals(7.9, ca.calcFosforoCorrecaoAdicional2(8.59, 3, 15, 70));
        assertEquals("NITROGENIO", NutrientesAdicionais.NITROGENIO.name());
        assertEquals(0.48, ca.calcCorrecaoFosforoCusto(8.59, 3, 15, 70, 5.53));

    }

    @Test
    public void testaCorrecaoFosforoDAP() {
        assertEquals(93.2, ca.calculaCorrecaoFosforoQtdAplicar(8.59, 4, 15, 70));
        assertEquals("DAP", FonteFosforo.DAP.name());
        assertEquals(14.9, ca.calcFosforoCorrecaoAdicional2(8.59, 4, 15, 70));
        assertEquals("NITROGENIO", NutrientesAdicionais.NITROGENIO.name());
        assertEquals(0.52, ca.calcCorrecaoFosforoCusto(8.59, 4, 15, 70, 5.53));

    }

    @Test
    public void testaCorrecaoFosforoYoorin() {
        assertEquals(233, ca.calculaCorrecaoFosforoQtdAplicar(8.59, 5, 15, 70));
        assertEquals("TERMOFOSFATO_YOORIN", FonteFosforo.TERMOFOSFATO_YOORIN.name());
        assertEquals(34.9, ca.calcFosforoCorrecaoAdicional1(8.59, 5, 15, 70));
        assertEquals(65.2, ca.calcFosforoCorrecaoAdicional2(8.59, 5, 15, 70));
        assertEquals("MAGNESIO",NutrientesAdicionais.MAGNESIO.name());
        assertEquals("CALCIO", NutrientesAdicionais.CALCIO.name());
        assertEquals(1.29, ca.calcCorrecaoFosforoCusto(8.59, 5, 15, 70, 5.53));

    }

    @Test
    public void testaCorrecaoFosforoFosfatoArad() {
        assertEquals(127.09, ca.calculaCorrecaoFosforoQtdAplicar(8.59, 6, 15, 70));
        assertEquals("FOSFATO_ARAD", FonteFosforo.FOSFATO_ARAD.name());
        assertEquals(66.1, ca.calcFosforoCorrecaoAdicional2(8.59, 6, 15, 70));
        assertEquals("CALCIO", NutrientesAdicionais.CALCIO.name());
        assertEquals(0.70, ca.calcCorrecaoFosforoCusto(8.59, 6, 15, 70, 5.53));
    }

    @Test
    public void testaCorrecaoReativoGafsa() {
        assertEquals(144.62, ca.calculaCorrecaoFosforoQtdAplicar(8.59, 7, 15, 70));
        assertEquals("FOSFATO_GAFSA", FonteFosforo.FOSFATO_GAFSA.name());
        assertEquals(75.2, ca.calcFosforoCorrecaoAdicional2(8.59, 7, 15, 70));
        assertEquals("CALCIO",NutrientesAdicionais.CALCIO.name());
        assertEquals(0.80, ca.calcCorrecaoFosforoCusto(8.59, 7, 15, 70, 5.53));
    }

    @Test
    public void testaCorrecaoFosforoDaoui() {
        assertEquals(131.06, ca.calculaCorrecaoFosforoQtdAplicar(8.59, 8, 15, 70));
        assertEquals("FOSFATO_DAOUI", FonteFosforo.FOSFATO_DAOUI.name());
        assertEquals(59.0, ca.calcFosforoCorrecaoAdicional2(8.59, 8, 15, 70));
        assertEquals("CALCIO", NutrientesAdicionais.CALCIO.name());
        assertEquals(0.72, ca.calcCorrecaoFosforoCusto(8.59, 8, 15, 70, 5.53));
    }

    @Test
    public void testaCorrecaoFosforoPatosdeMinas() {
        assertEquals(174.75, ca.calculaCorrecaoFosforoQtdAplicar(8.59, 9, 15, 70));
        assertEquals("FOSFATO_PATOS_DE_MINAS", FonteFosforo.FOSFATO_PATOS_DE_MINAS.name());
        assertEquals(48.9, ca.calcFosforoCorrecaoAdicional2(8.59, 9, 15, 70));
        assertEquals("CALCIO", NutrientesAdicionais.CALCIO.name());
        assertEquals(0.97, ca.calcCorrecaoFosforoCusto(8.59, 9, 15, 70, 5.53));
    }

    @Test
    public void testaCorrecaoFosforoEscoriadeThomas() {
        assertEquals(226.70, ca.calculaCorrecaoFosforoQtdAplicar(8.59, 10, 15, 70));
        assertEquals("ESCORIA_DE_THOMAS", FonteFosforo.ESCORIA_DE_THOMAS.name());
        assertEquals(99.7, ca.calcFosforoCorrecaoAdicional2(8.59, 10, 15, 70));
        assertEquals("CALCIO", NutrientesAdicionais.CALCIO.name());
        assertEquals(1.25, ca.calcCorrecaoFosforoCusto(8.59, 10, 15, 70, 5.53));
    }

    @Test
    public void testaCorrecaoFosforoAcidoFosfórico() {
        assertEquals(80.65, ca.calculaCorrecaoFosforoQtdAplicar(8.59, 11, 15, 70));
        assertEquals("ACIDO_FOSFORICO",FonteFosforo.ACIDO_FOSFORICO.name());
        assertEquals(0.45, ca.calcCorrecaoFosforoCusto(8.59, 11, 15, 70, 5.53));
    }

    @Test
    public void testaCorrecaoFosforoMultifosfatoMagnesiano() {
        assertEquals(233, ca.calculaCorrecaoFosforoQtdAplicar(8.59, 12, 15, 70));
        assertEquals("MULTIFOSFATO_MAGNESIANO", FonteFosforo.MULTIFOSFATO_MAGNESIANO.name());
        assertEquals(25.6, ca.calcFosforoCorrecaoAdicional1(8.59, 12, 15, 70));
        assertEquals(41.9, ca.calcFosforoCorrecaoAdicional2(8.59, 12, 15, 70));
        assertEquals("ENXOFRE", NutrientesAdicionais.ENXOFRE.name());
        assertEquals("CALCIO", NutrientesAdicionais.CALCIO.name());
        assertEquals(1.29, ca.calcCorrecaoFosforoCusto(8.59, 12, 15, 70, 5.53));
    }

    @Test
    public void testaCorrecaoPotassioCloreto() {
        assertEquals(450.55, ca.calculaCorrecaoPotassioQtdAplicar(0.15, 5.76, 1.63, 5.35, 1, 3));
        assertEquals("CLORETO_DE_POTASSIO", FontePotassio.CLORETO_DE_POTASSIO.name());
        assertEquals(1.2, ca.calcParticipacaoAtualCTCSoloPotassio(0.15, 5.76, 1.63, 5.35));
        assertEquals(3, ca.calcParticipacaoCTCSoloPotassioAposCorrecao(3));
        assertEquals(67.58, ca.calcCorrecaoPotassioCusto(0.15, 5.76, 1.63, 5.35, 1, 3, 150));
    }

    @Test
    public void testaCorrecaoPotassioSulfatoDePotassio() {
        assertEquals(502.53, ca.calculaCorrecaoPotassioQtdAplicar(0.15, 5.76, 1.63, 5.35, 2, 3));
        assertEquals("SULFATO_DE_POTASSIO", FontePotassio.SULFATO_DE_POTASSIO.name());
        assertEquals(1.2, ca.calcParticipacaoAtualCTCSoloPotassio(0.15, 5.76, 1.63, 5.35));
        assertEquals(3, ca.calcParticipacaoCTCSoloPotassioAposCorrecao(3));
        assertEquals(75.38, ca.calcCorrecaoPotassioCusto(0.15, 5.76, 1.63, 5.35, 2, 3, 150));
        assertEquals(85.43, ca.calcCorrecaoPotassioAdicional1(0.15, 5.76, 1.63, 5.35, 2, 3));
        assertEquals("ENXOFRE",NutrientesAdicionais.ENXOFRE.name());
    }

    @Test
    public void testaCorrecaoPotassioSulfatodePotassioEMagnesio() {
        assertEquals(1187.8, ca.calculaCorrecaoPotassioQtdAplicar(0.15, 5.76, 1.63, 5.35, 3, 3));
        assertEquals("SULFATO_DE_POTASSIO_E_MAGNESIO", FontePotassio.SULFATO_DE_POTASSIO_E_MAGNESIO.name());
        assertEquals(1.2, ca.calcParticipacaoAtualCTCSoloPotassio(0.15, 5.76, 1.63, 5.35));
        assertEquals(3, ca.calcParticipacaoCTCSoloPotassioAposCorrecao(3));
        assertEquals(178.17, ca.calcCorrecaoPotassioCusto(0.15, 5.76, 1.63, 5.35, 3, 3, 150));
        assertEquals(261.32, ca.calcCorrecaoPotassioAdicional1(0.15, 5.76, 1.63, 5.35, 3, 3));
        assertEquals("ENXOFRE", NutrientesAdicionais.ENXOFRE.name());
        assertEquals(213.8, ca.calcCorrecaoPotassioAdicional2(0.15, 5.76, 1.63, 5.35, 3, 3));
        assertEquals("MAGNESIO", NutrientesAdicionais.MAGNESIO.name());
    }

}
