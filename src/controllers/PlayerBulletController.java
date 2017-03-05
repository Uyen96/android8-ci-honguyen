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
    public static final int DEFAULT_WIDTH = 13;
    public static final int DEFAULT_HEIGHT = 30;
    public static final int DEFAULT_HAFT_WIDTH = DEFAULT_WIDTH/2;

    public PlayerBulletController(PlayerBulletModel model, GameView view) {
        super(model, view);
    }

    public void run()
    {((PlayerBulletModel)model).fly();
    }

    public PlayerBulletController(int x, int y){
       this( new PlayerBulletModel(x, y , DEFAULT_WIDTH, DEFAULT_HEIGHT),
               new PlayerBulletView(Utils.loadImageFromRes("bullet.png")));
    }


}
