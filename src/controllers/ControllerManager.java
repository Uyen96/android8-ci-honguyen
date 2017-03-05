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
    private Vector<IsLandController> islandControllers;
    private Vector<PlayerBulletController> playerBulletControllers;

    private Vector<EnemyPlaneController> enemyPlaneControllers ;
    private Vector<EnemyBulletController> enemyBulletControllers ;



    public ControllerManager(Vector<IsLandController> islandControllers,
                        Vector<PlayerBulletController> playerBulletControllers,
                             Vector<EnemyPlaneController> enemyPlaneControllers,
                             Vector<EnemyBulletController> enemyBulletControllers) {
        this.islandControllers = islandControllers;
        this.playerBulletControllers = playerBulletControllers;
        this.enemyPlaneControllers = enemyPlaneControllers;
        this.enemyBulletControllers = enemyBulletControllers;
    }

    public void run() {
        synchronized (islandControllers){
            for(IsLandController islandController : islandControllers){
                islandController.run();
            }
        }



        synchronized (playerBulletControllers) {
            for (PlayerBulletController playerBulletController : playerBulletControllers) {
                playerBulletController.run();
            }
        }

        synchronized (enemyPlaneControllers) {
            for (EnemyPlaneController enemyPlaneController : enemyPlaneControllers) {
                enemyPlaneController.run();
            }
        }

        synchronized (enemyBulletControllers) {
            for(EnemyBulletController enemyBulletController : enemyBulletControllers) {
                enemyBulletController.run();
            }
        }
    }

    public void draw(Graphics graphics) {

        synchronized (islandControllers){
            for (IsLandController islandController : islandControllers) {
                islandController.draw(graphics);
            }
        }

        synchronized (playerBulletControllers){
            for (PlayerBulletController playerBulletController : playerBulletControllers) {
                playerBulletController.draw(graphics);
            }
        }

        synchronized (enemyPlaneControllers){
            for(EnemyPlaneController enemyPlaneController : enemyPlaneControllers){
                enemyPlaneController.draw( graphics);
            }
        }

        synchronized (enemyBulletControllers){
            for(EnemyBulletController enemyBulletController : enemyBulletControllers) {
                enemyBulletController.draw(graphics);
            }
        }
    }

}
