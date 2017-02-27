package controllers;

import model.PlayerBulletModel;
import utils.Utils;
import views.PlayerBulletView;

import javax.rmi.CORBA.Util;
import java.awt.*;

/**
 * Created by HongUyen on 26-Feb-17.
 */
public class PlayerBulletController {
    private PlayerBulletModel model;
    private PlayerBulletView view;

    public PlayerBulletController(PlayerBulletModel model, PlayerBulletView view) {
        this.model = model;
        this.view = view;
    }

    public void run(){
        model.fly();
    }

    public PlayerBulletController(int x, int y){
       this( new PlayerBulletModel(x, y ,13,30), new PlayerBulletView(Utils.loadImageFromRes("plane3.png")));
    }
    public void draw(Graphics graphics){
        view.draw(graphics, model);
    }
}
