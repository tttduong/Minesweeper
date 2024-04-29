package View;

import javax.swing.*;
import java.awt.*;

public class PanelPlayer extends JPanel {
    public GamePanel getGame() {
        return game;
    }

    public void setGame(GamePanel game) {
        this.game = game;
    }

    private GamePanel game;

    public PanelPlayer(GamePanel game){
        this.game = game;


        setBorder(BorderFactory.createLoweredBevelBorder());
        setLayout(new GridLayout(game.getW(), game.getH()));
        JButton[][] arrayButton = game.getWorld().getArrayButton();

        for (int i =0 ; i < arrayButton.length; i++){
            for (int j =0; j< arrayButton.length; j++){
                add(arrayButton[i][j] = new ButtonPlay(this));

            }
        }



    }
}
