package View;

import Control.World;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Stack;
import javax.swing.*;

import static java.awt.AWTEventMulticaster.add;

public class GamePanel extends JPanel implements MouseListener {
    private Stack<World> ver;
    private PanelNotification p1;
    private PanelPlayer p2;
private World worldTemp;
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
        p1.updateLabelBoom();

        ver= new Stack<>();
        ver.push(world);


    }

    public void resetIUFromWorld(){
        for (int i = 0; i < world.getArrayButton().length; i++) {
            for (int j = 0; j < world.getArrayButton()[i].length; j++) {

                world.getArrayButton()[i][j].setNumber(-2);
                world.getArrayButton()[i][j].repaint();
                }

            }
        }

    public void updateUIFromWorld() {
        ButtonPlay[][] arrayButton = p2.getArrayButton();
        boolean[][] arrayBoolean = world.getArrayBoolean();
        boolean[][] arrayFlag = world.getArrayFlag();
        int[][] arrayMin = world.getArrayMin();

        for (int i = 0; i < arrayButton.length; i++) {
            for (int j = 0; j < arrayButton[i].length; j++) {
                if((worldTemp.getArrayBoolean()[i][j] != arrayBoolean[i][j]) || (worldTemp.getArrayFlag()[i][j] != arrayFlag[i][j])){
                    world = worldTemp.deepCopy();
                    if(worldTemp.getArrayFlag()[i][j]){
                        arrayFlag[i][j] = true;
                        arrayBoolean[i][j] = false;
                        arrayButton[i][j].setNumber(11);
                        arrayButton[i][j].repaint();
                    }else{
                        arrayFlag[i][j] = false;
                        arrayBoolean[i][j] = false;
                        arrayButton[i][j].setNumber(-2);
                        arrayButton[i][j].repaint();
                    }
                }
            }
        }
        // Cập nhật thông báo số bom còn lại
        p1.updateLabelBoom();
    }

    public void undo() {
        if (ver.size() > 2) { // Ensure there's a previous state to undo to
            ver.pop(); // Remove the current state
            worldTemp = ver.peek().deepCopy();
            System.out.println("\nPop world");
            System.out.println("ver = "+ver+ "  ver.peek() = "+ver.peek());
            System.out.println("ver.peek() = "+Arrays.deepToString(ver.peek().getArrayBoolean()));

            updateUIFromWorld();
        }
        else{
            resetIUFromWorld();
        }
    }
    public void pushVer(World w) {
        World newWorld = w.deepCopy();
        worldTemp = ver.peek().deepCopy();
        System.out.println("\nPush world");
        ver.push(newWorld);
        System.out.println("ver = " + ver);
        System.out.println("ver.peek().getArrayBoolean()");
        System.out.print(Arrays.deepToString(ver.peek().getArrayBoolean()));

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
        ButtonSmile smile = p1.getBtSmile();


        if (e.getButton() == 1 && e.getSource() == smile) {
            gameFrame.dispose();
            new GameFrame(w, h, boom);
        } else {
            for (int i = 0; i < arrayButton.length; i++) {
                for (int j = 0; j < arrayButton[i].length; j++) {

                    if (e.getButton() == 1 && e.getSource() == arrayButton[i][j]) {
                        if (!world.getArrayFlag()[i][j]) {                 //nếu ko có cờ thì mở ô
                            if (!world.open(i, j)) {                  //nếu open = false. thì hiện thông báo

                                if (!world.isComplete()) {           // chưa win (complete = false)
//                                p1.resetLabelBoom();
//                                System.out.println("reset label boom");
                                    int option = JOptionPane.showConfirmDialog(this, "You lost. Play again?", "Notification", JOptionPane.YES_NO_OPTION);
                                    if (option == JOptionPane.YES_OPTION) {
                                        gameFrame.setVisible(false);
                                        new GameFrame(w, h, boom);
                                    } else {                               // nếu không chọn chơi lại thì arrayBoolean = full true ->
                                        world.fullTrue();
                                        world.setComplete(true);

                                    }
                                } else                               //win - complete = true
//                                if(world.isEnd())
                                {
//                                p1.resetLabelBoom();
//                                System.out.println("reset label boom");
                                    int option = JOptionPane.showConfirmDialog(this, "You Win. Play again?", "Notification", JOptionPane.YES_NO_OPTION);
                                    if (option == JOptionPane.YES_OPTION) {
                                        gameFrame.setVisible(false);
                                        new GameFrame(w, h, boom);
                                    }

                                }
                            } else {
//                            p1.setFlag(world.getFlag());
//                            p1.updateLabelBoom();
                            }

                        } else {
                            world.flagDown(i, j);
                            p1.updateLabelBoom();

                        }


                    }
                    if (e.getButton() == 3 && e.getSource() == arrayButton[i][j]) {
                        if (world.getFlag() < world.getBoom()) {
                            world.flagUp(i, j);
//                        world.setFlag(world.getFlag()+1);
                            p1.updateLabelBoom();
                        }

                    }

                    if (e.getClickCount() == 2 && e.getSource() == arrayButton[i][j]) {
                        System.out.println(i + "   " + j);

                        if (world.openAround(i, j)) {


                            System.out.println("openAround = " + world.openAround(i, j) + "; isComplete = " + world.isComplete());
                            boolean open = true;
                            for (int l = i - 1; l <= i + 1; l++) {
                                for (int k = j - 1; k <= j + 1; k++) {
                                    if (l >= 0 && l <= world.getArrayMin().length - 1 && k >= 0 && k <= world.getArrayMin()[i].length - 1) {
                                        if ((!world.getArrayBoolean()[l][k]) && (!world.getArrayFlag()[l][k])) {
                                            if (!world.open(l, k)) {
                                                open = false;
                                                world.getArrayFlag()[l][k] = false;
                                                p1.resetLabelBoom();
                                                System.out.println("reset label boom");

                                                if (!world.isComplete()) {           // chưa win (complete = false)

                                                    int option = JOptionPane.showConfirmDialog(this, "You lost. Play again?", "Notification", JOptionPane.YES_NO_OPTION);
                                                    if (option == JOptionPane.YES_OPTION) {
                                                        gameFrame.setVisible(false);
                                                        new GameFrame(w, h, boom);
                                                    } else {                               // nếu không chọn chơi lại thì arrayBoolean = full true ->
                                                        world.fullTrue();
                                                        world.setComplete(true);

                                                    }
                                                } else                               //win - complete = true

                                                {

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
//                        if(!open){
//                            p1.resetLabelBoom();
//                            System.out.println("reset label boom");
//                        }


                            }


                            if ((!world.openAround(i, j)) || (!world.open(i, j))) {                  //nếu openaround = false. thì hiện thông báo
//                        System.out.println("openAround = "+ world.openAround(i, j)+ "; isComplete = "+world.isComplete());
                                if (!world.isComplete()) {           // chưa win (complete = false)
//                            p1.resetLabelBoom();
//                            System.out.println("reset label boom");
                                    int option = JOptionPane.showConfirmDialog(this, "You lost. Play again?", "Notification", JOptionPane.YES_NO_OPTION);
                                    if (option == JOptionPane.YES_OPTION) {
                                        gameFrame.setVisible(false);
                                        new GameFrame(w, h, boom);
                                    } else {                               // nếu không chọn chơi lại thì arrayBoolean = full true ->
                                        world.fullTrue();
                                        world.setComplete(true);

                                    }
                                } else                               //win - complete = true
//                                if(world.isEnd())
                                {
//                            p1.resetLabelBoom();
//                            System.out.println("reset label boom");
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
            pushVer(world);


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
