/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kaksintaistelu;

import java.awt.Image;
import java.util.Scanner;

/**
 *
 * @author Timo Jääskeläinen
 * @version 0.05
 * @since 4-4-2012
 *
 * Luokka toimii alustana korttitapahtumille.
 *
 */
//Timo Jääskeläinen Viikko2 Tehtävä #.#
public class pelimoottori {

    Scanner lukija = new Scanner(System.in);
    private ihmisPelaaja ihminen;
    private tietokonePelaaja tietokone;

    public pelimoottori() {
        ihminen= new ihmisPelaaja(20);
        tietokone = new tietokonePelaaja(20);                   
    }
    public Image getKorttiKuvat(int nro){
    kortti kortti=ihminen.haeKorttiTietystaPaikasta(nro);
    return kortti.getImage();
    
    }
}
