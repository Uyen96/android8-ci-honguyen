package controllers;

import gui.GameWindow;
import model.PlayerBulletModel;
import utils.Utils;
import views.PlayerBulletView;

import javax.rmi.CORBA.Util;
import java.awt.*;
import java.util.ArrayList;

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

    public PlayerBulletModel getModel() {
        return model;
    }

    public PlayerBulletView getView() {
        return view;
    }

    public void run(){
        model.fly();
    }

    public PlayerBulletController(int x, int y){
       this( new PlayerBulletModel(x, y , GameWindow.WIDTH,GameWindow.HEIGHT),
               new PlayerBulletView(Utils.loadImageFromRes("bullet.png")));
    }
    public void draw(Graphics graphics){
        view.draw(graphics, model);
    }

}
