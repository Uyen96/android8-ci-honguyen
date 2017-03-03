package controllers;

import model.EnemyBulletModel;
import model.EnemyPlaneModel;
import model.GameModel;
import utils.Utils;
import views.EnemyBulletView;
import views.GameView;

import java.awt.*;

/**
 * Created by HongUyen on 27-Feb-17.
 */
public class EnemyBulletController extends GameController {
    public EnemyBulletController(EnemyPlaneModel model, GameView view) {
        super(model, view);
    }

//
//    public EnemyBulletController(int x, int y){
//        this(new EnemyBulletModel(x,y,9,9), new EnemyBulletView(Utils.loadImageFromRes("bullet-round.png")));
//    }


    //shoot bullet
    public void run(int status)
    {
        ((EnemyBulletModel)model).run(1);
    }


}
