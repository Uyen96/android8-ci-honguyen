package views;

import model.PlayerPlaneModel;

import java.awt.*;

/**
 * Created by HongUyen on 26-Feb-17.
 */
public class PlayerPlaneView {
    private Image image;

    public PlayerPlaneView(Image image) {
        this.image = image;
    }

    public void draw(Graphics graphics, PlayerPlaneModel model){
        graphics.drawImage(image, model.getX(), model.getY(), model.getWidth(), model.getHeight(), null);
    }
}
