package model;

/**
 * Created by HongUyen on 26-Feb-17.
 */
public class PlayerBulletModel extends GameModel{
    public static final int SPEED = 5;
    public static final int WIDTH = 6;
    public static final int HEIGHT = 16;


    public PlayerBulletModel(int x, int y, int width, int height) {
       super(x, y, width, height);
    }


    public void fly(){
        y -= SPEED;
    }
}
