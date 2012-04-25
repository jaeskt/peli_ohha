/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kaksintaistelu;

import java.util.Random;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author timojaas
 * @version 0.01
 * @since 20-3-2012
 *
 * Korttiluokka huolehtii uusien korttien tekemisestä. Luokka palauttaa olemassa
 * olevien korttien kuvan ja tunnisteen.
 */
public class Kortti {

    private int kortinTunniste;
    Image kortti;
    ImageIcon i;

    /**
     * Luo uuden sattumanvaraisen kortin pelaajalle/tietokoneelle
     */
    public Kortti() {
        Random arpoja = new Random();
        kortinTunniste = arpoja.nextInt(5) + 1;
        kuvanAsetus(kortinTunniste);
    }

    /**
     * Luo halutun tunnisteen omaavan kortin. 
     * Estää luomasta korttia, jonka tunniste tieto ei ole välillä 1-5.
     * @param apu halutun kortin tunniste (testaukseen)
     */
    public Kortti(int apu) {
        int i = apu;
        if (apu > 5 || apu < 1) {
            i = 1;
        }
        kortinTunniste = i;
        kuvanAsetus(kortinTunniste);
    }

    /**
     * asettaa kortille oikean kuvan
     *
     * @param kortinTunniste Kertoo mikä kuva kortille pitää laittaa.
     *
     */
    private void kuvanAsetus(int kortinTunniste) {
        if (kortinTunniste == 1) {
            i = new ImageIcon("E:/Users/T/ohha/kaksintaistelu/kuvat/1.png");
        } else if (kortinTunniste == 2) {
            i = new ImageIcon("E:/Users/T/ohha/kaksintaistelu/kuvat/2.png");
        } else if (kortinTunniste == 3) {
            i = new ImageIcon("E:/Users/T/ohha/kaksintaistelu/kuvat/3.png");
        } else if (kortinTunniste == 4) {
            i = new ImageIcon("E:/Users/T/ohha/kaksintaistelu/kuvat/4.png");
        } else if (kortinTunniste == 5) {
            i = new ImageIcon("E:/Users/T/ohha/kaksintaistelu/kuvat/5.png");
        }
        kortti = i.getImage();
    }

    /**
     *
     * @return Kortin tunniste, jotä ohjelma käyttää tapahtuman tarkastelussa
     */
    public int getTunniste() {
        return kortinTunniste;
    }

    /**
     *
     * @return Kortin kuva piirtämistä varten
     */
    public Image getImage() {
        return kortti;
    }
}
