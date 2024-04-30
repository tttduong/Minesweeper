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

    public GameFrame (int w,int h,int boom){
        loadData = new LoadData();

        add(gamePanel= new GamePanel(w,h,boom, this));
        setResizable(false);
        setIconImage(loadData.getListImage().get("title"));
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

//    public static void main(String[] args) {
////        try{
////            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
////        }catch(Exception ex){
////            ex.printStackTrace();
////        }
//        new GameFrame(9, 9, 10);
//    }

}
