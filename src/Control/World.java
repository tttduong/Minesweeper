package Control;

import Viewer.ButtonSmile;

import javax.swing.*;

public class World {
    private JButton[][] arrayButton;
    private ButtonSmile buttonSmile;
    public World(int w, int h, int boom) {
        arrayButton = new JButton[w][h];
    }





    public ButtonSmile getButtonSmile() {
        return buttonSmile;
    }

    public void setButtonSmile(ButtonSmile buttonSmile) {
        this.buttonSmile = buttonSmile;
    }

    public JButton[][] getArrayButton() {
        return arrayButton;
    }

    public void setArrayButton(JButton[][] arrayButton) {
        this.arrayButton = arrayButton;
    }




}
