package model;

/**
 * Created by HongUyen on 27-Feb-17.
 */
public class EnemyBulletModel extends GameModel{
    private static final  int SPEED = 10;
    public static final int WIDTH = 30;
    public static final int HEIGHT = 30;

    public EnemyBulletModel(int x, int y, int width, int height) {
        super(x, y ,width, height);

    }



    public void flyDown(){
         y += SPEED;

    }

}
