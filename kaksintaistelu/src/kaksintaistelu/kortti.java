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
 */
// Timo Jääskeläinen Tehtävä #.# Viikko #
public class kortti {

    private int kortinTunniste;
    Image kortti;

    public kortti() {
        Random arpoja = new Random();
        kortinTunniste = arpoja.nextInt(5) + 1;
        ImageIcon i = new ImageIcon("E:/Users/T/ohha/kaksintaistelu/kuvat/tausta.png");
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

    public int getTunniste() {
        return kortinTunniste;
    }
    public Image getImage(){
    return kortti;}
}
