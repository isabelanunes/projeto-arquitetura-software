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
public class Fosforo {

    /**
     * @param args the command line arguments
     */
    
    private final double ideal1 = 9.0;
    private final double ideal2 = 12.0;
    private double ideal;
    private double qtdSolo;
    private double corrigido;
    private double teorFosforo;
    private int fonteFosforo;

    public Fosforo(double qtdSolo, int textura) {
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
    
    
    public void calcTeorFosforo() {
        Scanner dado = new Scanner(System.in);
        
        System.out.println("Digite a quantidade de teor de fósforo a atingir: ");
        teorFosforo = dado.nextDouble();

        if (teorFosforo < 0.01) {
            System.out.println("Não há valor de correção para o fósforo.");
        } else {
            setCorrigido(teorFosforo);
        }
        
        System.out.println("Digite a qual a fonte de fósforo a utilizar (de 1 a 12): ");
        fonteFosforo = dado.nextInt();
        switch (fonteFosforo){
           case 1:
               break;
           case 2:
               break;
           case 3:
               break;
           case 4:
               break;
           case 5:
               break;
           case 6:
               break;
           case 7:
               break;
           case 8:
               break;
           case 9:
               break;
           case 10:
               break;
           case 11:
               break;
           case 12:
               break;
           default:
           System.out.println("A fonte de fósforo deve ser de 1 a 12. Valor a ser "
                   + "utilizado = 1");
           fonteFosforo = 1;
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

    public int getFonteFosforo() {
        return fonteFosforo;
    }

   
    
    
    
}
