package Viewer;

import Model.LoadData;

import javax.swing.*;

public class GameFrame extends JFrame {
    LoadData loadData = new LoadData();
GamePanel gamePanel ;
    public GameFrame (){
        loadData = new LoadData();

        add(gamePanel= new GamePanel(9,9,10));

        setIconImage(loadData.getListImage().get("title"));
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
