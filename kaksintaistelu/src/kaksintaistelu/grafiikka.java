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
    Image tausta;
    Image apukuva;
    Image apukuvaAI;
    boolean kaynnissa;
    boolean vuoro;
    boolean keskikuva;
    pelimoottori peli;
    String teksti;
    Font font1;
    AttributedString attributedString;

    public grafiikka() {
        ImageIcon i = new ImageIcon("E:/Users/T/ohha/kaksintaistelu/kuvat/tausta.png");
        tausta = i.getImage();
        kaynnissa = false;
        keskikuva = false;
        font1 = new Font("Algerian", Font.PLAIN, 30);

    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(tausta, 0, 0, null);
        tekstienKirjoitus(g);

        if (kaynnissa == true) {
            for (int i = 0; i < 5; i++) {
                g.drawImage(peli.getKorttiKuvat(i), 20 + 150 * i, 600, null);
            }
            if (keskikuva == true && peli.getAIHP() > 0 && peli.getIhmHP() > 0) {
                g.drawImage(apukuva, 150, 270, null);
                g.drawImage(apukuvaAI, 500, 270, null);
                teksti = "Seuraavavuoro: ENTER";
                attributedString = new AttributedString(teksti);
                attributedString.addAttribute(TextAttribute.FONT, font1);
                g.drawString(attributedString.getIterator(), 210, 550);
            } else if (keskikuva == true) {
                if (peli.getIhmHP() <= 0) {
                    
                } else if (peli.getAIHP() <= 0) {
                }
                kaynnissa=false;
            }
            g.setColor(Color.RED);
            g.fillRect(20, 100, 20, 20 * peli.getIhmHP());
            teksti = "HP: " + peli.getIhmHP();
            attributedString = new AttributedString(teksti);
            attributedString.addAttribute(TextAttribute.FONT, font1);
            g.drawString(attributedString.getIterator(), 10, 90);
            g.fillRect(740, 100, 20, 20 * peli.getAIHP());
            teksti = "HP: " + peli.getAIHP();
            attributedString = new AttributedString(teksti);
            attributedString.addAttribute(TextAttribute.FONT, font1);
            g.drawString(attributedString.getIterator(), 680, 90);

        }
    }

    private void tekstienKirjoitus(Graphics g) {

        teksti = "Start F1";
        attributedString = new AttributedString(teksti);
        attributedString.addAttribute(TextAttribute.FONT, font1);
        g.drawString(attributedString.getIterator(), 20, 40);

        teksti = "Exit F2";
        attributedString = new AttributedString(teksti);
        attributedString.addAttribute(TextAttribute.FONT, font1);
        g.drawString(attributedString.getIterator(), 650, 40);

        teksti = "1.";
        attributedString = new AttributedString(teksti);
        attributedString.addAttribute(TextAttribute.FONT, font1);
        g.drawString(attributedString.getIterator(), 80, 590);

        teksti = "2.";
        attributedString = new AttributedString(teksti);
        attributedString.addAttribute(TextAttribute.FONT, font1);
        g.drawString(attributedString.getIterator(), 230, 590);

        teksti = "3.";
        attributedString = new AttributedString(teksti);
        attributedString.addAttribute(TextAttribute.FONT, font1);
        g.drawString(attributedString.getIterator(), 380, 590);

        teksti = "4.";
        attributedString = new AttributedString(teksti);
        attributedString.addAttribute(TextAttribute.FONT, font1);
        g.drawString(attributedString.getIterator(), 530, 590);

        teksti = "5.";
        attributedString = new AttributedString(teksti);
        attributedString.addAttribute(TextAttribute.FONT, font1);
        g.drawString(attributedString.getIterator(), 680, 590);
    }

    @Override
    public void keyPressed(KeyEvent ke) {

        if (ke.getKeyCode() == 112) {
            kaynnistys();
        }
        if (ke.getKeyCode() == 113) {
            System.exit(0);
        }

        if (vuoro == true) {
            if (ke.getKeyCode() == 49) {
                vuoroApu(0);
            } else if (ke.getKeyCode() == 50) {
                vuoroApu(1);
            } else if (ke.getKeyCode() == 51) {
                vuoroApu(2);
            } else if (ke.getKeyCode() == 52) {
                vuoroApu(3);
            } else if (ke.getKeyCode() == 53) {
                vuoroApu(4);
            }
        } else if (vuoro == false && kaynnissa == true && ke.getKeyCode() == 10) {
            vuoro = true;
        }
        repaint();
    }

    private void kaynnistys() {
        peli = new pelimoottori();
        kaynnissa = true;
        vuoro = true;
    }

    public void vuoroApu(int nro) {
        apukuva = peli.getKorttiKuvat(nro);
        peli.pelaaKortti(nro);
        apukuvaAI = peli.getKorttiKuvaAI();
        vuoro = false;
        keskikuva = true;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
