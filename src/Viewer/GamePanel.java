package Viewer;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;

import static java.awt.AWTEventMulticaster.add;

public class GamePanel extends JPanel{
    private JPanel p1,p2;
    private JButton[][] arrayButton;
    public GamePanel (int w, int h, int boom){
        arrayButton = new JButton[w][h];
//        p1 = new JPanel();
//        p2 = new JPanel();
//
//        p1.setLayout(new BorderLayout());
//        p2.setLayout(new GridLayout());

        add(p1 = new JPanel());
        add(p2 = new JPanel(new GridLayout(w,h)));
        for (int i =0 ; i < arrayButton.length; i++){
            for (int j =0; j< arrayButton.length; j++){
                p2.add(arrayButton[i][j] = new JButton());
            }
        }

        this.setLayout(new BorderLayout());


    }


}
