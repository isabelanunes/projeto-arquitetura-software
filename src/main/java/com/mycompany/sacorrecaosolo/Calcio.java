/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sacorrecaosolo;

import java.util.Scanner;

/**
 *
 * @author jvitorgf
 */
public class Calcio {

    /**
     * @param args the command line arguments
     */
    private final double ideal1 = 6;
    private final double ideal2 = 4;
    private double ideal;
    private double qtdSolo;
    private double corrigido;
    private double ctcDesejada;
    private int fonteCalcio;
    private double somaCalcio;
    
    
    public Calcio(double qtdSolo, int textura) {
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
    
    public void calcTeorCalcio() {
        Scanner dado = new Scanner(System.in);
 
        double valorFonteCalcio;
        
        
        System.out.println("Digite a quantidade da participação de cálcio na CTC desejada:");
        ctcDesejada = dado.nextDouble();
        
        System.out.println("Digite qual a fonte do corretivo a utilizar para o cálcio (de 1 a 6)");
        fonteCalcio = dado.nextInt();

        switch (fonteCalcio) {
            case 1:
                valorFonteCalcio = 30.4*0.01783;
                break;
            case 2:
                valorFonteCalcio = 56*0.01783;
                break;
            case 3:
                valorFonteCalcio = 54*0.01783;
                break;
            case 4:
                valorFonteCalcio = 29*0.01783;
                break;
            case 5:
                valorFonteCalcio = 75.7*0.01783;
                break;
            case 6:
                valorFonteCalcio = 35*0.01783;
                break;
            default:
                 System.out.println("Valor a digitar deve ser de 1 a 6. Utilizando por padrão fonte 1.");
                 valorFonteCalcio = 30.4*0.01783;

            }
        
        
        
        somaCalcio = (qtdSolo*ctcDesejada/(qtdSolo/(App.potassio.getQtdSolo() + qtdSolo
                    + App.magnesio.getQtdSolo() + App.acidez.getQtdSolo())*100)) - qtdSolo;
        
        somaCalcio = somaCalcio/valorFonteCalcio;
        
        setCorrigido(qtdSolo + (somaCalcio*valorFonteCalcio));
        
    }

    public int getFonteCalcio() {
        return fonteCalcio;
    }

    public double getSomaCalcio() {
        return somaCalcio;
    }
    
    
    
    
}
