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

    Grafiikka testiG;
    
    @Before
    public void setUp() {
        testiG = new Grafiikka();
        testiG.kaynnistys();
            
    }
        @Test
     public void vuoroPysähtyy() {
            testiG.vuoroApu(3);
   assertEquals(false, testiG.getVuoro());       
}
}