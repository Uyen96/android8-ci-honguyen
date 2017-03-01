package controllers;

import model.EnemyPlaneModel;
import utils.Utils;
import views.EnemyPlaneView;

import java.awt.*;
import java.util.Random;

/**
 * Created by HongUyen on 27-Feb-17.
 */
public class EnemyPlaneController {
    private EnemyPlaneModel model;
    private EnemyPlaneView view;

    public EnemyPlaneController(EnemyPlaneModel model, EnemyPlaneView view) {
        this.model = model;
        this.view = view;
    }

    public EnemyPlaneController(int x, int y, Image img){
        this(new EnemyPlaneModel(x,y,30,30),new EnemyPlaneView(img));
    }

    //GETTER model
    public EnemyPlaneModel getModel() {
        return model;
    }

    //move enemy
    public void run(int status){
        model.run(status);
    }

    //auto shoot enemy
    public void addBullet(EnemyBulletController bullet){
        model.addBullet(bullet);
    }

    public void draw(Graphics g){
        view.draw(g, model);
    }
}
