package controllers;

import model.PlayerPlaneModel;
import utils.Utils;
import views.GameView;
import views.PlayerPlaneView;
import java.util.Vector;

/**
 * Created by HongUyen on 26-Feb-17.
 */
public class PlayerPlaneController extends GameController {
    Vector<PlayerBulletController> playerBulletControllers;

    public PlayerPlaneController(PlayerPlaneModel model, GameView view,
                                 Vector<PlayerBulletController> playerBulletControllers) {
        super(model, view);
        this.playerBulletControllers = playerBulletControllers;
    }

    public PlayerPlaneController(int x, int y,
                                 Vector<PlayerBulletController> playerBulletController) {
        this(new PlayerPlaneModel(x,y,PlayerPlaneModel.DEFAULT_WIDTH, PlayerPlaneModel.DEFAULT_HEIGHT),
                new PlayerPlaneView(Utils.loadImageFromRes("plane3.png")),
                playerBulletController);
    }



    public void run(){

    }

    public void shoot(){

                    PlayerBulletController playerBulletController = new PlayerBulletController(
                            (int)model.getMidX() - PlayerBulletController.DEFAULT_HAFT_WIDTH,
                            model. getY() - PlayerBulletController.DEFAULT_HEIGHT);

                    playerBulletControllers.add(playerBulletController);
                    playerBulletController.run();
    }

    public void flyUp(){
            ((PlayerPlaneModel)model).flyUp();
    }


    public void flyDown() {
            ((PlayerPlaneModel)model).flyDown();
    }

    public void flyLeft() {
            ((PlayerPlaneModel)model).flyLeft();
    }

    public void flyRight() {
            ((PlayerPlaneModel)model).flyRight();
    }


}
