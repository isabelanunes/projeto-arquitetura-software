package SA;

public interface CalculosCorrecaoPotassio {

    public double calculaCorrecaoPotassioQtdAplicar(double qtdSoloPotassio, double qtdSoloCalcio, double qtdSoloMagnesio, double qtdSoloHmaisL, int fonte, double ctcDesejada);

    public Object[] calcCorrecaoPotassioAdicional1(double qtdSoloPotassio, double qtdSoloCalcio, double qtdSoloMagnesio, double qtdSoloHmaisL, int fonte, double ctcDesejada);

    public Object[] calcCorrecaoPotassioAdicional2(double qtdSoloPotassio, double qtdSoloCalcio, double qtdSoloMagnesio, double qtdSoloHmaisL, int fonte, double ctcDesejada);

    public double calcCorrecaoPotassioCusto(double qtdSoloPotassio, double qtdSoloCalcio, double qtdSoloMagnesio, double qtdSoloHmaisL, int fonte, double ctcDesejada, double valorTon);

}
