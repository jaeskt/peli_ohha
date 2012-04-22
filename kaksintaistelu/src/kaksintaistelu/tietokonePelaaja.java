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
 * Luokka perii myös luokan Pelaaja
 */
 class TietokonePelaaja extends Pelaaja {

    private int vastustajanHP;
    private int apuNRO;
    private Kortti kortti;

    

    public TietokonePelaaja(int maara) {
        super(maara);

    }
/**
 * Metodin on tarkoitus päättää minkä kortin tietokonepelaa
 * 
 * Päätös tehdään vastustajan kestojen, omien kestojen ja valittavana olevien korttien perusteella
 * @param ihminenHP saa vastustajan kestot päätöstä varten
 * @return 
 */
    public Kortti AIpelaaKortti(int ihminenHP) {

        vastustajanHP=ihminenHP;
        if(vastustajanHP<=getHP()){
          for(int i=0;i<kasiKortit.size();i++){
            kortti=haeKorttiTietystaPaikasta(i);
        } 
        }
        apuNRO=1;
        return pelaaKortti(apuNRO);
    }
}
