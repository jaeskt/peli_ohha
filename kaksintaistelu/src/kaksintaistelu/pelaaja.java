/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kaksintaistelu;

import java.util.ArrayList;

/**
 *
 * @author timojaas
 */
// Timo Jääskeläinen Tehtävä #.# Viikko #
public class pelaaja {

    private int hp;
    private ArrayList<kortti> kasiKortit;
    private kortti pelattavaKortti;

    public pelaaja(int maara) {
        lisaaKestoa(maara);
        kasiKortit = new ArrayList<kortti>();
        nostaKorttiMaaraViiteen();
    }

    public int getHP() {
        return hp;
    }

    public int getKorttiMaara() {
        return kasiKortit.size();
    }

    public void nostaKorttiMaaraViiteen() {
        for (int i = kasiKortit.size(); i < 5; i++) {
            kasiKortit.add(new kortti());
        }
    }

    public kortti haeKorttiTietystaPaikasta(int hakunumero) {
        return kasiKortit.get(hakunumero);
    }

    public kortti pelaaKortti(int hakunumero) {
        pelattavaKortti = haeKorttiTietystaPaikasta(hakunumero);
        kasiKortit.remove(hakunumero);
        nostaKorttiMaaraViiteen();
        return pelattavaKortti;
    }

    public void lisaaKestoa(int maara) {
        if (hp + maara >= 20) {
            hp = 20;
        } else {
            hp = hp + maara;
        }
    }
}
