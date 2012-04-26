/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kaksintaistelu;

import java.util.ArrayList;

/**
 *
 * @author Timo Jääskeläinen
 * @version 0.01
 * @since 20-3-2012
 *
 * Luokka pitää yllä pelaajan tietoja.
 *
 * Luokka muuttaa kestoja ja huolehtii myös samalla korttimäärästä.
 */
public class Pelaaja {

    /**
     * Parametri, joka muistaa pelaajan keston.
     */
    private int hp;
       /**
     * Parametri, jossa säilytetään pelaajalla käytössä olevat kortit.
     */
    ArrayList<Kortti> kasiKortit;
       /**
     * Parametri pitää muistissa pelaajan pelaaman kortin.
     */
    private Kortti pelattavaKortti;

    /**
     * Luo uuden pelaajan ja luo tälle uuden korttivaraston.
     * @param maara uuden pelaajan kestojen määrä
     */
    public Pelaaja(int maara) {
        muutaKesto(maara);
        this.kasiKortit = new ArrayList<Kortti>();
        nostaKorttiMaaraViiteen();
    }

    /**
     * Metdo palauttaa pelaajan kestot.
     * @return kyseisen pelaajan jäljellä olevat kestot
     */
    public int getHP() {
        return hp;
    }

    /**
     * Metodi palauttaa korttien määrän.
     * @return käsikorttien määrä
     */
    public int getKorttiMaara() {
        return kasiKortit.size();
    }

    /**
     * Metodi täydentää käsikortien määrän viiteen
     */
    public void nostaKorttiMaaraViiteen() {
        for (int i = kasiKortit.size(); i < 5; i++) {
            kasiKortit.add(new Kortti());
        }
    }

    /**
     * Metodi palauttaa tietystä paikasta kortin.
     *
     * @param hakunumero pelaajan haluaman kortin paikka
     * @return Palauttaa tietyn kortin
     */
    public Kortti haeKorttiTietystaPaikasta(int hakunumero) {
        return kasiKortit.get(hakunumero);
    }

    /**
     * Metodi palauttaa tietyn kortin tunnistetiedon ja poistaa kortin kädestä.
     *
     * @param hakunumero halutun kortin paikka pelaajan kädessä
     * @return Palauttaa tietyn kortin
     */
    public Kortti pelaaKortti(int hakunumero) {
        pelattavaKortti = haeKorttiTietystaPaikasta(hakunumero);
        kasiKortit.remove(hakunumero);
        nostaKorttiMaaraViiteen();
        return pelattavaKortti;
    }

    /**
     * Metodi asettaa pelaajan kestot haluttuun pisteeseen.
     *
     * @param maara luku, jonka verran kestoja halutaan muuttaa
     */
    public void muutaKesto(int maara) {
        if (hp + maara >= 20) {
            hp = 20;
        } else {
            hp = hp + maara;
        }
        if (hp <= 0) {
            hp = 0;
        }
    }
}
