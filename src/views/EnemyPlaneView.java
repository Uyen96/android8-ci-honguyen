package views;

import model.EnemyPlaneModel;

import java.awt.*;

/**
 * Created by HongUyen on 27-Feb-17.
 */
public class EnemyPlaneView {
    private Image image;

    public EnemyPlaneView(Image image) {
        this.image = image;
    }

    public void draw(Graphics g, EnemyPlaneModel model){
        g.drawImage(image, model.getEnemyX(), model.getEnemyX(), model.getWidth(), model.getHeight(), null);

    }
}
