package SA;

public interface CalculosCorrecaoFosforo {

    public double calculaCorrecaoFosforoQtdAplicar(double qtdSoloFosforo, int fonte, double teor, double eficiencia);

    public Object[] calcFosforoCorrecaoAdicional1(double qtdSoloFosforo, int fonte, double teor, double eficiencia);

    public Object[] calcFosforoCorrecaoAdicional2(double qtdSoloFosforo, int fonte, double teor, double eficiencia);

    public double calcCorrecaoFosforoCusto(double qtdSoloFosforo, int fonte, double teor, double eficiencia, double valorTon);
}
