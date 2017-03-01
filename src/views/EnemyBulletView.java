package views;

import model.EnemyBulletModel;
import model.EnemyPlaneModel;

import java.awt.*;

/**
 * Created by HongUyen on 27-Feb-17.
 */
public class EnemyBulletView {

    private Image image;

    public EnemyBulletView(Image image) {
        this.image = image;
    }

    public void draw(Graphics g, EnemyBulletModel model){
        g.drawImage(image, model.getBulletX(), model.getBulletY(), model.getWidth(), model.getHeight(), null );
    }
}
