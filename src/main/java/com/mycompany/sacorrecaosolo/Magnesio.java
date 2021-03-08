/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sacorrecaosolo;

/**
 *
 * @author jvitorgf
 */
public class Magnesio {

    /**
     * @param args the command line arguments
     */
    private double qtdSolo;
    private final double ideal1 = 1.5;
    private final double ideal2 = 1.0;
    private double ideal;
    private double corrigido;
    
    
    
    public Magnesio(double qtdSolo, int textura) {
        this.qtdSolo = qtdSolo;
        
        switch(textura){
            case 1:
                this.ideal = ideal1;
                break;
            case 2:
                this.ideal = ideal2;
                break;
        }
    }
    
    
    
    public double getQtdSolo() {
        return qtdSolo;
    }
    
    public void setCorrigido(double corrigido) {
        this.corrigido = corrigido;
    }

    public double getIdeal() {
        return ideal;
    }

    public double getCorrigido() {
        return corrigido;
    }
    
    public void calcTeorMagnesio() {
        
        double somaMagnesio;
      
         switch (App.calcio.getFonteCalcio()) {
            case 1:
                somaMagnesio = 18*0.0248*App.calcio.getSomaCalcio();
                break;
            case 2:
                somaMagnesio = 5*0.0248*App.calcio.getSomaCalcio();
                break;
            case 6:
                somaMagnesio = 10*0.0248*App.calcio.getSomaCalcio();
                break;
            default:
                 somaMagnesio = 0;

            }
        
        
        setCorrigido(qtdSolo+somaMagnesio);
    }
    
    
}
