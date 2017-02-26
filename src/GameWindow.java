import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

import static java.awt.event.KeyEvent.VK_LEFT;

/**
 * Created by HongUyen on 21-Feb-17.
 */
public class GameWindow extends Frame {
    public static final int WIDTH = 400;
    public static final int HEIGHT= 600;
    public static final int BACKGROUNDSPEED = 1;
    public static final int PLAYERPLANESPEED = 10;
    public static final int ENEMYPLANESPEED = 2;
    public static final int PLAYERBULLETSPEED = 10;
    public static final int ENEMYBULLETSPEED = 10;
    Background backgroundImage;
    Background backgroundImage2;
    PlayerPlane playerPlane;
    EnemyPlane enemyPlaneDown;
    EnemyPlane enemyPlaneCross1;
    EnemyPlane enemyForExplosion;
    EnemyBullet enemyBullet;
    ArrayList<EnemyBullet> enemyBulletList = new ArrayList<EnemyBullet>();
    private BufferedImage backBufferedImage;
    Thread thread;
    Thread thread1;
    private Graphics backGraphics;
    ArrayList<PlayerBullet> playerBulletList = new ArrayList<PlayerBullet>();

    public GameWindow(){

        setVisible(true);
        setSize(WIDTH, HEIGHT);

        playerPlane = new PlayerPlane(WIDTH / 2 - 35, HEIGHT - 50, "plane3.png", PLAYERPLANESPEED);
        enemyPlaneDown = new EnemyPlane(WIDTH / 2 - 32 / 2, 0,
                "enemy_plane_white_3.png", ENEMYPLANESPEED);

        enemyPlaneCross1 = new EnemyPlane(0, 0, "enemy-green-1.png", ENEMYPLANESPEED);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                super.windowClosing(windowEvent);
                System.out.println("Closing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {
                super.windowClosed(windowEvent);
                System.out.println("Closed");
                System.exit(0);
            }
        });

        // load image
        backgroundImage = new Background("background.png", 0, 0,
                BACKGROUNDSPEED, WIDTH, HEIGHT);
        backgroundImage2 = new Background("background.png", 0, -HEIGHT,
                BACKGROUNDSPEED, WIDTH, HEIGHT);
//        repaint();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                switch (e.getKeyCode()){
                        case KeyEvent.VK_SPACE:
                            PlayerBullet playerBullet = new PlayerBullet(playerPlane.x, playerPlane.y,
                                    playerPlane.planeWidth, PLAYERBULLETSPEED, "bullet.png", 13, 32);
                            playerBulletList.add(playerBullet);
                            break;
                        case KeyEvent.VK_RIGHT:
                            playerPlane.moveRight();
                            break;
                        case KeyEvent.VK_LEFT:
                            playerPlane.moveLeft();
                            break;
                        case KeyEvent.VK_UP:
                            playerPlane.moveUp();
                            break;
                        case KeyEvent.VK_DOWN:
                            playerPlane.moveDown();
                            break;
                    }

                }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });
        thread =  new Thread(new Runnable() {

            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(17);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    repaint();
                }
            }
        });

        thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    int randomX = ThreadLocalRandom.current().nextInt(50, GameWindow.WIDTH-50);
                    int randomY=    ThreadLocalRandom.current().nextInt(50, 200);
 //                   powerUp= new PowerUp("power-up.png",randomX,randomY,3);
                }
            }
        });
        backBufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        backGraphics = backBufferedImage.getGraphics();
    }



    public void start(){
        thread.start();
        thread1.start();
    }
    public static Image loadImageFromRes(String url){
        try {
             Image image = ImageIO.read(new File("resources/" + url));
             return image;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void update(Graphics g) {
        if (enemyPlaneDown.y > HEIGHT) {
            int randomX = ThreadLocalRandom.current().nextInt(50, WIDTH);
            enemyPlaneDown = new EnemyPlane(randomX, 0, "enemy_plane_white_3.png", ENEMYPLANESPEED);
        }
        if (enemyPlaneDown.y == 0) {
            enemyBullet = new EnemyBullet("enemy_bullet.png", ENEMYBULLETSPEED,
                    enemyPlaneDown.image, enemyPlaneDown.x, enemyPlaneDown.y);
            enemyBulletList.add(enemyBullet);
        }
        if (enemyPlaneCross1.x % 100 == 0) {
            enemyBullet = new EnemyBullet("enemy_bullet.png", ENEMYBULLETSPEED / 2,
                    enemyPlaneCross1.image, enemyPlaneCross1.x, enemyPlaneCross1.y);
            enemyBulletList.add(enemyBullet);
        }
        if (backBufferedImage != null) {
            backGraphics = backBufferedImage.getGraphics();
            backGraphics.drawImage(backgroundImage.image, backgroundImage.x, backgroundImage.y,
                    backgroundImage.width, backgroundImage.height, null);
            backGraphics.drawImage(backgroundImage2.image, backgroundImage2.x, backgroundImage2.y,
                    backgroundImage2.width, backgroundImage2.height, null);
            backGraphics.drawImage(playerPlane.image, playerPlane.x, playerPlane.y,
                    playerPlane.image.getWidth(null), playerPlane.image.getHeight(null), null);
            backGraphics.drawImage(enemyPlaneDown.image, enemyPlaneDown.x, enemyPlaneDown.y,
                    enemyPlaneDown.planeWidth, enemyPlaneDown.planeHeight, null);
            backGraphics.drawImage(enemyPlaneCross1.image, enemyPlaneCross1.x, enemyPlaneCross1.y,
                    enemyPlaneCross1.planeWidth, enemyPlaneCross1.planeHeight, null);
            for (EnemyBullet temp : enemyBulletList) {
                backGraphics.drawImage(temp.image, temp.x, temp.y, null);
                temp.moveDown();
            }

            Iterator<PlayerBullet> iter = playerBulletList.iterator();
            while (iter.hasNext()) {
                PlayerBullet temp = iter.next();
                if (enemyPlaneDown.getHitByPlayerBullet(temp)) {
                    iter.remove();
                    int randomX = ThreadLocalRandom.current().nextInt(50, GameWindow.WIDTH);
                    enemyForExplosion=enemyPlaneDown;
                    enemyPlaneDown = new EnemyPlane(randomX, 0,
                            "enemy_plane_white_3.png", ENEMYPLANESPEED);
                } else if (enemyPlaneCross1.getHitByPlayerBullet(temp)) {
                    iter.remove();
                    enemyForExplosion=enemyPlaneCross1;
                    enemyPlaneCross1 = new EnemyPlane(0, 0, "enemy-green-1.png", ENEMYPLANESPEED);
                } else {
                    backGraphics.drawImage(temp.image, temp.x, temp.y, temp.bulletWidth, temp.bulletHeight, null);
                    temp.moveUp();
                }

            }
            if(enemyForExplosion!=null)
            {
                enemyForExplosion.enemyBlowUp();
                backGraphics.drawImage(enemyForExplosion.image,enemyForExplosion.x,enemyForExplosion.y,null);
                if(enemyForExplosion.stateOfExplosion>6)
                    enemyForExplosion=null;
            }
        }

            enemyPlaneDown.moveDown();
            enemyPlaneCross1.moveCrossToRight();
            backgroundImage.moveDown();
            backgroundImage2.moveDown();
            g.drawImage(backBufferedImage, 0, 0, null);
        }


    public static Image loadImageFromFile(String url) {
        Image image = null;
        try {
            image = ImageIO.read(new File("resources/" + url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
    }
