package model;

import gui.GameWindow;

/**
 * Created by HongUyen on 27-Feb-17.
 */
public class BackGroundModel {
    private int x;
    private int y;
    private int width = GameWindow.getWIDTH();
    private int heigh = GameWindow.getHEIGHT();
    private static final int SPEED = 10;


    public BackGroundModel(int width, int height) {
        this.x = x;
        this.y = y;
//        this.width = width;
//        this.heigh = height;

    }

    public BackGroundModel() {

    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeigh() {
        return heigh;
    }

    public int getWidth() {
        return width;
    }

    public void run(){
        y += SPEED;
    }
}
