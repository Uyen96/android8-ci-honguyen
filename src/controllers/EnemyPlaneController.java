package controllers;

import model.EnemyPlaneModel;
import views.EnemyPlaneView;

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

    public void run(){
        model.run();
    }
}
