
package com.mycompany.sacorrecaosolo;

public interface CalculosCorrecaoFosforo {
    public double calculaCorrecaoFosforoQtdAplicar(double qtdSoloFosforo, int fonte, double teor, double eficiencia);
    public double calcFosforoCorrecaoAdicional1(double qtdSoloFosforo, int fonte, double teor, double eficiencia);
    public double calcFosforoCorrecaoAdicional2(double qtdSoloFosforo, int fonte, double teor, double eficiencia);
    public double calcCorrecaoFosforoCusto(double qtdSoloFosforo, int fonte, double teor, double eficiencia, double valorTon);
}
