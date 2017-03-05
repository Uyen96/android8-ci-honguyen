package controllers;

import model.EnemyBulletModel;
import model.EnemyPlaneModel;
import model.GameModel;
import model.PlayerBulletModel;
import utils.Utils;
import views.EnemyBulletView;
import views.GameView;
import views.PlayerBulletView;

import java.awt.*;

/**
 * Created by HongUyen on 27-Feb-17.
 */
public class EnemyBulletController extends GameController {
    public EnemyBulletController(EnemyBulletModel model, GameView view)
    {
        super(model, view);
    }


    public void run()
    {
        ((EnemyBulletModel)model).flyDown();
    }

    public EnemyBulletController(int x, int y){
        this( new EnemyBulletModel(x, y, 30,30),
                new EnemyBulletView(Utils.loadImageFromRes("enemy_bullet.png")));
    }


}
