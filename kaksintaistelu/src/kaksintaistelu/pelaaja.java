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
 * @param hp pelaajan kestopisteet
 * @param kasiKortit pitää korttien paikkoja selvillä
 * @param pelattavaKortti helpottaa kohteena olevan kortin käyttöä
 */
 class Pelaaja {

    /**
     * hp on kestot, jotka pelaajalla on. kasiKortit on lista, joka pitää
     * muistissa pelaajan kortit. pelattavaKortti on helpottava apuväline kortin
     * muistamiseen.
     */
    private int hp;
     ArrayList<Kortti> kasiKortit;
    private Kortti pelattavaKortti;

    public Pelaaja(int maara) {
        muutaKesto(maara);
        this.kasiKortit = new ArrayList<Kortti>();
        nostaKorttiMaaraViiteen();
    }

    /**
     * *
     * @return kyseisen pelaajan jäljellä olevat kestot
     */
    public int getHP() {
        return this.hp;
    }

    /**
     *
     * @return käsikorttienmäärä
     */
    public int getKorttiMaara() {
        return this.kasiKortit.size();
    }

    /**
     * Metodi täydentää käsikortien määrän viiteen
     */
    public void nostaKorttiMaaraViiteen() {
        for (int i = this.kasiKortit.size(); i < 5; i++) {
            this.kasiKortit.add(new Kortti());
        }
    }

    /**
     * Metodi palauttaa halutun kortin tiedot käyttöön.
     *
     * @param hakunumero pelaajan haluaman kortin paikka
     * @return tietyn kortin tunnistetiedon
     */
    public Kortti haeKorttiTietystaPaikasta(int hakunumero) {
        return this.kasiKortit.get(hakunumero);
    }

    /**
     * Metodi palauttaa tietyn kortin tunnistetiedon ja poistaa kortin kädestä.
     *
     * @param hakunumero halutun kortin paikka pelaajan kädessä
     * @return tietyn kortin tunnistetiedot
     */
    public Kortti pelaaKortti(int hakunumero) {
        this.pelattavaKortti = haeKorttiTietystaPaikasta(hakunumero);
        this.kasiKortit.remove(hakunumero);
        nostaKorttiMaaraViiteen();
        return this.pelattavaKortti;
    }

    /**
     * Metodi asettaa pelaajan kestot haluttuun pisteeseen.
     *
     * @param maara luku, jonka verran kestoja halutaan muuttaa
     */
    public void muutaKesto(int maara) {
        if (this.hp + maara >= 20) {
            this.hp = 20;
        } else {
            this.hp = this.hp + maara;
        }
        if (hp <= 0) {
            this.hp = 0;
        }
    }
}
