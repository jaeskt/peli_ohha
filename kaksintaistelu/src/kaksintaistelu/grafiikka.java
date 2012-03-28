/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kaksintaistelu;

/**
 * @author timojaas
 * @version 0.02
 * @since 21-3-2012
 * 
 * Grafiikka luokka huolehtii kaiken piirtämisen mitä pelissä tarvitaan.
 * 
 */
// Timo Jääskeläinen Tehtävä #.# Viikko #
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;

public class grafiikka extends JPanel {
    Scanner lukija = new Scanner(System.in);
    private int apuHP;
   
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.drawString("START F1", 20, 20);
        g.drawString("EXIT F2", 500, 20);
        
    }
    public void kestojenAnto(Graphics g){
        super.paint(g);
        g.setColor(Color.RED);
        g.drawString("Anna  pelaajan kestot!", 200,200);
        apuHP=Integer.parseInt(lukija.nextLine());
        String teksti=""+apuHP;
        g.drawString(teksti,20,300);
        
        
    }
}
