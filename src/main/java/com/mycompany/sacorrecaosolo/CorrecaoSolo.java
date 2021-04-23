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
