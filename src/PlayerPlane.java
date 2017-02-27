import java.awt.*;

/**
 * Created by HongUyen on 25-Feb-17.
 */
public class PlayerPlane {
    public static final int SPEED = 10;
    private int x;
    private int y;
    private Image image;
    private int planeWidth;
    private int planeHeight;


    public PlayerPlane(int x, int y, Image image, int planeWidth, int planeHeight) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.planeWidth = planeWidth;
        this.planeHeight = planeHeight;
    }

    //lay ra
    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public int getPlaneWidth() {
        return planeWidth;
    }

    public int getPlaneHeight() {
        return planeHeight;
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setPlaneWidth(int planeWidth) {
        this.planeWidth = planeWidth;
    }

    public void setPlaneHeight(int planeHeight) {
        this.planeHeight = planeHeight;
    }

    public void moveUp()
    {
        if(y >= 30+SPEED)
            y -= SPEED;
    }
    public void moveDown()
    {
        if(y <= GameWindow.HEIGHT-planeHeight - SPEED)
            y +=SPEED;
    }
    public void moveLeft()
    {
        if(x >= 0+SPEED)
            x -= SPEED;
    }
    public void moveRight()
    {
        if(x<=GameWindow.WIDTH-planeWidth-SPEED)
            x+=SPEED;
    }

//    public void draw (Graphics g){
//
//    }
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
