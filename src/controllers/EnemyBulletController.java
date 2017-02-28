package controllers;

import model.EnemyBulletModel;
import views.EnemyBulletView;

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

    public void run(){
        model.run();
    }
}
