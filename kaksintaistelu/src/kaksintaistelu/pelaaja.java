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
public class pelaaja {

    /**
     * hp on kestot, jotka pelaajalla on. kasiKortit on lista, joka pitää
     * muistissa pelaajan kortit. pelattavaKortti on helpottava apuväline kortin
     * muistamiseen.
     */
    private int hp;
    private ArrayList<kortti> kasiKortit;
    private kortti pelattavaKortti;

    public pelaaja(int maara) {
        muutaKesto(maara);
        this.kasiKortit = new ArrayList<kortti>();
        nostaKorttiMaaraViiteen();
    }

    public int getHP() {
        return this.hp;
    }

    public int getKorttiMaara() {
        return this.kasiKortit.size();
    }

    public void nostaKorttiMaaraViiteen() {
        for (int i = this.kasiKortit.size(); i < 5; i++) {
            this.kasiKortit.add(new kortti());
        }
    }

    public kortti haeKorttiTietystaPaikasta(int hakunumero) {
        return this.kasiKortit.get(hakunumero);
    }

    public kortti pelaaKortti(int hakunumero) {
        this.pelattavaKortti = haeKorttiTietystaPaikasta(hakunumero);
        this.kasiKortit.remove(hakunumero);
        nostaKorttiMaaraViiteen();
        return this.pelattavaKortti;
    }

    public void muutaKesto(int maara) {
        if (this.hp + maara >= 20) {
            this.hp = 20;
        } else {
            this.hp = this.hp + maara;
        }
    }
}
