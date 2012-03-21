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
 */
public class pelinkulkuTest {
    
    pelaaja ihminen;
    pelaaja tietokone;

    @Before
    public void setUp() {
        ihminen = new ihmisPelaaja(35);
        tietokone = new tietokonePelaaja(5);

    }

    //@Test
    public void molemmatOttavatTietynKortin() {
    assertEquals(1,ihminen.pelaaKortti(1));
    assertEquals(3,ihminen.pelaaKortti(3));}
    
}
