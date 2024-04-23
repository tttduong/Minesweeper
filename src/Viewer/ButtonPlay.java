package Viewer;

import javax.swing.*;
import java.awt.*;

public class ButtonPlay extends JButton {
    private PanelPlayer player_panel;
    public ButtonPlay(PanelPlayer player_panel){
        this.player_panel =player_panel;
        setPreferredSize(new Dimension(30,30));
    }

    @Override
    public void paint(Graphics g){
        g.drawImage(player_panel.getGame().getGameFrame().getLoadData().getListImage().get("nouse"),
                0,0,getPreferredSize().width,getPreferredSize().height,null);

    }

}
