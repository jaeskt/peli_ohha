/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kaksintaistelu;

import java.awt.Image;

/**
 *
 * @author Timo Jääskeläinen
 * @version 0.05
 * @since 4-4-2012
 *
 * Luokka toimii alustana korttitapahtumille.
 *
 */
//Timo Jääskeläinen Viikko2 Tehtävä #.#
public class Pelimoottori {

    /**
     * @see kaksintaistelu.IhmisPelaaja
     */
    IhmisPelaaja ihminen;
    /**
     * Talentaa toisen pelaajan tiedot, jotta tapahtumien selvitys helpottuu.
     */
    private Pelaaja apupelaaja1;
    /**
     * Talentaa toisen pelaajan tiedot, jotta tapahtumien selvitys helpottuu.
     */
    Pelaaja apupelaaja2;
    /**
     * @see kaksintaistelu.TietokonePelaaja
     */
    TietokonePelaaja tietokone;
    /**
     * Ihmisen pelaama kortti.
     */
    Kortti korttiIhminen;
    /**
     * Tietokoneen pelaama kortti.
     */
    Kortti korttiAI;
    /**
     * Tietokoneen pelaaman kortin tunnistenumero.
     */
    private int nroAI;
    /**
     * Ihmisen pelaaman kortin tunnistenumero.
     */
   private int nroI;
    /**
     * Asettaa toisen pelaajan kortintunnistenumeron tänne tapahtumien selvittämistä vasrten.
     */
    private int apu;

    /**
     * Kun ohjelman käynnissä olessa luodaan uusipeli, niin Pelimoottori luo
     * tietokonevastuksen ja pelaajan.
     */
    public Pelimoottori() {
        ihminen = new IhmisPelaaja(20);
        tietokone = new TietokonePelaaja(20);
    }

    /**
     *
     * @param nro kortin paikka tunniste, josta pelaaja haluaa pelata kortin
     * @return palauttaa Grafiikalle halutun kuvan piirtämistä varten.
     */
    public Image getKorttiKuvat(int nro) {
        korttiIhminen = ihminen.haeKorttiTietystaPaikasta(nro);
        return korttiIhminen.getImage();
    }

    /**
     *
     * @return palauttaa tietokoneen pelaaman kortin kuvan Grafiikalle.
     */
    public Image getKorttiKuvaAI() {
        return korttiAI.getImage();
    }

    /**
     * Metodi hoitaa ylimmäntason vuoron aikana tapahtuvasta korttien
     * pelaamisesta.
     *
     * @param nro ihmisen pelaaman kortin paikkatieto.
     */
    public void pelaaKortti(int nro) {
        korttiIhminen = ihminen.pelaaKortti(nro);
        korttiAI = tietokone.pelaaKorttiAI(ihminen.getHP());
        korttienKasittely();

    }

    /**
     * Hakee ihmisen kestot ja palauttaa ne eteenpäin.
     * @return palauttaa ihmisen kestot.
     */
    int getIhmHP() {
        return ihminen.getHP();
    }

    /**
     * Hakee tietokoneen kestot ja palauttaa ne eteenpäin.
     * @return palauttaa tietokoneen kestot.
     */
    int getAIHP() {
        return tietokone.getHP();
    }

    /**
     * Metodi vertaa tietokoneen ja ihmisen pelaamien korttien tunnisteita.
     */
    public void korttienKasittely() {
        nroAI = korttiAI.getTunniste();
        nroI = korttiIhminen.getTunniste();
        samatNumerot();
        toisellaNroYksi();
        toisellaNroKaksi();
        toiselllaNroKolme();
        toisellaNroNelja();
    }

    /**
     * Metodi hoitaa tapahtuman, jos toisen pelaajan kortintunniste on neljä.
     */
    private void toisellaNroNelja() {
        if (nroI == 4 || nroAI == 4) {
            if (nroI == 4) {
                asetaIhminenApu1();
            } else {
                asetaTietokoneApu1();
            }
            if (apu == 5) {
                apupelaaja1.muutaKesto(-4);
            }
        }
    }

    /**
     * Metodi hoitaa tapahtuman, jos toisella pelaajalla kortintunniste on
     * kolme.
     */
    private void toiselllaNroKolme() {
        if (nroI == 3 || nroAI == 3) {
            if (nroI == 3) {
                asetaIhminenApu1();
            } else {
                asetaTietokoneApu1();
            }
            if (apu == 4) {
                apupelaaja2.muutaKesto(5);
            }
        }
    }

    /**
     * Metodi hoitaa tapahtuman, jos toisella pelaajalla kortintunniste on
     * kaksi.
     */
    private void toisellaNroKaksi() {
        if (nroI == 2 || nroAI == 2) {
            if (nroI == 2) {
                asetaIhminenApu1();
            } else {
                asetaTietokoneApu1();
            }
            if (apu == 3) {
                apupelaaja2.muutaKesto(-9);
            } else if (apu == 4) {
                apupelaaja2.muutaKesto(-4);
            } else if (apu == 5) {
                apupelaaja1.muutaKesto(-4);
                apupelaaja2.muutaKesto(-4);
            }

        }
    }

    /**
     * Metodi hoitaa tapahtuman, jos toisella pelaajalla kortintunniste on yksi.
     */
    private void toisellaNroYksi() {
        if (nroI == 1 || nroAI == 1) {

            if (nroI == 1) {
                asetaIhminenApu1();
            } else {
                asetaTietokoneApu1();
            }
            if (apu == 2) {
                apupelaaja2.muutaKesto(-4);
            } else if (apu == 3) {
                apupelaaja2.muutaKesto(4);
            } else if (apu == 4) {
                apupelaaja1.muutaKesto(-2);
            }
        }
    }
/**
 * Metodi asettaa ihmisen apupelaaja2:ksi ja kortin tunnistenumeron @param apu:n.
 */
    private void asetaTietokoneApu1() {
        apupelaaja2 = ihminen;
        apu = nroI;
        apupelaaja1 = tietokone;
    }
/**
 * Metodi asettaa tietokoneen apupelaaja2:ksi ja kortin tunnistenumeron @param apu:n.
 */
    private void asetaIhminenApu1() {
        apupelaaja1 = ihminen;
        apu = nroAI;
        apupelaaja2 = tietokone;
    }
/**
 * Metodi hoitaa tapahtumat jos molemmat pelaavat saman kortin.
 */
    private void samatNumerot() {
        if (nroI == nroAI) {
            if (nroI == 1) {
                ihminen.muutaKesto(-4);
                tietokone.muutaKesto(-4);
            } else if (nroI == 3) {
                ihminen.muutaKesto(10);
                tietokone.muutaKesto(10);
            } else if (nroI == 5) {
                ihminen.muutaKesto(-100);
                tietokone.muutaKesto(-100);
            }

        }
    }
}
