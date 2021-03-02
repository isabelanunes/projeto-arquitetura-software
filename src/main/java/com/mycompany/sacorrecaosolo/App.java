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
        
        System.out.println("Digite a quantidade da participação de cálcio na CTC desejada:");
        ctc = dado.nextDouble();
        calcTeorCalcioEMagnesio(ctc);
        System.out.println("A quantidade de " + nutriente[2].getNome() + " ideal após as correções é de: " + nutriente[2]
                .getCorrigido());
        System.out.println("A quantidade de " + nutriente[3].getNome() + " ideal após as correções é de: " + nutriente[3]
                .getCorrigido());
        
        calcValoresCmol();

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
            ctcAtual = nutriente[1].getQtdSolo() / (nutriente[1].getQtdSolo() + nutriente[2].getQtdSolo()
                    + nutriente[3].getQtdSolo() + acidez) * 100;

            double valork = (nutriente[1].getQtdSolo() * ctc / ctcAtual) - nutriente[1].getQtdSolo();
            if (valork < 0.01) {
                nutriente[1].setCorrigido(nutriente[1].getQtdSolo());
            } else {
                nutriente[1].setCorrigido(nutriente[1].getQtdSolo() + valork);
            }
        }
    }

    public static void calcTeorCalcioEMagnesio(double ctc) {
        Scanner dado = new Scanner(System.in);
        int fonte = 0;
        double valorFonteCalcio = 0;
        double somaCalcio = 0;
        double somaMagnesio = 0;
        
        
  
        System.out.println("Digite qual a fonte do corretivo a utilizar para o cálcio (de 1 a 6)");
        fonte = dado.nextInt();

        switch (fonte) {
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
        
        
        
        somaCalcio = (nutriente[2].getQtdSolo()*ctc/(nutriente[2].getQtdSolo()/(nutriente[1].getQtdSolo() + nutriente[2].getQtdSolo()
                    + nutriente[3].getQtdSolo() + acidez)*100)) - nutriente[2].getQtdSolo();
        
        somaCalcio = somaCalcio/valorFonteCalcio;
        
        nutriente[2].setCorrigido(nutriente[2].getQtdSolo() + (somaCalcio*valorFonteCalcio));
        
        
        
        //Calculo do Magnesio
        switch (fonte) {
            case 1:
                somaMagnesio = 18*0.0248*somaCalcio;
                break;
            case 2:
                somaMagnesio = 5*0.0248*somaCalcio;
                break;
            case 6:
                somaMagnesio = 10*0.0248*somaCalcio;
                break;
            default:
                 somaMagnesio = 0;

            }
        
        nutriente[3].setCorrigido(nutriente[3].getQtdSolo()+somaMagnesio);
        
    }
    
    public static void calcValoresCmol(){
        double sCmol = nutriente[1].getQtdSolo()+nutriente[2].getQtdSolo()+nutriente[3].getQtdSolo();
        double ctcCmol = sCmol + acidez;
        double vAtual = 100*sCmol/ctcCmol;
        
        System.out.println("Scmol = " + sCmol+" ctcCmol: "+ctcCmol+ " vAtual = " +vAtual);
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
