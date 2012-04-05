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
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import java.util.Scanner;

public class grafiikka extends JPanel implements KeyListener {

    Scanner lukija = new Scanner(System.in);
    private int apuHP;
    int y = 0;
    Image tausta;
    Image apu;
    boolean kaynnissa;
    pelimoottori peli;

    public grafiikka() {
        ImageIcon i = new ImageIcon("E:/Users/T/ohha/kaksintaistelu/kuvat/tausta.png");
        tausta = i.getImage();
        kaynnissa = false;

    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(tausta, 0, 0, null);
        Font font1 = new Font("Book Antiqua", Font.PLAIN, 30);
        String teksti = "Start F1";
        AttributedString attributedString = new AttributedString(teksti);
        attributedString.addAttribute(TextAttribute.FONT, font1);
        g.drawString(attributedString.getIterator(), 20, 40);
       
        teksti = "Exit F2";
        attributedString = new AttributedString(teksti);
        attributedString.addAttribute(TextAttribute.FONT, font1);
        g.drawString(attributedString.getIterator(), 650, 40);
        
        if (kaynnissa == true) {
            for (int i = 0; i < 5; i++) {
                apu = peli.getKorttiKuvat(i);
                g.drawImage(apu, 20 + 140 * i, 600, null);           
            }
        }

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == 112) {
            peli = new pelimoottori();
            kaynnissa = true;
            repaint();

        } else if (ke.getKeyCode() == 113) {
            System.exit(0);
        }
    }
}
