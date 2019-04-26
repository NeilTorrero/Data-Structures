package Graphs.visualización;


import javax.swing.*;
import java.awt.*;

public class Vista extends JFrame {

    public Vista(Graphs.List usus) {
        Vista_Graph vg = new Vista_Graph(usus);
        this.add(vg);
        this.setSize(new Dimension(700,700));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
