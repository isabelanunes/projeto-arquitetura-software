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
    
    static Nutriente fosforo = new Nutriente("Fósforo",10.23);
    static private int texturaSolo = 0;
    
    public static void main(String args[]) {
    Scanner dado = new Scanner(System.in); 
    
    System.out.println("Digite a textura do solo:");
    texturaSolo = dado.nextInt();  
    App.calcIdeal(texturaSolo);
    if(texturaSolo == 1 || texturaSolo == 2){
        System.out.println("A quantidadade ideal de fósforo é de: "+fosforo.getIdeal());
    }
       
    }
    
    public float teorFosforo(float teor){
        if(teor == 0){
            return 0;
        } else{
            return teor;
        }
    }
    
    public static void calcIdeal (float texturaSolo){
        if(texturaSolo == 1){
            fosforo.setIdeal(9);
        } else if(texturaSolo == 2){
            fosforo.setIdeal(12);
        }else{
            System.out.println("A textura do solo deve ser 1 ou 2.");
        }
    }
}
