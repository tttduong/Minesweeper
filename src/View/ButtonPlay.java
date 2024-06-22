/*
Name: Tạ Thị Thùy Dương
IU Code: ITCSIU21053
Purpose: manages game button graphics and state.
*/

package View;

import javax.swing.*;
import java.awt.*;

public class ButtonPlay extends JButton {
    private PanelPlayer player_panel;
    private int number;



    public ButtonPlay(PanelPlayer player_panel){
        number = -2;
        this.player_panel =player_panel;
        setPreferredSize(new Dimension(30,30));
    }

    public void setNumber(int number){
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
    @Override
    public void paint(Graphics g){
        switch (number){
            case -2:
                g.drawImage(player_panel.getGame().getGameFrame().getLoadData().getListImage().get("nouse"),
                        0,0,getPreferredSize().width,getPreferredSize().height,null);

                break;
            case -1:
                g.drawImage(player_panel.getGame().getGameFrame().getLoadData().getListImage().get("boom"),
                        0,0,getPreferredSize().width,getPreferredSize().height,null);

                break;
            case 0:
                g.drawImage(player_panel.getGame().getGameFrame().getLoadData().getListImage().get("b0"),
                        0,0,getPreferredSize().width,getPreferredSize().height,null);

                break;
            case 1:
                g.drawImage(player_panel.getGame().getGameFrame().getLoadData().getListImage().get("b1"),
                        0,0,getPreferredSize().width,getPreferredSize().height,null);
                break;
            case 2:
                g.drawImage(player_panel.getGame().getGameFrame().getLoadData().getListImage().get("b2"),
                        0,0,getPreferredSize().width,getPreferredSize().height,null);
                break;
            case 3:
                g.drawImage(player_panel.getGame().getGameFrame().getLoadData().getListImage().get("b3"),
                        0,0,getPreferredSize().width,getPreferredSize().height,null);
                break;
            case 4:
                g.drawImage(player_panel.getGame().getGameFrame().getLoadData().getListImage().get("b4"),
                        0,0,getPreferredSize().width,getPreferredSize().height,null);
                break;
            case 5:
                g.drawImage(player_panel.getGame().getGameFrame().getLoadData().getListImage().get("b5"),
                        0,0,getPreferredSize().width,getPreferredSize().height,null);
                break;
            case 6:
                g.drawImage(player_panel.getGame().getGameFrame().getLoadData().getListImage().get("b6"),
                        0,0,getPreferredSize().width,getPreferredSize().height,null);
                break;
            case 7:
                g.drawImage(player_panel.getGame().getGameFrame().getLoadData().getListImage().get("b7"),
                        0,0,getPreferredSize().width,getPreferredSize().height,null);
                break;
            case 8:
                g.drawImage(player_panel.getGame().getGameFrame().getLoadData().getListImage().get("b8"),
                        0,0,getPreferredSize().width,getPreferredSize().height,null);
                break;
            case 9:
                g.drawImage(player_panel.getGame().getGameFrame().getLoadData().getListImage().get("boomRed"),
                        0,0,getPreferredSize().width,getPreferredSize().height,null);
                break;
            case 10:
                g.drawImage(player_panel.getGame().getGameFrame().getLoadData().getListImage().get("boomX"),
                        0,0,getPreferredSize().width,getPreferredSize().height,null);
                break;

            case 11:
                g.drawImage(player_panel.getGame().getGameFrame().getLoadData().getListImage().get("flag"),
                        0,0,getPreferredSize().width,getPreferredSize().height,null);
                break;
        }


    }

}
