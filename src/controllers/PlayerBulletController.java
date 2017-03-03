package controllers;

import gui.GameWindow;
import model.GameModel;
import model.PlayerBulletModel;
import utils.Utils;
import views.GameView;
import views.PlayerBulletView;

import javax.rmi.CORBA.Util;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by HongUyen on 26-Feb-17.
 */
public class PlayerBulletController extends GameController{


    public PlayerBulletController(PlayerBulletModel model, GameView view) {
        super(model, view);
    }

    public void run()
    {((PlayerBulletModel)model).fly();
    }

//    public PlayerBulletController(int x, int y){
//       this( new PlayerBulletModel(x, y , 13, 30),
//               new PlayerBulletView(Utils.loadImageFromRes("bullet.png")));
//    }


}
