package Viewer;

import javax.swing.*;
import java.awt.*;

public class PanelNotification extends JPanel {
    private GamePanel game;
    private JPanel p11,p12, p13 ;

    private JLabel label_time, label_boom;
    private ButtonSmile btSmile;

    public GamePanel getGame() {
        return game;
    }

    public void setGame(GamePanel game) {
        this.game = game;
    }

    public PanelNotification(GamePanel game){
        this.game = game;
        btSmile = game.getWorld().getButtonSmile();
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLoweredBevelBorder());
        add(p11 = new JPanel(), BorderLayout.WEST);
        add(p12=new JPanel(), BorderLayout.CENTER);
        add(p13 = new JPanel(), BorderLayout.EAST);

        p11.add(label_boom = new JLabel("Number of Booms"));
        p12.add(btSmile = new ButtonSmile(this));
        p13.add(label_time = new JLabel("Time"));

    }

}
