package model;

import controllers.EnemyBulletController;
import gui.GameWindow;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by HongUyen on 27-Feb-17.
 */
public class EnemyPlaneModel extends GameModel {
    public static final int SPEED = 5;
    public static final int DEFAULT_WIDTH = 70;
    public static final int DEFAULT_HEIGHT = 60;
    private int time_delay_shoot = 2500;

    private int time_shoot = 0;

    private Vector<EnemyBulletController> enemyBulletControllers = new Vector<>();


    public EnemyPlaneModel(int x, int y, int width, int height) {
        super(x, y , width, height);

    }
    public void flyDown(){
        y += SPEED;
    }


    public Vector<EnemyBulletController> getEnemyBulletControllers() {
        return enemyBulletControllers;
    }

    public void increaseTimeShoot(){
        time_shoot += GameWindow.TIME_GAME_LOOP;
    }

    public boolean shoot(){
        time_shoot += GameWindow.TIME_GAME_LOOP;
        if(time_shoot>= time_delay_shoot){
            time_shoot = 0;
            return  true;
        }
        return false;
    }

}
