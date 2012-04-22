/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kaksintaistelu;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author T
 */
public class TaisteluTest {

    Pelaaja ihminen;
    Pelaaja tietokone;

    public TaisteluTest() {
    }

    @BeforeClass
    @Before
    public void setUp() {
        ihminen = new IhmisPelaaja(10);
        tietokone = new TietokonePelaaja(10);
    }

    @Test
    public void kortinValinta() {
    }

    @Test
    public void vahinko() {
    }

    @Test
    public void parannus() {
    }

    @Test
    public void pelaajanKuolema() {
    }

    @Test
    public void tietokoneenKuolema() {
    }
}
