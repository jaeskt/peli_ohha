package kaksintaistelu;

import java.awt.*;
import javax.swing.*;

public class Kaksintaistelu {

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
}
