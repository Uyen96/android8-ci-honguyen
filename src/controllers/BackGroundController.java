package controllers;

import gui.GameWindow;
import model.BackGroundModel;
import utils.Utils;
import views.BackGroundView;

import java.awt.*;

import static gui.GameWindow.*;

/**
 * Created by HongUyen on 27-Feb-17.
 */
public class BackGroundController extends GameController {
     public BackGroundController(BackGroundModel model, BackGroundView view){
         super(model, view);
     }

    public BackGroundController() {
        this(new BackGroundModel(0, 0, GameWindow.SCREEN_WIDTH, GameWindow.SCREEN_HEIGHT),
                new BackGroundView(Utils.loadImageFromRes("background.png")));
    }

    public void run(){
        ((BackGroundModel)model).run();
    }

    public void draw(Graphics g){
        view.draw(g,model);
    }
}
