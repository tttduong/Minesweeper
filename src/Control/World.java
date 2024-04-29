package Control;

import View.ButtonPlay;
import View.ButtonSmile;
import View.LabelNumber;

import javax.swing.*;
import java.util.Random;

public class World {
    private ButtonPlay[][] arrayButton;
    private int[][] arrayMin;
    private Random rd;
    private ButtonSmile buttonSmile;



    private LabelNumber label_time, label_boom;
    public World(int w, int h, int boom) {
        arrayButton = new ButtonPlay[w][h];
        arrayMin = new int[w][h];
        rd = new Random();

        createArrayMin(boom, w, h);
        fillNumber();

        for(int i=0; i<arrayMin.length; i++){
            for(int j = 0; j<arrayMin[i].length; j++){
                System.out.print(arrayMin[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }

    }

    public boolean open(int i, int j){
        int number = arrayMin[i][j];
//        System.out.println(number);
        if(number != -1) {
            arrayButton[i][j].setNumber(number);
            arrayButton[i][j].repaint();
            return true;
        }else{
            arrayButton[i][j].repaint();
            return false;
        }
    }
    public void fillNumber(){
        for(int i = 0; i< arrayMin.length; i++){
            for (int j =0; j < arrayMin[i].length; j++){
                if(arrayMin[i][j] ==0 ) {
                    int count = 0;
                    for (int l = i - 1; l <= i + 1; l++) {
                        for (int k = j - 1; k <= j + 1; k++) {
                           if (l >= 0 && l <= arrayMin.length - 1 && k >= 0 && k <= arrayMin[i].length - 1) {
                                if (arrayMin[l][k] == -1) {
                                    count++;
                                }
                                                          }

                        }
                        arrayMin[i][j] = count;
                    }
                }

            }
        }
    }
    public void createArrayMin(int boom, int w, int h){
    int locationX = rd.nextInt(w);
    int locationY = rd.nextInt(h);

    arrayMin[locationX][locationY] = -1;

    int count = 1;

    while (count != boom){
        locationX = rd.nextInt(w);
        locationY = rd.nextInt(h);

        if(arrayMin[locationX][locationY] != -1){
            arrayMin[locationX][locationY] = -1;
            count = 0;
            for(int i=0; i<arrayMin.length; i++){
                for(int j = 0; j<arrayMin.length; j++){
                    if(arrayMin[i][j] == -1){
                        count++;
                    }
                }
            }
        }
    }

    }

    public LabelNumber getLabel_time() {
        return label_time;
    }

    public void setLabel_time(LabelNumber label_time) {
        this.label_time = label_time;
    }

    public LabelNumber getLabel_boom() {
        return label_boom;
    }

    public void setLabel_boom(LabelNumber label_boom) {
        this.label_boom = label_boom;
    }




    public ButtonSmile getButtonSmile() {
        return buttonSmile;
    }

    public void setButtonSmile(ButtonSmile buttonSmile) {
        this.buttonSmile = buttonSmile;
    }

    public ButtonPlay[][] getArrayButton() {
        return arrayButton;
    }

    public void setArrayButton(ButtonPlay[][] arrayButton) {
        this.arrayButton = arrayButton;
    }




}
