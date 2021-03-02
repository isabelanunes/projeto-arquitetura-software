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
public class App {

    /**
     * @param args the command line arguments
     */
    static Nutriente[] nutriente = new Nutriente[6];

    static private int texturaSolo = 0;
    static private double teorFosforo = 0;
    static private double ctc = 0;
    static private double ctcAtual = 0;
    static private double acidez = 0;

    public static void main(String args[]) {
        nutriente[0] = new Nutriente("Fósforo", 10.23);
        nutriente[1] = new Nutriente("Potássio", 0.15);
        nutriente[2] = new Nutriente("Cálcio", 5.76);
        nutriente[3] = new Nutriente("Magnésio", 1.63);
        nutriente[4] = new Nutriente("Enxofre", 1.10);
        nutriente[5] = new Nutriente("Alumínio", 0);
        acidez = 5.35;
        
        Scanner dado = new Scanner(System.in);

        System.out.println("Digite a textura do solo:");
        texturaSolo = dado.nextInt();
        App.calcIdeal(texturaSolo);
        if (texturaSolo == 1 || texturaSolo == 2) {
            for (int i = 0; i < 6; i++) {
                System.out.println("A quantidadade ideal de " + nutriente[i].getNome() + " é de: " + nutriente[i].getIdeal());
            }
        }
        System.out.println("Digite a quantidade de teor de fósforo a atingir:");
        teorFosforo = dado.nextDouble();
        App.calcTeorFosforo(teorFosforo);
        if (teorFosforo > 0.01) {
            System.out.println("A quantidade de " + nutriente[0].getNome() + " ideal após as correções é de: " + nutriente[0]
                    .getCorrigido());
        }
        System.out.println("Digite a quantidade da participação de potássio na CTC desejada:");
        ctc = dado.nextDouble();
        calcTeorPotassio(ctc);
        System.out.println("A quantidade de " + nutriente[1].getNome() + " ideal após as correções é de: " + nutriente[1]
                .getCorrigido());

    }

    public static void calcTeorFosforo(double teor) {
        if (teor < 0.01) {
            System.out.println("Não há valor de correção para o fósforo.");
        } else {
            nutriente[0].setCorrigido(teor);
        }
    }

    public static void calcTeorPotassio(double ctc) {
        if (nutriente[1].getQtdSolo() > 0.5) {
            nutriente[1].setCorrigido(nutriente[1].getQtdSolo());
        } else {
            ctcAtual = nutriente[1].getQtdSolo()/(nutriente[1].getQtdSolo()+nutriente[2].getQtdSolo()
                    +nutriente[3].getQtdSolo() + acidez)*100;
            
            double valork = (nutriente[1].getQtdSolo() * ctc / ctcAtual) - nutriente[1].getQtdSolo();
            if (valork < 0.01) {
                nutriente[1].setCorrigido(nutriente[1].getQtdSolo());
            } else {
                nutriente[1].setCorrigido(nutriente[1].getQtdSolo() + valork);
            }
        }
    }

    public static void calcIdeal(int texturaSolo) {
        if (texturaSolo == 1) {
            nutriente[0].setIdeal(9);
            nutriente[1].setIdeal(0.35);
            nutriente[2].setIdeal(6);
            nutriente[3].setIdeal(1.5);
            nutriente[4].setIdeal(9);
            nutriente[5].setIdeal(0);
        } else if (texturaSolo == 2) {
            nutriente[0].setIdeal(12);
            nutriente[1].setIdeal(0.25);
            nutriente[2].setIdeal(4.0);
            nutriente[3].setIdeal(1.0);
            nutriente[4].setIdeal(6.0);
            nutriente[5].setIdeal(0.0);
        } else {
            System.out.println("A textura do solo deve ser 1 ou 2.");
        }
    }
}
