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

    //ctor
    public PlayerPlaneController(PlayerPlaneModel model, PlayerPlaneView view) {
        this.model = model;
        this.view = view;
    }
    //ctor  |  set x,y, width, height
    public PlayerPlaneController(int planeX, int planeY) {
        this(new PlayerPlaneModel(planeX,planeY,35,30), new PlayerPlaneView(Utils.loadImageFromRes("plane3.png")) );
    }

    //GETTER model


    public PlayerPlaneModel getModel() {
        return model;
    }

    //move plane
    public void run(int status){
        model.run(status);
    }

    //draw playerPlane
    public void draw(Graphics g){
        view.draw(g, model);
    }

}
