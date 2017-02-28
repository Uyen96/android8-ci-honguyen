package model;

/**
 * Created by HongUyen on 26-Feb-17.
 */
public class PlayerPlaneModel {
    private static final int SPEED = 50;
    private int x;
    private int y;
    private int width;
    private int height;

    public PlayerPlaneModel(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public static int getSPEED() {
        return SPEED;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public void moveLeft(){
        x -= SPEED;
    }

    public void moveRight(){
        x += SPEED;
    }
    public void moveUp(){
        y -= SPEED;
    }
    public void moveDown(){
        y += SPEED;
    }
//    public void run(int n){
//        switch (n){
//            case 1 : {
//                x += SPEED;
//                break;
//            }
//            case 2 :
//                x -= SPEED;
//                break;
//            case 3 :
//                y -= SPEED;
//                break;
//            case 4 :
//                y += SPEED;
//                break;
//        }
//    }




}
