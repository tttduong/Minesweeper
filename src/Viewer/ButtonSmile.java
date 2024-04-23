package Viewer;

import javax.swing.*;
import java.awt.*;
public class ButtonSmile extends JButton {
//    public JButton getButton_smile() {
//        return button_smile;
//    }
//
//    public void setButton_smile(JButton button_smile) {
//        this.button_smile = button_smile;
//    }

    private JButton button_smile;
    private PanelNotification noti_panel;
    public ButtonSmile(PanelNotification noti_panel){
        this.noti_panel = noti_panel;
        setPreferredSize(new Dimension(50,50));

    }
    @Override
    public void paint(Graphics g){
        g.drawImage(noti_panel.getGame().getGameFrame().getLoadData().getListImage().get("smile"),
                0,0,getWidth(), getHeight(), null);
    }
}
