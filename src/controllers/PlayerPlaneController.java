package controllers;

import model.PlayerPlaneModel;
import utils.Utils;
import views.PlayerPlaneView;

import java.awt.*;

/**
 * Created by HongUyen on 26-Feb-17.
 */
public class PlayerPlaneController {
    private PlayerPlaneModel model;
    private PlayerPlaneView view;

    public PlayerPlaneController(PlayerPlaneModel playerPlaneModel, PlayerPlaneView playerPlaneView) {
        this.model = playerPlaneModel;
        this.view = playerPlaneView;
    }

    public PlayerPlaneController(int x, int y, int w, int h){
        this(new PlayerPlaneModel(x,y,w,h),
                new PlayerPlaneView(Utils.loadImageFromRes("plane3.png")));
    }

    public PlayerPlaneModel getModel() {
        return model;
    }

    public PlayerPlaneView getView() {
        return view;
    }

    public void draw(Graphics g){
        view.draw(g, model);
    }
//
//    public void run(){
//        model.run(model);
//    }
}
