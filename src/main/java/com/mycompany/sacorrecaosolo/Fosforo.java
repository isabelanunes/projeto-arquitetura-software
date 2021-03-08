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

    public Fosforo(double qtdSolo, int textura) {
        this.qtdSolo = qtdSolo;
        
        switch(textura){
            case 1:
                this.ideal = 9.0;
                break;
            case 2:
                this.ideal = 12.0;
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
    
    
    
}
