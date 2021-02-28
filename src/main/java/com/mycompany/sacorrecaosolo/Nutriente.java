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
public class Nutriente {

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getQtdSolo() {
        return qtdSolo;
    }

    public void setQtdSolo(double qtdSolo) {
        this.qtdSolo = qtdSolo;
    }
    
    private String nome;
    private double qtdSolo;
    private float ideal;

    public float getIdeal() {
        return ideal;
    }

    public void setIdeal(float ideal) {
        this.ideal = ideal;
    }

    public Nutriente(String nome, double qtdSolo) {
        this.nome = nome;
        this.qtdSolo = qtdSolo;
    }

  
    
   
}
