
package com.mycompany.sacorrecaosolo;
/**
 *
 * @author jvitorgf
 */
public class CorrecaoSolo {

    private double idealFosforo;
    private double idealPotassio;
    private double idealCalcio;    
    private double idealMagnesio; 
    private double idealEnxofre;
    private double idealAluminio;

    
    public void calcIdeal(int texturaSolo) {
        if (texturaSolo == 1) {
            idealFosforo = 9;
            idealPotassio = 0.35;
            idealCalcio = 6;
            idealMagnesio = 1.5;
            idealEnxofre  = 9;
            idealAluminio = 0;

        } else if (texturaSolo == 2) {
            idealFosforo = 12;
            idealPotassio = 0.25;
            idealCalcio = 4;
            idealMagnesio = 1;
            idealEnxofre  = 6;
            idealAluminio = 0;
        } else {
            System.out.println("A textura do solo deve ser 1 ou 2.");
        }
    }
}
