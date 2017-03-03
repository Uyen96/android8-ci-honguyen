package controllers;

import model.IsLandModel;
import views.IsLandView;

import java.awt.*;

/**
 * Created by HongUyen on 02-Mar-17.
 */
public class IsLandController {
    private IsLandModel model;
    private IsLandView view;

    public IsLandController(IsLandModel model, IsLandView view) {
        this.model = model;
        this.view = view;
    }

//    public IsLandController(int x, int y) {
//        this(new IsLandModel(x,y,50,50), new IsLandView());
//    }

    //GETTER model
    public IsLandModel getModel() {
        return model;
    }

    public void setDefaultLocation(){
        model.setDefaultLocation();
    }

    public void run(){
        model.run();
    }

    public void draw(Graphics g){
        view.draw(g,model);
    }
}
