
package kaksintaistelu;

/**
 *
 *  *
 * @author Timo Jääskeläinen @versio 0.02
 * @since 21-3-2012
 *
 * Luokka on olemassa ihmispelaajaa varten, jos innostun laajentamaan tätä ohjelmaa ja
 * keksimään uusia ominaisuuksia, jotka eivät koskisi tietokonepelaajaa. 
 *
 * Luokka perii myös luokan Pelaaja
 */

public class IhmisPelaaja extends Pelaaja {
    /**
     * Konstruktori luo uuden pelaajan.
     * @param maara Kestopisteiden maara, jonka pelaaja saa luonnin yhteydessä
     */
    public IhmisPelaaja(int maara) {
        super(maara);
    }
}
