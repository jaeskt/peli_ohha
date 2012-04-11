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
/**
 * Metodin on tarkoitus päättää minkä kortin tietokonepelaa
 * 
 * Päätös tehdään vastustajan kestojen, omien kestojen ja valittavana olevien korttien perusteella
 * @param ihminenHP saa vastustajan kestot päätöstä varten
 * @return 
 */
    public kortti AIpelaaKortti(int ihminenHP) {
        vastustajanHP=ihminenHP;
        if(vastustajanHP<=getHP()){
            
        }
        apuNRO=1;
        return pelaaKortti(apuNRO);
    }
}
