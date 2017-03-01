package views;

import model.BackGroundModel;

import java.awt.*;

/**
 * Created by HongUyen on 27-Feb-17.
 */
public class BackGroundView {
    private Image image;

    public BackGroundView(Image img) {
        this.image = img;
    }

    public void draw(Graphics g, BackGroundModel model){
        g.drawImage(image,model.getX1(),model.getY1(),model.getWidth(),model.getHeight(), null );
        g.drawImage(image,model.getX2(),model.getY2(),model.getWidth(),model.getHeight(), null);
    }

}
