package controllers;

import model.EnemyBulletModel;
import utils.Utils;
import views.EnemyBulletView;

import java.awt.*;

/**
 * Created by HongUyen on 27-Feb-17.
 */
public class EnemyBulletController {
    private EnemyBulletModel model;
    private EnemyBulletView view;

    public EnemyBulletController(EnemyBulletModel model, EnemyBulletView view) {
        this.model = model;
        this.view = view;
    }

    public EnemyBulletController(int x, int y){
        this(new EnemyBulletModel(x,y,9,9), new EnemyBulletView(Utils.loadImageFromRes("bullet-round.png")));
    }

    //GETTER model
    public EnemyBulletModel getModel() {
        return model;
    }

    //shoot bullet
    public void run(int status){
        model.run(1);
    }

    public void draw(Graphics g){
        view.draw(g,model);
    }

}
