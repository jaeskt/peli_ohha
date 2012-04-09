/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kaksintaistelu;

/**
 *
 * @author Timo Jääskeläinen @versio 0.02
 * @since 21-3-2012
 *
 * Luokan ohjaa tietokonevastustajan käytöstä.
 *
 * Tänne ohjelmoidaan kuinka tietokonepelaaja toimii erillaisissa tilanteissa.
 * Luokka perii myös luokan pelaaja
 */
public class tietokonePelaaja extends pelaaja {

    private int vastustajanHP;
    private int apuNRO;

    public tietokonePelaaja(int maara) {
        super(maara);

    }

    public kortti AIpelaaKortti(int ihminenHP) {
        apuNRO=1;
        return pelaaKortti(apuNRO);
    }
}
