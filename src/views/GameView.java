package views;

import model.GameModel;

import java.awt.*;

/**
 * Created by HongUyen on 03-Mar-17.
 */
public class GameView {
    private Image image;

    public GameView(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void draw(Graphics graphics, GameModel model){
        graphics.drawImage(image,
                model.getX(),
                model.getY(),
                model.getWidth(),
                model.getHeight(),
                null);
    }
}
