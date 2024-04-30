package Control;

import View.*;

import javax.swing.*;
import java.util.Random;

public class World {
    private ButtonPlay[][] arrayButton;
    private int[][] arrayMin;

    public boolean getArrayBoolean(int i, int j ) {
        return arrayBoolean[i][j];
    }



    private boolean[][] arrayBoolean;
    private boolean isComplete;         //true khi game thua
    private boolean isEnd;              //true khi game thắng
    private Random rd;
    private ButtonSmile buttonSmile;
    private LabelNumber label_time, label_boom;
    private int boom;
//    private boolean isComplete;


    public World(int w, int h, int boom) {
        this.boom = boom;
        arrayButton = new ButtonPlay[w][h];
        arrayMin = new int[w][h];
        arrayBoolean = new boolean[w][h];

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

        if(checkWin()){
            isEnd = true;

            fullTrue();

            return false;
        }
        if(!isComplete && !isEnd) {

            if (!arrayBoolean[i][j]) {                       //nếu arrayBoolean = false - ô chưa mở thì mở arrayBoolean
                if (arrayMin[i][j] == 0) {
                    arrayBoolean[i][j] = true;                //mở arrayBoolean xong thì đổi arrayBoolean thành true
                    arrayButton[i][j].setNumber(0);
                    arrayButton[i][j].repaint();

                    for (int l = i - 1; l <= i + 1; l++) {
                        for (int k = j - 1; k <= j + 1; k++) {
                            if (l >= 0 && l <= arrayMin.length - 1 && k >= 0 && k <= arrayMin[i].length - 1) {
                                if (!arrayBoolean[l][k]) {
                                    open(l, k);

                                }
                            }
                        }
                    }


                } else {
                    arrayBoolean[i][j] = true;
                    int number = arrayMin[i][j];
                    if (number != -1) {                         //mở ra nếu ko phải boom thì mở ra số (return open về true),
                        arrayButton[i][j].setNumber(number);
                        arrayButton[i][j].repaint();

                        return true;

                    }
                }
            }

            if (arrayMin[i][j] == -1) {
                isComplete = false;
                return false;
            } else {                                         //nếu ô đã mở thỉ return open về false (ko mở đc)
//            arrayButton[i][j].repaint();
                return true;
            }
        }else{
            return false;
        }
    }
    public boolean checkWin(){
        int count =0;
        for (int i =0; i <arrayBoolean.length; i++){
            for (int j =0; j<arrayBoolean[i].length; j++) {
                if (arrayBoolean[i][j] == false) {
                    count++;
                }
            }
        }

        if (count == boom){
            return true;
        }else{
            return false;
        }
    }
    public void fullTrue(){
        for(int i=0; i< arrayBoolean.length; i++){
            for(int j = 0; j<arrayBoolean[i].length; j++){
                arrayBoolean[i][j]=true;
            }
        }
    }

//    public void fullFalse(){
//        for(int i=0; i< arrayBoolean.length; i++){
//            for(int j = 0; j<arrayBoolean[i].length; j++){
//            }
//        }
//    }
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

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
}
