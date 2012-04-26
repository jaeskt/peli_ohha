/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kaksintaistelu;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *Tässä testiluokassa testataan korttien toimivuutta.
 * Testit tarkastelevat
 */
public class kortinTapahtumaTest {

    Kortti kortti1;
    Kortti kortti2;
    Pelimoottori testiM;
    Pelaaja tietokone;
    Pelaaja ihminen;

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
        assertEquals(20, testiM.getIhmHP());
    }

    @Test
    public void nelonenVoittaaYkkosen() {
        kortti1 = new Kortti(1);
        kortti2 = new Kortti(4);
        testiM.korttiAI = kortti2;
        testiM.korttiIhminen = kortti1;
        testiM.korttienKasittely();
        assertEquals(20, testiM.getAIHP());
        assertEquals(18, testiM.getIhmHP());
    }

    @Test
    public void toisellaVitonenToisellaYkkonen() {
        kortti1 = new Kortti(1);
        kortti2 = new Kortti(5);
        testiM.korttiAI = kortti2;
        testiM.korttiIhminen = kortti1;
        testiM.korttienKasittely();
        assertEquals(20, testiM.getAIHP());
        assertEquals(20, testiM.getIhmHP());
    }

    @Test
    public void molemmillaKakkoset() {
        kortti1 = new Kortti(2);
        kortti2 = new Kortti(2);
        testiM.korttiAI = kortti2;
        testiM.korttiIhminen = kortti1;
        testiM.korttienKasittely();
        assertEquals(20, testiM.getAIHP());
        assertEquals(20, testiM.getIhmHP());
    }

    @Test
    public void kakkonenVoittaaNelosen() {
        kortti1 = new Kortti(2);
        kortti2 = new Kortti(4);
        testiM.korttiAI = kortti2;
        testiM.korttiIhminen = kortti1;
        testiM.korttienKasittely();
        assertEquals(16, testiM.getAIHP());
        assertEquals(20, testiM.getIhmHP());
    }

    @Test
    public void kakkonenVoittaaKolmosen() {
        kortti1 = new Kortti(2);
        kortti2 = new Kortti(3);
        testiM.korttiAI = kortti2;
        testiM.korttiIhminen = kortti1;
        testiM.korttienKasittely();
        assertEquals(20, testiM.getIhmHP());
        assertEquals(11, testiM.getAIHP());
    }

    @Test
    public void kakkonenVastaanVitonen() {
        kortti1 = new Kortti(2);
        kortti2 = new Kortti(5);
        testiM.korttiAI = kortti2;
        testiM.korttiIhminen = kortti1;
        testiM.korttienKasittely();
        assertEquals(16, testiM.getAIHP());
        assertEquals(16, testiM.getIhmHP());
    }

    @Test
    public void molemmillaKolmoset() {
       tietokone = testiM.tietokone;
        tietokone.muutaKesto(-11);
        ihminen = testiM.ihminen;
        ihminen.muutaKesto(-15);
        kortti1 = new Kortti(3);
        kortti2 = new Kortti(3);
        testiM.korttiAI = kortti2;
        testiM.korttiIhminen = kortti1;
        testiM.korttienKasittely();
        assertEquals(19, testiM.getAIHP());
        assertEquals(15, testiM.getIhmHP());
    }
        @Test
    public void nelonenVoittaaKolmosen() {
               tietokone = testiM.tietokone;
        tietokone.muutaKesto(-10);
        ihminen = testiM.ihminen;
        ihminen.muutaKesto(-10);
            kortti1 = new Kortti(3);
        kortti2 = new Kortti(4);
        testiM.korttiAI = kortti2;
        testiM.korttiIhminen = kortti1;
        testiM.korttienKasittely();
        assertEquals(15, testiM.getAIHP());
        assertEquals(10, testiM.getIhmHP());
    }
  @Test
    public void kolmonenVastaanVitonen() {
        kortti1 = new Kortti(3);
        kortti2 = new Kortti(5);
        testiM.korttiAI = kortti2;
        testiM.korttiIhminen = kortti1;
        testiM.korttienKasittely();
        assertEquals(20, testiM.getAIHP());
        assertEquals(20, testiM.getIhmHP());
    }
    @Test
    public void nelonenVastaanNelonen() {
        kortti1 = new Kortti(4);
        kortti2 = new Kortti(4);
        testiM.korttiAI = kortti2;
        testiM.korttiIhminen = kortti1;
        testiM.korttienKasittely();
        assertEquals(20, testiM.getAIHP());
        assertEquals(20, testiM.getIhmHP());
    }
      @Test
    public void vitonenVoittaaNelosen() {
        kortti1 = new Kortti(4);
        kortti2 = new Kortti(5);
        testiM.korttiAI = kortti2;
        testiM.korttiIhminen = kortti1;
        testiM.korttienKasittely();
        assertEquals(20, testiM.getAIHP());
        assertEquals(16, testiM.getIhmHP());
    }
        @Test
    public void vitonenVastaanVitonen() {
        kortti1 = new Kortti(5);
        kortti2 = new Kortti(5);
        testiM.korttiAI = kortti2;
        testiM.korttiIhminen = kortti1;
        testiM.korttienKasittely();
        assertEquals(0, testiM.getAIHP());
        assertEquals(0, testiM.getIhmHP());
    }
}
