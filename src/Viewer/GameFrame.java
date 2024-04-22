package Viewer;

import Model.LoadData;

import javax.swing.*;

public class GameFrame extends JFrame {
    LoadData loadData = new LoadData();

    public GameFrame (){
        loadData = new LoadData();
        setIconImage(loadData.getListImage().get("title"));
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
