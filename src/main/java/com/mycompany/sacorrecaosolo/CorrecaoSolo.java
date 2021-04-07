package com.mycompany.sacorrecaosolo;

public class CorrecaoSolo {

    private double[] nutrienteIdeal = new double[6];

    public double[] calcIdeal(int texturaSolo) {
        switch (texturaSolo) {
            case 1:
                nutrienteIdeal[0] = 9;
                nutrienteIdeal[1] = 0.35;
                nutrienteIdeal[2] = 6;
                nutrienteIdeal[3] = 1.5;
                nutrienteIdeal[4] = 9;
                nutrienteIdeal[5] = 0;
                return nutrienteIdeal;

            case 2:
                nutrienteIdeal[0] = 12;
                nutrienteIdeal[1] = 0.25;
                nutrienteIdeal[2] = 4;
                nutrienteIdeal[3] = 1;
                nutrienteIdeal[4] = 6;
                nutrienteIdeal[5] = 0;
                return nutrienteIdeal;
        }

        return null;
    }

    public double calculaCorrecaoFosforoQtdAplicar(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {

        double qtdAplicarAux = ((((teor - qtdSoloFosforo) * 2) * 2.29) * 100 / eficiencia) * 100;

        if (teor > qtdSoloFosforo) {

            switch (fonte) {
                case 1:
                case 5:
                case 12:
                    return (double) Math.round((qtdAplicarAux / 18) * 100) / 100;
                case 2:
                    return (double) Math.round((qtdAplicarAux / 41) * 100) / 100;
                case 3:
                    return (double) Math.round((qtdAplicarAux / 48) * 100) / 100;
                case 4:
                    return (double) Math.round((qtdAplicarAux / 45) * 100) / 100;
                case 6:
                    return (double) Math.round((qtdAplicarAux / 33) * 100) / 100;
                case 7:
                    return (double) Math.round((qtdAplicarAux / 29) * 100) / 100;
                case 8:
                    return (double) Math.round((qtdAplicarAux / 32) * 100) / 100;
                case 9:
                    return (double) Math.round((qtdAplicarAux / 24) * 100) / 100;
                case 10:
                    return (double) Math.round((qtdAplicarAux / 18.5) * 100) / 100;
                case 11:
                    return (double) Math.round((qtdAplicarAux / 52) * 100) / 100;
            }
        }

        return 0;

    }

    public String getNomeFonteFosforo(int fonte) {
        switch (fonte) {
            case 1:
                return "Superfosfato Simples";
            case 2:
                return "Superfosfato Triplo";
            case 3:
                return "MAP";
            case 4:
                return "DAP";
            case 5:
                return "Termofosfato Yoorin";
            case 6:
                return "Fosfato Arad";
            case 7:
                return "Fosfato Gafsa";
            case 8:
                return "Fosfato Daoui";
            case 9:
                return "Fosfato Patos de Minas";
            case 10:
                return "Escória de Thomas";
            case 11:
                return "Ácido Fosfórico";
            case 12:
                return "Multifosfato Magnesiano";
        }
        return null;
    }

    public double calcFosforoCorrecaoAdicional1(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {
        if (teor > qtdSoloFosforo) {
            double adicional1Aux = calculaCorrecaoFosforoQtdAplicar(qtdSoloFosforo, fonte, teor, eficiencia);
            switch (fonte) {
                case 1:
                    return (double) Math.round(adicional1Aux * 0.1 * 10) / 10;
                case 5:
                    return (double) Math.round(adicional1Aux * 0.15 * 10) / 10;
                case 12:
                    return (double) Math.round(adicional1Aux * 0.11 * 10) / 10;
            }
        }
        return 0;
    }

    public double calcFosforoCorrecaoAdicional2(double qtdSoloFosforo, int fonte, double teor, double eficiencia) {
        if (teor > qtdSoloFosforo) {

            double adicional2Aux = calculaCorrecaoFosforoQtdAplicar(qtdSoloFosforo, fonte, teor, eficiencia);

            switch (fonte) {
                case 1:
                case 5:
                    return (double) Math.round(adicional2Aux * 0.28 * 10) / 10;
                case 2:
                    return (double) Math.round(adicional2Aux * 0.2 * 10) / 10;
                case 3:
                    return (double) Math.round(adicional2Aux * 0.09 * 10) / 10;
                case 4:
                    return (double) Math.round(adicional2Aux * 0.16 * 10) / 10;
                case 6:
                case 7:
                    return (double) Math.round(adicional2Aux * 0.52 * 10) / 10;
                case 8:
                    return (double) Math.round(adicional2Aux * 0.45 * 10) / 10;
                case 9:
                    return (double) Math.round(adicional2Aux * 0.28 * 10) / 10;
                case 10:
                    return (double) Math.round(adicional2Aux * 0.44 * 10) / 10;
                case 12:
                    return (double) Math.round(adicional2Aux * 0.18 * 10) / 10;

            }

        }
        return 0;
    }

    public String getNomeFosforoCorrecaoAdicional1(int fonte) {
        switch (fonte) {
            case 1:
            case 12:
                return "Enxofre";
            case 5:
                return "Magnésio";
        }
        return null;
    }

    public String getNomeFosforoCorrecaoAdicional2(int fonte) {
        switch (fonte) {
            case 1:
            case 2:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 12:
                return "Cálcio";
            case 3:
            case 4:
                return "Nitrogênio";
        }
        return null;
    }

    public double calcCorrecaoFosforoCusto(double qtdSoloFosforo, int fonte, double teor, double eficiencia, double valorTon) {
        if (teor > qtdSoloFosforo) {
            if (fonte >= 1 && fonte <= 12) {
                return (double) Math.round(valorTon * (calculaCorrecaoFosforoQtdAplicar(qtdSoloFosforo, fonte, teor, eficiencia)) / 1000 * 100) / 100;
            }
        }
        return 0;
    }

    public double calculaCorrecaoPotassioQtdAplicar(double qtdSoloPotassio, double qtdSoloCalcio, double qtdSoloMagnesio, double qtdSoloHmaisL, int fonte, double ctcDesejada) {

        double qtdAplicarAux = (qtdSoloPotassio * ctcDesejada / (qtdSoloPotassio / (qtdSoloPotassio + qtdSoloCalcio + qtdSoloMagnesio + qtdSoloHmaisL) * 100) - qtdSoloPotassio) * 39.1 * 10 * 2 * 1.2 * 100 / 85 * 100;

        if (qtdAplicarAux > 0) {
            switch (fonte) {
                case 1:
                    return (double) Math.round((qtdAplicarAux / 58) * 100) / 100;
                case 2:
                    return (double) Math.round((qtdAplicarAux / 52) * 100) / 100;
                case 3:
                    return (double) Math.round((qtdAplicarAux / 22) * 100) / 100;
            }
        }
        return 0;

    }

    public String getNomeFontePotassio(int fonte) {
        switch (fonte) {
            case 1:
                return "Cloreto de Potássio";
            case 2:
                return "Sulfato de Potássio";
            case 3:
                return "Sulfato de Potássio e Magnésio";
        }
        return null;
    }

    public double calcCorrecaoPotassioAdicional1(double qtdSoloPotassio, double qtdSoloCalcio, double qtdSoloMagnesio, double qtdSoloHmaisL, int fonte, double ctcDesejada) {
        double qtdAplicarSolo = calculaCorrecaoPotassioQtdAplicar(qtdSoloPotassio, qtdSoloCalcio, qtdSoloMagnesio, qtdSoloHmaisL, fonte, ctcDesejada);

        if (qtdAplicarSolo > 0) {
            switch (fonte) {
                case 2:
                    return (double) Math.round(qtdAplicarSolo * 0.17 * 100) / 100;
                case 3:
                    return (double) Math.round(qtdAplicarSolo * 0.22 * 100) / 100;
            }
        }

        return 0;
    }

    public double calcCorrecaoPotassioAdicional2(double qtdSoloPotassio, double qtdSoloCalcio, double qtdSoloMagnesio, double qtdSoloHmaisL, int fonte, double ctcDesejada) {
        double qtdAplicarSolo = calculaCorrecaoPotassioQtdAplicar(qtdSoloPotassio, qtdSoloCalcio, qtdSoloMagnesio, qtdSoloHmaisL, fonte, ctcDesejada);

        if (qtdAplicarSolo > 0) {
            if (fonte == 3) {
                return (double) Math.round(qtdAplicarSolo * 0.18 * 100) / 100;
            }
        }

        return 0;
    }

    public String getNomePotassioCorrecaoAdicional1(int fonte) {
        if (fonte > 1 && fonte <= 3) {
            return "Enxofre";
        }
        return null;
    }

    public String getNomePotassioCorrecaoAdicional2(int fonte) {
        if (fonte == 3) {
            return "Magnésio";
        }
        return null;
    }

    public double calcCorrecaoPotassioCusto(double qtdSoloPotassio, double qtdSoloCalcio, double qtdSoloMagnesio, double qtdSoloHmaisL, int fonte, double ctcDesejada, double valorTon) {
        double qtdAplicarSolo = calculaCorrecaoPotassioQtdAplicar(qtdSoloPotassio, qtdSoloCalcio, qtdSoloMagnesio, qtdSoloHmaisL, fonte, ctcDesejada);

        if (qtdAplicarSolo > 0) {
            if (fonte >= 1 && fonte <= 3) {
                return (double) Math.round(valorTon * qtdAplicarSolo / 1000 * 100) / 100;
            }
        }
        return 0;
    }

    public double calcParticipacaoAtualCTCSoloPotassio(double qtdSoloPotassio, double qtdSoloCalcio, double qtdSoloMagnesio, double qtdSoloHmaisL) {

        double potassioAtualCTCSolo = qtdSoloPotassio / (qtdSoloPotassio + qtdSoloCalcio + qtdSoloMagnesio + qtdSoloHmaisL) * 100;

        if (potassioAtualCTCSolo > 0) {
            return (double) Math.round(potassioAtualCTCSolo * 10) / 10;
        }
        return 0;
    }

    public double calcParticipacaoCTCSoloPotassioAposCorrecao(double ctcDesejada) {
        if (ctcDesejada > 0.001) {
            return (double) Math.round(ctcDesejada * 10) / 10;
        }
        return 0;
    }
}
