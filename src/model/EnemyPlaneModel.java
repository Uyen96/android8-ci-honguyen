package model;

import controllers.EnemyBulletController;

import java.util.ArrayList;

/**
 * Created by HongUyen on 27-Feb-17.
 */
public class EnemyPlaneModel extends GameModel {

    private ArrayList<EnemyBulletController> bullets = new ArrayList<>();
    private static final int SPEED = 2;

    public EnemyPlaneModel(int x, int y, int width, int height) {
        super(x, y , width, height);

    }


    public ArrayList<EnemyBulletController> getBullets() {
        return bullets;
    }

    /**
     *
     * @param status
     * 1 : AUTO
     * 2 : LEFT TO RIGHT
     * 3 : RIGHT TO LEFT
     */
    public void run(int status){
        switch (status){
            case 1 :
                y += SPEED;
                break;

            case 2 :

                break;
        }
    }

    public void addBullet(EnemyBulletController enemyBullet){
        if(y > height) {
            bullets.add(enemyBullet);
        }
    }
}
