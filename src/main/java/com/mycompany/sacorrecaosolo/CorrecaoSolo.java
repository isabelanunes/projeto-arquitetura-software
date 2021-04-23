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

    public double calcParticipacaoAtualCTCSoloPotassio(double qtdSoloPotassio, double qtdSoloCalcio, double qtdSoloMagnesio, double qtdSoloHmaisL) {

        double potassioAtualCTCSolo = (double) Math.round(qtdSoloPotassio / (qtdSoloPotassio + qtdSoloCalcio + qtdSoloMagnesio + qtdSoloHmaisL) * 100 * 10) / 10;
        return Math.max(0, potassioAtualCTCSolo);
    }

    public double calcParticipacaoCTCSoloPotassioAposCorrecao(double ctcDesejada) {
        return Math.max(0.001, (double) Math.round(ctcDesejada * 10) / 10);
    }
}
