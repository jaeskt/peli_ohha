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
public class kortinTapahtumaTest {

    Kortti kortti1;
    Kortti kortti2;
    Pelimoottori testiM;
    Pelaaja tietokone;

    public kortinTapahtumaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        testiM = new Pelimoottori();

    }

    @After
    public void tearDown() {
    }

    @Test
    public void ykkonenVoittaaKakkosen() {
        kortti1 = new Kortti(1);
        kortti2 = new Kortti(2);
        testiM.korttiAI = kortti2;
        testiM.korttiIhminen = kortti1;
        testiM.korttienKasittely();
        assertEquals(16, testiM.getAIHP());
    }

    public void ykkosillaMolemmiltaKestoa() {
        kortti1 = new Kortti(1);
        kortti2 = new Kortti(1);
        testiM.korttiAI = kortti2;
        testiM.korttiIhminen = kortti1;
        testiM.korttienKasittely();
        assertEquals(16, testiM.getAIHP());
        assertEquals(16, testiM.getIhmHP());
    }

    @Test
    public void kolmonenVoittaaykkosen() {
        tietokone = testiM.tietokone;
        tietokone.muutaKesto(-5);
        kortti1 = new Kortti(1);
        kortti2 = new Kortti(3);
        testiM.korttiAI = kortti2;
        testiM.korttiIhminen = kortti1;
        testiM.korttienKasittely();
        assertEquals(19, testiM.getAIHP());
    }
      @Test
    public void nelonenVoittaaykkosen() {
        kortti1 = new Kortti(1);
        kortti2 = new Kortti(3);
        testiM.korttiAI = kortti2;
        testiM.korttiIhminen = kortti1;
        testiM.korttienKasittely();
        assertEquals(18, testiM.getAIHP());
    }
}
