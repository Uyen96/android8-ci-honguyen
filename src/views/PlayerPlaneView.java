package views;

import model.PlayerPlaneModel;

import java.awt.*;

/**
 * Created by HongUyen on 26-Feb-17.
 */
public class PlayerPlaneView {
    private Image img;

    public PlayerPlaneView(Image img) {
        this.img = img;
    }

    public void draw(Graphics g, PlayerPlaneModel model){
        g.drawImage(img,model.getPlaneX(), model.getPlaneY(),model.getWidth(),model.getHeight(), null);
    }
}
