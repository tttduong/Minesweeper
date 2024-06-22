/*
Name: Tạ Thị Thùy Dương
IU Code: ITCSIU21053
Purpose: contains ButtonPlay objects and references GamePanel.
*/
package View;

import javax.swing.*;
import java.awt.*;
import View.ButtonPlay;

public class PanelPlayer extends JPanel {
    private GamePanel game;
    private ButtonPlay[][] arrayButton;

    public PanelPlayer(GamePanel game){
        this.game = game;
        arrayButton = game.getWorld().getArrayButton();

        setBorder(BorderFactory.createLoweredBevelBorder());
        setLayout(new GridLayout(game.getW(), game.getH()));


        for (int i =0 ; i < arrayButton.length; i++){
            for (int j =0; j< arrayButton.length; j++){
                add(arrayButton[i][j] = new ButtonPlay(this));
                arrayButton[i][j].addMouseListener(game);
            }
        }
    }
    public GamePanel getGame() {
        return game;
    }

    public void setGame(GamePanel game) {
        this.game = game;
    }
    public ButtonPlay[][] getArrayButton() {
        return arrayButton;
    }

    public void setArrayButton(ButtonPlay[][] arrayButton) {
        this.arrayButton = arrayButton;
    }
}
