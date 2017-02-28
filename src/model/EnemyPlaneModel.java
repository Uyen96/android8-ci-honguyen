package model;

/**
 * Created by HongUyen on 27-Feb-17.
 */
public class EnemyPlaneModel {
    private static final int SPEED = 10;
    private int x;
    private int y;
    private int width;
    private int height;

    public EnemyPlaneModel(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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

    public void run(){
        y += SPEED;
    }
}
