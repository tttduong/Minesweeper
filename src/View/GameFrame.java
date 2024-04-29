package View;

import Model.LoadData;

import javax.swing.*;

public class GameFrame extends JFrame {
    private LoadData loadData ;
    private GamePanel gamePanel ;

    public LoadData getLoadData() {
        return loadData;
    }

    public void setLoadData(LoadData loadData) {
        this.loadData = loadData;
    }

    public GameFrame (){
        loadData = new LoadData();

        add(gamePanel= new GamePanel(9,9,10, this));
        setResizable(false);
        setIconImage(loadData.getListImage().get("title"));
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
