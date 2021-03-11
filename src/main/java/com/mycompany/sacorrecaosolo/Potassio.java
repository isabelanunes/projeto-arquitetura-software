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
public class Potassio {

    /**
     * @param args the command line arguments
     */
    
    private final double ideal1 = 0.35;
    private final double ideal2 = 0.25;
    private double ideal;
    private double qtdSolo;
    private double corrigido;
    private double ctcAtual;
    private double ctcDesejada;
    private double valork;
    private int fontePotassio;
    
    public Potassio(double qtdSolo, int textura) {
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
    
    public void calcTeorPotassio() {
        
        Scanner dado = new Scanner(System.in);
        
        System.out.println("Digite a quantidade da participação de potássio na CTC desejada:");
        ctcDesejada = dado.nextDouble();
        
        
        if (qtdSolo > 0.5) {
            setCorrigido(qtdSolo);
        } else {
            ctcAtual = qtdSolo / (qtdSolo + App.calcio.getQtdSolo()
                    + App.magnesio.getQtdSolo() + App.acidez.getQtdSolo()) * 100;

            valork = (qtdSolo * ctcDesejada / ctcAtual) - qtdSolo;
            if (valork < 0.01) {
                setCorrigido(qtdSolo);
            } else {
                setCorrigido(qtdSolo + valork);
            }
        }
        
       System.out.println("Digite qual a fonte de potássio a utilizar: ");
       fontePotassio = dado.nextInt();
       switch (fontePotassio){
           case 1:
               break;
           case 2:
               break;
           case 3:
               break;
           default:
           System.out.println("A fonte de potássio deve ser de 1 a 3. Valor a ser "
                   + "utilizado = 1");
           fontePotassio = 1;
       }
       
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

    public double getQtdSolo() {
        return qtdSolo;
    }

    public double getValork() {
        return valork;
    }

    public int getFontePotassio() {
        return fontePotassio;
    }
    
    
    
    
    
    
}
