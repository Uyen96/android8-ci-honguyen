import java.awt.*;

/**
 * Created by HongUyen on 25-Feb-17.
 */
public class EnemyBullet {
    public Image image;
    public int x;
    public int y;
    public int speed;

    public EnemyBullet(String Name, int speed,Image enemyImage,int enemyX, int enemyY) {
        this.image = GameWindow.loadImageFromRes(Name);
        x=enemyX + enemyImage.getWidth(null)/2 - image.getWidth(null)/2;
        y=enemyY + enemyImage.getHeight(null);
        this.speed = speed;
    }
    public void moveDown()
    {
        y+=speed;
    }
}
