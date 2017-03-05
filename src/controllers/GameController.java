package controllers;

import model.GameModel;
import views.GameView;

import java.awt.*;
import java.util.BitSet;

/**
 * Created by HongUyen on 03-Mar-17.
 */
public class GameController {
    protected GameModel model;
    protected GameView view;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    public GameModel getModel() {
        return model;
    }

    public GameView getView() {
        return view;
    }

    public void run(){

    }

    public void draw(Graphics g){
        view.draw(g, model);
    }


}
