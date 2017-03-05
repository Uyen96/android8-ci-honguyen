package controllers;

import model.EnemyBulletModel;
import model.EnemyPlaneModel;
import model.GameModel;
import utils.Utils;
import views.EnemyPlaneView;
import views.GameView;

import java.awt.*;
import java.util.Random;
import java.util.Vector;

/**
 * Created by HongUyen on 27-Feb-17.
 */
public class EnemyPlaneController extends GameController {
    Vector<EnemyBulletController> enemyBulletControllers;

    public EnemyPlaneController(EnemyPlaneModel model, GameView view,
                                Vector <EnemyBulletController> enemyBulletControllers) {
        super(model, view);
        this.enemyBulletControllers = enemyBulletControllers;
    }
     public EnemyPlaneController (int x, int y,  Vector<EnemyBulletController> enemyBulletController){
        this( new EnemyPlaneModel(x, y, EnemyPlaneModel.DEFAULT_WIDTH, EnemyPlaneModel.DEFAULT_HEIGHT),
                new EnemyPlaneView(Utils.loadImageFromRes("plane1.png")),
                enemyBulletController);
     }



    public void run(){

        ((EnemyPlaneModel) model).flyDown();
          shoot();
    }

    public void shoot(){

                EnemyBulletController enemyBulletController = new EnemyBulletController(
                        (int)model.getMidX()- EnemyBulletModel.WIDTH/2,
                        model.getY() + EnemyBulletModel.HEIGHT );
                enemyBulletControllers.add(enemyBulletController);

    }

}
