/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kaksintaistelu;

import java.util.Random;

/**
 *
 * @author timojaas
 * @version 0.01
 * @since 20-3-2012
 */
// Timo Jääskeläinen Tehtävä #.# Viikko #
public class kortti {
    private int kortinTunniste;
    public kortti(){
         Random arpoja = new Random(); 
         kortinTunniste= arpoja.nextInt(5)+1;
    }
    public int getTunniste(){
    return kortinTunniste;}

}
