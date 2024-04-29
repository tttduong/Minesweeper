package View;

import Control.World;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

import static java.awt.AWTEventMulticaster.add;

public class GamePanel extends JPanel implements MouseListener {
    private PanelNotification p1;
    private PanelPlayer p2;

    private World world;
    private int w;
    private int h;

    public GamePanel (int w, int h, int boom, GameFrame gameFrame){
        this.w = w;
        this.h = h ;
        this.gameFrame = gameFrame ;

        world = new World(w,h,boom);
        setLayout(new BorderLayout(10,10));
        add(p1 = new PanelNotification(this), BorderLayout.NORTH);
        add(p2 = new PanelPlayer(this), BorderLayout.CENTER);


    }

    public GameFrame getGameFrame() {
        return gameFrame;
    }

    public void setGameFrame(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    private GameFrame gameFrame;
    private JButton[][] arrayButton;

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
