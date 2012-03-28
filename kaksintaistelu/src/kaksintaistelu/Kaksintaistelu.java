package kaksintaistelu;

import java.awt.*;
import javax.swing.*;
import java.util.Scanner;

public class Kaksintaistelu {
    Scanner lukija = new Scanner(System.in);
    ihmisPelaaja ihminen;
    tietokonePelaaja tietokone;
    public static void main(String[] args) {
        JFrame ikkuna = new JFrame();
        ikkuna.setSize(800, 800);
        ikkuna.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ikkuna.setVisible(true);
        grafiikka peli = new grafiikka();
        peli.setBackground(Color.BLACK);
        Container sisalto = ikkuna.getContentPane();
        sisalto.add(peli);
        
        
    }
    
   public void aloitaPeli(){
       ihminen= new ihmisPelaaja(Integer.parseInt(lukija.nextLine()));
       tietokone = new tietokonePelaaja(Integer.parseInt(lukija.nextLine()));
   }
}
