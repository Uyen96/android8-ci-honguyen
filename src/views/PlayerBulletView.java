package views;

import model.PlayerBulletModel;

import java.awt.*;

/**
 * Created by HongUyen on 26-Feb-17.
 */
public class PlayerBulletView {
    private Image image;

    public PlayerBulletView(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void draw(Graphics graphics, PlayerBulletModel model){
        graphics.drawImage(image, model.getX(), model.getY(), model.getWidth(), model.getHeight(), null );
    }
}
