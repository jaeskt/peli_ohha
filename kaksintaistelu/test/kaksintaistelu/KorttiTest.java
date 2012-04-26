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
public class KorttiTest {
    Kortti k1;
    Kortti k2;




    
    @Before
    public void setUp() {
        k1 = new Kortti();
        k2 = new Kortti();
    }
    
     @Test
     public void KortitSaavatOikenTunnisteen() {
         int apu=0;
         if(k1.getTunniste()<=5){
         apu=k1.getTunniste();}
         assertEquals(apu,k1.getTunniste());

     }
     
}
