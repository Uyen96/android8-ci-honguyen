package controllers;

import gui.GameWindow;

import java.awt.*;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by HongUyen on 03-Mar-17.
 */
public class ControllerManager {
    Vector<GameController> gameControllers;

    private Vector<IsLandController> islandControllers;
    protected Vector<PlayerBulletController> playerBulletControllers;
    private Vector<EnemyPlaneController> enemyPlaneControllers ;
    private Vector<EnemyBulletController> enemyBulletControllers ;


    public ControllerManager(Vector<IsLandController> islandControllers,
                             Vector<PlayerBulletController> playerBulletControlers,
                             Vector<EnemyPlaneController> enemyPlaneControllers,
                             Vector<EnemyBulletController> enemyBulletControllers) {
        this.islandControllers = islandControllers;
        this.playerBulletControllers = playerBulletControllers;
        this.enemyPlaneControllers= enemyPlaneControllers;
        this.enemyBulletControllers = enemyBulletControllers;
    }

    public void run() {
            for(IsLandController islandController : islandControllers){
                islandController.run();
            }

            for (PlayerBulletController playerBulletController : playerBulletControllers) {
                playerBulletController.run();
            }
            if(enemyBulletControllers == null) {
                for (EnemyPlaneController enemyPlaneController : enemyPlaneControllers) {
                    enemyPlaneController.run();
                }
            }
            for(EnemyBulletController enemyBulletController : enemyBulletControllers) {
                enemyBulletController.run();
            }
    }

    public void draw(Graphics graphics) {

            for (IsLandController islandController : islandControllers) {
                islandController.draw(graphics);
            }

            for (PlayerBulletController playerBulletController : playerBulletControllers) {
                playerBulletController.draw(graphics);
            }

            for(EnemyPlaneController enemyPlaneController : enemyPlaneControllers){
                enemyPlaneController.draw( graphics);
            }
            for(EnemyBulletController enemyBulletController : enemyBulletControllers) {
                enemyBulletController.draw(graphics);
            }
    }

}
