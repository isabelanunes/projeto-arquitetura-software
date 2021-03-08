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
public class App {

    /**
     * @param args the command line arguments
     */
    static final private int TEXTURA_SOLO = 1;
    
    //(Quantidade no solo, textura do solo)
    
    static Fosforo fosforo = new Fosforo(8.59,TEXTURA_SOLO);
    static Potassio potassio = new Potassio(0.15,TEXTURA_SOLO);
    static Calcio calcio = new Calcio(5.76,TEXTURA_SOLO);
    static Magnesio magnesio = new Magnesio(1.63,TEXTURA_SOLO);
    static Enxofre enxofre = new Enxofre(1.63,TEXTURA_SOLO);
    static Aluminio aluminio = new Aluminio(1.63);
    static Acidez acidez = new Acidez(5.35);
    

    public static void main(String args[]) {
               
        fosforo.calcTeorFosforo();
        potassio.calcTeorPotassio();
        calcio.calcTeorCalcio();
        magnesio.calcTeorMagnesio();
        
        System.out.println("------------------------------------------------------------------------");
        System.out.println("A quantidade ideal de fósforo é de: " +fosforo.getIdeal());
        System.out.println("A quantidade ideal de potássio é de: " +potassio.getIdeal());
        System.out.println("A quantidade ideal de cálcio é de: " +calcio.getIdeal());
        System.out.println("A quantidade ideal de magnésio é de: " +magnesio.getIdeal());
        System.out.println("A quantidade ideal de enxofre é de: " +enxofre.getIdeal());
        System.out.println("A quantidade ideal de alumínio é de: " +aluminio.getIdeal());
        System.out.println("------------------------------------------------------------------------");
        System.out.println("A quantidade corrigida de fósforo é de: " +fosforo.getCorrigido());
        System.out.println("A quantidade corrigida de potássio é de: " +potassio.getCorrigido());
        System.out.println("A quantidade corrigida de cálcio é de: " +calcio.getCorrigido());
        System.out.println("A quantidade corrigida de magnésio é de: " +magnesio.getCorrigido());
        System.out.println("------------------------------------------------------------------------");
        calcValoresCmol();

    }
    
    public static void calcValoresCmol(){
        double sCmol = potassio.getQtdSolo()+calcio.getQtdSolo()+magnesio.getQtdSolo();
        double ctcCmol = sCmol + acidez.getQtdSolo();
        double vAtual = 100*sCmol/ctcCmol;
        
        System.out.println("S cmol = " + sCmol+" ctcCmol = "+ctcCmol+ " V% Atual = " +vAtual);
    }
    
}
