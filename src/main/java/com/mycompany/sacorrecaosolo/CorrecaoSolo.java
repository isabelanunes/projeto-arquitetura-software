
package com.mycompany.sacorrecaosolo;

public class CorrecaoSolo {
    
    private double[] nutriente = new double [6];
    
    public double[] calcIdeal(int texturaSolo) {
        switch(texturaSolo){
            case 1:
                nutriente[0] = 9;
                nutriente[1] = 0.35;
                nutriente[2] = 6;
                nutriente[3] = 1.5;
                nutriente[4] = 9;
                nutriente[5] = 0;
                return nutriente;
     
            case 2:
                nutriente[0] = 12;
                nutriente[1] = 0.25;
                nutriente[2] = 4;
                nutriente[3] = 1;
                nutriente[4] = 6;
                nutriente[5] = 0;                  
                return nutriente;
        }
        
        return nutriente;
    }
}
