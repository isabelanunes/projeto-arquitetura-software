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
public class Enxofre {

    /**
     * @param args the command line arguments
     */
    private double qtdSolo;
    private final double ideal1 = 9.0;
    private final double ideal2 = 6.0;
    private double ideal;
    
    public Enxofre(double qtdSolo, int textura) {
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
    
    public double getIdeal() {
        return ideal;
    }
}
