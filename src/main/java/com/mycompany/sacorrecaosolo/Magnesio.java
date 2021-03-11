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
        double somaPotassio;
        double somaMeio;
        double somaFosforo;
      
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
         
         if(App.potassio.getFontePotassio() != 3){
            somaPotassio = 0;
         }else{
             if(App.potassio.getValork() < 0.1){
                 somaMeio = 0;
             }else{
                 somaMeio = App.potassio.getValork()*39.1*10*2*1.2;
             }
             somaPotassio = (((somaMeio*100/0.85/100)*100/22)*18*0.0248/1000)*0.6;
         }
         
         if(App.fosforo.getFonteFosforo() != 5){
             somaFosforo = 0;
         }else{
             somaFosforo = (0.0248*15)*0.6;
         }
         
        
        
        setCorrigido(qtdSolo+somaMagnesio+somaPotassio+somaFosforo);
    }
    
    
}
