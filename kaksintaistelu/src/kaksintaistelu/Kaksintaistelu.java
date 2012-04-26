package kaksintaistelu;

import java.awt.*;
import javax.swing.*;

public class Kaksintaistelu {

    public static void main(String[] args) {
        JFrame ikkuna = new JFrame();
        Grafiikka Graf = new Grafiikka();
        Container container = ikkuna.getContentPane();
        container.add(Graf);
        ikkuna.addKeyListener(Graf);
        ikkuna.setSize(799, 830);
        ikkuna.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ikkuna.setVisible(true);
        
       

    }
}
