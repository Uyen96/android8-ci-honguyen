package controllers;

import model.GameModel;
import model.IsLandModel;
import utils.Utils;
import views.GameView;
import views.IsLandView;

import java.awt.*;

/**
 * Created by HongUyen on 02-Mar-17.
 */
public class IsLandController extends GameController {


    public IsLandController(IsLandModel model, GameView view) {
        super(model, view);
    }



    public void run(){
        ((IsLandModel)model).run();
    }

    public IsLandController(int x, int y){
        this(new IsLandModel(x, y, IsLandModel.WIDTH, IsLandModel.HEIGHT),
                new IsLandView(Utils.loadImageFromRes("island.png")));

    }
}
