import java.awt.*;

/**
 * Created by HongUyen on 25-Feb-17.
 */
public class PlayerPlane {
    public int x;
    public int y;
    public int speed;
    public Image image;
    public int planeWidth;
    public int planeHeight;

    public PlayerPlane(int x, int y,String Name, int speed) {
        image=GameWindow.loadImageFromRes(Name);
        planeWidth = image.getWidth(null);
        planeHeight = image.getHeight(null);
        this.x=x;
        this.y=y;
        this.speed=speed;
    }

    public void moveUp()
    {
        if(y>=30+speed)
            y-=speed;
    }
    public void moveDown()
    {
        if(y<=GameWindow.HEIGHT-planeHeight-speed)
            y+=speed;
    }
    public void moveLeft()
    {
        if(x>=0+speed)
            x-=speed;
    }
    public void moveRight()
    {
        if(x<=GameWindow.WIDTH-planeWidth-speed)
            x+=speed;
    }
    public void getHitByBullet(EnemyBullet enemyBullet) {
        int bulletLeftBottomX = enemyBullet.x;
        int bulletLeftBottomY = enemyBullet.y + enemyBullet.image.getHeight(null);
        int bulletRightBottomX = enemyBullet.x + enemyBullet.image.getWidth(null);
        int bulletRightBottomY = bulletLeftBottomY;
        int playerBottomRightX = x + image.getWidth(null);
        int playerBottomRightY = y + image.getHeight(null);

        if ((bulletRightBottomX > x && bulletRightBottomX < playerBottomRightX &&
                bulletRightBottomY > y && bulletRightBottomY < playerBottomRightY)) {
            image = GameWindow.loadImageFromRes("explosion1.png");
        } else if ((bulletLeftBottomX > x && bulletLeftBottomX < playerBottomRightX &&
                bulletLeftBottomY > y && bulletLeftBottomY < playerBottomRightY)) {
            image = GameWindow.loadImageFromRes("explosion1.png");
        }
    }

}