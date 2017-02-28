package views;

import model.BackGroundModel;

import java.awt.*;

/**
 * Created by HongUyen on 27-Feb-17.
 */
public class BackGroundView {
    private Image image;

    public BackGroundView(Image image) {
        this.image = image;
    }

    public void draw(Graphics g, BackGroundModel model){
        g.drawImage(image, model.getX(), model.getY(), model.getWidth(), model.getHeigh(), null);
    }


}
