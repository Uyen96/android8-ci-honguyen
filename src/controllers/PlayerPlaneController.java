package controllers;

import model.GameModel;
import model.PlayerPlaneModel;
import utils.Utils;
import views.GameView;
import views.PlayerPlaneView;

import java.awt.*;

/**
 * Created by HongUyen on 26-Feb-17.
 */
public class PlayerPlaneController extends GameController {

    public PlayerPlaneController(PlayerPlaneModel model, GameView view) {
        super(model, view);
    }


//    public PlayerPlaneController(int planeX, int planeY) {
//        this(new PlayerPlaneModel(planeX,planeY,35,30), new PlayerPlaneView(Utils.loadImageFromRes("plane3.png")) );
//    }

    //GETTER model



    //move plane
    public void run(int status){

        ((PlayerPlaneModel)model).run(status);
    }

}
