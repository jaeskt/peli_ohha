package kaksintaistelu;

/**
 * @author timojaas
 * @version 0.02
 * @since 21-3-2012
 *
 * Grafiikka luokka huolehtii kaikesta piirtämisestä mitä pelissä tarvitaan.
 *
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.text.AttributedString;

public class Grafiikka extends JPanel implements KeyListener {

    /**
     * Taustan asettamiseen käytetty parametri
     */
    Image tausta;
    /**
     * Ihmisen pelaaman kortin asettamiseen.
     */
    Image apukuva;
    /**
     * Tietokoneen pelaaman kortin asettaminen.
     */
    Image apukuvaAI;
    /**
     * Muistaa onko peli käynnissä vai ei.
     */
    private boolean kaynnissa;
    /**
     * Pitää huolta että montaa korttia ei voi pelata samanaikaisesti.
     */
    private boolean vuoro;
    /**
     * Parametrin avulla pidetään huoli, että pelatut kortit eivät näy tietyissä tilanteissa.
     */
    private boolean keskikuva;
    /**
 * Parametri estää korttien pelaamisen, kun pelaaja on HELP-ruudussa.
 */
    private boolean pause;
    /**
 * @see kaksintaistelu.Pelimoottori
 */
    Pelimoottori peli;
    /**
 * Parametri, jota käytetään halutun tekstin muistamiseen.
 */
    private String teksti;
    /**
 * Parametri, fontin valintaan.
 */
    private Font font1;
    /**
 * Parametri, tekstien kirjoittamiseen.
 */
    private AttributedString attributedString;

    /**
     * Luo uuden taustan ohjelman käynnistämisen yhteydessä.
     */
    public Grafiikka() {
        asetaNormiTausta();
        kaynnissa = false;
        keskikuva = false;
        font1 = new Font("Algerian", Font.PLAIN, 30);


    }

    /**
     * Paint hoitaa kuvien vaihtamisen ja tekstien kirjoittamisen pelin edetessä.
     *
     * @param g Grafiikan käyttämä parametri
     */
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(tausta, 0, 0, null);

        if (kaynnissa == true && pause == false) {
            g.setColor(Color.RED);
            g.fillRect(20, 100, 20, 20 * peli.getIhmHP());
            teksti = "HP: " + peli.getIhmHP();
            tekstinFonttiPerus();
            g.drawString(attributedString.getIterator(), 10, 90);
            g.fillRect(740, 100, 20, 20 * peli.getAIHP());
            teksti = "HP: " + peli.getAIHP();
            tekstinFonttiPerus();
            g.drawString(attributedString.getIterator(), 680, 90);
            for (int i = 0; i < 5; i++) {
                g.drawImage(peli.getKorttiKuvat(i), 20 + 150 * i, 600, null);
            }
            if (keskikuva == true && peli.getAIHP() > 0 && peli.getIhmHP() > 0 && kaynnissa == true) {
                g.drawImage(apukuva, 150, 270, null);
                g.drawImage(apukuvaAI, 500, 270, null);
                teksti = "Seuraavavuoro: ENTER";
                tekstinFonttiPerus();
                g.drawString(attributedString.getIterator(), 210, 550);
            } else if (keskikuva == true && kaynnissa == true) {
                tarkistaLopputilanne(g);
            }
        }
        if (pause == false) {
            tekstienKirjoitus(g);
        }
    }

    /**
     * Metodi tarkistaa päätyykö peli ja mikä oli siihen syy.
     * Vaihtaa myös oikean taustakuvan.
     *
     * @param g Grafiikan käyttämä parametri
     */
    private void tarkistaLopputilanne(Graphics g) {
        if (peli.getAIHP() <= 0 && peli.getIhmHP() <= 0) {
            ImageIcon i = new ImageIcon("E:/Users/T/ohha/kaksintaistelu/kuvat/tasapeli.png");
            tausta = i.getImage();
            g.drawImage(tausta, 0, 0, null);
            teksti = "Tasapeli!";
            tekstinFonttiPerus();
            g.drawString(attributedString.getIterator(), 310, 350);
        } else if (peli.getIhmHP() <= 0) {
            ImageIcon i = new ImageIcon("E:/Users/T/ohha/kaksintaistelu/kuvat/havio.png");
            tausta = i.getImage();
            g.drawImage(tausta, 0, 0, null);
        } else if (peli.getAIHP() <= 0) {
            ImageIcon i = new ImageIcon("E:/Users/T/ohha/kaksintaistelu/kuvat/voitto.png");
            tausta = i.getImage();
            g.drawImage(tausta, 0, 0, null);
            asetaNormiTausta();
            teksti = "Voitit!";
            g.drawString(attributedString.getIterator(), 310, 350);
        }
         asetaNormiTausta();;
        kaynnissa = false;
    }

    /**
     * Metodi asettaa taustakuvan perusasetukselle.
     */
    private void asetaNormiTausta() {
        ImageIcon i;
        i = new ImageIcon("E:/Users/T/ohha/kaksintaistelu/kuvat/tausta.png");
        tausta = i.getImage();
    }

    /**
     * Metodi vaihtaa kirjoitettavan tekstin sisällön.
     * Metodin tarkoitus on myös siistiä koodia.
     */
    private void tekstinFonttiPerus() {
        attributedString = new AttributedString(teksti);
        attributedString.addAttribute(TextAttribute.FONT, font1);
    }

    /**
     * Metodi hoitaa muuttumattominen tekstien kirjoittamisen.
     *
     * @param g Grafiikan käyttämä parametri
     */
    private void tekstienKirjoitus(Graphics g) {

        teksti = "Start F1";
        tekstinFonttiPerus();
        g.drawString(attributedString.getIterator(), 20, 40);

        teksti = "Exit F2";
        tekstinFonttiPerus();
        g.drawString(attributedString.getIterator(), 650, 40);

        teksti = "Help F3";
        tekstinFonttiPerus();
        g.drawString(attributedString.getIterator(), 350, 40);
        if (kaynnissa == true) {
            teksti = "1.";
            tekstinFonttiPerus();
            g.drawString(attributedString.getIterator(), 80, 590);

            teksti = "2.";
            tekstinFonttiPerus();
            g.drawString(attributedString.getIterator(), 230, 590);

            teksti = "3.";
            tekstinFonttiPerus();
            g.drawString(attributedString.getIterator(), 380, 590);

            teksti = "4.";
            tekstinFonttiPerus();
            g.drawString(attributedString.getIterator(), 530, 590);

            teksti = "5.";
            tekstinFonttiPerus();
            g.drawString(attributedString.getIterator(), 680, 590);
        }
    }

    /**
     * Metodi valvoo mitä näppäimiä pelaaja painaa.
     *
     * @param ke Näppäinpainalluksessa käytettävä parametri
     */
    @Override
    public void keyPressed(KeyEvent ke) {

        if (ke.getKeyCode() == 112 && pause == false) {
            kaynnistys();
            repaint();
        }
        if (ke.getKeyCode() == 113) {
            System.exit(0);
        }
        if (ke.getKeyCode() == 114) {

            if (pause == false) {
                ImageIcon i = new ImageIcon("E:/Users/T/ohha/kaksintaistelu/kuvat/help.png");
                tausta = i.getImage();
                pause = true;
            } else {
                asetaNormiTausta();
                pause = false;
            }
            repaint();
        }
        if (vuoro == true && pause == false) {
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
            repaint();
        } else if (vuoro == false && kaynnissa == true && ke.getKeyCode() == 10) {
            vuoro = true;
            repaint();
        }

    }

    /**
     * Käynnistää uuden pelin ohjelman sisällä.
     */
     void kaynnistys() {
        peli = new Pelimoottori();
        kaynnissa = true;
        vuoro = true;
        keskikuva = false;

    }

    /**
     * Huolehtii kuvista, jotka pelaaja ja tietokone pelaavat vuoronaikana.
     * Ilmoittaa myös pelimoottorille, mimkä korttipaikan numeroa pelaaja painoi.
     *
     * @param nro Pelaajan painaman korttipaikan numero.
     */
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
    public boolean getVuoro(){
        return vuoro;
    }
}
