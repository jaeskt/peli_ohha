/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kaksintaistelu;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author timojaas
 * @version 0.01
 * @since 19-3-2012
 */
public class pelinAloitusTest {

    pelaaja ihminen;
    pelaaja tietokone;

    @Before
    public void setUp() {
        ihminen = new ihmisPelaaja(35);
        tietokone = new tietokonePelaaja(5);

    }

    @Test
    public void pelaajienKestot() {
        assertEquals(20, ihminen.getHP());
        assertEquals(5, tietokone.getHP());
        /**
         * tarkistaa että kestot eivät voi mennä ylitse 30 tarkistaa että antaa
         * toiselle pelaajalle oikeat kestot.
         */
    }

    @Test
    public void korttienLukumaaraOikea() {
        assertEquals(5, tietokone.getKorttiMaara());
        assertEquals(5, ihminen.getKorttiMaara());
        /**
         * tarkistaa että molemmilla on alussa viisi korttia.
         */
    }
}
