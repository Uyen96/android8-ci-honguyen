package model;

/**
 * Created by HongUyen on 27-Feb-17.
 */
public class EnemyBulletModel extends GameModel{
    private static int SPEED = 4;

    public EnemyBulletModel(int x, int y, int width, int height) {
        super(x, y ,width, height);

    }



    public void run(int status){
        switch (status){
            case 1 :
                x += SPEED;
                break;

            case 2 :
                y += SPEED;
                x += SPEED/3;
                break;

            case 3 :
                y += SPEED;
                x -= SPEED;
                break;
        }
    }

}
