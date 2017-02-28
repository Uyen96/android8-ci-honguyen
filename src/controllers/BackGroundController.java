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
public class BackGroundController {
    private BackGroundModel model;
    private BackGroundView view;

    public BackGroundController(BackGroundModel model, BackGroundView view) {
        this.model = model;
        this.view = view;
    }

    public BackGroundController(int x, int y, int w, int h){
        this ( new BackGroundModel(),
                new BackGroundView(Utils.loadImageFromRes("background.png")));
    }

    public BackGroundModel getModel() {
        return model;
    }

    public BackGroundView getView() {
        return view;
    }

    public void run(){
        model.run();
    }
    public void draw(Graphics g){
        view.draw(g, model);
    }
}
