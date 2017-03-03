package controllers;

import model.EnemyPlaneModel;
import model.GameModel;
import utils.Utils;
import views.EnemyPlaneView;
import views.GameView;

import java.awt.*;
import java.util.Random;

/**
 * Created by HongUyen on 27-Feb-17.
 */
public class EnemyPlaneController extends GameController {


    public EnemyPlaneController(EnemyPlaneModel model, GameView view) {
        super(model, view);
    }

    //move enemy
    public void run(int status){

        ((EnemyPlaneModel)model).run(status);
    }

    //auto shoot enemy
    public void addBullet(EnemyBulletController bullet)
    {
        ((EnemyPlaneModel)model).addBullet(bullet);
    }

}
