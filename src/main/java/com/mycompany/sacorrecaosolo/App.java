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

    public static void main(String args[]) {
        nutriente[0] = new Nutriente("Fósforo", 10.23);
        nutriente[1] = new Nutriente("Potássio", 0.82);
        nutriente[2] = new Nutriente("Cálcio", 12.45);
        nutriente[3] = new Nutriente("Magnésio", 3.47);
        nutriente[4] = new Nutriente("Enxofre", 1.10);
        nutriente[5] = new Nutriente("Alumínio", 0);
        Scanner dado = new Scanner(System.in);

        System.out.println("Digite a textura do solo:");
        texturaSolo = dado.nextInt();
        App.calcIdeal(texturaSolo);
        if (texturaSolo == 1 || texturaSolo == 2) {
            for (int i = 0; i < 6; i++) {
                System.out.println("A quantidadade ideal de " + nutriente[i].getNome() + " é de: " + nutriente[i].getIdeal());
            }
        }

    }

    public float teorFosforo(float teor) {
        if (teor == 0) {
            return 0;
        } else {
            return teor;
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
