package tp;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Panneau extends JPanel {
    public void paintComponent(Graphics g) {
        System.out.println("Je suis exécutée !");
        g.drawRoundRect(200,100,150,100,20,20);
        g.drawString("Bienvenue sur notre site de gestion de projet", this.getWidth()/2, this.getHeight()/2);
    }
}
