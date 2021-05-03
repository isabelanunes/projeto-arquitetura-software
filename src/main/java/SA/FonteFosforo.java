package SA;

public enum FonteFosforo implements CalculosCorrecaoFosforo {
    SUPERFOSFATO_SIMPLES {
        @Override
        public double calculaCorrecaoFosforoQtdAplicar(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {
            double qtdAplicar = (double) Math.round((((((teor - qtdSoloFosforo) * 2) * 2.29) * 100 / eficiencia) * 100 / 18) * 100) / 100;
            return Math.max(0, qtdAplicar);
        }

        @Override
        public Object[] calcFosforoCorrecaoAdicional1(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {
            double adicional1 = (double) Math.round(calculaCorrecaoFosforoQtdAplicar(qtdSoloFosforo, fonte, teor, eficiencia) * 0.1 * 10) / 10;
            return new Object[] {Math.max(0, adicional1), NutrientesAdicionais.ENXOFRE};
        }

        @Override
        public Object[] calcFosforoCorrecaoAdicional2(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {
            double adicional2 = (double) Math.round(calculaCorrecaoFosforoQtdAplicar(qtdSoloFosforo, fonte, teor, eficiencia) * 0.28 * 10) / 10;
            return new Object[] {Math.max(0, adicional2), NutrientesAdicionais.CALCIO};
        }

        @Override
        public double calcCorrecaoFosforoCusto(double qtdSoloFosforo, int fonte, double teor, double eficiencia, double valorTon) {
            double custo = (double) Math.round(valorTon * (calculaCorrecaoFosforoQtdAplicar(qtdSoloFosforo, fonte, teor, eficiencia)) / 1000 * 100) / 100;
            return Math.max(0, custo);
        }

    },
    SUPERFOSFATO_TRIPLO {
        @Override
        public double calculaCorrecaoFosforoQtdAplicar(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {
            double qtdAplicar = (double) Math.round((((((teor - qtdSoloFosforo) * 2) * 2.29) * 100 / eficiencia) * 100 / 41) * 100) / 100;
            return Math.max(0, qtdAplicar);
        }

        @Override
        public Object[] calcFosforoCorrecaoAdicional1(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {

            return new Object[]{0};
        }

        @Override
        public Object[] calcFosforoCorrecaoAdicional2(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {
            double adicional2 = (double) Math.round(calculaCorrecaoFosforoQtdAplicar(qtdSoloFosforo, fonte, teor, eficiencia) * 0.2 * 10) / 10;
            return new Object[] {Math.max(0, adicional2), NutrientesAdicionais.CALCIO};

        }

        @Override
        public double calcCorrecaoFosforoCusto(double qtdSoloFosforo, int fonte, double teor, double eficiencia, double valorTon) {
            double custo = (double) Math.round(valorTon * (calculaCorrecaoFosforoQtdAplicar(qtdSoloFosforo, fonte, teor, eficiencia)) / 1000 * 100) / 100;
            return Math.max(0, custo);
        }
    },
    MAP {
        @Override
        public double calculaCorrecaoFosforoQtdAplicar(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {
            double qtdAplicar = (double) Math.round((((((teor - qtdSoloFosforo) * 2) * 2.29) * 100 / eficiencia) * 100 / 48) * 100) / 100;
            return Math.max(0, qtdAplicar);
        }

        @Override
        public Object[] calcFosforoCorrecaoAdicional1(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {

            return new Object[]{0};
        }

        @Override
        public Object[] calcFosforoCorrecaoAdicional2(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {
            double adicional2 = (double) Math.round(calculaCorrecaoFosforoQtdAplicar(qtdSoloFosforo, fonte, teor, eficiencia) * 0.09 * 10) / 10;
            return new Object[] {Math.max(0, adicional2), NutrientesAdicionais.NITROGENIO};

        }

        @Override
        public double calcCorrecaoFosforoCusto(double qtdSoloFosforo, int fonte, double teor, double eficiencia, double valorTon) {
            double custo = (double) Math.round(valorTon * (calculaCorrecaoFosforoQtdAplicar(qtdSoloFosforo, fonte, teor, eficiencia)) / 1000 * 100) / 100;
            return Math.max(0, custo);
        }
    },
    DAP {
        @Override
        public double calculaCorrecaoFosforoQtdAplicar(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {
            double qtdAplicar = (double) Math.round((((((teor - qtdSoloFosforo) * 2) * 2.29) * 100 / eficiencia) * 100 / 45) * 100) / 100;
            return Math.max(0, qtdAplicar);

        }

        @Override
        public Object[] calcFosforoCorrecaoAdicional1(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {

            return new Object[]{0};
        }

        @Override
        public Object[] calcFosforoCorrecaoAdicional2(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {
            double adicional2 = (double) Math.round(calculaCorrecaoFosforoQtdAplicar(qtdSoloFosforo, fonte, teor, eficiencia) * 0.16 * 10) / 10;
            return new Object[] {Math.max(0, adicional2), NutrientesAdicionais.NITROGENIO};

        }

        @Override
        public double calcCorrecaoFosforoCusto(double qtdSoloFosforo, int fonte, double teor, double eficiencia, double valorTon) {
            double custo = (double) Math.round(valorTon * (calculaCorrecaoFosforoQtdAplicar(qtdSoloFosforo, fonte, teor, eficiencia)) / 1000 * 100) / 100;
            return Math.max(0, custo);
        }
    },
    TERMOFOSFATO_YOORIN {
        @Override
        public double calculaCorrecaoFosforoQtdAplicar(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {
            double qtdAplicar = (double) Math.round((((((teor - qtdSoloFosforo) * 2) * 2.29) * 100 / eficiencia) * 100 / 18) * 100) / 100;
            return Math.max(0, qtdAplicar);
        }

        @Override
        public Object[] calcFosforoCorrecaoAdicional1(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {
            double adicional1 = (double) Math.round(calculaCorrecaoFosforoQtdAplicar(qtdSoloFosforo, fonte, teor, eficiencia) * 0.15 * 10) / 10;
            return new Object[] {Math.max(0, adicional1), NutrientesAdicionais.MAGNESIO};

        }

        @Override
        public Object[] calcFosforoCorrecaoAdicional2(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {
            double adicional2 = (double) Math.round(calculaCorrecaoFosforoQtdAplicar(qtdSoloFosforo, fonte, teor, eficiencia) * 0.28 * 10) / 10;
            return new Object[] {Math.max(0, adicional2), NutrientesAdicionais.CALCIO};

        }

        @Override
        public double calcCorrecaoFosforoCusto(double qtdSoloFosforo, int fonte, double teor, double eficiencia, double valorTon) {
            double custo = (double) Math.round(valorTon * (calculaCorrecaoFosforoQtdAplicar(qtdSoloFosforo, fonte, teor, eficiencia)) / 1000 * 100) / 100;
            return Math.max(0, custo);
        }
    },
    FOSFATO_ARAD {
        @Override
        public double calculaCorrecaoFosforoQtdAplicar(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {
            double qtdAplicar = (double) Math.round((((((teor - qtdSoloFosforo) * 2) * 2.29) * 100 / eficiencia) * 100 / 33) * 100) / 100;
            return Math.max(0, qtdAplicar);
        }

        @Override
        public Object[] calcFosforoCorrecaoAdicional1(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {

            return new Object[]{0};
        }

        @Override
        public Object[] calcFosforoCorrecaoAdicional2(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {
            double adicional2 = (double) Math.round(calculaCorrecaoFosforoQtdAplicar(qtdSoloFosforo, fonte, teor, eficiencia) * 0.52 * 10) / 10;
            return new Object[] {Math.max(0, adicional2), NutrientesAdicionais.CALCIO};

        }

        @Override
        public double calcCorrecaoFosforoCusto(double qtdSoloFosforo, int fonte, double teor, double eficiencia, double valorTon) {
            double custo = (double) Math.round(valorTon * (calculaCorrecaoFosforoQtdAplicar(qtdSoloFosforo, fonte, teor, eficiencia)) / 1000 * 100) / 100;
            return Math.max(0, custo);
        }
    },
    FOSFATO_GAFSA {
        @Override
        public double calculaCorrecaoFosforoQtdAplicar(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {
            double qtdAplicar = (double) Math.round((((((teor - qtdSoloFosforo) * 2) * 2.29) * 100 / eficiencia) * 100 / 29) * 100) / 100;
            return Math.max(0, qtdAplicar);
        }

        @Override
        public Object[] calcFosforoCorrecaoAdicional1(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {

            return new Object[]{0};
        }

        @Override
        public Object[] calcFosforoCorrecaoAdicional2(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {
            double adicional2 = (double) Math.round(calculaCorrecaoFosforoQtdAplicar(qtdSoloFosforo, fonte, teor, eficiencia) * 0.52 * 10) / 10;
            return new Object[] {Math.max(0, adicional2), NutrientesAdicionais.CALCIO};

        }

        @Override
        public double calcCorrecaoFosforoCusto(double qtdSoloFosforo, int fonte, double teor, double eficiencia, double valorTon) {
            double custo = (double) Math.round(valorTon * (calculaCorrecaoFosforoQtdAplicar(qtdSoloFosforo, fonte, teor, eficiencia)) / 1000 * 100) / 100;
            return Math.max(0, custo);
        }
    },
    FOSFATO_DAOUI {
        @Override
        public double calculaCorrecaoFosforoQtdAplicar(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {
            double qtdAplicar = (double) Math.round((((((teor - qtdSoloFosforo) * 2) * 2.29) * 100 / eficiencia) * 100 / 32) * 100) / 100;
            return Math.max(0, qtdAplicar);
        }

        @Override
        public Object[] calcFosforoCorrecaoAdicional1(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {

            return new Object[]{0};
        }

        @Override
        public Object[] calcFosforoCorrecaoAdicional2(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {
            double adicional2 = (double) Math.round(calculaCorrecaoFosforoQtdAplicar(qtdSoloFosforo, fonte, teor, eficiencia) * 0.45 * 10) / 10;
            return new Object[] {Math.max(0, adicional2), NutrientesAdicionais.CALCIO};
        }

        @Override
        public double calcCorrecaoFosforoCusto(double qtdSoloFosforo, int fonte, double teor, double eficiencia, double valorTon) {
            double custo = (double) Math.round(valorTon * (calculaCorrecaoFosforoQtdAplicar(qtdSoloFosforo, fonte, teor, eficiencia)) / 1000 * 100) / 100;
            return Math.max(0, custo);
        }
    },
    FOSFATO_PATOS_DE_MINAS {
        @Override
        public double calculaCorrecaoFosforoQtdAplicar(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {
            double qtdAplicar = (double) Math.round((((((teor - qtdSoloFosforo) * 2) * 2.29) * 100 / eficiencia) * 100 / 24) * 100) / 100;
            return Math.max(0, qtdAplicar);
        }

        @Override
        public Object[] calcFosforoCorrecaoAdicional1(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {

            return new Object[]{0};
        }

        @Override
        public Object[] calcFosforoCorrecaoAdicional2(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {
            double adicional2 = (double) Math.round(calculaCorrecaoFosforoQtdAplicar(qtdSoloFosforo, fonte, teor, eficiencia) * 0.28 * 10) / 10;
            return new Object[] {Math.max(0, adicional2), NutrientesAdicionais.CALCIO};
        }

        @Override
        public double calcCorrecaoFosforoCusto(double qtdSoloFosforo, int fonte, double teor, double eficiencia, double valorTon) {
            double custo = (double) Math.round(valorTon * (calculaCorrecaoFosforoQtdAplicar(qtdSoloFosforo, fonte, teor, eficiencia)) / 1000 * 100) / 100;
            return Math.max(0, custo);
        }
    },
    ESCORIA_DE_THOMAS {
        @Override
        public double calculaCorrecaoFosforoQtdAplicar(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {
            double qtdAplicar = (double) Math.round((((((teor - qtdSoloFosforo) * 2) * 2.29) * 100 / eficiencia) * 100 / 18.5) * 100) / 100;
            return Math.max(0, qtdAplicar);
        }

        @Override
        public Object[] calcFosforoCorrecaoAdicional1(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {

            return new Object[]{0};
        }

        @Override
        public Object[] calcFosforoCorrecaoAdicional2(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {
            double adicional2 = (double) Math.round(calculaCorrecaoFosforoQtdAplicar(qtdSoloFosforo, fonte, teor, eficiencia) * 0.44 * 10) / 10;
            return new Object[] {Math.max(0, adicional2), NutrientesAdicionais.CALCIO};
        }

        @Override
        public double calcCorrecaoFosforoCusto(double qtdSoloFosforo, int fonte, double teor, double eficiencia, double valorTon) {
            double custo = (double) Math.round(valorTon * (calculaCorrecaoFosforoQtdAplicar(qtdSoloFosforo, fonte, teor, eficiencia)) / 1000 * 100) / 100;
            return Math.max(0, custo);
        }

    },
    ACIDO_FOSFORICO {
        @Override
        public double calculaCorrecaoFosforoQtdAplicar(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {
            double qtdAplicar = (double) Math.round((((((teor - qtdSoloFosforo) * 2) * 2.29) * 100 / eficiencia) * 100 / 52) * 100) / 100;
            return Math.max(0, qtdAplicar);
        }

        @Override
        public Object[] calcFosforoCorrecaoAdicional1(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {

            return new Object[]{0};
        }

        @Override
        public Object[] calcFosforoCorrecaoAdicional2(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {

           return new Object[]{0};
        }

        @Override
        public double calcCorrecaoFosforoCusto(double qtdSoloFosforo, int fonte, double teor, double eficiencia, double valorTon) {
            double custo = (double) Math.round(valorTon * (calculaCorrecaoFosforoQtdAplicar(qtdSoloFosforo, fonte, teor, eficiencia)) / 1000 * 100) / 100;
            return Math.max(0, custo);
        }
    },
    MULTIFOSFATO_MAGNESIANO {
        @Override
        public double calculaCorrecaoFosforoQtdAplicar(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {
            double qtdAplicar = (double) Math.round((((((teor - qtdSoloFosforo) * 2) * 2.29) * 100 / eficiencia) * 100 / 18) * 100) / 100;
            return Math.max(0, qtdAplicar);
        }

        @Override
        public Object[] calcFosforoCorrecaoAdicional1(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {
            double adicional1 = (double) Math.round(calculaCorrecaoFosforoQtdAplicar(qtdSoloFosforo, fonte, teor, eficiencia) * 0.11 * 10) / 10;
            return new Object[] {Math.max(0, adicional1), NutrientesAdicionais.ENXOFRE};
        }

        @Override
        public Object[] calcFosforoCorrecaoAdicional2(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {
            double adicional2 = (double) Math.round(calculaCorrecaoFosforoQtdAplicar(qtdSoloFosforo, fonte, teor, eficiencia) * 0.18 * 10) / 10;
            return new Object[] {Math.max(0, adicional2), NutrientesAdicionais.CALCIO};
        }

        @Override
        public double calcCorrecaoFosforoCusto(double qtdSoloFosforo, int fonte, double teor, double eficiencia, double valorTon) {
            double custo = (double) Math.round(valorTon * (calculaCorrecaoFosforoQtdAplicar(qtdSoloFosforo, fonte, teor, eficiencia)) / 1000 * 100) / 100;
            return Math.max(0, custo);
        }
    }
}
