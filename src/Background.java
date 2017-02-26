import java.awt.*;

/**
 * Created by HongUyen on 25-Feb-17.
 */
public class Background {
    public Image image;
    public int x;
    public int y;
    public int speed;
    public int width;
    public int height;
    public Background(String name, int x, int y, int speed,int width,int height) {
        image= GameWindow.loadImageFromRes(name);
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width=width;
        this.height=height;
    }
    public void moveDown()
    {
        y+=speed;
        if(y>GameWindow.HEIGHT)
            y=-GameWindow.HEIGHT;
    }

}
