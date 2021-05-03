package SA;

public class CorrecaoSolo {

    private double[] nutrienteIdeal = new double[7];

    public double[] calcIdeal(int texturaSolo) {
        switch (texturaSolo) {
            case 1:
                nutrienteIdeal[0] = 9;
                nutrienteIdeal[1] = 0.35;
                nutrienteIdeal[2] = 6;
                nutrienteIdeal[3] = 1.5;
                nutrienteIdeal[4] = 9;
                nutrienteIdeal[5] = 0;
                nutrienteIdeal[6] = 0;
                return nutrienteIdeal;

            case 2:
                nutrienteIdeal[0] = 12;
                nutrienteIdeal[1] = 0.25;
                nutrienteIdeal[2] = 4;
                nutrienteIdeal[3] = 1;
                nutrienteIdeal[4] = 6;
                nutrienteIdeal[5] = 0;
                nutrienteIdeal[6] = 0;
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
    
     //foi necessário implementar os métodos getSCmol, getCTCCmol, getVPercentual
    //getMOPercentual e getCarbono
    
    public double getSCmol(double potassio, double calcio, double magnesio) {
        return (potassio + calcio + magnesio);
    }

    public double getCTCCmol(double potassio, double calcio, double magnesio, double acidez) {
        return (potassio + calcio + magnesio + acidez);
    }
    
    public double getVPercentual (double potassio, double calcio, double magnesio, double acidez) {
        if (this.getCTCCmol(potassio, calcio, magnesio, acidez) > 0 && this.getSCmol(potassio, calcio, magnesio) > 0){
            return (this.getSCmol(potassio, calcio, magnesio) / this.getCTCCmol(potassio, calcio, magnesio, acidez) * 100);
        } else {
            return 0.0;
        }     
    }

    public double getMOPercentual(double mo) {
        if (mo > 0) {
            return mo/10;
        } else {
            return 0.0;
        }
    }

    public double getCarbono(double moPercentual) {
        if (moPercentual > 0){
            return moPercentual/1.72*10;
        } else {
            return 0.0;
        }
    }
    
    public double participacaoPotassioPercentualIdeal(){
        return 3.0;
    }
    
}
