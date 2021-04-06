
package com.mycompany.sacorrecaosolo;

public class CorrecaoSolo {
    
    private double[] nutrienteIdeal = new double [6];
    
    public double[] calcIdeal(int texturaSolo) {
        switch(texturaSolo){
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
    
    public double correcaoFosforo(double qtdSoloFosforo,int fonte,double teor, double eficiencia){
        
        double qtdAplicarAux = ((((teor - qtdSoloFosforo)*2)*2.29)*100/eficiencia)*100;
        
        if(teor>qtdSoloFosforo){
              
        switch(fonte){
            case 1:
            case 5:
            case 12:
                return (double) Math.round((qtdAplicarAux/18)*100)/100;
            case 2:
                return (double) Math.round((qtdAplicarAux/41)*100)/100;
            case 3:
                return (double) Math.round((qtdAplicarAux/48)*100)/100;
            case 4:
                return (double) Math.round((qtdAplicarAux/45)*100)/100;
            case 6:
                return (double) Math.round((qtdAplicarAux/33)*100)/100;
            case 7:
                return (double) Math.round((qtdAplicarAux/29)*100)/100;
            case 8:
                return (double) Math.round((qtdAplicarAux/32)*100)/100;
            case 9:
                return (double) Math.round((qtdAplicarAux/24)*100)/100;
            case 10:
                return (double) Math.round((qtdAplicarAux/18.5)*100)/100;
            case 11:
                return (double) Math.round((qtdAplicarAux/52)*100)/100;
             }
        }
        
        return 0;

    }
    public double correcaoPotassio(double qtdSoloPotassio,double qtdSoloCalcio ,double qtdSoloMagnesio,double qtdSoloHmaisL,int fonte,double ctcDesejada){
        
        double qtdAplicarAux = (qtdSoloPotassio*ctcDesejada/( qtdSoloPotassio/(qtdSoloPotassio+qtdSoloCalcio+qtdSoloMagnesio+qtdSoloHmaisL)*100)-qtdSoloPotassio)*39.1*10*2*1.2*100/85*100;
        
        switch(fonte){
            case 1:
                return (double) Math.round((qtdAplicarAux/58)*100)/100;
            case 2:
                return (double) Math.round((qtdAplicarAux/52)*100)/100;
            case 3:
                return (double) Math.round((qtdAplicarAux/22)*100)/100;
        }
        
        return 0;

    }
}
