/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kaksintaistelu;

import java.awt.Image;
import java.util.Scanner;

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
public class pelimoottori {

    Scanner lukija = new Scanner(System.in);
    private ihmisPelaaja ihminen;
    pelaaja apupelaaja1;
    pelaaja apupelaaja2;
    private tietokonePelaaja tietokone;
    kortti korttiIhminen;
    kortti korttiAI;
    int AInro;
    int Inro;
    int apu;

    public pelimoottori() {
        ihminen = new ihmisPelaaja(20);
        tietokone = new tietokonePelaaja(20);
    }

    public Image getKorttiKuvat(int nro) {
        korttiIhminen = ihminen.haeKorttiTietystaPaikasta(nro);
        return korttiIhminen.getImage();
    }

    public Image getKorttiKuvaAI() {
        return korttiAI.getImage();
    }

    public void pelaaKortti(int nro) {
        korttiIhminen = ihminen.pelaaKortti(nro);
        korttiAI = tietokone.AIpelaaKortti(ihminen.getHP());
        korttienKasittely();

    }

    int getIhmHP() {
        return ihminen.getHP();
    }

    int getAIHP() {
        return tietokone.getHP();
    }

    public void korttienKasittely() {

        AInro = korttiAI.getTunniste();
        Inro = korttiIhminen.getTunniste();
        samatNumerot();
        toisellaNroYksi();
        toisellaNroKaksi();
        toiselllaNroKolme();
        toisellaNroNelja();
    }

    private void toisellaNroNelja() {
        if (Inro == 4 || AInro == 4) {
            if (Inro == 4) {
                asetaIhminenApu1();
            } else {
                asetaTietokoneApu1();
            }
            if (apu == 5) {
                apupelaaja1.muutaKesto(-4);
            }
        }
    }

    private void toiselllaNroKolme() {
        if (Inro == 3 || AInro == 3) {
            if (Inro == 3) {
                asetaIhminenApu1();
            } else {
                asetaTietokoneApu1();
            }
            if (apu == 4) {
                apupelaaja1.muutaKesto(10);
            }
        }
    }

    private void toisellaNroKaksi() {
        if (Inro == 2 || AInro == 2) {
            if (Inro == 2) {
                asetaIhminenApu1();
            } else {
                asetaTietokoneApu1();
            }
            if (apu == 3) {
                apupelaaja2.muutaKesto(-8);
            } else if (apu == 4) {
                apupelaaja2.muutaKesto(-4);
            } else if (apu == 5) {
                apupelaaja1.muutaKesto(-4);
                apupelaaja2.muutaKesto(-4);
            }

        }
    }

    private void toisellaNroYksi() {
        if (Inro == 1 || AInro == 1) {

            if (Inro == 1) {
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

    private void asetaTietokoneApu1() {
        apupelaaja2 = ihminen;
        apu = Inro;
        apupelaaja1 = tietokone;
    }

    private void asetaIhminenApu1() {
        apupelaaja1 = ihminen;
        apu = AInro;
        apupelaaja2 = tietokone;
    }

    private void samatNumerot() {
        if (Inro == AInro) {
            if (Inro == 1) {
                ihminen.muutaKesto(-4);
                tietokone.muutaKesto(-4);
            } else if (Inro == 3) {
                ihminen.muutaKesto(10);
                tietokone.muutaKesto(10);
            } else if (Inro == 5) {
                ihminen.muutaKesto(-100);
                tietokone.muutaKesto(-100);
            }

        }
    }
}
