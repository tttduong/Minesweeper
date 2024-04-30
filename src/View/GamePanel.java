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
    private int boom;
    private GameFrame gameFrame;
//    private JButton[][] arrayButton;

    public GamePanel (int w, int h, int boom, GameFrame gameFrame){
        this.w = w;
        this.h = h ;
        this.boom = boom;
        this.gameFrame = gameFrame ;

        world = new World(w,h,boom);
        setLayout(new BorderLayout(10,10));
        add(p1 = new PanelNotification(this), BorderLayout.NORTH);
        add(p2 = new PanelPlayer(this), BorderLayout.CENTER);


    }

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

    public GameFrame getGameFrame() {
        return gameFrame;
    }

    public void setGameFrame(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        ButtonPlay[][] arrayButton = p2.getArrayButton();


        for (int i = 0; i < arrayButton.length ; i++){
            for(int j =0; j < arrayButton[i].length ; j++){

                if (e.getButton() == 1 && e.getSource() == arrayButton[i][j]){

                        if (!world.open(i, j)) {                  //nếu open = false. thì hỏi chơi lại
                            if(world.isComplete()) {
                                int option = JOptionPane.showConfirmDialog(this, "You lost. Play again?", "Notification", JOptionPane.YES_NO_OPTION);
                                if (option == JOptionPane.YES_OPTION) {
                                    gameFrame.setVisible(false);
                                    new GameFrame(w, h, boom);
                                } else {                               // nếu không chọn chơi lại thì arrayBoolean = full true ->
                                    world.fullTrue();
                                }
                            }else if(world.isEnd()){
                                int option = JOptionPane.showConfirmDialog(this, "You Win. Play again?", "Notification", JOptionPane.YES_NO_OPTION);
                                if (option == JOptionPane.YES_OPTION) {
                                    gameFrame.setVisible(false);
                                    new GameFrame(w, h, boom);
                                }

                            }
                        }

                }
            }
        }

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
