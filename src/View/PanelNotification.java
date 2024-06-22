/*
Name: Tạ Thị Thùy Dương
IU Code: ITCSIU21053
Purpose: updates and resets mine counts, interacts with ButtonSmile and GamePanel.
*/

package View;

import javax.swing.*;
import java.awt.*;

public class PanelNotification extends JPanel {
    private GamePanel game;
    private JPanel p11,p12, p13 ;

    private LabelNumber label_time, label_boom;

    public ButtonSmile getBtSmile() {
        return btSmile;
    }

    public void setBtSmile(ButtonSmile btSmile) {
        this.btSmile = btSmile;
    }

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
        label_boom = game.getWorld().getLabel_boom();
        label_time = game.getWorld().getLabel_time();

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLoweredBevelBorder());
        add(p11 = new JPanel(), BorderLayout.WEST);
        add(p12=new JPanel(), BorderLayout.CENTER);
        add(p13 = new JPanel(), BorderLayout.EAST);

        p11.add(label_boom = new LabelNumber(this,"000"));
        p12.add(btSmile = new ButtonSmile(this));
        p13.add(label_time = new LabelNumber(this, "000"));

        btSmile.addMouseListener(game);

    }
    public void updateLabelBoom(){
        boolean[][] currentArrayFlag = new boolean[game.getWorld().getArrayFlag().length][];
        for (int i = 0; i < currentArrayFlag.length; i++) {
            currentArrayFlag[i] = game.getWorld().getArrayFlag()[i].clone();
        }

        int flag = 0;
        for (int i = 0; i < currentArrayFlag.length; i++) {
            for (int j = 0; j < currentArrayFlag[i].length; j++) {
                if (currentArrayFlag[i][j]){
                flag++;
                }
            }
        }

        int num_boom = game.getWorld().getBoom() - flag ;
        String boom = String.valueOf(num_boom);

        label_boom.setNumber(boom);

        label_boom.repaint();

    }
    public void resetLabelBoom(){
        int num_boom = game.getWorld().getBoom();
        String boom = String.valueOf(num_boom);

        label_boom.setNumber(boom);

        label_boom.repaint();

    }
    public int getFlag() {
        return game.getWorld().getFlag();
    }

    public void setFlag(int flag) {
        game.getWorld().setFlag(flag);

    }

}
