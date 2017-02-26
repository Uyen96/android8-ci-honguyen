import java.awt.*;

/**
 * Created by HongUyen on 21-Feb-17.
 */
public class PlayerBullet {
    public int x;
    public int y;
    public int speed;
    public Image image;
    public int bulletWidth;
    public int bulletHeight;
    public int isHit;
    public PlayerBullet(int playerPlaneX, int playerPlaneY, int playerPlaneWidth,
                        int speed, String Name, int bulletWidth, int bulletHeight) {
        x = playerPlaneX + playerPlaneWidth / 2 - bulletWidth / 2;
        y = playerPlaneY - bulletHeight;
        this.speed = speed;
        image = GameWindow.loadImageFromRes(Name);
        this.bulletWidth = bulletWidth;
        this.bulletHeight = bulletHeight;
    }

    public void moveUp() {
        y -= speed;
    }
}
