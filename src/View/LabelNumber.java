package View;

import javax.swing.*;
import java.awt.*;

public class LabelNumber extends JLabel {

    private PanelNotification p ;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    private String number;
    public LabelNumber (PanelNotification p, String number){
        this.p = p;
        this.number = number;
        setPreferredSize(new Dimension(78,46));
    }
    @Override
    public void paint(Graphics g){
        if(number.length() == 1){
            number = "00"+number;
        } else if (number.length()==2) {
            number = "0"+number;
        }
        g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get(String.valueOf(number.charAt(0))),0,0,26,46, null);
        g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get(String.valueOf(number.charAt(1))),26,0,26,46, null);
        g.drawImage(p.getGame().getGameFrame().getLoadData().getListImage().get(String.valueOf(number.charAt(2))),52,0,26,46, null);


    }
}
