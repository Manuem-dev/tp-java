package tp;

import javax.swing.JFrame;


public class Fenetre extends JFrame {
    public Fenetre(){
        this.setTitle("Gestion de Stock");
        this.setSize(1000,900);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        
        // Content pan de JPanel
        this.setContentPane(new Panneau());










        this.setVisible(true);


    }
}
