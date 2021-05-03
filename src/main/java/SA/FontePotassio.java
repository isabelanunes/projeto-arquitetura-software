package SA;

public enum FontePotassio implements CalculosCorrecaoPotassio {
    CLORETO_DE_POTASSIO {
        @Override
        public double calculaCorrecaoPotassioQtdAplicar(double qtdSoloPotassio, double qtdSoloCalcio, double qtdSoloMagnesio, double qtdSoloHmaisL, int fonte, double ctcDesejada) {
            double qtdAplicar = (double) Math.round(((qtdSoloPotassio * ctcDesejada / (qtdSoloPotassio / (qtdSoloPotassio + qtdSoloCalcio + qtdSoloMagnesio + qtdSoloHmaisL) * 100) - qtdSoloPotassio) * 39.1 * 10 * 2 * 1.2 * 100 / 85 * 100 / 58) * 100) / 100;
            return Math.max(0, qtdAplicar);
        }

        @Override
        public Object[] calcCorrecaoPotassioAdicional1(double qtdSoloPotassio, double qtdSoloCalcio, double qtdSoloMagnesio, double qtdSoloHmaisL, int fonte, double ctcDesejada) {
            return new Object[]{0};
        }

        @Override
        public Object[] calcCorrecaoPotassioAdicional2(double qtdSoloPotassio, double qtdSoloCalcio, double qtdSoloMagnesio, double qtdSoloHmaisL, int fonte, double ctcDesejada) {
            return new Object[]{0};
        }

        @Override
        public double calcCorrecaoPotassioCusto(double qtdSoloPotassio, double qtdSoloCalcio, double qtdSoloMagnesio, double qtdSoloHmaisL, int fonte, double ctcDesejada, double valorTon) {
            double valorFinal = (double) Math.round(valorTon * calculaCorrecaoPotassioQtdAplicar(qtdSoloPotassio, qtdSoloCalcio, qtdSoloMagnesio, qtdSoloHmaisL, fonte, ctcDesejada) / 1000 * 100) / 100;
            return Math.max(0, valorFinal);

        }

    },
    SULFATO_DE_POTASSIO {
        @Override
        public double calculaCorrecaoPotassioQtdAplicar(double qtdSoloPotassio, double qtdSoloCalcio, double qtdSoloMagnesio, double qtdSoloHmaisL, int fonte, double ctcDesejada) {
            double qtdAplicar = (double) Math.round(((qtdSoloPotassio * ctcDesejada / (qtdSoloPotassio / (qtdSoloPotassio + qtdSoloCalcio + qtdSoloMagnesio + qtdSoloHmaisL) * 100) - qtdSoloPotassio) * 39.1 * 10 * 2 * 1.2 * 100 / 85 * 100 / 52) * 100) / 100;
            return Math.max(0, qtdAplicar);
        }

        @Override
        public Object[] calcCorrecaoPotassioAdicional1(double qtdSoloPotassio, double qtdSoloCalcio, double qtdSoloMagnesio, double qtdSoloHmaisL, int fonte, double ctcDesejada) {
            double qtdAplicarSolo = (double) Math.round(calculaCorrecaoPotassioQtdAplicar(qtdSoloPotassio, qtdSoloCalcio, qtdSoloMagnesio, qtdSoloHmaisL, fonte, ctcDesejada) * 0.17 * 100) / 100;
            return new Object[]{Math.max(0, qtdAplicarSolo), NutrientesAdicionais.ENXOFRE};
        }

        @Override
        public Object[] calcCorrecaoPotassioAdicional2(double qtdSoloPotassio, double qtdSoloCalcio, double qtdSoloMagnesio, double qtdSoloHmaisL, int fonte, double ctcDesejada) {
            return new Object[]{0};
        }

        @Override
        public double calcCorrecaoPotassioCusto(double qtdSoloPotassio, double qtdSoloCalcio, double qtdSoloMagnesio, double qtdSoloHmaisL, int fonte, double ctcDesejada, double valorTon) {
            double valorFinal = (double) Math.round(calculaCorrecaoPotassioQtdAplicar(qtdSoloPotassio, qtdSoloCalcio, qtdSoloMagnesio, qtdSoloHmaisL, fonte, ctcDesejada) * valorTon / 1000 * 100) / 100;
            return Math.max(0, valorFinal);
        }
    },
    SULFATO_DE_POTASSIO_E_MAGNESIO {
        @Override
        public double calculaCorrecaoPotassioQtdAplicar(double qtdSoloPotassio, double qtdSoloCalcio, double qtdSoloMagnesio, double qtdSoloHmaisL, int fonte, double ctcDesejada) {
            double qtdAplicar = (double) Math.round(((qtdSoloPotassio * ctcDesejada / (qtdSoloPotassio / (qtdSoloPotassio + qtdSoloCalcio + qtdSoloMagnesio + qtdSoloHmaisL) * 100) - qtdSoloPotassio) * 39.1 * 10 * 2 * 1.2 * 100 / 85 * 100 / 22) * 100) / 100;
            return Math.max(0, qtdAplicar);
        }

        @Override
        public Object[] calcCorrecaoPotassioAdicional1(double qtdSoloPotassio, double qtdSoloCalcio, double qtdSoloMagnesio, double qtdSoloHmaisL, int fonte, double ctcDesejada) {
            double qtdAplicarSolo = (double) Math.round(calculaCorrecaoPotassioQtdAplicar(qtdSoloPotassio, qtdSoloCalcio, qtdSoloMagnesio, qtdSoloHmaisL, fonte, ctcDesejada) * 0.22 * 100) / 100;
            return new Object[]{Math.max(0, qtdAplicarSolo), NutrientesAdicionais.ENXOFRE};
        }

        @Override
        public Object[] calcCorrecaoPotassioAdicional2(double qtdSoloPotassio, double qtdSoloCalcio, double qtdSoloMagnesio, double qtdSoloHmaisL, int fonte, double ctcDesejada) {
            double qtdAplicarSolo = (double) Math.round(calculaCorrecaoPotassioQtdAplicar(qtdSoloPotassio, qtdSoloCalcio, qtdSoloMagnesio, qtdSoloHmaisL, fonte, ctcDesejada) * 0.18 * 100) / 100;
            return new Object[]{Math.max(0, qtdAplicarSolo), NutrientesAdicionais.MAGNESIO};
        }

        @Override
        public double calcCorrecaoPotassioCusto(double qtdSoloPotassio, double qtdSoloCalcio, double qtdSoloMagnesio, double qtdSoloHmaisL, int fonte, double ctcDesejada, double valorTon) {
            double valorFinal = (double) Math.round(calculaCorrecaoPotassioQtdAplicar(qtdSoloPotassio, qtdSoloCalcio, qtdSoloMagnesio, qtdSoloHmaisL, fonte, ctcDesejada) * valorTon / 1000 * 100) / 100;
            return Math.max(0, valorFinal);
        }
    }
}
