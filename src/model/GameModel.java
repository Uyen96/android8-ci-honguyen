package model;

import java.awt.*;

/**
 * Created by HongUyen on 03-Mar-17.
 */
public class GameModel {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean isExist;

    public GameModel(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }


    public Rectangle getRectangle() {
        return new Rectangle(x, y, width, height);
    }
    public boolean checkContact(GameModel otherGameModel){
        Rectangle r1 = new Rectangle(x, y , width, height);
        Rectangle r2 = new Rectangle(otherGameModel.x, otherGameModel.y, otherGameModel.width, otherGameModel.height);
        return r1.intersects(r2);

    }

    public  int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public  int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getMidX(){
        return (double)(x+width/2);
    }

    public double getMidY(){
        return (double) (y+height/2);
    }
    public boolean isExist() {
        return isExist;
    }

    public void setExist(boolean exist) {
        isExist = exist;
    }



}
